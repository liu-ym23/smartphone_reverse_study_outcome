package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.keyboard.edittext2.edittors.inlinecode.EditorInlineCodeCenterSpan;
import com.ss.android.lark.richtextmd.RichTextBISUUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends RichTextEditor {
    public static final String w = null;
    public static final EnumSet<RichTextElement.RichTextTag> x = null;
    public final Map<RichTextElement, Integer> u;
    public final AtomicInteger v;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.richText.a$a, reason: collision with other inner class name */
    public static final class C0141a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            r0[RichTextElement.RichTextTag.OL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[RichTextElement.RichTextTag.UL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[RichTextElement.RichTextTag.LI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[RichTextElement.RichTextTag.CODE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        w = UIHelper.getString(2131913605);
        x = EnumSet.of(RichTextElement.RichTextTag.H1, new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.H2, RichTextElement.RichTextTag.H3, RichTextElement.RichTextTag.H4, RichTextElement.RichTextTag.H5, RichTextElement.RichTextTag.H6});
    }

    public final boolean Y() {
        RichTextElement r0 = (RichTextElement) CollectionsKt.getOrNull(this.r, 1);
        if (r0 == null) goto L5;
        RichTextElement.RichTextTag r1 = r0.getTag();
    L7:
        if (r1 == RichTextElement.RichTextTag.LI) goto L11;
        return false;
    L11:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public a() {
        this.u = new LinkedHashMap();
        this.v = new AtomicInteger(0);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void E() {
        if (Y() == true) goto L8;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L9;
        RichTextEditor.W(r0);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void O() {
        if (Y() == true) goto L8;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L9;
        RichTextEditor.W(r0);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void h() {
        if (Y() == true) goto L8;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L9;
        RichTextEditor.W(r0);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void l() {
        if (Y() == true) goto L8;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L9;
        RichTextEditor.W(r0);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void w() {
        if (Y() == true) goto L8;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L9;
        RichTextEditor.W(r0);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void x() {
        if (Y() == true) goto L8;
        SpannableStringBuilder r0 = this.p;
        if (r0 == null) goto L9;
        RichTextEditor.W(r0);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void B(RichTextElement.LIProperty r7) {
        Integer r0 = this.s.peek();
        boolean r2 = true;
        RichTextElement r1 = (RichTextElement) CollectionsKt.getOrNull(this.r, 1);
        Integer r3 = null;
        if (r1 == null) goto L5;
        RichTextElement.RichTextTag r4 = r1.getTag();
    L6:
        int r5 = 0;
        if (r4 != RichTextElement.RichTextTag.UL) goto L9;
    L12:
        SpannableStringBuilder r6 = this.p;
        if (r6 == null) goto L16;
        r3 = Integer.valueOf(r6.length());
    L16:
        if (Intrinsics.areEqual(r0, r3) == false) goto L28;
        if (r2 == false) goto L28;
        SpannableStringBuilder r8 = this.p;
        if (r8 == null) goto L21;
        RichTextEditor.W(r8);
    L21:
        SpannableStringBuilder r9 = this.p;
        if (r9 == null) goto L25;
        r5 = r9.length();
    L25:
        if (this.s.isEmpty() == true) goto L31;
        this.s.pop();
        this.s.push(Integer.valueOf(r5));
        return;
    L31:
        return;
    L28:
        super.B(r7);
        return;
    L9:
        if (r4 == RichTextElement.RichTextTag.OL) goto L12;
        r2 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public void a(RichText r11) {
        super.a(r11);
        SpannableStringBuilder r12 = this.p;
        if (r12 == null) goto L32;
        int r2 = 0;
        y9b.a[] r0 = (y9b.a[]) r12.getSpans(0, r12.length(), y9b.a.class);
        if (r0.length != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L40;
        int r3 = r0.length;
    L12:
        if (r2 >= r3) goto L41;
        y9b.a r4 = r0[r2];
        int r5 = r12.getSpanStart(r4);
        int r6 = r12.getSpanEnd(r4);
        int r7 = r5;
    L15:
        if (r7 <= 0) goto L19;
        int r8 = r7 - 1;
        if (r12.charAt(r8) == '\n') goto L19;
        r7 = r8;
    L19:
        int r9 = r6;
    L21:
        if (r9 >= r12.length()) goto L26;
        if (r12.charAt(r9) == '\n') goto L26;
        r9 = r9 + 1;
    L26:
        if (r9 >= r12.length()) goto L28;
        r9 = r9 + 1;
    L28:
        if (r7 != r5) goto L30;
        if (r9 != r6) goto L30;
    L31:
        r2 = r2 + 1;
    L30:
        r12.setSpan(r4, r7, r9, 33);
        goto L31
    L41:
        return;
    L40:
        return;
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public void b(RichText r5) {
        super.b(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        List r0 = r5.getElementIds();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) r2.next();
        RichTextElement r4 = (RichTextElement) r5.getElements().getDictionary().get(r3);
        if (r4 == null) goto L7;
        r1.add(r4);
        goto L7
    L11:
        Iterator r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        Z(r5, (RichTextElement) r6.next(), new LinkedHashMap());
        goto L13
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void i(RichTextElement.ParagraphProperty r3) {
        RichTextElement r0 = (RichTextElement) CollectionsKt.getOrNull(this.r, 1);
        if (r0 == null) goto L5;
        RichTextElement.RichTextTag r1 = r0.getTag();
    L7:
        if (r1 != RichTextElement.RichTextTag.LI) goto L11;
        SpannableStringBuilder r4 = this.p;
        if (r4 == null) goto L13;
        RichTextEditor.U(r4);
        return;
    L13:
        return;
    L11:
        super.i(r3);
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void p(RichTextElement r3) {
        super.p(r3);
        RichTextElement.RichTextTag r0 = r3.getTag();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        RichTextElement.OLProperty r2 = r3.getProperty();
        this.u.put(r3, Integer.valueOf(r2.getStart()));
        this.v.incrementAndGet();
        return;
    L9:
        if (r1 != 2) goto L15;
        this.v.incrementAndGet();
        return;
    L15:
        return;
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void s(RichTextElement r11) {
        RichTextElement.RichTextTag r0 = r11.getTag();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        this.u.remove(r11);
        this.v.decrementAndGet();
    L55:
        super.s(r11);
        return;
    L9:
        if (r1 != 2) goto L11;
        this.v.decrementAndGet();
        goto L55
    L11:
        if (r1 != 3) goto L13;
        Integer r2 = this.s.peek();
        if (r2 == null) goto L55;
        int r3 = r2.intValue();
        SpannableStringBuilder r4 = this.p;
        if (r4 == null) goto L55;
        if (r3 >= 0) goto L31;
    L33:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L55;
        RichTextElement r7 = (RichTextElement) CollectionsKt.getOrNull(this.r, 1);
        if (r7 == null) goto L55;
        if (r7.getTag() != RichTextElement.RichTextTag.OL) goto L47;
        Integer r8 = (Integer) ((LinkedHashMap) this.u).get(r7);
        if (r8 == null) goto L44;
        int r9 = r8.intValue();
    L45:
        this.u.put(r7, Integer.valueOf(r9 + 1));
        y9b.b r10 = new y9b.b();
        r10.h(r9);
    L50:
        if (r10 == null) goto L55;
        Context r12 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getContext();
        int r13 = UIUtils.getColor(r12, 2131108619);
        r10.f(Math.max(this.v.get() - 1, 0));
        ((CommonPrefixSpan) r10).a.g = r13;
        ((CommonPrefixSpan) r10).a.j = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getTextSize();
        int r5 = com.ss.android.lark.coremd.utils.a.a;
        Intrinsics.checkNotNull(r12);
        ((CommonPrefixSpan) r10).a.c = com.ss.android.lark.coremd.utils.a.b(r12, r10) + com.ss.android.lark.coremd.utils.a.a(r12, -1, r10.b());
        ((CommonPrefixSpan) r10).a.e = com.ss.android.lark.coremd.utils.a.c(r12, r10, -1.0f);
        ((CommonPrefixSpan) r10).a.d = com.ss.android.lark.coremd.utils.a.d(r10);
        r4.setSpan(r10, r3, r4.length(), 33);
        goto L55
    L44:
        r9 = 1;
        goto L45
    L47:
        if (r7.getTag() != RichTextElement.RichTextTag.UL) goto L49;
        r10 = new y9b.c();
        goto L50
    L49:
        r10 = null;
        goto L50
    L31:
        if (r3 >= r4.length()) goto L33;
        r6 = true;
        goto L34
    L13:
        if (r1 != 4) goto L55;
        if (com.ss.android.lark.keyboard.edittext2.utils.d.a("myai.ai_card.copy_markdown") == false) goto L55;
        SpannableStringBuilder r14 = this.p;
        if (r14 == null) goto L55;
        Integer r15 = this.s.peek();
        if (r15 == null) goto L55;
        int r16 = r15.intValue();
        InlineCodeInfo r17 = new InlineCodeInfo();
        r17.setBackgroundColor(2131102486);
        Context r18 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getContext();
        Intrinsics.checkNotNull(r18);
        r14.setSpan(new EditorInlineCodeCenterSpan(r18, r17), r16, r14.length(), 33);
        goto L55
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public static void Z(RichText r4, RichTextElement r5, Map r6) {
        RichTextBISUUtils.e(r6, r5);
        Map r7 = r5.getStyle();
        if (r7 != null) goto L5;
        r7 = new LinkedHashMap();
    L5:
        List r0 = r5.getChildIds();
        if (r0 == null) goto L13;
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        String r3 = (String) r2.next();
        RichTextElement r8 = (RichTextElement) r4.getElements().getDictionary().get(r3);
        if (r8 == null) goto L9;
        r1.add(r8);
    L15:
        if (x.contains(r5.getTag()) == false) goto L17;
        r7.put("fontWeight", w);
    L17:
        if (r1 == null) goto L22;
        Iterator r9 = r1.iterator();
    L20:
        if (r9.hasNext() == false) goto L29;
        Z(r4, (RichTextElement) r9.next(), r7);
        goto L20
    L29:
        return;
    L22:
        return;
    L13:
        r1 = null;
        goto L15
    }
}
