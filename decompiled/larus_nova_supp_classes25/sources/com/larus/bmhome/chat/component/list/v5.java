package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v5 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatListComponent a;

    public v5(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        Intrinsics.checkNotNullParameter((BotModel) r3, "new");
        MessageAdapter r4 = this.a.O;
        if (r4 == null) goto L6;
        r4.S3(":fake_message:8", 0);
        return;
    }
}
