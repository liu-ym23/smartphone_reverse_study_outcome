package o5;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f9709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLocation f9710b;

    public l(BDLocation r8, x r10) {
        this.f9709a = r10;
        this.f9710b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9709a.onLocationChanged(this.f9710b);
    }
}
