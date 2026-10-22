package com.bytedance.android.live.effect.sticker.ui;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements IFetchEffectListener {
    public final /* synthetic */ Function1 a;

    public final void onStart(Effect r1) {
    }

    public h(Function1 r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r2) {
        Effect r3 = (Effect) r2;
        if (r3 == null) goto L5;
        this.a.invoke(com.bytedance.android.live.effect.sticker.d.b(r3));
        return;
    L5:
        Unit r4 = (Unit) this.a.invoke(null);
    }

    public final void onFail(Effect r1, ExceptionResult r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.invoke(null);
    }
}
