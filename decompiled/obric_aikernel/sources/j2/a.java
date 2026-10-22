package j2;

import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {
    private long mInitialDelay;
    private long mLoopInterval;
    private NetworkAsyncTaskType mTaskType;
    private TimeUnit mTimeUnit;

    public a() {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
    }

    public a(long r10) {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
        this.mLoopInterval = r10;
    }

    public a(long r10, long r11) {
        this(r11);
        this.mInitialDelay = r10;
    }

    public a(long r10, long r11, TimeUnit r12) {
        this(r10, r11);
        this.mTimeUnit = r12;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public NetworkAsyncTaskType getTaskType() {
        return this.mTaskType;
    }

    public TimeUnit getTimeUnit() {
        return this.mTimeUnit;
    }

    public boolean isLoop() {
        if (this.mLoopInterval <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setTaskType(NetworkAsyncTaskType r10) {
        this.mTaskType = r10;
    }
}
