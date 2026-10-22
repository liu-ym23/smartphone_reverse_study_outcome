package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.browser.jsbridge.base.LiveCreateQuestionContainerResultModel;
import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.n2;
import w20.oa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.createQuestionContainer")
public final class b extends n2<oa, LiveCreateQuestionContainerResultModel> {
    public b() {
    }

    public final void invoke(Object r2, CallContext r3) {
        oa r4 = (oa) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.b();
        JsonObject r6 = r4.a();
        if (r5 == null) goto L12;
        if (r6 == null) goto L12;
        IAnswerQuestionService r0 = k.f(IAnswerQuestionService.class);
        if (r0 != null) goto L8;
    L10:
        LiveCreateQuestionContainerResultModel r7 = new LiveCreateQuestionContainerResultModel();
        r7.a(LiveCreateQuestionContainerResultModel.Code.Failed);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
    L11:
        Unit r9 = Unit.INSTANCE;
    L13:
        if (r9 != null) goto L16;
        LiveCreateQuestionContainerResultModel r11 = new LiveCreateQuestionContainerResultModel();
        r11.a(LiveCreateQuestionContainerResultModel.Code.Failed);
        Unit r12 = Unit.INSTANCE;
        finishWithResult(r11);
        return;
    L16:
        return;
    L8:
        if (r0.showAnswerQuestionContainer(r5, r6) != true) goto L10;
        LiveCreateQuestionContainerResultModel r13 = new LiveCreateQuestionContainerResultModel();
        r13.a(LiveCreateQuestionContainerResultModel.Code.Success);
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
    L12:
        r9 = null;
        goto L13
    }
}
