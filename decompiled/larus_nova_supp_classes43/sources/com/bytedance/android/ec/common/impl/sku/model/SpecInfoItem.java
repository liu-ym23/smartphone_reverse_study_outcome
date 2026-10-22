package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0011¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfoItem;", "Ljava/io/Serializable;", "id", "", a.KEY_SHOPPING_GUIDE_NAME, "enabled", "", "selected", "defaultSelect", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "price", "(Ljava/lang/String;Ljava/lang/String;ZZZLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "getDefaultSelect", "()Z", "getEnabled", "setEnabled", "(Z)V", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getPrice", "setPrice", "getSelected", "setSelected", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecInfoItem implements Serializable {

    @SerializedName("default_select")
    private final boolean defaultSelect;
    private boolean enabled;
    private final ECUrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f18id;

    @SerializedName(a.KEY_SHOPPING_GUIDE_NAME)
    private String name;

    @SerializedName("price")
    private String price;
    private boolean selected;

    public SpecInfoItem() {
        this(null, null, false, false, false, null, null, 127, null);
    }

    public static /* synthetic */ SpecInfoItem copy$default(SpecInfoItem r10, String r11, String r12, boolean r13, boolean r14, boolean r15, ECUrlModel r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.f18id;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.name;
    L8:
        String r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.enabled;
    L11:
        boolean r0 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.selected;
    L14:
        boolean r1 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.defaultSelect;
    L17:
        boolean r20 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.icon;
    L20:
        ECUrlModel r21 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.price;
    L23:
        String r22 = r11;
        return r10.copy(r22, r110, r0, r1, r20, r21, r17);
    }

    public final String component1() {
        return this.f18id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final boolean component4() {
        return this.selected;
    }

    public final boolean component5() {
        return this.defaultSelect;
    }

    public final ECUrlModel component6() {
        return this.icon;
    }

    public final String component7() {
        return this.price;
    }

    public final SpecInfoItem copy(String r10, String r11, boolean r12, boolean r13, boolean r14, ECUrlModel r15, String r16) {
        return new SpecInfoItem(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SpecInfoItem) == false) goto L20;
        SpecInfoItem r11 = (SpecInfoItem) r10;
        if (Intrinsics.areEqual(this.f18id, r11.f18id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L10;
        return false;
    L10:
        if (this.enabled == r11.enabled) goto L12;
        return false;
    L12:
        if (this.selected == r11.selected) goto L14;
        return false;
    L14:
        if (this.defaultSelect == r11.defaultSelect) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.price, r11.price) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.f18id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.name;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        boolean r15 = this.enabled;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L13;
        r17 = 1;
    L13:
        int r18 = (r14 + r17) * 31;
        boolean r19 = this.selected;
        ?? r20 = r19;
        if (r19 == false) goto L16;
        r20 = 1;
    L16:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.defaultSelect;
        if (r22 == true) goto L20;
        r16 = r22;
    L20:
        int r23 = (r21 + r16) * 31;
        ECUrlModel r24 = this.icon;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 31;
        String r27 = this.price;
        if (r27 == null) goto L28;
        r1 = r27.hashCode();
    L28:
        return r26 + r1;
    L23:
        r25 = 0;
        goto L24
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "SpecInfoItem(id=" + this.f18id + ", name=" + this.name + ", enabled=" + this.enabled + ", selected=" + this.selected + ", defaultSelect=" + this.defaultSelect + ", icon=" + this.icon + ", price=" + this.price + ")";
    }

    public final boolean getDefaultSelect() {
        return this.defaultSelect;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f18id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrice() {
        return this.price;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public final void setId(String r1) {
        this.f18id = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setPrice(String r1) {
        this.price = r1;
    }

    public final void setSelected(boolean r1) {
        this.selected = r1;
    }

    public SpecInfoItem(String r1, String r10, boolean r11, boolean r12, boolean r13, ECUrlModel r14, String r15) {
        this.f18id = r1;
        this.name = r10;
        this.enabled = r11;
        this.selected = r12;
        this.defaultSelect = r13;
        this.icon = r14;
        this.price = r15;
    }

    public /* synthetic */ SpecInfoItem(String r10, String r11, boolean r12, boolean r13, boolean r14, ECUrlModel r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        String r19 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        boolean r20 = true;
    L15:
        if ((r17 & 8) == 0) goto L17;
        boolean r21 = false;
    L19:
        if ((r17 & 16) == 0) goto L21;
        boolean r22 = false;
    L23:
        if ((r17 & 32) == 0) goto L25;
        ECUrlModel r23 = null;
    L27:
        if ((r17 & 64) == 0) goto L29;
        String r110 = null;
    L30:
        this(r19, r1, r20, r21, r22, r23, r110);
        return;
    L29:
        r110 = r16;
        goto L30
    L25:
        r23 = r15;
        goto L27
    L21:
        r22 = r14;
        goto L23
    L17:
        r21 = r13;
        goto L19
    L13:
        r20 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r19 = r10;
        goto L7
    }
}
