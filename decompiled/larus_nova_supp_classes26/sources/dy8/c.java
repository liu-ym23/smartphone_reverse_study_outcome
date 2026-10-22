package dy8;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.canvas.depend.ICanvasNetworkApi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new b());
    }

    public final ey8.a a(String r15, Object r16, Map<String, String> r17, Map<String, String> r18, Map<String, Long> r19) {
        Intrinsics.checkNotNullParameter(r15, "relativeUrl");
        Intrinsics.checkNotNullParameter(r16, "body");
        if (r19 == null) goto L48;
        RequestContext r2 = new RequestContext();
        Long r3 = r19.get("connect_timeout");
        boolean r4 = false;
        if (r3 != null) goto L7;
    L15:
        Long r5 = r19.get("interval_timeout");
        if (r5 != null) goto L18;
    L26:
        Long r6 = r19.get("write_timeout");
        if (r6 != null) goto L29;
    L37:
        Long r0 = r19.get("protect_timeout");
        if (r0 != null) goto L40;
    L47:
        RequestContext r7 = r2;
    L49:
        ICanvasNetworkApi r8 = (ICanvasNetworkApi) b.getValue();
        if (r17 != null) goto L52;
        Map<String, String> r9 = MapsKt.emptyMap();
    L53:
        Call<TypedInput> r1 = r8.streamPull(r15, r9, r16, r18, r7);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L67
        SsResponse r11 = r1.execute();     // Catch: Throwable -> L67
        TypedInput r12 = (TypedInput) r11.body();     // Catch: Throwable -> L67
        Intrinsics.checkNotNullParameter(r12, "value");     // Catch: Throwable -> L67
        String r13 = "UTF-8";
        if (r12.mimeType() == null) goto L57;
        r13 = MimeUtil.parseCharset(r12.mimeType(), "UTF-8");     // Catch: Throwable -> L67
    L57:
        BufferedReader r14 = new BufferedReader(new InputStreamReader(r12.in(), r13));     // Catch: Throwable -> L67
        List r20 = r11.headers();     // Catch: Throwable -> L67
        LinkedHashMap r21 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r20, 10)), 16));     // Catch: Throwable -> L67
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L67
    L59:
        if (r22.hasNext() == false) goto L61;
        Object r23 = r22.next();     // Catch: Throwable -> L67
        r21.put(((Header) r23).getName(), ((Header) r23).getValue());     // Catch: Throwable -> L67
        goto L59
    L61:
        int r24 = r11.code();     // Catch: Throwable -> L67
        Request r25 = r1.request();     // Catch: Throwable -> L67
        if (r25 == null) goto L64;
        String r110 = r25.getUrl();     // Catch: Throwable -> L67
    L65:
        Object r26 = Result.constructor-impl(new ey8.a(r15, r24, r21, "", "", r14, null, r110, 64));     // Catch: Throwable -> L67
    L69:
        CronetIOException r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L91;
        String r28 = "";
        if ((r27 instanceof CronetIOException) == false) goto L78;
        int r29 = r27.getStatusCode();
        String r30 = r27.getMessage();
        if (r30 == null) goto L88;
    L82:
        int r31 = r29;
        String r32 = r30;
    L89:
        r26 = new ey8.a(r15, r31, null, null, r32, null, r27, null, 160);
    L88:
        r31 = r29;
        r32 = r28;
        goto L89
    L78:
        if ((r27 instanceof NetworkNotAvailabeException) == false) goto L83;
        r29 = ((NetworkNotAvailabeException) r27).getCronetInternalErrorCode();
        r30 = r27.getMessage();
        if (r30 != null) goto L82;
    L83:
        String r33 = r27.getMessage();
        if (r33 == null) goto L87;
        r28 = r33;
    L87:
        r29 = fm9.a.b(r27);
    L91:
        return (ey8.a) r26;
    L64:
        r110 = null;
    L67:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L52:
        r9 = r17;
        goto L53
    L40:
        if (r0.longValue() <= 0) goto L42;
        r4 = true;
    L42:
        if (r4 == true) goto L45;
        r0 = null;
    L45:
        if (r0 == null) goto L47;
        ((BaseRequestContext) r2).protect_timeout = r0.longValue();
        goto L47
    L29:
        if (r6.longValue() <= 0) goto L31;
        boolean r35 = true;
    L32:
        if (r35 == true) goto L35;
        r6 = null;
    L35:
        if (r6 == null) goto L37;
        ((BaseRequestContext) r2).timeout_write = r6.longValue();
        goto L37
    L31:
        r35 = false;
        goto L32
    L18:
        if (r5.longValue() <= 0) goto L20;
        boolean r36 = true;
    L21:
        if (r36 == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L26;
        ((BaseRequestContext) r2).timeout_read = r5.longValue();
        goto L26
    L20:
        r36 = false;
        goto L21
    L7:
        if (r3.longValue() <= 0) goto L9;
        boolean r37 = true;
    L10:
        if (r37 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        ((BaseRequestContext) r2).timeout_connect = r3.longValue();
        goto L15
    L9:
        r37 = false;
        goto L10
    L48:
        r7 = null;
        goto L49
    }
}
