package com.obric.cae.location.geosdk.poi;

import android.content.Context;
import android.hardware.SensorEvent;
import android.location.Location;
import android.os.Message;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends InnerAwareInfoCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StarPoiManager f7227a;

    public h(StarPoiManager r1) {
        this.f7227a = r1;
    }

    private void a(int r5) {
        StarPoiManager r4 = this.f7227a;
        StarPoiManager r0 = StarPoiManager.f7164a;
        if (r4.m() == true) goto L6;
        return;
    L6:
        if ((Math.abs(r5) % 10) != 0) goto L8;
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.libs.statemachine.d.a("onStepsCounterChanged steps=", r5, ", mLastDetectSteps=").append(r4.ac).toString());
    L8:
        r4.ab = r5;
        System.currentTimeMillis();
        c r1 = r4.D;
        if (r1 != c.f7219a) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L20;
        r4.d(1);
        r4.Z.obtainMessage(1, r5, 0).sendToTarget();
        return;
    L20:
        return;
    L11:
        if (r1 == c.f7220b) goto L14;
        r2 = false;
        goto L15
    }

    public static /* synthetic */ void lambda$Bn1xmVKKrOfO8SNyAo8vzPKAEPc(h r0, int r1) {
        r0.a(r1);
    }

    @Override // com.obric.cae.userAware.InnerAwareInfoCallback
    public final void onAoiBoardEvent(AoiBoard r3) {
        StarPoiManager r2 = this.f7227a;
        StarPoiManager r0 = StarPoiManager.f7164a;
        if (r2.m() == false) goto L20;
        if (r3 == null) goto L21;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "onAoiBoardEvent type=" + r3.getType() + ", event=" + r3.getEvent());
        if (r2.D == c.f7220b) goto L12;
        if (r2.D == c.f7219a) goto L12;
        return;
    L12:
        if (r3.getType() == AoiBoard.Type.MALL) goto L14;
        return;
    L14:
        if (r3.getEvent() != AoiBoard.Event.ENTER) goto L19;
        r2.d(5);
        r2.Z.obtainMessage(5).sendToTarget();
        return;
    L19:
        return;
    L21:
        return;
    }

    @Override // com.obric.cae.userAware.InnerAwareInfoCallback
    public final void onGeofenceInfoChange(StarGeofence r6, Location r7) {
        StarPoiManager r5 = this.f7227a;
        StarPoiManager r8 = StarPoiManager.f7164a;
        if (r5.m() == false) goto L49;
        if (r6 == null) goto L50;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "onGeofenceInfoChange geoType=" + r6.getGeoType() + ", geoState=" + r6.getGeoState());
        StarGeofence.GeoType r9 = r6.getGeoType();
        StarGeofence.GeoType r10 = StarGeofence.GeoType.MALL;
        if (r9 != r10) goto L51;
        Context r11 = r5.t;
        if (r11 != null) goto L39;
    L23:
        boolean r12 = false;
    L25:
        if (r12 == true) goto L27;
    L30:
        if (r12 == true) goto L32;
    L34:
        if (r12 == false) goto L36;
        return;
    L36:
        if (r5.D == c.f7219a) goto L48;
        r5.d(4);
        Message r13 = r5.Z.obtainMessage(4, 1, 0);
    L29:
        r13.sendToTarget();
        return;
    L48:
        return;
    L32:
        if (r5.D != c.f7220b) goto L34;
        r5.d(7);
        r13 = r5.Z.obtainMessage(7, 0, 0);
        goto L29
    L27:
        if (r5.D != c.f7219a) goto L30;
        r5.d(4);
        r13 = r5.Z.obtainMessage(4, 0, 0);
        goto L29
    L39:
        Iterator<StarGeofence> r14 = com.obric.cae.location.database.c.a(r11, 0).a(0, r10).iterator();     // Catch: RuntimeException -> L21
    L15:
        if (r14.hasNext() == false) goto L23;
        StarGeofence r15 = (StarGeofence) ZeusTransformUtils.preCheckCast(r14.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L21
        if (r15 == null) goto L15;
        if (r15.getGeoState() != StarGeofence.GeoState.INSIDE) goto L15;
        r12 = true;
    L21:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "query mall geofences failed", e);
        goto L23
    L51:
        return;
    L50:
        return;
    }

    @Override // com.obric.cae.userAware.InnerAwareInfoCallback
    public final void onHARStatusChanged(int r4, long r5) {
        StarPoiManager r3 = this.f7227a;
        int r0 = r3.aj;
        r3.aj = r4;
        if (r3.m() == true) goto L6;
        return;
    L6:
        if (r3.D != c.f7219a) goto L9;
        return;
    L9:
        if (StarPoiManager.a(r3.D) == true) goto L23;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "onHARStatusChanged status=" + r4 + ", timestampMs=" + r5);
        boolean r6 = StarPoiManager.a(r0);
        boolean r7 = StarPoiManager.a(r4);
        if (r4 != 0) goto L14;
        boolean r1 = true;
    L15:
        if (r6 == r7) goto L17;
    L18:
        r3.d(2);
        r3.Z.obtainMessage(2, r4, 0).sendToTarget();
        return;
    L17:
        if (r3.G != r1) goto L18;
        return;
    L14:
        r1 = false;
        goto L15
    }

    @Override // com.obric.cae.userAware.InnerAwareInfoCallback
    public final void onSensorDataChange(SensorEvent r5) {
        StarPoiManager r4 = this.f7227a;
        StarPoiManager r0 = StarPoiManager.f7164a;
        if (r4.m() == false) goto L28;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.sensor == null) goto L30;
        c r1 = r4.D;
        if (r1 != c.f7219a) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
        return;
    L16:
        if (r5.sensor.getType() != 33171019) goto L32;
        float[] r6 = r5.values;
        if (r6 != null) goto L20;
        return;
    L20:
        if (r6.length == 0) goto L34;
        int r7 = (int) r6[0];
        long r3 = System.currentTimeMillis();
        r4.ae = r7;
        if (r7 != 0) goto L25;
        long r8 = 0;
    L26:
        r4.af = r8;
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.libs.statemachine.d.a("upDownType=", r7, ", isInUpDownStage=").append(r4.a(r3)).toString());
        return;
    L25:
        r8 = r3;
        goto L26
    L34:
        return;
    L32:
        return;
    L10:
        if (r1 == c.f7220b) goto L13;
        r2 = false;
        goto L14
    L30:
        return;
    }

    @Override // com.obric.cae.userAware.InnerAwareInfoCallback
    public final void onStepsCounterChanged(final int r3) {
        StarPoiManager.j r0 = this.f7227a.Z;
        if (r0 == null) goto L6;
        r0.post(new $$Lambda$h$Bn1xmVKKrOfO8SNyAo8vzPKAEPc(this, r3));
        return;
    }
}
