package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public final float a;
    public final eab.e b;
    public final String c;
    public final MovableRenderConfig d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        MovableRenderConfig r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownRenderKey(widthDp=" + this.a + ", markdownNode=" + this.b + ", urlPreviewInlineDigest=" + this.c + ", renderConfig=" + this.d + ')';
    }

    public h(float r2, eab.e r3, String r4, MovableRenderConfig r5) {
        Intrinsics.checkNotNullParameter(r3, "markdownNode");
        Intrinsics.checkNotNullParameter(r4, "urlPreviewInlineDigest");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
