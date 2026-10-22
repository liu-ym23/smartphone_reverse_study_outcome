package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.y0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends j {
    public final int d;

    public i(c0 r5, Method r10, int r11) {
        super(r5, r10);
        this.d = r11;
    }

    @Override // com.lynx.tasm.behavior.utils.j
    public final Object a(y0 r5) {
        return Integer.valueOf(r5.c(this.f10795a, this.d));
    }

    public i(d0 r5, Method r10, int r11, int r12) {
        super(r5, r10, r11);
        this.d = r12;
    }
}
