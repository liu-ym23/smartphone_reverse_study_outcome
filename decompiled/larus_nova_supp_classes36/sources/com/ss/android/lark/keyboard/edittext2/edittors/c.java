package com.ss.android.lark.keyboard.edittext2.edittors;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends BaseFunctionEditor<hob.e> implements com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a d = null;
    public CodeBlockV2ProcessParams c;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<c> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<c> a() {
            return this.a.a;
        }

        public a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(c.class);
        }
    }

    static {
        d = new a();
    }

    public c() {
        this.c = CodeBlockV2ProcessParams.b.f(CodeBlockV2ProcessParams.Companion, 0, 3);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r5, hob.e r6, int r7) {
        hob.e r8 = r6;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r8, "data");
        int r9 = r5.length();
        String r0 = com.ss.android.lark.widget.codeblock.entity.a.b();
        r5.append(r0);
        if (r8.a.isEmpty() == false) goto L5;
        Log.i("CodeBlockV2Editor", "insert code block return: line contents is empty");
        return;
    L5:
        r5.setSpan(new com.ss.android.lark.keyboard.edittext2.span.c(context(), r8.a, this.c), r9, r0.length() + r9, 33);
        com.ss.android.lark.keyboard.edittext2.widget.c.a.getClass();
        r5.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.b(), r9, r0.length() + r9, 33);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.e r3, SpannableStringBuilder r4, int r5, int r6) {
        hob.e r7 = r3;
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r4, "text");
        RichTextElement.CodeBlockV2Property r8 = r7.b;
        if (r8 == null) goto L6;
        r4.setSpan(new p(RichTextElementCreator.h(r8), r4.subSequence(r5, r6).toString()), r5, r6, 33);
        return;
    }
}
