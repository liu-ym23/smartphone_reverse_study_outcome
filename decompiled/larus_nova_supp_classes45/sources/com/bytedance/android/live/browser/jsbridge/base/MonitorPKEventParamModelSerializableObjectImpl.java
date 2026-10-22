package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.ub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/MonitorPKEventParamModelSerializableObjectImpl;", "Lw20/ub;", "", "eventType", "I", "getEventType", "()I", "setEventType", "(I)V", "Lcom/google/gson/JsonObject;", "eventParams", "Lcom/google/gson/JsonObject;", "getEventParams", "()Lcom/google/gson/JsonObject;", "setEventParams", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MonitorPKEventParamModelSerializableObjectImpl implements ub {

    @SerializedName("eventParams")
    private JsonObject eventParams;

    @SerializedName("eventType")
    private int eventType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/MonitorPKEventParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(MonitorPKEventParamModelSerializableObjectImpl.class);
        }
    }

    public MonitorPKEventParamModelSerializableObjectImpl() {
        this.eventParams = (JsonObject) d.c(JsonObject.class);
    }

    @Override // w20.ub
    public final JsonObject getEventParams() {
        return this.eventParams;
    }

    @Override // w20.ub
    public final int getEventType() {
        return this.eventType;
    }
}
