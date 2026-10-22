package com.larus.bmhome.view.actionbar.segment.vm;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.comment.api.CommentHttpApi;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/vm/CommentBotState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "Ljava/io/Serializable;", "showCommentButton", "", "commentCount", "", "botId", "", "draft", "preloadData", "Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "<init>", "(ZJLjava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;)V", "getShowCommentButton", "()Z", "getCommentCount", "()J", "getBotId", "()Ljava/lang/String;", "getDraft", "getPreloadData", "()Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentBotState implements w1a.b, Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("comment_count")
    private final long commentCount;

    @SerializedName("draft")
    private final String draft;

    @SerializedName("preload_data")
    private final CommentHttpApi.GetCommentListData preloadData;

    @SerializedName("show_comment_button")
    private final boolean showCommentButton;

    public CommentBotState() {
        this(false, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ CommentBotState copy$default(CommentBotState r4, boolean r5, long r6, String r8, String r9, CommentHttpApi.GetCommentListData r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.showCommentButton;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.commentCount;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.botId;
    L11:
        String r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.draft;
    L14:
        String r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.preloadData;
    L17:
        boolean r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
    }

    public final boolean component1() {
        return this.showCommentButton;
    }

    public final long component2() {
        return this.commentCount;
    }

    public final String component3() {
        return this.botId;
    }

    public final String component4() {
        return this.draft;
    }

    public final CommentHttpApi.GetCommentListData component5() {
        return this.preloadData;
    }

    public final CommentBotState copy(boolean r9, long r10, String r12, String r13, CommentHttpApi.GetCommentListData r14) {
        return new CommentBotState(r9, r10, r12, r13, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CommentBotState) == true) goto L8;
        return false;
    L8:
        CommentBotState r9 = (CommentBotState) r8;
        if (this.showCommentButton == r9.showCommentButton) goto L12;
        return false;
    L12:
        if (this.commentCount == r9.commentCount) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.draft, r9.draft) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preloadData, r9.preloadData) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.showCommentButton == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.commentCount;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.botId;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.draft;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        CommentHttpApi.GetCommentListData r10 = this.preloadData;
        if (r10 == null) goto L19;
        r4 = r10.hashCode();
    L19:
        return r9 + r4;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CommentBotState(showCommentButton=" + this.showCommentButton + ", commentCount=" + this.commentCount + ", botId=" + this.botId + ", draft=" + this.draft + ", preloadData=" + this.preloadData + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final long getCommentCount() {
        return this.commentCount;
    }

    public final String getDraft() {
        return this.draft;
    }

    public final CommentHttpApi.GetCommentListData getPreloadData() {
        return this.preloadData;
    }

    public final boolean getShowCommentButton() {
        return this.showCommentButton;
    }

    public CommentBotState(boolean r1, long r2, String r4, String r5, CommentHttpApi.GetCommentListData r6) {
        this.showCommentButton = r1;
        this.commentCount = r2;
        this.botId = r4;
        this.draft = r5;
        this.preloadData = r6;
    }

    public /* synthetic */ CommentBotState(boolean r5, long r6, String r8, String r9, CommentHttpApi.GetCommentListData r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = 0;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        String r13 = null;
    L13:
        if ((r11 & 8) == 0) goto L15;
        String r2 = null;
    L17:
        if ((r11 & 16) == 0) goto L19;
        CommentHttpApi.GetCommentListData r3 = null;
    L20:
        this(r5, r0, r13, r2, r3);
        return;
    L19:
        r3 = r10;
        goto L20
    L15:
        r2 = r9;
        goto L17
    L11:
        r13 = r8;
        goto L13
    }
}
