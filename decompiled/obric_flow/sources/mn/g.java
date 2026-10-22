package mn;

import androidx.room.writer.DaoWriter;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f20130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20132c;

    public g(String r5, int r10) {
        this.f20131b = r5;
        this.f20132c = r10;
        this.f20130a = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r10 = new Thread(r5, this.f20131b + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + this.f20130a.getAndIncrement());
        if (r10.isDaemon() == false) goto L5;
        r10.setDaemon(false);
    L5:
        r10.setPriority(this.f20132c);
        r10.setUncaughtExceptionHandler(new f());
        return r10;
    }
}
