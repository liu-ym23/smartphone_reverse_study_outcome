package yg;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lyg/c;", "", "", "app", "Ljava/lang/String;", "getApp", "()Ljava/lang/String;", "setApp", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", com.bytedance.android.ec.core.event.a.KEY_PLATFORM, "getPlatform", "setPlatform", "msgID", "getMsgID", "setMsgID", "Business", "getBusiness", "setBusiness", "msgType", "getMsgType", "setMsgType", "itemID", "getItemID", "setItemID", "bizMsgID", "getBizMsgID", "setBizMsgID", "", "action", "Ljava/lang/Integer;", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "", "payload", "Ljava/util/Map;", "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("Business")
    private String Business;

    @SerializedName("action")
    private Integer action;

    @SerializedName("app")
    private String app;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("bizMsgID")
    private String bizMsgID;

    @SerializedName("itemID")
    private String itemID;

    @SerializedName("msgID")
    private String msgID;

    @SerializedName("msgType")
    private String msgType;

    @SerializedName("payload")
    private Map<String, String> payload;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PLATFORM)
    private String platform;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L26;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.app, r11.app) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appVersion, r11.appVersion) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.platform, r11.platform) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgID, r11.msgID) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.Business, r11.Business) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.msgType, r11.msgType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemID, r11.itemID) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizMsgID, r11.bizMsgID) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.action, r11.action) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.payload, r11.payload) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r0 = this.app;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.appVersion;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.platform;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.msgID;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.Business;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.msgType;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.itemID;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.bizMsgID;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        Integer r33 = this.action;
        if (r33 == null) goto L37;
        int r34 = r33.hashCode();
    L38:
        int r35 = (r32 + r34) * 31;
        Map<String, String> r36 = this.payload;
        if (r36 == null) goto L42;
        r1 = r36.hashCode();
    L42:
        return r35 + r1;
    L37:
        r34 = 0;
        goto L38
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "SceneRecvMessage(app=" + this.app + ", appVersion=" + this.appVersion + ", platform=" + this.platform + ", msgID=" + this.msgID + ", Business=" + this.Business + ", msgType=" + this.msgType + ", itemID=" + this.itemID + ", bizMsgID=" + this.bizMsgID + ", action=" + this.action + ", payload=" + this.payload + ")";
    }

    public c(String r1, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Integer r17, Map<String, String> r18) {
        this.app = r1;
        this.appVersion = r10;
        this.platform = r11;
        this.msgID = r12;
        this.Business = r13;
        this.msgType = r14;
        this.itemID = r15;
        this.bizMsgID = r16;
        this.action = r17;
        this.payload = r18;
    }
}
