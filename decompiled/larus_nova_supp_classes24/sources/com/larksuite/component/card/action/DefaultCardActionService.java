package com.larksuite.component.card.action;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionRequest;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionRequestInner;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizParam;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/larksuite/component/card/action/DefaultCardActionService;", "Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "<init>", "()V", "sendRequest", "", "context", "Lcom/larksuite/component/card/protocol/context/action/CardActionContext;", "cardActionRequestParams", "Lcom/larksuite/component/card/protocol/context/action/CardActionRequestParams;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/protocol/context/action/UniversalCardPutActionResponse;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DefaultCardActionService implements CardActionService {
    public DefaultCardActionService() {
    }

    @Override // com.larksuite.component.card.protocol.context.action.CardActionService
    public void sendRequest(dz7.a r4, dz7.b r5, final IGetDataCallback<dz7.c> r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "cardActionRequestParams");
        Intrinsics.checkNotNullParameter(r6, "callback");
        int r2 = d.a;
        IGetDataCallback<dz7.c> r3 = new AnonymousClass1(r6);
        Intrinsics.checkNotNullParameter(r4, "cardActionContext");
        Intrinsics.checkNotNullParameter(r5, "cardActionRequestParams");
        Intrinsics.checkNotNullParameter(r3, "callback");
        BizContext r7 = r4.c;
        if (TextUtils.isEmpty(r7.getBizId()) == false) goto L5;
        Log.w("UrlCardActionClient", "bizId is null");
        return;
    L5:
        PutUniversalCardActionRequestInner.Builder r8 = new PutUniversalCardActionRequestInner.Builder().action_id(r5.c).card_id(r5.a).version(r5.d).trace_id(r5.g.getTracingID()).source_type(Integer.valueOf(r5.h)).source_id(r5.i).universal_card_biz_param(new UniversalCardBizParam.Builder().biz_id(r7.getBizId()).biz_type(Integer.valueOf(r7.getBizType().getValue())).build());
        if ((!r5.b.isEmpty()) == false) goto L8;
        r8.params(r5.b);
    L8:
        SdkSender.asynSendRequestNonWrap(Command.PUT_UNIVERSAL_CARD_ACTION_REQUEST, new PutUniversalCardActionRequest.Builder().inner(r8.build()), r3, c.a);
    }
}
