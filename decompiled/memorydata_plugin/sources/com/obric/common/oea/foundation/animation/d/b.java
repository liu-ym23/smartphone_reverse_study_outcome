package com.obric.common.oea.foundation.animation.d;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f7707b = null;

    static {
        int[] r0 = new int[RunMode.values().length];
        f7706a = r0;
        r0[RunMode.PARALLEL.ordinal()] = 1;
        r0[RunMode.SERIAL.ordinal()] = 2;
        int[] r1 = new int[RepeatMode.values().length];
        f7707b = r1;
        r1[RepeatMode.LOOP.ordinal()] = 1;
        r1[RepeatMode.REVERSE.ordinal()] = 2;
        r1[RepeatMode.NORMAL.ordinal()] = 3;
    }
}
