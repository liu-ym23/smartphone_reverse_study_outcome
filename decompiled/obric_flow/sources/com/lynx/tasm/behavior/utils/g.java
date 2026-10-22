package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.y0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends j {
    public final double d;

    public g(c0 r5, Method r10, double r11) {
        super(r5, r10);
        this.d = r11;
    }

    @Override // com.lynx.tasm.behavior.utils.j
    public final Object a(y0 r5) {
        return Double.valueOf(r5.a(this.f10795a, this.d));
    }

    public g(d0 r5, Method r10, int r11, double r12) {
        super(r5, r10, r11);
        this.d = r12;
    }
}
