package com.larus.search.impl.global;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import com.larus.im.service.y;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class GlobalSearchFragment$botUpdateListener$1 implements y {
    public String a;
    public final /* synthetic */ GlobalSearchFragment b;

    public GlobalSearchFragment$botUpdateListener$1(GlobalSearchFragment r1) {
        this.b = r1;
        this.a = "";
    }

    public final void a(List<BotModel> r7, BotChangeType r8) {
        Intrinsics.checkNotNullParameter(r7, "changedBots");
        Intrinsics.checkNotNullParameter(r8, "changeType");
        if (r8 != BotChangeType.UPDATE) goto L9;
        GlobalSearchFragment r9 = this.b;
        if (r9.e != null) goto L7;
        return;
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9.getViewLifecycleOwner()), Dispatchers.getIO(), null, new GlobalSearchFragment$botUpdateListener$1$onBotChanged$1(this.b, r7, this, null), 2, null);
        return;
    }
}
