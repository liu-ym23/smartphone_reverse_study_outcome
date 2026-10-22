package o5;

import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f9708b;

    public k(g r8, String r10) {
        this.f9708b = r8;
        this.f9707a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseLocate r8 = this.f9708b.f9682f;
        if (r8 == null) goto L6;
        String r10 = this.f9707a;
        r8.stopLocationForBusiness(r10);
        Logger.i("BDLocationService.stopLocationForBusiness completed: " + r10);
        return;
    }
}
