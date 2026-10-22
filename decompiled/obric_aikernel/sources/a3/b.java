package a3;

import android.os.SystemClock;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.a0;
import o2.f;

/* JADX INFO: loaded from: classes.dex */
public final class b implements q4.a {
    public b() {
    }

    private n4.c b(n4.c r10) {
        if (r10 != null) goto L5;
        return r10;
    L5:
        if (r10.N() == false) goto L7;
        return r10;
    L7:
        return c(r10);
    }

    private n4.c c(n4.c r10) {
        String r11 = r10.G();     // Catch: Throwable -> L7
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());     // Catch: Throwable -> L7
        String r13 = f.Y(r11, r10.I(), new Object[]{r10.s()});     // Catch: Throwable -> L7
        if (r10.z() == null) goto L5;
        r10.z().W = SystemClock.uptimeMillis() - r12.longValue();     // Catch: Throwable -> L7
    L5:
        n4.c.a r14 = r10.O();     // Catch: Throwable -> L7
        r14.f(r13);     // Catch: Throwable -> L7
        return r14.a();
    L7:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }

    @Override // q4.a
    public a0 a(q4.a.InterfaceC0283a r10) {
        RetrofitMetrics r11 = r10.b();
        Long r12 = Long.valueOf(SystemClock.uptimeMillis());
        n4.c r13 = b(r10.a());
        if (r11 == null) goto L6;
        r11.S.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12.longValue()));
    L6:
        return r10.c(r13);
    }
}
