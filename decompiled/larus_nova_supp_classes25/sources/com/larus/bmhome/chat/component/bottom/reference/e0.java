package com.larus.bmhome.chat.component.bottom.reference;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ReferenceMsgComponent a;

    public e0(ReferenceMsgComponent r1) {
        this.a = r1;
    }

    public final void c(Object r8) {
        BotModel r9 = (BotModel) r8;
        Intrinsics.checkNotNullParameter(r9, "new");
        this.a.OW(r9);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ReferenceMsgComponent$observerBotChanged$1$onChange$1(this.a, r9, null), 3, null);
    }
}
