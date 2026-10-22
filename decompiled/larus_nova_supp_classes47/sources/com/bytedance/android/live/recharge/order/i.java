package com.bytedance.android.live.recharge.order;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public String b;
    public String c;

    public static final class a {
        @JvmStatic
        public static i a(com.bytedance.android.live.recharge.model.d r4) {
            i r0 = new i(null, null, 7);
            String r1 = "";
            if (r4 != null) goto L5;
        L7:
            String r2 = "";
        L8:
            r0.b = r2;
            if (r4 == null) goto L14;
            String r5 = r4.b;
            if (r5 == null) goto L14;
            r1 = r5;
        L14:
            r0.c = r1;
            return r0;
        L5:
            if (r4.a != true) goto L7;
            r2 = "room";
            goto L8
        }
    }

    static {
    }

    public i() {
        this(null, null, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L12;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RechargeChannelPrams(platform=" + this.a + ", bizPage=" + this.b + ", bizScene=" + this.c + ")";
    }

    public final String a() {
        JSONObject r0 = new JSONObject();
        r0.put("l1", this.a);
        r0.put("l2", this.b);
        r0.put("l3", this.c);
        return r0.toString();
    }

    public i(String r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        String r0 = "android";
    L7:
        if ((r6 & 2) == 0) goto L10;
        r4 = "";
    L10:
        if ((r6 & 4) == 0) goto L12;
        r5 = "";
    L12:
        this.a = r0;
        this.b = r4;
        this.c = r5;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
