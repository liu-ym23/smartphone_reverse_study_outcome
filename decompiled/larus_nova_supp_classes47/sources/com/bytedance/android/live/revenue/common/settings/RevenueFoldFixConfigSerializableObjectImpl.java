package com.bytedance.android.live.revenue.common.settings;

import ay0.e;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revenue/common/settings/RevenueFoldFixConfigSerializableObjectImpl;", "Lay0/e;", "", "enablePkMultiFoldFix", "Z", "b4", "()Z", "enableGiftPanelFoldFix", "u4", "enablePrivilegeFoldFix", "getEnablePrivilegeFoldFix", "<init>", "()V", "Adapter", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueFoldFixConfigSerializableObjectImpl implements e {

    @SerializedName("gift_panel_fold_fix")
    private final boolean enableGiftPanelFoldFix;

    @SerializedName("pk_multi_fold_fix")
    private final boolean enablePkMultiFoldFix;

    @SerializedName("privilege_fold_fix")
    private final boolean enablePrivilegeFoldFix;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/common/settings/RevenueFoldFixConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevenueFoldFixConfigSerializableObjectImpl.class);
        }
    }

    public RevenueFoldFixConfigSerializableObjectImpl() {
        this.enablePkMultiFoldFix = false;
        this.enableGiftPanelFoldFix = false;
        this.enablePrivilegeFoldFix = false;
    }

    @Override // ay0.e
    public final boolean b4() {
        return this.enablePkMultiFoldFix;
    }

    @Override // ay0.e
    public final boolean u4() {
        return this.enableGiftPanelFoldFix;
    }
}
