package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final RunMode a;
    public final RepeatMode b;
    public final float c;
    public final float d;
    public final boolean e;

    public a(RunMode r2, RepeatMode r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "runMode");
        Intrinsics.checkNotNullParameter(r3, "repeatMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = false;
    }
}
