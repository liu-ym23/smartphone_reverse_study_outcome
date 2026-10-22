package com.obric.cae.location.geofence.vendor;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.UserHandle;
import android.os.UserManager;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.a;
import com.obric.cae.location.city.f;
import com.obric.cae.location.database.c;
import com.obric.cae.location.util.d;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class VendorGeoCallbackBroadcast extends PluginBroadcastReceiver {
    private static final int XIAOMI_GEO_EVENT_ENTERED = 11;
    private static final int XIAOMI_GEO_EVENT_EXITED = 12;
    private final String TAG;

    public VendorGeoCallbackBroadcast() {
        this.TAG = "StarLocation-vendorGeoCallback";
    }

    private Location normalizeGeofenceLocation(Location r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r1 = r2.getProvider();
        Location r0 = new Location(r2);
        if (r1 == null) goto L10;
        if (r1.isEmpty() == true) goto L10;
    L15:
        return a.a().b(r0);
    L10:
        if (r2.hasSpeed() == false) goto L12;
        String r3 = "gps";
    L13:
        r0.setProvider(r3);
        goto L15
    L12:
        r3 = "network";
        goto L13
    }

    private synchronized void runOnCallback(Context r8, Intent r9) {
        monitor-enter(this);
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        String r0 = r9.getStringExtra("context-data");     // Catch: Throwable -> L28
        Location r1 = normalizeGeofenceLocation((Location) ZeusTransformUtils.preCheckCast(r9.getParcelableExtra("transition-location"), Location.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
        if (r1 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r3 = 0;
        int r11 = r9.getIntExtra("transition-event", 0);     // Catch: Throwable -> L28
        com.obric.cae.log.a.c("StarLocation-vendorGeoCallback", d.c(), "GeofenceCallback-onTransitionEvent, event:" + r11 + ", id:" + r0, d.b());     // Catch: Throwable -> L28
        StarGeofence r2 = null;
        UserManager r4 = (UserManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r4 == null) goto L16;
        Iterator<UserHandle> r5 = r4.getUserProfiles().iterator();     // Catch: Throwable -> L28
    L11:
        if (r5.hasNext() == false) goto L16;
        UserHandle r6 = (UserHandle) ZeusTransformUtils.preCheckCast(r5.next(), UserHandle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        StarGeofence r7 = c.a(r10, r6.getIdentifier()).d(r0);     // Catch: Throwable -> L28
        if (r7 != null) goto L14;
        r2 = r7;
        goto L11
    L14:
        r3 = r6.getIdentifier();     // Catch: Throwable -> L28
        r2 = r7;
    L16:
        if (r2 != null) goto L20;
        com.obric.cae.log.a.i("StarLocation-vendorGeoCallback", "starGeofence is null");     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L20:
        StarGeofence.GeoEvent r12 = toStarGeofenceEvent(r11);     // Catch: Throwable -> L28
        if (r12 != StarGeofence.GeoEvent.UNKNOWN) goto L25;
        com.obric.cae.log.a.i("StarLocation-vendorGeoCallback", "Unknown geofence event");     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L25:
        com.obric.cae.log.a.c("StarLocation-vendorGeoCallback", f.a("dispatch geofence event from vendor callback, id=", r0, ", source=2, provider=").append(r1.getProvider()).append(", accuracy=").append(r1.getAccuracy()).append(", event=").append(r12).toString());     // Catch: Throwable -> L28
        a.a().b(2, r1, r3);     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    private StarGeofence.GeoEvent toStarGeofenceEvent(int r2) {
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L17;
        if (r2 == 11) goto L15;
        if (r2 == 12) goto L13;
        com.obric.cae.log.a.i("StarLocation-vendorGeoCallback", "Unknown geofence event: " + r2);
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

    public /* synthetic */ void lambda$onReceive$0$VendorGeoCallbackBroadcast(Context r3, Intent r4) {
        runOnCallback((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    public void onReceive(Context r4, final Intent r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c("StarLocation-vendorGeoCallback", "onReceive");
        if (r5 != null) goto L5;
    L9:
        com.obric.cae.log.a.c("StarLocation-vendorGeoCallback", "receiver intent error， " + r5);
        return;
    L5:
        if (r5.getIntExtra("transition-event", -1) == (-1)) goto L9;
        d.a().r().submit(new $$Lambda$VendorGeoCallbackBroadcast$ClwZi1bjp3Pv1CHBSOx9QPnon4(this, r6, r5));
    }
}
