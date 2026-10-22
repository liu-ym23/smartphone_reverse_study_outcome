package com.larus.bmhome.view.actionbar.segment.vm;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "Ljava/io/Serializable;", "showLikeButton", "", "liked", "likeCount", "", "botId", "", "knowLike", "<init>", "(ZZJLjava/lang/String;Ljava/lang/Boolean;)V", "getShowLikeButton", "()Z", "getLiked", "getLikeCount", "()J", "getBotId", "()Ljava/lang/String;", "getKnowLike", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(ZZJLjava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotState;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LikeBotState implements w1a.b, Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("know_like")
    private final Boolean knowLike;

    @SerializedName("like_count")
    private final long likeCount;

    @SerializedName("liked")
    private final boolean liked;

    @SerializedName("show_like_button")
    private final boolean showLikeButton;

    public LikeBotState() {
        this(false, false, 0, null, null, 31, null);
    }

    public static /* synthetic */ LikeBotState copy$default(LikeBotState r4, boolean r5, boolean r6, long r7, String r9, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.showLikeButton;
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
        r9 = r4.botId;
    L14:
        String r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.knowLike;
    L17:
        boolean r8 = r5;
        return r4.copy(r8, r13, r0, r2, r10);
    }

    public final boolean component1() {
        return this.showLikeButton;
    }

    public final boolean component2() {
        return this.liked;
    }

    public final long component3() {
        return this.likeCount;
    }

    public final String component4() {
        return this.botId;
    }

    public final Boolean component5() {
        return this.knowLike;
    }

    public final LikeBotState copy(boolean r9, boolean r10, long r11, String r13, Boolean r14) {
        return new LikeBotState(r9, r10, r11, r13, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LikeBotState) == true) goto L8;
        return false;
    L8:
        LikeBotState r9 = (LikeBotState) r8;
        if (this.showLikeButton == r9.showLikeButton) goto L12;
        return false;
    L12:
        if (this.liked == r9.liked) goto L15;
        return false;
    L15:
        if (this.likeCount == r9.likeCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.knowLike, r9.knowLike) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.showLikeButton == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.liked == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        long r4 = this.likeCount;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        String r6 = this.botId;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r5 + r8) * 31;
        Boolean r10 = this.knowLike;
        if (r10 == null) goto L19;
        r7 = r10.hashCode();
    L19:
        return r9 + r7;
    L13:
        r8 = r6.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "LikeBotState(showLikeButton=" + this.showLikeButton + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", botId=" + this.botId + ", knowLike=" + this.knowLike + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final Boolean getKnowLike() {
        return this.knowLike;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final boolean getShowLikeButton() {
        return this.showLikeButton;
    }

    public LikeBotState(boolean r1, boolean r2, long r3, String r5, Boolean r6) {
        this.showLikeButton = r1;
        this.liked = r2;
        this.likeCount = r3;
        this.botId = r5;
        this.knowLike = r6;
    }

    public /* synthetic */ LikeBotState(boolean r5, boolean r6, long r7, String r9, Boolean r10, int r11, DefaultConstructorMarker r12) {
        boolean r0 = false;
        if ((r11 & 1) == 0) goto L5;
        boolean r13 = false;
    L7:
        if ((r11 & 2) != 0) goto L11;
        r0 = r6;
    L11:
        if ((r11 & 4) == 0) goto L13;
        r7 = 0;
    L13:
        long r1 = r7;
        if ((r11 & 8) == 0) goto L16;
        r9 = null;
    L16:
        String r3 = r9;
        if ((r11 & 16) == 0) goto L19;
        r10 = Boolean.FALSE;
    L19:
        boolean r8 = r13;
        boolean r14 = r0;
        this(r8, r14, r1, r3, r10);
        return;
    L5:
        r13 = r5;
        goto L7
    }
}
