package androidx.work.impl.constraints;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class WorkConstraintsTrackerKt {
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = r10;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }
}
