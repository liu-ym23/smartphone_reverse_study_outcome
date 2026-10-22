package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ImageObj;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JK\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasGenerateData;", "Ljava/io/Serializable;", "genePrompt", "", "modelName", "refImages", "", "Lcom/larus/im/bean/message/ImageObj;", "imageOriRaw", "imageTargetRaw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasGenerateData implements Serializable {

    @SerializedName("gene_prompt")
    public final String genePrompt;

    @SerializedName("image_ori_raw")
    public final ImageObj imageOriRaw;

    @SerializedName("image_target_raw")
    public final ImageObj imageTargetRaw;

    @SerializedName("model_name")
    public final String modelName;

    @SerializedName("ref_images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final List<ImageObj> refImages;

    public CanvasGenerateData() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CanvasGenerateData copy$default(CanvasGenerateData r3, String r4, String r5, List r6, ImageObj r7, ImageObj r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.genePrompt;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.modelName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.refImages;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.imageOriRaw;
    L14:
        ImageObj r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.imageTargetRaw;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.genePrompt;
    }

    public final String component2() {
        return this.modelName;
    }

    public final List<ImageObj> component3() {
        return this.refImages;
    }

    public final ImageObj component4() {
        return this.imageOriRaw;
    }

    public final ImageObj component5() {
        return this.imageTargetRaw;
    }

    public final CanvasGenerateData copy(String r8, String r9, List<ImageObj> r10, ImageObj r11, ImageObj r12) {
        return new CanvasGenerateData(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CanvasGenerateData) == true) goto L8;
        return false;
    L8:
        CanvasGenerateData r6 = (CanvasGenerateData) r5;
        if (Intrinsics.areEqual(this.genePrompt, r6.genePrompt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.modelName, r6.modelName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refImages, r6.refImages) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOriRaw, r6.imageOriRaw) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageTargetRaw, r6.imageTargetRaw) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.genePrompt;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.modelName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<ImageObj> r7 = this.refImages;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageObj r10 = this.imageOriRaw;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ImageObj r13 = this.imageTargetRaw;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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

    public String toString() {
        return "CanvasGenerateData(genePrompt=" + this.genePrompt + ", modelName=" + this.modelName + ", refImages=" + this.refImages + ", imageOriRaw=" + this.imageOriRaw + ", imageTargetRaw=" + this.imageTargetRaw + ')';
    }

    public CanvasGenerateData(String r1, String r2, List<ImageObj> r3, ImageObj r4, ImageObj r5) {
        this.genePrompt = r1;
        this.modelName = r2;
        this.refImages = r3;
        this.imageOriRaw = r4;
        this.imageTargetRaw = r5;
    }

    public /* synthetic */ CanvasGenerateData(String r5, String r6, List r7, ImageObj r8, ImageObj r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        List r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        ImageObj r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        ImageObj r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
