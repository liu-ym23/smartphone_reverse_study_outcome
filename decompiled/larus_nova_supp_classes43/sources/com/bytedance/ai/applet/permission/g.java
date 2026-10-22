package com.bytedance.ai.applet.permission;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final /* synthetic */ int c = 0;
    public final String a;
    public final Map<String, Boolean> b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppletGetSettingResult(reason=" + this.a + ", authSetting=" + this.b + ')';
    }

    public g(String r10, Map<String, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "authSetting");
        this.a = r10;
        this.b = r11;
    }
}
