package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "actionDownPreload", "Z", "a", "()Z", "setActionDownPreload", "(Z)V", "openRechargePreload", "c", "setOpenRechargePreload", "enterRoomPreload", "b", "setEnterRoomPreload", "panelClosePreload", "d", "setPanelClosePreload", "preloadGiftPanelLayout", "getPreloadGiftPanelLayout", "setPreloadGiftPanelLayout", "preloadPanelViews", "g", "setPreloadPanelViews", "preloadGiftItems", "f", "setPreloadGiftItems", BuildConfig.FLAVOR, "preloadGiftItemCount", "I", "e", "()I", "setPreloadGiftItemCount", "(I)V", "adaptPanelViews", "getAdaptPanelViews", "setAdaptPanelViews", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("action_down_preload")
    private boolean actionDownPreload;

    @SerializedName("adapt_panel_views")
    private boolean adaptPanelViews;

    @SerializedName("enter_room_preload")
    private boolean enterRoomPreload;

    @SerializedName("open_recharge_preload")
    private boolean openRechargePreload;

    @SerializedName("panel_close_preload")
    private boolean panelClosePreload;

    @SerializedName("preload_gift_item_count")
    private int preloadGiftItemCount;

    @SerializedName("preload_gift_items")
    private boolean preloadGiftItems;

    @SerializedName("preload_gift_panel_layout")
    private boolean preloadGiftPanelLayout;

    @SerializedName("preload_panel_views")
    private boolean preloadPanelViews;

    public a() {
        this.preloadGiftItemCount = 12;
    }

    public final boolean a() {
        return this.actionDownPreload;
    }

    public final boolean b() {
        return this.enterRoomPreload;
    }

    public final boolean c() {
        return this.openRechargePreload;
    }

    public final boolean d() {
        return this.panelClosePreload;
    }

    public final int e() {
        return this.preloadGiftItemCount;
    }

    public final boolean f() {
        return this.preloadGiftItems;
    }

    public final boolean g() {
        return this.preloadPanelViews;
    }
}
