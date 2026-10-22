package com.larus.bmhome.dora;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/dora/DoraEVisionExt;", "", "mode", "", "scene", "realTime", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScene", "getRealTime", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/dora/DoraEVisionExt;", "equals", "", "other", "hashCode", "toString", "", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraEVisionExt {

    @SerializedName("vision_mode")
    private final Integer mode;

    @SerializedName("real_time")
    private final Integer realTime;

    @SerializedName("vision_biz_scene")
    private final Integer scene;

    public DoraEVisionExt() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DoraEVisionExt copy$default(DoraEVisionExt r0, Integer r1, Integer r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.mode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.scene;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.realTime;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.mode;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Integer component3() {
        return this.realTime;
    }

    public final DoraEVisionExt copy(Integer r2, Integer r3, Integer r4) {
        return new DoraEVisionExt(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraEVisionExt) == true) goto L8;
        return false;
    L8:
        DoraEVisionExt r6 = (DoraEVisionExt) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.realTime, r6.realTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.mode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.scene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.realTime;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraEVisionExt(mode=" + this.mode + ", scene=" + this.scene + ", realTime=" + this.realTime + ')';
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final Integer getRealTime() {
        return this.realTime;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public DoraEVisionExt(Integer r1, Integer r2, Integer r3) {
        this.mode = r1;
        this.scene = r2;
        this.realTime = r3;
    }

    public /* synthetic */ DoraEVisionExt(Integer r2, Integer r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
