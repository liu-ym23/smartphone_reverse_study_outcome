package com.larus.bmhome.chat.model.repo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class IBotRepoService$a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IBotRepoService$a) == true) goto L8;
        return false;
    L8:
        IBotRepoService$a r6 = (IBotRepoService$a) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActionBarConfParam(languageCode=" + this.a + ", botId=" + this.b + ", cvsId=" + this.c + ", scene=" + this.d + ", throughToken=" + this.e + ')';
    }

    public /* synthetic */ IBotRepoService$a(String r7, String r8, String r9) {
        this(r7, r8, r9, "", null);
    }

    public IBotRepoService$a(String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "languageCode");
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "cvsId");
        Intrinsics.checkNotNullParameter(r5, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
