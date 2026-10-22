package com.obric.assistant.settings;

import android.view.View;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g1 extends q0 {
    public final String a;
    public final CharSequence b;
    public final CharSequence c;
    public boolean d;
    public final Function2<Boolean, View, Unit> e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final boolean j;
    public final String k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r6 = (g1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        CharSequence r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.d == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        if (this.g == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.h;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.i;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        if (this.j == true) goto L30;
        r5 = 1237;
    L30:
        int r18 = (r17 + r5) * 31;
        String r19 = this.k;
        if (r19 == null) goto L35;
        r2 = r19.hashCode();
    L35:
        return r18 + r2;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SwitchUiModel(id=" + this.a + ", title=" + this.b + ", subtitle=" + this.c + ", isChecked=" + this.d + ", onCheckedChange=" + this.e + ", showRedPot=" + this.f + ", beta=" + this.g + ", titleTagText=" + this.h + ", tips=" + this.i + ", enabled=" + this.j + ", disabledToastText=" + this.k + ')';
    }

    @Override // com.obric.assistant.settings.q0
    public final boolean a(q0 r5) {
        Intrinsics.checkNotNullParameter(r5, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        if ((r5 instanceof g1) == true) goto L5;
        return false;
    L5:
        g1 r6 = (g1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b.toString(), r6.b.toString()) == false) goto L35;
        CharSequence r0 = this.c;
        String r2 = null;
        if (r0 == null) goto L12;
        String r1 = r0.toString();
    L13:
        CharSequence r3 = r6.c;
        if (r3 == null) goto L17;
        r2 = r3.toString();
    L17:
        if (Intrinsics.areEqual(r1, r2) == true) goto L19;
        return false;
    L19:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L23;
        return false;
    L23:
        if (this.g == r6.g) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L29;
        return false;
    L29:
        if (this.j == r6.j) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.k, r6.k) == false) goto L43;
        return true;
    L43:
        return false;
    L12:
        r1 = null;
        goto L13
    L35:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g1(String r2, CharSequence r3, CharSequence r4, boolean r5, Function2<? super Boolean, ? super View, Unit> r6, boolean r7, boolean r8, String r9, String r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r6, "onCheckedChange");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
