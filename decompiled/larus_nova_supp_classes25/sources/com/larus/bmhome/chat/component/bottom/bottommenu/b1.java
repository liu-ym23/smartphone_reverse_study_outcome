package com.larus.bmhome.chat.component.bottom.bottommenu;

import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.Gson;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b1 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ BottomMenuComponent a;

    public b1(BottomMenuComponent r1) {
        this.a = r1;
    }

    public final void c(Object r10) {
        BotModel r11 = (BotModel) r10;
        Intrinsics.checkNotNullParameter(r11, "new");
        BottomMenuComponent r0 = this.a;
        int r1 = BottomMenuComponent.x1;
        r0.getClass();
        Gson r2 = new Gson();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl((EditPos) r2.fromJson(r11.getEditPos(), EditPos.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        EditPos r13 = (EditPos) r12;
        if (r13 != null) goto L20;
        r13 = new EditPos(0);
    L20:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), Dispatchers.getIO(), null, new BottomMenuComponent$updateBottomMenu$1(r0, r13, null), 2, null);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.a.e("MultimodalInputWrapper", "Got exception: " + e);
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
