package o5;

import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f9705a;

    public i(g r8) {
        this.f9705a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r8 = this.f9705a;
        if (g.b(r8) != null) goto L5;
    L10:
        StringBuilder r10 = new StringBuilder("stopLocationBecauseEnterBackground skip, option: ");
        if (g.b(r8) != null) goto L13;
        Object r11 = "cl null";
    L14:
        r10.append(r11);
        Logger.i(r10.toString());
        return;
    L13:
        r11 = g.b(r8).getLocationOption();
        goto L14
    L5:
        if (g.b(r8).getLocationOption() != null) goto L7;
    L8:
        Logger.i("stopLocationBecauseEnterBackground, option: " + g.b(r8).getLocationOption());
        g.b(r8).stopLocation();
        return;
    L7:
        if ("bpea-light_navigation".equals(g.b(r8).getLocationOption().getUploadSource()) == true) goto L10;
        goto L8
    }
}
