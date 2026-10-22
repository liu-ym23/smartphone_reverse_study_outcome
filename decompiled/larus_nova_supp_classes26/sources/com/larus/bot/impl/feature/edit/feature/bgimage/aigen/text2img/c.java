package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final List<Text2BgImageBindingViewHolder.a> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIGenBgImageUIState(isLoadError=" + this.a + ", hasChosenImage=" + this.b + ", viewData=" + this.c + ')';
    }

    public c(boolean r2, boolean r3, List<Text2BgImageBindingViewHolder.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "viewData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static c a(c r2, boolean r3, List r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        boolean r0 = r2.a;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r3 = r2.b;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = r2.c;
    L12:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "viewData");
        return new c(r0, r3, r4);
    L5:
        r0 = false;
        goto L7
    }
}
