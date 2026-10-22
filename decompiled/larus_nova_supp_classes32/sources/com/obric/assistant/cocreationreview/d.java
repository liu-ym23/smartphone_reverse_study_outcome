package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final String a;
    public final CardTemplateTagTone b;
    public final Integer c;
    public final Integer d;
    public final Function1<Context, Drawable> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Integer r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Function1<Context, Drawable> r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardTemplateTag(text=" + this.a + ", tone=" + this.b + ", accentColor=" + this.c + ", iconRes=" + this.d + ", iconDrawableProvider=" + this.e + ')';
    }

    public /* synthetic */ d(String r7, CardTemplateTagTone r8, Integer r9, Integer r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r8 = CardTemplateTagTone.NEUTRAL;
    L5:
        CardTemplateTagTone r2 = r8;
        if ((r11 & 4) == 0) goto L8;
        Integer r3 = null;
    L10:
        if ((r11 & 8) == 0) goto L12;
        Integer r4 = null;
    L13:
        this(r7, r2, r3, r4, null);
        return;
    L12:
        r4 = r10;
        goto L13
    L8:
        r3 = r9;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r2, CardTemplateTagTone r3, Integer r4, Integer r5, Function1<? super Context, ? extends Drawable> r6) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "tone");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
