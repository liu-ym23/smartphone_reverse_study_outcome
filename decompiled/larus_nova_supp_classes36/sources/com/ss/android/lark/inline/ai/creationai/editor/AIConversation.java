package com.ss.android.lark.inline.ai.creationai.editor;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/AIConversation;", "Ljava/io/Serializable;", "<init>", "()V", "conversationId", "", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "taskId", "getTaskId", "setTaskId", "contentHeight", "", "getContentHeight", "()Ljava/lang/Integer;", "setContentHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AIConversation implements Serializable {
    private Integer contentHeight;
    private String conversationId;
    private String taskId;

    public AIConversation() {
    }

    public String toString() {
        return "AIConversation(conversationId='" + this.conversationId + "', taskId='" + this.taskId + "', contentHeight = " + this.contentHeight + ')';
    }

    public final Integer getContentHeight() {
        return this.contentHeight;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setContentHeight(Integer r1) {
        this.contentHeight = r1;
    }

    public final void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }
}
