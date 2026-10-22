package com.ss.android.lark.chameleonv2.lkapi.net;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.lkapi.net.a$a, reason: collision with other inner class name */
    public static final class C0024a {
    }

    public final class b extends AbsChameleonHandler<INet$Internal$HttpRequest> {
        public final String a;

        /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.lkapi.net.a$b$a, reason: collision with other inner class name */
        public /* synthetic */ class C0025a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[INet$Internal$Credentials.values().length];
                r0[INet$Internal$Credentials.Omit.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[INet$Internal$Credentials.Include.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L6:
                a = r0;
                int[] r1 = new int[INet$Internal$HttpMethod.values().length];
                r1[INet$Internal$HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L21:
                r1[INet$Internal$HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L9:
                b = r1;
            }
        }

        public b() {
            this.a = LKAPIModules.Internal.Net.Fetch.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(INet$Internal$HttpRequest r21, final Callback r22) {
            INet$Internal$HttpRequest r1 = r21;
            Intrinsics.checkNotNullParameter(r1, "req");
            Intrinsics.checkNotNullParameter(r22, "callback");
            if (r1.getUrl().length() != 0) goto L5;
            boolean r4 = true;
        L7:
            if (r4 == false) goto L9;
            j.e("LK_API_TAG_Net", "url empty");
            r22.error(new LKAPIError(-1, "fetch url is empty"));
            return;
        L9:
            INet$Internal$Credentials r5 = r1.getCredentials();
            int r6 = C0025a.a[r5.ordinal()];
            l r8 = null;
            if (r6 == 1) goto L42;
            if (r6 != 2) goto L41;
            Intrinsics.checkNotNullParameter(r1, "req");
            Intrinsics.checkNotNullParameter(r22, "callback");
            j.e("LK_API_TAG_Net", "userSendHttp");
            UserSendHttpRequest.Builder r12 = new UserSendHttpRequest.Builder();
            r12.url(r1.getUrl());
            INet$Internal$HttpMethod r2 = r1.getMethod();
            int r3 = C0025a.b[r2.ordinal()];
            if (r3 == 1) goto L18;
            if (r3 != 2) goto L17;
            HttpMethod r7 = HttpMethod.POST;
        L19:
            r12.method(r7);
            String r9 = r1.getBodyString();
            if (r9 == null) goto L23;
            ByteString.Companion.getClass();
            r12.body(ByteString.a.b(r9));
        L23:
            if (r1.getBody() == null) goto L25;
            ByteString.a r10 = ByteString.Companion;
            String r11 = String.valueOf(r1.getBody());
            r10.getClass();
            r12.body(ByteString.a.b(r11));
        L25:
            HttpHeaderMap.Builder r13 = new HttpHeaderMap.Builder();
            Map<String, String> r14 = r1.getHeaders();
            if (r14 == null) goto L32;
            ArrayList r15 = new ArrayList(r14.size());
            Iterator<Map.Entry<String, String>> r16 = r14.entrySet().iterator();
        L29:
            if (r16.hasNext() == false) goto L31;
            Map.Entry<String, String> r17 = r16.next();
            String r18 = r17.getKey();
            String r19 = r17.getValue();
            r15.add(new HttpHeader.Builder().name(r18).value(r19).build());
            goto L29
        L31:
            r13.headers(r15);
        L32:
            r12.headers(r13.build());
            Application r20 = LarkContext.getApplication();
            if (r20 == null) goto L37;
            q1b.a r23 = (q1b.a) k.a(r20, q1b.a.class);
            if (r23 == null) goto L37;
            r8 = r23.g();
        L37:
            if (r8 != null) goto L39;
            r22.error(new LKAPIError(-1, "rust client is null"));
            return;
        L39:
            Command r110 = Command.USER_SEND_HTTP;
            t.a(r8.h(new d(r12, UserSendHttpResponse.ADAPTER, r110, null, null, null, r1.getRequestTagUserTriggered(), 120)).a(), new Net$FetchHandler$userSendHttp$4(r22), new Net$FetchHandler$userSendHttp$5(r22), new Net$FetchHandler$userSendHttp$6(r22));
            return;
        L17:
            throw new NoWhenBranchMatchedException();
        L18:
            r7 = HttpMethod.GET;
            goto L19
        L41:
            throw new NoWhenBranchMatchedException();
        L42:
            Intrinsics.checkNotNullParameter(r1, "req");
            Intrinsics.checkNotNullParameter(r22, "callback");
            j.e("LK_API_TAG_Net", "sendHttp");
            SendHttpRequest.Builder r111 = new SendHttpRequest.Builder();
            r111.url(r1.getUrl());
            INet$Internal$HttpMethod r24 = r1.getMethod();
            int r25 = C0025a.b[r24.ordinal()];
            if (r25 == 1) goto L48;
            if (r25 != 2) goto L47;
            SendHttpRequest.Method r26 = SendHttpRequest.Method.POST;
        L49:
            r111.method(r26);
            String r27 = r1.getBodyString();
            if (r27 == null) goto L53;
            ByteString.Companion.getClass();
            r111.body(ByteString.a.b(r27));
        L53:
            if (r1.getBody() == null) goto L55;
            ByteString.a r28 = ByteString.Companion;
            String r29 = String.valueOf(r1.getBody());
            r28.getClass();
            r111.body(ByteString.a.b(r29));
        L55:
            Map<String, String> r30 = r1.getHeaders();
            if (r30 == null) goto L58;
            r111.headers(r30);
        L58:
            Application r31 = LarkContext.getApplication();
            if (r31 == null) goto L63;
            q1b.a r32 = (q1b.a) k.a(r31, q1b.a.class);
            if (r32 == null) goto L63;
            r8 = r32.g();
        L63:
            if (r8 != null) goto L65;
            r22.error(new LKAPIError(-1, "rust client is null"));
            return;
        L65:
            Command r112 = Command.SEND_HTTP;
            t.a(r8.h(new d(r111, SendHttpResponse.ADAPTER, r112, null, null, null, r1.getRequestTagUserTriggered(), 120)).a(), new Net$FetchHandler$sendHttp$4(r22), new Net$FetchHandler$sendHttp$5(r22), new Net$FetchHandler$sendHttp$6(r22));
            return;
        L47:
            throw new NoWhenBranchMatchedException();
        L48:
            r26 = SendHttpRequest.Method.GET;
            goto L49
        L5:
            r4 = false;
            goto L7
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
