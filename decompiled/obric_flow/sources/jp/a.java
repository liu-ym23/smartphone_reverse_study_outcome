package jp;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f18403b = null;

    static {
        int[] r5 = new int[RunMode.values().length];
        f18402a = r5;
        r5[RunMode.PARALLEL.ordinal()] = 1;
        r5[RunMode.SERIAL.ordinal()] = 2;
        int[] r10 = new int[RepeatMode.values().length];
        f18403b = r10;
        r10[RepeatMode.LOOP.ordinal()] = 1;
        r10[RepeatMode.REVERSE.ordinal()] = 2;
        r10[RepeatMode.NORMAL.ordinal()] = 3;
    }
}
