package com.obric.cae.userAware;

import android.hardware.SensorEvent;
import android.location.Location;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.location.a;
import com.obric.cae.userAware.datacollection.TrafficRecognitionInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InnerAwareInfoCallback {

    public static final class CellPoiStatus {
        public final long cellId;
        public final int cellPoiType;
        public final int pci;
        public final int rat;
        public final String stationName;
        public final int tac;

        public CellPoiStatus(int r1, int r2, int r3, long r4, int r6, String r7) {
            this.cellPoiType = r1;
            this.rat = r2;
            this.tac = r3;
            this.cellId = r4;
            this.pci = r6;
            this.stationName = r7;
        }
    }

    public InnerAwareInfoCallback() {
    }

    public void onAoiBoardEvent(AoiBoard r1) {
    }

    public void onBtInfoChanged(BtAwareInfo r1) {
    }

    public void onCellInfoChanged(CellAwareInfo r1) {
    }

    public void onCellNeighborInfoChanged(List<CellAwareInfo> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public void onDeviceProvisionedChanged(int r1) {
    }

    public void onEngineStatusChanged(int r1) {
    }

    public void onGeofenceInfoChange(StarGeofence r1, Location r2) {
    }

    public void onGnssSvInfoChanged(GnssSvAwareInfo r1) {
    }

    public void onHAREnableValueChange(int r1) {
    }

    public void onHARStatusChanged(int r1, long r2) {
    }

    public void onInSubWayChange(int r1, String r2) {
    }

    public void onLocationAwareInfoChanged(LocationAwareInfo r1) {
    }

    public void onLocationChanged(Location r1) {
    }

    public void onLocationSourceChanged(a.C0349a r1) {
    }

    public void onLocationStateValueChange(String r1) {
    }

    public void onLocationUiSettingChanged(boolean r1) {
    }

    public void onNetworkValid(boolean r1) {
    }

    public void onRecordNearbyStatus(boolean r1) {
    }

    public void onSensorDataChange(SensorEvent r1) {
    }

    public void onStepsCounterChanged(int r1) {
    }

    public void onSubwayCellPoiStatusChange(CellPoiStatus r1) {
    }

    public void onSubwayEvaluationEvent(boolean r1, float r2, String r3, long r4, int r6, int r7, float r8, float r9, int r10, boolean r11, String r12) {
    }

    public void onSubwayFeedbackSwitchValueChange(int r1) {
    }

    public void onTrafficRecognitionChanged(TrafficRecognitionInfo r1) {
    }

    public void onUploadModeChanged(int r1) {
    }

    public void onUserFeedbackPredictSwitchValueChange(int r1) {
    }

    public void onWifiConnectInfoChanged(WifiStandardData r1) {
    }

    public void onWifiNetworkAvailable(boolean r1) {
    }

    public void onWifiScanInfoChanged(List<WifiStandardData> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public void onWifiScanNeighborApChanged(List<WifiStandardData> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public void onflightModeChanged(int r1) {
    }
}
