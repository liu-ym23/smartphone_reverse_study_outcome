package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final float a;
    public final eab.e b;
    public final MovableRenderConfig c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MarkdownDocumentPreloadKey(widthDp=" + this.a + ", markdownNode=" + this.b + ", renderConfig=" + this.c + ')';
    }

    public a(float r2, eab.e r3, MovableRenderConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "markdownNode");
        Intrinsics.checkNotNullParameter(r4, "renderConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
