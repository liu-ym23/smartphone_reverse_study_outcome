package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelFrequentCallOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/a0;", BuildConfig.FLAVOR, "banSendGiftToSelf", "Z", "getBanSendGiftToSelf", "()Z", "isBuffShowOpt", "itemListDataCache", "getItemListDataCache", "wrapDialogIconModelOpt", "w7", "businessStateOpt", "getBusinessStateOpt", "giftCardSpOpt", "W2", "settingOpt", "G8", "resourceOpt", "a2", "newListOpt", "n3", "bottomTextOpt", "p3", "logGiftShowOpt", "U5", "aLogOpt", "q0", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelFrequentCallOptSerializableObjectImpl implements a0 {

    @SerializedName("alog_opt")
    private final boolean aLogOpt;

    @SerializedName("ban_send_gift_to_self_opt")
    private final boolean banSendGiftToSelf;

    @SerializedName("bottom_text_opt")
    private final boolean bottomTextOpt;

    @SerializedName("business_state_opt")
    private final boolean businessStateOpt;

    @SerializedName("gift_card_sp_opt")
    private final boolean giftCardSpOpt;

    @SerializedName("is_buff_show_opt")
    private final boolean isBuffShowOpt;

    @SerializedName("item_list_data_cache")
    private final boolean itemListDataCache;

    @SerializedName("log_gift_show_opt")
    private final boolean logGiftShowOpt;

    @SerializedName("new_list_opt")
    private final boolean newListOpt;

    @SerializedName("resource_opt")
    private final boolean resourceOpt;

    @SerializedName("setting_opt")
    private final boolean settingOpt;

    @SerializedName("wrap_dialog_icon_model_opt")
    private final boolean wrapDialogIconModelOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelFrequentCallOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftPanelFrequentCallOptSerializableObjectImpl.class);
        }
    }

    public GiftPanelFrequentCallOptSerializableObjectImpl() {
        this.banSendGiftToSelf = false;
        this.isBuffShowOpt = false;
        this.itemListDataCache = false;
        this.wrapDialogIconModelOpt = false;
        this.businessStateOpt = false;
        this.giftCardSpOpt = false;
        this.settingOpt = false;
        this.resourceOpt = false;
        this.newListOpt = false;
        this.bottomTextOpt = false;
        this.logGiftShowOpt = false;
        this.aLogOpt = false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean G8() {
        return this.settingOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean U5() {
        return this.logGiftShowOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean W2() {
        return this.giftCardSpOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean a2() {
        return this.resourceOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean n3() {
        return this.newListOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean p3() {
        return this.bottomTextOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean q0() {
        return this.aLogOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.a0
    public final boolean w7() {
        return this.wrapDialogIconModelOpt;
    }
}
