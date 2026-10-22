package a8;

import android.net.Uri;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static String a;
    public static final a b = null;

    public static final class a implements Interceptor {
        public a() {
        }

        public final SsResponse<?> intercept(Interceptor.Chain r24) {
            Intrinsics.checkNotNull(r24);
            Request r0 = r24.request();
            String r1 = b.a;
            List r10 = r0.headers("x-tt-env");
            if (r10 == null) goto L12;
            Header r11 = (Header) CollectionsKt.getOrNull(r10, 0);
            if (r11 == null) goto L12;
            String r12 = r11.getValue();
            if (r12 == null) goto L12;
            if (StringsKt.isBlank(r12) == false) goto L11;
            r12 = b.a;
        L11:
            if (r12 == null) goto L12;
        L13:
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            b.a = r12;
            GeckoXAdapter.Companion r13 = GeckoXAdapter.Companion;
            String r14 = null;
            if (r13.isCDNMultiVersionResource(r0.getUrl()) == false) goto L54;
            Request.Builder r15 = r0.newBuilder();
            Uri r16 = UriProtector.parse(r0.getUrl());
            String r17 = r16.getHost();
            if (r17 == null) goto L54;
            Uri.Builder r18 = r16.buildUpon();
            if (b.a.length() <= 0) goto L21;
            boolean r19 = true;
        L23:
            if (r19 == true) goto L25;
        L41:
            String r110 = r17;
            boolean r111 = false;
        L42:
            Iterator r20 = r13.getCDNMultiVersionCommonParams().entrySet().iterator();
        L44:
            if (r20.hasNext() == false) goto L48;
            Map.Entry r21 = (Map.Entry) r20.next();
            if (UriProtector.getQueryParameter(r16, (String) r21.getKey()) != null) goto L44;
            r18.appendQueryParameter((String) r21.getKey(), (String) r21.getValue());
            goto L44
        L48:
            String r22 = StringsKt.replace$default(r18.toString(), r17, r110, false, 4, null);
            if (r111 == true) goto L51;
        L53:
            r15.url(r22);
            r0 = r15.build();
            goto L54
        L51:
            if (StringsKt.startsWith$default(r22, "https", false, 2, null) == false) goto L53;
            r22 = StringsKt.replaceFirst$default(r22, "https", "http", false, 4, null);
            goto L53
        L25:
            if (UriProtector.getQueryParameter(r16, "x-tt-env") != null) goto L28;
            r18.appendQueryParameter("x-tt-env", b.a);
        L28:
            if (StringsKt.startsWith$default(b.a, "ppe_", false, 2, null) == false) goto L33;
            if (UriProtector.getQueryParameter(r16, "x-use-ppe") != null) goto L33;
            r18.appendQueryParameter("x-use-ppe", "1");
        L33:
            if (StringsKt.startsWith$default(b.a, "boe_", false, 2, null) == false) goto L41;
            if (UriProtector.getQueryParameter(r16, "x-use-boe") != null) goto L41;
            r18.appendQueryParameter("x-use-boe", "1");
            if (StringsKt.contains$default(r17, "boe", false, 2, null) == true) goto L39;
            String r23 = r17.concat(".boe-gateway.byted.org");
        L40:
            r110 = r23;
            r111 = true;
            goto L42
        L39:
            r23 = r17;
            goto L40
        L21:
            r19 = false;
        L54:
            SsResponse<?> r25 = r24.proceed(r0);
            Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L74
            if (r25 == null) goto L72;
            Response r27 = r25.raw();     // Catch: Throwable -> L74
            if (r27 == null) goto L72;
            Header r28 = r27.getFirstHeader("x-tt-env");     // Catch: Throwable -> L74
            if (r28 == null) goto L72;
            String r29 = r28.getValue();     // Catch: Throwable -> L74
            if (r29 == null) goto L72;
            if ((!StringsKt.isBlank(r29)) == false) goto L71;
            Header r30 = r27.getFirstHeader("x-response-cache");     // Catch: Throwable -> L74
            if (r30 == null) goto L69;
            r14 = r30.getValue();     // Catch: Throwable -> L74
        L69:
            if (Intrinsics.areEqual(r14, "hit") == true) goto L71;
            String r31 = b.a;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r29, "<set-?>");     // Catch: Throwable -> L74
            b.a = r29;     // Catch: Throwable -> L74
        L71:
            r14 = Unit.INSTANCE;     // Catch: Throwable -> L74
        L72:
            Result.constructor-impl(r14);     // Catch: Throwable -> L74
        L76:
            return r25;
        L74:
            th = move-exception;
            Result.Companion r32 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L12:
            r12 = b.a;
            goto L13
        }
    }

    static {
        a = "";
        b = new a();
    }
}
