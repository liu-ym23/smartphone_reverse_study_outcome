package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "Ljava/io/Serializable;", "type", "", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "", "desc", a.KEY_SCHEMA, "(ILcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getSchema", "getTitle", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBannerStruct implements Serializable {

    @SerializedName("desc")
    private final String desc;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName(a.KEY_SCHEMA)
    private final String schema;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final int type;

    public static /* synthetic */ SkuBannerStruct copy$default(SkuBannerStruct r10, int r11, ECUrlModel r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.type;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.icon;
    L8:
        ECUrlModel r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.title;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.desc;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.schema;
    L17:
        int r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final int component1() {
        return this.type;
    }

    public final ECUrlModel component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.desc;
    }

    public final String component5() {
        return this.schema;
    }

    public final SkuBannerStruct copy(int r10, ECUrlModel r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "icon");
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r13, "desc");
        Intrinsics.checkNotNullParameter(r14, a.KEY_SCHEMA);
        return new SkuBannerStruct(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SkuBannerStruct) == false) goto L16;
        SkuBannerStruct r11 = (SkuBannerStruct) r10;
        if (this.type == r11.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r11.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r11.desc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.schema, r11.schema) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.type * 31;
        ECUrlModel r1 = this.icon;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.title;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.desc;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.schema;
        if (r19 == null) goto L18;
        r10 = r19.hashCode();
    L18:
        return r18 + r10;
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "SkuBannerStruct(type=" + this.type + ", icon=" + this.icon + ", title=" + this.title + ", desc=" + this.desc + ", schema=" + this.schema + ")";
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public SkuBannerStruct(int r10, ECUrlModel r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "icon");
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r13, "desc");
        Intrinsics.checkNotNullParameter(r14, a.KEY_SCHEMA);
        this.type = r10;
        this.icon = r11;
        this.title = r12;
        this.desc = r13;
        this.schema = r14;
    }
}
