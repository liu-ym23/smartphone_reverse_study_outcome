package ms.bd.c;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e0 implements DisplayManager.DisplayListener {
    public final DisplayManager a;

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int r1) {
    }

    public e0(DisplayManager r1) {
        this.a = r1;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int r11) {
        Display[] r12 = this.a.getDisplays();     // Catch: Exception -> L18
        int r0 = r12.length;     // Catch: Exception -> L18
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r3.j != null) goto L7;
        r3.j = new r3();     // Catch: Exception -> L18
    L7:
        r3 r1 = r3.j;     // Catch: Exception -> L18
        r1.getClass();     // Catch: Exception -> L18
        String r2 = r3.d(r12);     // Catch: Exception -> L18
        String r13 = r3.b(r12);     // Catch: Exception -> L18
        if (r1.d == r0) goto L10;
        r1.e = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
    L10:
        r1.d = r0;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.g = r2;     // Catch: Exception -> L18
    L14:
        if (TextUtils.isEmpty(r13) == true) goto L16;
        r1.h = r13;     // Catch: Exception -> L18
    L16:
        r1.a = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
        r1.f = (String) p2.a(16777217, 0, 0, "73890a", new byte[]{39, 53, 79});     // Catch: Exception -> L18
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int r11) {
        Display[] r12 = this.a.getDisplays();     // Catch: Exception -> L18
        int r0 = r12.length;     // Catch: Exception -> L18
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r3.j != null) goto L7;
        r3.j = new r3();     // Catch: Exception -> L18
    L7:
        r3 r1 = r3.j;     // Catch: Exception -> L18
        r1.getClass();     // Catch: Exception -> L18
        String r2 = r3.d(r12);     // Catch: Exception -> L18
        String r13 = r3.b(r12);     // Catch: Exception -> L18
        if (r1.d == r0) goto L10;
        r1.e = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
    L10:
        r1.d = r0;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.g = r2;     // Catch: Exception -> L18
    L14:
        if (TextUtils.isEmpty(r13) == true) goto L16;
        r1.h = r13;     // Catch: Exception -> L18
    L16:
        r1.b = System.currentTimeMillis() / 1000;     // Catch: Exception -> L18
        r1.f = (String) p2.a(16777217, 0, 0, "c7f849", new byte[]{96, 48, 24, 67, 29, 43});     // Catch: Exception -> L18
        return;
    }
}
