package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq9.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/AsrConfigData;", "", "zipConfig", "Lcom/larus/platform/model/audio/ZipConfigData;", "connectPoolStrategy", "Lcom/larus/platform/model/audio/AudioStrategy;", "<init>", "(Lcom/larus/platform/model/audio/ZipConfigData;Lcom/larus/platform/model/audio/AudioStrategy;)V", "getZipConfig", "()Lcom/larus/platform/model/audio/ZipConfigData;", "getConnectPoolStrategy", "()Lcom/larus/platform/model/audio/AudioStrategy;", "setConnectPoolStrategy", "(Lcom/larus/platform/model/audio/AudioStrategy;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AsrConfigData {

    @SerializedName("network_strategy")
    private AudioStrategy connectPoolStrategy;

    @SerializedName("zip_config")
    private final l0 zipConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public AsrConfigData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AsrConfigData copy$default(AsrConfigData r0, l0 r1, AudioStrategy r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.zipConfig;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.connectPoolStrategy;
    L9:
        return r0.copy(r1, r2);
    }

    public final l0 component1() {
        return this.zipConfig;
    }

    public final AudioStrategy component2() {
        return this.connectPoolStrategy;
    }

    public final AsrConfigData copy(l0 r2, AudioStrategy r3) {
        return new AsrConfigData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AsrConfigData) == true) goto L8;
        return false;
    L8:
        AsrConfigData r6 = (AsrConfigData) r5;
        if (Intrinsics.areEqual(this.zipConfig, r6.zipConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.connectPoolStrategy, r6.connectPoolStrategy) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        l0 r0 = this.zipConfig;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AudioStrategy r4 = this.connectPoolStrategy;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AsrConfigData(zipConfig=" + this.zipConfig + ", connectPoolStrategy=" + this.connectPoolStrategy + ')';
    }

    public final AudioStrategy getConnectPoolStrategy() {
        return this.connectPoolStrategy;
    }

    public final l0 getZipConfig() {
        return this.zipConfig;
    }

    public final void setConnectPoolStrategy(AudioStrategy r1) {
        this.connectPoolStrategy = r1;
    }

    public AsrConfigData(l0 r1, AudioStrategy r2) {
        this.zipConfig = r1;
        this.connectPoolStrategy = r2;
    }

    public /* synthetic */ AsrConfigData(l0 r2, AudioStrategy r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = new AudioStrategy(null, 1, null);
    L8:
        this(r2, r3);
    }
}
