package com.bytedance.android.ec.common.api.model;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/common/api/model/PlaybackSmallCardViewState;", "Ljava/io/Serializable;", "smallCardViewWidth", "", "smallCardViewHeight", "productImageSize", "(III)V", "getProductImageSize", "()I", "getSmallCardViewHeight", "getSmallCardViewWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class PlaybackSmallCardViewState implements Serializable {
    private final int productImageSize;
    private final int smallCardViewHeight;
    private final int smallCardViewWidth;

    public static /* synthetic */ PlaybackSmallCardViewState copy$default(PlaybackSmallCardViewState r0, int r1, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.smallCardViewWidth;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.smallCardViewHeight;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.productImageSize;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final int component1() {
        return this.smallCardViewWidth;
    }

    public final int component2() {
        return this.smallCardViewHeight;
    }

    public final int component3() {
        return this.productImageSize;
    }

    public final PlaybackSmallCardViewState copy(int r10, int r11, int r12) {
        return new PlaybackSmallCardViewState(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof PlaybackSmallCardViewState) == false) goto L12;
        PlaybackSmallCardViewState r11 = (PlaybackSmallCardViewState) r10;
        if (this.smallCardViewWidth == r11.smallCardViewWidth) goto L8;
        return false;
    L8:
        if (this.smallCardViewHeight == r11.smallCardViewHeight) goto L10;
        return false;
    L10:
        if (this.productImageSize == r11.productImageSize) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (((this.smallCardViewWidth * 31) + this.smallCardViewHeight) * 31) + this.productImageSize;
    }

    public String toString() {
        return "PlaybackSmallCardViewState(smallCardViewWidth=" + this.smallCardViewWidth + ", smallCardViewHeight=" + this.smallCardViewHeight + ", productImageSize=" + this.productImageSize + ")";
    }

    public final int getProductImageSize() {
        return this.productImageSize;
    }

    public final int getSmallCardViewHeight() {
        return this.smallCardViewHeight;
    }

    public final int getSmallCardViewWidth() {
        return this.smallCardViewWidth;
    }

    public PlaybackSmallCardViewState(int r1, int r10, int r11) {
        this.smallCardViewWidth = r1;
        this.smallCardViewHeight = r10;
        this.productImageSize = r11;
    }
}
