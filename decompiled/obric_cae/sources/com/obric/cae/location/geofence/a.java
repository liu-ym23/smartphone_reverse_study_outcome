package com.obric.cae.location.geofence;

import android.hardware.SensorEvent;
import android.location.Location;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements UserAwareManager.InnerCallbackAction2, UserAwareManager.InnerCallbackAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5654a;

    public /* synthetic */ a(int r8) {
        this.f5654a = r8;
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction
    public final void execute(InnerAwareInfoCallback r8, Object r10) {
        switch(this.f5654a) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L21;
        };
    L5:
        r8.onSensorDataChange((SensorEvent) r10);
        return;
    L7:
        r8.onHAREnableValueChange(((Integer) r10).intValue());
        return;
    L9:
        r8.onWifiConnectInfoChanged((WifiStandardData) r10);
        return;
    L11:
        r8.onCellNeighborInfoChanged((List) r10);
        return;
    L13:
        r8.onflightModeChanged(((Integer) r10).intValue());
        return;
    L15:
        r8.onLocationAwareInfoChanged((LocationAwareInfo) r10);
        return;
    L17:
        r8.onLocationUiSettingChanged(((Boolean) r10).booleanValue());
        return;
    L19:
        r8.onWifiScanInfoChanged((List) r10);
        return;
    L21:
        r8.onStepsCounterChanged(((Integer) r10).intValue());
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction2
    public final void execute(InnerAwareInfoCallback r8, Object r10, Object r11) {
        StarGeoCallback.a(r8, (StarGeofence) r10, (Location) r11);
    }
}
