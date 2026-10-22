package com.bytedance.android.live.broadcast.rts;

import com.relax.relaxframework.ImageMode;
import com.relax.relaxframework.TapEvent;
import com.relax.relaxframework.p6;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public final String a;
    public final Function0<String> b;
    public final ArrayList<p6> c;
    public final ImageMode d;
    public final Function1<? super TapEvent, Unit> e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public j() {
        throw null;
    }

    public j(String r3, ArrayList r4, Function1 r5, int r6) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 16) == 0) goto L8;
        r5 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "src");
        this.a = r3;
        this.b = null;
        this.c = r4;
        this.d = null;
        this.e = r5;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }
}
