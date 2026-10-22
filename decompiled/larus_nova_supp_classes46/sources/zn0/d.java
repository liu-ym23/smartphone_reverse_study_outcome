package zn0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Interceptor {
    public d() {
    }

    public final SsResponse<?> intercept(Interceptor.Chain r12) {
        Intrinsics.checkNotNullParameter(r12, "chain");
        Request r0 = r12.request();
        List r2 = r0.headers("x-nx-chunk");
        if (r2 == null) goto L13;
        Iterator r3 = r2.iterator();
        if (r3 == null) goto L13;
    L7:
        if (r3.hasNext() == false) goto L13;
        Header r4 = (Header) r3.next();
        String r5 = r4.getValue();
        if (jc1.a.c() == false) goto L7;
        if ((!Intrinsics.areEqual(r5, "1.0")) == false) goto L7;
        r0.getUrl();
        r0.getHeaders().remove(r4);
    L13:
        SsResponse<?> r13 = r12.proceed(r0);
        Object r1 = r13.body();
        if ((r1 instanceof f) == false) goto L40;
        f r6 = (f) r1;
        Map r7 = ((com.bytedance.frameworks.baselib.netx.chunk.d) r6).b;
        Header r8 = r13.raw().getFirstHeader("x-tt-logid");
        String r9 = "";
        if (r8 == null) goto L19;
        String r10 = r8.getValue();
        if (r10 == null) goto L19;
    L20:
        r7.put("logId", r10);
        Map r11 = ((com.bytedance.frameworks.baselib.netx.chunk.d) r6).b;
        Header r14 = r13.raw().getFirstHeader("x-tt-trace-id");
        if (r14 == null) goto L26;
        String r15 = r14.getValue();
        if (r15 == null) goto L26;
        r9 = r15;
    L26:
        r11.put("traceId", r9);
        List r16 = r13.raw().headers("x-nx-chunk");
        if (r16 != null) goto L29;
    L39:
        Intrinsics.checkNotNullParameter("server not support", "reason");
        ((com.bytedance.frameworks.baselib.netx.chunk.d) r6).a = true;
        goto L40
    L29:
        if (r16.size() == 0) goto L39;
        r16.size();
        String r17 = ((Header) ListProtector.get(r16, 0)).getValue();
        int r18 = StringsKt.indexOf$default(r17, ".", 0, false, 6, null);
        if (r18 < 0) goto L38;
        if ((!Intrinsics.areEqual("1", r17.substring(0, r18))) == false) goto L36;
        Intrinsics.checkNotNullParameter("version conflict", "reason");
        ((com.bytedance.frameworks.baselib.netx.chunk.d) r6).a = true;
    L36:
        ((com.bytedance.frameworks.baselib.netx.chunk.d) r6).a = false;
        goto L40
    L38:
        throw new IllegalAccessException("IllegalArgument NETX_CHUNK_VERSION_HEADER for live request");
    L19:
        r10 = "";
    L40:
        return r13;
    }
}
