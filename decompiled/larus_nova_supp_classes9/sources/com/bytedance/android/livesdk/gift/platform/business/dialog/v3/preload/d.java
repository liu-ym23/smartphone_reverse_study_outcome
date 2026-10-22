package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/d;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "enableScroll", "e", "enableDefaultSelect", "d", "enableChangeTab", "b", "enableCreatePanel", "c", "preloadGiftExtra", "g", "preloadLynxModel", "h", BuildConfig.FLAVOR, "gridViewHolderItemNum", "I", "f", "()I", "verticalPageItemNum", "i", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_change_tab")
    private final boolean enableChangeTab;

    @SerializedName("enable_create_panel")
    private final boolean enableCreatePanel;

    @SerializedName("enable_default_select")
    private final boolean enableDefaultSelect;

    @SerializedName("enable_scroll")
    private final boolean enableScroll;

    @SerializedName("grid_view_holder_item_num")
    private final int gridViewHolderItemNum;

    @SerializedName("preload_gift_extra")
    private final boolean preloadGiftExtra;

    @SerializedName("preload_lynx_model")
    private final boolean preloadLynxModel;

    @SerializedName("vertical_page_item_num")
    private final int verticalPageItemNum;

    public d() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L24;
        d r4 = (d) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.enableScroll == r4.enableScroll) goto L10;
        return false;
    L10:
        if (this.enableDefaultSelect == r4.enableDefaultSelect) goto L12;
        return false;
    L12:
        if (this.enableChangeTab == r4.enableChangeTab) goto L14;
        return false;
    L14:
        if (this.enableCreatePanel == r4.enableCreatePanel) goto L16;
        return false;
    L16:
        if (this.preloadGiftExtra == r4.preloadGiftExtra) goto L18;
        return false;
    L18:
        if (this.preloadLynxModel == r4.preloadLynxModel) goto L20;
        return false;
    L20:
        if (this.gridViewHolderItemNum == r4.gridViewHolderItemNum) goto L22;
        return false;
    L22:
        if (this.verticalPageItemNum == r4.verticalPageItemNum) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.enableScroll;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.enableDefaultSelect;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.enableChangeTab;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r13 = (r9 + r11) * 31;
        boolean r14 = this.enableCreatePanel;
        ?? r15 = r14;
        if (r14 == false) goto L17;
        r15 = 1;
    L17:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.preloadGiftExtra;
        ?? r18 = r17;
        if (r17 == false) goto L20;
        r18 = 1;
    L20:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.preloadLynxModel;
        if (r20 == true) goto L25;
        r1 = r20;
    L25:
        return ((((r19 + r1) * 31) + this.gridViewHolderItemNum) * 31) + this.verticalPageItemNum;
    }

    public final String toString() {
        return "GiftPreloaderConfig(enable=" + this.enable + ", enableScroll=" + this.enableScroll + ", enableDefaultSelect=" + this.enableDefaultSelect + ", enableChangeTab=" + this.enableChangeTab + ", enableCreatePanel=" + this.enableCreatePanel + ", preloadGiftExtra=" + this.preloadGiftExtra + ", preloadLynxModel=" + this.preloadLynxModel + ", gridViewHolderItemNum=" + this.gridViewHolderItemNum + ", verticalPageItemNum=" + this.verticalPageItemNum + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableChangeTab;
    }

    public final boolean c() {
        return this.enableCreatePanel;
    }

    public final boolean d() {
        return this.enableDefaultSelect;
    }

    public final boolean e() {
        return this.enableScroll;
    }

    public final int f() {
        return this.gridViewHolderItemNum;
    }

    public final boolean g() {
        return this.preloadGiftExtra;
    }

    public final boolean h() {
        return this.preloadLynxModel;
    }

    public final int i() {
        return this.verticalPageItemNum;
    }

    public d(int r1) {
        this.enable = false;
        this.enableScroll = false;
        this.enableDefaultSelect = false;
        this.enableChangeTab = false;
        this.enableCreatePanel = false;
        this.preloadGiftExtra = false;
        this.preloadLynxModel = false;
        this.gridViewHolderItemNum = 12;
        this.verticalPageItemNum = 2;
    }
}
