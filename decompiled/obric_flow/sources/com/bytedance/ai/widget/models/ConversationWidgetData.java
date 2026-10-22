package com.bytedance.ai.widget.models;

import androidx.annotation.Keep;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003Jk\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ai/widget/models/ConversationWidgetData;", "", "packageName", "", "widgetId", "messageId", "botId", "conversationId", "liteTemplateUrl", "widgetData", "appType", "oAppletWrap", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/widget/models/OAppletWrap;)V", "getPackageName", "()Ljava/lang/String;", "getWidgetId", "getMessageId", "getBotId", "getConversationId", "getLiteTemplateUrl", "getWidgetData", "getAppType", "getOAppletWrap", "()Lcom/bytedance/ai/widget/models/OAppletWrap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConversationWidgetData {
    private final String appType;
    private final String botId;
    private final String conversationId;
    private final String liteTemplateUrl;
    private final String messageId;
    private final OAppletWrap oAppletWrap;
    private final String packageName;
    private final String widgetData;
    private final String widgetId;

    public ConversationWidgetData(String r5, String r10, String r11, String r12, String r13, String r14, String r15, String r16, OAppletWrap r17) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r12, "botId");
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        this.packageName = r5;
        this.widgetId = r10;
        this.messageId = r11;
        this.botId = r12;
        this.conversationId = r13;
        this.liteTemplateUrl = r14;
        this.widgetData = r15;
        this.appType = r16;
        this.oAppletWrap = r17;
    }

    public static /* synthetic */ ConversationWidgetData copy$default(ConversationWidgetData r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, OAppletWrap r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r5 = r10.packageName;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r22 = r10.widgetId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r23 = r10.messageId;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r24 = r10.botId;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r25 = r10.conversationId;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r26 = r10.liteTemplateUrl;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r27 = r10.widgetData;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r28 = r10.appType;
    L35:
        if ((r20 & 256) == 0) goto L37;
        OAppletWrap r29 = r10.oAppletWrap;
    L39:
        return r10.copy(r5, r22, r23, r24, r25, r26, r27, r28, r29);
    L37:
        r29 = r19;
        goto L39
    L33:
        r28 = r18;
        goto L35
    L29:
        r27 = r17;
        goto L31
    L25:
        r26 = r16;
        goto L27
    L21:
        r25 = r15;
        goto L23
    L17:
        r24 = r14;
        goto L19
    L13:
        r23 = r13;
        goto L15
    L9:
        r22 = r12;
        goto L11
    L5:
        r5 = r11;
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

    public final OAppletWrap component9() {
        return this.oAppletWrap;
    }

    public final ConversationWidgetData copy(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, OAppletWrap r20) {
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Intrinsics.checkNotNullParameter(r13, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "messageId");
        Intrinsics.checkNotNullParameter(r15, "botId");
        Intrinsics.checkNotNullParameter(r16, "conversationId");
        return new ConversationWidgetData(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ConversationWidgetData) == true) goto L8;
        return false;
    L8:
        ConversationWidgetData r10 = (ConversationWidgetData) r5;
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r10.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r10.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r10.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liteTemplateUrl, r10.liteTemplateUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.widgetData, r10.widgetData) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.appType, r10.appType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.oAppletWrap, r10.oAppletWrap) == true) goto L35;
        return false;
    L35:
        return true;
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

    public final OAppletWrap getOAppletWrap() {
        return this.oAppletWrap;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        int r5 = a.b(this.conversationId, a.b(this.botId, a.b(this.messageId, a.b(this.widgetId, this.packageName.hashCode() * 31, 31), 31), 31), 31);
        String r10 = this.liteTemplateUrl;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.widgetData;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.appType;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        OAppletWrap r20 = this.oAppletWrap;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationWidgetData(packageName=" + this.packageName + ", widgetId=" + this.widgetId + ", messageId=" + this.messageId + ", botId=" + this.botId + ", conversationId=" + this.conversationId + ", liteTemplateUrl=" + this.liteTemplateUrl + ", widgetData=" + this.widgetData + ", appType=" + this.appType + ", oAppletWrap=" + this.oAppletWrap + ')';
    }

    public /* synthetic */ ConversationWidgetData(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, OAppletWrap r21, int r22, DefaultConstructorMarker r23) {
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
        OAppletWrap r111 = null;
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
