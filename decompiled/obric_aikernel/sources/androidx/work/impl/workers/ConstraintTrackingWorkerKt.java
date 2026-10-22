package androidx.work.impl.workers;

import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorkerKt {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("ConstraintTrkngWrkr");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"ConstraintTrkngWrkr\")");
        TAG = r10;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ boolean access$setFailed(SettableFuture r10) {
        return setFailed(r10);
    }

    public static final /* synthetic */ boolean access$setRetry(SettableFuture r10) {
        return setRetry(r10);
    }

    private static final boolean setFailed(SettableFuture<ListenableWorker.Result> r10) {
        return r10.set(ListenableWorker.Result.failure());
    }

    private static final boolean setRetry(SettableFuture<ListenableWorker.Result> r10) {
        return r10.set(ListenableWorker.Result.retry());
    }
}
