package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "Ljava/io/Serializable;", "title", "", "icon", "width", "", "height", "images", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Ljava/lang/String;", "getImages", "()Ljava/util/List;", "getTitle", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "equals", "", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecChartStruct implements Serializable {

    @SerializedName("height")
    private final Integer height;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("images")
    private final List<ECUrlModel> images;

    @SerializedName("text")
    private final String title;

    @SerializedName("width")
    private final Integer width;

    public SpecChartStruct() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpecChartStruct copy$default(SpecChartStruct r10, String r11, String r12, Integer r13, Integer r14, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.title;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.icon;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.width;
    L11:
        Integer r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.height;
    L14:
        Integer r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.images;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final List<ECUrlModel> component5() {
        return this.images;
    }

    public final SpecChartStruct copy(String r10, String r11, Integer r12, Integer r13, List<? extends ECUrlModel> r14) {
        return new SpecChartStruct(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SpecChartStruct) == false) goto L16;
        SpecChartStruct r11 = (SpecChartStruct) r10;
        if (Intrinsics.areEqual(this.title, r11.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.width, r11.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r11.height) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.images, r11.images) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.icon;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Integer r15 = this.width;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.height;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        List<ECUrlModel> r21 = this.images;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return r20 + r1;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "SpecChartStruct(title=" + this.title + ", icon=" + this.icon + ", width=" + this.width + ", height=" + this.height + ", images=" + this.images + ")";
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<ECUrlModel> getImages() {
        return this.images;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public SpecChartStruct(String r1, String r10, Integer r11, Integer r12, List<? extends ECUrlModel> r13) {
        this.title = r1;
        this.icon = r10;
        this.width = r11;
        this.height = r12;
        this.images = r13;
    }

    public /* synthetic */ SpecChartStruct(String r10, String r11, Integer r12, Integer r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        Integer r18 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        Integer r19 = null;
    L19:
        if ((r15 & 16) == 0) goto L21;
        List r110 = null;
    L22:
        this(r17, r1, r18, r19, r110);
        return;
    L21:
        r110 = r14;
        goto L22
    L17:
        r19 = r13;
        goto L19
    L13:
        r18 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r17 = r10;
        goto L7
    }
}
