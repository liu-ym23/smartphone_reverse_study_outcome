package yr9;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends as9.a {
    public final PowerManager f;
    public C0086a g;

    /* JADX INFO: renamed from: yr9.a$a, reason: collision with other inner class name */
    public class C0086a implements PowerManager.OnThermalStatusChangedListener {
        public final /* synthetic */ a a;

        public C0086a(a r1) {
            this.a = r1;
        }

        @Override // android.os.PowerManager.OnThermalStatusChangedListener
        public final void onThermalStatusChanged(int r4) {
            a r0 = this.a;
            monitor-enter(r0);
            a r1 = this.a;     // Catch: Throwable -> L9
            as9.a.InterfaceC0000a r2 = r1.a;     // Catch: Throwable -> L9
            if (r2 == null) goto L7;
            r1.d = r4;     // Catch: Throwable -> L9
            r2.onStatusGenerate(r4, -1.0f);     // Catch: Throwable -> L9
            boolean r5 = bs9.a.a;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    @Override // as9.a
    public final boolean a() {
        if (Build.VERSION.SDK_INT < 29) goto L14;
        PowerManager r0 = this.f;
        if (r0 == null) goto L14;
        if (this.g != null) goto L20;
        this.g = new C0086a(this);
    L20:
        r0.addThermalStatusListener(this.g);     // Catch: Exception -> L12 Throwable -> L16
        return true;
    L18:
        this.g = null;     // Catch: Throwable -> L17
    L22:
        return true;
    L14:
        return false;
    }

    @Override // as9.a
    public final int c() {
        if (this.a != null) goto L13;
        if (Build.VERSION.SDK_INT < 29) goto L10;
        PowerManager r0 = this.f;
        if (r0 == null) goto L10;
        return r0.getCurrentThermalStatus();
    L10:
        return -1;
    L13:
        return this.d;
    }

    @Override // as9.a
    public final void e() {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        PowerManager r0 = this.f;
        if (r0 == null) goto L9;
        C0086a r1 = this.g;
        if (r1 == null) goto L9;
        r0.removeThermalStatusListener(r1);
    L9:
        this.g = null;
    }

    public a(Context r2, Looper r3) {
        super(r2, r3);
        PowerManager r4 = (PowerManager) r2.getSystemService("power");
        this.f = r4;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r4 == null) goto L7;
        int r5 = r4.getCurrentThermalStatus();     // Catch: Exception -> L10
    L8:
        this.d = r5;
        return;
    L7:
        r5 = -1;
        goto L8
    }
}
