package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final JSONObject f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r10 = this.d;
        int r11 = 0;
        if (r10 != null) goto L9;
        int r12 = 0;
    L10:
        int r13 = (r1 + r12) * 31;
        String r14 = this.e;
        if (r14 != null) goto L13;
        int r15 = 0;
    L14:
        int r16 = (r13 + r15) * 31;
        JSONObject r17 = this.f;
        if (r17 == null) goto L19;
        r11 = r17.hashCode();
    L19:
        return r16 + r11;
    L13:
        r15 = r14.hashCode();
        goto L14
    L9:
        r12 = r10.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LiveCardClientResult(ok=" + this.a + ", sessionKey=" + this.b + ", sessionTag=" + this.c + ", errorCode=" + this.d + ", errorMessage=" + this.e + ", detail=" + this.f + ')';
    }

    public /* synthetic */ o(String r10, String r11, String r12, String r13) {
        this(false, r10, r11, r12, r13, null);
    }

    public o(boolean r10, String r11, String r12, String r13, String r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r11, "sessionKey");
        Intrinsics.checkNotNullParameter(r12, "sessionTag");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
    }
}
