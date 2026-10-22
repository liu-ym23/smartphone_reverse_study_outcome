package com.larus.caijing_pay.impl.init;

import com.bytedance.applet.impl.f0;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements a {
    public final /* synthetic */ Function2<Integer, String, Unit> a;

    public h(f0 r1) {
        this.a = r1;
    }

    public final void onResult(int r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("CJPayServiceImpl", "outerBDPay result code: " + r3 + ", msg: " + r4);
        Function2<Integer, String, Unit> r6 = this.a;
        if (r6 == null) goto L6;
        r6.invoke(Integer.valueOf(r3), r4);
        return;
    }
}
