package qa;

import android.text.TextUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements ThreadFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10709i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10710j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f10711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f10712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f10713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedBlockingQueue f10717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10718h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Thread.UncaughtExceptionHandler f10719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f10722d;

        public a() {
            this.f10721c = k1.f10709i;
            this.f10722d = 30;
        }
    }

    static {
        int r8 = Runtime.getRuntime().availableProcessors();
        f10709i = Math.max(2, Math.min(r8 - 1, 4));
        f10710j = (r8 * 2) + 1;
    }

    public k1(a r8) {
        this.f10712b = Executors.defaultThreadFactory();
        int r10 = r8.f10721c;
        this.f10715e = r10;
        int r11 = f10710j;
        this.f10716f = r11;
        if (r11 < r10) goto L11;
        this.f10718h = r8.f10722d;
        this.f10717g = new LinkedBlockingQueue(256);
        if (TextUtils.isEmpty(r8.f10720b) == false) goto L7;
        String r12 = "amap-threadpool";
    L8:
        this.f10714d = r12;
        this.f10713c = r8.f10719a;
        this.f10711a = new AtomicLong();
        return;
    L7:
        r12 = r8.f10720b;
        goto L8
    L11:
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        Thread r10 = this.f10712b.newThread(r8);
        String r11 = this.f10714d;
        if (r11 == null) goto L5;
        Long r12 = Long.valueOf(this.f10711a.incrementAndGet());
        r10.setName(String.format(defpackage.a.e(r11, "-%d"), new Object[]{r12}));
    L5:
        Thread.UncaughtExceptionHandler r13 = this.f10713c;
        if (r13 == null) goto L8;
        r10.setUncaughtExceptionHandler(r13);
    L8:
        return r10;
    }
}
