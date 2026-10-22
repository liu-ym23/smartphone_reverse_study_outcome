package a3;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.a0;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import o2.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements q4.a {
    public a() {
    }

    private String d(String r10) {
        return f.c(r10, true);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }

    @Override // q4.a
    public a0 a(q4.a.InterfaceC0283a r10) {
        Long r11 = Long.valueOf(SystemClock.uptimeMillis());
        n4.c r12 = r10.a();
        URL r13 = new URL(r12.G());     // Catch: MalformedURLException -> L13
        if (r13.getProtocol().equals("http") == false) goto L6;
        f.B(r13.getHost(), r13.getPath(), false);     // Catch: MalformedURLException -> L13
    L6:
        n4.c r14 = b(r12);
        if (r14.z() == null) goto L9;
        r14.z().S.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r11.longValue()));
    L9:
        a0 r15 = r10.c(r14);
        Long r16 = Long.valueOf(SystemClock.uptimeMillis());
        c(r14, r15);
        if (r14.z() == null) goto L12;
        r14.z().T.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r16.longValue()));
    L12:
        return r15;
    }

    protected n4.c b(n4.c r10) {
        if (f.o() == true) goto L5;
    L9:
        if (r10 != null) goto L11;
        return r10;
    L11:
        Long r11 = Long.valueOf(SystemClock.uptimeMillis());
        String r12 = r10.G();
        if ((r10.t() instanceof o2.c) == false) goto L14;
        String r13 = f.g(r12, (o2.c) r10.t());
    L16:
        if (r10.z() == null) goto L19;
        RetrofitMetrics r14 = r10.z();
        r14.U = SystemClock.uptimeMillis() - r11.longValue();
    L19:
        if (r10.G().startsWith("https:") == true) goto L21;
    L23:
        Long r15 = Long.valueOf(SystemClock.uptimeMillis());
        if (r10.I() == false) goto L27;
        p2.b.b().a();
        r13 = d(r13);
    L27:
        if (r10.z() == null) goto L29;
        RetrofitMetrics r16 = r10.z();
        r16.V = SystemClock.uptimeMillis() - r15.longValue();
    L29:
        n4.c.a r17 = r10.O();
        r17.f(r13);
        return r17.a();
    L21:
        if (r13.startsWith("http:") == false) goto L23;
        URL r18 = new URL(r13);     // Catch: Throwable -> L31
        f.B(r18.getHost(), r18.getPath(), true);     // Catch: Throwable -> L31
        goto L23
    L14:
        r13 = f.f(r12);
        goto L16
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    protected void c(n4.c r10, a0 r11) {
    }
}
