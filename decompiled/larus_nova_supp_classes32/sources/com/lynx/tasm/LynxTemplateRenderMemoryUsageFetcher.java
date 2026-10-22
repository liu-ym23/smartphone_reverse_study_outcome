package com.lynx.tasm;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxTemplateRenderMemoryUsageFetcher extends t0 {
    public final WeakReference<LynxTemplateRender> a;

    public static final class InstanceMemoryUsageQuery {
        private long mBackgroundThreadRuntimeBytes;
        private String mBtsRuntimeGroupId;
        private com.lynx.tasm.base.e<r0> mCallback;
        private long mElementBytes;
        private long mElementNodeCount;
        private boolean mFinished;
        private final int mInstanceId;
        private long mMainThreadRuntimeBytes;
        private boolean mNativeDone;
        private final long mQueryStartMs;
        private final String mUrl;
        private long mViewBytes;
        private Map<String, a8a.a> mViewDetail;
        private boolean mViewDone;

        public static /* synthetic */ void a(InstanceMemoryUsageQuery r0, long r1, long r3, long r5, long r7, String r9) {
            r0.lambda$onNativeMemoryUsageResult$0(r1, r3, r5, r7, r9);
        }

        private void finishIfReady() {
            if (this.mFinished == false) goto L5;
            return;
        L5:
            if (this.mNativeDone == true) goto L7;
            return;
        L7:
            if (this.mViewDone == false) goto L19;
            TraceEvent.beginSection("TemplateRenderMemoryUsage.finish");
            this.mFinished = true;
            long r2 = this.mElementBytes;
            long r4 = this.mViewBytes;
            long r3 = r2 + r4;
            long r5 = this.mMainThreadRuntimeBytes;
            long r6 = r3 + r5;
            long r7 = this.mBackgroundThreadRuntimeBytes;
            long r20 = r6 + r7;
            r0 r8 = new r0(this.mInstanceId, this.mUrl, r20, r2, this.mElementNodeCount, r4, this.mViewDetail, r5, r7, this.mBtsRuntimeGroupId);
            if (TraceEvent.isTracingStarted() == false) goto L12;
            HashMap r9 = new HashMap();
            r9.put("instance_id", String.valueOf(this.mInstanceId));
            n0 r10 = n0.c;
            r9.put("duration_ms", String.valueOf(System.currentTimeMillis() - this.mQueryStartMs));
            r9.put("total_bytes", String.valueOf(r20));
            TraceEvent.instant(0, "TemplateRenderMemoryUsage.total", r9);
        L12:
            com.lynx.tasm.base.e<r0> r11 = this.mCallback;
            this.mCallback = null;
            TraceEvent.endSection("TemplateRenderMemoryUsage.finish");
            if (r11 == null) goto L18;
            r11.accept(r8);
            return;
        L18:
            return;
        }

        public void completeViewSnapshot(long r1, Map<String, a8a.a> r3) {
            this.mViewBytes = r1;
            if (r3 != null) goto L5;
        L8:
            Map<String, a8a.a> r2 = Collections.emptyMap();
        L9:
            this.mViewDetail = r2;
            this.mViewDone = true;
            finishIfReady();
            return;
        L5:
            if (r3.isEmpty() == true) goto L8;
            r2 = new HashMap(r3);
            goto L9
        }

        public InstanceMemoryUsageQuery(int r3, String r4, com.lynx.tasm.base.e<r0> r5) {
            n0 r0 = n0.c;
            this.mQueryStartMs = System.currentTimeMillis();
            this.mBtsRuntimeGroupId = NameKeys.UnloadStrategy_No_Strategy;
            this.mViewDetail = Collections.emptyMap();
            this.mInstanceId = r3;
            this.mUrl = r4;
            this.mCallback = r5;
        }

        private /* synthetic */ void lambda$onNativeMemoryUsageResult$0(long r2, long r4, long r6, long r8, String r10) {
            TraceEvent.beginSection("TemplateRenderMemoryUsage.nativeComplete");
            completeNativeSnapshot(r2, r4, r6, r8, r10);
            TraceEvent.endSection("TemplateRenderMemoryUsage.nativeComplete");
        }

        private void onNativeMemoryUsageResult(final long r14, final long r16, final long r18, final long r20, String r22) {
            if (r22 != null) goto L4;
            final String r11 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            TraceEvent.beginSection("TemplateRenderMemoryUsage.nativeCallback");
            LynxEventReporter.runOnReportThread(new n1(this, r14, r16, r18, r20, r11));
            TraceEvent.endSection("TemplateRenderMemoryUsage.nativeCallback");
            return;
        L4:
            r11 = r22;
            goto L5
        }

        public void completeNativeSnapshot(long r1, long r3, long r5, long r7, String r9) {
            this.mElementBytes = r1;
            this.mElementNodeCount = r3;
            this.mMainThreadRuntimeBytes = r5;
            this.mBackgroundThreadRuntimeBytes = r7;
            this.mBtsRuntimeGroupId = r9;
            this.mNativeDone = true;
            finishIfReady();
        }
    }

    public LynxTemplateRenderMemoryUsageFetcher(LynxTemplateRender r2) {
        this.a = new WeakReference(r2);
    }

    @Override // com.lynx.tasm.t0
    public final void a(l0 r7) {
        TraceEvent.beginSection("TemplateRenderMemoryUsage.query");
        LynxTemplateRender r1 = this.a.get();
        final LynxUIOwner r2 = null;
        if (r1 != null) goto L6;
        TraceEvent.endSection("TemplateRenderMemoryUsage.query");
        r7.accept(null);
        return;
    L6:
        LynxContext r3 = r1.getLynxContext();
        if (r3 != null) goto L9;
        int r4 = -1;
    L10:
        if (r3 != null) goto L12;
        String r5 = r1.getTemplateUrl();
    L13:
        if (r3 == null) goto L16;
        r2 = r3.getLynxUIOwner();
    L16:
        final InstanceMemoryUsageQuery r6 = new InstanceMemoryUsageQuery(r4, r5, r7);
        TraceEvent.beginSection("TemplateRenderMemoryUsage.dispatchNative");
        r1.queryNativeMemoryUsageForGlobalCollectorAsync(r6);
        TraceEvent.endSection("TemplateRenderMemoryUsage.dispatchNative");
        UIThreadUtils.runOnUiThread(new l1(r2, r6));
        TraceEvent.endSection("TemplateRenderMemoryUsage.query");
        return;
    L12:
        r5 = r3.getTemplateUrl();
        goto L13
    L9:
        r4 = r3.getInstanceId();
        goto L10
    }
}
