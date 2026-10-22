package com.obric.cae.smartNetwork.netPolicy;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.EventsUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.network.NetpolicyEvents;
import defpackage.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class EventCache {
    private static final int CAE_NETWORK_POLICY_EVENT_ID = 124;
    private static final int EVENT_BATCH_THRESHOLD = 10;
    private static final long MAX_CACHE_DURATION_MS = 60000;
    private static final int MSG_CHECK_AND_REPORT = 1;
    private static final int MSG_CHECK_TIME_THRESHOLD = 2;
    private static final String TAG = null;
    private static volatile EventCache sInstance;
    private Context mContext;
    private List<NetpolicyEvents> mEventCache;
    private AtomicLong mEventCount;
    private AtomicLong mFirstEventTime;
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    static {
        TAG = "NetPolicyEventCache";
    }

    private EventCache(Context r8) {
        this.mEventCache = new CopyOnWriteArrayList();
        this.mFirstEventTime = new AtomicLong(0);
        this.mEventCount = new AtomicLong(0);
        this.mContext = r8.getApplicationContext();
        initHandler();
    }

    public static /* synthetic */ void access$000(EventCache r8) {
        r8.checkAndReportEvents();
    }

    private void checkAndReportEvents() {
        List<NetpolicyEvents> r8 = this.mEventCache;
        monitor-enter(r8);
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L21
        long r11 = this.mEventCount.get();     // Catch: Throwable -> L21
        long r12 = this.mFirstEventTime.get();     // Catch: Throwable -> L21
        boolean r13 = true;
        if (r11 < 10) goto L7;
        CaeLog.d(TAG, "Reporting events: reached event count threshold (" + r11 + ")");     // Catch: Throwable -> L21
        boolean r14 = true;
    L8:
        if (r14 == false) goto L10;
    L14:
        r13 = r14;
    L15:
        if (r13 == true) goto L17;
    L19:
        monitor-exit(r8);     // Catch: Throwable -> L21
        return;
    L17:
        if (this.mEventCache.isEmpty() == true) goto L19;
        reportEvents();     // Catch: Throwable -> L21
        clearCache();     // Catch: Throwable -> L21
        goto L19
    L10:
        if (r12 <= 0) goto L14;
        long r15 = r10 - r12;     // Catch: Throwable -> L21
        if (r15 < 60000) goto L14;
        CaeLog.d(TAG, "Reporting events: reached time duration threshold (" + r15 + "ms)");     // Catch: Throwable -> L21
        goto L15
    L7:
        r14 = false;
    L21:
        th = move-exception;
        throw th;
    }

    private void clearCache() {
        this.mEventCache.clear();
        this.mEventCount.set(0);
        this.mFirstEventTime.set(0);
        this.mHandler.removeMessages(2);
    }

    public static EventCache getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(EventCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new EventCache(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(EventCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initHandler() {
        HandlerThread r8 = new HandlerThread("EventCache");
        this.mHandlerThread = r8;
        r8.start();
        final Looper r10 = this.mHandlerThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r10);
    }

    private void reportEvents() {
        NetpolicyEvents.Builder r8 = NetpolicyEvents.newBuilder();     // Catch: Exception -> L8
        Iterator<NetpolicyEvents> r10 = this.mEventCache.iterator();     // Catch: Exception -> L8
    L4:
        if (r10.hasNext() == false) goto L6;
        NetpolicyEvents r11 = r10.next();     // Catch: Exception -> L8
        r8.addAllUidRulesChangedEvents(r11.getUidRulesChangedEventsList());     // Catch: Exception -> L8
        r8.addAllMeteredIfacesChangedEvents(r11.getMeteredIfacesChangedEventsList());     // Catch: Exception -> L8
        r8.addAllRestrictBackgroundChangedEvents(r11.getRestrictBackgroundChangedEventsList());     // Catch: Exception -> L8
        r8.addAllUidPoliciesChangedEvents(r11.getUidPoliciesChangedEventsList());     // Catch: Exception -> L8
        r8.addAllSubscriptionOverrideChangedEvents(r11.getSubscriptionOverrideChangedEventsList());     // Catch: Exception -> L8
        r8.addAllSubscriptionPlansChangedEvents(r11.getSubscriptionPlansChangedEventsList());     // Catch: Exception -> L8
        r8.addAllBlockedReasonChangedEvents(r11.getBlockedReasonChangedEventsList());     // Catch: Exception -> L8
        r8.addAllPowerStateEvents(r11.getPowerStateEventsList());     // Catch: Exception -> L8
        r8.addAllAppNetOpChangedEvents(r11.getAppNetOpChangedEventsList());     // Catch: Exception -> L8
        r8.addAllSleepModeChangedEvents(r11.getSleepModeChangedEventsList());     // Catch: Exception -> L8
        goto L4
    L6:
        EventsUtils.writePbEvent(System.currentTimeMillis(), CAE_NETWORK_POLICY_EVENT_ID, r8.build().toByteArray());     // Catch: Exception -> L8
        CaeLog.d(TAG, "Reported " + this.mEventCache.size() + " NetpolicyEvents messages");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.k(e, new StringBuilder("reportEvents failed: "), TAG);
    }

    public void addEventToCache(NetpolicyEvents r8) {
        List<NetpolicyEvents> r10 = this.mEventCache;
        monitor-enter(r10);
        this.mEventCache.add(r8);     // Catch: Throwable -> L10
        this.mEventCount.incrementAndGet();     // Catch: Throwable -> L10
        if (this.mFirstEventTime.get() != 0) goto L7;
        this.mFirstEventTime.set(System.currentTimeMillis());     // Catch: Throwable -> L10
        this.mHandler.sendEmptyMessageDelayed(2, 60000);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L10
        this.mHandler.sendEmptyMessage(1);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void flush() {
        List<NetpolicyEvents> r8 = this.mEventCache;
        monitor-enter(r8);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mEventCache.isEmpty() == true) goto L7;
        reportEvents();     // Catch: Throwable -> L9
        clearCache();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L9
    }
}
