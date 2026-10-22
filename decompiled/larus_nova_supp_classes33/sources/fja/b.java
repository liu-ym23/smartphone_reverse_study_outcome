package fja;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[RunMode.values().length];
        a = r0;
        r0[RunMode.PARALLEL.ordinal()] = 1;
        r0[RunMode.SERIAL.ordinal()] = 2;
        int[] r1 = new int[RepeatMode.values().length];
        b = r1;
        r1[RepeatMode.LOOP.ordinal()] = 1;
        r1[RepeatMode.REVERSE.ordinal()] = 2;
        r1[RepeatMode.NORMAL.ordinal()] = 3;
    }
}
