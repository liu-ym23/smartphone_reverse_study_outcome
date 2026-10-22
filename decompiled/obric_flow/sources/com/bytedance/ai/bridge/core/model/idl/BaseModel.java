package com.bytedance.ai.bridge.core.model.idl;

import androidx.annotation.Keep;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/bridge/core/model/idl/BaseModel;", "", "toJson", "Lcom/google/gson/JsonObject;", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BaseModel {
    @Keep
    JsonObject toJson();
}
