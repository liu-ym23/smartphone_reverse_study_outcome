package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkConnectedController extends ConstraintController<NetworkState> {
    public NetworkConnectedController(ConstraintTracker<NetworkState> r10) {
        Intrinsics.checkNotNullParameter(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpec");
        if (r10.constraints.getRequiredNetworkType() != NetworkType.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(NetworkState r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        if (Build.VERSION.SDK_INT < 26) goto L10;
        if (r10.isConnected() == true) goto L7;
        return true;
    L7:
        if (r10.isValidated() == true) goto L13;
        return true;
    L13:
        return false;
    L10:
        if (r10.isConnected() == true) goto L13;
        return true;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(NetworkState r10) {
        return isConstrained2(r10);
    }
}
