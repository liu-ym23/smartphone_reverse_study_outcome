package com.bytedance.ai.bridge.method.widget;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JI\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/method/widget/UpdateCardInstanceRequest;", "", "appKey", "", "cardInstanceId", "messageId", "widgetId", "widgetData", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAppKey", "()Ljava/lang/String;", "getCardInstanceId", "getMessageId", "getWidgetId", "getWidgetData", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("card_instance_id")
    private final String cardInstanceId;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("widget_data")
    private final String widgetData;

    @SerializedName("widget_id")
    private final String widgetId;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardInstanceId, r11.cardInstanceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.widgetData, r11.widgetData) == true) goto L24;
        return false;
    L24:
        if (this.timestamp == r11.timestamp) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.appKey.hashCode() * 31) + this.cardInstanceId.hashCode()) * 31;
        String r1 = this.messageId;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.widgetId;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        int r14 = (((r12 + r10) * 31) + this.widgetData.hashCode()) * 31;
        long r15 = this.timestamp;
        return r14 + ((int) (r15 ^ (r15 >>> 32)));
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateCardInstanceRequest(appKey=" + this.appKey + ", cardInstanceId=" + this.cardInstanceId + ", messageId=" + this.messageId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ", timestamp=" + this.timestamp + ')';
    }

    public a(String r10, String r11, String r12, String r13, String r14, long r15) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        Intrinsics.checkNotNullParameter(r11, "cardInstanceId");
        Intrinsics.checkNotNullParameter(r14, "widgetData");
        this.appKey = r10;
        this.cardInstanceId = r11;
        this.messageId = r12;
        this.widgetId = r13;
        this.widgetData = r14;
        this.timestamp = r15;
    }
}
