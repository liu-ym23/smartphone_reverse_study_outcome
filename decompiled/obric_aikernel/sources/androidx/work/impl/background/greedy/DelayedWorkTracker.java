package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayedWorkTracker {
    static final String TAG = null;
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables;

    static {
        TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    }

    public DelayedWorkTracker(@NonNull GreedyScheduler r10, @NonNull RunnableScheduler r11) {
        this.mGreedyScheduler = r10;
        this.mRunnableScheduler = r11;
        this.mRunnables = new HashMap();
    }

    public void schedule(@NonNull final WorkSpec r10) {
        Runnable r11 = this.mRunnables.remove(r10.id);
        if (r11 == null) goto L5;
        this.mRunnableScheduler.cancel(r11);
    L5:
        Runnable r12 = new AnonymousClass1(this, r10);
        this.mRunnables.put(r10.id, r12);
        long r13 = System.currentTimeMillis();
        long r14 = r10.calculateNextRunTime() - r13;
        this.mRunnableScheduler.scheduleWithDelay(r14, r12);
    }

    public void unschedule(@NonNull String r10) {
        Runnable r11 = this.mRunnables.remove(r10);
        if (r11 == null) goto L6;
        this.mRunnableScheduler.cancel(r11);
        return;
    }
}
