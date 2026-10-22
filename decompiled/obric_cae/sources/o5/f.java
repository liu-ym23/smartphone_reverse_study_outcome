package o5;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LightLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.notification.SubmitNotification;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f9667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9668b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f9669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f9670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f9671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ g f9672p;

    public class a implements LightLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f9673a;

        public a(f r8) {
            this.f9673a = r8;
        }

        @Override // com.bytedance.bdlocation.callback.LightLocationCallback
        public final void onError(String r8, String r10) {
            Logger.i("getLightLocation parseLocInfoRsp:" + r10 + "--code:" + r8);
            if (BDLocationException.ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD.equals(r8) == true) goto L5;
        L7:
            boolean r11 = false;
        L8:
            LocationMonitor.doLightLocationError(r8, r10, this.f9673a.f9670n, r11);
            return;
        L5:
            if (BDLocationConfig.enableLightLocationNewPolicy() == false) goto L7;
            SubmitNotification.getInstance().executeLightLocationSubmitNotification();
            r11 = true;
            goto L8
        }

        @Override // com.bytedance.bdlocation.callback.LightLocationCallback
        public final void onSuccess(LocationResp r19, LocationUploadExtra r20) {
            f r8 = this.f9673a;
            if (r19 != null) goto L6;
            LocationMonitor.doLightLocationError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "LocationResp is null", r8.f9670n, false);
            Logger.i("getLightLocation parseLocInfoRsp error : result is null");
            return;
        L6:
            int r10 = r19.resultCode;
            if (r10 == 0) goto L10;
            LocationMonitor.doLightLocationError(String.valueOf(r10), r19.resultMsg, r8.f9670n, false);
            Logger.i("getLightLocation parseLocInfoRsp error:" + r19.toString());
            return;
        L10:
            SubmitNotification.getInstance().executeLightLocationSubmitNotification();
            long r11 = System.currentTimeMillis() - r8.f9669m;
            Logger.i("getLightLocation total Duration：" + r11 + "--geCellDuration:" + r20.getCurrentStationDuration() + "--submitDuration:" + r20.getLightSubmitDuration() + "--appColdBootToStartLocationDuration:" + r8.f9671o);
            LocationMonitor.doLightLocation(r8.f9671o, r11, r20.getCurrentStationDuration(), r20.getLightSubmitDuration(), true, BDLocationException.SUCCESS, "", r8.f9670n, true);
        }
    }

    public f(g r8, Object r10, String r11, long r12, boolean r13, long r14) {
        this.f9672p = r8;
        this.f9667a = r10;
        this.f9668b = r11;
        this.f9669m = r12;
        this.f9670n = r13;
        this.f9671o = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r8 = this.f9670n;
        g r10 = this.f9672p;
        Object r11 = this.f9667a;
        LocationUtil.checkBpeaCertNull("getLightLocation", r11);     // Catch: BDLocationException -> L10
        LocationUploadExtra r12 = new LocationUploadExtra();     // Catch: BDLocationException -> L10
        if (r10.d(r11) == false) goto L7;
        r10.f9683g.checkAndTranslateCert(r11, "getLightLocation");     // Catch: BDLocationException -> L10
        String r13 = r10.f9683g.getBpeaToken(r11);     // Catch: BDLocationException -> L10
    L6:
        r12.setUploadSource(r13);     // Catch: BDLocationException -> L10
        r12.setStartLocationTime(this.f9669m);     // Catch: BDLocationException -> L10
        LocationUtil.startLightLocationUpload(r8, r12, r11, new a(this));     // Catch: BDLocationException -> L10
        return;
    L7:
        r13 = this.f9668b;     // Catch: BDLocationException -> L10
    L10:
        e = move-exception;
        LocationMonitor.doLightLocationError(e.getCode(), e.getMessage(), r8, false);
    }
}
