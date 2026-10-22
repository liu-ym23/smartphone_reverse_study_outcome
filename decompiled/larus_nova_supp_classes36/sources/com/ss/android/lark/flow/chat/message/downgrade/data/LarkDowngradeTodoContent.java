package com.ss.android.lark.flow.chat.message.downgrade.data;

import com.bytedance.lark.pb.basic.v1.TodoOperationContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010 \u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014¨\u0006)"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/downgrade/data/LarkDowngradeTodoContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "operationType", "Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent$Type;", "getOperationType", "()Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent$Type;", "setOperationType", "(Lcom/bytedance/lark/pb/basic/v1/TodoOperationContent$Type;)V", "isCompleted", "", "()Z", "setCompleted", "(Z)V", "assigneeName", "getAssigneeName", "setAssigneeName", "dueTimeSeconds", "", "getDueTimeSeconds", "()J", "setDueTimeSeconds", "(J)V", "isAllDay", "setAllDay", "hasReminder", "getHasReminder", "setHasReminder", "canFollow", "getCanFollow", "setCanFollow", "isContentSame", "diffable", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkDowngradeTodoContent extends Content {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String assigneeName;
    private boolean canFollow;
    private long dueTimeSeconds;
    private boolean hasReminder;
    private boolean isAllDay;
    private boolean isCompleted;
    private TodoOperationContent.Type operationType;
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public LarkDowngradeTodoContent() {
        this.title = "";
        this.operationType = TodoOperationContent.Type.UNKNOWN;
        this.assigneeName = "";
    }

    public final String getAssigneeName() {
        return this.assigneeName;
    }

    public final boolean getCanFollow() {
        return this.canFollow;
    }

    public final long getDueTimeSeconds() {
        return this.dueTimeSeconds;
    }

    public final boolean getHasReminder() {
        return this.hasReminder;
    }

    public final TodoOperationContent.Type getOperationType() {
        return this.operationType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isAllDay() {
        return this.isAllDay;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public boolean isContentSame(Content r6) {
        if ((r6 instanceof LarkDowngradeTodoContent) == false) goto L21;
        LarkDowngradeTodoContent r7 = (LarkDowngradeTodoContent) r6;
        if (Intrinsics.areEqual(this.title, r7.title) == false) goto L21;
        if (this.operationType != r7.operationType) goto L21;
        if (this.isCompleted != r7.isCompleted) goto L21;
        if (Intrinsics.areEqual(this.assigneeName, r7.assigneeName) == false) goto L21;
        if (this.dueTimeSeconds != r7.dueTimeSeconds) goto L21;
        if (this.isAllDay != r7.isAllDay) goto L21;
        if (this.hasReminder != r7.hasReminder) goto L21;
        if (this.canFollow != r7.canFollow) goto L21;
        return true;
    L21:
        return false;
    }

    public final void setAllDay(boolean r1) {
        this.isAllDay = r1;
    }

    public final void setAssigneeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.assigneeName = r2;
    }

    public final void setCanFollow(boolean r1) {
        this.canFollow = r1;
    }

    public final void setCompleted(boolean r1) {
        this.isCompleted = r1;
    }

    public final void setDueTimeSeconds(long r1) {
        this.dueTimeSeconds = r1;
    }

    public final void setHasReminder(boolean r1) {
        this.hasReminder = r1;
    }

    public final void setOperationType(TodoOperationContent.Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.operationType = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }
}
