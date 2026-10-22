package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState;

    private static class TwilightState {
        boolean isNight;
        long nextUpdate;

        TwilightState() {
        }
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context r10, @NonNull LocationManager r11) {
        this.mTwilightState = new TwilightState();
        this.mContext = r10;
        this.mLocationManager = r11;
    }

    static TwilightManager getInstance(@NonNull Context r10) {
        if (sInstance != null) goto L6;
        Context r11 = r10.getApplicationContext();
        sInstance = new TwilightManager(r11, (LocationManager) r11.getSystemService("location"));
    L6:
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location r10 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r11 = getLastKnownLocationForProvider("network");
    L7:
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r10 = getLastKnownLocationForProvider("gps");
    L9:
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        if (r10.getTime() > r11.getTime()) goto L14;
        return r11;
    L14:
        return r10;
    L15:
        if (r10 != null) goto L17;
        return r11;
    L17:
        return r10;
    L5:
        r11 = null;
        goto L7
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String r10) {
    L6:
        e = move-exception;
        Log.d(TAG, "Failed to get last known location", e);
        return null;
    L3:
        if (this.mLocationManager.isProviderEnabled(r10) == false) goto L12;
        return this.mLocationManager.getLastKnownLocation(r10);
    L12:
        return null;
    }

    private boolean isStateValid() {
        if (this.mTwilightState.nextUpdate <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    static void setInstance(TwilightManager r10) {
        sInstance = r10;
    }

    private void updateState(@NonNull Location r19) {
        TwilightState r10 = this.mTwilightState;
        long r11 = System.currentTimeMillis();
        TwilightCalculator r12 = TwilightCalculator.getInstance();
        r12.calculateTwilight(r11 - 86400000, r19.getLatitude(), r19.getLongitude());
        r12.calculateTwilight(r11, r19.getLatitude(), r19.getLongitude());
        boolean r13 = true;
        if (r12.state == 1) goto L6;
        r13 = false;
    L6:
        boolean r14 = r13;
        long r15 = r12.sunrise;
        long r16 = r12.sunset;
        r12.calculateTwilight(r11 + 86400000, r19.getLatitude(), r19.getLongitude());
        long r17 = r12.sunrise;
        if (r15 != (-1)) goto L9;
    L19:
        long r18 = 43200000 + r11;
    L20:
        r10.isNight = r14;
        r10.nextUpdate = r18;
        return;
    L9:
        if (r16 == (-1)) goto L19;
        if (r11 <= r16) goto L15;
        long r20 = r17 + 0;
    L18:
        r18 = r20 + VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        goto L20
    L15:
        if (r11 <= r15) goto L17;
        r20 = r16 + 0;
        goto L18
    L17:
        r20 = r15 + 0;
        goto L18
    }

    boolean isNight() {
        TwilightState r10 = this.mTwilightState;
        if (isStateValid() == true) goto L5;
        Location r11 = getLastKnownLocation();
        if (r11 == null) goto L10;
        updateState(r11);
        return r10.isNight;
    L10:
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int r12 = Calendar.getInstance().get(11);
        if (r12 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r12 >= 22) goto L16;
        return false;
    L5:
        return r10.isNight;
    }
}
