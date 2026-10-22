package com.bytedance.ai.bridge.network;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestParamModel;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "RequestParamModel", "RequestResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsRequestMethodIDL extends CoreAIBridgeMethod<RequestParamModel, RequestResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R$\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "url", "", "getUrl", "()Ljava/lang/String;", "method", "getMethod", "header", "", "getHeader", "()Ljava/util/Map;", "data", "", "getData", "()Ljava/lang/Object;", "dataType", "getDataType", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface RequestParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "data", required = false)
        Object getData();

        @AIBridgeParamField(keyPath = "dataType", required = false)
        String getDataType();

        @AIBridgeParamField(keyPath = "header", required = false)
        Map<String, String> getHeader();

        @AIBridgeParamField(keyPath = "method", required = false)
        String getMethod();

        @AIBridgeParamField(keyPath = "url", required = true)
        String getUrl();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000b@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "statusCode", "getStatusCode", "()I", "setStatusCode", "(I)V", "", "", "", "header", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface RequestResultModel extends ResultModel {
        Object getData();

        Map<String, Object> getHeader();

        int getStatusCode();

        @AIBridgeParamField(keyPath = "data", required = false)
        void setData(Object r5);

        @AIBridgeParamField(keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r5);

        @AIBridgeParamField(keyPath = "statusCode", required = true)
        void setStatusCode(int r5);
    }

    public AbsRequestMethodIDL() {
        this.name = "doubao.request";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
