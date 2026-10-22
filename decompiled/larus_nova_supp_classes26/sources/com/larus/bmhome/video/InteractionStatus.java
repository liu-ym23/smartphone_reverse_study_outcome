package com.larus.bmhome.video;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/video/InteractionStatus;", "", "isLiked", "", "isCollected", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionStatus {

    @SerializedName("is_collected")
    private final boolean isCollected;

    @SerializedName("is_liked")
    private final boolean isLiked;

    public InteractionStatus() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ InteractionStatus copy$default(InteractionStatus r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isLiked;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isCollected;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isLiked;
    }

    public final boolean component2() {
        return this.isCollected;
    }

    public final InteractionStatus copy(boolean r2, boolean r3) {
        return new InteractionStatus(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InteractionStatus) == true) goto L8;
        return false;
    L8:
        InteractionStatus r6 = (InteractionStatus) r5;
        if (this.isLiked == r6.isLiked) goto L12;
        return false;
    L12:
        if (this.isCollected == r6.isCollected) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isLiked == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isCollected == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "InteractionStatus(isLiked=" + this.isLiked + ", isCollected=" + this.isCollected + ')';
    }

    public final boolean isCollected() {
        return this.isCollected;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    public InteractionStatus(boolean r1, boolean r2) {
        this.isLiked = r1;
        this.isCollected = r2;
    }

    public /* synthetic */ InteractionStatus(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
