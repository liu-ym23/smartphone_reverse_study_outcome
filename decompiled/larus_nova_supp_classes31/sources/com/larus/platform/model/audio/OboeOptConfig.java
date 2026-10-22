package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/audio/OboeOptConfig;", "", "enableRecord", "", "enablePlay", "recordPerFramesPerCallback", "", "playPerFramesPerCallback", "enableLowLatency", "<init>", "(ZZIIZ)V", "getEnableRecord", "()Z", "getEnablePlay", "getRecordPerFramesPerCallback", "()I", "getPlayPerFramesPerCallback", "getEnableLowLatency", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OboeOptConfig {

    @SerializedName("enable_low_Latency")
    private final boolean enableLowLatency;

    @SerializedName("enable_play")
    private final boolean enablePlay;

    @SerializedName("enable_record")
    private final boolean enableRecord;

    @SerializedName("play_num_per_callback")
    private final int playPerFramesPerCallback;

    @SerializedName("record_num_per_callback")
    private final int recordPerFramesPerCallback;

    public OboeOptConfig() {
        this(false, false, 0, 0, false, 31, null);
    }

    public static /* synthetic */ OboeOptConfig copy$default(OboeOptConfig r3, boolean r4, boolean r5, int r6, int r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableRecord;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enablePlay;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.recordPerFramesPerCallback;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.playPerFramesPerCallback;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.enableLowLatency;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.enableRecord;
    }

    public final boolean component2() {
        return this.enablePlay;
    }

    public final int component3() {
        return this.recordPerFramesPerCallback;
    }

    public final int component4() {
        return this.playPerFramesPerCallback;
    }

    public final boolean component5() {
        return this.enableLowLatency;
    }

    public final OboeOptConfig copy(boolean r8, boolean r9, int r10, int r11, boolean r12) {
        return new OboeOptConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OboeOptConfig) == true) goto L8;
        return false;
    L8:
        OboeOptConfig r6 = (OboeOptConfig) r5;
        if (this.enableRecord == r6.enableRecord) goto L12;
        return false;
    L12:
        if (this.enablePlay == r6.enablePlay) goto L15;
        return false;
    L15:
        if (this.recordPerFramesPerCallback == r6.recordPerFramesPerCallback) goto L18;
        return false;
    L18:
        if (this.playPerFramesPerCallback == r6.playPerFramesPerCallback) goto L21;
        return false;
    L21:
        if (this.enableLowLatency == r6.enableLowLatency) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableRecord == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enablePlay == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((((r2 + r3) * 31) + this.recordPerFramesPerCallback) * 31) + this.playPerFramesPerCallback) * 31;
        if (this.enableLowLatency == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "OboeOptConfig(enableRecord=" + this.enableRecord + ", enablePlay=" + this.enablePlay + ", recordPerFramesPerCallback=" + this.recordPerFramesPerCallback + ", playPerFramesPerCallback=" + this.playPerFramesPerCallback + ", enableLowLatency=" + this.enableLowLatency + ')';
    }

    public final boolean getEnableLowLatency() {
        return this.enableLowLatency;
    }

    public final boolean getEnablePlay() {
        return this.enablePlay;
    }

    public final boolean getEnableRecord() {
        return this.enableRecord;
    }

    public final int getPlayPerFramesPerCallback() {
        return this.playPerFramesPerCallback;
    }

    public final int getRecordPerFramesPerCallback() {
        return this.recordPerFramesPerCallback;
    }

    public OboeOptConfig(boolean r1, boolean r2, int r3, int r4, boolean r5) {
        this.enableRecord = r1;
        this.enablePlay = r2;
        this.recordPerFramesPerCallback = r3;
        this.playPerFramesPerCallback = r4;
        this.enableLowLatency = r5;
    }

    public /* synthetic */ OboeOptConfig(boolean r5, boolean r6, int r7, int r8, boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        boolean r12 = false;
    L7:
        if ((r10 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r10 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r10 & 8) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r10 & 16) == 0) goto L21;
        boolean r13 = false;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
