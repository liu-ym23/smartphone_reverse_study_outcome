package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public JSONObject a;
    public final String b;
    public String c;
    public String d;
    public final AuthScene e;

    public f() {
        this(null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "AuthDialogRenderInfo(lifeTraceInfo=" + this.a + ", title=" + this.b + ", cancelText=" + this.c + ", confirmText=" + this.d + ", authScene=" + this.e + ')';
    }

    public f(String r6, AuthScene r7, int r8) {
        String r1 = null;
        if ((r8 & 1) == 0) goto L5;
        JSONObject r0 = new JSONObject();
    L7:
        if ((r8 & 2) == 0) goto L10;
        r6 = "";
    L10:
        if ((r8 & 4) == 0) goto L12;
        String r2 = "";
    L14:
        if ((r8 & 8) == 0) goto L17;
        r1 = "";
    L17:
        if ((r8 & 16) == 0) goto L19;
        r7 = AuthScene.LocalLife;
    L19:
        Intrinsics.checkNotNullParameter(r0, "lifeTraceInfo");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r2, "cancelText");
        Intrinsics.checkNotNullParameter(r1, "confirmText");
        Intrinsics.checkNotNullParameter(r7, "authScene");
        this.a = r0;
        this.b = r6;
        this.c = r2;
        this.d = r1;
        this.e = r7;
        return;
    L12:
        r2 = null;
        goto L14
    L5:
        r0 = null;
        goto L7
    }
}
