package com.larus.community.impl.detail.bottomtools;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016JF\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "creationId", "", "liked", "", "likeCount", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "showAnimation", "<init>", "(Ljava/lang/String;ZJLcom/larus/platform/api/creation/UserCreation;Ljava/lang/Boolean;)V", "getCreationId", "()Ljava/lang/String;", "getLiked", "()Z", "getLikeCount", "()J", "getCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "getShowAnimation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ZJLcom/larus/platform/api/creation/UserCreation;Ljava/lang/Boolean;)Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLikeState implements w1a.b {

    @SerializedName("creation")
    private final UserCreation creation;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("like_count")
    private final long likeCount;

    @SerializedName("liked")
    private final boolean liked;

    @SerializedName("show_animation")
    private final Boolean showAnimation;

    public CreationLikeState() {
        this(null, false, 0, null, null, 31, null);
    }

    public static /* synthetic */ CreationLikeState copy$default(CreationLikeState r4, String r5, boolean r6, long r7, UserCreation r9, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.creationId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.liked;
    L8:
        boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.likeCount;
    L11:
        long r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.creation;
    L14:
        UserCreation r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.showAnimation;
    L17:
        String r8 = r5;
        return r4.copy(r8, r13, r0, r2, r10);
    }

    public final String component1() {
        return this.creationId;
    }

    public final boolean component2() {
        return this.liked;
    }

    public final long component3() {
        return this.likeCount;
    }

    public final UserCreation component4() {
        return this.creation;
    }

    public final Boolean component5() {
        return this.showAnimation;
    }

    public final CreationLikeState copy(String r9, boolean r10, long r11, UserCreation r13, Boolean r14) {
        return new CreationLikeState(r9, r10, r11, r13, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CreationLikeState) == true) goto L8;
        return false;
    L8:
        CreationLikeState r9 = (CreationLikeState) r8;
        if (Intrinsics.areEqual(this.creationId, r9.creationId) == true) goto L12;
        return false;
    L12:
        if (this.liked == r9.liked) goto L15;
        return false;
    L15:
        if (this.likeCount == r9.likeCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creation, r9.creation) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showAnimation, r9.showAnimation) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.liked == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        long r6 = this.likeCount;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        UserCreation r8 = this.creation;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.showAnimation;
        if (r11 == null) goto L19;
        r1 = r11.hashCode();
    L19:
        return r10 + r1;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationLikeState(creationId=" + this.creationId + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", creation=" + this.creation + ", showAnimation=" + this.showAnimation + ')';
    }

    public final UserCreation getCreation() {
        return this.creation;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final Boolean getShowAnimation() {
        return this.showAnimation;
    }

    public CreationLikeState(String r1, boolean r2, long r3, UserCreation r5, Boolean r6) {
        this.creationId = r1;
        this.liked = r2;
        this.likeCount = r3;
        this.creation = r5;
        this.showAnimation = r6;
    }

    public /* synthetic */ CreationLikeState(String r5, boolean r6, long r7, UserCreation r9, Boolean r10, int r11, DefaultConstructorMarker r12) {
        UserCreation r0 = null;
        if ((r11 & 1) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r11 & 4) == 0) goto L13;
        r7 = 0;
    L13:
        long r2 = r7;
        if ((r11 & 8) != 0) goto L18;
        r0 = r9;
    L18:
        if ((r11 & 16) == 0) goto L20;
        r10 = Boolean.FALSE;
    L20:
        this(r13, r1, r2, r0, r10);
        return;
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
