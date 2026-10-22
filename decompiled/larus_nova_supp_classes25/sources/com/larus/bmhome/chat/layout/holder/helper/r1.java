package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements t0 {
    public r1() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r45, Message r46, Function0<Message> r47, com.larus.bmhome.chat.api.q0 r48, BotModel r49, wc9.e r50, com.larus.bmhome.chat.api.q0.a r51, JSONObject r52) {
        Intrinsics.checkNotNullParameter(r45, "context");
        Intrinsics.checkNotNullParameter(r46, "data");
        Intrinsics.checkNotNullParameter(r49, "chatBot");
        ArrayList r2 = new ArrayList();
        r2.add(new com.larus.bmhome.view.screenmenu.l0(MenuActionType.REPORT_MUSIC.getType(), 2131905659, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971808, null, 2131241870)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
        r2.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r45, r49, false, 8));
        v1.a(r2);
        v1.b(r2, r51);
        return e.b(r2);
    }
}
