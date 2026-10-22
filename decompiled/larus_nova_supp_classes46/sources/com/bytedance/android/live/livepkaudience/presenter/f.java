package com.bytedance.android.live.livepkaudience.presenter;

import com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ Function1 b;

    public f(b r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        BasePkAudienceApplyListContract$View r0 = (BasePkAudienceApplyListContract$View) this.a.b;
        r0.Z90((Throwable) r2);
    }
}
