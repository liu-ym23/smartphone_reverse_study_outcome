package com.obric.cae.location.geofence.vendor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.room.l;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class VendorGeoCallbackBroadcast extends BroadcastReceiver {
    private static final int XIAOMI_GEO_EVENT_ENTERED = 11;
    private static final int XIAOMI_GEO_EVENT_EXITED = 12;
    private final String TAG;

    public VendorGeoCallbackBroadcast() {
        this.TAG = "StarLocation-vendorGeoCallback";
    }

    public static /* synthetic */ void a(VendorGeoCallbackBroadcast r8, Context r10, Intent r11) {
        r8.lambda$onReceive$0(r10, r11);
    }

    private /* synthetic */ void lambda$onReceive$0(Context r8, Intent r10) {
        runOnCallback(r8, r10);
    }

    private Location normalizeGeofenceLocation(Location r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        String r10 = r8.getProvider();
        Location r11 = new Location(r8);
        if (r10 == null) goto L10;
        if (r10.isEmpty() == true) goto L10;
    L15:
        return StarLocationManager.getInstance().copyLocationWithConfidence(r11);
    L10:
        if (r8.hasSpeed() == false) goto L12;
        String r12 = CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS;
    L13:
        r11.setProvider(r12);
        goto L15
    L12:
        r12 = "network";
        goto L13
    }

    private synchronized void runOnCallback(Context r8, Intent r10) {
        monitor-enter(this);
        String r11 = r10.getStringExtra("context-data");     // Catch: Throwable -> L29
        Location r12 = normalizeGeofenceLocation((Location) r10.getParcelableExtra("transition-location"));     // Catch: Throwable -> L29
        if (r12 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        int r13 = 0;
        int r14 = r10.getIntExtra("transition-event", 0);     // Catch: Throwable -> L29
        CommSenseLog.encryptedI("StarLocation-vendorGeoCallback", LocationUtil.getEncryptedModule(), "GeofenceCallback-onTransitionEvent, event:" + r14 + ", id:" + r11, LocationUtil.getEncryptedKey());     // Catch: Throwable -> L29
        UserManager r15 = (UserManager) r8.getSystemService("user");     // Catch: Throwable -> L29
        StarGeofence r16 = null;
        if (r15 == null) goto L17;
        Iterator<UserHandle> r17 = r15.getUserProfiles().iterator();     // Catch: Throwable -> L29
    L12:
        if (r17.hasNext() == false) goto L17;
        UserHandle r18 = r17.next();     // Catch: Throwable -> L29
        StarGeofence r19 = StarLocationDbManager.getInstance(r8, r18.getIdentifier()).queryGeofenceById(r11);     // Catch: Throwable -> L29
        if (r19 != null) goto L15;
        r16 = r19;
        goto L12
    L15:
        r13 = r18.getIdentifier();     // Catch: Throwable -> L29
        r16 = r19;
    L17:
        if (r16 != null) goto L21;
        CommSenseLog.e("StarLocation-vendorGeoCallback", "starGeofence is null");     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L21:
        StarGeofence.GeoEvent r20 = toStarGeofenceEvent(r14);     // Catch: Throwable -> L29
        if (r20 != StarGeofence.GeoEvent.UNKNOWN) goto L26;
        CommSenseLog.e("StarLocation-vendorGeoCallback", "Unknown geofence event");     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L26:
        CommSenseLog.d("StarLocation-vendorGeoCallback", "dispatch geofence event from vendor callback, id=" + r11 + ", source=2, provider=" + r12.getProvider() + ", accuracy=" + r12.getAccuracy() + ", event=" + r20);     // Catch: Throwable -> L29
        StarLocationManager.getInstance().updateLatest(2, r12, r13);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }

    private StarGeofence.GeoEvent toStarGeofenceEvent(int r8) {
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L17;
        if (r8 == 11) goto L15;
        if (r8 == 12) goto L13;
        CommSenseLog.e("StarLocation-vendorGeoCallback", "Unknown geofence event: " + r8);
        return StarGeofence.GeoEvent.UNKNOWN;
    L13:
        return StarGeofence.GeoEvent.EXIT;
    L15:
        return StarGeofence.GeoEvent.ENTER;
    L17:
        return StarGeofence.GeoEvent.EXIT;
    L19:
        return StarGeofence.GeoEvent.ENTER;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r10) {
        CommSenseLog.d("StarLocation-vendorGeoCallback", "onReceive");
        if (r10 != null) goto L5;
    L9:
        CommSenseLog.d("StarLocation-vendorGeoCallback", "receiver intent error， " + r10);
        return;
    L5:
        if (r10.getIntExtra("transition-event", -1) == (-1)) goto L9;
        LocationUtil.getInstance().getExecutor().submit(new l(this, r8, r10, 4));
    }
}
