package com.bytedance.ai.bridge.storage;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/storage/AbsGetStorageInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/storage/AbsGetStorageInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/storage/AbsGetStorageInfoMethodIDL$GetStorageInfoResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetStorageInfoResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsGetStorageInfoMethodIDL extends CoreAIBridgeMethod<EmptyMessageModel, GetStorageInfoResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/storage/AbsGetStorageInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface EmptyMessageModel extends ParamModel {
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n@gX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/storage/AbsGetStorageInfoMethodIDL$GetStorageInfoResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "Ljava/util/List;", "", "keys", "getKeys", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "", "currentSize", "getCurrentSize", "()I", "setCurrentSize", "(I)V", "limitSize", "getLimitSize", "setLimitSize", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetStorageInfoResultModel extends ResultModel {
        int getCurrentSize();

        List<String> getKeys();

        int getLimitSize();

        @AIBridgeParamField(keyPath = "currentSize", required = true)
        void setCurrentSize(int r5);

        @AIBridgeParamField(keyPath = "keys", required = true)
        void setKeys(List<String> r5);

        @AIBridgeParamField(keyPath = "limitSize", required = true)
        void setLimitSize(int r5);
    }

    public AbsGetStorageInfoMethodIDL() {
        this.name = "doubao.getStorageInfo";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
