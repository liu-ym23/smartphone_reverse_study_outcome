package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\rR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000f\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\t\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\r¨\u00064"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/PreviewStatusInfo;", "Ljava/io/Serializable;", "", "status", "", "currentStatusName", "currentStatusKeyName", "", "hasMiniAppPermission", "Z", "getHasMiniAppPermission", "()Z", "setHasMiniAppPermission", "(Z)V", "miniAppCount", "I", "getMiniAppCount", "()I", "setMiniAppCount", "(I)V", "commodityCount", "getCommodityCount", "setCommodityCount", "transformCardCount", "getTransformCardCount", "setTransformCardCount", "hasWelfarePermission", "getHasWelfarePermission", "setHasWelfarePermission", "", "welfareProjectId", "J", "getWelfareProjectId", "()J", "setWelfareProjectId", "(J)V", "mixMiniAppCount", "getMixMiniAppCount", "setMixMiniAppCount", "groupPurchasePermission", "getGroupPurchasePermission", "setGroupPurchasePermission", "groupPurchaseCount", "getGroupPurchaseCount", "setGroupPurchaseCount", "hasPaidLiveTicket", "getHasPaidLiveTicket", "setHasPaidLiveTicket", "<init>", "()V", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewStatusInfo implements Serializable {
    public static final int COMMERCE_MINI_APP_STATUS_COMMERCE = 1;
    public static final int COMMERCE_MINI_APP_STATUS_DEFAULT = 0;
    public static final int COMMERCE_MINI_APP_STATUS_GROUP_PURCHASE = 5;
    public static final int COMMERCE_MINI_APP_STATUS_MINI_APP = 2;
    public static final int COMMERCE_MINI_APP_STATUS_TRANSFORM_CARD = 3;
    public static final int COMMERCE_MINI_APP_STATUS_WELFARE = 4;
    public static final a Companion = null;
    public static final int MIX_MINI_APP = 2;
    public static final int PAID_LIVE_TICKET = 6;

    @SerializedName("commodityCount")
    private int commodityCount;

    @SerializedName("group_purchase_count")
    private int groupPurchaseCount;

    @SerializedName("group_purchase_permission")
    private boolean groupPurchasePermission;

    @SerializedName("permission")
    private boolean hasMiniAppPermission;

    @SerializedName("paid_live_ticket")
    private boolean hasPaidLiveTicket;

    @SerializedName("has_welfare_permission")
    private boolean hasWelfarePermission;

    @SerializedName("mini_app_count")
    private int miniAppCount;

    @SerializedName("mix_mini_app_count")
    private long mixMiniAppCount;

    @SerializedName("transformCardCount")
    private int transformCardCount;

    @SerializedName("welfare_project_id")
    private long welfareProjectId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PreviewStatusInfo() {
    }

    public final int status() {
        if (this.commodityCount <= 0) goto L6;
        return 1;
    L6:
        if (this.transformCardCount <= 0) goto L9;
        return 3;
    L9:
        if (this.miniAppCount <= 0) goto L12;
    L10:
        return 2;
    L12:
        if (this.welfareProjectId <= 0) goto L15;
        return 4;
    L15:
        if (this.mixMiniAppCount > 0) goto L10;
        if (this.groupPurchaseCount <= 0) goto L21;
        return 5;
    L21:
        if (this.hasPaidLiveTicket == false) goto L23;
        return 6;
    L23:
        return 0;
    }

    public final String currentStatusKeyName() {
        int r0 = status();
        if (r0 != 1) goto L5;
        return "COMMODITY";
    L5:
        if (r0 != 2) goto L7;
        return "TIMOR";
    L7:
        if (r0 != 4) goto L9;
        return "WELFARE_V2";
    L9:
        if (r0 != 5) goto L11;
        return "GROUP_PURCHASE";
    L11:
        if (r0 == 6) goto L13;
        return "";
    L13:
        return "PAID_LIVE";
    }

    public final String currentStatusName() {
        switch(status()) {
            case 1: goto L11;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L4;
        };
    L4:
        return "";
    L13:
        return com.bytedance.android.live.core.utils.s1.B(2131921194);
    L14:
        return com.bytedance.android.live.core.utils.s1.B(2131917222);
    L15:
        return com.bytedance.android.live.core.utils.s1.B(2131923444);
    L16:
        return com.bytedance.android.live.core.utils.s1.B(2131922964);
    L17:
        return com.bytedance.android.live.core.utils.s1.B(2131920400);
    L11:
        return com.bytedance.android.live.core.utils.s1.B(2131919980);
    }

    public final int getCommodityCount() {
        return this.commodityCount;
    }

    public final int getGroupPurchaseCount() {
        return this.groupPurchaseCount;
    }

    public final boolean getGroupPurchasePermission() {
        return this.groupPurchasePermission;
    }

    public final boolean getHasMiniAppPermission() {
        return this.hasMiniAppPermission;
    }

    public final boolean getHasPaidLiveTicket() {
        return this.hasPaidLiveTicket;
    }

    public final boolean getHasWelfarePermission() {
        return this.hasWelfarePermission;
    }

    public final int getMiniAppCount() {
        return this.miniAppCount;
    }

    public final long getMixMiniAppCount() {
        return this.mixMiniAppCount;
    }

    public final int getTransformCardCount() {
        return this.transformCardCount;
    }

    public final long getWelfareProjectId() {
        return this.welfareProjectId;
    }

    public final void setCommodityCount(int r1) {
        this.commodityCount = r1;
    }

    public final void setGroupPurchaseCount(int r1) {
        this.groupPurchaseCount = r1;
    }

    public final void setGroupPurchasePermission(boolean r1) {
        this.groupPurchasePermission = r1;
    }

    public final void setHasMiniAppPermission(boolean r1) {
        this.hasMiniAppPermission = r1;
    }

    public final void setHasPaidLiveTicket(boolean r1) {
        this.hasPaidLiveTicket = r1;
    }

    public final void setHasWelfarePermission(boolean r1) {
        this.hasWelfarePermission = r1;
    }

    public final void setMiniAppCount(int r1) {
        this.miniAppCount = r1;
    }

    public final void setMixMiniAppCount(long r1) {
        this.mixMiniAppCount = r1;
    }

    public final void setTransformCardCount(int r1) {
        this.transformCardCount = r1;
    }

    public final void setWelfareProjectId(long r1) {
        this.welfareProjectId = r1;
    }
}
