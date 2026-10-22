package com.obric.cae.location.report;

import android.annotation.SuppressLint;
import android.content.Context;
import com.obric.cae.libs.useraware.ICaeUserAware;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.UserAwareManager;
import ha.j;
import ha.m;
import ha.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationReportJson extends StarLocationReportBase {
    private static final String TAG = "StarLocation-ReportJson";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile StarLocationReportJson sInstance;

    public class GeofenceReportItem extends StarLocationReportBase.ReportItem {
        final /* synthetic */ StarLocationReportJson this$0;

        public GeofenceReportItem(StarLocationReportJson r8) {
            this.this$0 = r8;
        }

        private s getBreachObj(StarLocationReportBase.InnerBreachEventData r8) {
            s r10 = new s();
            r10.m("timestamp", Long.valueOf(r8.eventTimestamp));
            r10.m("latitude", Double.valueOf(r8.latitude));
            r10.m(StarCellDbManager.CellInfoEntry.LONGITUDE, Double.valueOf(r8.longitude));
            r10.m("hacc", Float.valueOf(r8.hacc));
            r10.n("provider", r8.provider);
            r10.m("source", Integer.valueOf(r8.source));
            r10.m("simCardStatus", Integer.valueOf(r8.simCardStatus));
            m r11 = new m();
            Iterator<String> r12 = r8.geofenceIds.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.m(r12.next());
            goto L4
        L6:
            r10.k("geofenceIds", r11);
            m r13 = new m();
            Iterator<Integer> r14 = r8.events.iterator();
        L8:
            if (r14.hasNext() == false) goto L10;
            r13.l(r14.next());
            goto L8
        L10:
            r10.k("events", r13);
            return r10;
        }

        private s getGeoObj(StarLocationReportBase.InnerStarGeofenceEventData r8) {
            s r10 = new s();
            r10.n(StarLocationDbManager.AoiBoardEntry.GEOFENCE_ID, r8.starGeofence.getGeofenceId());
            r10.n("packageName", r8.starGeofence.getPackageName());
            r10.m("latitude", Double.valueOf(r8.starGeofence.getLatitude()));
            r10.m(StarCellDbManager.CellInfoEntry.LONGITUDE, Double.valueOf(r8.starGeofence.getLongitude()));
            r10.m("radius", Integer.valueOf(r8.starGeofence.getRadius()));
            r10.m("geoType", Integer.valueOf(r8.starGeofence.getGeoType().getValue()));
            r10.m("operation", Integer.valueOf(r8.operation));
            r10.m("timestamp", Long.valueOf(r8.timestamp));
            return r10;
        }

        @Override // com.obric.cae.location.report.StarLocationReportBase.ReportItem
        public void buildEvents() {
            Object r8 = this.this$0.mGeoLock;
            monitor-enter(r8);
        L22:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mGeofenceEvents.isEmpty() == true) goto L7;
        L10:
            ArrayList r10 = new ArrayList(this.this$0.mGeofenceEvents);     // Catch: Throwable -> L22
            this.this$0.mGeofenceEvents.clear();     // Catch: Throwable -> L22
            ArrayList r11 = new ArrayList(this.this$0.mBreachEvents.values());     // Catch: Throwable -> L22
            this.this$0.mBreachEvents.clear();     // Catch: Throwable -> L22
            monitor-exit(r8);     // Catch: Throwable -> L22
            s r12 = new s();
            m r13 = new m();
            Iterator r14 = r10.iterator();
        L14:
            if (r14.hasNext() == false) goto L16;
            r13.k(getGeoObj((StarLocationReportBase.InnerStarGeofenceEventData) r14.next()));
            goto L14
        L16:
            r12.k("geofences", r13);
            m r15 = new m();
            Iterator r16 = r11.iterator();
        L18:
            if (r16.hasNext() == false) goto L20;
            r15.k(getBreachObj((StarLocationReportBase.InnerBreachEventData) r16.next()));
            goto L18
        L20:
            r12.k("breachEvents", r15);
            StarLocationReportJson.access$000(this.this$0, ICaeUserAware.USER_AWARE_REPORT_STAR_GEOFENCE_INFO, new j().i(r12));
            return;
        L7:
            if (this.this$0.mBreachEvents.isEmpty() == false) goto L10;
            monitor-exit(r8);     // Catch: Throwable -> L22
        }
    }

    public class ZppReportItem extends StarLocationReportBase.ReportItem {
        final /* synthetic */ StarLocationReportJson this$0;

        public ZppReportItem(StarLocationReportJson r8) {
            this.this$0 = r8;
        }

        private s getZppObj(StarLocationReportBase.InnerZppSessionData r8) {
            s r10 = new s();
            r10.n("modelVersion", r8.modelVersion);
            m r11 = new m();
            Iterator<Long> r12 = r8.timestamps.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.l(r12.next());
            goto L4
        L6:
            r10.k("timestamps", r11);
            m r13 = new m();
            Iterator<Float> r14 = r8.confidences.iterator();
        L8:
            if (r14.hasNext() == false) goto L10;
            r13.l(r14.next());
            goto L8
        L10:
            r10.k("confidences", r13);
            m r15 = new m();
            Iterator<Float> r16 = r8.featureArrays.iterator();
        L12:
            if (r16.hasNext() == false) goto L14;
            r15.l(r16.next());
            goto L12
        L14:
            r10.k("featureArrays", r15);
            m r17 = new m();
            Iterator<Float> r18 = r8.evals.iterator();
        L16:
            if (r18.hasNext() == false) goto L18;
            r17.l(r18.next());
            goto L16
        L18:
            r10.k("evals", r17);
            r10.m("zppStrategy", Integer.valueOf(r8.zppStrategy));
            return r10;
        }

        @Override // com.obric.cae.location.report.StarLocationReportBase.ReportItem
        public void buildEvents() {
            Object r8 = this.this$0.mZppLock;
            monitor-enter(r8);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mReadyZppSessions.isEmpty() == false) goto L8;
            monitor-exit(r8);     // Catch: Throwable -> L15
            return;
        L8:
            ArrayList r10 = new ArrayList(this.this$0.mReadyZppSessions);     // Catch: Throwable -> L15
            this.this$0.mReadyZppSessions.clear();     // Catch: Throwable -> L15
            monitor-exit(r8);     // Catch: Throwable -> L15
            Iterator r11 = r10.iterator();
        L12:
            if (r11.hasNext() == false) goto L14;
            s r12 = getZppObj((StarLocationReportBase.InnerZppSessionData) r11.next());
            StarLocationReportJson.access$000(this.this$0, ICaeUserAware.USER_AWARE_REPORT_STAR_ZPP_INFO, new j().i(r12));
            goto L12
        }
    }

    private StarLocationReportJson(Context r8) {
        super(r8);
    }

    public static /* synthetic */ void access$000(StarLocationReportJson r8, String r10, String r11) {
        r8.notifyCallback(r10, r11);
    }

    public static /* synthetic */ void c(String r8, String r10, ICaeUserAwareCallback r11, Object r12) {
        lambda$notifyCallback$0(r8, r10, r11, r12);
    }

    public static StarLocationReportJson getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(StarLocationReportJson.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StarLocationReportJson(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(StarLocationReportJson.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static /* synthetic */ void lambda$notifyCallback$0(String r8, String r10, ICaeUserAwareCallback r11, Object r12) {
        r11.onUserAwareReportData(r8, r10);
    }

    private void notifyCallback(final String r8, final String r10) {
        CommSenseLog.d(TAG, "notifyCallback: eventName -- " + r8 + ", jsonData -- " + r10);     // Catch: Exception -> L5
        UserAwareManager.getInstance().notifyCallbacks(new b(r8, r10), null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "Error calling user aware report callback", e);
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
