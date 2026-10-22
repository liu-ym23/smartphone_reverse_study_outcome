package com.obric.cae.userAware;

import android.os.Handler;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class GeofenceEventDelaySorter {
    private final long mDelayMs;
    private final EventDispatcher mDispatcher;
    private final FenceStateProvider mFenceStateProvider;
    private final Runnable mFlushRunnable;
    private final Handler mHandler;
    private final String mLogTag;
    private final ArrayList<Integer> mPending;

    public interface EventDispatcher {
        void dispatch(int r8);
    }

    public interface FenceStateProvider {
        int getFenceState();
    }

    public GeofenceEventDelaySorter(Handler r8, long r10, String r11, FenceStateProvider r12, EventDispatcher r13) {
        this.mPending = new ArrayList();
        this.mFlushRunnable = new g(this, 0);
        this.mHandler = r8;
        this.mDelayMs = r10;
        this.mLogTag = r11;
        this.mFenceStateProvider = r12;
        this.mDispatcher = r13;
    }

    public static /* synthetic */ void a(GeofenceEventDelaySorter r8) {
        r8.flushInternal();
    }

    private void flushInternal() {
        if (this.mPending.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r8 = new ArrayList(this.mPending);
        this.mPending.clear();
        if (r8.size() != 1) goto L9;
        this.mDispatcher.dispatch(((Integer) r8.get(0)).intValue());
        return;
    L9:
        int r10 = this.mFenceStateProvider.getFenceState();
        ArrayList<Integer> r11 = reorderGeofenceBatch(r8, r10);
        CommSenseLog.i(this.mLogTag, "[GeofenceDelay] batch size=" + r8.size() + ", fenceState=" + r10 + ", ordered=" + r11);
        Iterator<Integer> r12 = r11.iterator();
        Integer r13 = null;
    L11:
        if (r12.hasNext() == false) goto L20;
        Integer r14 = r12.next();
        if (r14 == null) goto L11;
        if (r13 == null) goto L19;
        if (r13.intValue() == r14.intValue()) goto L11;
    L19:
        this.mDispatcher.dispatch(r14.intValue());
        r13 = r14;
        goto L11
    }

    private static ArrayList<Integer> reorderGeofenceBatch(ArrayList<Integer> r8, int r10) {
        if (r8 == null) goto L34;
        if (r8.isEmpty() == true) goto L34;
        if (r10 != 3) goto L10;
        int r11 = 4;
    L13:
        if (r11 == (-1)) goto L15;
        ArrayList<Integer> r12 = new ArrayList(r8.size());
        Iterator<Integer> r13 = r8.iterator();
    L18:
        if (r13.hasNext() == false) goto L24;
        Integer r14 = r13.next();
        if (r14 == null) goto L18;
        if (r14.intValue() != r11) goto L18;
        r12.add(r14);
        goto L18
    L24:
        Iterator<Integer> r15 = r8.iterator();
    L26:
        if (r15.hasNext() == false) goto L32;
        Integer r16 = r15.next();
        if (r16 == null) goto L26;
        if (r16.intValue() == r11) goto L26;
        r12.add(r16);
        goto L26
    L32:
        return r12;
    L15:
        return new ArrayList(r8);
    L10:
        if (r10 != 1) goto L12;
        r11 = 2;
        goto L13
    L12:
        r11 = -1;
    L34:
        return new ArrayList();
    }

    public void onGeofenceEvent(int r8) {
        this.mPending.add(Integer.valueOf(r8));
        this.mHandler.removeCallbacks(this.mFlushRunnable);
        this.mHandler.postDelayed(this.mFlushRunnable, this.mDelayMs);
    }
}
