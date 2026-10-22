package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.y0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends j {
    public final float d;

    public h(c0 r5, Method r10, float r11) {
        super(r5, r10);
        this.d = r11;
    }

    @Override // com.lynx.tasm.behavior.utils.j
    public final Object a(y0 r5) {
        String r10 = this.f10795a;
        return Float.valueOf(r5.b(this.d, r10));
    }

    public h(d0 r5, Method r10, int r11, float r12) {
        super(r5, r10, r11);
        this.d = r12;
    }
}
