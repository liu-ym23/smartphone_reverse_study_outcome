package o5;

import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.store.LocationCache;

/* JADX INFO: loaded from: classes.dex */
public final class n implements RequestPermissionUtils.OnPermissionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionUtils.OnPermissionListener f9713a;

    public n(RequestPermissionUtils.OnPermissionListener r8) {
        this.f9713a = r8;
    }

    @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
    public final void onPermissionDenied() {
        this.f9713a.onPermissionDenied();
        LocationCache.getInstance().setLocationDenyTime(System.currentTimeMillis());
    }

    @Override // com.bytedance.bdlocation.permission.request.RequestPermissionUtils.OnPermissionListener
    public final void onPermissionGranted() {
        this.f9713a.onPermissionGranted();
    }
}
