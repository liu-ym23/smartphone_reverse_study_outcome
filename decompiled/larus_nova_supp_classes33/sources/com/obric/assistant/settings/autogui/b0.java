package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b0 {
    public final ObricAutoGuiItemViewType a;
    public final ObricAutoGuiItemBgType b;
    public final String c;
    public final boolean d;
    public final com.obric.assistant.settings.b e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        com.obric.assistant.settings.b r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.f == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.g == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((((r8 + r9) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.k == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.l == false) goto L29;
        int r15 = 1231;
    L30:
        int r16 = (r14 + r15) * 31;
        if (this.m == true) goto L35;
        r2 = 1237;
    L35:
        return r16 + r2;
    L29:
        r15 = 1237;
        goto L30
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricAutoGuiItemUIModel(viewType=" + this.a + ", bgType=" + this.b + ", title=" + this.c + ", beta=" + this.d + ", appInfo=" + this.e + ", autoGuiEnabled=" + this.f + ", autoExecuteAuthEntryVisible=" + this.g + ", riskPreferenceText=" + this.h + ", fastModeUseText=" + this.i + ", oUseClipboardEnabled=" + this.j + ", skillExtensionAvailable=" + this.k + ", skillExtensionEnabled=" + this.l + ", showGoSettingArrow=" + this.m + ')';
    }

    public static b0 a(b0 r18, boolean r19, String r20, int r21) {
        String r3 = null;
        if ((r21 & 1) == 0) goto L5;
        ObricAutoGuiItemViewType r5 = r18.a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        ObricAutoGuiItemBgType r6 = r18.b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r7 = r18.c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        boolean r8 = r18.d;
    L19:
        if ((r21 & 16) == 0) goto L21;
        com.obric.assistant.settings.b r9 = r18.e;
    L23:
        if ((r21 & 32) == 0) goto L25;
        boolean r10 = r18.f;
    L27:
        if ((r21 & 64) == 0) goto L29;
        boolean r11 = r18.g;
    L31:
        if ((r21 & 128) == 0) goto L33;
        r3 = r18.h;
    L33:
        String r12 = r3;
        if ((r21 & 256) == 0) goto L36;
        String r13 = r18.i;
    L38:
        if ((r21 & 512) == 0) goto L40;
        boolean r14 = r18.j;
    L42:
        if ((r21 & 1024) == 0) goto L44;
        boolean r15 = r18.k;
    L46:
        if ((r21 & 2048) == 0) goto L48;
        boolean r16 = r18.l;
    L50:
        if ((r21 & 4096) == 0) goto L52;
        boolean r17 = r18.m;
    L53:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r5, "viewType");
        Intrinsics.checkNotNullParameter(r6, "bgType");
        Intrinsics.checkNotNullParameter(r7, "title");
        Intrinsics.checkNotNullParameter(r12, "riskPreferenceText");
        Intrinsics.checkNotNullParameter(r13, "fastModeUseText");
        return new b0(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L52:
        r17 = false;
        goto L53
    L48:
        r16 = false;
        goto L50
    L44:
        r15 = false;
        goto L46
    L40:
        r14 = false;
        goto L42
    L36:
        r13 = r20;
        goto L38
    L29:
        r11 = false;
        goto L31
    L25:
        r10 = r19;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = false;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public b0(ObricAutoGuiItemViewType r2, ObricAutoGuiItemBgType r3, String r4, boolean r5, com.obric.assistant.settings.b r6, boolean r7, boolean r8, String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "viewType");
        Intrinsics.checkNotNullParameter(r3, "bgType");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r9, "riskPreferenceText");
        Intrinsics.checkNotNullParameter(r10, "fastModeUseText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }

    public /* synthetic */ b0(ObricAutoGuiItemViewType r17, ObricAutoGuiItemBgType r18, String r19, boolean r20, com.obric.assistant.settings.b r21, boolean r22, boolean r23, String r24, String r25, boolean r26, boolean r27, boolean r28, boolean r29, int r30) {
        if ((r30 & 2) == 0) goto L5;
        ObricAutoGuiItemBgType r4 = ObricAutoGuiItemBgType.NONE;
    L7:
        if ((r30 & 4) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r30 & 8) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r30 & 16) == 0) goto L17;
        com.obric.assistant.settings.b r7 = null;
    L19:
        if ((r30 & 32) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r30 & 64) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r30 & 128) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r30 & 256) == 0) goto L33;
        String r11 = "";
    L35:
        if ((r30 & 512) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r30 & 1024) == 0) goto L41;
        boolean r13 = true;
    L43:
        if ((r30 & 2048) == 0) goto L45;
        boolean r14 = false;
    L47:
        if ((r30 & 4096) == 0) goto L49;
        boolean r15 = false;
    L50:
        this(r17, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L49:
        r15 = r29;
        goto L50
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }
}
