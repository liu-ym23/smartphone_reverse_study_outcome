package com.bytedance.ai.bridge.payment.sign;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/payment/sign/AbsSignMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/payment/sign/AbsSignMethodIDL$SignParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "SignParamModel", "EmptyMessageModel", "SignFailedModelModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSignMethodIDL extends CoreAIBridgeMethod<c, ResultModel> {
    public final String a;

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "code", required = true)
        void setCode(int r1);

        @AIBridgeParamField(keyPath = "errLogId", required = false)
        void setErrLogId(String r1);

        @AIBridgeParamField(keyPath = "errMsg", required = true)
        void setErrMsg(String r1);

        @AIBridgeParamField(keyPath = "errNo", required = true)
        void setErrNo(String r1);
    }

    @AIBridgeParamModel
    public interface c extends ParamModel {
        @AIBridgeParamField(keyPath = "orderId", required = true)
        String getOrderId();
    }

    public AbsSignMethodIDL() {
        this.a = "doubao.sign";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
