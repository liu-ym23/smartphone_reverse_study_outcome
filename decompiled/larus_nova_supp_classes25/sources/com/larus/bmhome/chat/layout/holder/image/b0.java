package com.larus.bmhome.chat.layout.holder.image;

import com.larus.im.bean.bot.BotModel;
import com.larus.uaigc.utils.DataConverterKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements zs8.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ BotModel b;

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

    public final String getClickFrom() {
        return "ai_generate_feed_image";
    }

    public final String getEnterMethod() {
        return "ai_edit_picture_detail";
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

    public final String getChatType() {
        BotModel r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return DataConverterKt.b(r0);
    }

    public final String getBotId() {
        return this.a;
    }

    public b0(String r1, BotModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
