package com.larus.uaigc.createpage.component.instruction;

import com.larus.bmhome.chat.ChatParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p1 implements zs8.a {
    public final /* synthetic */ aq8.e a;
    public final /* synthetic */ ChatParam b;
    public final /* synthetic */ CreationEditorComponent c;
    public final /* synthetic */ com.larus.bmhome.actionbar.model.z0 d;

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

    public final String d() {
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

    public final String getTemplateType() {
        return null;
    }

    public final String h() {
        return null;
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
        return true;
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

    public final String getBotId() {
        ChatParam r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final String getChatType() {
        ChatParam r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final String getClickFrom() {
        CreationEditorComponent r0 = this.c;
        com.larus.bmhome.actionbar.model.z0 r1 = this.d;
        int r2 = CreationEditorComponent.g2;
        r0.getClass();
        com.larus.bmhome.actionbar.model.r r3 = r1.q;
        if (r3 == null) goto L5;
        Integer r4 = r3.a;
    L6:
        if (r4 != null) goto L9;
    L11:
        return "ai_generate_feed_image";
    L9:
        if (r4.intValue() != 18) goto L11;
        return "ai_generate_feed_video";
    L5:
        r4 = null;
        goto L6
    }

    public final String getEnterMethod() {
        aq8.e r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.g;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "chat_action_bar";
    }

    public p1(aq8.e r1, ChatParam r2, CreationEditorComponent r3, com.larus.bmhome.actionbar.model.z0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
