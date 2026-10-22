package com.bytedance.android.live.core.tetris.layer.core.element.tetris;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.e;
import j70.k;
import k70.b;
import k70.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends b<k> {
    public c b;
    public com.bytedance.android.live.core.tetris.layer.core.data.b c;
    public p70.b d;

    public a() {
    }

    @Override // k70.b
    public final Element a(e r8) {
        k r1 = (k) r8;
        Intrinsics.checkNotNullParameter(r1, "attribute");
        if (r1.v() == false) goto L15;
        c r4 = this.b;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L7:
        h70.b r3 = b();
        com.bytedance.android.live.core.tetris.layer.core.data.b r5 = this.c;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L10:
        p70.b r6 = this.d;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("processChains");
    L13:
        Element r9 = new ServiceTetrisElement(r1, r4, r3, r6, r5);
    L36:
        return r9;
    L15:
        if (r1.k() == false) goto L26;
        c r7 = this.b;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L19:
        h70.b r11 = b();
        com.bytedance.android.live.core.tetris.layer.core.data.b r12 = this.c;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L22:
        p70.b r13 = this.d;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("processChains");
    L25:
        r9 = new RecyclableTetrisElement(r1, r7, r11, r13, r12);
        goto L36
    L26:
        c r14 = this.b;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L29:
        h70.b r15 = b();
        com.bytedance.android.live.core.tetris.layer.core.data.b r16 = this.c;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L32:
        p70.b r17 = this.d;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("processChains");
    L35:
        r9 = new TetrisElement(r1, r14, r15, r17, r16);
        goto L36
    }
}
