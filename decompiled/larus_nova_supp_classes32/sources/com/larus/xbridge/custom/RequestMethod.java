package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "request")
public final class RequestMethod extends com.bytedance.sdk.xbridge.cn.network.a {
    public static final /* synthetic */ int e = 0;

    @XBridgeMethodName(name = "request", params = {"addCommonParams", LynxEventReporter.PROP_NAME_URL, "method", "body", "bodyType", LynxResourceModule.PARAMS_KEY, "header", "useUIThread", "usePrefetch"}, results = {"httpCode", "clientCode", "header", "response", "responseType", "rawResponse", "prefetchStatus"})
    public final String d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/xbridge/custom/RequestMethod$RequestMethodType;", NameKeys.UnloadStrategy_No_Strategy, "method", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RequestMethodType extends Enum<RequestMethodType> {
        public static final a Companion = null;
        public static final RequestMethodType DELETE = null;
        public static final RequestMethodType GET = null;
        public static final RequestMethodType POST = null;
        public static final RequestMethodType PUT = null;
        public static final RequestMethodType UNSUPPORTED = null;
        public static final /* synthetic */ RequestMethodType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String method;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RequestMethodType> getEntries() {
            return b;
        }

        static {
            RequestMethodType r0 = new RequestMethodType("GET", 0, "get");
            GET = r0;
            RequestMethodType r1 = new RequestMethodType("POST", 1, "post");
            POST = r1;
            RequestMethodType r3 = new RequestMethodType("PUT", 2, "put");
            PUT = r3;
            RequestMethodType r5 = new RequestMethodType("DELETE", 3, "delete");
            DELETE = r5;
            RequestMethodType r7 = new RequestMethodType("UNSUPPORTED", 4, "unsupported");
            UNSUPPORTED = r7;
            RequestMethodType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) a.clone();
        }

        public final String getMethod() {
            return this.method;
        }

        public static RequestMethodType valueOf(String r1) {
            return (RequestMethodType) r27.a.a(RequestMethodType.class, r1);
        }

        public RequestMethodType(String r1, int r2, String r3) {
            super(r1, r2);
            this.method = r3;
        }
    }

    public static final class a {
    }

    public interface b {
        String a();
    }

    public final boolean canRunInBackground() {
        return true;
    }

    static {
    }

    public RequestMethod() {
        this.d = "request";
    }

    public final String getName() {
        return this.d;
    }

    public static final void a(RequestMethod r0) {
        r0.getClass();
        id7.c.d.getClass();
    }

    public final void handle(final IBDXBridgeContext r24, XBaseParamModel r25, final CompletionBlock r26) {
        final com.bytedance.sdk.xbridge.cn.network.a.b r9 = (com.bytedance.sdk.xbridge.cn.network.a.b) r25;
        Intrinsics.checkNotNullParameter(r24, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r26, "callback");
        final long r7 = System.currentTimeMillis();
        Boolean r1 = r9.getUsePrefetch();
        Activity r3 = r24.getOwnerActivity();
        if (r3 == null) goto L5;
        Context r4 = r3.getApplicationContext();
    L6:
        final m16.b r11 = (m16.b) r24.getService(m16.b.class);
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r5) == false) goto L20;
        if (r4 == null) goto L20;
        if ((r9.getBody() instanceof Map) == false) goto L12;
        Object r6 = r9.getBody();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        JSONObject r8 = new JSONObject((Map) r6);
    L13:
        String r14 = r9.getUrl();
        String r15 = r9.getMethod();
        Map r16 = com.bytedance.ies.bullet.prefetchv2.u.a(r9.getHeader());
        Map r17 = com.bytedance.ies.bullet.prefetchv2.u.a(r9.getParams());
        boolean r19 = r9.getAddCommonParams();
        Intrinsics.checkNotNullParameter(r14, LynxEventReporter.PROP_NAME_URL);
        Intrinsics.checkNotNullParameter(r15, "method");
        com.bytedance.ies.bullet.prefetchv2.p r10 = new com.bytedance.ies.bullet.prefetchv2.p(r14, r15, r16, r17, r8, r19, false, false, 1536);
        com.bytedance.ies.bullet.prefetchv2.a0 r12 = com.bytedance.ies.bullet.prefetchv2.a0.a;
        com.bytedance.ies.bullet.prefetchv2.v r13 = com.bytedance.ies.bullet.prefetchv2.a0.a(r10);
        if (r13 == null) goto L16;
        CompletionBlock.DefaultImpls.onSuccess$default(r26, h2.a(r13, 2), null, 2, null);
        c(r11, r9.getUrl(), true, 2, "hit cache", System.currentTimeMillis() - r7, r13.h);
        return;
    L16:
        com.bytedance.ies.bullet.prefetchv2.z r18 = com.bytedance.ies.bullet.prefetchv2.a0.c(r10);
        if (r18 == null) goto L20;
        r18.d(new b2(r26, this, r11, r9, r7));
        return;
    L12:
        r8 = new JSONObject();
    L20:
        if (Intrinsics.areEqual(r1, r5) == false) goto L22;
        int r2 = com.bytedance.ies.bullet.prefetchv2.j.a;
        com.bytedance.ies.bullet.prefetchv2.j.b("未命中prefetch，请检查bridge请求参数跟配置是否匹配: " + r9.getUrl());
        com.larus.utils.t0.a(new y1(r11, this, r9, r7));
    L22:
        RequestMethodType.a r20 = RequestMethodType.Companion;
        String r21 = r9.getMethod();
        r20.getClass();
        if (r21 != null) goto L42;
        RequestMethodType r22 = RequestMethodType.UNSUPPORTED;
    L28:
        final RequestMethodType r23 = r22;
        final PlatformType r27 = r24.getPlatformType();
        if (r23 != RequestMethodType.UNSUPPORTED) goto L31;
        b(r24, r9.getMethod(), r9.getUrl(), 0, -3, "Illegal method " + r9.getMethod(), r27.name());
        CompletionBlock.DefaultImpls.onFailure$default(r26, -3, "Illegal method " + r9.getMethod(), null, 4, null);
        return;
    L31:
        final Map r28 = r9.getHeader();
        final Object r29 = r9.getBody();
        final String r30 = r9.getBodyType();
        final Map r31 = r9.getParams();
        if (TextUtils.isEmpty(r9.getUrl()) == false) goto L34;
        b(r24, r9.getMethod(), r9.getUrl(), 0, -3, "Illegal empty url", r27.name());
        CompletionBlock.DefaultImpls.onFailure$default(r26, -3, "url is empty", null, 4, null);
        return;
    L34:
        final long r110 = System.currentTimeMillis();
        int r32 = com.bytedance.sdk.xbridge.cn.utils.g.a;
        Intrinsics.checkNotNullParameter(r24, "bridgeContext");
        XBaseRuntime.a.getClass();
        qe7.d r0 = XBaseRuntime.o;
        if (r0 != null) goto L37;
        r0 = new qe7.d();
    L37:
        ExecutorService r33 = r0.getNormalThreadExecutor();
        if (r33 != null) goto L40;
        r33 = TTExecutors.getNormalExecutor();
    L40:
        r33.execute(new z1(r28, r24, r9, r31, r27, r23, r29, r30, this, r110, r26));
        return;
    L42:
        r22 = RequestMethodType.valueOf(r21.toUpperCase(Locale.ROOT));     // Catch: Exception -> L26
    L26:
        r22 = RequestMethodType.UNSUPPORTED;
        goto L28
    L5:
        r4 = null;
        goto L6
    }

    public final void b(final IBDXBridgeContext r11, final String r12, final String r13, final Integer r14, final int r15, final String r16, final String r17) {
        int r0 = com.bytedance.sdk.xbridge.cn.utils.g.a;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        XBaseRuntime.a.getClass();
        qe7.d r1 = XBaseRuntime.o;
        if (r1 != null) goto L5;
        r1 = new qe7.d();
    L5:
        ExecutorService r2 = r1.getNormalThreadExecutor();
        if (r2 != null) goto L8;
        r2 = TTExecutors.getNormalExecutor();
    L8:
        r2.execute(new a2(r12, r13, r14, r15, r16, r17, r11));
    }

    public final void c(m16.b r13, String r14, boolean r15, int r16, String r17, long r18, String r20) {
        int r1 = com.bytedance.ies.bullet.prefetchv2.o.a;
        if (r13 == null) goto L10;
        h16.e r2 = (h16.e) r13.c(h16.e.class);
        if (r2 == null) goto L10;
        BulletContext r3 = r2.getBulletContext();
        if (r3 == null) goto L10;
        String r4 = r3.f;
        if (r4 == null) goto L10;
    L11:
        String r5 = r4;
        if (r13 == null) goto L18;
        h16.e r0 = (h16.e) r13.c(h16.e.class);
        if (r0 == null) goto L18;
        BulletContext r6 = r0.getBulletContext();
        if (r6 == null) goto L18;
        a36.a r7 = r6.q;
    L19:
        com.bytedance.ies.bullet.prefetchv2.o.a(new com.bytedance.ies.bullet.prefetchv2.n(r5, r7, r14, r15, r16, r17, r18, r20));
        return;
    L18:
        r7 = null;
    L10:
        r4 = "default_bid";
        goto L11
    }
}
