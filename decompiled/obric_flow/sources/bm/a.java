package bm;

import com.bytedance.vmsdk.jsbridge.utils.SystemThread;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.loader.AnimaXResourceLoaderHolder;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.utils.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f960b;

    public /* synthetic */ a(int r5) {
        this.f959a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f959a) {
            case 0: goto L27;
            case 1: goto L23;
            case 2: goto L17;
            case 3: goto L13;
            case 4: goto L10;
            default: goto L5;
        };
    L10:
        SystemThread.access$100(this.f960b);
        return;
    L17:
        long r5 = this.f960b;
        if (r5 == 0) goto L32;
        LynxTemplateRender.d0(r5);
        this.f960b = 0;
        return;
    L32:
        return;
    L27:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXComposition", "nativeDestroy AnimaXComposition on CleanupReference.");
        long r10 = this.f960b;
        if (r10 == 0) goto L34;
        AnimaXComposition.a(r10);
        this.f960b = 0;
        return;
    L34:
        return;
    L5:
        if (VSyncMonitor.f10833c != null) goto L8;
        j.f(new com.bytedance.android.anniex.worker.a(25));
    L8:
        VSyncMonitor.requestOnUIThread(this.f960b);
        return;
    L13:
        if (this.f960b == 0) goto L31;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXResourceLoaderHolder", "Call nativeDestroy.");
        AnimaXResourceLoaderHolder.a(this.f960b);
        this.f960b = 0;
        return;
    L31:
        return;
    L23:
        if (this.f960b == 0) goto L33;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXPlayer", "Call nativeDestroy.");
        AnimaXPlayer.e(this.f960b);
        this.f960b = 0;
        return;
    }

    public /* synthetic */ a(int r5, long r10) {
        this.f959a = r5;
        this.f960b = r10;
    }
}
