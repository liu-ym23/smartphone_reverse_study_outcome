package o70;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final HashMap<Integer, LayerEventDispatcher> a = null;
    public static final HashMap<LayerEventDispatcher, Integer> b = null;
    public static final Object c = null;

    static {
        a = new HashMap();
        b = new HashMap();
        c = new Object();
    }

    @JvmStatic
    public static final LayerEventDispatcher a(Integer r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, LayerEventDispatcher> r0 = a;
        if (r0.containsKey(r3) == true) goto L15;
        Object r1 = c;
        monitor-enter(r1);
        LayerEventDispatcher r2 = new LayerEventDispatcher();     // Catch: Throwable -> L12
        r0.put(r3, r2);     // Catch: Throwable -> L12
        b.put(r2, r3);     // Catch: Throwable -> L12
        monitor-exit(r1);
        return r2;
    L12:
        th = move-exception;
        throw th;
    L15:
        LayerEventDispatcher r4 = r0.get(r3);
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
