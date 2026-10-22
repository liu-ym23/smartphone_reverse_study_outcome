package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel_SetEffectComposerDataSerializableObjectImpl;", "Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel$b;", "", "result", "Ljava/lang/Integer;", "getResult", "()Ljava/lang/Integer;", "setResult", "(Ljava/lang/Integer;)V", "", "", "nodes", "Ljava/util/List;", "getNodes", "()Ljava/util/List;", "setNodes", "(Ljava/util/List;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SetEffectComposerResultModel_SetEffectComposerDataSerializableObjectImpl implements SetEffectComposerResultModel.b {

    @SerializedName("nodes")
    private List<String> nodes;

    @SerializedName("result")
    private Integer result;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel_SetEffectComposerDataSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SetEffectComposerResultModel_SetEffectComposerDataSerializableObjectImpl.class);
        }
    }

    public SetEffectComposerResultModel_SetEffectComposerDataSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel.b
    public final void setResult(Integer r1) {
        this.result = r1;
    }
}
