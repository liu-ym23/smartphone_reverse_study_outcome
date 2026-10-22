package com.larus.search.impl.combine;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CombineSearchFragment$botUpdateListener$1 implements com.larus.im.service.y {
    public String a;
    public final /* synthetic */ CombineSearchFragment b;

    public CombineSearchFragment$botUpdateListener$1(CombineSearchFragment r1) {
        this.b = r1;
        this.a = "";
    }

    public final void a(List<BotModel> r7, BotChangeType r8) {
        Intrinsics.checkNotNullParameter(r7, "changedBots");
        Intrinsics.checkNotNullParameter(r8, "changeType");
        if (r8 != BotChangeType.UPDATE) goto L9;
        CombineSearchFragment r9 = this.b;
        if (r9.e != null) goto L7;
        return;
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9.getViewLifecycleOwner()), Dispatchers.getIO(), null, new CombineSearchFragment$botUpdateListener$1$onBotChanged$1(this.b, r7, this, null), 2, null);
        return;
    }
}
