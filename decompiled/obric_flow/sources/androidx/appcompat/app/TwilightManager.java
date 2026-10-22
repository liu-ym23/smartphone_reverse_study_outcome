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
import cn.nubia.neopush.commons.AppUtil;
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

    public static class TwilightState {
        boolean isNight;
        long nextUpdate;

        public TwilightState() {
        }
    }

    @VisibleForTesting
    public TwilightManager(@NonNull Context r5, @NonNull LocationManager r10) {
        this.mTwilightState = new TwilightState();
        this.mContext = r5;
        this.mLocationManager = r10;
    }

    public static TwilightManager getInstance(@NonNull Context r5) {
        if (sInstance != null) goto L6;
        Context r10 = r5.getApplicationContext();
        sInstance = new TwilightManager(r10, (LocationManager) r10.getSystemService("location"));
    L6:
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location r5 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r10 = getLastKnownLocationForProvider("network");
    L7:
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r5 = getLastKnownLocationForProvider("gps");
    L9:
        if (r5 == null) goto L15;
        if (r10 == null) goto L15;
        if (r5.getTime() > r10.getTime()) goto L14;
        return r10;
    L14:
        return r5;
    L15:
        if (r5 != null) goto L17;
        return r10;
    L17:
        return r5;
    L5:
        r10 = null;
        goto L7
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String r5) {
    L6:
        e = move-exception;
        Log.d(TAG, "Failed to get last known location", e);
        return null;
    L3:
        if (this.mLocationManager.isProviderEnabled(r5) == false) goto L12;
        return this.mLocationManager.getLastKnownLocation(r5);
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
    public static void setInstance(TwilightManager r5) {
        sInstance = r5;
    }

    private void updateState(@NonNull Location r19) {
        TwilightState r5 = this.mTwilightState;
        long r10 = System.currentTimeMillis();
        TwilightCalculator r11 = TwilightCalculator.getInstance();
        r11.calculateTwilight(r10 - AppUtil.MILLIS_IN_DAYS, r19.getLatitude(), r19.getLongitude());
        r11.calculateTwilight(r10, r19.getLatitude(), r19.getLongitude());
        boolean r12 = true;
        if (r11.state != 1) goto L5;
    L4:
        boolean r13 = r12;
        long r14 = r11.sunrise;
        long r15 = r11.sunset;
        r11.calculateTwilight(r10 + AppUtil.MILLIS_IN_DAYS, r19.getLatitude(), r19.getLongitude());
        long r16 = r11.sunrise;
        if (r14 != (-1)) goto L9;
    L18:
        long r17 = r10 + 43200000;
    L19:
        r5.isNight = r13;
        r5.nextUpdate = r17;
        return;
    L9:
        if (r15 == (-1)) goto L18;
        if (r10 <= r15) goto L15;
        r14 = r16;
    L17:
        r17 = r14 + 60000;
        goto L19
    L15:
        if (r10 <= r14) goto L17;
        r14 = r15;
        goto L17
    L5:
        r12 = false;
        goto L4
    }

    public boolean isNight() {
        TwilightState r5 = this.mTwilightState;
        if (isStateValid() == true) goto L5;
        Location r10 = getLastKnownLocation();
        if (r10 == null) goto L10;
        updateState(r10);
        return r5.isNight;
    L10:
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int r11 = Calendar.getInstance().get(11);
        if (r11 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r11 >= 22) goto L16;
        return false;
    L5:
        return r5.isNight;
    }
}
