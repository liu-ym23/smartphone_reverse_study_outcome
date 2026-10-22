package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryNotLowTrackerKt {
    public static final float BATTERY_LOW_THRESHOLD = 0.15f;
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("BatteryNotLowTracker");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"BatteryNotLowTracker\")");
        TAG = r10;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }
}
