package com.ss.android.lark.flow.chat.message.downgrade.data;

import com.bytedance.lark.pb.basic.v1.VideoChatContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/downgrade/data/LarkDowngradeVideoChatContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "status", "Lcom/bytedance/lark/pb/basic/v1/VideoChatContent$MeetingCard$Status;", "getStatus", "()Lcom/bytedance/lark/pb/basic/v1/VideoChatContent$MeetingCard$Status;", "setStatus", "(Lcom/bytedance/lark/pb/basic/v1/VideoChatContent$MeetingCard$Status;)V", "startTimeMs", "", "getStartTimeMs", "()J", "setStartTimeMs", "(J)V", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "isContentSame", "", "diffable", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkDowngradeVideoChatContent extends Content {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private long endTimeMs;
    private long startTimeMs;
    private VideoChatContent.MeetingCard.Status status;
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public LarkDowngradeVideoChatContent() {
        this.title = "";
        this.status = VideoChatContent.MeetingCard.Status.UNKNOWN;
        this.startTimeMs = -1;
        this.endTimeMs = -1;
    }

    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final VideoChatContent.MeetingCard.Status getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public boolean isContentSame(Content r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LarkDowngradeVideoChatContent) == false) goto L8;
        LarkDowngradeVideoChatContent r9 = (LarkDowngradeVideoChatContent) r8;
    L10:
        if (r9 != null) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.title, r9.title) == true) goto L15;
    L21:
        return false;
    L15:
        if (this.status != r9.status) goto L21;
        if (this.startTimeMs != r9.startTimeMs) goto L21;
        if (this.endTimeMs != r9.endTimeMs) goto L21;
        return true;
    L8:
        r9 = null;
        goto L10
    }

    public final void setEndTimeMs(long r1) {
        this.endTimeMs = r1;
    }

    public final void setStartTimeMs(long r1) {
        this.startTimeMs = r1;
    }

    public final void setStatus(VideoChatContent.MeetingCard.Status r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.status = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }
}
