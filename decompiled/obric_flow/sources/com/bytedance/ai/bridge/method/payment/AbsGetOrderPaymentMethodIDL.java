package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL$GetOrderPaymentParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetOrderPaymentParamModel", "GetOrderPaymentResultModel", "GetOrderPaymentFailedModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsGetOrderPaymentMethodIDL extends CoreAIBridgeMethod<GetOrderPaymentParamModel, ResultModel> {
    private final String name;

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL$GetOrderPaymentFailedModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "errNo", "getErrNo", "()Ljava/lang/String;", "setErrNo", "(Ljava/lang/String;)V", "errMsg", "getErrMsg", "setErrMsg", "errLogId", "getErrLogId", "setErrLogId", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetOrderPaymentFailedModel extends ResultModel {
        String getErrLogId();

        String getErrMsg();

        String getErrNo();

        @AIBridgeParamField(keyPath = "errLogId", required = false)
        void setErrLogId(String r5);

        @AIBridgeParamField(keyPath = "errMsg", required = true)
        void setErrMsg(String r5);

        @AIBridgeParamField(keyPath = "errNo", required = true)
        void setErrNo(String r5);
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL$GetOrderPaymentParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "orderId", "", "getOrderId", "()Ljava/lang/String;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetOrderPaymentParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "orderId", required = true)
        String getOrderId();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/AbsGetOrderPaymentMethodIDL$GetOrderPaymentResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "orderId", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "logId", "getLogId", "setLogId", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetOrderPaymentResultModel extends ResultModel {
        String getLogId();

        String getOrderId();

        @AIBridgeParamField(keyPath = "logId", required = true)
        void setLogId(String r5);

        @AIBridgeParamField(keyPath = "orderId", required = true)
        void setOrderId(String r5);
    }

    public AbsGetOrderPaymentMethodIDL() {
        this.name = "applet.getOrderPayment";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
