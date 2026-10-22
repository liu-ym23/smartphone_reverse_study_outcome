package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class StorageNotLowTrackerKt {
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("StorageNotLowTracker");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"StorageNotLowTracker\")");
        TAG = r10;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }
}
