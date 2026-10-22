package com.obric.miniapp.aibridge;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t {
    public static final /* synthetic */ int e = 0;
    public final boolean a;
    public final String b;
    public final String c;
    public final JSONObject d;

    public static final class a {
        public a() {
        }

        public static t b(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "sessionKey");
            Intrinsics.checkNotNullParameter(r4, "sessionTag");
            return new t(true, r3, r4, null);
        }

        public static t a(String r3, String r4, String r5, String r6) {
            int r0 = t.e;
            Intrinsics.checkNotNullParameter(r3, "sessionKey");
            Intrinsics.checkNotNullParameter(r4, "sessionTag");
            Intrinsics.checkNotNullParameter(r5, "code");
            Intrinsics.checkNotNullParameter(r6, "message");
            JSONObject r2 = new JSONObject();
            r2.put("code", r5);
            r2.put("message", r6);
            return new t(false, r3, r4, r2);
        }
    }

    static {
        new a();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        JSONObject r2 = this.d;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LiveCardOpResult(ok=" + this.a + ", sessionKey=" + this.b + ", sessionTag=" + this.c + ", error=" + this.d + ')';
    }

    public t(boolean r2, String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "sessionKey");
        Intrinsics.checkNotNullParameter(r4, "sessionTag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
