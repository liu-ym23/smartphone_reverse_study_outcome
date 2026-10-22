package com.bytedance.android.live.recharge.panel.dynamic;

import android.content.Context;
import com.bytedance.android.live.recharge.RechargeDialogFactoryImpl;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d extends com.bytedance.android.live.recharge.core.c {
    zy0.d d(Context r1, com.bytedance.android.live.recharge.model.d r2, RechargeDialogFactoryImpl.a r3);

    void e0(int r1, int r2, long r3);

    Disposable l1(Function0<Unit> r1);

    void m1(boolean r1);
}
