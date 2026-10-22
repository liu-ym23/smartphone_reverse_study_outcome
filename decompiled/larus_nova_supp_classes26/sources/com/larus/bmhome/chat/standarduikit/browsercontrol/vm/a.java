package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.block.BrowserControlUserAction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final BrowserControlUserAction b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Function0<Boolean> h;
    public final boolean i;
    public final Boolean j;

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
        if (this.b == r6.b) goto L15;
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
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Function0<Boolean> r1 = this.h;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.i == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Boolean r7 = this.j;
        if (r7 == null) goto L15;
        r2 = r7.hashCode();
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BrowserControlVMData(dataIdentifier=" + this.a + ", userAction=" + this.b + ", toolCallId=" + this.c + ", title=" + this.d + ", url=" + this.e + ", leftDarkIcon=" + this.f + ", leftLightIcon=" + this.g + ", interceptClickCard=" + this.h + ", disableFoldExpandClick=" + this.i + ", initialFoldState=" + this.j + ')';
    }

    public a(String r2, BrowserControlUserAction r3, String r4, String r5, String r6, String r7, String r8, dj8.b r9, boolean r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "dataIdentifier");
        Intrinsics.checkNotNullParameter(r3, "userAction");
        Intrinsics.checkNotNullParameter(r4, "toolCallId");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, ShareType.URL);
        Intrinsics.checkNotNullParameter(r7, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r8, "leftLightIcon");
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
    }
}
