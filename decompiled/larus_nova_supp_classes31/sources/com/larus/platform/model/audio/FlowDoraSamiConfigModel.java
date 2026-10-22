package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/FlowDoraSamiConfigModel;", "", "reconnectInterval", "", "doraVisionReconnectInterval", "reconnectTimeout", "", "startSessionTimeout", "startSessionTimeoutEnable", "", "startSessionTimeoutOnRadio", "reconnectIntervalOnRadio", "<init>", "([I[IIIZI[I)V", "getReconnectInterval", "()[I", "getDoraVisionReconnectInterval", "getReconnectTimeout", "()I", "getStartSessionTimeout", "getStartSessionTimeoutEnable", "()Z", "getStartSessionTimeoutOnRadio", "getReconnectIntervalOnRadio", "hasVision", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FlowDoraSamiConfigModel {

    @SerializedName("reconnect_interval_on_vision")
    private final int[] doraVisionReconnectInterval;

    @SerializedName("reconnect_interval")
    private final int[] reconnectInterval;

    @SerializedName("reconnect_interval_on_radio")
    private final int[] reconnectIntervalOnRadio;

    @SerializedName("reconnect_timeout")
    private final int reconnectTimeout;

    @SerializedName("start_session_timeout")
    private final int startSessionTimeout;

    @SerializedName("start_session_timeout_enable")
    private final boolean startSessionTimeoutEnable;

    @SerializedName("start_session_timeout_on_radio")
    private final int startSessionTimeoutOnRadio;

    public FlowDoraSamiConfigModel() {
        this(null, null, 0, 0, false, 0, null, 127, null);
    }

    public final int[] getDoraVisionReconnectInterval() {
        return this.doraVisionReconnectInterval;
    }

    public final int[] getReconnectInterval() {
        return this.reconnectInterval;
    }

    public final int[] getReconnectIntervalOnRadio() {
        return this.reconnectIntervalOnRadio;
    }

    public final int getReconnectTimeout() {
        return this.reconnectTimeout;
    }

    public final int getStartSessionTimeout() {
        return this.startSessionTimeout;
    }

    public final boolean getStartSessionTimeoutEnable() {
        return this.startSessionTimeoutEnable;
    }

    public final int getStartSessionTimeoutOnRadio() {
        return this.startSessionTimeoutOnRadio;
    }

    public final int[] getReconnectInterval(boolean r1) {
        if (r1 == false) goto L5;
        return this.doraVisionReconnectInterval;
    L5:
        return this.reconnectInterval;
    }

    public FlowDoraSamiConfigModel(int[] r1, int[] r2, int r3, int r4, boolean r5, int r6, int[] r7) {
        this.reconnectInterval = r1;
        this.doraVisionReconnectInterval = r2;
        this.reconnectTimeout = r3;
        this.startSessionTimeout = r4;
        this.startSessionTimeoutEnable = r5;
        this.startSessionTimeoutOnRadio = r6;
        this.reconnectIntervalOnRadio = r7;
    }

    public /* synthetic */ FlowDoraSamiConfigModel(int[] r6, int[] r7, int r8, int r9, boolean r10, int r11, int[] r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = new int[]{100, 200, 400, 800, 1200, 3200};
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = new int[]{100, 200, 400, 800, 1200, 3200, 3200, 3200, 3200, 3200, 3200};
    L8:
        int[] r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        int r0 = 5000;
    L13:
        if ((r13 & 8) == 0) goto L15;
        int r1 = 15;
    L17:
        if ((r13 & 16) == 0) goto L19;
        boolean r2 = true;
    L21:
        if ((r13 & 32) == 0) goto L23;
        int r3 = 30;
    L25:
        if ((r13 & 64) == 0) goto L27;
        r12 = new int[]{100, 200, 400, 800, 1600, 3200, 6400, 6400, 6400, 6400, 6400, 6400, 6400, 6400, 6400};
    L27:
        int[] r4 = r12;
        this(r6, r15, r0, r1, r2, r3, r4);
        return;
    L23:
        r3 = r11;
        goto L25
    L19:
        r2 = r10;
        goto L21
    L15:
        r1 = r9;
        goto L17
    L11:
        r0 = r8;
        goto L13
    }
}
