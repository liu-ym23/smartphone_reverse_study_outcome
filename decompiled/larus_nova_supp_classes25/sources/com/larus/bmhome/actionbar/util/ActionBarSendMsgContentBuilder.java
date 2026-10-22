package com.larus.bmhome.actionbar.util;

import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.k1;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.p;
import com.larus.bmhome.actionbar.model.q1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.s1;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.y1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.i;
import ouc.k;
import ouc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ActionBarSendMsgContentBuilder {
    public static final ActionBarSendMsgContentBuilder a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/actionbar/util/ActionBarSendMsgContentBuilder$PPTOptionType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "PAGE_SIZE", "TEMPLATE", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum PPTOptionType extends Enum<PPTOptionType> {
        public static final PPTOptionType PAGE_SIZE = null;
        public static final PPTOptionType TEMPLATE = null;
        public static final PPTOptionType UNKNOWN = null;
        public static final /* synthetic */ PPTOptionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PPTOptionType> getEntries() {
            return b;
        }

        static {
            PPTOptionType r0 = new PPTOptionType("UNKNOWN", 0);
            UNKNOWN = r0;
            PPTOptionType r1 = new PPTOptionType("PAGE_SIZE", 1);
            PAGE_SIZE = r1;
            PPTOptionType r3 = new PPTOptionType("TEMPLATE", 2);
            TEMPLATE = r3;
            PPTOptionType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PPTOptionType[] values() {
            return (PPTOptionType[]) a.clone();
        }

        public static PPTOptionType valueOf(String r1) {
            return (PPTOptionType) r27.a.a(PPTOptionType.class, r1);
        }

        public PPTOptionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final PPTOptionType g;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return ((r15 + r1) * 31) + this.g.hashCode();
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ParsedPPTOption(label=" + this.a + ", pageSizeId=" + this.b + ", pageSizeName=" + this.c + ", templateId=" + this.d + ", templateType=" + this.e + ", templateName=" + this.f + ", optionType=" + this.g + ')';
        }

        public a() {
            this("", "", "", "", "", "", PPTOptionType.UNKNOWN);
        }

        public a(String r2, String r3, String r4, String r5, String r6, String r7, PPTOptionType r8) {
            Intrinsics.checkNotNullParameter(r8, "optionType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final boolean c;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SelectedStylePromptOption(fallbackContent=" + this.a + ", promptContent=" + this.b + ", fromPromptList=" + this.c + ')';
        }

        public b(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "fallbackContent");
            Intrinsics.checkNotNullParameter(r3, "promptContent");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final String a;
        public final List<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<String> r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "UserSelectData(subtitle=" + this.a + ", suffixList=" + this.b + ')';
        }

        public c(String r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ActionBarSendMsgReplyFormat.values().length];
            r0[ActionBarSendMsgReplyFormat.REPLICA_REPLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ActionBarSendMsgReplyFormat.REPLICA_GENERATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new ActionBarSendMsgContentBuilder();
    }

    public ActionBarSendMsgContentBuilder() {
    }

    public static ArrayList x() {
        return CollectionsKt.arrayListOf(new String[]{"，", "。", "；", "：", "～", "！", "？", "#", "、", "/", "…", "&", "*", ",", ".", ";", ":", "~", "!", "?", "^"});
    }

    public static String l(e r2) {
        Intrinsics.checkNotNullParameter(r2, "options");
        String r0 = r2.k;
        if (r0 == null) goto L14;
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r1 = false;
    L14:
        if (Intrinsics.areEqual(r2.a, "zh") == false) goto L16;
        return "，";
    L16:
        return ", ";
    }

    public static boolean n(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.intValue() != 6) goto L11;
    L12:
        return true;
    L5:
        if (r2.intValue() == 30) goto L12;
        goto L6
    }

    public static boolean o(String r1) {
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static boolean p(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L13;
    L14:
        if (r2 != null) goto L17;
    L18:
        if (r2 != null) goto L21;
    L22:
        if (r2 != null) goto L25;
    L26:
        if (r2 != null) goto L29;
    L31:
        return false;
    L29:
        if (r2.intValue() != 33) goto L31;
    L32:
        return true;
    L25:
        if (r2.intValue() == 32) goto L32;
    L21:
        if (r2.intValue() == 28) goto L32;
    L17:
        if (r2.intValue() == 24) goto L32;
    L13:
        if (r2.intValue() == 18) goto L32;
    L9:
        if (r2.intValue() == 16) goto L32;
    L5:
        if (r2.intValue() == 4) goto L32;
        goto L6
    }

    public static boolean q(Integer r2) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.intValue() != 8) goto L11;
    L12:
        return true;
    L5:
        if (r2.intValue() == 4) goto L12;
        goto L6
    }

    public static ouc.b s(i r2) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        ouc.b r3 = k.m(r2);     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == true) goto L16;
        r0 = r4;
    L16:
        return (ouc.b) r0;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static d0 t(i r2) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        d0 r3 = k.n(r2);     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == true) goto L16;
        r0 = r4;
    L16:
        return (d0) r0;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static com.larus.bmhome.actionbar.model.h u(String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        v r1 = xt7.d.b;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) r1.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r2));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        return (com.larus.bmhome.actionbar.model.h) r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static n v(String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        v r1 = xt7.d.b;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl((n) r1.c(n.Companion.serializer(), r2));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        return (n) r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static String j(u r14, e r15) {
        if (r14 != null) goto L5;
        return null;
    L5:
        Integer r1 = r14.b;
        if (r1 != null) goto L9;
    L73:
        if (r1 != null) goto L76;
    L78:
        if (r1 != null) goto L81;
    L97:
        g.a.getClass();
        k1 r16 = g.a(r14);
        if (r16 != null) goto L100;
        return null;
    L100:
        return k1.a.a(r16, l(r15), 2);
    L81:
        if (r1.intValue() != 11) goto L97;
        Integer r2 = r14.a;
        String r4 = r14.d;
        if (r2 != null) goto L86;
    L90:
        String r3 = null;
    L92:
        if (r3 != null) goto L123;
        g.a.getClass();
        k1 r17 = g.a(r14);
        if (r17 != null) goto L122;
        return null;
    L122:
        return k1.a.a(r17, l(r15), 2);
    L123:
        return r3;
    L86:
        if (r2.intValue() != 1) goto L90;
        n r5 = v(r4);
        if (r5 == null) goto L90;
        r3 = r(f(r2, r5, r15), r15);
        goto L92
    L76:
        if (r1.intValue() != 2) goto L78;
        return i(r14.a, r14.d, r15);
    L9:
        if (r1.intValue() != 8) goto L73;
        String r18 = r14.d;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        v r7 = xt7.d.b;     // Catch: Throwable -> L16
        if (r18 != null) goto L14;
        r18 = "";
    L14:
        r7.getClass();     // Catch: Throwable -> L16
        Object r19 = Result.constructor-impl((b0) r7.c(b0.Companion.serializer(), r18));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r19) == false) goto L21;
        r19 = null;
    L21:
        b0 r110 = (b0) r19;
        if (r110 == null) goto L125;
        List<c0> r111 = r110.a;
        if (r111 == null) goto L118;
        ArrayList r8 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L66;
        c0 r9 = (c0) r112.next();
        int r10 = r9.b;
        if (r10 != 3) goto L32;
        ActionBarSendMsgContentBuilder r11 = a;
        Integer r12 = r9.a;
        String r13 = r9.c;
        r11.getClass();
        String r20 = i(r12, r13, r15);
    L64:
        if (r20 == null) goto L28;
        r8.add(r20);
        goto L28
    L32:
        if (r10 == 6) goto L34;
        a.getClass();
        r20 = k1.a.a(r9, l(r15), 2);
        goto L64
    L34:
        ActionBarSendMsgContentBuilder r21 = a;
        Integer r22 = r9.a;
        String r23 = r9.c;
        r21.getClass();
        com.larus.bmhome.actionbar.model.h r24 = u(r23);
        if (r24 != null) goto L38;
    L62:
        r20 = null;
        goto L64
    L38:
        if (n(r22) == true) goto L62;
        if (n(r24.b) == true) goto L62;
        if (q(r22) == false) goto L45;
    L61:
        r20 = r(g(r22, r24, r15), r15);
        goto L64
    L45:
        if (q(r24.b) == true) goto L61;
        List<w> r25 = r24.e;
        if (r25 == null) goto L62;
        ArrayList r26 = new ArrayList();
        Iterator<T> r27 = r25.iterator();
    L51:
        if (r27.hasNext() == false) goto L60;
        String r28 = ((w) r27.next()).d;
        if (r28 != null) goto L55;
    L57:
        r28 = null;
    L58:
        if (r28 == null) goto L51;
        r26.add(r28);
        goto L51
    L55:
        if ((!StringsKt.isBlank(r28)) == false) goto L57;
    L60:
        r20 = CollectionsKt.joinToString$default(r26, l(r15), null, null, 0, null, null, 62, null);
        goto L64
    L66:
        ArrayList r29 = new ArrayList();
        Iterator r113 = r8.iterator();
    L68:
        if (r113.hasNext() == false) goto L119;
        Object r0 = r113.next();
        if ((!StringsKt.isBlank((String) r0)) == false) goto L68;
        r29.add(r0);
        goto L68
    L119:
        return CollectionsKt.joinToString$default(r29, l(r15), null, null, 0, null, null, 62, null);
    L118:
        return null;
    L125:
        return null;
    L16:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public static String k(List r12, e r13) {
        List r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return null;
    L11:
        if (r12.size() <= 1) goto L50;
        List r14 = CollectionsKt.drop(r12, 1);
        ArrayList r2 = new ArrayList();
        Iterator r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L19;
        Object r3 = r15.next();
        g.a.getClass();
        if ((!(g.a((u) r3) instanceof p)) == false) goto L15;
        r2.add(r3);
        goto L15
    L19:
        ArrayList r16 = new ArrayList();
        Iterator r4 = r2.iterator();
    L21:
        if (r4.hasNext() == false) goto L25;
        u r5 = (u) r4.next();
        a.getClass();
        String r6 = j(r5, r13);
        if (r6 == null) goto L21;
        r16.add(r6);
        goto L21
    L25:
        ArrayList r7 = new ArrayList();
        Iterator r17 = r16.iterator();
    L27:
        if (r17.hasNext() == false) goto L32;
        Object r8 = r17.next();
        if ((!StringsKt.isBlank((String) r8)) == false) goto L27;
        r7.add(r8);
        goto L27
    L32:
        return CollectionsKt.joinToString$default(r7, l(r13), null, null, 0, null, null, 62, null);
    L50:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static String r(List r11, e r12) {
        if ((!r11.isEmpty()) == true) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return CollectionsKt.joinToString$default(r11, l(r12), null, null, 0, null, new f(), 30, null);
    }

    public static String w(String r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "options");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r2;
    L8:
        String r1 = String.valueOf(ArraysKt.last(r2.toCharArray()));
        if (Intrinsics.areEqual(r3.a, "zh") == false) goto L11;
        String r4 = "。";
    L13:
        if (x().contains(r1) == false) goto L16;
        return r2;
    L16:
        return r2.concat(r4);
    L11:
        r4 = ".";
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public static String y(d0 r0, String r1) {
        i r2 = (i) r0.get(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return k.g(k.o(r2));
    }

    public static b z(w r4, e r5) {
        String r0 = r4.d;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L9:
        r0 = r4.b;
        if (r0 != null) goto L12;
    L14:
        r0 = null;
    L15:
        if (r0 != null) goto L17;
        return null;
    L17:
        String r6 = (String) r5.j.invoke(r5.a, r4.a);
        if (r6 != null) goto L20;
        String r7 = r0;
    L21:
        if (r6 != null) goto L23;
    L25:
        r1 = false;
    L27:
        return new b(r0, r7, r1);
    L23:
        if (Intrinsics.areEqual(r6, r0) == true) goto L25;
    L20:
        r7 = r6;
        goto L21
    L12:
        if ((!StringsKt.isBlank(r0)) == false) goto L14;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L17;
        goto L9
    }

    public static String d(String r12, List r13, e r14) {
        if (r13 == null) goto L4;
        u r0 = (u) CollectionsKt.firstOrNull(r13);
    L5:
        String r1 = j(r0, r14);
        String r15 = k(r13, r14);
        ArrayList r2 = new ArrayList();
        boolean r10 = false;
        if (r1 != null) goto L8;
    L13:
        if (r15 != null) goto L15;
    L20:
        String r16 = CollectionsKt.joinToString$default(r2, l(r14), null, null, 0, null, null, 62, null);
        if (o(r16) == false) goto L33;
        String r17 = w(r16, r14);
        StringBuilder r3 = new StringBuilder();
        String r18 = StringsKt.trimEnd(r12).toString();
        if (r18.length() != 0) goto L25;
        r10 = true;
    L25:
        if (r10 == false) goto L28;
        r18 = "";
    L31:
        r3.append(r18);
        r3.append(r17);
        return r3.toString();
    L28:
        if (x().contains(String.valueOf(StringsKt.last(r18))) == true) goto L31;
        r18 = r18.concat(l(r14));
        goto L31
    L33:
        return w(r12, r14);
    L15:
        if (r15.length() <= 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        r2.add(r15);
        goto L20
    L17:
        r4 = false;
        goto L18
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        r2.add(r1);
        goto L13
    L10:
        r5 = false;
        goto L11
    L4:
        r0 = null;
        goto L5
    }

    public static String e(String r19, List r20, e r21) {
        if (r20 == null) goto L7;
        u r0 = (u) CollectionsKt.firstOrNull(r20);
        if (r0 == null) goto L7;
        String r1 = r0.d;
    L8:
        String r3 = "";
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        if (StringsKt.isBlank(r1) == false) goto L159;
        List r2 = CollectionsKt.emptyList();
    L91:
        if (o(r19) == false) goto L113;
        r3 = StringsKt.trimEnd(r19).toString();
        char[] r4 = {12290, 65292, 65281, 65311, 65307, 65306, '.', ',', '!', '?', ';', ':'};
        if (r3.length() <= 0) goto L95;
        boolean r7 = true;
    L96:
        if (r7 == false) goto L109;
        int r8 = 0;
    L98:
        if (r8 >= 12) goto L106;
        if (StringsKt.last(r3) != r4[r8]) goto L102;
        boolean r9 = true;
    L103:
        if (r9 == true) goto L104;
        r8 = r8 + 1;
        goto L98
    L104:
        boolean r5 = true;
    L107:
        if (r5 == false) goto L109;
        boolean r6 = true;
    L110:
        if (r6 == true) goto L113;
        r3 = r3.concat("。");
        goto L113
    L102:
        r9 = false;
        goto L103
    L106:
        r5 = false;
    L109:
        r6 = false;
        goto L110
    L95:
        r7 = false;
    L113:
        List r10 = r2;
        Iterator r11 = r10.iterator();
    L115:
        if (r11.hasNext() == false) goto L124;
        Object r12 = r11.next();
        a r13 = (a) r12;
        ActionBarSendMsgContentBuilder r14 = a;
        String r15 = r13.b;
        r14.getClass();
        if (o(r15) == true) goto L119;
    L121:
        boolean r16 = false;
    L122:
        if (r16 == false) goto L115;
    L125:
        a r17 = (a) r12;
        if (r17 == null) goto L129;
        String r18 = r17.a;
        if (r18 == null) goto L129;
    L130:
        if (r17 == null) goto L132;
        r3 = r3 + r18 + r17.c;
    L132:
        Iterator r22 = r10.iterator();
    L134:
        if (r22.hasNext() == false) goto L145;
        Object r23 = r22.next();
        a r24 = (a) r23;
        if (Intrinsics.areEqual(r24, r17) == false) goto L138;
    L142:
        boolean r25 = false;
    L143:
        if (r25 == false) goto L134;
    L146:
        a r26 = (a) r23;
        if (r26 == null) goto L150;
        String r27 = r26.a;
        if (r27 == null) goto L150;
    L151:
        if (r26 == null) goto L189;
        if (r17 == null) goto L154;
        String r28 = r3 + 65292 + r27 + r26.f;
    L156:
        return r28;
    L154:
        r28 = r3 + r27 + r26.f;
        goto L156
    L189:
        return r3;
    L150:
        r27 = r21.g;
        goto L151
    L138:
        if (r24.d == null) goto L142;
        ActionBarSendMsgContentBuilder r29 = a;
        String r30 = r24.f;
        r29.getClass();
        if (o(r30) == false) goto L142;
        r25 = true;
        goto L143
    L145:
        r23 = null;
    L129:
        r18 = r21.f;
        goto L130
    L119:
        if (o(r13.c) == false) goto L121;
        r16 = true;
        goto L122
    L124:
        r12 = null;
        goto L125
    L159:
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L16
        v r32 = xt7.d.b;     // Catch: Throwable -> L16
        r32.getClass();     // Catch: Throwable -> L16
        Object r33 = Result.constructor-impl(s((i) ((d0) r32.c(d0.Companion.serializer(), r1)).get("selector_list")));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r33) == false) goto L21;
        r33 = null;
    L21:
        ouc.b r34 = (ouc.b) r33;
        if (r34 != null) goto L24;
        r2 = CollectionsKt.emptyList();
        goto L91
    L24:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r34.iterator();
    L26:
        if (r36.hasNext() == false) goto L89;
        i r37 = (i) r36.next();
        a.getClass();
        d0 r38 = t(r37);
        if (r38 == null) goto L26;
        String r39 = y(r38, "template");
        if (r39 != null) goto L33;
    L36:
        boolean r40 = true;
    L37:
        if (r40 == true) goto L26;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L41
        v r42 = xt7.d.b;     // Catch: Throwable -> L41
        r42.getClass();     // Catch: Throwable -> L41
        Object r43 = Result.constructor-impl((d0) r42.c(d0.Companion.serializer(), r39));     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r43) == false) goto L46;
        r43 = null;
    L46:
        d0 r44 = (d0) r43;
        if (r44 == null) goto L26;
        a.getClass();
        String r45 = y(r44, "label");
        if (r45 != null) goto L52;
    L60:
        r45 = y(r44, "display_text");
    L61:
        ouc.b r46 = s((i) r44.get("option_list"));
        if (r46 == null) goto L26;
        Iterator r47 = r46.iterator();
    L66:
        if (r47.hasNext() == false) goto L26;
        i r110 = (i) r47.next();
        a.getClass();
        d0 r111 = t(r110);
        if (r111 == null) goto L66;
        d0 r112 = t((i) r111.get("extra"));
        if (r112 == null) goto L66;
        String r113 = y(r112, "page_size_id");
        String r114 = y(r111, "display_text");
        String r115 = y(r112, "selected_id");
        String r116 = y(r112, "selected_type");
        String r117 = y(r112, "selected_result_from");
        if (o(r113) == false) goto L76;
        String r118 = r114;
    L77:
        if (r115 == null) goto L79;
        String r119 = r114;
    L81:
        if (o(r113) == false) goto L85;
        PPTOptionType r120 = PPTOptionType.PAGE_SIZE;
    L88:
        r35.add(new a(r45, r113, r118, r115, r116, r119, r120));
        goto L66
    L85:
        if (Intrinsics.areEqual(r117, "selected_result_from_action_bar_button_router") == false) goto L87;
        r120 = PPTOptionType.TEMPLATE;
        goto L88
    L87:
        r120 = PPTOptionType.UNKNOWN;
        goto L88
    L79:
        r119 = null;
        goto L81
    L76:
        r118 = null;
        goto L77
    L52:
        if (r45.length() <= 0) goto L54;
        boolean r121 = true;
    L55:
        if (r121 == true) goto L58;
        r45 = null;
    L58:
        if (r45 == null) goto L60;
    L54:
        r121 = false;
    L41:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L33:
        if (StringsKt.isBlank(r39) == true) goto L36;
        r40 = false;
        goto L37
    L89:
        r2 = r35;
    L16:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = null;
        goto L8
    }

    public static List f(Integer r2, n r3, e r4) {
        if (r2 == null) goto L7;
        if (r2.intValue() != 1) goto L7;
        List<w> r5 = r3.a;
        if (r5 == null) goto L16;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L17;
        w r0 = (w) r7.next();
        a.getClass();
        b r1 = z(r0, r4);
        if (r1 == null) goto L12;
        r6.add(r1);
    L17:
        if (r6 == null) goto L19;
        return r6;
    L19:
        return CollectionsKt.emptyList();
    L16:
        r6 = null;
    L7:
        return CollectionsKt.emptyList();
    }

    public static List g(Integer r2, com.larus.bmhome.actionbar.model.h r3, e r4) {
        if (q(r2) == false) goto L5;
    L8:
        List<w> r5 = r3.e;
        if (r5 == null) goto L16;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L17;
        w r0 = (w) r7.next();
        a.getClass();
        b r1 = z(r0, r4);
        if (r1 == null) goto L12;
        r6.add(r1);
    L17:
        if (r6 == null) goto L19;
        return r6;
    L19:
        return CollectionsKt.emptyList();
    L16:
        r6 = null;
        goto L17
    L5:
        if (q(r3.b) == true) goto L8;
        return CollectionsKt.emptyList();
    }

    public static String i(Integer r10, String r11, e r12) {
        com.larus.bmhome.actionbar.model.h r13 = u(r11);
        if (r13 != null) goto L6;
        return null;
    L6:
        if (n(r10) == false) goto L8;
        return null;
    L8:
        if (n(r13.b) == false) goto L11;
        return null;
    L11:
        if (q(r10) == true) goto L30;
        if (q(r13.b) == true) goto L30;
        List<w> r14 = r13.e;
        if (r14 == null) goto L37;
        ArrayList r1 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L38;
        String r16 = ((w) r15.next()).d;
        if (r16 != null) goto L23;
    L25:
        r16 = null;
    L26:
        if (r16 == null) goto L19;
        r1.add(r16);
        goto L19
    L23:
        if ((!StringsKt.isBlank(r16)) == false) goto L25;
    L38:
        return CollectionsKt.joinToString$default(r1, l(r12), null, null, 0, null, null, 62, null);
    L37:
        return null;
    L30:
        return r(g(r10, r13, r12), r12);
    }

    public static String a(y1 r11, String r12, List r13, e r14) {
        if (r13.isEmpty() == false) goto L5;
        boolean r0 = true;
    L6:
        String r3 = "";
        if (r0 == false) goto L18;
        q1 r15 = r11.d;
        if (r15 == null) goto L15;
        String r16 = r15.b;
        if (r16 == null) goto L15;
        r3 = r16;
    L15:
        if (o(r3) == false) goto L133;
        r12 = (String) r14.h.invoke(r3, r12);
    L133:
        return r12;
    L18:
        q1 r17 = r11.d;
        if (r17 == null) goto L134;
        List<s1> r18 = r17.c;
        if (r18 == null) goto L135;
        Iterator<T> r19 = r18.iterator();
        String r1 = "";
    L24:
        if (r19.hasNext() == false) goto L95;
        s1 r4 = (s1) r19.next();
        Integer r5 = r4.c;
        if (r5 == null) goto L36;
        if (r5.intValue() != 2) goto L36;
        String r6 = r4.b;
        if (r6 != null) goto L33;
        r6 = "";
    L33:
        a.getClass();
        if (o(r6) == false) goto L24;
        r1 = r1 + ((String) r14.h.invoke(r6, r12));
    L36:
        if (r5 == null) goto L84;
        if (r5.intValue() != 1) goto L84;
        String r7 = r4.a;
        if (r7 != null) goto L43;
        r7 = "";
    L43:
        String r8 = r4.b;
        if (r8 != null) goto L46;
        r8 = "";
    L46:
        a.getClass();
        if (o(r7) == false) goto L24;
        if (o(r8) == false) goto L24;
        Iterator r9 = r13.iterator();
    L51:
        String r10 = null;
        if (r9.hasNext() == false) goto L61;
        List<com.larus.bmhome.actionbar.model.h> r20 = ((com.larus.bmhome.actionbar.model.i) r9.next()).a;
        if (r20 == null) goto L51;
        Iterator<T> r21 = r20.iterator();
    L57:
        if (r21.hasNext() == false) goto L51;
        com.larus.bmhome.actionbar.model.h r22 = (com.larus.bmhome.actionbar.model.h) r21.next();
        if (Intrinsics.areEqual(r22.a, r7) == false) goto L57;
    L62:
        if (r22 == null) goto L81;
        List<w> r23 = r22.e;
        if (r23 == null) goto L81;
        Iterator<T> r24 = r23.iterator();
    L67:
        if (r24.hasNext() == false) goto L77;
        Object r25 = r24.next();
        Integer r26 = ((w) r25).s;
        if (r26 != null) goto L72;
    L74:
        boolean r27 = false;
    L75:
        if (r27 == false) goto L67;
    L78:
        w r28 = (w) r25;
        if (r28 == null) goto L81;
        r10 = r28.b;
        goto L81
    L72:
        if (r26.intValue() != 1) goto L74;
        r27 = true;
        goto L75
    L77:
        r25 = null;
    L81:
        a.getClass();
        if (o(r10) == false) goto L24;
        r1 = r1 + ((String) r14.h.invoke(r8, r10));
        goto L24
    L61:
        r22 = null;
    L84:
        if (r5 == null) goto L24;
        if (r5.intValue() != 3) goto L24;
        String r29 = r4.b;
        if (r29 != null) goto L91;
        r29 = "";
    L91:
        a.getClass();
        if (o(r29) == false) goto L24;
        r1 = r1 + r29;
        goto L24
    L95:
        return r1;
    L135:
        return "";
    L134:
        return "";
    L5:
        r0 = false;
        goto L6
    }

    public static String b(r r2, String r3, ActionBarSendMsgReplyFormat r4, e r5) {
        boolean r0 = p(r2.a);
        if (r5.c == false) goto L8;
        if (r0 == false) goto L8;
        return r3;
    L8:
        return m(r2, r3, r4, r5);
    }

    public static String c(r r7, String r8, List r9, e r10) {
        String r0 = null;
        if (r9 == null) goto L5;
        u r1 = (u) CollectionsKt.firstOrNull(r9);
    L6:
        String r2 = j(r1, r10);
        String r11 = m(r7, r8, null, r10);
        if (o(r2) == false) goto L10;
        r11 = r2 + l(r10) + r11;
    L10:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{9, 22, 21, 27, 2}), r7.a) == true) goto L12;
        r11 = w(r11, r10);
    L12:
        String r12 = k(r9, r10);
        String r3 = "";
        if (o(r12) == false) goto L17;
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        r11 = r11 + w(r12, r10);
    L17:
        if (r9 == null) goto L32;
        Iterator r13 = r9.iterator();
    L20:
        if (r13.hasNext() == false) goto L30;
        Object r14 = r13.next();
        Integer r4 = ((u) r14).b;
        if (r4 != null) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L20;
    L31:
        u r15 = (u) r14;
    L33:
        if (r15 != null) goto L35;
    L47:
        p r16 = null;
    L48:
        if (r16 == null) goto L52;
        h1 r17 = r16.a;
        if (r17 == null) goto L52;
        String r18 = r17.c;
    L53:
        if (r16 == null) goto L58;
        h1 r19 = r16.a;
        if (r19 == null) goto L58;
        r0 = r19.b;
    L58:
        if (o(r18) == false) goto L65;
        Function2<String, Object, String> r20 = r10.h;
        if (r18 == null) goto L63;
        r3 = r18;
    L63:
        r0 = (String) r20.invoke(r3, r0);
    L65:
        if (o(r0) == true) goto L67;
        return r11;
    L67:
        return r11 + "\n\n" + r0;
    L52:
        r18 = null;
        goto L53
    L35:
        if (o(r15.d) == false) goto L47;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L41
        v r22 = xt7.d.b;     // Catch: Throwable -> L41
        String r23 = r15.d;     // Catch: Throwable -> L41
        if (r23 != null) goto L39;
        r23 = "";
    L39:
        r22.getClass();     // Catch: Throwable -> L41
        Object r24 = Result.constructor-impl((p) r22.c(p.Companion.serializer(), r23));     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r24) == false) goto L46;
        r24 = null;
    L46:
        r16 = (p) r24;
    L41:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L25:
        if (r4.intValue() != 3) goto L27;
        r5 = true;
        goto L28
    L30:
        r14 = null;
        goto L31
    L32:
        r15 = null;
        goto L33
    L5:
        r1 = null;
        goto L6
    }

    public static String m(r r3, String r4, ActionBarSendMsgReplyFormat r5, e r6) {
        if (r5 != null) goto L5;
        int r7 = -1;
    L6:
        boolean r1 = true;
        if (r7 == (-1)) goto L22;
        if (r7 != 1) goto L10;
        h1 r8 = r3.c;
        if (r8 == null) goto L25;
        String r9 = r8.h;
    L26:
        String r10 = (String) r6.i.invoke(r9, r4);
        if (r10 == null) goto L30;
        return r10;
    L30:
        if (o(r9) == false) goto L41;
        if (r4.length() <= 0) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == false) goto L41;
        Function2<String, Object, String> r12 = r6.h;
        if (r9 != null) goto L71;
        r9 = "";
    L71:
        return (String) r12.invoke(r9, r4);
    L34:
        r11 = false;
    L41:
        if (o(r9) == true) goto L43;
        return r4;
    L43:
        if (r4.length() == 0) goto L46;
        r1 = false;
    L46:
        if (r1 == false) goto L73;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L60
        if (r6.b == true) goto L51;
    L54:
        String r14 = "：%s";
    L55:
        if (r9 != null) goto L57;
        String r15 = "";
    L58:
        Object r16 = Result.constructor-impl(StringsKt.removeSuffix(r15, r14));     // Catch: Throwable -> L60
    L62:
        if (r9 != null) goto L65;
        r9 = "";
    L65:
        if (Result.isFailure-impl(r16) == false) goto L68;
        r16 = r9;
    L68:
        return (String) r16;
    L57:
        r15 = r9;
        goto L58
    L51:
        if (Intrinsics.areEqual(r6.a, "zh") == true) goto L54;
        r14 = ": %s";
    L60:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L73:
        return r4;
    L25:
        r9 = null;
        goto L26
    L10:
        if (r7 != 2) goto L18;
        h1 r18 = r3.c;
        if (r18 == null) goto L15;
        r9 = r18.j;
        if (r9 != null) goto L26;
    L15:
        if (r18 == null) goto L25;
        r9 = r18.h;
        goto L26
    L18:
        throw new NoWhenBranchMatchedException();
    L22:
        h1 r19 = r3.c;
        if (r19 == null) goto L25;
        r9 = r19.c;
        goto L26
    L5:
        r7 = d.a[r5.ordinal()];
        goto L6
    }

    public static String h(r r5, String r6, String r7, ActionBarSendMsgReplyFormat r8, e r9) {
        boolean r0 = p(r5.a);
        boolean r2 = false;
        if (StringsKt.trim(r6).toString().length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (StringsKt.trim(r7).toString().length() != 0) goto L10;
        r2 = true;
    L10:
        if (r9.c == false) goto L16;
        if (r0 == false) goto L16;
        if (r1 == false) goto L16;
        if (r2 == false) goto L16;
        return m(r5, r6, r8, r9);
    L16:
        return r7;
    L5:
        r1 = false;
        goto L7
    }
}
