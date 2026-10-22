package com.ss.android.lark.inline.ai.ui.richtext;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.contact.export.ContactSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InlineAIAtSpanHolder extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.a {
    public static final /* synthetic */ int d = 0;

    public static final class a extends ClickableSpan {
        public final String a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            if (Intrinsics.areEqual(this.a, "all") == false) goto L5;
            return;
        L5:
            ContactSource.a r0 = new ContactSource.a();
            com.ss.android.lark.profile.utils.a.a(r4.getContext(), this.a, new ContactSource(r0));
        }
    }

    public InlineAIAtSpanHolder(com.ss.android.lark.keyboard.edittext2.edittors.a r2, hob.c r3) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "data");
        super(r2, r3);
        f(new AnonymousClass1(this));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.a
    public final void n(SpannableStringBuilder r2, hob.c r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "data");
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(r3);
        r2.setSpan(new a(r3.a), 0, r5, 33);
    }
}
