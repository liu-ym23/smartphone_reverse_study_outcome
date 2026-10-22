package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference.PaintStyleViewHolder;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.ReferenceImageContainer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final int a;
    public final List<PaintStyleViewHolder.a> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "BgImageGenerateUIState(referenceImageUIState=" + this.a + ", paintStylesViewData=" + this.b + ')';
    }

    public d(@ReferenceImageContainer.ReferenceImageUIState int r2, List<PaintStyleViewHolder.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "paintStylesViewData");
        this.a = r2;
        this.b = r3;
    }
}
