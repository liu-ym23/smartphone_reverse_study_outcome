package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/UpdateWidgetMessageDataRequest;", "", "messageId", "", "mixtureCardId", "widgetId", "widgetData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getMixtureCardId", "getWidgetId", "getWidgetData", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("mixture_card_id")
    private final String mixtureCardId;

    @SerializedName("widget_data")
    private final String widgetData;

    @SerializedName("widget_id")
    private final String widgetId;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof s) == true) goto L8;
        return false;
    L8:
        s r11 = (s) r10;
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mixtureCardId, r11.mixtureCardId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.widgetData, r11.widgetData) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.messageId.hashCode() * 31) + this.mixtureCardId.hashCode()) * 31;
        String r1 = this.widgetId;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((r0 + r10) * 31) + this.widgetData.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "UpdateWidgetMessageDataRequest(messageId=" + this.messageId + ", mixtureCardId=" + this.mixtureCardId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ')';
    }

    public s(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter(r11, "mixtureCardId");
        Intrinsics.checkNotNullParameter(r13, "widgetData");
        this.messageId = r10;
        this.mixtureCardId = r11;
        this.widgetId = r12;
        this.widgetData = r13;
    }
}
