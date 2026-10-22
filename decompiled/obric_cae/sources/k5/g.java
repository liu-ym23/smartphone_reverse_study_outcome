package k5;

import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicInteger;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f8936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f8937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile r5.e.a f8938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f8939e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8940a;

    static {
        f8938d = r5.e.a.f11508n;
        f8939e = new AtomicInteger(0);
    }

    public g(Context r8) {
        this.f8940a = r8;
        int r10 = r.f13543a;
        f8938d = r5.e.d(r8);
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        f8936b = new f(this);
        r8.registerReceiver(f8936b, r11);
    }
}
