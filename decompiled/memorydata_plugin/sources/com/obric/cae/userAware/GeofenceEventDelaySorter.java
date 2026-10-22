package com.obric.cae.userAware;

import android.os.Handler;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class GeofenceEventDelaySorter {
    private final long mDelayMs;
    private final EventDispatcher mDispatcher;
    private final FenceStateProvider mFenceStateProvider;
    private final Runnable mFlushRunnable;
    private final Handler mHandler;
    private final String mLogTag;
    private final ArrayList<Integer> mPending;

    public interface EventDispatcher {
        void dispatch(int r1);
    }

    public interface FenceStateProvider {
        int getFenceState();
    }

    public GeofenceEventDelaySorter(Handler r3, long r4, String r6, FenceStateProvider r7, EventDispatcher r8) {
        FenceStateProvider r9 = (FenceStateProvider) ZeusTransformUtils.wrapperContextForParams(r7, FenceStateProvider.class, "com.obric.memorydata.plugin");
        EventDispatcher r10 = (EventDispatcher) ZeusTransformUtils.wrapperContextForParams(r8, EventDispatcher.class, "com.obric.memorydata.plugin");
        this.mPending = new ArrayList();
        this.mFlushRunnable = new $$Lambda$GeofenceEventDelaySorter$JS0zVXbnAgSO_ZiZD6msWS6aCw(this);
        this.mHandler = r3;
        this.mDelayMs = r4;
        this.mLogTag = r6;
        this.mFenceStateProvider = r9;
        this.mDispatcher = r10;
    }

    private void flushInternal() {
        if (this.mPending.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.mPending);
        this.mPending.clear();
        if (r0.size() != 1) goto L9;
        this.mDispatcher.dispatch(((Integer) ZeusTransformUtils.preCheckCast(r0.get(0), Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L9:
        int r1 = this.mFenceStateProvider.getFenceState();
        ArrayList<Integer> r2 = reorderGeofenceBatch(r0, r1);
        a.e(this.mLogTag, "[GeofenceDelay] batch size=" + r0.size() + ", fenceState=" + r1 + ", ordered=" + r2);
        Integer r3 = null;
        Iterator<Integer> r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L20;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        if (r3 == null) goto L19;
        if (r3.intValue() == r5.intValue()) goto L11;
    L19:
        this.mDispatcher.dispatch(r5.intValue());
        r3 = r5;
        goto L11
    }

    /* JADX INFO: renamed from: lambda$JS0zVXbnAgS-O_ZiZD6msWS6aCw, reason: not valid java name */
    public static /* synthetic */ void m402lambda$JS0zVXbnAgSO_ZiZD6msWS6aCw(GeofenceEventDelaySorter r0) {
        r0.flushInternal();
    }

    private static ArrayList<Integer> reorderGeofenceBatch(ArrayList<Integer> r5, int r6) {
        if (r5 == null) goto L34;
        if (r5.isEmpty() == true) goto L34;
        if (r6 != 3) goto L10;
        int r7 = 4;
    L13:
        if (r7 == (-1)) goto L15;
        ArrayList<Integer> r0 = new ArrayList(r5.size());
        Iterator<Integer> r1 = r5.iterator();
    L18:
        if (r1.hasNext() == false) goto L24;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        if (r2.intValue() != r7) goto L18;
        r0.add(r2);
        goto L18
    L24:
        Iterator<Integer> r8 = r5.iterator();
    L26:
        if (r8.hasNext() == false) goto L32;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r8.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L26;
        if (r3.intValue() == r7) goto L26;
        r0.add(r3);
        goto L26
    L32:
        return r0;
    L15:
        return new ArrayList(r5);
    L10:
        if (r6 != 1) goto L12;
        r7 = 2;
        goto L13
    L12:
        r7 = -1;
    L34:
        return new ArrayList();
    }

    public void onGeofenceEvent(int r4) {
        this.mPending.add(Integer.valueOf(r4));
        this.mHandler.removeCallbacks(this.mFlushRunnable);
        this.mHandler.postDelayed(this.mFlushRunnable, this.mDelayMs);
    }
}
