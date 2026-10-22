package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t3 implements Runnable {
    public final /* synthetic */ u3 a;

    public final void a() {
        u3 r0 = this.a;     // Catch: Throwable -> L22
        if (r0.b == null) goto L25;
        ThreadMethodProxy.start(r0.a);     // Catch: Throwable -> L22
        Handler r1 = new Handler(this.a.a.getLooper());     // Catch: Throwable -> L22
        u3 r2 = this.a;     // Catch: Throwable -> L22
        r2.d = (DisplayManager) r2.b.getApplicationContext().getSystemService((String) p2.a(16777217, 0, 0, "8ce276", new byte[]{45, 104, 5, 86, 4, 32, 34}));     // Catch: Throwable -> L22
        DisplayManager r3 = this.a.d;     // Catch: Throwable -> L22
        if (r3 == null) goto L26;
        Display[] r4 = r3.getDisplays();     // Catch: Throwable -> L22
        int r5 = r4.length;     // Catch: Throwable -> L22
        if (r5 > 1) goto L9;
    L20:
        u3 r6 = this.a;     // Catch: Throwable -> L22
        DisplayManager r7 = r6.d;     // Catch: Throwable -> L22
        e0 r8 = new e0(r7);     // Catch: Throwable -> L22
        r6.e = r8;     // Catch: Throwable -> L22
        r7.registerDisplayListener(r8, r1);     // Catch: Throwable -> L22
        return;
    L9:
        if (r3.j != null) goto L11;
        r3.j = new r3();     // Catch: Throwable -> L22
    L11:
        r3 r9 = r3.j;     // Catch: Throwable -> L22
        r9.getClass();     // Catch: Throwable -> L22
        String r10 = r3.d(r4);     // Catch: Throwable -> L22
        String r11 = r3.b(r4);     // Catch: Throwable -> L22
        if (r9.d == r5) goto L14;
        r9.e = System.currentTimeMillis() / 1000;     // Catch: Throwable -> L22
    L14:
        r9.d = r5;     // Catch: Throwable -> L22
        r9.i = true;     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r10) == true) goto L18;
        r9.g = r10;     // Catch: Throwable -> L22
    L18:
        if (TextUtils.isEmpty(r11) == true) goto L20;
        r9.h = r11;     // Catch: Throwable -> L22
        goto L20
    L26:
        return;
    L25:
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

    public t3(u3 r1) {
        this.a = r1;
    }
}
