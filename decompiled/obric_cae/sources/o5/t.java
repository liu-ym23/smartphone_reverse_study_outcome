package o5;

import android.content.Context;
import android.os.Handler;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;

/* JADX INFO: loaded from: classes.dex */
public final class t implements BackgroundProvider.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f9718a;

    public t(w r8) {
        this.f9718a = r8;
    }

    @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider.Callback
    public final void onAppBackgroundSwitch(boolean r8) {
        StringBuilder r10 = android.aimedia.a.l("onAppBackgroundSwitch isEnterBackground:", r8, "--coldBootBackground：");
        w r11 = this.f9718a;
        r10.append(r11.f9729f);
        Logger.i(r10.toString());
        boolean r12 = r11.f9729f;
        Context r13 = r11.f9725b;
        if (r12 == false) goto L6;
        r11.f9729f = false;
        r11.d(r13);
        NetworkManager.getInstance().registerNetworkCallback(r13);
        return;
    L6:
        if (r8 == false) goto L11;
        Logger.i("enter background");
        BDLocationConfig.setRequestLocation(false);
        if (BDLocationConfig.enableBackgroundLocation() == true) goto L10;
        m5.a.a().e();
        r11.e();
        NetworkManager.getInstance().unRegisterObserver(r13);
        g r14 = g.j();
        r14.getClass();
        Logger.i("BDLocationService.stopLocationBecauseEnterBackground.");
        Handler r15 = g.f9675m;
        r15.post(new i(r14));
        g r16 = g.j();
        r16.getClass();
        r15.post(new h(r16));
        SensorInfoManager.getInstance().unregisterListener(5);
    L10:
        NetworkManager.getInstance().unregisterNetworkCallback(r13);
        return;
    L11:
        Handler r17 = r11.f9724a;
        r17.post(new androidx.activity.j(this, 13));
        Logger.i("enter foreground");
        BDLocationConfig.setFirstRequestLocation(true);
        BDLocationConfig.setRequestLocation(false);
        r17.postDelayed(new r(0), BDLocationConfig.getBootLegitimateTime());
        r11.c();
        r17.post(new androidx.activity.j(r11, 12));
        NetworkManager.getInstance().registerNetworkCallback(r13);
    }
}
