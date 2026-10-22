package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelMutateOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/d0;", BuildConfig.FLAVOR, "refreshSelectExtraOpt", "Z", "C5", "()Z", "markingInfoOpt", "f5", "seriesInfoOpt", "w5", "carnivalMsgOpt", "u2", "expansionWidthOpt", "e5", "giftShowChangeOpt", "E8", "observeSelectBuffOpt", "R1", "selectGiftExtraOpt", "L8", "aboveComponentSizeOpt", "f8", "observeTopViewModeOpt", "l0", "mergeGiftExtraMutate", "W7", "newBatchReduceOpt", "g4", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelMutateOptSerializableObjectImpl implements d0 {

    @SerializedName("above_component_size_opt")
    private final boolean aboveComponentSizeOpt;

    @SerializedName("carnival_msg_opt")
    private final boolean carnivalMsgOpt;

    @SerializedName("expansion_width_opt")
    private final boolean expansionWidthOpt;

    @SerializedName("gift_show_change_opt")
    private final boolean giftShowChangeOpt;

    @SerializedName("marketing_info_opt")
    private final boolean markingInfoOpt;

    @SerializedName("merge_gift_extra_mutate")
    private final boolean mergeGiftExtraMutate;

    @SerializedName("new_batch_reduce_opt")
    private final boolean newBatchReduceOpt;

    @SerializedName("observe_select_buff_opt")
    private final boolean observeSelectBuffOpt;

    @SerializedName("observe_top_view_mode_opt")
    private final boolean observeTopViewModeOpt;

    @SerializedName("refresh_select_extra_opt")
    private final boolean refreshSelectExtraOpt;

    @SerializedName("select_gift_extra_opt")
    private final boolean selectGiftExtraOpt;

    @SerializedName("series_info_opt")
    private final boolean seriesInfoOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelMutateOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftPanelMutateOptSerializableObjectImpl.class);
        }
    }

    public GiftPanelMutateOptSerializableObjectImpl() {
        this.refreshSelectExtraOpt = false;
        this.markingInfoOpt = false;
        this.seriesInfoOpt = false;
        this.carnivalMsgOpt = false;
        this.expansionWidthOpt = false;
        this.giftShowChangeOpt = false;
        this.observeSelectBuffOpt = false;
        this.selectGiftExtraOpt = false;
        this.aboveComponentSizeOpt = false;
        this.observeTopViewModeOpt = false;
        this.mergeGiftExtraMutate = false;
        this.newBatchReduceOpt = false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean C5() {
        return this.refreshSelectExtraOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean E8() {
        return this.giftShowChangeOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean L8() {
        return this.selectGiftExtraOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean R1() {
        return this.observeSelectBuffOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean W7() {
        return this.mergeGiftExtraMutate;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean e5() {
        return this.expansionWidthOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean f5() {
        return this.markingInfoOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean f8() {
        return this.aboveComponentSizeOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean g4() {
        return this.newBatchReduceOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean l0() {
        return this.observeTopViewModeOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean u2() {
        return this.carnivalMsgOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d0
    public final boolean w5() {
        return this.seriesInfoOpt;
    }
}
