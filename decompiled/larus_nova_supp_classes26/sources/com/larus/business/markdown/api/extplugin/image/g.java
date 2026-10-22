package com.larus.business.markdown.api.extplugin.image;

import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final View a;
    public final TextView b;
    public final c c;
    public final List<Pair<Integer, View>> d;
    public final List<f> e;
    public final AtomicInteger f;
    public final int g;
    public final int h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g) * 31) + this.h;
    }

    public final String toString() {
        return "ImageLoaderInfo(imageView=" + this.a + ", textView=" + this.b + ", span=" + this.c + ", imageViewList=" + this.d + ", imageInfoList=" + this.e + ", imageIndex=" + this.f + ", targetWidth=" + this.g + ", targetHeight=" + this.h + ')';
    }

    public g(SimpleDraweeView r2, TextView r3, c r4, List r5, List r6, AtomicInteger r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, "span");
        Intrinsics.checkNotNullParameter(r5, "imageViewList");
        Intrinsics.checkNotNullParameter(r6, "imageInfoList");
        Intrinsics.checkNotNullParameter(r7, "imageIndex");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
