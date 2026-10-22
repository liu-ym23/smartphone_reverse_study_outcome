package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y2 implements t0 {
    public y2() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r52, Message r53, Function0<Message> r54, com.larus.bmhome.chat.api.q0 r55, BotModel r56, wc9.e r57, com.larus.bmhome.chat.api.q0.a r58, JSONObject r59) {
        Intrinsics.checkNotNullParameter(r52, "context");
        Intrinsics.checkNotNullParameter(r53, "data");
        Intrinsics.checkNotNullParameter(r56, "chatBot");
        ArrayList r3 = new ArrayList();
        r3.add(new com.larus.bmhome.view.screenmenu.y(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r53), com.larus.bmhome.chat.layout.holder.menu.item.p.a(r53)));
        Intrinsics.checkNotNullParameter(r52, "context");
        r3.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r52, v19.c.b(2130972086, null, 2131103159))));
        r3.add(new com.larus.bmhome.view.screenmenu.l0(MenuActionType.SAVE_SEARCH_IMAGE.getType(), 2131906511, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971735, null, 2131241420)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
        if (AppHost.a.isPlugin() == true) goto L5;
        com.larus.bmhome.view.screenmenu.l0 r4 = new com.larus.bmhome.view.screenmenu.l0(MenuActionType.SHARE_SEARCH_IMAGE.getType(), 2131906512, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971829, null, 2131241973)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127);
    L6:
        if (r4 == null) goto L8;
        r3.add(r4);
    L8:
        Intrinsics.checkNotNullParameter(r52, "context");
        r3.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r52, v19.c.b(2130972086, null, 2131103159))));
        r3.add(com.larus.bmhome.chat.layout.holder.menu.item.n0.a());
        r3.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r52, r56, false, 8));
        v1.a(r3);
        v1.b(r3, r58);
        return e.b(r3);
    L5:
        r4 = null;
        goto L6
    }
}
