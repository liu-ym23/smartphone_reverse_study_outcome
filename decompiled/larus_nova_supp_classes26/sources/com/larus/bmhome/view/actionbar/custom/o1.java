package com.larus.bmhome.view.actionbar.custom;

import com.larus.bmhome.chat.ChatParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o1 implements zs8.a {
    public final /* synthetic */ aq8.e a;
    public final /* synthetic */ CustomActionBar b;
    public final /* synthetic */ com.larus.bmhome.actionbar.model.z0 c;

    @Override // zs8.a
    public final String Y1() {
        return null;
    }

    @Override // zs8.a
    public final String a() {
        return null;
    }

    @Override // zs8.a
    public final String b() {
        return "chat";
    }

    @Override // zs8.a
    public final String c() {
        return null;
    }

    @Override // zs8.a
    public final String d() {
        return null;
    }

    @Override // zs8.a
    public final String e() {
        return null;
    }

    @Override // zs8.a
    public final String f() {
        return null;
    }

    @Override // zs8.a
    public final String g() {
        return null;
    }

    @Override // zs8.a
    public final String getTemplateType() {
        return null;
    }

    @Override // zs8.a
    public final String h() {
        return null;
    }

    @Override // zs8.a
    public final String i() {
        return null;
    }

    @Override // zs8.a
    public final String j() {
        return null;
    }

    @Override // zs8.a
    public final String k() {
        return null;
    }

    @Override // zs8.a
    public final boolean l() {
        return true;
    }

    @Override // zs8.a
    public final String m() {
        return null;
    }

    @Override // zs8.a
    public final String n() {
        return null;
    }

    @Override // zs8.a
    public final String o() {
        return null;
    }

    @Override // zs8.a
    public final String p() {
        return null;
    }

    @Override // zs8.a
    public final String getBotId() {
        ChatParam r0 = this.b.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // zs8.a
    public final String getChatType() {
        ChatParam r0 = this.b.h;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // zs8.a
    public final String getClickFrom() {
        CustomActionBar r0 = this.b;
        com.larus.bmhome.actionbar.model.z0 r1 = this.c;
        r0.getClass();
        com.larus.bmhome.actionbar.model.r r2 = r1.q;
        if (r2 == null) goto L5;
        Integer r3 = r2.a;
    L6:
        if (r3 != null) goto L9;
    L11:
        return "ai_generate_feed_image";
    L9:
        if (r3.intValue() != 18) goto L11;
        return "ai_generate_feed_video";
    L5:
        r3 = null;
        goto L6
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        aq8.e r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.g;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "chat_action_bar";
    }

    public o1(aq8.e r1, CustomActionBar r2, com.larus.bmhome.actionbar.model.z0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
