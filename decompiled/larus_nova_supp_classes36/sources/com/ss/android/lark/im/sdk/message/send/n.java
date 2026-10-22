package com.ss.android.lark.im.sdk.message.send;

import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements jkb.d<k> {
    public static final Regex b = null;
    public final com.ss.android.lark.im.sdk.service.e a;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "StripLeadingMentionResult(sanitizedText=" + this.a + ", stripped=" + this.b + ')';
        }

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "sanitizedText");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // jkb.d
    public final String getName() {
        return "VoiceTextPostProcessStep";
    }

    static {
        b = new Regex("(\\d+)\\.$");
    }

    public n(com.ss.android.lark.im.sdk.service.e r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceTextPostProcessService");
        this.a = r2;
    }

    public static j1 b(j1 r3, RichText r4) {
        j1.a r0 = new j1.a();
        ((MessageParams.a) r0).c = ((MessageParams) r3).c;
        ((MessageParams.a) r0).g = ((MessageParams) r3).f;
        ((MessageParams.a) r0).f = ((MessageParams) r3).g;
        ((MessageParams.a) r0).e = ((MessageParams) r3).i;
        ((MessageParams.a) r0).d = ((MessageParams) r3).d;
        ((MessageParams.a) r0).a = ((MessageParams) r3).a;
        ((MessageParams.a) r0).b = ((MessageParams) r3).b;
        ((MessageParams.a) r0).i = ((MessageParams) r3).h;
        ((MessageParams.a) r0).j = ((MessageParams) r3).j;
        ((MessageParams.a) r0).k = ((MessageParams) r3).k;
        ((MessageParams.a) r0).l = ((MessageParams) r3).l;
        ((MessageParams.a) r0).m = ((MessageParams) r3).m;
        ((MessageParams.a) r0).n = ((MessageParams) r3).n;
        Long r1 = ((MessageParams) r3).o;
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        ((MessageParams.a) r0).o = r2;
        ((MessageParams.a) r0).p = ((MessageParams) r3).p;
        ((MessageParams.a) r0).q = ((MessageParams) r3).q;
        ((MessageParams.a) r0).r = ((MessageParams) r3).r;
        ((MessageParams.a) r0).s = ((MessageParams) r3).s;
        ((MessageParams.a) r0).t = ((MessageParams) r3).t;
        ((MessageParams.a) r0).u = ((MessageParams) r3).u;
        r0.A = r4;
        List r5 = r3.C;
        if (r5 != null) goto L9;
        r5 = Collections.emptyList();
    L9:
        r0.C = r5;
        ((MessageParams.a) r0).v = ((MessageParams) r3).v;
        ((MessageParams.a) r0).w = ((MessageParams) r3).w;
        r0.B = false;
        return r0.b();
    L5:
        r2 = -1;
        goto L6
    }

    @Override // jkb.d
    public final void a(jkb.b r13, jkb.c r14) {
        k r15 = (k) r13;
        Intrinsics.checkNotNullParameter(r15, "pipelineContext");
        Intrinsics.checkNotNullParameter(r14, "pipelineControl");
        j1 r0 = r15.a;
        b r2 = null;
        Object r3 = null;
        if ((r0 instanceof j1) == false) goto L5;
        j1 r1 = r0;
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L14;
        r14.a();
        return;
    L14:
        RichText r5 = r1.A;
        String r6 = "";
        if (((MessageParams) r1).v == false) goto L37;
        Intrinsics.checkNotNull(r5);
        List r7 = r5.getAtIds();
        if (r7 == null) goto L37;
        String r8 = (String) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L37;
        RichText.RichTextElements r9 = r5.getElements();
        if (r9 == null) goto L37;
        Map r10 = r9.getDictionary();
        if (r10 == null) goto L37;
        RichTextElement r11 = (RichTextElement) r10.get(r8);
        if (r11 == null) goto L37;
        RichTextElement.AtProperty r12 = r11.getProperty();
        if (r12 == null) goto L37;
        String r16 = r5.getInnerText();
        if (r16 != null) goto L35;
        r16 = "";
    L35:
        if (StringsKt.startsWith$default(StringsKt.trimStart(r16).toString(), r12.getAtContent(), false, 2, null) == false) goto L37;
    L38:
        if (r5 == null) goto L40;
        String r17 = r5.getInnerText();
    L41:
        if (r17 == null) goto L43;
        String r18 = StringsKt.trim(r17).toString();
    L44:
        if (r18 == null) goto L47;
        r6 = r18;
    L47:
        String r19 = b.replace(r6, "$1。");
        if (r12 == null) goto L71;
        String r20 = r12.getAtContent();
        if (r19.length() != 0) goto L52;
        boolean r21 = true;
    L53:
        if (r21 == false) goto L55;
        r2 = new b(r19, false);
        goto L71
    L55:
        LinkedHashSet r22 = SetsKt.linkedSetOf(new String[]{r20, StringsKt.removePrefix(r20, "@")});
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L57:
        if (r24.hasNext() == false) goto L61;
        Object r110 = r24.next();
        if ((!StringsKt.isBlank((String) r110)) == false) goto L57;
        r23.add(r110);
        goto L57
    L61:
        Iterator r25 = r23.iterator();
    L63:
        if (r25.hasNext() == false) goto L67;
        Object r26 = r25.next();
        if (StringsKt.startsWith$default(r19, (String) r26, false, 2, null) == false) goto L63;
        r3 = r26;
    L67:
        String r27 = (String) r3;
        if (r27 == null) goto L70;
        r2 = new b(StringsKt.trimStart(StringsKt.removePrefix(r19, r27)).toString(), true);
        goto L71
    L70:
        r2 = new b(r19, false);
        goto L71
    L52:
        r21 = false;
    L71:
        if (r2 == null) goto L77;
        String r28 = r2.a;
        if (r28 == null) goto L77;
        r19 = r28;
    L77:
        if (r19.length() != 0) goto L79;
        boolean r29 = true;
    L81:
        if (r29 == false) goto L83;
        Intrinsics.checkNotNull(r5);
        j1 r30 = b(r1, r5);
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r15.a = r30;
        r14.a();
        return;
    L83:
        RichText r31 = this.a.a(((MessageParams) r1).c, r19);
        if (r12 == null) goto L88;
        if (r31 != null) goto L87;
        r31 = com.ss.android.lark.widget.richtext.c.c(r19);
    L87:
        int r32 = r5.getRichTextVersion();
        Intrinsics.checkNotNull(r31);
        RichText r33 = com.ss.android.lark.widget.richtext.c.b(CollectionsKt.mutableListOf(new RichTextElement[]{RichTextElementCreator.h(r12), RichTextElementCreator.e(" ")}));
        r33.setInnerText(r12.getAtContent() + ' ');
        r33.setRichTextVersion(r32);
        r5 = com.ss.android.lark.widget.richtext.utils.a.b(r33, r31);
    L91:
        Intrinsics.checkNotNull(r5);
        j1 r34 = b(r1, r5);
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        r15.a = r34;
        r14.a();
        return;
    L88:
        if (r31 == null) goto L91;
        r5 = r31;
        goto L91
    L79:
        r29 = false;
        goto L81
    L43:
        r18 = null;
        goto L44
    L40:
        r17 = null;
    L37:
        r12 = null;
        goto L38
    L9:
        if (r1.B != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }
}
