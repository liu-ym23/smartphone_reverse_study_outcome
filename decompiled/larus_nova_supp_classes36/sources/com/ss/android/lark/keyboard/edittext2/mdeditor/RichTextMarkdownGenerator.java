package com.ss.android.lark.keyboard.edittext2.mdeditor;

import a3c.b;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremdbiz.facade.o;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.d;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v7b.r;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RichTextMarkdownGenerator extends d {
    public a3c.a h;
    public a3c.a i;
    public final Function1<? super RichTextExtraInfo, Unit> j;

    public static final class a {
    }

    static {
    }

    public RichTextMarkdownGenerator() {
        b r0 = b.a;
        r0.getClass();
        this.h = b.c;
        r0.getClass();
        this.i = b.b;
        this.j = RichTextMarkdownGenerator$extraAttach$1.INSTANCE;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d, com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        RichTextMarkdownGenerator r3 = (RichTextMarkdownGenerator) r2;
        this.i = r3.i;
        this.h = r3.h;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final String h(Object r5, CharSequence r6) {
        Intrinsics.checkNotNullParameter(r5, "span");
        Intrinsics.checkNotNullParameter(r6, "sequence");
        if ((r5 instanceof y9b.a) == false) goto L9;
        StringBuilder r0 = new StringBuilder();
        y9b.a r7 = (y9b.a) r5;
        int r1 = ((CommonPrefixSpan) r7).a.h;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0.append("\t");
        r2 = r2 + 1;
        goto L5
    L7:
        r0.append(((CommonPrefixSpan) r7).a.f);
        r0.append(r6);
        return r0.toString();
    L9:
        super.h(r5, r6);
        return "";
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final RichText i(int r6, int r7) {
        Context r0 = c.a.a(this).getContext();
        Editable r1 = c.a.a(this).getEditableText();
        Log.i("RichTextGenerator", "generateRichText: start, end is (" + r6 + " , " + r7 + ')');
        if (r6 > r7) goto L5;
        SpannableStringBuilder r8 = e.e(t(r1.subSequence(Math.max(0, r6), Math.min(r7, r1.length()))));
        int r9 = com.ss.android.lark.keyboard.edittext2.utils.d.a;
        Intrinsics.checkNotNullParameter("open_app.bot.without_callback_owner_show_input", TabAppInfo.IMAGE_JSON_KEY);
        if (KeyboardBaseModule.a().isFeatureGatingCurrentEnable("open_app.bot.without_callback_owner_show_input") == false) goto L9;
        e(r8);
    L9:
        com.ss.android.lark.keyboard.edittext2.mdeditor.a r10 = (com.ss.android.lark.keyboard.edittext2.mdeditor.a) getTarget().q(com.ss.android.lark.keyboard.edittext2.mdeditor.a.c);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "content");
        SpannableStringBuilder r11 = e.e(r8);
        Context r2 = c.a.a(r10).getContext();
        t9b.a r3 = t9b.a.a;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "context");
        com.ss.android.lark.coremd.impl.buildnode.d r4 = new com.ss.android.lark.coremd.impl.buildnode.d(r2);
        u9b.a.a(r4, r10.a);
        s r12 = r4.b(r11);
        Log.d("EditorMarkdownNodeGenerator", "markdown node path is " + r.a(r12, true));
        if (this.a == false) goto L12;
        final a3c.a r13 = this.h;
    L13:
        t9b.b r5 = t9b.b.a;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r0, "context");
        com.ss.android.lark.richtextmd.generate.c r14 = new com.ss.android.lark.richtextmd.generate.c(r0);
        com.ss.android.lark.richtextmd.generate.a.a(r14, new RichTextMarkdownGenerator$generateRichText$richText$1(r13));
        RichText r15 = r14.b(r12);
        com.ss.android.lark.coremd.impl.parse.b.a r16 = t9b.b.a(r0);
        r16.e(o.a);
        r15.setInnerText(r16.d(r12).toString());
        Intrinsics.checkNotNull(r1);
        RichTextExtraInfo r17 = r(r1);
        this.j.invoke(r17);
        r15.setExtraInfo(r17);
        return r15;
    L12:
        r13 = this.i;
        goto L13
    L5:
        return com.ss.android.lark.widget.richtext.c.a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final void q(Spanned r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r5, "spans");
        super.q(r4, r5);
        CollectionsKt.addAll(r5, r4.getSpans(0, r4.length(), y9b.a.class));
    }
}
