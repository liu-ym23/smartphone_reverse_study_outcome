package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/StorageInputParam;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "groupId", "", "getGroupId", "()Ljava/lang/String;", "storageId", "getStorageId", "isPersist", "", "()Z", "isShared", "key", "getKey", a.KEY_LUBAN_VALUE, "getValue", "extra", "getExtra", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface StorageInputParam extends ParamModel {
    @AIBridgeParamField(keyPath = "extra")
    String getExtra();

    @AIBridgeParamField(keyPath = "groupID", required = true)
    String getGroupId();

    @AIBridgeParamField(keyPath = "key", required = true)
    String getKey();

    @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "default", type = DefaultType.STRING), keyPath = "storageID", required = true)
    String getStorageId();

    @AIBridgeParamField(keyPath = a.KEY_LUBAN_VALUE)
    String getValue();

    @AIBridgeParamField(keyPath = "persistent", required = true)
    boolean isPersist();

    @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "shared")
    boolean isShared();
}
