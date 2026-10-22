package com.larus.drive.biz.impl.utils;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements IIMCallback<BotModel> {
    public final /* synthetic */ kotlinx.coroutines.i<BotModel> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public b(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.i("DriveAskDoubaoLauncher", "getBotModel failed, code=" + r4.getCode() + ", tips=" + r4.getTips());
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        BotModel r3 = (BotModel) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
