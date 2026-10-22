package com.mammon.speechaudiosdk.kmp.param.va;

import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J}\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionDownlinkEventParam;", NameKeys.UnloadStrategy_No_Strategy, "event", NameKeys.UnloadStrategy_No_Strategy, "statusCode", NameKeys.UnloadStrategy_No_Strategy, "statusText", "taskId", "sessionId", "messageId", "textMsg", "extra", "binaryData", NameKeys.UnloadStrategy_No_Strategy, "seqId", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BJ)V", "getEvent", "()Ljava/lang/String;", "getStatusCode", "()I", "getStatusText", "getTaskId", "getSessionId", "getMessageId", "getTextMsg", "getExtra", "getBinaryData", "()[B", "getSeqId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionDownlinkEventParam {
    private final byte[] binaryData;
    private final String event;
    private final String extra;
    private final String messageId;
    private final long seqId;
    private final String sessionId;
    private final int statusCode;
    private final String statusText;
    private final String taskId;
    private final String textMsg;

    public SpeechVoiceAssistantSessionDownlinkEventParam() {
        this(null, 0, null, null, null, null, null, null, null, 0, 1023, null);
    }

    public static /* synthetic */ SpeechVoiceAssistantSessionDownlinkEventParam copy$default(SpeechVoiceAssistantSessionDownlinkEventParam r13, String r14, int r15, String r16, String r17, String r18, String r19, String r20, String r21, byte[] r22, long r23, int r25, Object r26) {
        if ((r25 & 1) == 0) goto L5;
        String r2 = r13.event;
    L7:
        if ((r25 & 2) == 0) goto L9;
        int r3 = r13.statusCode;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r4 = r13.statusText;
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r5 = r13.taskId;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r6 = r13.sessionId;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r7 = r13.messageId;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r8 = r13.textMsg;
    L31:
        if ((r25 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r9 = r13.extra;
    L35:
        if ((r25 & 256) == 0) goto L37;
        byte[] r10 = r13.binaryData;
    L39:
        if ((r25 & 512) == 0) goto L41;
        long r11 = r13.seqId;
    L43:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.event;
    }

    public final long component10() {
        return this.seqId;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final String component3() {
        return this.statusText;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.sessionId;
    }

    public final String component6() {
        return this.messageId;
    }

    public final String component7() {
        return this.textMsg;
    }

    public final String component8() {
        return this.extra;
    }

    public final byte[] component9() {
        return this.binaryData;
    }

    public final SpeechVoiceAssistantSessionDownlinkEventParam copy(String r14, int r15, String r16, String r17, String r18, String r19, String r20, String r21, byte[] r22, long r23) {
        return new SpeechVoiceAssistantSessionDownlinkEventParam(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SpeechVoiceAssistantSessionDownlinkEventParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionDownlinkEventParam r9 = (SpeechVoiceAssistantSessionDownlinkEventParam) r8;
        if (Intrinsics.areEqual(this.event, r9.event) == true) goto L12;
        return false;
    L12:
        if (this.statusCode == r9.statusCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.statusText, r9.statusText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sessionId, r9.sessionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.textMsg, r9.textMsg) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.binaryData, r9.binaryData) == true) goto L36;
        return false;
    L36:
        if (this.seqId == r9.seqId) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.event;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.statusCode) * 31;
        String r4 = this.statusText;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.taskId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sessionId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.messageId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.textMsg;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.extra;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        byte[] r22 = this.binaryData;
        if (r22 == null) goto L34;
        r1 = Arrays.hashCode(r22);
    L34:
        int r23 = (r21 + r1) * 31;
        long r24 = this.seqId;
        return r23 + ((int) (r24 ^ (r24 >>> 32)));
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
        return "SpeechVoiceAssistantSessionDownlinkEventParam(event=" + this.event + ", statusCode=" + this.statusCode + ", statusText=" + this.statusText + ", taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", textMsg=" + this.textMsg + ", extra=" + this.extra + ", binaryData=" + Arrays.toString(this.binaryData) + ", seqId=" + this.seqId + ')';
    }

    public final byte[] getBinaryData() {
        return this.binaryData;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final long getSeqId() {
        return this.seqId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTextMsg() {
        return this.textMsg;
    }

    public SpeechVoiceAssistantSessionDownlinkEventParam(String r1, int r2, String r3, String r4, String r5, String r6, String r7, String r8, byte[] r9, long r10) {
        this.event = r1;
        this.statusCode = r2;
        this.statusText = r3;
        this.taskId = r4;
        this.sessionId = r5;
        this.messageId = r6;
        this.textMsg = r7;
        this.extra = r8;
        this.binaryData = r9;
        this.seqId = r10;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionDownlinkEventParam(String r13, int r14, String r15, String r16, String r17, String r18, String r19, String r20, byte[] r21, long r22, int r24, DefaultConstructorMarker r25) {
        byte[] r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r24 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & 256) != 0) goto L39;
        r2 = r21;
    L39:
        if ((r24 & 512) == 0) goto L41;
        long r10 = 0;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2, r10);
        return;
    L41:
        r10 = r22;
        goto L42
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
