package o5;

import com.bytedance.bdlocation.store.LocationCache;
import com.obric.cae.cldReport.CldCommon;
import com.ttnet.org.chromium.base.library_loader.LibraryLoader;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9716a;

    public /* synthetic */ q(int r8) {
        this.f9716a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9716a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        CldCommon.a();
        return;
    L7:
        LocationCache.getInstance().clearLocalLocationCache();
        return;
    L9:
        LibraryLoader.a();
    }
}
