package com.bytedance.ai.widget.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/ai/widget/models/ConversationWidgetData;", "", "packageName", "", "widgetId", "messageId", "botId", "conversationId", "liteTemplateUrl", "widgetData", "appType", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getWidgetId", "setWidgetId", "(Ljava/lang/String;)V", "getMessageId", "getBotId", "getConversationId", "getLiteTemplateUrl", "getWidgetData", "getAppType", "getVersionTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationWidgetData {
    private final String appType;
    private final String botId;
    private final String conversationId;
    private final String liteTemplateUrl;
    private final String messageId;
    private final String packageName;
    private final String versionTag;
    private final String widgetData;
    private String widgetId;

    public static /* synthetic */ ConversationWidgetData copy$default(ConversationWidgetData r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r22 = r10.packageName;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r23 = r10.widgetId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r24 = r10.messageId;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r25 = r10.botId;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r26 = r10.conversationId;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r27 = r10.liteTemplateUrl;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r28 = r10.widgetData;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r29 = r10.appType;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.versionTag;
    L39:
        return r10.copy(r22, r23, r24, r25, r26, r27, r28, r29, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r29 = r18;
        goto L35
    L29:
        r28 = r17;
        goto L31
    L25:
        r27 = r16;
        goto L27
    L21:
        r26 = r15;
        goto L23
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r22 = r11;
        goto L7
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.botId;
    }

    public final String component5() {
        return this.conversationId;
    }

    public final String component6() {
        return this.liteTemplateUrl;
    }

    public final String component7() {
        return this.widgetData;
    }

    public final String component8() {
        return this.appType;
    }

    public final String component9() {
        return this.versionTag;
    }

    public final ConversationWidgetData copy(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Intrinsics.checkNotNullParameter(r13, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "messageId");
        Intrinsics.checkNotNullParameter(r15, "botId");
        Intrinsics.checkNotNullParameter(r16, "conversationId");
        return new ConversationWidgetData(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ConversationWidgetData) == true) goto L8;
        return false;
    L8:
        ConversationWidgetData r11 = (ConversationWidgetData) r10;
        if (Intrinsics.areEqual(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r11.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liteTemplateUrl, r11.liteTemplateUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.widgetData, r11.widgetData) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.appType, r11.appType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.versionTag, r11.versionTag) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.packageName.hashCode() * 31) + this.widgetId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.botId.hashCode()) * 31) + this.conversationId.hashCode()) * 31;
        String r1 = this.liteTemplateUrl;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.widgetData;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.appType;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.versionTag;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationWidgetData(packageName=" + this.packageName + ", widgetId=" + this.widgetId + ", messageId=" + this.messageId + ", botId=" + this.botId + ", conversationId=" + this.conversationId + ", liteTemplateUrl=" + this.liteTemplateUrl + ", widgetData=" + this.widgetData + ", appType=" + this.appType + ", versionTag=" + this.versionTag + ')';
    }

    public final String getAppType() {
        return this.appType;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getLiteTemplateUrl() {
        return this.liteTemplateUrl;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final void setWidgetId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.widgetId = r10;
    }

    public ConversationWidgetData(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "messageId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r14, "conversationId");
        this.packageName = r10;
        this.widgetId = r11;
        this.messageId = r12;
        this.botId = r13;
        this.conversationId = r14;
        this.liteTemplateUrl = r15;
        this.widgetData = r16;
        this.appType = r17;
        this.versionTag = r18;
    }

    public /* synthetic */ ConversationWidgetData(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 16) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r22 & 32) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r22 & 64) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r22 & 128) == 0) goto L17;
        String r110 = null;
    L19:
        if ((r22 & 256) == 0) goto L21;
        String r111 = null;
    L22:
        this(r13, r14, r15, r16, r10, r11, r12, r110, r111);
        return;
    L21:
        r111 = r21;
        goto L22
    L17:
        r110 = r20;
        goto L19
    L13:
        r12 = r19;
        goto L15
    L9:
        r11 = r18;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }
}
