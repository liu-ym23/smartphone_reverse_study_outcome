package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.w9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/HandleBattleBgImageParamModelSerializableObjectImpl;", "Lw20/w9;", "", "topBgImage", "Ljava/lang/String;", "e2", "()Ljava/lang/String;", "setTopBgImage", "(Ljava/lang/String;)V", "bottomBgImage", "U8", "setBottomBgImage", "wholeBgImage", "K0", "setWholeBgImage", "", "isAnim", "Z", "N2", "()Z", "setAnim", "(Z)V", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HandleBattleBgImageParamModelSerializableObjectImpl implements w9 {

    @SerializedName("bottomBgImage")
    private String bottomBgImage;

    @SerializedName("isAnim")
    private boolean isAnim;

    @SerializedName("topBgImage")
    private String topBgImage;

    @SerializedName("wholeBgImage")
    private String wholeBgImage;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/HandleBattleBgImageParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(HandleBattleBgImageParamModelSerializableObjectImpl.class);
        }
    }

    public HandleBattleBgImageParamModelSerializableObjectImpl() {
        this.topBgImage = "";
        this.bottomBgImage = "";
        this.wholeBgImage = "";
    }

    @Override // w20.w9
    public final String K0() {
        return this.wholeBgImage;
    }

    @Override // w20.w9
    public final boolean N2() {
        return this.isAnim;
    }

    @Override // w20.w9
    public final String U8() {
        return this.bottomBgImage;
    }

    @Override // w20.w9
    public final String e2() {
        return this.topBgImage;
    }
}
