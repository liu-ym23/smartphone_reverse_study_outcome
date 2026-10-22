package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.text.Editable;
import android.text.Layout;
import android.widget.EditText;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 {
    public final EditText a;
    public final Function0<k1> b;
    public final String c;
    public final Paint d;
    public a e;
    public ColorStateList f;
    public final c0 g;
    public final a0 h;

    public static final class a {
        public final int a;
        public final float b;
        public final float c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Position(cursor=" + this.a + ", x=" + this.b + ", baseline=" + this.c + ", rtl=" + this.d + ')';
        }

        public a(int r1, float r2, float r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MultiTypePanelTrigger.values().length];
            r0[MultiTypePanelTrigger.MENTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MultiTypePanelTrigger.SLASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MultiTypePanelTrigger.EXTERNAL_SKILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    private final void update() {
        k1 r0 = (k1) this.b.invoke();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L80:
        a r5 = null;
    L81:
        if (r5 == null) goto L92;
        Editable r2 = this.a.getText();
        if (r2 != null) goto L85;
    L88:
        if (r1 == false) goto L92;
        if (this.a.getCurrentHintTextColor() == 0) goto L99;
        this.f = this.a.getHintTextColors();
        this.a.setHintTextColor(0);
    L99:
        if (Intrinsics.areEqual(this.e, r5) == true) goto L101;
    L104:
        this.e = r5;
        this.g.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
        this.g.invalidateSelf();
        return;
    L101:
        if (this.g.getBounds().width() != this.a.getWidth()) goto L104;
        if (this.g.getBounds().height() != this.a.getHeight()) goto L104;
        return;
    L85:
        if (r2.length() == 0) goto L88;
        r1 = false;
    L92:
        ColorStateList r3 = this.f;
        if (r3 != null) goto L95;
    L97:
        this.f = null;
        goto L99
    L95:
        if (this.a.getCurrentHintTextColor() != 0) goto L97;
        this.a.setHintTextColor(r3);
        goto L97
    L5:
        if (r0.c.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L80;
        if (this.a.isShown() == false) goto L80;
        if (this.a.isEnabled() == false) goto L80;
        int r6 = this.a.getSelectionStart();
        Editable r7 = this.a.getText();
        if (r7 == null) goto L80;
        if (r6 != this.a.getSelectionEnd()) goto L80;
        if (r6 != r0.b) goto L80;
        if (r6 >= 0) goto L27;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == false) goto L80;
        int r9 = b.a[r0.d.ordinal()];
        if (r9 != 1) goto L35;
    L41:
        int r10 = r6 - 1;
    L42:
        int r11 = r0.a;
        if (r11 != r10) goto L80;
        if (r0.d != MultiTypePanelTrigger.MENTION) goto L54;
        Character r12 = StringsKt.getOrNull(r7, r11);
        if (r12 == null) goto L80;
        if (r12.charValue() != '@') goto L80;
    L54:
        if (r0.d != MultiTypePanelTrigger.SLASH) goto L61;
        Character r13 = StringsKt.getOrNull(r7, r0.a);
        if (r13 == null) goto L80;
        if (r13.charValue() != '/') goto L80;
    L61:
        Layout r14 = this.a.getLayout();
        if (r14 == null) goto L80;
        if (r6 > r14.getText().length()) goto L80;
        int r15 = r14.getLineForOffset(r6);
        int r16 = RangesKt.coerceAtMost(r14.getLineEnd(r15), r7.length());
        int r17 = r6;
    L68:
        if (r17 >= r16) goto L75;
        if (r7.charAt(r17) == '\n') goto L74;
        if (r7.charAt(r17) != '\r') goto L80;
    L74:
        r17 = r17 + 1;
        goto L68
    L75:
        float r18 = (this.a.getTotalPaddingLeft() + r14.getPrimaryHorizontal(r6)) - this.a.getScrollX();
        float r19 = ((this.a.getBaseline() + r14.getLineBaseline(r15)) - r14.getLineBaseline(0)) - this.a.getScrollY();
        if (r14.getParagraphDirection(r15) >= 0) goto L78;
        boolean r20 = true;
    L79:
        r5 = new a(r6, r18, r19, r20);
        goto L81
    L78:
        r20 = false;
        goto L79
    L35:
        if (r9 == 2) goto L41;
        if (r9 != 3) goto L40;
        r10 = r6;
        goto L42
    L40:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r6 > r7.length()) goto L29;
        r8 = true;
        goto L30
    L7:
        r4 = false;
        goto L8
    }

    public static void a(b0 r0) {
        r0.update();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.larus.bmhome.chat.component.bottom.core.inputtext.a0] */
    public b0(EditText r3, f1 r4) {
        Intrinsics.checkNotNullParameter(r3, "editText");
        Intrinsics.checkNotNullParameter(r4, "queryProvider");
        this.a = r3;
        this.b = r4;
        this.c = r3.getContext().getString(2131906711);
        this.d = new Paint(1);
        c0 r5 = new c0(this);
        this.g = r5;
        ?? r0 = new a0(this);
        this.h = r0;
        r3.getOverlay().add(r5);
        r3.getViewTreeObserver().addOnPreDrawListener(r0);
    }
}
