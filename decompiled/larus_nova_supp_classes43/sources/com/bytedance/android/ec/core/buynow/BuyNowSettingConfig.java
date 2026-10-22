package com.bytedance.android.ec.core.buynow;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/BuyNowSettingConfig;", "Ljava/io/Serializable;", "buynow_yata_check", "", "extendFields", "", "", "(ZLjava/util/List;)V", "getBuynow_yata_check", "()Z", "getExtendFields", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowSettingConfig implements Serializable {

    @SerializedName("buynow_yata_check")
    private final boolean buynow_yata_check;

    @SerializedName("extend_fields")
    private final List<String> extendFields;

    public BuyNowSettingConfig() {
        List r0 = null;
        boolean r10 = false;
        this(r10, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuyNowSettingConfig copy$default(BuyNowSettingConfig r0, boolean r1, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.buynow_yata_check;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.extendFields;
    L9:
        return r0.copy(r1, r10);
    }

    public final boolean component1() {
        return this.buynow_yata_check;
    }

    public final List<String> component2() {
        return this.extendFields;
    }

    public final BuyNowSettingConfig copy(boolean r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "extendFields");
        return new BuyNowSettingConfig(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof BuyNowSettingConfig) == false) goto L10;
        BuyNowSettingConfig r11 = (BuyNowSettingConfig) r10;
        if (this.buynow_yata_check == r11.buynow_yata_check) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extendFields, r11.extendFields) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r0 = this.buynow_yata_check;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r10 = r1 * 31;
        List<String> r11 = this.extendFields;
        if (r11 == null) goto L8;
        int r12 = r11.hashCode();
    L10:
        return r10 + r12;
    L8:
        r12 = 0;
        goto L10
    }

    public String toString() {
        return "BuyNowSettingConfig(buynow_yata_check=" + this.buynow_yata_check + ", extendFields=" + this.extendFields + ")";
    }

    public final boolean getBuynow_yata_check() {
        return this.buynow_yata_check;
    }

    public final List<String> getExtendFields() {
        return this.extendFields;
    }

    public BuyNowSettingConfig(boolean r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "extendFields");
        this.buynow_yata_check = r10;
        this.extendFields = r11;
    }

    public /* synthetic */ BuyNowSettingConfig(boolean r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = CollectionsKt.listOf(new String[]{"all_products", "product_click_index", "product_click_event", "type", "is_scroll", "add_on_desc", "title", "products"});
    L8:
        this(r10, r11);
    }
}
