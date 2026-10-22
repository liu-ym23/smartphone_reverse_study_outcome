package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z2 implements t0 {
    public z2() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r1, Message r2, Function0<Message> r3, com.larus.bmhome.chat.api.q0 r4, BotModel r5, wc9.e r6, com.larus.bmhome.chat.api.q0.a r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r5, "chatBot");
        ArrayList r9 = new ArrayList();
        r9.add(new com.larus.bmhome.view.screenmenu.y(com.larus.bmhome.chat.layout.holder.menu.item.x.a(r2), com.larus.bmhome.chat.layout.holder.menu.item.p.a(r2)));
        Intrinsics.checkNotNullParameter(r1, "context");
        r9.add(new com.larus.bmhome.view.screenmenu.i0(0, ContextCompat.getColor(r1, v19.c.b(2130972086, null, 2131103159))));
        r9.add(com.larus.bmhome.chat.layout.holder.menu.item.n0.a());
        r9.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r1, r5, false, 8));
        v1.a(r9);
        v1.b(r9, r7);
        return e.b(r9);
    }
}
