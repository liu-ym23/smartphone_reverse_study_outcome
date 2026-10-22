package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.keyboard.edittext2.span.j;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.keyboard.edittext2.utils.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import com.ss.android.lark.widget.span.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class d implements com.ss.android.lark.keyboard.edittext2.base.a, com.ss.android.lark.keyboard.edittext2.base.c {
    public static final a g = null;
    public boolean a;
    public boolean b;
    public com.ss.android.lark.keyboard.edittext2.base.b c;
    public final b d;
    public final c e;
    public final boolean f;

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

    public static class b implements f.a {
        public final d a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RichTextElement.RichTextTag.values().length];
                r0[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L35:
                r0[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L51:
                r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L39:
                r0[RichTextElement.RichTextTag.EMOTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            L43:
                r0[RichTextElement.RichTextTag.IMG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
            L29:
                r0[RichTextElement.RichTextTag.MEDIA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
            L45:
                r0[RichTextElement.RichTextTag.MENTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            L47:
                r0[RichTextElement.RichTextTag.CODE_BLOCK_V2.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
            L37:
                r0[RichTextElement.RichTextTag.TABLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
            L41:
                r0[RichTextElement.RichTextTag.COLUMNS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
            L31:
                r0[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
            L33:
                r0[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
            L15:
                a = r0;
            }
        }

        public b(d r2) {
            Intrinsics.checkNotNullParameter(r2, "generator");
            this.a = r2;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.utils.f.a
        public final RichTextElement a(Object r4) {
            Intrinsics.checkNotNullParameter(r4, "span");
            if ((r4 instanceof p) == false) goto L27;
            Object r0 = ((p) r4).b;
            if ((r0 instanceof RichTextElement) == false) goto L27;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement");
            RichTextElement r1 = (RichTextElement) r0;
            RichTextElement.RichTextTag r2 = r1.getTag();
            if (r2 != null) goto L10;
            int r3 = -1;
        L11:
            switch(r3) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L38;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                default: goto L28;
            };
        L13:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "markdownElement");
            return r1;
        L14:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "userGroupElement");
            return r1;
        L15:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "columnsElement");
            return r1;
        L16:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "tableElement");
            return r1;
        L17:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "codeBlockV2Element");
            return r1;
        L18:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "mentionElement");
            return r1;
        L19:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "mediaElement");
            return r1;
        L20:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "imgElement");
            return r1;
        L21:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "emotionElement");
            return r1;
        L23:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "atElement");
            return r1;
        L24:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "textElement");
            return r1;
        L28:
            return this.a.g(r4);
        L38:
            return this.a.f(r1);
        L10:
            r3 = a.a[r2.ordinal()];
        L27:
            return this.a.g(r4);
        }

        public final void e(Spanned r2, List<Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "editable");
            Intrinsics.checkNotNullParameter(r3, "spans");
            this.a.p(r2, r3);
        }

        public final boolean c(Spannable r2, Object r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "editable");
            Intrinsics.checkNotNullParameter(r3, "span");
            return this.a.o(r2, r3, r4, r5);
        }
    }

    public static class c implements com.ss.android.lark.widget.richtext.a {
        public final d a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RichTextElement.RichTextTag.values().length];
                r0[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L35:
                r0[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L51:
                r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L39:
                r0[RichTextElement.RichTextTag.EMOTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            L43:
                r0[RichTextElement.RichTextTag.IMG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
            L29:
                r0[RichTextElement.RichTextTag.MEDIA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
            L45:
                r0[RichTextElement.RichTextTag.MENTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            L47:
                r0[RichTextElement.RichTextTag.CODE_BLOCK_V2.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
            L37:
                r0[RichTextElement.RichTextTag.TABLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
            L41:
                r0[RichTextElement.RichTextTag.COLUMNS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
            L31:
                r0[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
            L33:
                r0[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
            L15:
                a = r0;
            }
        }

        public c(d r2) {
            Intrinsics.checkNotNullParameter(r2, "generator");
            this.a = r2;
        }

        public final void e(Spanned r2, List<Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "editable");
            Intrinsics.checkNotNullParameter(r3, "spans");
            this.a.q(r2, r3);
        }

        public final String g(Object r4, CharSequence r5) {
            Intrinsics.checkNotNullParameter(r4, "span");
            Intrinsics.checkNotNullParameter(r5, "sequence");
            if ((r4 instanceof p) == false) goto L38;
            Object r0 = ((p) r4).b;
            if ((r0 instanceof RichTextElement) == false) goto L38;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement");
            RichTextElement r1 = (RichTextElement) r0;
            RichTextElement.RichTextTag r2 = r1.getTag();
            if (r2 != null) goto L10;
            int r3 = -1;
        L11:
            List r6 = null;
            String r7 = null;
            switch(r3) {
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L14;
                default: goto L39;
            };
        L14:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "markdownElement");
            RichTextElement.MarkdownProperty r8 = r1.getProperty();
            if (r8 == null) goto L17;
            r7 = r8.getContent();
        L17:
            if (r7 != null) goto L40;
            return "";
        L40:
            return r7;
        L19:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "userGroupElement");
            return r1.getProperty().getAtContent();
        L20:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "columnsElement");
            int r9 = dcc.a.a;
            return UIHelper.getString(2131891027);
        L21:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "tableElement");
            return uec.a.a();
        L22:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "codeBlockV2Element");
            RichTextElement.CodeBlockV2Property r10 = r1.getProperty();
            if (r10 == null) goto L25;
            r6 = r10.getLineContents();
        L25:
            String r11 = com.ss.android.lark.widget.codeblock.entity.a.a(r6);
            if (StringsKt.isBlank(r11) == false) goto L45;
            r11 = com.ss.android.lark.widget.codeblock.entity.a.b();
        L45:
            return r11;
        L29:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "mentionElement");
            return r1.getProperty().getContent();
        L30:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "mediaElement");
            return UIHelper.getString(2131891923);
        L31:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "imgElement");
            return UIHelper.getString(2131891845);
        L32:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "emotionElement");
            return EmojiHandler.f(r1.getProperty().getKey());
        L33:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "anchorElement");
            return r1.getProperty().getHref();
        L34:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "atElement");
            return r1.getProperty().getAtContent();
        L35:
            this.a.getClass();
            Intrinsics.checkNotNullParameter(r1, "textElement");
            return r1.getProperty().getContent();
        L39:
            return this.a.h(r4, r5);
        L10:
            r3 = a.a[r2.ordinal()];
        L38:
            return this.a.h(r4, r5);
        }

        public final boolean c(Spannable r2, Object r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "editable");
            Intrinsics.checkNotNullParameter(r3, "span");
            return this.a.o(r2, r3, r4, r5);
        }
    }

    static {
        g = new a();
    }

    public RichTextExtraInfo a(RichTextExtraInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "richTextExtraInfo");
        return r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    public RichTextElement g(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "span");
        return null;
    }

    public String h(Object r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "span");
        Intrinsics.checkNotNullParameter(r3, "sequence");
        return "";
    }

    public boolean o(Spannable r1, Object r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "editable");
        Intrinsics.checkNotNullParameter(r2, "span");
        return false;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    public d() {
        boolean r0 = true;
        this.b = true;
        this.d = new b(this);
        this.e = new c(this);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L5;
    L8:
        this.f = r0;
        return;
    L5:
        if (KeyboardBaseModule.a().isFeatureGatingEnable("im.messenger.keyboard.trim_richtext_fix_revert") == false) goto L8;
        r0 = false;
        goto L8
    }

    public static RichText j(d r2) {
        r2.getClass();
        return r2.i(0, com.ss.android.lark.keyboard.edittext2.base.c.a.a(r2).length());
    }

    public static void s(Spanned r5) {
        Iterator r0 = ArrayIteratorKt.iterator((p[]) r5.getSpans(0, r5.length(), p.class));
    L4:
        if (r0.hasNext() == false) goto L24;
        p r1 = (p) r0.next();
        Object r2 = r1.b;
        if ((r2 instanceof RichTextElement) == false) goto L8;
        RichTextElement r3 = (RichTextElement) r2;
    L9:
        if (r3 == null) goto L4;
        if (r3.getTag() != RichTextElement.RichTextTag.MARKDOWN) goto L4;
        int r4 = r5.getSpanStart(r1);
        int r6 = r5.getSpanEnd(r1);
        if (r4 < 0) goto L22;
        if (r6 < 0) goto L22;
        if (r4 >= r6) goto L22;
        String r7 = r5.subSequence(r4, r6).toString();
        RichTextElement.MarkdownProperty r8 = r3.getProperty();
        if (r8 == null) goto L4;
        r8.setContent(r7);
    L22:
        if ((r5 instanceof Spannable) == false) goto L4;
        ((Spannable) r5).removeSpan(r1);
        goto L4
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
    }

    public void e(SpannableStringBuilder r7) {
        Intrinsics.checkNotNullParameter(r7, "ssb");
        if (this.f == true) goto L7;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (this.b == false) goto L7;
        StringsKt.trim(r7);
    L7:
        int r2 = 0;
        z[] r0 = (z[]) r7.getSpans(0, r7.length(), z.class);
        int r1 = r0.length;
    L8:
        if (r2 >= r1) goto L10;
        z r3 = r0[r2];
        r7.replace(r7.getSpanStart(r3), r7.getSpanEnd(r3), "");
        r2 = r2 + 1;
        goto L8
    }

    public RichTextElement f(RichTextElement r3) {
        Intrinsics.checkNotNullParameter(r3, "anchorElement");
        RichTextElement.AnchorProperty r0 = r3.getProperty();
        if (this.a == false) goto L6;
        Log.i("RichTextGenerator", "isDowngradeAnchor: generate text element");
        return RichTextElementCreator.e(r0.getHref());
    L6:
        return r3;
    }

    public final String n(Spannable r12) {
        Intrinsics.checkNotNullParameter(r12, "targetSequence");
        int r0 = f.a;
        c r1 = this.e;
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r1, "handler");
        ArrayList r2 = new ArrayList();
        r1.e(r12, r2);
        Pair r3 = f.d(r12, r2, r1);
        Map r4 = (Map) r3.component1();
        List r5 = (List) r3.component2();
        if (r2.isEmpty() == true) goto L24;
        StringBuilder r6 = new StringBuilder();
        int r7 = r5.size();
        int r8 = 0;
        int r9 = 0;
    L6:
        if (r9 >= r7) goto L16;
        Pair r10 = f.a(r4, r5, r9);
        if (r10 == null) goto L10;
        SpannableStringBuilder r11 = (SpannableStringBuilder) r12;
        r6.append(r11.subSequence(((Number) r10.getFirst()).intValue(), ((Number) r10.getSecond()).intValue()));
    L10:
        Object r13 = ListProtector.get(r5, r9);
        Pair r14 = (Pair) r4.get(r13);
        if (r14 == null) goto L14;
        SpannableStringBuilder r15 = (SpannableStringBuilder) r12;
        CharSequence r16 = r15.subSequence(((Number) r14.getFirst()).intValue(), ((Number) r14.getSecond()).intValue());
        if (r16 == null) goto L14;
    L15:
        r6.append(r1.g(r13, r16));
        r9 = r9 + 1;
    L14:
        r16 = "";
        goto L15
    L16:
        Pair r17 = (Pair) r4.get(CollectionsKt.lastOrNull(r5));
        if (r17 == null) goto L19;
        r8 = ((Number) r17.getSecond()).intValue();
    L19:
        SpannableStringBuilder r18 = (SpannableStringBuilder) r12;
        r6.append(r18.subSequence(r8, r18.length()).toString());
        return r6.toString();
    L24:
        return r12.toString();
    }

    public final RichTextExtraInfo r(Editable r5) {
        Intrinsics.checkNotNullParameter(r5, "editable");
        RichTextExtraInfo r0 = new RichTextExtraInfo();
        int r3 = 0;
        j[] r6 = (j[]) r5.getSpans(0, r5.length(), j.class);
        Intrinsics.checkNotNull(r6);
        if (r6.length != 0) goto L5;
        boolean r1 = true;
    L7:
        if ((!r1) == false) goto L12;
        int r2 = r6.length;
    L9:
        if (r3 >= r2) goto L12;
        r6[r3].a(r0);
        r3 = r3 + 1;
    L12:
        return a(r0);
    L5:
        r1 = false;
        goto L7
    }

    public final CharSequence t(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (this.b == true) goto L5;
        return r2;
    L5:
        if (this.f == true) goto L7;
        return r2;
    L7:
        return StringsKt.trimEnd(r2);
    }

    public static List b(Spanned r7, p[] r8) {
        ArrayList r0 = new ArrayList();
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        p r3 = r8[r2];
        Object r4 = r3.b;
        boolean r6 = true;
        if ((r4 instanceof RichTextElement) == true) goto L8;
    L12:
        if (r6 == false) goto L14;
        r0.add(r3);
    L14:
        r2 = r2 + 1;
        goto L3
    L8:
        if (((RichTextElement) r4).getTag() != RichTextElement.RichTextTag.TEXT) goto L12;
        String r5 = r7.subSequence(r7.getSpanStart(r3), r7.getSpanEnd(r3)).toString();
        Intrinsics.checkNotNullParameter(r5, "what");
        if (r3.d == false) goto L12;
        r6 = Intrinsics.areEqual(r5, r3.c);
        goto L12
    L15:
        return r0;
    }

    public RichText i(int r5, int r6) {
        Editable r0 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText();
        Log.i("RichTextGenerator", "generateRichText: start, end is (" + r5 + " , " + r6 + ')');
        if (r5 > r6) goto L5;
        int r7 = Math.max(0, r5);
        int r8 = Math.min(r6, r0.length());
        SpannableStringBuilder r2 = e.e(t(r0.subSequence(r7, r8)));
        e(r2);
        if (r2.length() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L14;
        return com.ss.android.lark.widget.richtext.c.a();
    L14:
        if (this.f == false) goto L16;
        RichText r9 = l(r2, 0, r2.length());
    L17:
        Intrinsics.checkNotNull(r0);
        r9.setExtraInfo(r(r0));
        return r9;
    L16:
        r9 = l(r2, r7, r8);
        goto L17
    L9:
        r3 = false;
        goto L10
    L5:
        return com.ss.android.lark.widget.richtext.c.a();
    }

    public final String m(int r4, int r5) {
        Editable r0 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText();
        Log.i("RichTextGenerator", "generateRichText: start, end is (" + r4 + " , " + r5 + ')');
        if (r4 <= r5) goto L6;
        return "";
    L6:
        SpannableStringBuilder r6 = e.e(t(r0.subSequence(Math.max(0, r4), Math.min(r5, r0.length()))));
        e(r6);
        if (this.f == false) goto L10;
        r6.length();
        return n(r6);
    L10:
        return n(r6);
    }

    public void p(Spanned r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r5, "spans");
        s(r4);
        p[] r0 = (p[]) r4.getSpans(0, r4.length(), p.class);
        Intrinsics.checkNotNull(r0);
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(b(r4, r0));
    }

    public void q(Spanned r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r5, "spans");
        s(r4);
        p[] r0 = (p[]) r4.getSpans(0, r4.length(), p.class);
        Intrinsics.checkNotNull(r0);
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(b(r4, r0));
    }

    public RichText l(Spannable r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "targetSequence");
        int r0 = f.a;
        RichText r1 = com.ss.android.lark.widget.richtext.c.b(f.c(r3, this.d));
        if (this.f == false) goto L5;
        String r6 = n(r3);
    L6:
        r1.setInnerText(r6);
        Intrinsics.checkNotNull(r1);
        return r1;
    L5:
        r6 = m(r4, r5);
        goto L6
    }
}
