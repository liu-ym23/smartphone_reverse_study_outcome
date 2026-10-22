package com.larus.camera.impl.result;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements IIMCallback<List<? extends BotModel>> {
    public final /* synthetic */ CameraResultFirstFlow.a a;

    public final boolean mustInMain() {
        return true;
    }

    public c(CameraResultFirstFlow.a r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("CameraResultFirstFlow", "load main bot failed, code=" + r4.getCode() + ", tips=" + r4.getTips());
        this.a.b(null);
    }

    public final void onSuccess(Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        this.a.b((BotModel) CollectionsKt.firstOrNull(r5));
        FLogger.a.i("CameraResultFirstFlow", "load main bot success, size=" + r5.size());
    }
}
