package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StopWorkRunnable implements Runnable {
    private static final String TAG = null;
    private final boolean mStopInForeground;
    private final StartStopToken mToken;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        TAG = Logger.tagWithPrefix("StopWorkRunnable");
    }

    public StopWorkRunnable(@NonNull WorkManagerImpl r10, @NonNull StartStopToken r11, boolean r12) {
        this.mWorkManagerImpl = r10;
        this.mToken = r11;
        this.mStopInForeground = r12;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mStopInForeground == false) goto L5;
        boolean r10 = this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mToken);
    L6:
        Logger.get().debug(TAG, "StopWorkRunnable for " + this.mToken.getId().getWorkSpecId() + "; Processor.stopWork = " + r10);
        return;
    L5:
        r10 = this.mWorkManagerImpl.getProcessor().stopWork(this.mToken);
        goto L6
    }
}
