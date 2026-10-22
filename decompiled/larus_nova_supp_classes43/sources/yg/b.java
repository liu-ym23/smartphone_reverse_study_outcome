package yg;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lyg/b;", "", "", "msgID", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setMsgID", "(Ljava/lang/String;)V", "bizMsgID", "a", "setBizMsgID", "sceneType", "g", "setSceneType", "itemID", "e", "setItemID", "seqID", "getSeqID", "setSeqID", "contentType", "d", "setContentType", "contentFormat", "c", "setContentFormat", "content", "b", "setContent", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("bizMsgID")
    private String bizMsgID;

    @SerializedName("content")
    private String content;

    @SerializedName("contentFormat")
    private String contentFormat;

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("itemID")
    private String itemID;

    @SerializedName("msgID")
    private String msgID;

    @SerializedName("type")
    private String sceneType;

    @SerializedName("seqID")
    private String seqID;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L22;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.msgID, r11.msgID) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizMsgID, r11.bizMsgID) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sceneType, r11.sceneType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemID, r11.itemID) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.seqID, r11.seqID) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.contentType, r11.contentType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentFormat, r11.contentFormat) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.content, r11.content) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.msgID;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.bizMsgID;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.sceneType;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.itemID;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.seqID;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.contentType;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.contentFormat;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.content;
        if (r30 == null) goto L34;
        r1 = r30.hashCode();
    L34:
        return r29 + r1;
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
        return "SceneReceiveMessage(msgID=" + this.msgID + ", bizMsgID=" + this.bizMsgID + ", sceneType=" + this.sceneType + ", itemID=" + this.itemID + ", seqID=" + this.seqID + ", contentType=" + this.contentType + ", contentFormat=" + this.contentFormat + ", content=" + this.content + ")";
    }

    public b() {
        this.msgID = null;
        this.bizMsgID = null;
        this.sceneType = null;
        this.itemID = null;
        this.seqID = null;
        this.contentType = null;
        this.contentFormat = null;
        this.content = null;
    }

    public final String a() {
        return this.bizMsgID;
    }

    public final String b() {
        return this.content;
    }

    public final String c() {
        return this.contentFormat;
    }

    public final String d() {
        return this.contentType;
    }

    public final String e() {
        return this.itemID;
    }

    public final String f() {
        return this.msgID;
    }

    public final String g() {
        return this.sceneType;
    }
}
