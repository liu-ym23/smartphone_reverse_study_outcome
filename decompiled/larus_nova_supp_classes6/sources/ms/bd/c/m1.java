package ms.bd.c;

import android.os.Build;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m1 implements Runnable {
    public final /* synthetic */ n1 a;

    public final void a() {
        r1 r0 = this.a.b.a;
        if (r0.a == true) goto L5;
    L17:
        String r1 = (String) p2.a(16777217, 0, 0, "ead419", new byte[]{80, 108, 2, 121, 7, 32, 74, 73, 35, 97});
        String r2 = (String) p2.a(16777217, 0, 0, "22aa4b", new byte[]{125, 110, 76, 85, 56, 97, 48, 1, 36, 52, 39, 124, 82, 2, 2, 121, 61, 83, 50, 52, 99, 35, 6, 26, 27, 101, 52, 23, 112, 48, 37, 36, 23, 7, 75, 48, 53, 0});
        int r3 = this.a.b.b.b;
        return;
    L5:
        if (r0.d != null) goto L8;
        r0.d = new q1(r0, r0.b);
    L8:
        if (r0.e == true) goto L17;
        if (Build.VERSION.SDK_INT < 26) goto L13;
        int r5 = 2038;
    L14:
        WindowManager.LayoutParams r4 = new WindowManager.LayoutParams(1, 1, r5, 262152, -3);
        r4.gravity = 8388661;
        r0.c.addView(r0.d, r4);     // Catch: Exception -> L19
    L16:
        r0.e = true;
        goto L17
    L13:
        r5 = 2002;
        goto L14
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

    public m1(n1 r1) {
        this.a = r1;
    }
}
