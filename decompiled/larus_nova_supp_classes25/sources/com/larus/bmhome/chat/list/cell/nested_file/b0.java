package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.v1;
import com.larus.bmhome.chat.layout.holder.menu.item.w0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 implements t0 {
    public b0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r2, Message r3, Function0<Message> r4, q0 r5, BotModel r6, wc9.e r7, q0.a r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r6, "chatBot");
        ArrayList r10 = new ArrayList();
        if (hp8.a.b(r3) == false) goto L5;
    L11:
        l0 r11 = w0.a(r3, r8);
        if (r11 == null) goto L14;
        r10.add(r11);
    L14:
        r10.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r2, r6, false, 8));
        v1.a(r10);
        v1.d(r10, r3, r7, r8);
        return com.larus.bmhome.chat.layout.holder.helper.e.b(r10);
    L5:
        if (hp8.a.c(r3) == false) goto L11;
        if (z2.a.e3().a == false) goto L14;
        l0 r12 = w0.a(r3, r8);
        if (r12 == null) goto L14;
        r10.add(r12);
        goto L14
    }
}
