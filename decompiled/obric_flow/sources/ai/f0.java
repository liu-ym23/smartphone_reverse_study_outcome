package ai;

import android.os.SystemClock;
import com.bytedance.retrofit2.SsHttpCall;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f208b;

    public f0(h0 r5, Class r10) {
        this.f208b = r5;
        this.f207a = b0.f180a;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r5, Method r10, Object... r11) {
        i0 r12 = new i0();
        r12.e = System.currentTimeMillis();
        if (r10.getDeclaringClass() == Object.class) goto L5;
        this.f207a.getClass();
        r12.f223k = SystemClock.uptimeMillis();
        h0 r13 = this.f208b;
        l0 r14 = (l0) r13.f213a.get(r10);
        if (r14 != null) goto L18;
        ConcurrentHashMap r15 = r13.f213a;
        monitor-enter(r15);
        l0 r16 = (l0) r13.f213a.get(r10);     // Catch: Throwable -> L14
        if (r16 != null) goto L16;
        r16 = new k0(r13, r10).a();     // Catch: Throwable -> L14
        r13.f213a.put(r10, r16);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r15);     // Catch: Throwable -> L14
        r14 = r16;
    L14:
        th = move-exception;
        throw th;
    L18:
        r12.f224l = SystemClock.uptimeMillis();
        r14.f279t = r12;
        SsHttpCall r17 = new SsHttpCall(r14, r11);
        return r14.f266b.a(r17);
    L5:
        return r10.invoke(this, r11);
    }
}
