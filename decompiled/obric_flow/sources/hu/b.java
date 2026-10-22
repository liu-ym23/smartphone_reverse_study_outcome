package hu;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f17472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f17473b = null;

    static {
        int r5 = Math.max(Runtime.getRuntime().availableProcessors(), 2);
        new ConcurrentHashMap();
        f17472a = new ThreadPoolExecutor(r5, r5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f17473b = new c(Looper.getMainLooper());
        HandlerThread r10 = new HandlerThread("UiThreadHelper", -2);
        r10.start();
        new c(r10.getLooper());
        HandlerThread r11 = new HandlerThread("launcher-loader", 0);
        r11.start();
        new c(r11.getLooper());
    }
}
