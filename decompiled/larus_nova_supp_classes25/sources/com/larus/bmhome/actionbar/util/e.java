package com.larus.bmhome.actionbar.util;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Function2<String, Object, String> h;
    public final Function2<String, String, String> i;
    public final Function2<String, Long, String> j;
    public final String k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((((((((((((((r3 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        String r5 = this.k;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ActionBarSendMsgContentBuildOptions(languageCode=" + this.a + ", isOversea=" + this.b + ", removeScreenPromptPrefixEnabled=" + this.c + ", outpaintOriginalRatioText=" + this.d + ", outpaintSelectedRatioFormat=" + this.e + ", pptPageSizeFallbackLabel=" + this.f + ", pptTemplateFallbackLabel=" + this.g + ", formatString=" + this.h + ", obricUserInputFormatter=" + this.i + ", stylePromptMessageTextProvider=" + this.j + ", promptSeparator=" + this.k + ')';
    }

    public e() {
        this("zh", false, false, "", "%s", "", "", new b(), c.a, d.a, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r2, boolean r3, boolean r4, String r5, String r6, String r7, String r8, Function2<? super String, Object, String> r9, Function2<? super String, ? super String, String> r10, Function2<? super String, ? super Long, String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "languageCode");
        Intrinsics.checkNotNullParameter(r5, "outpaintOriginalRatioText");
        Intrinsics.checkNotNullParameter(r6, "outpaintSelectedRatioFormat");
        Intrinsics.checkNotNullParameter(r7, "pptPageSizeFallbackLabel");
        Intrinsics.checkNotNullParameter(r8, "pptTemplateFallbackLabel");
        Intrinsics.checkNotNullParameter(r9, "formatString");
        Intrinsics.checkNotNullParameter(r10, "obricUserInputFormatter");
        Intrinsics.checkNotNullParameter(r11, "stylePromptMessageTextProvider");
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
    }
}
