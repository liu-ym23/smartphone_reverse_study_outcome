package o5;

import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f9706a;

    public j(g r8) {
        this.f9706a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r8 = this.f9706a;
        if (g.b(r8) == null) goto L6;
        g.b(r8).stopLocation();
        Logger.i("BDLocationService.stopLocation, uploadSource: " + g.b(r8).getLocationOption());
        return;
    }
}
