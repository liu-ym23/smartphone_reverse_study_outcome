package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelAsyncTaskConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/y;", BuildConfig.FLAVOR, "giftShowLog", "Z", "y0", "()Z", "giftPreviewLog", "B0", "profitCheck", "k8", "giftItemShowLog", "Y1", "giftTabShowLog", "f9", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelAsyncTaskConfigSerializableObjectImpl implements y {

    @SerializedName("gift_item_show_log")
    private final boolean giftItemShowLog;

    @SerializedName("gift_preview_log")
    private final boolean giftPreviewLog;

    @SerializedName("gift_show_log")
    private final boolean giftShowLog;

    @SerializedName("gift_tab_show_log")
    private final boolean giftTabShowLog;

    @SerializedName("profit_check")
    private final boolean profitCheck;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelAsyncTaskConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftPanelAsyncTaskConfigSerializableObjectImpl.class);
        }
    }

    public GiftPanelAsyncTaskConfigSerializableObjectImpl() {
        this.giftShowLog = false;
        this.giftPreviewLog = false;
        this.profitCheck = false;
        this.giftItemShowLog = false;
        this.giftTabShowLog = false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.y
    public final boolean B0() {
        return this.giftPreviewLog;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.y
    public final boolean Y1() {
        return this.giftItemShowLog;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.y
    public final boolean f9() {
        return this.giftTabShowLog;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.y
    public final boolean k8() {
        return this.profitCheck;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.y
    public final boolean y0() {
        return this.giftShowLog;
    }
}
