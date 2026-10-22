package com.bytedance.ai.bridge.network;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/network/AbsDownloadFileMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/network/AbsDownloadFileMethodIDL$DownloadFileParamModel;", "Lcom/bytedance/ai/bridge/network/AbsDownloadFileMethodIDL$DownloadFileResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "DownloadFileParamModel", "DownloadFileResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDownloadFileMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "downloadTaskId", required = true)
        String getDownloadTaskId();

        @AIBridgeParamField(keyPath = "filePath", required = false)
        String getFilePath();

        @AIBridgeParamField(keyPath = "header", required = false)
        Map<String, Object> getHeader();

        @AIBridgeParamField(keyPath = "timeout", required = false)
        Long getTimeout();

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_URL, required = true)
        String getUrl();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "filePath", required = false)
        void setFilePath(String r1);

        @AIBridgeParamField(keyPath = "header", required = false)
        void setHeader(Map<String, ? extends Object> r1);

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_STATUS_CODE, required = true)
        void setStatusCode(int r1);

        @AIBridgeParamField(keyPath = "tempFilePath", required = false)
        void setTempFilePath(String r1);
    }

    public AbsDownloadFileMethodIDL() {
        this.a = "doubao.downloadFile";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
