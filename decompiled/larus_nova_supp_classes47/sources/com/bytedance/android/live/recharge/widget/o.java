package com.bytedance.android.live.recharge.widget;

import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ p a;

    public o(p r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Unit r5 = (Unit) r4;
        RechargeNoPasswordWidget r6 = this.a.a;
        int r0 = RechargeNoPasswordWidget.O;
        r6.getClass();
        ALogger.d("RechargeNoPasswordWidget", "财经免密支付组件加载失败，降级");
        r6.L = false;
        r6.h.getRepository().P.a(new com.bytedance.android.live.recharge.platform.model.f(0));
        TextView r7 = r6.q;
        if (r7 == null) goto L6;
        r7.setText(s1.B(2131921900));
        return;
    }
}
