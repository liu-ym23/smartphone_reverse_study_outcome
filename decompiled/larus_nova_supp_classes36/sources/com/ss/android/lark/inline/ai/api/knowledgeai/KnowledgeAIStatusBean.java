package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIStatusBean;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIStatus;", "unreadCount", "", "enable", "", "isWriting", "<init>", "(IZZ)V", "getUnreadCount", "()I", "getEnable", "()Z", "component1", "component2", "component3", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KnowledgeAIStatusBean implements IKnowledgeAIStatus {
    private final boolean enable;
    private final boolean isWriting;
    private final int unreadCount;

    public static /* synthetic */ KnowledgeAIStatusBean copy$default(KnowledgeAIStatusBean r0, int r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.unreadCount;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enable;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isWriting;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.unreadCount;
    }

    public final boolean component2() {
        return this.enable;
    }

    public final boolean component3() {
        return this.isWriting;
    }

    public final KnowledgeAIStatusBean copy(int r2, boolean r3, boolean r4) {
        return new KnowledgeAIStatusBean(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KnowledgeAIStatusBean) == true) goto L8;
        return false;
    L8:
        KnowledgeAIStatusBean r6 = (KnowledgeAIStatusBean) r5;
        if (this.unreadCount == r6.unreadCount) goto L12;
        return false;
    L12:
        if (this.enable == r6.enable) goto L15;
        return false;
    L15:
        if (this.isWriting == r6.isWriting) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.unreadCount * 31;
        int r2 = 1231;
        if (this.enable == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isWriting == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "KnowledgeAIStatusBean(unreadCount=" + this.unreadCount + ", enable=" + this.enable + ", isWriting=" + this.isWriting + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIStatus
    public boolean getEnable() {
        return this.enable;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIStatus
    public int getUnreadCount() {
        return this.unreadCount;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIStatus
    public boolean isWriting() {
        return this.isWriting;
    }

    public KnowledgeAIStatusBean(int r1, boolean r2, boolean r3) {
        this.unreadCount = r1;
        this.enable = r2;
        this.isWriting = r3;
    }
}
