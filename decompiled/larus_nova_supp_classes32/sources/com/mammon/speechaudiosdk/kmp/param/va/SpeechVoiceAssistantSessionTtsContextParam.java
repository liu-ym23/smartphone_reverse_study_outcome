package com.mammon.speechaudiosdk.kmp.param.va;

import com.mammon.speechaudiosdk.kmp.param.SpeechAudioConfigParam;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", NameKeys.UnloadStrategy_No_Strategy, "audioConfig", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "speaker", NameKeys.UnloadStrategy_No_Strategy, "extra", "internalParam", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudioConfig", "()Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "getSpeaker", "()Ljava/lang/String;", "getExtra", "getInternalParam", "component1", "component2", "component3", "component4", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionTtsContextParam {
    private final SpeechAudioConfigParam audioConfig;
    private final String extra;
    private final String internalParam;
    private final String speaker;

    public static /* synthetic */ SpeechVoiceAssistantSessionTtsContextParam copy$default(SpeechVoiceAssistantSessionTtsContextParam r0, SpeechAudioConfigParam r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.audioConfig;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.speaker;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.extra;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.internalParam;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final SpeechAudioConfigParam component1() {
        return this.audioConfig;
    }

    public final String component2() {
        return this.speaker;
    }

    public final String component3() {
        return this.extra;
    }

    public final String component4() {
        return this.internalParam;
    }

    public final SpeechVoiceAssistantSessionTtsContextParam copy(SpeechAudioConfigParam r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "audioConfig");
        return new SpeechVoiceAssistantSessionTtsContextParam(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpeechVoiceAssistantSessionTtsContextParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionTtsContextParam r6 = (SpeechVoiceAssistantSessionTtsContextParam) r5;
        if (Intrinsics.areEqual(this.audioConfig, r6.audioConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.speaker, r6.speaker) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.internalParam, r6.internalParam) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.audioConfig.hashCode() * 31;
        String r1 = this.speaker;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.extra;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.internalParam;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionTtsContextParam(audioConfig=" + this.audioConfig + ", speaker=" + this.speaker + ", extra=" + this.extra + ", internalParam=" + this.internalParam + ')';
    }

    public final SpeechAudioConfigParam getAudioConfig() {
        return this.audioConfig;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getInternalParam() {
        return this.internalParam;
    }

    public final String getSpeaker() {
        return this.speaker;
    }

    public SpeechVoiceAssistantSessionTtsContextParam(SpeechAudioConfigParam r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "audioConfig");
        this.audioConfig = r2;
        this.speaker = r3;
        this.extra = r4;
        this.internalParam = r5;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionTtsContextParam(SpeechAudioConfigParam r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
