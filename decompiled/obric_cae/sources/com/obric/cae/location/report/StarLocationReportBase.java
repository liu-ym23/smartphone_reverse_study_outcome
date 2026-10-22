package com.obric.cae.location.report;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.activity.d;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.zpp.StarZppManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class StarLocationReportBase {
    protected static final int MSG_HANDLE_GEO_REPORT = 1;
    protected static final int MSG_HANDLE_PERIODIC_REPORT = 2;
    protected static final int MSG_HANDLE_ZPP_REPORT = 0;
    protected static final int PERIODIC_REPORT_INTERVAL_MINUTES = 120;
    protected final ConcurrentHashMap<Point, InnerBreachEventData> mBreachEvents;
    protected final Context mContext;
    protected InnerZppSessionData mCurrentZppSession;
    protected final Object mGeoLock;
    protected final List<InnerStarGeofenceEventData> mGeofenceEvents;
    protected Handler mHandler;
    protected final List<InnerZppSessionData> mReadyZppSessions;
    private ScheduledExecutorService mScheduledExecutorService;
    protected final Object mZppLock;

    public static class InnerBreachEventData {
        public long eventTimestamp;
        public final List<Integer> events;
        public final List<Boolean> firstBreaches;
        public final List<String> geofenceIds;
        public float hacc;
        public double latitude;
        public double longitude;
        public String provider;
        public final List<Float> responseRates;
        public int simCardStatus;
        public int source;

        public InnerBreachEventData(long r8, double r10, double r11, float r12, String r13, int r14, int r15) {
            this.geofenceIds = new ArrayList();
            this.events = new ArrayList();
            this.responseRates = new ArrayList();
            this.firstBreaches = new ArrayList();
            this.eventTimestamp = r8;
            this.latitude = r10;
            this.longitude = r11;
            this.hacc = r12;
            this.provider = r13;
            this.source = r14;
            this.simCardStatus = r15;
        }

        public void addGeofenceInfo(String r8, int r10, float r11, boolean r12) {
            this.geofenceIds.add(r8);
            this.events.add(Integer.valueOf(r10));
            this.responseRates.add(Float.valueOf(r11));
            this.firstBreaches.add(Boolean.valueOf(r12));
        }
    }

    public static class InnerStarGeofenceEventData {
        public int operation;
        public StarGeofence starGeofence;
        public long timestamp;

        public InnerStarGeofenceEventData(long r8, StarGeofence r10, int r11) {
            this.timestamp = r8;
            this.starGeofence = r10;
            this.operation = r11;
        }
    }

    public static class InnerZppSessionData {
        public List<Float> confidences;
        public List<Float> evals;
        public List<Float> featureArrays;
        public String modelVersion;
        public List<Long> timestamps;
        public int zppStrategy;

        public InnerZppSessionData(String r8) {
            this.timestamps = new ArrayList();
            this.confidences = new ArrayList();
            this.featureArrays = new ArrayList();
            this.evals = new ArrayList();
            this.modelVersion = r8;
        }

        public void addEvalData(StarZppManager.InnerStarZppData r8, float r10, int r11) {
            this.timestamps.add(Long.valueOf(r8.getTimestamp()));
            this.featureArrays.addAll(r8.getFeatureArray());
            this.confidences.add(Float.valueOf(r8.getConfidence()));
            this.evals.add(Float.valueOf(r8.getDistance()));
            this.evals.add(Float.valueOf(r10));
            this.zppStrategy = r11;
        }
    }

    public static class Point {
        public final double latitude;
        public final double longitude;

        public Point(double r8, double r10) {
            this.latitude = r8;
            this.longitude = r10;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r8.getClass()) goto L17;
            Point r10 = (Point) r8;
            if (Double.compare(r10.latitude, this.latitude) != 0) goto L16;
            if (Double.compare(r10.longitude, this.longitude) != 0) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Double.valueOf(this.latitude), Double.valueOf(this.longitude)});
        }
    }

    public static abstract class ReportItem {
        public ReportItem() {
        }

        public abstract void buildEvents();
    }

    public class ReportQueueProcessHandler extends Handler {
        private final List<ReportItem> mGeofenceReportItems;
        private final List<ReportItem> mZppReportItems;
        final /* synthetic */ StarLocationReportBase this$0;

        public ReportQueueProcessHandler(StarLocationReportBase r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
            this.mGeofenceReportItems = new ArrayList();
            this.mZppReportItems = new ArrayList();
        }

        @Override // android.os.Handler
        public synchronized void handleMessage(Message r8) {
            monitor-enter(this);
            int r10 = r8.what;     // Catch: Throwable -> L32
            if (r10 != 0) goto L8;
            List<ReportItem> r11 = this.mGeofenceReportItems;     // Catch: Throwable -> L32
            ReportItem r12 = this.this$0.createZppReportItem();     // Catch: Throwable -> L32
        L6:
            r11.add(r12);     // Catch: Throwable -> L32
        L30:
            monitor-exit(this);
            return;
        L8:
            if (r10 != 1) goto L11;
            r11 = this.mZppReportItems;     // Catch: Throwable -> L32
            r12 = this.this$0.createGeofenceReportItem();     // Catch: Throwable -> L32
            goto L6
        L11:
            if (r10 != 2) goto L30;
            if (this.mZppReportItems.isEmpty() == true) goto L22;
            Iterator<ReportItem> r13 = this.mZppReportItems.iterator();     // Catch: Throwable -> L32
        L16:
            if (r13.hasNext() == false) goto L20;
            ReportItem r14 = r13.next();     // Catch: Throwable -> L32
            if (r14 == null) goto L16;
            r14.buildEvents();     // Catch: Throwable -> L32
            goto L16
        L20:
            this.mZppReportItems.clear();     // Catch: Throwable -> L32
        L22:
            if (this.mGeofenceReportItems.isEmpty() == true) goto L30;
            Iterator<ReportItem> r15 = this.mGeofenceReportItems.iterator();     // Catch: Throwable -> L32
        L25:
            if (r15.hasNext() == false) goto L29;
            ReportItem r16 = r15.next();     // Catch: Throwable -> L32
            if (r16 == null) goto L25;
            r16.buildEvents();     // Catch: Throwable -> L32
            goto L25
        L29:
            this.mGeofenceReportItems.clear();     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;
        }
    }

    public StarLocationReportBase(Context r8) {
        this.mZppLock = new Object();
        this.mReadyZppSessions = new ArrayList();
        this.mGeoLock = new Object();
        this.mGeofenceEvents = new ArrayList();
        this.mBreachEvents = new ConcurrentHashMap();
        this.mContext = r8;
        initHandler();
        initPeriodicTask();
    }

    public static /* synthetic */ void a(StarLocationReportBase r8) {
        r8.executePeriodicTask();
    }

    public static /* synthetic */ Thread b(StarLocationReportBase r8, Runnable r10) {
        return r8.lambda$initPeriodicTask$0(r10);
    }

    private void executePeriodicTask() {
        sendReport(2);
    }

    private void initHandler() {
        HandlerThread r8 = new HandlerThread("star_location_report");
        r8.start();
        this.mHandler = new ReportQueueProcessHandler(this, r8.getLooper());
    }

    private void initPeriodicTask() {
        ScheduledExecutorService r8 = Executors.newScheduledThreadPool(1, new a(this));
        this.mScheduledExecutorService = r8;
        r8.scheduleWithFixedDelay(new d(this, 22), 1, 120, TimeUnit.MINUTES);
    }

    private /* synthetic */ Thread lambda$initPeriodicTask$0(Runnable r8) {
        return new Thread(r8, getTag() + "-Periodic");
    }

    public void cleanup() {
        ScheduledExecutorService r8 = this.mScheduledExecutorService;
        if (r8 == null) goto L5;
        r8.shutdownNow();
        this.mScheduledExecutorService = null;
    L5:
        Handler r10 = this.mHandler;
        if (r10 == null) goto L9;
        r10.removeCallbacksAndMessages(null);
        this.mHandler.getLooper().quitSafely();
        this.mHandler = null;
        return;
    }

    public abstract ReportItem createGeofenceReportItem();

    public abstract ReportItem createZppReportItem();

    public abstract String getTag();

    public void recordBreachEvent(long r19, Location r21, String r22, int r23, int r24, StarGeofence.GeoEvent r25, float r26, boolean r27) {
        double r8 = r21.getLatitude();
        double r10 = r21.getLongitude();
        Point r15 = new Point(r8, r10);
        Object r14 = this.mGeoLock;
        monitor-enter(r14);
        InnerBreachEventData r11 = this.mBreachEvents.get(r15);     // Catch: Throwable -> L15
        if (r11 == null) goto L11;
        if ((r19 - r11.eventTimestamp) >= 1000) goto L11;
        r11.addGeofenceInfo(r22, r25.getValue(), r26, r27);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r14);     // Catch: Throwable -> L19
        sendReport(1);
        return;
    L11:
        InnerBreachEventData r13 = new InnerBreachEventData(r19, r8, r10, r21.getAccuracy(), r21.getProvider(), r23, r24);     // Catch: Throwable -> L19
        r13.addGeofenceInfo(r22, r25.getValue(), r26, r27);     // Catch: Throwable -> L19
        this.mBreachEvents.put(r15, r13);     // Catch: Throwable -> L19
    L15:
        th = th;
    L17:
        monitor-exit(r14);     // Catch: Throwable -> L19
        throw th;
    L19:
        th = th;
        goto L17
    }

    public void recordStarGeofenceEvent(long r8, StarGeofence r10, int r11) {
        Object r12 = this.mGeoLock;
        monitor-enter(r12);
        this.mGeofenceEvents.add(new InnerStarGeofenceEventData(r8, r10, r11));     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
        sendReport(1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void reportStarZppEval(StarZppManager.InnerStarZppData r8, float r10, int r11) {
        Object r12 = this.mZppLock;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentZppSession != null) goto L7;
        this.mCurrentZppSession = new InnerZppSessionData(r8.getModelVersion());     // Catch: Throwable -> L11
    L7:
        this.mCurrentZppSession.addEvalData(r8, r10, r11);     // Catch: Throwable -> L11
        this.mReadyZppSessions.add(this.mCurrentZppSession);     // Catch: Throwable -> L11
        this.mCurrentZppSession = null;     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        sendReport(0);
    }

    public void sendReport(int r8) {
        Handler r10 = this.mHandler;
        if (r10 == null) goto L6;
        r10.sendEmptyMessage(r8);
        return;
    }
}
