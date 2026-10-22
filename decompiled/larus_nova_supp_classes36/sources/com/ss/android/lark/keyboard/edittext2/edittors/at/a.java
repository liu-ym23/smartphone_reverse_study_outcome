package com.ss.android.lark.keyboard.edittext2.edittors.at;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import androidx.appcompat.widget.AppCompatEditText;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.c;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a<I extends hob.c> implements d {
    public final /* synthetic */ EditTextSpanHolder a;
    public final I b;

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public void c(FunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a.c(r2);
    }

    public boolean m(boolean r1, boolean r2) {
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        return false;
    L6:
        return true;
    }

    public static void j(hob.c r5) {
        Intrinsics.checkNotNullParameter(r5, "atInfo");
        RichTextElement.AtProperty r0 = r5.g;
        if (r0 == null) goto L8;
        r0.setOriginUserName(r5.c);
        RichTextElement.AtProperty r1 = r5.g;
        if (r1 == null) goto L12;
        r1.setHighLight(r5.j);
        return;
    L12:
        return;
    L8:
        RichTextElement.AtProperty r2 = RichTextElementCreator.b(r5.a, r5.b, r5.c, r5.d, r5.e);
        r5.g = r2;
        r2.setHighLight(r5.j);
        RichTextElement.AtProperty r3 = r5.g;
        if (r3 == null) goto L13;
        r3.setContentWithoutLimit(r5.b);
        return;
    }

    public final Pair<SpannableStringBuilder, Object> e(com.ss.android.lark.keyboard.edittext2.edittors.a r13) {
        Intrinsics.checkNotNullParameter(r13, "editor");
        SpannableStringBuilder r2 = new SpannableStringBuilder("@" + this.b.b);
        I r1 = this.b;
        Intrinsics.checkNotNullParameter(r13, "editor");
        Intrinsics.checkNotNullParameter(r1, "originData");
        String r5 = r1.a;
        boolean r0 = r1.d;
        boolean r9 = r1.e;
        boolean r8 = r1.j;
        int r10 = r13.d;
        Context r14 = r13.context();
        com.ss.android.lark.keyboard.edittext2.span.a r11 = new com.ss.android.lark.keyboard.edittext2.span.a(r14, r5, r0, r9, r8);
        if (m(r0, r9) == false) goto L6;
        r11.f = r10;
    L6:
        if (r1.i == false) goto L8;
        r11.f = UDColorUtils.getColor(r14, 2131105540);
    L8:
        r2.setSpan(r11, 0, r2.length(), 33);
        return TuplesKt.to(r2, r11);
    }

    public final void f(Function1<? super FunctionEditText, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        EditTextSpanHolder r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "action");
        r1.c = r3;
        FunctionEditText r0 = r1.b;
        if (r0 == null) goto L6;
        r3.invoke(r0);
        r1.c = EditTextSpanHolder$consumeAction$1.INSTANCE;
        return;
    }

    public Pair<Integer, Integer> g(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "editable");
        return TuplesKt.to(Integer.valueOf(r2.getSpanStart(this)), Integer.valueOf(r2.getSpanEnd(this)));
    }

    public final boolean i(Editable r6) {
        Intrinsics.checkNotNullParameter(r6, "editable");
        Intrinsics.checkNotNullParameter(r6, "editable");
        Pair<Integer, Integer> r0 = g(r6);
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        if (r1 == (-1)) goto L24;
        if (r2 == (-1)) goto L24;
        if (r2 < r1) goto L24;
        if (r1 >= 0) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L20;
        if (r2 >= 0) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L24;
        boolean r3 = Intrinsics.areEqual(r6.subSequence(r1, r2), this.b.b);
    L25:
        if (r3 == false) goto L28;
        k(r6);
        return true;
    L28:
        return false;
    L15:
        if (r2 > r6.length()) goto L17;
        r5 = true;
    L20:
        r7 = false;
        goto L21
    L9:
        if (r1 > r6.length()) goto L11;
        r4 = true;
    L24:
        r3 = true;
        goto L25
    }

    public void k(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "editable");
        r2.removeSpan(this);
    }

    public a(I r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "originData");
        Intrinsics.checkNotNullParameter(r3, "tag");
        this.a = new EditTextSpanHolder(r3);
        this.b = r2;
        hashCode();
    }

    public final void l(Editable r4, SpannableStringBuilder r5) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r5, "target");
        Pair<Integer, Integer> r0 = g(r4);
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        if (r1 == (-1)) goto L7;
        if (r2 == (-1)) goto L7;
        boolean r3 = false;
    L8:
        if (r3 == true) goto L11;
        k(r4);
        r4.replace(r1, r2, r5);
        return;
    L11:
        return;
    L7:
        r3 = true;
        goto L8
    }

    public final void h(SpannableStringBuilder r2, I r3, int r4, int r5, RichTextElement r6) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r6, "element");
        Map<String, String> r0 = r3.h;
        if (r0 == null) goto L5;
        r6.getStyle().putAll(r0);
    L5:
        Map<String, String> r7 = r3.h;
        AppCompatEditText r8 = this.a.b;
        if (r8 == null) goto L8;
        Context r9 = r8.getContext();
    L9:
        com.ss.android.lark.keyboard.edittext2.edittors.richText.c.b(r2, r4, r5, r7, r9);
        return;
    L8:
        r9 = null;
        goto L9
    }
}
