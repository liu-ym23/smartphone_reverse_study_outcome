package mn;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import com.lynx.tasm.core.VSyncMonitor;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20154a;

    public /* synthetic */ j(int r5) {
        this.f20154a = r5;
    }

    private final void a(int r5) {
    }

    private final void b(int r5) {
    }

    private final void c(int r5) {
    }

    private final void d(int r5) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int r5) {
        int r10 = this.f20154a;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int r5) {
        switch(this.f20154a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        r2.b r10 = r2.b.f21643a;
        String r11 = com.lynx.jsbridge.a.d(r5, "display_changed:");
        monitor-enter(r10);
        r2.b.f = r11;     // Catch: Throwable -> L9
        Handler r12 = r2.b.f21645c;     // Catch: Throwable -> L9
        f3.a r13 = r2.b.f21646h;     // Catch: Throwable -> L9
        r12.removeCallbacks(r13);     // Catch: Throwable -> L9
        r12.postDelayed(r13, 100);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        if (r5 == 0) goto L14;
        return;
    L14:
        if (VSyncMonitor.f10832b == null) goto L20;
        VSyncMonitor.b();
        return;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int r5) {
        int r10 = this.f20154a;
    }
}
