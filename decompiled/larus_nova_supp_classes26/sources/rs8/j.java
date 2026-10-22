package rs8;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements g {
    public final String a;
    public final int b;
    public final CharSequence c;
    public final Drawable d;
    public final String e;
    public final float f;
    public final MessageActionBarAlign g;
    public final boolean h;
    public final boolean i;
    public final Integer j;
    public final ActionStyle k;
    public final String l;
    public final Function1<View, Unit> m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (Float.compare(this.f, r6.f) == 0) goto L27;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        Drawable r4 = this.d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + Float.floatToIntBits(this.f)) * 31) + this.g.hashCode()) * 31;
        int r10 = 1231;
        if (this.h == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.i == true) goto L22;
        r10 = 1237;
    L22:
        int r13 = (r12 + r10) * 31;
        Integer r14 = this.j;
        if (r14 == null) goto L27;
        r1 = r14.hashCode();
    L27:
        return ((((((r13 + r1) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
    L17:
        r11 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageAction(actionBarKey=" + this.a + ", id=" + this.b + ", description=" + this.c + ", iconDrawable=" + this.d + ", iconNormalUrl=" + this.e + ", iconRotation=" + this.f + ", messageActionBarAlign=" + this.g + ", isSelected=" + this.h + ", isEnable=" + this.i + ", resourceIdForCompose=" + this.j + ", style=" + this.k + ", accessibilityContent=" + this.l + ", onClick=" + this.m + ')';
    }

    @Override // rs8.g
    public final String a() {
        return this.a;
    }

    @Override // rs8.g
    public final MessageActionBarAlign b() {
        return this.g;
    }

    @Override // rs8.g
    public final Function1<View, Unit> c() {
        return this.m;
    }

    @Override // rs8.g
    public final String d() {
        return this.l;
    }

    @Override // rs8.g
    public final CharSequence getDescription() {
        return this.c;
    }

    @Override // rs8.g
    public final int getId() {
        return this.b;
    }

    @Override // rs8.g
    public final ActionStyle getStyle() {
        return this.k;
    }

    public static j e(j r14, boolean r15) {
        String r1 = r14.a;
        int r2 = r14.b;
        CharSequence r3 = r14.c;
        Drawable r4 = r14.d;
        String r5 = r14.e;
        float r6 = r14.f;
        MessageActionBarAlign r7 = r14.g;
        boolean r8 = r14.h;
        Integer r10 = r14.j;
        ActionStyle r11 = r14.k;
        String r12 = r14.l;
        Function1<View, Unit> r13 = r14.m;
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r7, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r11, "style");
        Intrinsics.checkNotNullParameter(r12, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r13, "onClick");
        return new j(r1, r2, r3, r4, r5, r6, r7, r8, r15, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r2, int r3, CharSequence r4, Drawable r5, String r6, float r7, MessageActionBarAlign r8, boolean r9, boolean r10, Integer r11, ActionStyle r12, String r13, Function1<? super View, Unit> r14) {
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r8, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r12, "style");
        Intrinsics.checkNotNullParameter(r13, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r14, "onClick");
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
        this.l = r13;
        this.m = r14;
    }

    public /* synthetic */ j(String r18, int r19, CharSequence r20, Drawable r21, String r22, float r23, MessageActionBarAlign r24, boolean r25, boolean r26, Integer r27, ActionStyle r28, String r29, Function1 r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r31 & 8) == 0) goto L9;
        Drawable r7 = null;
    L11:
        if ((r31 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r31 & 32) == 0) goto L17;
        float r9 = 0.0f;
    L19:
        if ((r31 & 64) == 0) goto L21;
        MessageActionBarAlign r10 = MessageActionBarAlign.START;
    L23:
        if ((r31 & 128) == 0) goto L25;
        boolean r11 = false;
    L27:
        if ((r31 & 256) == 0) goto L29;
        boolean r12 = true;
    L31:
        if ((r31 & 512) == 0) goto L33;
        Integer r13 = null;
    L35:
        if ((r31 & 1024) == 0) goto L37;
        ActionStyle r14 = ActionStyle.NORMAL;
    L39:
        if ((r31 & 2048) == 0) goto L41;
        String r15 = "";
    L43:
        if ((r31 & 4096) == 0) goto L45;
        Function1 r16 = new i();
    L46:
        this(r4, r19, r20, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return;
    L45:
        r16 = r30;
        goto L46
    L41:
        r15 = r29;
        goto L43
    L37:
        r14 = r28;
        goto L39
    L33:
        r13 = r27;
        goto L35
    L29:
        r12 = r26;
        goto L31
    L25:
        r11 = r25;
        goto L27
    L21:
        r10 = r24;
        goto L23
    L17:
        r9 = r23;
        goto L19
    L13:
        r8 = r22;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }
}
