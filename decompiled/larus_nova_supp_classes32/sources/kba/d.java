package kba;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements Runnable {
    public final /* synthetic */ c a;

    public final void a() {
        if (this.a.h == true) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis();
        c r2 = this.a;
        int r3 = a.a;
        r2.f = a.b(r0 - r2.i);
        c r4 = this.a;
        r4.c.invoke(Float.valueOf(r4.f));
        c r5 = this.a;
        float r6 = r5.f;
        if ((r0 - r5.j) < 1000) goto L9;
        r5.j = r0;
        FLogger.a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_running: durationMs=" + (r0 - r5.i) + " amplitude=" + r6 + " mode=" + ((String) r5.b.invoke()));
    L9:
        c r1 = this.a;
        if (r1.h == false) goto L13;
        r1.a.postDelayed(this, 20);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(c r1) {
        this.a = r1;
    }
}
