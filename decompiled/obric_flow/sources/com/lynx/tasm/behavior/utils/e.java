package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.y0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends j {
    public final /* synthetic */ int d;

    public /* synthetic */ e(c0 r5, Method r10, int r11) {
        this.d = r11;
        super(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.utils.j
    public final Object a(y0 r5) {
        switch(this.d) {
            case 0: goto L23;
            case 1: goto L15;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        String r10 = this.f10795a;
        return r5.f10815a.getString(r10);
    L6:
        String r11 = this.f10795a;
        return r5.f10815a.getMap(r11);
    L8:
        String r12 = this.f10795a;
        return r5.f10815a.getDynamic(r12);
    L10:
        ReadableMap r13 = r5.f10815a;
        String r14 = this.f10795a;
        if (r13.isNull(r14) == false) goto L25;
        return null;
    L25:
        return Integer.valueOf(r5.c(r14, 0));
    L15:
        ReadableMap r15 = r5.f10815a;
        String r16 = this.f10795a;
        if (r15.isNull(r16) == false) goto L18;
        return null;
    L18:
        if (r5.e(r16, false) == false) goto L27;
        return Boolean.TRUE;
    L27:
        return Boolean.FALSE;
    L23:
        String r17 = this.f10795a;
        return r5.f10815a.getArray(r17);
    }

    public /* synthetic */ e(d0 r5, Method r10, int r11, int r12) {
        this.d = r12;
        super(r5, r10, r11);
    }
}
