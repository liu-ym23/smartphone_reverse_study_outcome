package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final UrlPreviewCardType a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "PreviewRenderKey(cardType=" + this.a + ", maxWidth=" + this.b + ')';
    }

    public g(UrlPreviewCardType r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "cardType");
        this.a = r2;
        this.b = r3;
    }
}
