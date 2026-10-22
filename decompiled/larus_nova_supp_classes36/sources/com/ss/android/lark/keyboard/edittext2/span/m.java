package com.ss.android.lark.keyboard.edittext2.span;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import sz7.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends CharacterStyle implements f {
    public final Context a;
    public final String b;
    public final String c;
    public final int d;
    public final SpannableStringBuilder e;
    public final q f;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public final Context d;
        public final String e;
        public final String f;
        public final String g;
        public final int h;
        public final String i;
        public final String j;
        public final boolean k;

        public final Context getContext() {
            return this.d;
        }

        public /* synthetic */ a(Context r10, String r11, String r12, String r13) {
            this(r10, r11, r12, 0, r13, null, null, false);
        }

        public a(Context r3, String r4, String r5, int r6, String r7, String r8, String r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, "href");
            this.a = UIHelper.getColor(2131106616);
            this.b = UIHelper.getColor(2131106616);
            this.c = UIHelper.getDimens(2131165902);
            this.e = "";
            this.f = "";
            if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L5;
            int r0 = 2131255012;
        L6:
            this.h = r0;
            this.d = r3;
            UDIconUtils.getIconDrawable(r3, r0, this.b);
            this.e = r4;
            this.f = r5;
            this.g = r7;
            if (r6 == 0) goto L9;
            this.h = r6;
        L9:
            this.i = r8;
            this.j = r9;
            this.k = r10;
            return;
        L5:
            r0 = 2131255013;
            goto L6
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public m(a r17) {
        Context r2 = r17.getContext();
        String r3 = r17.e;
        String r4 = r17.f;
        int r5 = r17.a;
        int r6 = r17.b;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        q r7 = new q(r2, false);
        this.f = r7;
        Drawable r12 = UDIconUtils.getIconDrawable(r2, r17.h, r5, new UDDimension.a(r17.c));
        String r8 = r17.g;
        String r9 = r17.i;
        String r10 = r17.j;
        boolean r11 = r17.k;
        if (r9 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L11;
        int r14 = 1;
        Integer[] r15 = sbb.d.a;
        String r16 = r17.i;
        if (r16 != null) goto L52;
        r16 = "";
    L52:
        BitmapDrawable r18 = new BitmapDrawable(sbb.d.a(r16));
        int r1 = r17.c;
        r18.setBounds(0, 0, r1, r1);
        d r19 = new d(r18);
    L53:
        SpannableStringBuilder r20 = new SpannableStringBuilder("$" + r3 + " \u200b");
        this.e = r20;
        r20.setSpan(r19, 0, r14, 33);
        Intrinsics.checkNotNull(r20);
        r20.setSpan(this, 0, r20.length(), 33);
        return;
    L11:
        if ((!com.ss.android.lark.keyboard.edittext2.utils.d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L38;
        if (r11 == false) goto L28;
        if (r8 != null) goto L15;
    L18:
        boolean r21 = true;
    L19:
        if (r21 == false) goto L28;
        if (r10 != null) goto L22;
    L25:
        boolean r22 = true;
    L26:
        if (r22 == false) goto L35;
    L36:
        boolean r23 = false;
    L37:
        r7.l = r23;
    L35:
        r23 = true;
        goto L37
    L22:
        if (r10.length() == 0) goto L25;
        r22 = false;
        goto L26
    L15:
        if (r8.length() == 0) goto L18;
        r21 = false;
    L28:
        if (r8 != null) goto L30;
    L33:
        boolean r24 = true;
    L34:
        if (r24 == true) goto L36;
    L30:
        if (r8.length() == 0) goto L33;
        r24 = false;
    L38:
        if (r11 == false) goto L47;
        if (r8 != null) goto L41;
    L44:
        boolean r25 = true;
    L45:
        if (r25 == false) goto L47;
        int r110 = r17.c;
        r7.b(r10, r110, r110, r12, false, Integer.valueOf(r6));
        r14 = 1;
    L48:
        int r26 = r17.c;
        r7.setBounds(0, 0, r26, r26);
        r19 = new d(r7);
        goto L53
    L41:
        if (r8.length() == 0) goto L44;
        r25 = false;
    L47:
        int r111 = r17.c;
        r14 = 1;
        q.d(r7, r8, null, r111, r111, r12, false, Integer.valueOf(r6));
        goto L48
    L5:
        if (r9.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setColor(this.d);
        r2.setUnderlineText(false);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.span.k
    public final k.a e(int r1, int r2, Editable r3) {
        return f.a.a(this, r1, r2, r3);
    }
}
