package com.mammon.speechaudiosdk.kmp.param;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014¨\u0006 "}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", NameKeys.UnloadStrategy_No_Strategy, "format", NameKeys.UnloadStrategy_No_Strategy, "sampleRate", NameKeys.UnloadStrategy_No_Strategy, "channel", "bitRate", "enableNetTransportCompress", NameKeys.UnloadStrategy_No_Strategy, "isPlanar", "<init>", "(Ljava/lang/String;IIIZZ)V", "getFormat", "()Ljava/lang/String;", "getSampleRate", "()I", "getChannel", "getBitRate", "getEnableNetTransportCompress", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechAudioConfigParam {
    private final int bitRate;
    private final int channel;
    private final boolean enableNetTransportCompress;
    private final String format;
    private final boolean isPlanar;
    private final int sampleRate;

    public SpeechAudioConfigParam() {
        this(null, 0, 0, 0, false, false, 63, null);
    }

    public static /* synthetic */ SpeechAudioConfigParam copy$default(SpeechAudioConfigParam r4, String r5, int r6, int r7, int r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.format;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.sampleRate;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.channel;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.bitRate;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.enableNetTransportCompress;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.isPlanar;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.format;
    }

    public final int component2() {
        return this.sampleRate;
    }

    public final int component3() {
        return this.channel;
    }

    public final int component4() {
        return this.bitRate;
    }

    public final boolean component5() {
        return this.enableNetTransportCompress;
    }

    public final boolean component6() {
        return this.isPlanar;
    }

    public final SpeechAudioConfigParam copy(String r9, int r10, int r11, int r12, boolean r13, boolean r14) {
        return new SpeechAudioConfigParam(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpeechAudioConfigParam) == true) goto L8;
        return false;
    L8:
        SpeechAudioConfigParam r6 = (SpeechAudioConfigParam) r5;
        if (Intrinsics.areEqual(this.format, r6.format) == true) goto L12;
        return false;
    L12:
        if (this.sampleRate == r6.sampleRate) goto L15;
        return false;
    L15:
        if (this.channel == r6.channel) goto L18;
        return false;
    L18:
        if (this.bitRate == r6.bitRate) goto L21;
        return false;
    L21:
        if (this.enableNetTransportCompress == r6.enableNetTransportCompress) goto L24;
        return false;
    L24:
        if (this.isPlanar == r6.isPlanar) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.format;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((((r1 * 31) + this.sampleRate) * 31) + this.channel) * 31) + this.bitRate) * 31;
        int r3 = 1231;
        if (this.enableNetTransportCompress == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.isPlanar == true) goto L15;
        r3 = 1237;
    L15:
        return r5 + r3;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechAudioConfigParam(format=" + this.format + ", sampleRate=" + this.sampleRate + ", channel=" + this.channel + ", bitRate=" + this.bitRate + ", enableNetTransportCompress=" + this.enableNetTransportCompress + ", isPlanar=" + this.isPlanar + ')';
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final boolean getEnableNetTransportCompress() {
        return this.enableNetTransportCompress;
    }

    public final String getFormat() {
        return this.format;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final boolean isPlanar() {
        return this.isPlanar;
    }

    public SpeechAudioConfigParam(String r1, int r2, int r3, int r4, boolean r5, boolean r6) {
        this.format = r1;
        this.sampleRate = r2;
        this.channel = r3;
        this.bitRate = r4;
        this.enableNetTransportCompress = r5;
        this.isPlanar = r6;
    }

    public /* synthetic */ SpeechAudioConfigParam(String r5, int r6, int r7, int r8, boolean r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = null;
    L5:
        boolean r0 = false;
        if ((r11 & 2) == 0) goto L8;
        int r13 = 0;
    L10:
        if ((r11 & 4) == 0) goto L12;
        int r1 = 0;
    L14:
        if ((r11 & 8) == 0) goto L16;
        int r2 = 0;
    L18:
        if ((r11 & 16) == 0) goto L20;
        boolean r3 = false;
    L22:
        if ((r11 & 32) != 0) goto L25;
        r0 = r10;
    L25:
        this(r5, r13, r1, r2, r3, r0);
        return;
    L20:
        r3 = r9;
        goto L22
    L16:
        r2 = r8;
        goto L18
    L12:
        r1 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L10
    }
}
