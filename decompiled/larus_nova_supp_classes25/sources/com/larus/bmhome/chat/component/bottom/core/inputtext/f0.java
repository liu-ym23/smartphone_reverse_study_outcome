package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public static final Regex a = null;
    public static final Regex b = null;

    public static final class a {
        public final IntRange a;
        public final d0 b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            d0 r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "DecodedReferenceMatch(range=" + this.a + ", reference=" + this.b + ", fallbackText=" + this.c + ')';
        }

        public a(IntRange r2, d0 r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "range");
            Intrinsics.checkNotNullParameter(r4, "fallbackText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = new Regex("<(at|mention)\\b([^>]*)>(.*?)</\\1>", SetsKt.setOf(new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL}));
        b = new Regex("(?<!\\\\)\\[((?:\\\\[^\\r\\n]|[^\\x5D\\\\\\r\\n])+)]\\(([^\\s)]+)\\)");
    }

    public static String a(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, "&", "&amp;", false, 4, null), "\"", "&quot;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
    }

    public static String b(String r15) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r15, "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
    }

    public static String h(d0 r26) {
        String r1 = r26.g;
        String r2 = null;
        if (r1 != null) goto L5;
    L10:
        String r3 = r26.d;
        if (r3 != null) goto L13;
    L15:
        if (r2 == null) goto L19;
        return "[" + StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(k0.a(r26), "\r\n", " ", false, 4, null), '\r', ' ', false, 4, null), '\n', ' ', false, 4, null), "\\", "\\\\", false, 4, null), "[", "\\[", false, 4, null), "]", "\\]", false, 4, null) + "](" + r2 + ')';
    L19:
        throw new IllegalArgumentException(("Reference protocol destination is required for " + r26.getType()).toString());
    L13:
        if ((!StringsKt.isBlank(r3)) == false) goto L15;
        r2 = r3;
        goto L15
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        return r1;
    }

    public static String c(String r5, List r6) {
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "entities");
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        UplinkFileEntity r1 = (UplinkFileEntity) r7.next();
        String r2 = r1.getFileIdentifier();
        Pair r3 = null;
        if (r2 != null) goto L8;
    L13:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        r3 = TuplesKt.to(r2, r1);
        goto L13
    L15:
        final Map r8 = MapsKt.toMap(r0);
        if (r8.isEmpty() == false) goto L19;
        return r5;
    L19:
        return b.replace(r5, new e0(r8));
    }

    public static boolean d(String r7, List r8) {
        Intrinsics.checkNotNullParameter(r7, "content");
        Intrinsics.checkNotNullParameter(r8, "entities");
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L3:
        String r3 = null;
        if (r9.hasNext() == false) goto L12;
        String r1 = ((UplinkFileEntity) r9.next()).getFileIdentifier();
        if (r1 != null) goto L8;
    L10:
        if (r3 == null) goto L3;
        r0.add(r3);
        goto L3
    L8:
        if ((true ^ StringsKt.isBlank(r1)) == false) goto L10;
        r3 = r1;
        goto L10
    L12:
        Set r10 = CollectionsKt.toSet(r0);
        if (r10.isEmpty() == false) goto L15;
        return false;
    L15:
        Iterator r11 = Regex.findAll$default(b, r7, 0, 2, null).iterator();
    L17:
        if (r11.hasNext() == false) goto L40;
        MatchResult r2 = (MatchResult) r11.next();
        MatchGroup r5 = r2.getGroups().get(1);
        if (r5 == null) goto L21;
        String r6 = r5.getValue();
    L22:
        String r12 = "";
        if (r6 != null) goto L25;
        r6 = "";
    L25:
        MatchGroup r4 = r2.getGroups().get(2);
        if (r4 == null) goto L28;
        String r13 = r4.getValue();
    L29:
        if (r13 == null) goto L32;
        r12 = r13;
    L32:
        d0 r14 = f(r6, r12);
        if (r14 == null) goto L37;
        String r15 = r14.a;
        if (r15 == null) goto L37;
        boolean r16 = r10.contains(r15);
    L38:
        if (r16 == false) goto L17;
        return true;
    L37:
        r16 = false;
        goto L38
    L28:
        r13 = null;
        goto L29
    L21:
        r6 = null;
        goto L22
    L40:
        return false;
    }

    public static d0 f(String r1, String r2) {
        Regex r0 = com.larus.bmhome.chat.markdown.richtext.n.a;
        d0 r3 = g(r1, com.larus.bmhome.chat.markdown.richtext.n.r(r2));
        if (r3 != null) goto L5;
    L10:
        return null;
    L5:
        if (r3.getType() != InputReferenceType.ATTACHMENT) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        return r3;
    L7:
        r4 = false;
        goto L8
    }

    public static d0 g(String r14, String r15) {
        Regex r0 = com.larus.bmhome.chat.markdown.richtext.n.a;
        com.larus.bmhome.chat.markdown.richtext.r r1 = com.larus.bmhome.chat.markdown.richtext.n.o(r15);
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof com.larus.bmhome.chat.markdown.richtext.r.d) == false) goto L14;
        com.larus.bmhome.chat.markdown.richtext.r.d r2 = (com.larus.bmhome.chat.markdown.richtext.r.d) r1;
        String r3 = r2.b;
        if (r3 != null) goto L12;
        r3 = r2.c;
        if (r3 != null) goto L12;
        return null;
    L12:
        Pair r4 = TuplesKt.to(r3, InputReferenceType.SKILL);
    L23:
        return new d0((String) r4.component1(), r14, (InputReferenceType) r4.component2(), r15, null, null, null, null, null, null, 1008);
    L14:
        if ((r1 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == false) goto L17;
        r4 = TuplesKt.to(((com.larus.bmhome.chat.markdown.richtext.r.b) r1).a, InputReferenceType.CONVERSATION);
        goto L23
    L17:
        if ((r1 instanceof com.larus.bmhome.chat.markdown.richtext.r.c) == false) goto L20;
        r4 = TuplesKt.to(((com.larus.bmhome.chat.markdown.richtext.r.c) r1).a, InputReferenceType.FILE);
        goto L23
    L20:
        if ((r1 instanceof com.larus.bmhome.chat.markdown.richtext.r.a) == false) goto L25;
        r4 = TuplesKt.to(((com.larus.bmhome.chat.markdown.richtext.r.a) r1).a, InputReferenceType.ATTACHMENT);
        goto L23
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public static d0 e(String r15, String r16, String r17, String r18) {
        String r1 = null;
        if (r15 != null) goto L5;
    L56:
        return null;
    L5:
        if (new Regex("oc_[A-Za-z0-9_-]+").matches(r15) == false) goto L7;
        String r4 = r15;
    L8:
        if (r4 == null) goto L56;
        if (r16 == null) goto L56;
        String r0 = StringsKt.trim(r16).toString();
        if (r0 == null) goto L56;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r0)) == false) goto L16;
        String r5 = r0;
    L17:
        if (r5 == null) goto L56;
        if (r18 == null) goto L31;
        Long r2 = StringsKt.toLongOrNull(r18);
        if (r2 == null) goto L24;
        long r8 = r2.longValue();
    L26:
        if (r8 <= 0) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == false) goto L31;
        String r7 = r18;
    L32:
        if (r17 != null) goto L34;
    L40:
        String r12 = null;
    L41:
        String r9 = "";
        if (r12 == null) goto L48;
        StringBuilder r10 = new StringBuilder(" avatar_key=\"");
        r10.append(a(r12));
        r10.append("\" entity_id=\"");
        if (r7 == null) goto L47;
        r9 = r7;
    L47:
        r10.append(a(r9));
        r10.append('\"');
        r9 = r10.toString();
    L48:
        InputReferenceType r11 = InputReferenceType.GROUP;
        String r13 = "<at chat_id=\"" + a(r4) + '\"' + r9 + '>' + b(r5) + "</at>";
        if (r12 != null) goto L52;
        r3 = false;
    L52:
        if (r3 == false) goto L55;
        r1 = r7;
    L55:
        return new d0(r4, r5, r11, null, null, null, r13, null, r12, r1, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END);
    L34:
        if ((!StringsKt.isBlank(r17)) == false) goto L37;
        if (r7 == null) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L40;
        r12 = r17;
    L37:
        r14 = false;
        goto L38
    L28:
        r6 = false;
        goto L29
    L24:
        r8 = 0;
    L31:
        r7 = null;
        goto L32
    L16:
        r5 = null;
        goto L17
    L7:
        r4 = null;
        goto L8
    }
}
