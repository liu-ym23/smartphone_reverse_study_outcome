package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.link.model.u0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ q a;
    public final /* synthetic */ u0 b;
    public final /* synthetic */ Function0 c;

    public r(q r1, u0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        this.a.h = false;
        this.c.invoke();
        ToastUtil.a(2131917818, 0);
    }
}
