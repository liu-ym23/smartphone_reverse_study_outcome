package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k extends a {
    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131907402) goto L5;
        return true;
    L5:
        return false;
    }

    public k() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r3, View r4, ef8.b r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        com.bytedance.router.i r6 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/chat_debug");
        r6.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("argument_key_message_id", r5.a.getMessageId()), TuplesKt.to("argument_key_local_message_id", r5.a.getLocalMessageId())}));
        r6.d();
        return true;
    }
}
