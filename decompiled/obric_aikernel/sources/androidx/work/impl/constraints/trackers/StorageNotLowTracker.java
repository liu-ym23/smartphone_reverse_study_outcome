package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StorageNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    public StorageNotLowTracker(Context r10, TaskExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "taskExecutor");
        super(r10, r11);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        Intent r10 = getAppContext().registerReceiver(null, getIntentFilter());
        boolean r11 = false;
        if (r10 != null) goto L5;
    L18:
        r11 = true;
    L20:
        return Boolean.valueOf(r11);
    L5:
        if (r10.getAction() == null) goto L18;
        String r12 = r10.getAction();
        if (r12 == null) goto L20;
        int r13 = r12.hashCode();
        if (r13 != (-1181163412)) goto L12;
        r12.equals("android.intent.action.DEVICE_STORAGE_LOW");
        goto L20
    L12:
        if (r13 != (-730838620)) goto L20;
        if (r12.equals("android.intent.action.DEVICE_STORAGE_OK") == true) goto L18;
        goto L18
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.DEVICE_STORAGE_OK");
        r10.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return r10;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        if (r10.getAction() != null) goto L5;
        return;
    L5:
        Logger.get().debug(StorageNotLowTrackerKt.access$getTAG$p(), "Received " + r10.getAction());
        String r11 = r10.getAction();
        if (r11 == null) goto L22;
        int r12 = r11.hashCode();
        if (r12 == (-1181163412)) goto L17;
        if (r12 == (-730838620)) goto L13;
        return;
    L13:
        if (r11.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L24;
        Boolean r13 = Boolean.TRUE;
    L20:
        setState(r13);
        return;
    L24:
        return;
    L17:
        if (r11.equals("android.intent.action.DEVICE_STORAGE_LOW") == false) goto L25;
        r13 = Boolean.FALSE;
        goto L20
    L25:
        return;
    }
}
