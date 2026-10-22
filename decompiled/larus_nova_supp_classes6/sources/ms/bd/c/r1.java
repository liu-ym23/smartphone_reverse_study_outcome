package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class r1 {
    public final boolean a;
    public final Context b;
    public final WindowManager c;
    public q1 d;
    public boolean e;
    public final LinkedBlockingDeque f;
    public final u1 g;
    public final Object h;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "98756b", new byte[]{12, 53, 81, 120, 0, 123, 22, 16, 112, 96});
        String r1 = (String) p2.a(16777217, 0, 0, "2ef3ba", new byte[]{47, 110, 3, 66, 98, 98, 52, 87});
    }

    public final String b() {
        if (this.a == true) goto L7;
        u1 r0 = this.g;
        r0.b = -1;
        return r0.toString();
    L7:
        if (this.f.isEmpty() == true) goto L31;
        Object r2 = this.h;
        monitor-enter(r2);
        int r1 = 0;
        String r3 = (String) p2.a(16777217, 0, 0, "f516bb", new byte[]{50, 51, 2, 80, 88, 120, 100, 29, 110, 99, 115, 119, 86, 77, 29, 119, 96, 84, 114, 99, 103, 56, 80, 86, 88, 113, 43});     // Catch: Throwable -> L28
        this.f.size();     // Catch: Throwable -> L28
        LinkedBlockingDeque r4 = this.f;     // Catch: Throwable -> L28
        int r5 = b4.a;     // Catch: Throwable -> L28
        if (r4 != null) goto L14;
    L24:
        String r6 = "";
    L25:
        this.f.clear();     // Catch: Throwable -> L28
        monitor-exit(r2);     // Catch: Throwable -> L28
        return r6;
    L14:
        if (r4.isEmpty() == true) goto L24;
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L28
        Iterator r8 = r4.iterator();     // Catch: Throwable -> L28
    L18:
        if (r8.hasNext() == false) goto L23;
        r7.append(r8.next().toString());     // Catch: Throwable -> L28
        if (r1 >= (r4.size() - 1)) goto L22;
        r7.append('|');     // Catch: Throwable -> L28
    L22:
        r1 = r1 + 1;     // Catch: Throwable -> L28
        goto L18
    L23:
        r6 = r7.toString();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        return "";
    }

    public final void c() {
        if (this.a == false) goto L15;
        this.g.f = SystemClock.uptimeMillis();
        this.g.a++;
        String r0 = (String) p2.a(16777217, 0, 0, "5d47e8", new byte[]{121, 59, 26, 30, 7, 114, 107, 24, 56, 58, 100, 35, 84, 3, 7, 114, 107, 24, 56, 58, 121, 59, 26, 30, 26});
        u1 r1 = this.g.a();
        Object r2 = this.h;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f.size() <= 50) goto L9;
        this.f.pop();     // Catch: Throwable -> L12
    L9:
        this.f.add(r1);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        u1 r3 = this.g;
        r3.b = 0;
        r3.c = 0;
        return;
    }

    public r1(Context r8) {
        this.e = false;
        this.g = new u1();
        this.f = new LinkedBlockingDeque();
        this.h = new Object();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r0 = Settings.canDrawOverlays(r8);
    L6:
        this.a = r0;
        if (r0 == true) goto L10;
        String r9 = (String) p2.a(16777217, 0, 0, "99850b", new byte[]{12, 52, 94, 120, 6, 123, 22, 17, 127, 96});
        String r10 = (String) p2.a(16777217, 0, 0, "f20c14", new byte[]{88, 38, 70, 5, 2, 34, 124, 83, 113, 54, 101, 61, 74, 4, 29, 42, 106, 29, 33, 58, 100, 112, 77, 24, 26, 99, 98, 1, 96, 61, 99, 53, 71, 89});
        return;
    L10:
        this.b = r8;
        this.c = (WindowManager) r8.getSystemService((String) p2.a(16777217, 0, 0, "7f9e42", new byte[]{49, 109, 68, 21, 4, 50}));
        return;
    L5:
        r0 = true;
        goto L6
    }

    public final void a(boolean r3) {
        if (this.a == false) goto L16;
        q1 r0 = this.d;
        if (r0 != null) goto L7;
    L10:
        if (r3 == false) goto L17;
        this.d = null;
        u1 r4 = this.g;
        r4.b = 0;
        r4.c = 0;
        r4.a = 0;
        return;
    L17:
        return;
    L7:
        if (this.e == false) goto L10;
        this.c.removeView(r0);     // Catch: Exception -> L13
    L9:
        this.e = false;
        goto L10
    }
}
