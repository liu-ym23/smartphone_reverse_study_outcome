package com.ss.android.lark.chat.base.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/base/model/ResolutionSize;", BuildConfig.FLAVOR, "width", BuildConfig.FLAVOR, "height", "<init>", "(II)V", "getWidth", "()I", "getHeight", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResolutionSize {

    @SerializedName("height")
    private final int height;

    @SerializedName("width")
    private final int width;

    public ResolutionSize() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ ResolutionSize copy$default(ResolutionSize r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final ResolutionSize copy(int r2, int r3) {
        return new ResolutionSize(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResolutionSize) == true) goto L8;
        return false;
    L8:
        ResolutionSize r6 = (ResolutionSize) r5;
        if (this.width == r6.width) goto L12;
        return false;
    L12:
        if (this.height == r6.height) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "ResolutionSize(width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public ResolutionSize(int r1, int r2) {
        this.width = r1;
        this.height = r2;
    }

    public /* synthetic */ ResolutionSize(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 10000;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 10000;
    L8:
        this(r2, r3);
    }
}
