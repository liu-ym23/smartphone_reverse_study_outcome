package com.obric.assistant.feedback;

import com.obric.capabilitykit.common.UiType;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricFeedbackService$c {
    public final List<String> a;
    public final String b;
    public final List<String> c;
    public final List<String> d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Boolean i;
    public final Integer j;
    public final boolean k;
    public final List<String> l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final String p;
    public final String q;
    public final boolean r;
    public final Function1<IObricFeedbackService$b, Unit> s;

    public IObricFeedbackService$c() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, false, false, false, null, false, null, 524287);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IObricFeedbackService$c) == true) goto L8;
        return false;
    L8:
        IObricFeedbackService$c r6 = (IObricFeedbackService$c) r5;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (this.n == r6.n) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.a;
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
        List<String> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.d;
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
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        int r31 = 1231;
        if (this.k == false) goto L45;
        int r32 = 1231;
    L46:
        int r33 = (r30 + r32) * 31;
        List<String> r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        if (this.m == false) goto L53;
        int r37 = 1231;
    L54:
        int r38 = (r36 + r37) * 31;
        if (this.n == false) goto L57;
        int r39 = 1231;
    L58:
        int r40 = (r38 + r39) * 31;
        if (this.o == false) goto L61;
        int r41 = 1231;
    L62:
        int r42 = (r40 + r41) * 31;
        String r43 = this.p;
        if (r43 != null) goto L65;
        int r44 = 0;
    L66:
        int r45 = (r42 + r44) * 31;
        String r46 = this.q;
        if (r46 != null) goto L69;
        int r47 = 0;
    L70:
        int r48 = (r45 + r47) * 31;
        if (this.r == true) goto L74;
        r31 = 1237;
    L74:
        int r49 = (r48 + r31) * 31;
        Function1<IObricFeedbackService$b, Unit> r50 = this.s;
        if (r50 == null) goto L79;
        r1 = r50.hashCode();
    L79:
        return r49 + r1;
    L69:
        r47 = r46.hashCode();
        goto L70
    L65:
        r44 = r43.hashCode();
        goto L66
    L61:
        r41 = 1237;
        goto L62
    L57:
        r39 = 1237;
        goto L58
    L53:
        r37 = 1237;
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = 1237;
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "FeedbackParam(tagList=" + this.a + ", content=" + this.b + ", urlList=" + this.c + ", messageIdList=" + this.d + ", feedbackMsgId=" + this.e + ", feedbackSource=" + this.f + ", feedbackBizType=" + this.g + ", searchTool=" + this.h + ", isConsentChecked=" + this.i + ", score=" + this.j + ", needUploadImage=" + this.k + ", filePathList=" + this.l + ", launchReportAppWhenNoPermission=" + this.m + ", needReportToVoc=" + this.n + ", needShowToast=" + this.o + ", omniTaskId=" + this.p + ", omniFeedbackType=" + this.q + ", useRawContent=" + this.r + ", onCompleteCallback=" + this.s + ')';
    }

    public IObricFeedbackService$c(List r21, String r22, List r23, List r24, String r25, String r26, String r27, String r28, Boolean r29, Integer r30, boolean r31, List r32, boolean r33, boolean r34, boolean r35, String r36, boolean r37, Function1 r38, int r39) {
        if ((r39 & 1) == 0) goto L5;
        List r2 = null;
    L7:
        if ((r39 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r39 & 4) == 0) goto L13;
        List r5 = null;
    L15:
        if ((r39 & 8) == 0) goto L17;
        List r6 = null;
    L19:
        if ((r39 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r39 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r39 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r39 & 256) == 0) goto L37;
        Boolean r11 = null;
    L39:
        if ((r39 & 512) == 0) goto L41;
        Integer r12 = null;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        boolean r13 = true;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        List r14 = null;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        boolean r15 = false;
    L55:
        if ((r39 & 8192) == 0) goto L57;
        boolean r3 = false;
    L58:
        boolean r210 = r3;
        if ((r39 & 16384) == 0) goto L61;
        boolean r16 = false;
    L63:
        if ((r39 & 32768) == 0) goto L65;
        String r18 = null;
    L67:
        if ((r39 & UiType.FLAG_PHONE_CARD) == 0) goto L69;
        boolean r19 = false;
    L71:
        if ((r39 & UiType.FLAG_TIMER_CARD) == 0) goto L73;
        Function1 r1 = null;
    L74:
        this.a = r2;
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
        this.l = r14;
        this.m = r15;
        this.n = r210;
        this.o = r16;
        this.p = r18;
        this.q = null;
        this.r = r19;
        this.s = r1;
        return;
    L73:
        r1 = r38;
        goto L74
    L69:
        r19 = r37;
        goto L71
    L65:
        r18 = r36;
        goto L67
    L61:
        r16 = r35;
        goto L63
    L57:
        r3 = r34;
        goto L58
    L53:
        r15 = r33;
        goto L55
    L49:
        r14 = r32;
        goto L51
    L45:
        r13 = r31;
        goto L47
    L41:
        r12 = r30;
        goto L43
    L37:
        r11 = r29;
        goto L39
    L33:
        r10 = r28;
        goto L35
    L29:
        r9 = r27;
        goto L31
    L25:
        r8 = r26;
        goto L27
    L21:
        r7 = r25;
        goto L23
    L17:
        r6 = r24;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r4 = r22;
        goto L11
    L5:
        r2 = r21;
        goto L7
    }
}
