package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/canvas/service/bean/PresetRefImage;", "", "imageThumb", "Lcom/larus/canvas/service/bean/Icon;", "imageOri", "<init>", "(Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;)V", "getImageThumb", "()Lcom/larus/canvas/service/bean/Icon;", "getImageOri", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PresetRefImage {

    @SerializedName("image_ori")
    private final Icon imageOri;

    @SerializedName("image_thumb")
    private final Icon imageThumb;

    public PresetRefImage() {
        Icon r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ PresetRefImage copy$default(PresetRefImage r0, Icon r1, Icon r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.imageThumb;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.imageOri;
    L9:
        return r0.copy(r1, r2);
    }

    public final Icon component1() {
        return this.imageThumb;
    }

    public final Icon component2() {
        return this.imageOri;
    }

    public final PresetRefImage copy(Icon r2, Icon r3) {
        return new PresetRefImage(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PresetRefImage) == true) goto L8;
        return false;
    L8:
        PresetRefImage r6 = (PresetRefImage) r5;
        if (Intrinsics.areEqual(this.imageThumb, r6.imageThumb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageOri, r6.imageOri) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Icon r0 = this.imageThumb;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Icon r4 = this.imageOri;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PresetRefImage(imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ')';
    }

    public final Icon getImageOri() {
        return this.imageOri;
    }

    public final Icon getImageThumb() {
        return this.imageThumb;
    }

    public PresetRefImage(Icon r1, Icon r2) {
        this.imageThumb = r1;
        this.imageOri = r2;
    }

    public /* synthetic */ PresetRefImage(Icon r2, Icon r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
