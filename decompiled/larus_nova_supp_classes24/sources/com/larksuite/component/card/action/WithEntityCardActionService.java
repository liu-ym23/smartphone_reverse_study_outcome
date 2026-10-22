package com.larksuite.component.card.action;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionByEntityRequest;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionRequestInner;
import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizParam;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/card/action/WithEntityCardActionService;", "Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "<init>", "()V", "entity", "Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "getEntity", "()Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "setEntity", "(Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;)V", "sendRequest", "", "context", "Lcom/larksuite/component/card/protocol/context/action/CardActionContext;", "cardActionRequestParams", "Lcom/larksuite/component/card/protocol/context/action/CardActionRequestParams;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/protocol/context/action/UniversalCardPutActionResponse;", "buildRequest", "Lcom/bytedance/lark/pb/openplatform/v1/PutUniversalCardActionByEntityRequest$Builder;", "actionContext", "universalCardEntity", "putAction", "requestBuilder", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class WithEntityCardActionService implements CardActionService {
    public static final a Companion = null;
    private UniversalCardEntity entity;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public WithEntityCardActionService() {
    }

    public final UniversalCardEntity getEntity() {
        return this.entity;
    }

    public final void setEntity(UniversalCardEntity r1) {
        this.entity = r1;
    }

    @Override // com.larksuite.component.card.protocol.context.action.CardActionService
    public void sendRequest(dz7.a r4, dz7.b r5, final IGetDataCallback<dz7.c> r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "cardActionRequestParams");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Log.i("WithEntityCardActionService", "sendRequest, cardId: " + r5.a + ", actionId: " + r5.c);
        UniversalCardEntity r0 = this.entity;
        if (r0 != null) goto L6;
        Log.e("WithEntityCardActionService", "sendRequest error, entity is null");
        Exception r7 = new Exception("unknown error");
        int r8 = ((Number) bz7.d.a.getFirst()).intValue();
        String r1 = (String) bz7.d.c.getSecond();
        ErrorResult r2 = new ErrorResult(0);
        ErrorResult.access$002(r2, r8);
        ErrorResult.access$102(r2, -9999);
        ErrorResult.access$202(r2, 0);
        ErrorResult.access$302(r2, r7);
        ErrorResult.access$402(r2, "");
        ErrorResult.access$502(r2, r1);
        ErrorResult.access$602(r2, "");
        ErrorResult.access$702(r2, "");
        ErrorResult.access$802(r2, 0);
        ErrorResult.access$902(r2, null);
        ErrorResult.access$1002(r2, null);
        ErrorResult.access$1102(r2, null);
        r6.onError(r2);
        return;
    L6:
        PutUniversalCardActionRequestInner.Builder r9 = new PutUniversalCardActionRequestInner.Builder().universal_card_entity(r0).action_id(r5.c).card_id(r5.a).version(r5.d).trace_id(r5.g.getTracingID()).source_type(Integer.valueOf(r5.h)).source_id(r5.i).universal_card_biz_param(new UniversalCardBizParam.Builder().biz_id(r4.c.getBizId()).biz_type(1).build());
        if ((!r5.b.isEmpty()) == false) goto L9;
        r9.params(r5.b);
    L9:
        final PutUniversalCardActionByEntityRequest.Builder r10 = new PutUniversalCardActionByEntityRequest.Builder().inner(r9.build());
        SdkSender.asynSendRequestNonWrap(Command.PUT_UNIVERSAL_CARD_ACTION_REQUEST_BY_ENTITY, r10, new WithEntityCardActionService$putAction$1(r10, r6), h.a);
    }
}
