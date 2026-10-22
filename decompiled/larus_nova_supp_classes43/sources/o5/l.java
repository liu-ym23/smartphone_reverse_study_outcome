package o5;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements Interceptor {
    public l() {
    }

    public final SsResponse<?> intercept(Interceptor.Chain r10) {
        if (r10 == null) goto L13;
        Request r0 = r10.request();
        if (r0 == null) goto L15;
        ArrayList r1 = new ArrayList();
        AtomicBoolean r11 = f2.b.a;
        h2.a r12 = f2.b.c;
        if (r12 != null) goto L9;
    L11:
        Request.Builder r13 = r0.newBuilder();
        List r14 = CollectionsKt.toMutableList(r0.getHeaders());
        r14.addAll(r1);
        Unit r15 = Unit.INSTANCE;
        return r10.proceed(r13.headers(r14).build());
    L9:
        if (r12.p == false) goto L11;
        r1.add(new Header("x-use-ppe", "1"));
        r1.add(new Header("x-tt-env", r12.q));
        goto L11
    L15:
        return null;
    L13:
        return null;
    }
}
