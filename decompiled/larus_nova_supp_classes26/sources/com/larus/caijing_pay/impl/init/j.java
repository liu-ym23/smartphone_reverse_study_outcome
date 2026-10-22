package com.larus.caijing_pay.impl.init;

import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.bytedance.applet.impl.e0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements IH5PayCallback {
    public final /* synthetic */ Function2<Integer, String, Unit> a;

    public j(e0 r1) {
        this.a = r1;
    }

    public final void onResult(int r2, String r3) {
        Function2<Integer, String, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(r2), r3);
        return;
    }
}
