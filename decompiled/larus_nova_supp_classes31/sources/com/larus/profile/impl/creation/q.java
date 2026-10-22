package com.larus.profile.impl.creation;

import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements zs8.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ sq9.p b;
    public final /* synthetic */ UserCreation c;

    public final String a() {
        return null;
    }

    public final String c() {
        return null;
    }

    public final String getBotId() {
        return null;
    }

    public final String getChatType() {
        return null;
    }

    public final String i() {
        return null;
    }

    public final boolean l() {
        return false;
    }

    public final String m() {
        return null;
    }

    public final String o() {
        return null;
    }

    public final String Y1() {
        return this.b.i;
    }

    public final String d() {
        return zp9.d.c(this.c);
    }

    public final String e() {
        sq9.d0 r0 = this.b.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final String f() {
        UserCreationTrackParams r0 = this.c.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final String g() {
        sq9.d0 r0 = this.b.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final String getClickFrom() {
        String r0 = this.b.c;
        if (r0 != null) goto L6;
        return "use_template";
    L6:
        return r0;
    }

    public final String getEnterMethod() {
        String r0 = this.b.c;
        if (r0 != null) goto L6;
        return "use_template";
    L6:
        return r0;
    }

    public final String getTemplateType() {
        return zp9.d.d(this.c);
    }

    public final String h() {
        return this.b.g;
    }

    public final String j() {
        UserCreationTrackParams r0 = this.c.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public final String k() {
        sq9.d0 r0 = this.b.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final String n() {
        sq9.d0 r0 = this.b.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final String p() {
        UserCreationTrackParams r0 = this.c.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final String b() {
        return this.a;
    }

    public q(String r1, sq9.p r2, UserCreation r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
