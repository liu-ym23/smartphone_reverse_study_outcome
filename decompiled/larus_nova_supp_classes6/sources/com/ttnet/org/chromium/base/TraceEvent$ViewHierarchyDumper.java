package com.ttnet.org.chromium.base;

import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class TraceEvent$ViewHierarchyDumper implements MessageQueue.IdleHandler {
    private static final String EVENT_NAME = "TraceEvent.ViewHierarchyDumper";
    private static final long MIN_VIEW_DUMP_INTERVAL_MILLIS = 1000;
    private static boolean sEnabled;
    private static TraceEvent$ViewHierarchyDumper sInstance;
    private long mLastDumpTs;

    private TraceEvent$ViewHierarchyDumper() {
    }

    public static /* synthetic */ void a() {
        lambda$updateEnabledState$0();
    }

    private static void disable() {
        ThreadUtils.assertOnUiThread();
        if (sEnabled == false) goto L6;
        Looper.myQueue().removeIdleHandler(sInstance);
        sEnabled = false;
        return;
    }

    private static void enable() {
        ThreadUtils.assertOnUiThread();
        if (sEnabled == true) goto L6;
        Looper.myQueue().addIdleHandler(sInstance);
        sEnabled = true;
        return;
    }

    public static void updateEnabledState() {
        if (ThreadUtils.runningOnUiThread() == true) goto L7;
        ThreadUtils.postOnUiThread(new l());
        return;
    L7:
        if (TraceEventJni.get().viewHierarchyDumpEnabled() == false) goto L13;
        if (sInstance != null) goto L11;
        sInstance = new TraceEvent$ViewHierarchyDumper();
    L11:
        enable();
        return;
    L13:
        if (sInstance == null) goto L17;
        disable();
        return;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        long r0 = TimeUtils.elapsedRealtimeMillis();
        long r2 = this.mLastDumpTs;
        if (r2 != 0) goto L5;
    L6:
        this.mLastDumpTs = r0;
        TraceEventJni.get().initViewHierarchyDump();
        return true;
    L5:
        if ((r0 - r2) > 1000) goto L6;
        return true;
    }

    private static /* synthetic */ void lambda$updateEnabledState$0() {
        updateEnabledState();
    }

    public static /* synthetic */ void access$500(int r0, View r1, long r2) {
        dumpView(r0, r1, r2);
    }

    private static void dumpView(int r10, View r11, long r12) {
        ThreadUtils.assertOnUiThread();
        int r9 = r11.getId();
    L10:
        String r0 = "__name_not_found__";
    L11:
        String r6 = r0;
        TraceEventJni.get().addViewDump(r9, r10, r11.isShown(), r11.isDirty(), r11.getClass().getSimpleName(), r6, r12);
        if ((r11 instanceof ViewGroup) == false) goto L17;
        ViewGroup r13 = (ViewGroup) r11;
        int r14 = 0;
    L15:
        if (r14 >= r13.getChildCount()) goto L21;
        dumpView(r9, r13.getChildAt(r14), r12);
        r14 = r14 + 1;
        goto L15
    L21:
        return;
    L17:
        return;
    L4:
        if (r11.getResources() == null) goto L8;
        if (r9 == 0) goto L7;
        r0 = r11.getResources().getResourceName(r9);     // Catch: Resources.NotFoundException -> L10
        goto L11
    L7:
        r0 = "__no_id__";
        goto L11
    L8:
        r0 = "__no_resources__";
        goto L11
    }
}
