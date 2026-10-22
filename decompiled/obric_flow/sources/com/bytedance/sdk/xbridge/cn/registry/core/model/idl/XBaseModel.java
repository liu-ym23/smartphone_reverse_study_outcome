package com.bytedance.sdk.xbridge.cn.registry.core.model.idl;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "", "Lorg/json/JSONObject;", "toJSON", "()Lorg/json/JSONObject;", "", "", "convert", "()Ljava/util/Map;", "fj/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface XBaseModel {
    @Keep
    Map<String, Object> convert();

    @Keep
    JSONObject toJSON();
}
