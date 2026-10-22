package com.obric.oui.privacy;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14186c;
    public final List d;
    public final String e;
    public final List f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f14188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f14189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f14190k;

    public c(String r5, String r10, String r11, List r12, String r13, List r14, String r15, String r16, boolean r17, boolean r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r10, "appName");
        Intrinsics.checkNotNullParameter(r12, "items");
        Intrinsics.checkNotNullParameter(r14, "privacyPolicyLinkTexts");
        this.f14184a = r5;
        this.f14185b = r10;
        this.f14186c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f14187h = r16;
        this.f14188i = r17;
        this.f14189j = r18;
        this.f14190k = r19;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f14184a;
        if (Intrinsics.areEqual(this.f14184a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14185b, r10.f14185b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f14186c, r10.f14186c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f14187h, r10.f14187h) == true) goto L33;
        return false;
    L33:
        if (this.f14188i == r10.f14188i) goto L36;
        return false;
    L36:
        if (this.f14189j == r10.f14189j) goto L39;
        return false;
    L39:
        if (this.f14190k == r10.f14190k) goto L41;
        return false;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14, types: [int] */
    /* JADX WARN: Type inference failed for: r3v16, types: [int] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f14184a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = androidx.constraintlayout.motion.widget.a.c(r11 * 31, 31, this.f14185b);
        String r13 = this.f14186c;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = androidx.constraintlayout.motion.widget.a.f(this.d, (r12 + r14) * 31, 31);
        String r16 = this.e;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = androidx.constraintlayout.motion.widget.a.f(this.f, (r15 + r17) * 31, 31);
        String r19 = this.g;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.f14187h;
        if (r22 == null) goto L22;
        r5 = r22.hashCode();
    L22:
        int r23 = (r21 + r5) * 31;
        ?? r24 = 1;
        boolean r25 = this.f14188i;
        ?? r26 = r25;
        if (r25 == false) goto L25;
        r26 = 1;
    L25:
        int r27 = (r23 + r26) * 31;
        boolean r28 = this.f14189j;
        ?? r29 = r28;
        if (r28 == false) goto L28;
        r29 = 1;
    L28:
        int r30 = (r27 + r29) * 31;
        boolean r31 = this.f14190k;
        if (r31 == true) goto L33;
        r24 = r31;
    L33:
        return r30 + r24;
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("OPrivacySheetConfig(appIconPackageName=");
        r5.append(this.f14184a);
        r5.append(", appName=");
        r5.append(this.f14185b);
        r5.append(", appDescription=");
        r5.append(this.f14186c);
        r5.append(", items=");
        r5.append(this.d);
        r5.append(", privacyPolicyText=");
        r5.append(this.e);
        r5.append(", privacyPolicyLinkTexts=");
        r5.append(this.f);
        r5.append(", agreeButtonText=");
        r5.append(this.g);
        r5.append(", exitButtonText=");
        r5.append(this.f14187h);
        r5.append(", enableDim=");
        r5.append(this.f14188i);
        r5.append(", cancelable=");
        r5.append(this.f14189j);
        r5.append(", enableEnterAnim=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f14190k, ')');
    }
}
