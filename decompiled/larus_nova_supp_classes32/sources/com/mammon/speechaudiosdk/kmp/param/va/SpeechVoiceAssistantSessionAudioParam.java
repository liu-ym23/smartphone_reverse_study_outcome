package com.mammon.speechaudiosdk.kmp.param.va;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAudioParam;", NameKeys.UnloadStrategy_No_Strategy, "taskId", NameKeys.UnloadStrategy_No_Strategy, "sessionId", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "dataSize", NameKeys.UnloadStrategy_No_Strategy, "refData", "refDataSize", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;[BJ[BJLjava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getSessionId", "getData", "()[B", "getDataSize", "()J", "getRefData", "getRefDataSize", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionAudioParam {
    private final byte[] data;
    private final long dataSize;
    private final String extra;
    private final byte[] refData;
    private final long refDataSize;
    private final String sessionId;
    private final String taskId;

    public static /* synthetic */ SpeechVoiceAssistantSessionAudioParam copy$default(SpeechVoiceAssistantSessionAudioParam r10, String r11, String r12, byte[] r13, long r14, byte[] r16, long r17, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.taskId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r2 = r10.sessionId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        byte[] r3 = r10.data;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r4 = r10.dataSize;
    L19:
        if ((r20 & 16) == 0) goto L21;
        byte[] r6 = r10.refData;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r7 = r10.refDataSize;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.extra;
    L31:
        return r10.copy(r1, r2, r3, r4, r6, r7, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final byte[] component3() {
        return this.data;
    }

    public final long component4() {
        return this.dataSize;
    }

    public final byte[] component5() {
        return this.refData;
    }

    public final long component6() {
        return this.refDataSize;
    }

    public final String component7() {
        return this.extra;
    }

    public final SpeechVoiceAssistantSessionAudioParam copy(String r12, String r13, byte[] r14, long r15, byte[] r17, long r18, String r20) {
        return new SpeechVoiceAssistantSessionAudioParam(r12, r13, r14, r15, r17, r18, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SpeechVoiceAssistantSessionAudioParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionAudioParam r9 = (SpeechVoiceAssistantSessionAudioParam) r8;
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r9.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r9.data) == true) goto L18;
        return false;
    L18:
        if (this.dataSize == r9.dataSize) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refData, r9.refData) == true) goto L24;
        return false;
    L24:
        if (this.refDataSize == r9.refDataSize) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sessionId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        byte[] r7 = this.data;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        long r10 = this.dataSize;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        byte[] r12 = this.refData;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        long r15 = this.refDataSize;
        int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        String r17 = this.extra;
        if (r17 == null) goto L23;
        r1 = r17.hashCode();
    L23:
        return r16 + r1;
    L17:
        r13 = Arrays.hashCode(r12);
        goto L18
    L13:
        r8 = Arrays.hashCode(r7);
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionAudioParam(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", data=" + Arrays.toString(this.data) + ", dataSize=" + this.dataSize + ", refData=" + Arrays.toString(this.refData) + ", refDataSize=" + this.refDataSize + ", extra=" + this.extra + ')';
    }

    public final byte[] getData() {
        return this.data;
    }

    public final long getDataSize() {
        return this.dataSize;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final byte[] getRefData() {
        return this.refData;
    }

    public final long getRefDataSize() {
        return this.refDataSize;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public SpeechVoiceAssistantSessionAudioParam(String r1, String r2, byte[] r3, long r4, byte[] r6, long r7, String r9) {
        this.taskId = r1;
        this.sessionId = r2;
        this.data = r3;
        this.dataSize = r4;
        this.refData = r6;
        this.refDataSize = r7;
        this.extra = r9;
    }
}
