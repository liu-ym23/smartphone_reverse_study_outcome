package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.c4;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x2 implements t0 {
    public x2() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r2, Message r3, Function0<Message> r4, com.larus.bmhome.chat.api.q0 r5, BotModel r6, wc9.e r7, com.larus.bmhome.chat.api.q0.a r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r6, "chatBot");
        if (r5 == null) goto L7;
        Function0<Fragment> r10 = r5.getHostFragment();
        if (r10 == null) goto L7;
        Fragment r11 = (Fragment) r10.invoke();
    L8:
        boolean r12 = c4.a(r11);
        ArrayList r13 = new ArrayList();
        if (r12 == true) goto L13;
        com.larus.bmhome.view.screenmenu.l0 r14 = com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r3, r8);
        if (r14 == null) goto L13;
        r13.add(r14);
    L13:
        if (r12 == true) goto L15;
        r13.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r2, r6, false, 8));
    L15:
        v1.a(r13);
        v1.d(r13, r3, r7, r8);
        return e.b(r13);
    L7:
        r11 = null;
        goto L8
    }
}
