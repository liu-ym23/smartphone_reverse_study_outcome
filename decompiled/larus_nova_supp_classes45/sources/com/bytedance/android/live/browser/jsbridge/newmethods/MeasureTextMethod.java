package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.graphics.Paint;
import com.bytedance.android.live.browser.jsbridge.base.MeasureTextResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "measureText")
public final class MeasureTextMethod extends w20.y3<w20.sb, MeasureTextResultModel> {
    public final Lazy a;

    public MeasureTextMethod() {
        this.a = LazyKt.lazy(MeasureTextMethod$paint$2.INSTANCE);
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.sb r4 = (w20.sb) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Integer r5 = r4.a();
        String r0 = r4.b();
        if (r5 == null) goto L7;
        if (r0 == null) goto L7;
        ((Paint) this.a.getValue()).setTextSize(r5.intValue());
        float r6 = ((Paint) this.a.getValue()).measureText(r4.b());
        MeasureTextResultModel r7 = new MeasureTextResultModel();
        MeasureTextResultModel.a r1 = new MeasureTextResultModel.a();
        r1.a(Float.valueOf(r6));
        Unit r8 = Unit.INSTANCE;
        r7.a(r1);
        finishWithResult(r7);
        return;
    L7:
        MeasureTextResultModel r9 = new MeasureTextResultModel();
        MeasureTextResultModel.a r11 = new MeasureTextResultModel.a();
        r11.a(Float.valueOf(0.0f));
        Unit r12 = Unit.INSTANCE;
        r9.a(r11);
        finishWithResult(r9);
    }
}
