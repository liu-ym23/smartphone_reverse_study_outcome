package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s1 implements t0 {
    public s1() {
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
        com.larus.bmhome.view.screenmenu.l0 r10 = com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r2, r7);
        if (r10 == null) goto L5;
        r9.add(r10);
    L5:
        r9.add(com.larus.bmhome.chat.layout.holder.menu.item.n.a());
        return r9;
    }
}
