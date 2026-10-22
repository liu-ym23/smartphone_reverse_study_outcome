package com.obric.memory.datacollect.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003Jw\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\nHÖ\u0001J\t\u0010G\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006H"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/ChatData;", "Ljava/io/Serializable;", "timestamp", "", "chatType", "Lcom/obric/memory/datacollect/kotlin/ChatType;", "chatName", "", "msgPerson", "chatPeopleNum", "", "msgContent", "msgType", "Lcom/obric/memory/datacollect/kotlin/MsgType;", "refPerson", "refSource", "audioToText", "timeAccuracy", "Lcom/obric/memory/datacollect/kotlin/TimeAccuracy;", "(JLcom/obric/memory/datacollect/kotlin/ChatType;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/obric/memory/datacollect/kotlin/MsgType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memory/datacollect/kotlin/TimeAccuracy;)V", "getAudioToText", "()Ljava/lang/String;", "setAudioToText", "(Ljava/lang/String;)V", "getChatName", "setChatName", "getChatPeopleNum", "()I", "setChatPeopleNum", "(I)V", "getChatType", "()Lcom/obric/memory/datacollect/kotlin/ChatType;", "setChatType", "(Lcom/obric/memory/datacollect/kotlin/ChatType;)V", "getMsgContent", "setMsgContent", "getMsgPerson", "setMsgPerson", "getMsgType", "()Lcom/obric/memory/datacollect/kotlin/MsgType;", "setMsgType", "(Lcom/obric/memory/datacollect/kotlin/MsgType;)V", "getRefPerson", "setRefPerson", "getRefSource", "setRefSource", "getTimeAccuracy", "()Lcom/obric/memory/datacollect/kotlin/TimeAccuracy;", "setTimeAccuracy", "(Lcom/obric/memory/datacollect/kotlin/TimeAccuracy;)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class ChatData implements Serializable {

    @SerializedName("audioToText")
    private String audioToText;

    @SerializedName("chatName")
    private String chatName;

    @SerializedName("chatPeopleNum")
    private int chatPeopleNum;

    @SerializedName("chatType")
    private ChatType chatType;

    @SerializedName("msgContent")
    private String msgContent;

    @SerializedName("msgPerson")
    private String msgPerson;

    @SerializedName("msgType")
    private MsgType msgType;

    @SerializedName("refPerson")
    private String refPerson;

    @SerializedName("refSource")
    private String refSource;

    @SerializedName("timeAccuracy")
    private TimeAccuracy timeAccuracy;

    @SerializedName("timestamp")
    private long timestamp;

    public ChatData(long r2, ChatType r4, String r5, String r6, int r7, String r8, MsgType r9, String r10, String r11, String r12, TimeAccuracy r13) {
        Intrinsics.checkParameterIsNotNull(r4, "chatType");
        Intrinsics.checkParameterIsNotNull(r5, "chatName");
        Intrinsics.checkParameterIsNotNull(r6, "msgPerson");
        Intrinsics.checkParameterIsNotNull(r8, "msgContent");
        Intrinsics.checkParameterIsNotNull(r9, "msgType");
        Intrinsics.checkParameterIsNotNull(r10, "refPerson");
        Intrinsics.checkParameterIsNotNull(r11, "refSource");
        Intrinsics.checkParameterIsNotNull(r12, "audioToText");
        Intrinsics.checkParameterIsNotNull(r13, "timeAccuracy");
        this.timestamp = r2;
        this.chatType = r4;
        this.chatName = r5;
        this.msgPerson = r6;
        this.chatPeopleNum = r7;
        this.msgContent = r8;
        this.msgType = r9;
        this.refPerson = r10;
        this.refSource = r11;
        this.audioToText = r12;
        this.timeAccuracy = r13;
    }

    public static /* synthetic */ ChatData copy$default(ChatData r13, long r14, ChatType r16, String r17, String r18, int r19, String r20, MsgType r21, String r22, String r23, String r24, TimeAccuracy r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r2 = r13.timestamp;
    L7:
        if ((r26 & 2) == 0) goto L9;
        ChatType r4 = r13.chatType;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r5 = r13.chatName;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r6 = r13.msgPerson;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r7 = r13.chatPeopleNum;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r8 = r13.msgContent;
    L27:
        if ((r26 & 64) == 0) goto L29;
        MsgType r9 = r13.msgType;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r10 = r13.refPerson;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r11 = r13.refSource;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r12 = r13.audioToText;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        TimeAccuracy r1 = r13.timeAccuracy;
    L47:
        return r13.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L45:
        r1 = r25;
        goto L47
    L41:
        r12 = r24;
        goto L43
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final long component1() {
        return this.timestamp;
    }

    public final String component10() {
        return this.audioToText;
    }

    public final TimeAccuracy component11() {
        return this.timeAccuracy;
    }

    public final ChatType component2() {
        return this.chatType;
    }

    public final String component3() {
        return this.chatName;
    }

    public final String component4() {
        return this.msgPerson;
    }

    public final int component5() {
        return this.chatPeopleNum;
    }

    public final String component6() {
        return this.msgContent;
    }

    public final MsgType component7() {
        return this.msgType;
    }

    public final String component8() {
        return this.refPerson;
    }

    public final String component9() {
        return this.refSource;
    }

    public final ChatData copy(long r15, ChatType r17, String r18, String r19, int r20, String r21, MsgType r22, String r23, String r24, String r25, TimeAccuracy r26) {
        Intrinsics.checkParameterIsNotNull(r17, "chatType");
        Intrinsics.checkParameterIsNotNull(r18, "chatName");
        Intrinsics.checkParameterIsNotNull(r19, "msgPerson");
        Intrinsics.checkParameterIsNotNull(r21, "msgContent");
        Intrinsics.checkParameterIsNotNull(r22, "msgType");
        Intrinsics.checkParameterIsNotNull(r23, "refPerson");
        Intrinsics.checkParameterIsNotNull(r24, "refSource");
        Intrinsics.checkParameterIsNotNull(r25, "audioToText");
        Intrinsics.checkParameterIsNotNull(r26, "timeAccuracy");
        return new ChatData(r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ChatData.class) == false) goto L29;
        ChatData r6 = (ChatData) ZeusTransformUtils.preCheckCast(r5, ChatData.class, "com.obric.memorydata.plugin");
        if (this.timestamp == r6.timestamp) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.chatType, r6.chatType) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.chatName, r6.chatName) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.msgPerson, r6.msgPerson) == true) goto L15;
        return false;
    L15:
        if (this.chatPeopleNum == r6.chatPeopleNum) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.msgContent, r6.msgContent) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.msgType, r6.msgType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refPerson, r6.refPerson) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.refSource, r6.refSource) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.audioToText, r6.audioToText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeAccuracy, r6.timeAccuracy) == true) goto L44;
        return false;
    L44:
        return true;
    L29:
        return false;
    }

    public final String getAudioToText() {
        return this.audioToText;
    }

    public final String getChatName() {
        return this.chatName;
    }

    public final int getChatPeopleNum() {
        return this.chatPeopleNum;
    }

    public final ChatType getChatType() {
        return this.chatType;
    }

    public final String getMsgContent() {
        return this.msgContent;
    }

    public final String getMsgPerson() {
        return this.msgPerson;
    }

    public final MsgType getMsgType() {
        return this.msgType;
    }

    public final String getRefPerson() {
        return this.refPerson;
    }

    public final String getRefSource() {
        return this.refSource;
    }

    public final TimeAccuracy getTimeAccuracy() {
        return this.timeAccuracy;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.timestamp) * 31;
        ChatType r1 = this.chatType;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.chatName;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.msgPerson;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((r7 + r9) * 31) + Integer.hashCode(this.chatPeopleNum)) * 31;
        String r11 = this.msgContent;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        MsgType r14 = this.msgType;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.refPerson;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.refSource;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.audioToText;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        TimeAccuracy r26 = this.timeAccuracy;
        if (r26 == null) goto L38;
        r2 = r26.hashCode();
    L38:
        return r25 + r2;
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void setAudioToText(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.audioToText = r2;
    }

    public final void setChatName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.chatName = r2;
    }

    public final void setChatPeopleNum(int r1) {
        this.chatPeopleNum = r1;
    }

    public final void setChatType(ChatType r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.chatType = r2;
    }

    public final void setMsgContent(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.msgContent = r2;
    }

    public final void setMsgPerson(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.msgPerson = r2;
    }

    public final void setMsgType(MsgType r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.msgType = r2;
    }

    public final void setRefPerson(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.refPerson = r2;
    }

    public final void setRefSource(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.refSource = r2;
    }

    public final void setTimeAccuracy(TimeAccuracy r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.timeAccuracy = r2;
    }

    public final void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public String toString() {
        return "ChatData(timestamp=" + this.timestamp + ", chatType=" + this.chatType + ", chatName=" + this.chatName + ", msgPerson=" + this.msgPerson + ", chatPeopleNum=" + this.chatPeopleNum + ", msgContent=" + this.msgContent + ", msgType=" + this.msgType + ", refPerson=" + this.refPerson + ", refSource=" + this.refSource + ", audioToText=" + this.audioToText + ", timeAccuracy=" + this.timeAccuracy + ")";
    }
}
