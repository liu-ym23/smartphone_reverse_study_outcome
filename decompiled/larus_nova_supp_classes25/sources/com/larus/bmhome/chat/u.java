package com.larus.bmhome.chat;

import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.kmp.chat.TemplateInfo;
import zs8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u implements a {
    public final /* synthetic */ String a;
    public final /* synthetic */ TemplateInfo.TemplateInfo b;

    public final String Y1() {
        return null;
    }

    public final String a() {
        return null;
    }

    public final String b() {
        return "chat";
    }

    public final String c() {
        return null;
    }

    public final String e() {
        return null;
    }

    public final String f() {
        return null;
    }

    public final String g() {
        return null;
    }

    public final String getChatType() {
        return "other_default";
    }

    public final String getClickFrom() {
        return "use_template";
    }

    public final String getEnterMethod() {
        return "use_template";
    }

    public final String h() {
        return "action_bar_template";
    }

    public final String i() {
        return null;
    }

    public final String j() {
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

    public final String p() {
        return null;
    }

    public final String d() {
        UserCreation r0 = this.b.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return zp9.d.c(r0);
    }

    public final String getTemplateType() {
        UserCreation r0 = this.b.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return zp9.d.d(r0);
    }

    public final String getBotId() {
        return this.a;
    }

    public u(String r1, TemplateInfo.TemplateInfo r2) {
        this.a = r1;
        this.b = r2;
    }
}
