package com.ss.android.lark.keyboard.edittext2.compat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.richtext.RichText;
import hob.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ExtensionEditTextCompatKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final RichText b(EditText r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        return com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) e.a(((FunctionEditText) r1).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g), ExtensionEditTextCompatKt$getDraftRichText$1.INSTANCE));
    L6:
        return com.ss.android.lark.widget.richtext.c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final RichText c(EditText r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof KeyboardFunctionEditText) == false) goto L6;
        return com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) e.a(((KeyboardFunctionEditText) r1).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g), ExtensionEditTextCompatKt$getOriginRichText$1.INSTANCE));
    L6:
        return com.ss.android.lark.widget.richtext.c.a();
    }

    public static final RichText d(KeyboardFunctionEditText r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        return com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) e.a(r1.q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g), ExtensionEditTextCompatKt$getOriginalRichText$1.INSTANCE));
    L6:
        return com.ss.android.lark.widget.richtext.c.a();
    }

    public static /* synthetic */ RichText f(EditText r2) {
        return e(r2, 0, r2.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String g(KeyboardFunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r1 = r2.length();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) r2.q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g)).m(0, r1);
    }

    public static final void n(AppCompatEditText r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        com.ss.android.lark.keyboard.edittext2.edittors.a r2 = (com.ss.android.lark.keyboard.edittext2.edittors.a) ((FunctionEditText) r1).q(com.ss.android.lark.keyboard.edittext2.edittors.a.e);
        return;
    }

    public static final void k(KeyboardFunctionEditText r1, CodeBlockV2ProcessParams r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "params");
        if ((r1 instanceof KeyboardFunctionEditText) == false) goto L6;
        com.ss.android.lark.keyboard.edittext2.edittors.c r3 = (com.ss.android.lark.keyboard.edittext2.edittors.c) r1.q(com.ss.android.lark.keyboard.edittext2.edittors.c.d);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r3.c = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(EditText r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        a r3 = (a) ((FunctionEditText) r1).q(a.c);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r3.b = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(EditText r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        ((com.ss.android.lark.keyboard.edittext2.edittors.d) ((FunctionEditText) r1).q(com.ss.android.lark.keyboard.edittext2.edittors.d.e)).c = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(EditText r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof KeyboardFunctionEditText) == false) goto L6;
        KeyboardFunctionEditText r4 = (KeyboardFunctionEditText) r2;
        r4.getClass();
        RichTextEditor.a r0 = RichTextEditor.t;
        ((RichTextEditor) r4.q(r0)).k = r3;
        ((RichTextEditor) r4.q(r0)).l = true;
        r4.g();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(EditText r1, RichText r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof FunctionEditText) == false) goto L9;
        AppCompatEditText r3 = (FunctionEditText) r1;
        r3.getEditableText().clear();
        RichTextEditor r4 = (RichTextEditor) r3.q(RichTextEditor.t);
        if (r2 != null) goto L7;
        r2 = com.ss.android.lark.widget.richtext.c.a();
    L7:
        Intrinsics.checkNotNull(r2);
        r4.insert(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final RichText e(EditText r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        return ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) e.a(((FunctionEditText) r1).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g), ExtensionEditTextCompatKt$getRichText$1.INSTANCE)).i(r2, r3);
    L6:
        return com.ss.android.lark.widget.richtext.c.c(r1.getText().toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(EditText r1, Context r2, Drawable r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "drawable");
        Intrinsics.checkNotNullParameter(r4, "emojiKey");
        Intrinsics.checkNotNullParameter(r5, "emojiText");
        if ((r1 instanceof FunctionEditText) == false) goto L6;
        ((com.ss.android.lark.keyboard.edittext2.edittors.d) ((FunctionEditText) r1).q(com.ss.android.lark.keyboard.edittext2.edittors.d.e)).insert(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.EditText, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [hob.a] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [hob.j] */
    public static final void h(EditText r2, String r3, String r4, Integer r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "href");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r7, "suffix");
        if ((r2 instanceof FunctionEditText) == false) goto L22;
        boolean r0 = false;
        boolean r1 = true;
        if (r6 == false) goto L14;
        ?? r8 = new j(r3);
        if (r4.length() > 0) goto L10;
        r1 = false;
    L10:
        if (r1 == false) goto L12;
        String r9 = r4 + r7;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.e = r9;
        r8.d = false;
    L12:
        if (r5 == null) goto L20;
        r8.f.a = r5.intValue();
    L20:
        ((eob.a) ((FunctionEditText) r2).q(eob.a.f)).insert(r8);
        return;
    L14:
        StringBuilder r10 = new StringBuilder();
        if (r4.length() != 0) goto L17;
        r0 = true;
    L17:
        if (r0 == false) goto L19;
        r4 = r3;
    L19:
        r10.append(r4);
        r10.append(r7);
        r8 = new hob.a(r3, r10.toString());
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(EditText r7, String r8, String r9, String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "chatterId");
        Intrinsics.checkNotNullParameter(r9, "chatterName");
        Intrinsics.checkNotNullParameter(r10, "chatterOriginName");
        if ((r7 instanceof FunctionEditText) == false) goto L6;
        hob.c r0 = new hob.c(r8, r9, r10, r11, r12);
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) ((FunctionEditText) r7).q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).insert(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(EditText r7, String r8, String r9, String r10, boolean r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "chatterId");
        Intrinsics.checkNotNullParameter(r9, "chatterName");
        Intrinsics.checkNotNullParameter(r10, "chatterOriginName");
        if ((r7 instanceof FunctionEditText) == false) goto L6;
        hob.c r0 = new hob.c(r8, r9, r10, r11, r12);
        r0.i = r13;
        r0.j = r13;
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) ((FunctionEditText) r7).q(com.ss.android.lark.keyboard.edittext2.edittors.a.e)).insert(r0);
        return;
    }
}
