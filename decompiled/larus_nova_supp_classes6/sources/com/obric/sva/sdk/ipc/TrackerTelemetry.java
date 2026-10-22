package com.obric.sva.sdk.ipc;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackerTelemetry;", "", "<init>", "()V", "TAG", "", "onTrackerAttach", "", "generation", "", "reason", "onTrackerDetach", "onGateFailOpen", "gateType", "onGateUpdate", "enabled", "", "onTruthCaptureCallFailed", "cause", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TrackerTelemetry {
    public static final TrackerTelemetry INSTANCE = null;
    private static final String TAG = "TrackerTelemetry";

    static {
        INSTANCE = new TrackerTelemetry();
    }

    private TrackerTelemetry() {
    }

    public final void onTruthCaptureCallFailed(String r3) {
        Intrinsics.checkNotNullParameter(r3, "cause");
        LogUtils.w(TAG, "wakeup_truth_capture provider call failed cause=" + r3, new Object[0]);
    }

    public final void onGateFailOpen(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "gateType");
        Intrinsics.checkNotNullParameter(r4, "reason");
        LogUtils.w(TAG, "gate_fail_open type=" + r3 + " reason=" + r4, new Object[0]);
    }

    public final void onTrackerAttach(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        LogUtils.i(TAG, "tracker_attach generation=" + r3 + " reason=" + r5, new Object[0]);
    }

    public final void onTrackerDetach(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        LogUtils.i(TAG, "tracker_detach generation=" + r3 + " reason=" + r5, new Object[0]);
    }

    public final void onGateUpdate(String r3, boolean r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "gateType");
        LogUtils.i(TAG, "gate_update type=" + r3 + " enabled=" + r4 + " generation=" + r5, new Object[0]);
    }
}
