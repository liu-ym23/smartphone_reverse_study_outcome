package g98;

import com.larus.audio.call.o;
import com.larus.avlink.env.DoraEnvObserveState;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static o a;
    public static volatile o b;
    public static volatile f c;
    public static volatile long d;
    public static volatile String e;
    public static final LinkedHashMap<String, Integer> f = null;
    public static final Object g = null;
    public static e h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DoraEnvObserveState.values().length];
            r0[DoraEnvObserveState.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r0[DoraEnvObserveState.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            a = r0;
            int[] r1 = new int[EnvObserveChangeReason.values().length];
            r1[EnvObserveChangeReason.CONNECT_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
        f = new LinkedHashMap();
        g = new Object();
    }

    public static void a(final f r3) {
        FLogger.a.i("DoraEnvObserveManager", "onEnvObserveStateEvent event: " + r3);
        t0.a(new g98.a(r3));
    }

    public static void b(Integer r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.intValue() <= 0) goto L32;
        Object r0 = g;
        monitor-enter(r0);
        String r1 = e;     // Catch: Throwable -> L24
        if (r1 != null) goto L12;
        monitor-exit(r0);
        return;
    L12:
        LinkedHashMap<String, Integer> r2 = f;     // Catch: Throwable -> L24
        if (r2.containsKey(r1) == true) goto L21;
        r2.put(r1, r4);     // Catch: Throwable -> L24
    L15:
        LinkedHashMap<String, Integer> r5 = f;     // Catch: Throwable -> L24
        if (r5.size() <= 16) goto L21;
        String r3 = (String) CollectionsKt.firstOrNull(r5.keySet());     // Catch: Throwable -> L24
        if (r3 == null) goto L21;
        r5.remove(r3);     // Catch: Throwable -> L24
    L21:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r0);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
