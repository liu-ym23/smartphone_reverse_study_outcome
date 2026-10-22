package i4;

import android.os.SystemClock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f8231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f8232b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f8233c = null;

    static {
        f8233c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        long r8 = (((SystemClock.elapsedRealtime() / 1000) * 100) + ((long) new SecureRandom().nextInt(99))) * 100000;
        f8231a = new AtomicLong(r8);
        f8232b = new AtomicLong(r8);
    }

    public static String a() {
        return f8233c.format(new Date());
    }
}
