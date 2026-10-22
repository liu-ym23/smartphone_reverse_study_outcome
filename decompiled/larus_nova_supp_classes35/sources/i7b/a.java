package i7b;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public String a;
    public int b;
    public boolean c;
    public boolean d;
    public String e;
    public Chat f;
    public ChatChatter g;
    public ChatChatter h;
    public OpenApp i;
    public ChatThemeInfo j;
    public boolean k;
    public String l;
    public String m;
    public ChatTeamBundle n;

    public final boolean a() {
        if (TextUtils.isEmpty(this.e) == false) goto L6;
        Log.e("ChatWindowInitData", "open chat failed，chatId is null!!!");
        return false;
    L6:
        Chat r0 = this.f;
        if (r0 != null) goto L11;
        Log.e("ChatWindowInitData", "open chat failed，chat is null，chatId:" + this.e);
        return false;
    L11:
        if (r0.isSecret() == true) goto L16;
        if (this.f.isFake() == false) goto L16;
        return true;
    L16:
        if (this.f.getType() != Chat.Type.P2P) goto L22;
        if (this.g != null) goto L22;
        Log.e("ChatWindowInitData", "open chat failed，chatter is null, chatId:" + this.e);
        return false;
    L22:
        if (this.h != null) goto L25;
        Log.e("ChatWindowInitData", "open chat failed, self is null，chatId:" + this.e);
        return false;
    L25:
        return true;
    }

    public a() {
    }

    public static a b(fxa.b r2, ChatWindowPrepareData r3) {
        a r0 = new a();
        r0.a = r2.q();
        r0.d = r2.i();
        r0.b = r2.o();
        r0.c = r2.t();
        r0.e = r2.getChatId();
        r2.getAppId();
        r0.k = r2.d();
        r2.k();
        r2.getSourceType();
        r2.getTabId();
        if (r3 != null) goto L5;
        r3 = r2.g();
    L5:
        if (r3 == null) goto L7;
        r0.f = r3.chat;
        r0.g = r3.p2pChatter;
        r0.h = r3.self;
        r0.i = r3.openApp;
        r0.j = r3.chatThemeInfo;
    L7:
        r0.l = r2.c();
        r0.m = r2.h();
        r0.n = r2.e();
        r2.j();
        return r0;
    }
}
