package com.larus.caijing_pay.impl.init;

import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements IH5PayCallback {
    public final /* synthetic */ Function2<Integer, String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function2<? super Integer, ? super String, Unit> r1) {
        this.a = r1;
    }

    public final void onResult(int r4, String r5) {
        FLogger.a.i("CJPayServiceImpl", "pay result code: " + r4 + ", msg: " + r5);
        Function2<Integer, String, Unit> r0 = this.a;
        if (r0 == null) goto L5;
        r0.invoke(Integer.valueOf(r4), r5);
    L5:
        TTCJPayUtils.Companion.getInstance().releaseAll();
    }
}
