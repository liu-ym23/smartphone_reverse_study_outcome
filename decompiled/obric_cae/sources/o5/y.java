package o5;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public final class y implements LocationUploadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f9752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BDLocation f9753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f9754c;

    public y(x r8, long r10, BDLocation r11) {
        this.f9754c = r8;
        this.f9752a = r10;
        this.f9753b = r11;
    }

    @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
    public final void onError(String r8) {
        Logger.i("StationaryScene UpLoadCacheLocationInfo error: " + r8);
        LocationTraceLogger r10 = this.f9754c.f9735c.getLocationTraceLogger();
        LocationMonitor.locationTraceLogEnd(r10, "total_duration");
        r10.locationErrorReport(new BDLocationException(r8, "", "1001"));
    }

    @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
    public final void onSuccess(LocationResp r8, boolean r10, WifiInfo r11) {
        x r12 = this.f9754c;
        LocationTraceLogger r13 = r12.f9735c.getLocationTraceLogger();
        LocationMonitor.locationTraceLogEnd(r13, "total_duration");
        LocationMonitor.locationTracePutMetricData(r13, LocationMonitorConst.UPLOAD_STATIONARY_CACHE_INFO_DURATION, System.currentTimeMillis() - this.f9752a);
        if (r8 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        int r15 = -1001;
        String r16 = WsConstants.KEY_CONNECTION_ERROR;
        if (r14 == false) goto L12;
        r13.locationSuccessReport(this.f9753b, r12.f9735c);
    L20:
        StringBuilder r17 = android.aimedia.a.l("StationaryScene UpLoadCacheLocationInfo success: ", r14, "-resultCode: ");
        if (r8 == null) goto L24;
        r15 = r8.resultCode;
    L24:
        r17.append(r15);
        r17.append("-resultMsg: ");
        if (r8 == null) goto L28;
        r16 = r8.resultMsg;
    L28:
        r17.append(r16);
        Logger.i(r17.toString());
        return;
    L12:
        if (r8 != null) goto L14;
        String r18 = WsConstants.KEY_CONNECTION_ERROR;
    L15:
        StringBuilder r19 = new StringBuilder();
        if (r8 != null) goto L18;
        int r20 = -1001;
    L19:
        r13.locationErrorReport(new BDLocationException(r18, "", android.aimedia.a.h(r19, r20, "")));
        goto L20
    L18:
        r20 = r8.resultCode;
        goto L19
    L14:
        r18 = r8.resultMsg;
        goto L15
    L5:
        if (r8.resultCode != 0) goto L7;
        r14 = true;
        goto L8
    }
}
