package com.bytedance.android.live.core.tetris.layer.core.element.container;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.e;
import k70.b;
import k70.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends b<j70.b> {
    public c b;
    public com.bytedance.android.live.core.tetris.layer.core.data.b c;
    public p70.b d;
    public b80.a e;

    public a() {
    }

    @Override // k70.b
    public final Element a(e r8) {
        j70.b r1 = (j70.b) r8;
        Intrinsics.checkNotNullParameter(r1, "attribute");
        c r2 = this.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        h70.b r3 = b();
        b80.a r4 = this.e;
        p70.b r5 = this.d;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("processChains");
    L8:
        com.bytedance.android.live.core.tetris.layer.core.data.b r6 = this.c;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L12:
        return new ContainerElement(r1, r2, r3, r4, r5, r6);
    }
}
