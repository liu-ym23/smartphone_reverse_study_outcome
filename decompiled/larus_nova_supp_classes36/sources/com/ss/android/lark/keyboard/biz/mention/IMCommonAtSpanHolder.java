package com.ss.android.lark.keyboard.biz.mention;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IMCommonAtSpanHolder extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.a implements com.ss.android.lark.keyboard.edittext2.edittors.at.b<Pair<? extends String, ? extends String>> {
    public static final /* synthetic */ int f = 0;
    public Object d;
    public final boolean e;

    public static final class a extends ClickableSpan {
        public final String a;
        public final boolean b;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "widget");
            if (Intrinsics.areEqual(this.a, "all") == false) goto L6;
            return;
        L6:
            if (this.b == false) goto L8;
            return;
        L8:
            ProfileSource.a r0 = new ProfileSource.a();
            r0.e = this.a;
            ChatCoreModule.a().getProfileDependency().e(r3.getContext(), r0.a());
        }

        public a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void b() {
        f(new IMCommonAtSpanHolder$onDataLoadedFailed$1(this));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void d(Pair<? extends String, ? extends String> r3) {
        Pair<? extends String, ? extends String> r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        final String r0 = (String) r4.getFirst();
        final String r5 = (String) r4.getSecond();
        if (Intrinsics.areEqual(r0, this.b.b) == false) goto L5;
        f(new IMCommonAtSpanHolder$onDataLoadedSuccess$1(this, r5));
        return;
    L5:
        f(new IMCommonAtSpanHolder$onDataLoadedSuccess$2(this, r0, r5));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.a
    public final Pair<Integer, Integer> g(Editable r3) {
        Intrinsics.checkNotNullParameter(r3, "editable");
        Object r0 = this.d;
        if (r0 != null) goto L6;
        return super.g(r3);
    L6:
        return TuplesKt.to(Integer.valueOf(r3.getSpanStart(r0)), Integer.valueOf(r3.getSpanEnd(this.d)));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.a
    public final void k(Editable r3) {
        Intrinsics.checkNotNullParameter(r3, "editable");
        Object r1 = this.d;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "editable");
        r3.removeSpan(this);
        return;
    L5:
        r3.removeSpan(r1);
        this.d = null;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.a
    public final void o(EditText r6) {
        Intrinsics.checkNotNullParameter(r6, "targetView");
        Pair<SpannableStringBuilder, Object> r0 = e(this.c);
        SpannableStringBuilder r1 = (SpannableStringBuilder) r0.getFirst();
        if (this.e == true) goto L5;
        n(r1, this.b, 0, r1.length());
    L5:
        l(r6.getEditableText(), r1);
        this.d = r0.getSecond();
    }

    public static final void p(IMCommonAtSpanHolder r3, Editable r4) {
        Pair<Integer, Integer> r0 = r3.g(r4);
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        if (r1 == (-1)) goto L11;
        if (r2 != (-1)) goto L7;
        return;
    L7:
        if ((r4 instanceof SpannableStringBuilder) == false) goto L13;
        r3.n((SpannableStringBuilder) r4, r3.b, r1, r2);
        return;
    L13:
        return;
    }

    public static final /* synthetic */ void q(IMCommonAtSpanHolder r0, EditText r1) {
        super.o(r1);
    }

    public IMCommonAtSpanHolder(IMCommonAtStrategy.c r2, com.ss.android.lark.keyboard.edittext2.edittors.a r3, hob.c r4) {
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        super(r3, r4);
        if (r2 == null) goto L5;
        boolean r5 = true;
    L6:
        this.e = r5;
        f(new AnonymousClass1(this));
        if (r5 == false) goto L11;
        if (r2 == null) goto L12;
        r2.a(r4, this);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.a
    public final void n(SpannableStringBuilder r8, hob.c r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "data");
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(r9);
        RichTextElement.AtProperty r0 = r9.g;
        if (r0 == null) goto L11;
        RichTextElement r6 = RichTextElementCreator.h(r0);
        r8.setSpan(new p(r6, r8.subSequence(r10, r11).toString()), r10, r11, 33);
        h(r8, r9, r10, r11, r6);
        if (r9.f == false) goto L7;
        r8.append(" ");
    L7:
        r8.setSpan(new a(r9.a, r9.i), r10, r11, 33);
        if (r9.i == false) goto L12;
        r8.setSpan(new com.ss.android.lark.keyboard.edittext.span.b(), r10, r11, 33);
        return;
    L12:
        return;
    }
}
