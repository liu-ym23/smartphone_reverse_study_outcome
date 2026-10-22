package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sq9.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public final PreviewScene a;
    public final ToolbarLayoutMode b;
    public final ToolbarVisualStyle c;
    public final boolean d;
    public final Function1<SourceType, a0> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.g == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.h == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.i == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.j == true) goto L27;
        r2 = 1237;
    L27:
        return r11 + r2;
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreviewSourcePolicy(scene=" + this.a + ", layoutMode=" + this.b + ", visualStyle=" + this.c + ", publishInSharePanel=" + this.d + ", toolPresentation=" + this.e + ", preserveToolPresentationForLocalMedia=" + this.f + ", showBottom=" + this.g + ", showSideBar=" + this.h + ", showPlusButton=" + this.i + ", attachCurrentImageFromAlbum=" + this.j + ')';
    }

    public r(PreviewScene r2, ToolbarLayoutMode r3, ToolbarVisualStyle r4, boolean r5, Function1 r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutMode");
        Intrinsics.checkNotNullParameter(r4, "visualStyle");
        Intrinsics.checkNotNullParameter(r6, "toolPresentation");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = true;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
