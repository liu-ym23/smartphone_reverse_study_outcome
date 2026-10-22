package com.mammon.speechaudiosdk.kmp.param;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", NameKeys.UnloadStrategy_No_Strategy, "metaData", NameKeys.UnloadStrategy_No_Strategy, "deviceAiData", "audioDumpPath", "loudNormAlgoType", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMetaData", "()Ljava/lang/String;", "setMetaData", "(Ljava/lang/String;)V", "getDeviceAiData", "setDeviceAiData", "getAudioDumpPath", "setAudioDumpPath", "getLoudNormAlgoType", "()I", "setLoudNormAlgoType", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechAudioLoudnessStrategyParam {
    private String audioDumpPath;
    private String deviceAiData;
    private int loudNormAlgoType;
    private String metaData;

    public SpeechAudioLoudnessStrategyParam() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ SpeechAudioLoudnessStrategyParam copy$default(SpeechAudioLoudnessStrategyParam r0, String r1, String r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.metaData;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.deviceAiData;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.audioDumpPath;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.loudNormAlgoType;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.metaData;
    }

    public final String component2() {
        return this.deviceAiData;
    }

    public final String component3() {
        return this.audioDumpPath;
    }

    public final int component4() {
        return this.loudNormAlgoType;
    }

    public final SpeechAudioLoudnessStrategyParam copy(String r2, String r3, String r4, int r5) {
        return new SpeechAudioLoudnessStrategyParam(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpeechAudioLoudnessStrategyParam) == true) goto L8;
        return false;
    L8:
        SpeechAudioLoudnessStrategyParam r6 = (SpeechAudioLoudnessStrategyParam) r5;
        if (Intrinsics.areEqual(this.metaData, r6.metaData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceAiData, r6.deviceAiData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioDumpPath, r6.audioDumpPath) == true) goto L18;
        return false;
    L18:
        if (this.loudNormAlgoType == r6.loudNormAlgoType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.metaData;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.deviceAiData;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.audioDumpPath;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.loudNormAlgoType;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechAudioLoudnessStrategyParam(metaData=" + this.metaData + ", deviceAiData=" + this.deviceAiData + ", audioDumpPath=" + this.audioDumpPath + ", loudNormAlgoType=" + this.loudNormAlgoType + ')';
    }

    public final String getAudioDumpPath() {
        return this.audioDumpPath;
    }

    public final String getDeviceAiData() {
        return this.deviceAiData;
    }

    public final int getLoudNormAlgoType() {
        return this.loudNormAlgoType;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final void setAudioDumpPath(String r1) {
        this.audioDumpPath = r1;
    }

    public final void setDeviceAiData(String r1) {
        this.deviceAiData = r1;
    }

    public final void setLoudNormAlgoType(int r1) {
        this.loudNormAlgoType = r1;
    }

    public final void setMetaData(String r1) {
        this.metaData = r1;
    }

    public SpeechAudioLoudnessStrategyParam(String r1, String r2, String r3, int r4) {
        this.metaData = r1;
        this.deviceAiData = r2;
        this.audioDumpPath = r3;
        this.loudNormAlgoType = r4;
    }

    public /* synthetic */ SpeechAudioLoudnessStrategyParam(String r2, String r3, String r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
