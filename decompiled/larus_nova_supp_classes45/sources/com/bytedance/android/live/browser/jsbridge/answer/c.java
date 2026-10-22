package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.browser.jsbridge.base.LiveDestroyQuestionContainerResultModel;
import com.bytedance.android.livesdk.interactivity.api.IAnswerQuestionService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.o2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.destroyQuestionContainer")
public final class c extends o2<JsonObject, LiveDestroyQuestionContainerResultModel> {
    public c() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IAnswerQuestionService r4 = k.f(IAnswerQuestionService.class);
        if (r4 != null) goto L5;
    L7:
        LiveDestroyQuestionContainerResultModel r5 = new LiveDestroyQuestionContainerResultModel();
        r5.a(LiveDestroyQuestionContainerResultModel.Code.Failed);
        Unit r6 = Unit.INSTANCE;
        finishWithResult(r5);
        return;
    L5:
        if (r4.dismissAnswerQuestionContainer() != true) goto L7;
        LiveDestroyQuestionContainerResultModel r7 = new LiveDestroyQuestionContainerResultModel();
        r7.a(LiveDestroyQuestionContainerResultModel.Code.Success);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
    }
}
