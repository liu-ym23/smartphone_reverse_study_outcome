package com.larus.profile.impl.creation;

import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v1 implements zs8.a {
    public final /* synthetic */ UserCreation a;

    public final String Y1() {
        return null;
    }

    public final String a() {
        return null;
    }

    public final String b() {
        return "creation_detail";
    }

    public final String c() {
        return null;
    }

    public final String e() {
        return null;
    }

    public final String g() {
        return null;
    }

    public final String getBotId() {
        return null;
    }

    public final String getChatType() {
        return null;
    }

    public final String getClickFrom() {
        return "use_template";
    }

    public final String getEnterMethod() {
        return "use_template";
    }

    public final String h() {
        return null;
    }

    public final String i() {
        return null;
    }

    public final String k() {
        return null;
    }

    public final boolean l() {
        return false;
    }

    public final String m() {
        return null;
    }

    public final String n() {
        return null;
    }

    public final String o() {
        return null;
    }

    public final String d() {
        return zp9.d.c(this.a);
    }

    public final String f() {
        UserCreationTrackParams r0 = this.a.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    public final String getTemplateType() {
        return zp9.d.d(this.a);
    }

    public final String j() {
        UserCreationTrackParams r0 = this.a.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public final String p() {
        UserCreationTrackParams r0 = this.a.n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public v1(UserCreation r1) {
        this.a = r1;
    }
}
