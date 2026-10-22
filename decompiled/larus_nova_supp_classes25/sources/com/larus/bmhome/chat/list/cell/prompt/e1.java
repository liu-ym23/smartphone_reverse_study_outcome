package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e1 {
    public static final /* synthetic */ int l = 0;
    public final PromptBizType a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final Map<String, String> k;

    public static final class a {
        public static e1 a(PromptContent.SuggestItem r14, Message r15, String r16, int r17) {
            Intrinsics.checkNotNullParameter(r15, "message");
            if (com.larus.bmhome.chat.bean.d.k0(r15) == false) goto L7;
            PromptBizType r0 = PromptBizType.FIRST_MET;
        L5:
            PromptBizType r2 = r0;
            if (com.larus.bmhome.chat.bean.d.z0(r15) == true) goto L14;
            if (r14 == null) goto L14;
            Map r12 = MapsKt.mapOf(TuplesKt.to("enter_method", r14.getSuggestedType()));
        L16:
            if (r14 == null) goto L18;
            String r4 = r14.getItemId();
        L19:
            String r5 = com.larus.im.bean.message.a.x(r15);
            if (r14 == null) goto L22;
            String r7 = r14.getPromptFrom();
        L23:
            if (r14 == null) goto L25;
            String r8 = r14.getTemplateSubType();
        L26:
            if (r14 == null) goto L28;
            String r9 = r14.getTagCode();
        L29:
            if (r14 == null) goto L31;
            String r10 = r14.getActionBarTemplateId();
        L33:
            return new e1(r2, r4, r5, r17, r16, r7, r8, r9, r10, null, r12, 512);
        L31:
            r10 = null;
            goto L33
        L28:
            r9 = null;
            goto L29
        L25:
            r8 = null;
            goto L26
        L22:
            r7 = null;
            goto L23
        L18:
            r4 = null;
        L14:
            r12 = null;
            goto L16
        L7:
            if (com.larus.bmhome.chat.bean.d.z0(r15) == false) goto L9;
            r0 = PromptBizType.WELCOME_BACK;
            goto L5
        L9:
            r0 = PromptBizType.SUGGEST;
            goto L5
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PromptBizType.values().length];
            r0[PromptBizType.FIRST_MET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PromptBizType.WELCOME_BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PromptBizType.SUGGEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public e1() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r6 = (e1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.d) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.i;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.j;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Map<String, String> r26 = this.k;
        if (r26 == null) goto L39;
        r2 = r26.hashCode();
    L39:
        return r25 + r2;
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PromptLogParams(bizType=" + this.a + ", itemId=" + this.b + ", logId=" + this.c + ", position=" + this.d + ", promptType=" + this.e + ", promptFrom=" + this.f + ", templateSubType=" + this.g + ", tagCode=" + this.h + ", actionBarTemplateId=" + this.i + ", visualSize=" + this.j + ", sugParams=" + this.k + ')';
    }

    public final String a() {
        PromptBizType r0 = this.a;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "first_met";
    L5:
        if (r1 != 2) goto L7;
        return "new_topic";
    L7:
        if (r1 != 3) goto L15;
        Map<String, String> r2 = this.k;
        if (r2 == null) goto L11;
        String r3 = r2.get("enter_method");
    L12:
        if (r3 != null) goto L19;
        return "";
    L19:
        return r3;
    L11:
        r3 = null;
        goto L12
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final String b() {
        String r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return "use_prompt";
    L11:
        return "use_template";
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String c() {
        PromptBizType r0 = this.a;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "first_met";
    L5:
        if (r1 != 2) goto L7;
        return "new_topic";
    L7:
        if (r1 != 3) goto L10;
        return "";
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public e1(PromptBizType r3, String r4, String r5, int r6, String r7, String r8, String r9, String r10, String r11, String r12, Map r13, int r14) {
        if ((r14 & 8) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r14 & 64) == 0) goto L9;
        r9 = null;
    L9:
        if ((r14 & 128) == 0) goto L12;
        r10 = null;
    L12:
        if ((r14 & 256) == 0) goto L15;
        r11 = null;
    L15:
        if ((r14 & 512) == 0) goto L18;
        r12 = null;
    L18:
        if ((r14 & 1024) == 0) goto L20;
        r13 = null;
    L20:
        Intrinsics.checkNotNullParameter(r3, "bizType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
    }
}
