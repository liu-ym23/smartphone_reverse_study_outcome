package com.ss.android.lark.inline.ai.creationai.editor;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0001 BQ\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/AIPreviewData;", "Ljava/io/Serializable;", "editor", "", "conversationId", "", "taskId", "theme", "bgColor", "status", "fontSize", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEditor", "()Ljava/lang/Object;", "setEditor", "(Ljava/lang/Object;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "getTheme", "setTheme", "getBgColor", "setBgColor", "getStatus", "setStatus", "getFontSize", "setFontSize", "toString", "Status", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AIPreviewData implements Serializable {
    private String bgColor;
    private String conversationId;
    private Object editor;
    private String fontSize;
    private String status;
    private String taskId;
    private String theme;

    public String toString() {
        return "AIPreviewData(editor=" + this.editor + ", conversationId=" + this.conversationId + ", taskId=" + this.taskId + ", theme=" + this.theme + ", bgColor=" + this.bgColor + ", status=" + this.status + ", fontSize=" + this.fontSize + ')';
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Object getEditor() {
        return this.editor;
    }

    public final String getFontSize() {
        return this.fontSize;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final void setBgColor(String r1) {
        this.bgColor = r1;
    }

    public final void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public final void setEditor(Object r1) {
        this.editor = r1;
    }

    public final void setFontSize(String r1) {
        this.fontSize = r1;
    }

    public final void setStatus(String r1) {
        this.status = r1;
    }

    public final void setTaskId(String r1) {
        this.taskId = r1;
    }

    public final void setTheme(String r1) {
        this.theme = r1;
    }

    public AIPreviewData(Object r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.editor = r1;
        this.conversationId = r2;
        this.taskId = r3;
        this.theme = r4;
        this.bgColor = r5;
        this.status = r6;
        this.fontSize = r7;
    }

    public /* synthetic */ AIPreviewData(Object r10, String r11, String r12, String r13, String r14, String r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        String r6 = null;
    L6:
        this(r10, r11, r12, r13, r6, r15, r16);
        return;
    L5:
        r6 = r14;
        goto L6
    }
}
