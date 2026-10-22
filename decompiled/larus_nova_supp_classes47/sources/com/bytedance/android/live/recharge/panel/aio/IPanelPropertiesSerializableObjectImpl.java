package com.bytedance.android.live.recharge.panel.aio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\"\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/IPanelPropertiesSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "()V", "customPrice", "", "getCustomPrice", "()Ljava/lang/Long;", "setCustomPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isCombinedPaySelected", "", "()Ljava/lang/Boolean;", "setCombinedPaySelected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isHidePanel", "setHidePanel", "isRechargeAgreementAccepted", "setRechargeAgreementAccepted", "isShowCenterLoading", "setShowCenterLoading", "panelMode", "", "getPanelMode", "()I", "setPanelMode", "(I)V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPanelPropertiesSerializableObjectImpl implements IPanelProperties {

    @SerializedName("custom_price")
    private Long customPrice;

    @SerializedName("is_combined_pay_selected")
    private Boolean isCombinedPaySelected;

    @SerializedName("is_hide_panel")
    private Boolean isHidePanel;

    @SerializedName("is_recharge_agreement_accepted")
    private Boolean isRechargeAgreementAccepted;

    @SerializedName("is_show_center_loading")
    private Boolean isShowCenterLoading;

    @SerializedName("panel_mode")
    private int panelMode;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/IPanelPropertiesSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IPanelPropertiesSerializableObjectImpl.class);
        }
    }

    public IPanelPropertiesSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final Long getCustomPrice() {
        return this.customPrice;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final int getPanelMode() {
        return this.panelMode;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final Boolean isCombinedPaySelected() {
        return this.isCombinedPaySelected;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final Boolean isHidePanel() {
        return this.isHidePanel;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final Boolean isRechargeAgreementAccepted() {
        return this.isRechargeAgreementAccepted;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final Boolean isShowCenterLoading() {
        return this.isShowCenterLoading;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final void setCombinedPaySelected(Boolean r1) {
        this.isCombinedPaySelected = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final void setCustomPrice(Long r1) {
        this.customPrice = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final void setHidePanel(Boolean r1) {
        this.isHidePanel = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final void setPanelMode(int r1) {
        this.panelMode = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final void setRechargeAgreementAccepted(Boolean r1) {
        this.isRechargeAgreementAccepted = r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.aio.IPanelProperties, vw0.d
    public final void setShowCenterLoading(Boolean r1) {
        this.isShowCenterLoading = r1;
    }
}
