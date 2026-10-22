package i7;

import android.os.SystemClock;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import w6.e;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Interceptor {
    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r10) {
        RetrofitMetrics r11 = r10.metrics();
        Long r8 = Long.valueOf(SystemClock.uptimeMillis());
        Request r12 = r10.request();
        if (r12 != null) goto L6;
    L17:
        if (r11 == null) goto L20;
        r11.requestInterceptDuration.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r8.longValue()));
    L20:
        return r10.proceed(r12);
    L6:
        if (r12.isResponseStreaming() == true) goto L17;
        String r13 = r12.getUrl();     // Catch: Throwable -> L15
        Long r14 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L15
        boolean r15 = r12.isAddCommonParam();     // Catch: Throwable -> L15
        Object[] r16 = {r12.getBody()};     // Catch: Throwable -> L15
        e.a r17 = e.f13022c;     // Catch: Throwable -> L15
        if (r17 == null) goto L11;
        r13 = r17.addRequestVertifyParams(r13, r15, r16);     // Catch: Throwable -> L15
    L11:
        if (r12.getMetrics() == null) goto L13;
        r12.getMetrics().requestVerifyDuration = SystemClock.uptimeMillis() - r14.longValue();     // Catch: Throwable -> L15
    L13:
        Request.Builder r18 = r12.newBuilder();     // Catch: Throwable -> L15
        r18.url(r13);     // Catch: Throwable -> L15
        r12 = r18.build();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }
}
