package com.obric.cae.location.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.EventsUtils;
import com.obric.cae.location.geofence.BreachEventData;
import com.obric.cae.location.geofence.StarGeofenceData;
import com.obric.cae.location.geofence.StarGeofenceProto;
import com.obric.cae.location.zpp.StarZppData;
import com.obric.cae.location.zpp.StarZppProto;
import com.obric.cae.log.CaeLog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationReportProto extends StarLocationReportBase {
    private static final int FEATURE_ID_STAR_GEOFENCE_EVENTS = 19;
    private static final int FEATURE_ID_STAR_ZPP_EVENTS = 20;
    private static final String TAG = "StarLocation-ReportProto";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile StarLocationReportProto sInstance;

    public class GeofenceReportItem extends StarLocationReportBase.ReportItem {
        final /* synthetic */ StarLocationReportProto this$0;

        public GeofenceReportItem(StarLocationReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.location.report.StarLocationReportBase.ReportItem
        public void buildEvents() {
            Object r8 = this.this$0.mGeoLock;
            monitor-enter(r8);
        L43:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mGeofenceEvents.isEmpty() == true) goto L7;
        L10:
            ArrayList r10 = new ArrayList(this.this$0.mGeofenceEvents);     // Catch: Throwable -> L43
            this.this$0.mGeofenceEvents.clear();     // Catch: Throwable -> L43
            ArrayList r11 = new ArrayList(this.this$0.mBreachEvents.values());     // Catch: Throwable -> L43
            this.this$0.mBreachEvents.clear();     // Catch: Throwable -> L43
            monitor-exit(r8);     // Catch: Throwable -> L43
            StarGeofenceProto.Builder r12 = StarGeofenceProto.newBuilder();
            Iterator r13 = r10.iterator();
        L14:
            if (r13.hasNext() == false) goto L34;
            StarLocationReportBase.InnerStarGeofenceEventData r14 = (StarLocationReportBase.InnerStarGeofenceEventData) r13.next();
            StarGeofenceData.Builder r15 = StarGeofenceData.newBuilder().setGeofenceId(r14.starGeofence.getGeofenceId()).setPackageName(r14.starGeofence.getPackageName()).setLatitude(r14.starGeofence.getLatitude()).setLongitude(r14.starGeofence.getLongitude()).setRadius(r14.starGeofence.getRadius()).setTransitionType(r14.starGeofence.getTransitionType().getValue()).setGeoType(r14.starGeofence.getGeoType().getValue());
            String r16 = r14.starGeofence.getAddress();
            if (r16 != null) goto L18;
        L20:
            int r17 = r14.operation;
            if (r17 != 1) goto L23;
            r15.addAddTimestamp(r14.timestamp);
        L33:
            r12.addGeofence(r15.build());
            goto L14
        L23:
            if (r17 != 2) goto L25;
            r15.addDeleteTimestamp(r14.timestamp);
            goto L33
        L25:
            if (r17 != 3) goto L27;
            r15.addUpdateTimestamp(r14.timestamp);
            goto L33
        L27:
            if (r17 != 4) goto L33;
            r15.addRecoverTimestamp(r14.timestamp);
            goto L33
        L18:
            if (r16.isEmpty() == true) goto L20;
            r15.setAddress(r16);
            goto L20
        L34:
            Iterator r18 = r11.iterator();
        L36:
            if (r18.hasNext() == false) goto L46;
            StarLocationReportBase.InnerBreachEventData r19 = (StarLocationReportBase.InnerBreachEventData) r18.next();
            r12.addBreachEvent(BreachEventData.newBuilder().setEventTimestamp(r19.eventTimestamp).setBreachLatitude(r19.latitude).setBreachLongitude(r19.longitude).setBreachHacc(r19.hacc).setProvider(r19.provider).setSource(r19.source).setSimCardStatus(r19.simCardStatus).addAllGeofenceId(r19.geofenceIds).addAllEvent(r19.events).addAllResponseRate(r19.responseRates).addAllFirstBreach(r19.firstBreaches).build());
            goto L36
        L46:
            EventsUtils.writePbEvent(System.currentTimeMillis(), 19, r12.build().toByteArray());     // Catch: Exception -> L40
            CaeLog.d(StarLocationReportProto.TAG, "Geofence writePbEvent success");     // Catch: Exception -> L40
            return;
        L40:
            e = move-exception;
            android.aimedia.a.q("Geofence writePbEvent failed: ", e, StarLocationReportProto.TAG);
            return;
        L7:
            if (this.this$0.mBreachEvents.isEmpty() == false) goto L10;
            monitor-exit(r8);     // Catch: Throwable -> L43
        }
    }

    public class ZppReportItem extends StarLocationReportBase.ReportItem {
        final /* synthetic */ StarLocationReportProto this$0;

        public ZppReportItem(StarLocationReportProto r8) {
            this.this$0 = r8;
        }

        @Override // com.obric.cae.location.report.StarLocationReportBase.ReportItem
        public void buildEvents() {
            Object r8 = this.this$0.mZppLock;
            monitor-enter(r8);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mReadyZppSessions.isEmpty() == false) goto L8;
            monitor-exit(r8);     // Catch: Throwable -> L19
            return;
        L8:
            ArrayList r10 = new ArrayList(this.this$0.mReadyZppSessions);     // Catch: Throwable -> L19
            this.this$0.mReadyZppSessions.clear();     // Catch: Throwable -> L19
            monitor-exit(r8);     // Catch: Throwable -> L19
            Iterator r11 = r10.iterator();
        L12:
            if (r11.hasNext() == false) goto L18;
            StarLocationReportBase.InnerZppSessionData r12 = (StarLocationReportBase.InnerZppSessionData) r11.next();
            StarZppProto.Builder r13 = StarZppProto.newBuilder();
            StarZppData.Builder r14 = StarZppData.newBuilder();
            r14.setModelVersion(r12.modelVersion);
            r14.addAllTimestamp(r12.timestamps);
            r14.addAllConfidence(r12.confidences);
            r14.addAllFeatureArray(r12.featureArrays);
            r14.addAllEval(r12.evals);
            r14.setZppStrategy(r12.zppStrategy);
            r13.setZpp(r14.build());
            EventsUtils.writePbEvent(System.currentTimeMillis(), 20, r13.build().toByteArray());     // Catch: Exception -> L16
            CaeLog.d(StarLocationReportProto.TAG, "ZPP writePbEvent success");     // Catch: Exception -> L16
        L16:
            e = move-exception;
            android.aimedia.a.q("ZPP writePbEvent failed: ", e, StarLocationReportProto.TAG);
            goto L12
        }
    }

    private StarLocationReportProto(Context r8) {
        super(r8);
    }

    public static StarLocationReportProto getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(StarLocationReportProto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StarLocationReportProto(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(StarLocationReportProto.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.obric.cae.location.report.StarLocationReportBase
    public void cleanup() {
        super.cleanup();
        sInstance = null;
    }

    @Override // com.obric.cae.location.report.StarLocationReportBase
    public StarLocationReportBase.ReportItem createGeofenceReportItem() {
        return new GeofenceReportItem(this);
    }

    @Override // com.obric.cae.location.report.StarLocationReportBase
    public StarLocationReportBase.ReportItem createZppReportItem() {
        return new ZppReportItem(this);
    }

    @Override // com.obric.cae.location.report.StarLocationReportBase
    public String getTag() {
        return TAG;
    }
}
