package com.larus.slides.impl.actionbar.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003Jz\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/larus/slides/impl/actionbar/model/PPTTemplate;", "", "id", "", "name", "type", "", "description", "coverImage", "Lcom/larus/slides/impl/actionbar/model/ImageInfo;", "pageDetail", "Lcom/larus/slides/impl/actionbar/model/PPTTemplatePageDetail;", "isSelected", "", "extraData", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/slides/impl/actionbar/model/ImageInfo;Lcom/larus/slides/impl/actionbar/model/PPTTemplatePageDetail;ZLjava/util/Map;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "getCoverImage", "()Lcom/larus/slides/impl/actionbar/model/ImageInfo;", "getPageDetail", "()Lcom/larus/slides/impl/actionbar/model/PPTTemplatePageDetail;", "()Z", "setSelected", "(Z)V", "getExtraData", "()Ljava/util/Map;", "copyWithSelected", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/slides/impl/actionbar/model/ImageInfo;Lcom/larus/slides/impl/actionbar/model/PPTTemplatePageDetail;ZLjava/util/Map;)Lcom/larus/slides/impl/actionbar/model/PPTTemplate;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c {

    @SerializedName("cover_image")
    private final a coverImage;

    @SerializedName("description")
    private final String description;

    @SerializedName("extra_data")
    private final Map<String, String> extraData;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_selected")
    private boolean isSelected;

    @SerializedName("name")
    private final String name;

    @SerializedName("page_detail")
    private final e pageDetail;

    @SerializedName("template_type")
    private final Integer type;

    public c() {
        this.id = null;
        this.name = null;
        this.type = 0;
        this.description = null;
        this.coverImage = null;
        this.pageDetail = null;
        this.isSelected = false;
        this.extraData = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.coverImage, r6.coverImage) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pageDetail, r6.pageDetail) == true) goto L27;
        return false;
    L27:
        if (this.isSelected == r6.isSelected) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraData, r6.extraData) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.type;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.description;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        a r13 = this.coverImage;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        e r16 = this.pageDetail;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.isSelected == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        Map<String, String> r21 = this.extraData;
        if (r21 == null) goto L35;
        r1 = r21.hashCode();
    L35:
        return r20 + r1;
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PPTTemplate(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", description=" + this.description + ", coverImage=" + this.coverImage + ", pageDetail=" + this.pageDetail + ", isSelected=" + this.isSelected + ", extraData=" + this.extraData + ')';
    }

    public final a a() {
        return this.coverImage;
    }

    public final String b() {
        return this.id;
    }

    public final String c() {
        return this.name;
    }

    public final boolean d() {
        return this.isSelected;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void e(boolean r1) {
        this.isSelected = r1;
    }
}
