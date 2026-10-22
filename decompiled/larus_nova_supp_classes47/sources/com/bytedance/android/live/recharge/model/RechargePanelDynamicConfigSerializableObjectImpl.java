package com.bytedance.android.live.recharge.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/recharge/model/RechargePanelDynamicConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/model/RechargePanelDynamicConfig;", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "scheme", "Ljava/lang/String;", "getScheme", "()Ljava/lang/String;", "setScheme", "(Ljava/lang/String;)V", "enableCache", "j1", "setEnableCache", "", "cacheTimeLimit", "J", "e3", "()J", "setCacheTimeLimit", "(J)V", "", "cacheReqEntrance", "I", "e0", "()I", "setCacheReqEntrance", "(I)V", "enableRefreshCacheOnEnterPanel", "p0", "setEnableRefreshCacheOnEnterPanel", "enableRefreshCacheAfterRechargeSuccess", "X7", "setEnableRefreshCacheAfterRechargeSuccess", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargePanelDynamicConfigSerializableObjectImpl implements RechargePanelDynamicConfig {

    @SerializedName("cache_req_entrance")
    private int cacheReqEntrance;

    @SerializedName("cached_time_limit")
    private long cacheTimeLimit;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_cache")
    private boolean enableCache;

    @SerializedName("enable_refresh_cache_after_recharge_success")
    private boolean enableRefreshCacheAfterRechargeSuccess;

    @SerializedName("enable_refresh_cache_on_enter_panel")
    private boolean enableRefreshCacheOnEnterPanel;

    @SerializedName("scheme")
    private String scheme;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/model/RechargePanelDynamicConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RechargePanelDynamicConfigSerializableObjectImpl.class);
        }
    }

    public RechargePanelDynamicConfigSerializableObjectImpl() {
        this.scheme = "";
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final boolean X7() {
        return this.enableRefreshCacheAfterRechargeSuccess;
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final int e0() {
        return this.cacheReqEntrance;
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final long e3() {
        return this.cacheTimeLimit;
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final String getScheme() {
        return this.scheme;
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final boolean j1() {
        return this.enableCache;
    }

    @Override // com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig
    public final boolean p0() {
        return this.enableRefreshCacheOnEnterPanel;
    }
}
