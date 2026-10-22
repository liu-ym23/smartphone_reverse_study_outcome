package com.bytedance.ai.applet.douyinAuth;

import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final GrantingAction a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DouyinGeneralAuthRequestResult(userAction=" + this.a + ", errorMsg=" + this.b + ')';
    }

    public d(GrantingAction r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "userAction");
        this.a = r10;
        this.b = r11;
    }
}
