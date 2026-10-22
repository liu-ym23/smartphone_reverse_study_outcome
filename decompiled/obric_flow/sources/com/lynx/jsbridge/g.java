package com.lynx.jsbridge;

import android.os.Handler;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.ui.y;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f9912c;
    public final /* synthetic */ LynxExposureModule d;

    public /* synthetic */ g(LynxExposureModule r5, com.lynx.tasm.behavior.f r10, ReadableMap r11, int r12) {
        this.f9911b = r12;
        this.d = r5;
        this.f9912c = r11;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        switch(this.f9911b) {
            case 0: goto L32;
            default: goto L4;
        };
    L4:
        y r5 = this.d.mLynxContext.f10155x;
        if (r5 == null) goto L36;
        ReadableMap r10 = this.f9912c;
        if (r10 == null) goto L41;
        int r11 = -1;
        if (r10.hasKey("forExposureCheck") == false) goto L12;
        int r12 = r10.getInt("forExposureCheck");
    L14:
        if (r12 <= 0) goto L17;
        r5.g = Math.max(16, 1000 / r12);
    L17:
        if (r10.hasKey("forPageRect") == false) goto L19;
        r11 = r10.getInt("forPageRect");
    L19:
        if (r11 >= 0) goto L21;
        return;
    L21:
        if (r11 == 0) goto L23;
        long r13 = Math.max(16, 1000 / r11);
    L24:
        r5.f10207n = r13;
        if (r13 == 0) goto L38;
        Handler r14 = r5.f10204k;
        if (r14 == null) goto L39;
        a0 r15 = r5.f10205l;
        if (r15 == null) goto L40;
        r14.postDelayed(r15, r13);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L23:
        r13 = 0;
        goto L24
    L12:
        r12 = -1;
        goto L14
    L41:
        return;
    L36:
        return;
    L32:
        y r16 = this.d.mLynxContext.f10155x;
        if (r16 == null) goto L42;
        r16.k(this.f9912c.asHashMap());
        return;
    }
}
