package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkMeteredController extends ConstraintController<NetworkState> {
    public static final Companion Companion = null;
    private static final String TAG = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        String r10 = Logger.tagWithPrefix("NetworkMeteredCtrlr");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        TAG = r10;
    }

    public NetworkMeteredController(ConstraintTracker<NetworkState> r10) {
        Intrinsics.checkNotNullParameter(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpec");
        if (r10.constraints.getRequiredNetworkType() != NetworkType.METERED) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isConstrained, reason: avoid collision after fix types in other method */
    public boolean isConstrained2(NetworkState r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        Logger.get().debug(TAG, "Metered network constraint is not supported before API 26, only checking for connected state.");
        if (r10.isConnected() == false) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (r10.isConnected() == false) goto L12;
        if (r10.isMetered() == false) goto L12;
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean isConstrained(NetworkState r10) {
        return isConstrained2(r10);
    }
}
