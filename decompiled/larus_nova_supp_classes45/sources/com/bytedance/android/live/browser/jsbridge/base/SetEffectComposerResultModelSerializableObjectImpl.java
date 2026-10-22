package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModelSerializableObjectImpl;", "Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel;", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel$b;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel$b;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel$b;", "v8", "(Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModel$b;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SetEffectComposerResultModelSerializableObjectImpl implements SetEffectComposerResultModel {

    @SerializedName("code")
    private Integer code;

    @SerializedName("data")
    private SetEffectComposerResultModel.b data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerResultModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SetEffectComposerResultModelSerializableObjectImpl.class);
        }
    }

    public SetEffectComposerResultModelSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel
    public final SetEffectComposerResultModel.b getData() {
        return this.data;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel
    public final void v8(SetEffectComposerResultModel.b r1) {
        this.data = r1;
    }
}
