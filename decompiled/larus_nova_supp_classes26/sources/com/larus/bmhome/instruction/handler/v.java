package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.chat.ChatParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v implements zs8.a {
    public final /* synthetic */ w a;

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
    public final String getClickFrom() {
        return "ai_generate_feed_image";
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
        return false;
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
        ChatParam r0 = this.a.e().a(ChatParam.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // zs8.a
    public final String getChatType() {
        ChatParam r0 = this.a.e().a(ChatParam.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        com.larus.bmhome.instruction.n r0 = this.a.m;
        if (r0 == null) goto L8;
        aq8.e r1 = r0.b;
        if (r1 == null) goto L8;
        String r2 = r1.g;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public v(w r1) {
        this.a = r1;
    }
}
