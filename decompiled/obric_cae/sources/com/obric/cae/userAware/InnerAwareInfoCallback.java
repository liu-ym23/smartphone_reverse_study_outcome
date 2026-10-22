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
import com.obric.cae.location.StarLocationManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InnerAwareInfoCallback {

    public static final class CellPoiStatus {
        public final long cellId;
        public final int cellPoiType;
        public final int pci;
        public final int rat;
        public final String stationName;
        public final int tac;

        public CellPoiStatus(int r8, int r10, int r11, long r12, int r13, String r14) {
            this.cellPoiType = r8;
            this.rat = r10;
            this.tac = r11;
            this.cellId = r12;
            this.pci = r13;
            this.stationName = r14;
        }
    }

    public InnerAwareInfoCallback() {
    }

    public void onAoiBoardEvent(AoiBoard r8) {
    }

    public void onBtInfoChanged(BtAwareInfo r8) {
    }

    public void onCellInfoChanged(CellAwareInfo r8) {
    }

    public void onCellNeighborInfoChanged(List<CellAwareInfo> r8) {
    }

    public void onDeviceProvisionedChanged(int r8) {
    }

    public void onEngineStatusChanged(int r8) {
    }

    public void onGeofenceInfoChange(StarGeofence r8, Location r10) {
    }

    public void onGnssSvInfoChanged(GnssSvAwareInfo r8) {
    }

    public void onHAREnableValueChange(int r8) {
    }

    public void onHARStatusChanged(int r8, long r10) {
    }

    public void onInSubWayChange(int r8, String r10) {
    }

    public void onLocationAwareInfoChanged(LocationAwareInfo r8) {
    }

    public void onLocationChanged(Location r8) {
    }

    public void onLocationSourceChanged(StarLocationManager.LocationSource r8) {
    }

    public void onLocationStateValueChange(String r8) {
    }

    public void onLocationUiSettingChanged(boolean r8) {
    }

    public void onNetworkValid(boolean r8) {
    }

    public void onRecordNearbyStatus(boolean r8) {
    }

    public void onSensorDataChange(SensorEvent r8) {
    }

    public void onStepsCounterChanged(int r8) {
    }

    public void onSubwayCellPoiStatusChange(CellPoiStatus r8) {
    }

    public void onSubwayEvaluationEvent(boolean r8, float r10, String r11, long r12, int r13, int r14, float r15, float r16, int r17, boolean r18, String r19) {
    }

    public void onSubwayFeedbackSwitchValueChange(int r8) {
    }

    public void onUploadModeChanged(int r8) {
    }

    public void onUserFeedbackPredictSwitchValueChange(int r8) {
    }

    public void onWifiConnectInfoChanged(WifiStandardData r8) {
    }

    public void onWifiNetworkAvailable(boolean r8) {
    }

    public void onWifiScanInfoChanged(List<WifiStandardData> r8) {
    }

    public void onWifiScanNeighborApChanged(List<WifiStandardData> r8) {
    }

    public void onflightModeChanged(int r8) {
    }
}
