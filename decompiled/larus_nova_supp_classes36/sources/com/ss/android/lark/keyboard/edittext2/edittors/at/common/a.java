package com.ss.android.lark.keyboard.edittext2.edittors.at.common;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import hob.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends com.ss.android.lark.keyboard.edittext2.edittors.at.a<c> {
    public final com.ss.android.lark.keyboard.edittext2.edittors.a c;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.at.common.a$a, reason: collision with other inner class name */
    public static final class C0139a {
    }

    static {
    }

    public void o(EditText r5) {
        Intrinsics.checkNotNullParameter(r5, "targetView");
        SpannableStringBuilder r0 = (SpannableStringBuilder) e(this.c).getFirst();
        n(r0, this.b, 0, r0.length());
        l(r5.getEditableText(), r0);
    }

    public a(com.ss.android.lark.keyboard.edittext2.edittors.a r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        Intrinsics.checkNotNullParameter(r3, "data");
        super(r3, "CommonAtSpanHolder");
        this.c = r2;
    }

    public void n(SpannableStringBuilder r7, c r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "text");
        Intrinsics.checkNotNullParameter(r8, "data");
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(r8);
        RichTextElement.AtProperty r11 = r8.g;
        if (r11 == null) goto L9;
        RichTextElement r5 = RichTextElementCreator.h(r11);
        r7.setSpan(new p(r5, r7.subSequence(0, r10).toString()), 0, r10, 33);
        if (r8.f == false) goto L7;
        r7.append(" ");
    L7:
        h(r7, r8, 0, r10, r5);
        return;
    }
}
