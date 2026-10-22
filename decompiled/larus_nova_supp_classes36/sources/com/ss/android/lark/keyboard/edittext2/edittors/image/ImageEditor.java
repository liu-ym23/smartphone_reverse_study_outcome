package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.base.d;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.span.m0;
import hob.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ImageEditor extends BaseFunctionEditor<f> implements com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a c = null;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<ImageEditor> {
        public final /* synthetic */ d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<ImageEditor> a() {
            return this.a.a;
        }

        public a() {
            this.a = new d(ImageEditor.class);
        }
    }

    static {
        c = new a();
    }

    public ImageEditor() {
    }

    public Object V(Context r4, f r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "insertImageInfo");
        m0 r0 = new m0(r4, r5.a, new ImageEditor$prepareSpan$span$1(this));
        ((com.ss.android.lark.widget.span.b) r0).m = UIUtils.dp2px(context(), 2.0f);
        ((com.ss.android.lark.widget.span.b) r0).n = UIUtils.dp2px(context(), 1.0f);
        ((com.ss.android.lark.widget.span.b) r0).p = r5.e;
        return r0;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void S(SpannableStringBuilder r8, f r9, int r10) {
        f r11 = r9;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r11, "data");
        RichTextElement.ImageProperty r12 = r11.d;
        if (r12 == null) goto L5;
        Boolean r13 = Boolean.valueOf(r12.isNeedCopy());
    L6:
        com.ss.android.lark.widget.span.b.b<?> r0 = r11.a;
        RichTextElement.ImageProperty r1 = RichTextElementCreator.c(r0.a, r11.b, r0.b, r0.c, r11.c, null);
        r1.setNeedCopy(Intrinsics.areEqual(r13, Boolean.TRUE));
        r1.setOriginKey(r11.b);
        r11.d = r1;
        int r14 = r8.length();
        String r2 = UIHelper.getString(2131891845);
        r8.append(r2);
        r8.setSpan(V(context(), r11), r14, r2.length() + r14, 33);
        com.ss.android.lark.keyboard.edittext2.widget.c.a.getClass();
        r8.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.b(), r14, r2.length() + r14, 33);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void T(f r1, SpannableStringBuilder r2, int r3, int r4) {
        U(r1, r2, r3, r4);
    }

    public void U(f r3, SpannableStringBuilder r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "text");
        RichTextElement.ImageProperty r7 = r3.d;
        if (r7 == null) goto L6;
        r4.setSpan(new p(RichTextElementCreator.h(r7), r4.subSequence(r5, r6).toString()), r5, r6, 33);
        return;
    }
}
