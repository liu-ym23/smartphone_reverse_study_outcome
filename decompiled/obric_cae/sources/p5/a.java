package p5;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public final class a implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDLocationCallback f9945a;

    public a() {
        this.f9945a = null;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r8) {
        BDLocationCallback r10 = this.f9945a;
        if (r10 == null) goto L6;
        r10.onError(r8);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r8) {
        BDLocationCallback r10 = this.f9945a;
        if (r10 == null) goto L6;
        r10.onLocationChanged(r8);
        return;
    }
}
