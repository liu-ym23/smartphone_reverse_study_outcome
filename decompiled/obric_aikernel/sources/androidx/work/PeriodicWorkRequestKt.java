package androidx.work;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long r10, TimeUnit r11) {
        Intrinsics.checkNotNullParameter(r11, "repeatIntervalTimeUnit");
        Intrinsics.reifiedOperationMarker(4, "W");
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, r10, r11);
    }

    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long r10, TimeUnit r11, long r12, TimeUnit r14) {
        Intrinsics.checkNotNullParameter(r11, "repeatIntervalTimeUnit");
        Intrinsics.checkNotNullParameter(r14, "flexTimeIntervalUnit");
        Intrinsics.reifiedOperationMarker(4, "W");
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, r10, r11, r12, r14);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration r10) {
        Intrinsics.checkNotNullParameter(r10, "repeatInterval");
        Intrinsics.reifiedOperationMarker(4, "W");
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, r10);
    }

    @RequiresApi(26)
    public static final /* synthetic */ <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration r10, Duration r11) {
        Intrinsics.checkNotNullParameter(r10, "repeatInterval");
        Intrinsics.checkNotNullParameter(r11, "flexTimeInterval");
        Intrinsics.reifiedOperationMarker(4, "W");
        return new PeriodicWorkRequest.Builder(ListenableWorker.class, r10, r11);
    }
}
