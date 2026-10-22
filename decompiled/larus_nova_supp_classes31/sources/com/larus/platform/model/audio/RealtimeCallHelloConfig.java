package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallHelloConfig;", "", "audioHello", "Lcom/larus/platform/model/audio/EventConfig;", "onlyEnableMainBot", "", "<init>", "(Lcom/larus/platform/model/audio/EventConfig;Z)V", "getAudioHello", "()Lcom/larus/platform/model/audio/EventConfig;", "getOnlyEnableMainBot", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RealtimeCallHelloConfig {

    @SerializedName("audio_realtime_call_hello")
    private final EventConfig audioHello;

    @SerializedName("only_enable_main_bot")
    private final boolean onlyEnableMainBot;

    public RealtimeCallHelloConfig() {
        EventConfig r2 = null;
        this(r2, false, 3, r2);
    }

    public static /* synthetic */ RealtimeCallHelloConfig copy$default(RealtimeCallHelloConfig r0, EventConfig r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.audioHello;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.onlyEnableMainBot;
    L9:
        return r0.copy(r1, r2);
    }

    public final EventConfig component1() {
        return this.audioHello;
    }

    public final boolean component2() {
        return this.onlyEnableMainBot;
    }

    public final RealtimeCallHelloConfig copy(EventConfig r2, boolean r3) {
        return new RealtimeCallHelloConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RealtimeCallHelloConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallHelloConfig r6 = (RealtimeCallHelloConfig) r5;
        if (Intrinsics.areEqual(this.audioHello, r6.audioHello) == true) goto L12;
        return false;
    L12:
        if (this.onlyEnableMainBot == r6.onlyEnableMainBot) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        EventConfig r0 = this.audioHello;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.onlyEnableMainBot == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RealtimeCallHelloConfig(audioHello=" + this.audioHello + ", onlyEnableMainBot=" + this.onlyEnableMainBot + ')';
    }

    public final EventConfig getAudioHello() {
        return this.audioHello;
    }

    public final boolean getOnlyEnableMainBot() {
        return this.onlyEnableMainBot;
    }

    public RealtimeCallHelloConfig(EventConfig r1, boolean r2) {
        this.audioHello = r1;
        this.onlyEnableMainBot = r2;
    }

    public /* synthetic */ RealtimeCallHelloConfig(EventConfig r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r4 = new EventConfig(false, 0.0f, 3, null);
    L6:
        if ((r6 & 2) == 0) goto L8;
        r5 = false;
    L8:
        this(r4, r5);
    }
}
