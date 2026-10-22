package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.event.LynxTouchEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final String a;
    public final CardTemplateTagTone b;
    public final Integer c;
    public final Integer d;
    public final Function1<Context, Drawable> e;
    public final Integer f;
    public final String g;
    public final Function0<Unit> h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
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
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Function0<Unit> r17 = this.h;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardTemplateFootTag(text=" + this.a + ", tone=" + this.b + ", accentColor=" + this.c + ", iconRes=" + this.d + ", iconDrawableProvider=" + this.e + ", maxWidthDp=" + this.f + ", detailAnchor=" + this.g + ", onClick=" + this.h + ')';
    }

    public /* synthetic */ c(String r12, CardTemplateTagTone r13, Integer r14, hda.t0 r15, Integer r16, String r17, ida.h r18, int r19) {
        if ((r19 & 2) == 0) goto L5;
        CardTemplateTagTone r4 = CardTemplateTagTone.METRIC;
    L7:
        if ((r19 & 8) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r19 & 16) == 0) goto L13;
        hda.t0 r7 = null;
    L15:
        if ((r19 & 32) == 0) goto L17;
        Integer r8 = null;
    L19:
        if ((r19 & 64) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r19 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L25;
        ida.h r10 = null;
    L26:
        this(r12, r4, null, r6, r7, r8, r9, r10);
        return;
    L25:
        r10 = r18;
        goto L26
    L21:
        r9 = r17;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r2, CardTemplateTagTone r3, Integer r4, Integer r5, Function1<? super Context, ? extends Drawable> r6, Integer r7, String r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "tone");
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
