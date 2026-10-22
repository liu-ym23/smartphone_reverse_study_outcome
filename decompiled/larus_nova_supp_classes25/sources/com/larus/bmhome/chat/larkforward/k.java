package com.larus.bmhome.chat.larkforward;

import android.os.Handler;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements com.larus.im.service.y {
    public final /* synthetic */ int a;

    public k(int r1) {
        this.a = r1;
    }

    public final void a(final List<BotModel> r2, BotChangeType r3) {
        Intrinsics.checkNotNullParameter(r2, "changedBots");
        Intrinsics.checkNotNullParameter(r3, "changeType");
        if (r3 != BotChangeType.DELETE) goto L5;
        return;
    L5:
        Handler r4 = i.a;
        final int r5 = this.a;
        i.f(new j(r5, r2));
    }
}
