package com.larus.agents.impl.webfetch;

import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;

    public static final class a {
        public static h a() {
            Object r0 = z2.a.P1("web_fetch_request_config");
            String r2 = null;
            if ((r0 instanceof JSONObject) == false) goto L5;
            JSONObject r1 = (JSONObject) r0;
        L7:
            if (r1 == null) goto L9;
            Object r3 = r1.opt("user_agent");
        L11:
            if ((r3 instanceof String) == false) goto L13;
            String r4 = (String) r3;
        L14:
            String r5 = "";
            if (r4 != null) goto L17;
            r4 = "";
        L17:
            if (r1 == null) goto L19;
            Object r6 = r1.opt("accept");
        L21:
            if ((r6 instanceof String) == false) goto L23;
            r2 = (String) r6;
        L23:
            if (r2 == null) goto L26;
            r5 = r2;
        L26:
            int r7 = 10;
            if (r1 == null) goto L29;
            r7 = r1.optInt("max_redirect", 10);
        L29:
            boolean r8 = false;
            if (r1 == null) goto L33;
            r8 = r1.optBoolean("disable", false);
        L33:
            return new h(r4, r5, r7, r8);
        L19:
            r6 = null;
            goto L21
        L13:
            r4 = null;
            goto L14
        L9:
            r3 = null;
            goto L11
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
    }

    public h() {
        this("", "", 10, false);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "WebFetchAppSettings(userAgent=" + this.a + ", accept=" + this.b + ", maxRedirect=" + this.c + ", disable=" + this.d + ')';
    }

    public h(String r2, String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "userAgent");
        Intrinsics.checkNotNullParameter(r3, "accept");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
