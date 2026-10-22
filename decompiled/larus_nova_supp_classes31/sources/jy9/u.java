package jy9;

import com.larus.im.bean.bot.BotModel;
import com.larus.uaigc.utils.DataConverterKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u implements zs8.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a c;

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
        BotModel r0 = this.c.i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return DataConverterKt.b(r0);
    }

    public final String getBotId() {
        return this.b;
    }

    public final String getEnterMethod() {
        return this.a;
    }

    public u(String r1, String r2, a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
