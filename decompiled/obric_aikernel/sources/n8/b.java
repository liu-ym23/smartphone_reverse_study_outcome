package n8;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f11272b = null;

    static {
        int[] r10 = new int[RunMode.values().length];
        f11271a = r10;
        r10[RunMode.PARALLEL.ordinal()] = 1;
        r10[RunMode.SERIAL.ordinal()] = 2;
        int[] r11 = new int[RepeatMode.values().length];
        f11272b = r11;
        r11[RepeatMode.LOOP.ordinal()] = 1;
        r11[RepeatMode.REVERSE.ordinal()] = 2;
        r11[RepeatMode.NORMAL.ordinal()] = 3;
    }
}
