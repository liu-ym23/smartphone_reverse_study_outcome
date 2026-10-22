package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "exposeAccurateExperiment")
public final class v2 extends c<w2, ExposeAccurateExperimentResultModel> {
    public v2() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w2 r8 = (w2) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8.c() != null) goto L5;
        ExposeAccurateExperimentResultModel r9 = new ExposeAccurateExperimentResultModel();
        r9.a(ExposeAccurateExperimentResultModel.Code.Failed);
        r9.c("key未定义");
        Unit r11 = Unit.INSTANCE;
        finishWithResult(r9);
        return;
    L5:
        String r12 = (String) ((Map) com.bytedance.android.livesdk.config.q9.a.getValue()).get(r8.c());
        if (r12 != null) goto L8;
        ExposeAccurateExperimentResultModel r13 = new ExposeAccurateExperimentResultModel();
        r13.a(ExposeAccurateExperimentResultModel.Code.Failed);
        r13.c("不能映射精准实验key，请去https://cloud.bytedance.net/dolphin/cn/bizline/45/group/1246891/rules进行配置");
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    L8:
        Class r1 = Integer.TYPE;
        String r2 = r8.a();
        boolean r3 = false;
        if (r2 == null) goto L11;
        int r4 = CastIntegerProtector.parseInt(r2);
    L12:
        Integer r5 = Integer.valueOf(r4);
        Boolean r15 = r8.d();
        if (r15 == null) goto L15;
        r15.booleanValue();
    L15:
        ClientABTestKey r0 = new ClientABTestKey(r12, r1, r5, 1);
        com.bytedance.android.live.base.abtest.b.a r16 = com.bytedance.android.live.base.abtest.b.b;
        Boolean r17 = r8.b();
        if (r17 == null) goto L18;
        r3 = r17.booleanValue();
    L18:
        r16.getClass();
        Integer r18 = (Integer) com.bytedance.android.live.base.abtest.b.a.b(r0, r3);
        ExposeAccurateExperimentResultModel r19 = new ExposeAccurateExperimentResultModel();
        r19.a(ExposeAccurateExperimentResultModel.Code.Success);
        ExposeAccurateExperimentResultModel.a r21 = new ExposeAccurateExperimentResultModel.a();
        if (r18 != null) goto L22;
    L24:
        String r22 = String.valueOf(r18.intValue());
    L25:
        r21.a(r22);
        Unit r23 = Unit.INSTANCE;
        r19.b(r21);
        finishWithResult(r19);
        return;
    L22:
        if (r18.intValue() != 9999) goto L24;
        r22 = r8.a();
        goto L25
    L11:
        r4 = 0;
        goto L12
    }
}
