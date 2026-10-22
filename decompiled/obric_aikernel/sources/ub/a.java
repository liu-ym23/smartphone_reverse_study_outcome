package ub;

import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f13146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f13147b;

    static {
        new AtomicInteger(0);
    }

    public static void a() {
        HandlerThread r10 = f13146a;
        if (r10 == null) goto L6;
        r10.quit();
        f13147b.a();
        f13146a = null;
        f13147b = null;
        return;
    }
}
