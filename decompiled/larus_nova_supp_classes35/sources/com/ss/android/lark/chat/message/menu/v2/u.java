package com.ss.android.lark.chat.message.menu.v2;

import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import z5c.h3;
import z5c.n2;
import z5c.p3;
import z5c.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements g {
    public final /* synthetic */ long a;
    public final /* synthetic */ Map<String, Object> b;
    public final /* synthetic */ MessageActionPanelManager<y6b.a<?>> c;

    public final s5c.d c() {
        s5c.a r0 = n2.c;
        long r1 = (System.currentTimeMillis() - this.a) / ((long) 1000);
        s5c.a r2 = h3.c.a(String.valueOf(r1));
        r0.getClass();
        return s5c.d.b.b(r0, r2).plus(this.b).plus(ChatParamUtils.f(this.c.a.getChatId()));
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.g
    public final void a() {
        Statistics.sendEvent("im_msg_menu_click", c().plus(z5c.r.Q1).plus(p3.c).toJson());
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.g
    public final void b() {
        s5c.d r0 = c().plus(z5c.r.P1).plus(p3.p);
        DefaultEmojiPanelData r1 = k2c.a.a().a();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.c() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        s5c.a r3 = z0.c;
    L11:
        Statistics.sendEvent("im_msg_menu_click", r0.plus(r3).toJson());
        return;
    L10:
        r3 = z0.d;
    L7:
        r2 = false;
        goto L8
    }

    public u(long r1, Map<String, ? extends Object> r3, MessageActionPanelManager<y6b.a<?>> r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
