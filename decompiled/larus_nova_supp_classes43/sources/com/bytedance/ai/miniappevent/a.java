package com.bytedance.ai.miniappevent;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final JsonObject d;
    public final AIMiniAppNativeTrigger e;
    public final String f;
    public final String g;
    public final long h;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
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
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r11.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.g;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        long r14 = this.h;
        return ((r12 + r10) * 31) + ((int) (r14 ^ (r14 >>> 32)));
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIMiniAppNativeEvent(appletId=" + this.a + ", eventId=" + this.b + ", eventName=" + this.c + ", payload=" + this.d + ", trigger=" + this.e + ", msgId=" + this.f + ", logId=" + this.g + ", ttlMillis=" + this.h + ')';
    }

    public a(String r10, String r11, JsonObject r12, AIMiniAppNativeTrigger r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "eventId");
        Intrinsics.checkNotNullParameter("action_bar_exposed", "eventName");
        Intrinsics.checkNotNullParameter(r12, "payload");
        Intrinsics.checkNotNullParameter(r13, "trigger");
        this.a = r10;
        this.b = r11;
        this.c = "action_bar_exposed";
        this.d = r12;
        this.e = r13;
        this.f = null;
        this.g = r14;
        this.h = 30000;
    }
}
