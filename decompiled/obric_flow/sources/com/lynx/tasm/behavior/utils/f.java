package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.y0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends j {
    public final boolean d;

    public f(c0 r5, Method r10, boolean r11) {
        super(r5, r10);
        this.d = r11;
    }

    @Override // com.lynx.tasm.behavior.utils.j
    public final Object a(y0 r5) {
        if (r5.e(this.f10795a, this.d) == false) goto L7;
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }
}
