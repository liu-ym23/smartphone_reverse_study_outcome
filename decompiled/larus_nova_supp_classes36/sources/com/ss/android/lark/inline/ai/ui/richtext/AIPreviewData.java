package com.ss.android.lark.inline.ai.ui.richtext;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u00010B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010!\u001a\u00020\u0003H\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010#\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0087\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0016¨\u00061"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/AIPreviewData;", "Ljava/io/Serializable;", "content", "", "contentExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "conversationId", "taskId", "theme", "bgColor", "status", "fontSize", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getContentExtra", "()Ljava/util/HashMap;", "getConversationId", "setConversationId", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "getTheme", "setTheme", "getBgColor", "setBgColor", "getStatus", "setStatus", "getFontSize", "setFontSize", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "Status", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AIPreviewData implements Serializable {
    private String bgColor;
    private final String content;
    private final HashMap<String, Object> contentExtra;
    private String conversationId;
    private String fontSize;
    private String status;
    private String taskId;
    private String theme;

    public AIPreviewData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPreviewData copy$default(AIPreviewData r9, String r10, HashMap r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.content;
    L7:
        if ((r18 & 2) == 0) goto L9;
        HashMap r3 = r9.contentExtra;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.conversationId;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.taskId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.theme;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.bgColor;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.status;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.fontSize;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.content;
    }

    public final HashMap<String, Object> component2() {
        return this.contentExtra;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.theme;
    }

    public final String component6() {
        return this.bgColor;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.fontSize;
    }

    public final AIPreviewData copy(String r11, HashMap<String, Object> r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        return new AIPreviewData(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPreviewData) == true) goto L8;
        return false;
    L8:
        AIPreviewData r6 = (AIPreviewData) r5;
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contentExtra, r6.contentExtra) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.theme, r6.theme) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bgColor, r6.bgColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fontSize, r6.fontSize) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HashMap<String, Object> r4 = this.contentExtra;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.conversationId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.taskId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.theme;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.bgColor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.status;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.fontSize;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AIPreviewData(content length=");
        String r1 = this.content;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", conversationId=");
        r0.append(this.conversationId);
        r0.append(", taskId=");
        r0.append(this.taskId);
        r0.append(", theme=");
        r0.append(this.theme);
        r0.append(", bgColor=");
        r0.append(this.bgColor);
        r0.append(", status=");
        r0.append(this.status);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getContent() {
        return this.content;
    }

    public final HashMap<String, Object> getContentExtra() {
        return this.contentExtra;
    }

    public final String getConversationId() {
        return this.conversationId;
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

    public AIPreviewData(String r1, HashMap<String, Object> r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        this.content = r1;
        this.contentExtra = r2;
        this.conversationId = r3;
        this.taskId = r4;
        this.theme = r5;
        this.bgColor = r6;
        this.status = r7;
        this.fontSize = r8;
    }

    public /* synthetic */ AIPreviewData(String r10, HashMap r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        HashMap r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
