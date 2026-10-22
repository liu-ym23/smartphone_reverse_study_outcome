package sna;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public static final h a = null;
    public static final Lazy b = null;

    public h() {
    }

    static {
        a = new h();
        b = LazyKt.lazy(new g());
    }

    public static Keva a() {
        return (Keva) b.getValue();
    }

    public static void b(String r2) {
        FLogger.a.i("WakeupCacheManager", r2);
    }
}
