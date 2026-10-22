package com.mammon.speechaudiosdk.kmp.param;

import com.lynx.tasm.eventreport.LynxEventReporter;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioNetConnectionStateType;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioNetConnectionEventParam;", NameKeys.UnloadStrategy_No_Strategy, "state", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;", LynxEventReporter.PROP_NAME_URL, NameKeys.UnloadStrategy_No_Strategy, "textMsg", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;Ljava/lang/String;Ljava/lang/String;)V", "getState", "()Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;", "getUrl", "()Ljava/lang/String;", "getTextMsg", "component1", "component2", "component3", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechAudioNetConnectionEventParam {
    private final SpeechAudioNetConnectionStateType state;
    private final String textMsg;
    private final String url;

    public SpeechAudioNetConnectionEventParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SpeechAudioNetConnectionEventParam copy$default(SpeechAudioNetConnectionEventParam r0, SpeechAudioNetConnectionStateType r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.url;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.textMsg;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final SpeechAudioNetConnectionStateType component1() {
        return this.state;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.textMsg;
    }

    public final SpeechAudioNetConnectionEventParam copy(SpeechAudioNetConnectionStateType r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return new SpeechAudioNetConnectionEventParam(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SpeechAudioNetConnectionEventParam) == true) goto L8;
        return false;
    L8:
        SpeechAudioNetConnectionEventParam r6 = (SpeechAudioNetConnectionEventParam) r5;
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textMsg, r6.textMsg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        String r1 = this.url;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.textMsg;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechAudioNetConnectionEventParam(state=" + this.state + ", url=" + this.url + ", textMsg=" + this.textMsg + ')';
    }

    public final SpeechAudioNetConnectionStateType getState() {
        return this.state;
    }

    public final String getTextMsg() {
        return this.textMsg;
    }

    public final String getUrl() {
        return this.url;
    }

    public SpeechAudioNetConnectionEventParam(SpeechAudioNetConnectionStateType r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.state = r2;
        this.url = r3;
        this.textMsg = r4;
    }

    public /* synthetic */ SpeechAudioNetConnectionEventParam(SpeechAudioNetConnectionStateType r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = SpeechAudioNetConnectionStateType.ConnectionStateConnectUnknown;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
