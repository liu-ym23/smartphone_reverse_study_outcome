package o5;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;

/* JADX INFO: loaded from: classes.dex */
public final class v implements BackgroundProvider.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f9722a;

    public v(w r8) {
        this.f9722a = r8;
    }

    @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider.Callback
    public final void onAppBackgroundSwitch(boolean r8) {
        Logger.i("onAppBackgroundSwitchTest isEnterBackground:" + r8);
        boolean r10 = LocationUtil.isMainThread();
        w r11 = this.f9722a;
        if (r10 == false) goto L5;
        r11.f9724a.post(new u(this, 0, r8));
        return;
    L5:
        w.a(r11, r8);
    }
}
