package of;

import com.lynx.base.log.LynxLog;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f20557a;

    public b(e r5) {
        this.f20557a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxLog.b(2, "VideoController", "Do trigger video engine prepare in video controller");
        TTVideoEngine r5 = this.f20557a.f20558a;
        if (r5 == null) goto L6;
        r5.prepare();
        return;
    }
}
