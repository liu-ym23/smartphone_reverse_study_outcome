package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.nd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/RevenueDownloadEffectAssetsParamModelSerializableObjectImpl;", "Lw20/nd;", "", "", "effectIds", "Ljava/util/List;", "e8", "()Ljava/util/List;", "setEffectIds", "(Ljava/util/List;)V", "", "priority", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "platform", "Ljava/lang/String;", "getPlatform", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "panelType", "getPanelType", "setPanelType", "resourceIds", "getResourceIds", "setResourceIds", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueDownloadEffectAssetsParamModelSerializableObjectImpl implements nd {

    @SerializedName("effectIds")
    private List<String> effectIds;

    @SerializedName("panelType")
    private String panelType;

    @SerializedName("platform")
    private String platform;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("resourceIds")
    private List<String> resourceIds;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/RevenueDownloadEffectAssetsParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevenueDownloadEffectAssetsParamModelSerializableObjectImpl.class);
        }
    }

    public RevenueDownloadEffectAssetsParamModelSerializableObjectImpl() {
    }

    @Override // w20.nd
    public final List<String> e8() {
        return this.effectIds;
    }

    @Override // w20.nd
    public final String getPlatform() {
        return this.platform;
    }

    @Override // w20.nd
    public final Integer getPriority() {
        return this.priority;
    }
}
