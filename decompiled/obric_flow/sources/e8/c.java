package e8;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ThreadFactory {
    public static final AtomicInteger d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f16782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16784c;

    static {
        d = new AtomicInteger(1);
    }

    public c(String r5) {
        this.f16783b = new AtomicInteger(1);
        SecurityManager r10 = System.getSecurityManager();
        if (r10 == null) goto L5;
        ThreadGroup r11 = r10.getThreadGroup();
    L6:
        this.f16782a = r11;
        StringBuilder r12 = j0.w(r5, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r12.append(d.getAndIncrement());
        r12.append("-Thread-");
        this.f16784c = r12.toString();
        return;
    L5:
        r11 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r10) {
        Thread r11 = new Thread(this.f16782a, r10, this.f16784c + this.f16783b.getAndIncrement(), 0);
        if (r11.isDaemon() == false) goto L6;
        r11.setDaemon(false);
    L6:
        if (r11.getPriority() == 5) goto L8;
        r11.setPriority(5);
    L8:
        return r11;
    }
}
