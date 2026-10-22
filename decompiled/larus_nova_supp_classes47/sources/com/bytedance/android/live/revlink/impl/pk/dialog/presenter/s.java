package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.link.model.u0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ q a;
    public final /* synthetic */ u0 b;
    public final /* synthetic */ Function0 c;

    public s(q r1, u0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "obj");
        this.a.h = false;
        r4.printStackTrace();
        ToastUtil.a(2131917817, 0);
    }
}
