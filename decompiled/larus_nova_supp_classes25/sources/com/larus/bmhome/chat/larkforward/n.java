package com.larus.bmhome.chat.larkforward;

import android.os.Handler;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements IIMCallback<BotModel> {
    public final /* synthetic */ int a;

    public final boolean mustInMain() {
        return true;
    }

    public n(int r1) {
        this.a = r1;
    }

    public final void onFailure(final IIMError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        Handler r0 = i.a;
        final int r1 = this.a;
        i.f(new l(r1, r3));
    }

    public final void onSuccess(Object r3) {
        final BotModel r4 = (BotModel) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        Handler r0 = i.a;
        final int r1 = this.a;
        i.f(new m(r1, r4));
    }
}
