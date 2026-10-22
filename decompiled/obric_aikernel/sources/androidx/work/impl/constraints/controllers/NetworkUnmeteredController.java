package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    public NetworkUnmeteredController(ConstraintTracker<NetworkState> r10) {
        Intrinsics.checkNotNullParameter(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpec");
        NetworkType r11 = r10.constraints.getRequiredNetworkType();
        if (r11 != NetworkType.UNMETERED) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 30) goto L7;
    L9:
        return false;
    L7:
        if (r11 != NetworkType.TEMPORARILY_UNMETERED) goto L9;
        goto L9
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(NetworkState r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        if (r10.isConnected() == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.isMetered() == true) goto L8;
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(NetworkState r10) {
        return isConstrained2(r10);
    }
}
