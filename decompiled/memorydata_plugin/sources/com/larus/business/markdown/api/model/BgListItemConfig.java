package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/api/model/BgListItemConfig;", "", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(IILjava/lang/Float;Ljava/lang/Integer;)V", "getBgColor", "()I", "getBgMargin", "getBgRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLeading", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Float;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/BgListItemConfig;", "equals", "", "other", "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BgListItemConfig {
    private final int bgColor;
    private final int bgMargin;
    private final Float bgRadius;
    private final Integer leading;

    public BgListItemConfig(int r1, int r2, Float r3, Integer r4) {
        this.bgColor = r1;
        this.bgMargin = r2;
        this.bgRadius = r3;
        this.leading = r4;
    }

    public /* synthetic */ BgListItemConfig(int r1, int r2, Float r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = Float.valueOf(0.0f);
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = 0;
    L8:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ BgListItemConfig copy$default(BgListItemConfig r0, int r1, int r2, Float r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.bgColor;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.bgMargin;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.bgRadius;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.leading;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.bgColor;
    }

    public final int component2() {
        return this.bgMargin;
    }

    public final Float component3() {
        return this.bgRadius;
    }

    public final Integer component4() {
        return this.leading;
    }

    public final BgListItemConfig copy(int r1, int r2, Float r3, Integer r4) {
        return new BgListItemConfig(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BgListItemConfig.class) == true) goto L8;
        return false;
    L8:
        BgListItemConfig r6 = (BgListItemConfig) ZeusTransformUtils.preCheckCast(r5, BgListItemConfig.class, "com.obric.memorydata.plugin");
        if (this.bgColor == r6.bgColor) goto L12;
        return false;
    L12:
        if (this.bgMargin == r6.bgMargin) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgRadius, r6.bgRadius) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.leading, r6.leading) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getBgMargin() {
        return this.bgMargin;
    }

    public final Float getBgRadius() {
        return this.bgRadius;
    }

    public final Integer getLeading() {
        return this.leading;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.bgColor) * 31) + Integer.hashCode(this.bgMargin)) * 31;
        Float r1 = this.bgRadius;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.leading;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "BgListItemConfig(bgColor=" + this.bgColor + ", bgMargin=" + this.bgMargin + ", bgRadius=" + this.bgRadius + ", leading=" + this.leading + ')';
    }
}
