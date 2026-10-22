package com.ss.android.lark.keyboard.edittext2.edittors;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class d extends BaseFunctionEditor<String> implements com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a e = null;
    public float c;
    public final int d;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<d> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<d> a() {
            return this.a.a;
        }

        public a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(d.class);
        }
    }

    static {
        e = new a();
    }

    public d() {
        this.d = 1;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor, com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
        this.c = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, String r2, int r3) {
        U(r1, r2, r3);
    }

    public void U(SpannableStringBuilder r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "emojiKey");
        Context r2 = context();
        Drawable r3 = EmojiHandler.c(r11, null, null);
        if (r3 != null) goto L5;
        return;
    L5:
        String r0 = EmojiHandler.e(r11);
        float r1 = this.c;
        if (r1 > 0.0f) goto L8;
        r1 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize();
    L8:
        Object r8 = new com.ss.android.lark.widget.linked_emojicon.base.a(r2, r3, r11, (int) r1, this.d, (int) com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize());
        r10.append(r0);
        r10.setSpan(r8, r12, r0.length() + r12, 33);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(String r3, SpannableStringBuilder r4, int r5, int r6) {
        String r7 = r3;
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r4, "text");
        Map r0 = RichTextElementCreator.a;
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        Intrinsics.checkNotNullParameter(r7, "emojiKey");
        RichTextElement.EmotionProperty r1 = new RichTextElement.EmotionProperty();
        r1.setKey(r7);
        r4.setSpan(new p(RichTextElementCreator.h(r1), r4.subSequence(r5, r6).toString()), r5, r6, 33);
    }
}
