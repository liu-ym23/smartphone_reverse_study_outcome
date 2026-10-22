package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J'\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ReEditInfo;", "Ljava/io/Serializable;", "messageId", "", "createTime", "", "showTitleEditor", "", "<init>", "(Ljava/lang/String;JZ)V", "getMessageId", "()Ljava/lang/String;", "getCreateTime", "()J", "setCreateTime", "(J)V", "getShowTitleEditor", "()Z", "setShowTitleEditor", "(Z)V", "continuousShowGuideTips", "getContinuousShowGuideTips", "setContinuousShowGuideTips", "fileAttachments", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "Lkotlin/collections/ArrayList;", "getFileAttachments", "()Ljava/util/ArrayList;", "setFileAttachments", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ReEditInfo implements Serializable {
    public static final a Companion = null;
    private boolean continuousShowGuideTips;
    private long createTime;
    private ArrayList<ChatAttachmentEntity> fileAttachments;
    private final String messageId;
    private boolean showTitleEditor;

    public static final class a implements n.a<ReEditInfo> {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ReEditInfo copy$default(ReEditInfo r0, String r1, long r2, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.messageId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.createTime;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.showTitleEditor;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.messageId;
    }

    public final long component2() {
        return this.createTime;
    }

    public final boolean component3() {
        return this.showTitleEditor;
    }

    public final ReEditInfo copy(String r2, long r3, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return new ReEditInfo(r2, r3, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ReEditInfo) == true) goto L8;
        return false;
    L8:
        ReEditInfo r9 = (ReEditInfo) r8;
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r9.createTime) goto L15;
        return false;
    L15:
        if (this.showTitleEditor == r9.showTitleEditor) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.messageId.hashCode() * 31;
        long r1 = this.createTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.showTitleEditor == false) goto L5;
        int r3 = 1231;
    L7:
        return r2 + r3;
    L5:
        r3 = 1237;
        goto L7
    }

    public String toString() {
        return "ReEditInfo(messageId=" + this.messageId + ", createTime=" + this.createTime + ", showTitleEditor=" + this.showTitleEditor + ')';
    }

    public final boolean getContinuousShowGuideTips() {
        return this.continuousShowGuideTips;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final ArrayList<ChatAttachmentEntity> getFileAttachments() {
        return this.fileAttachments;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final boolean getShowTitleEditor() {
        return this.showTitleEditor;
    }

    public final void setContinuousShowGuideTips(boolean r1) {
        this.continuousShowGuideTips = r1;
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setFileAttachments(ArrayList<ChatAttachmentEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileAttachments = r2;
    }

    public final void setShowTitleEditor(boolean r1) {
        this.showTitleEditor = r1;
    }

    public ReEditInfo(String r2, long r3, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.messageId = r2;
        this.createTime = r3;
        this.showTitleEditor = r5;
        this.fileAttachments = new ArrayList();
    }

    public /* synthetic */ ReEditInfo(String r1, long r2, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = true;
    L8:
        this(r1, r2, r4);
    }
}
