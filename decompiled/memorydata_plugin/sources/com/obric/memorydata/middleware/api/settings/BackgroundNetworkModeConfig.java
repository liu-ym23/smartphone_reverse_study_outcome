package com.obric.memorydata.middleware.api.settings;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/BackgroundNetworkModeConfig;", "", "mode", "", "disconnectFrontier", "", "disablePreconnect", "clearPool", "strictGraceMs", "", "<init>", "(IZZZJ)V", "getMode", "()I", "getDisconnectFrontier", "()Z", "getDisablePreconnect", "getClearPool", "getStrictGraceMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackgroundNetworkModeConfig {

    @SerializedName("clear_pool")
    private final boolean clearPool;

    @SerializedName("disable_preconnect")
    private final boolean disablePreconnect;

    @SerializedName("disconnect_frontier")
    private final boolean disconnectFrontier;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("strict_grace_ms")
    private final long strictGraceMs;

    public BackgroundNetworkModeConfig() {
        this(0, false, false, false, 0, 31, null);
    }

    public BackgroundNetworkModeConfig(int r1, boolean r2, boolean r3, boolean r4, long r5) {
        this.mode = r1;
        this.disconnectFrontier = r2;
        this.disablePreconnect = r3;
        this.clearPool = r4;
        this.strictGraceMs = r5;
    }

    public /* synthetic */ BackgroundNetworkModeConfig(int r2, boolean r3, boolean r4, boolean r5, long r6, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = true;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = true;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r6 = 0;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ BackgroundNetworkModeConfig copy$default(BackgroundNetworkModeConfig r4, int r5, boolean r6, boolean r7, boolean r8, long r9, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.mode;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.disconnectFrontier;
    L8:
        boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.disablePreconnect;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.clearPool;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.strictGraceMs;
    L17:
        int r10 = r5;
        return r4.copy(r10, r13, r0, r1, r9);
    }

    public final int component1() {
        return this.mode;
    }

    public final boolean component2() {
        return this.disconnectFrontier;
    }

    public final boolean component3() {
        return this.disablePreconnect;
    }

    public final boolean component4() {
        return this.clearPool;
    }

    public final long component5() {
        return this.strictGraceMs;
    }

    public final BackgroundNetworkModeConfig copy(int r8, boolean r9, boolean r10, boolean r11, long r12) {
        return new BackgroundNetworkModeConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, BackgroundNetworkModeConfig.class) == true) goto L8;
        return false;
    L8:
        BackgroundNetworkModeConfig r8 = (BackgroundNetworkModeConfig) ZeusTransformUtils.preCheckCast(r7, BackgroundNetworkModeConfig.class, "com.obric.memorydata.plugin");
        if (this.mode == r8.mode) goto L12;
        return false;
    L12:
        if (this.disconnectFrontier == r8.disconnectFrontier) goto L15;
        return false;
    L15:
        if (this.disablePreconnect == r8.disablePreconnect) goto L18;
        return false;
    L18:
        if (this.clearPool == r8.clearPool) goto L21;
        return false;
    L21:
        if (this.strictGraceMs == r8.strictGraceMs) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean getClearPool() {
        return this.clearPool;
    }

    public final boolean getDisablePreconnect() {
        return this.disablePreconnect;
    }

    public final boolean getDisconnectFrontier() {
        return this.disconnectFrontier;
    }

    public final int getMode() {
        return this.mode;
    }

    public final long getStrictGraceMs() {
        return this.strictGraceMs;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.mode) * 31) + Boolean.hashCode(this.disconnectFrontier)) * 31) + Boolean.hashCode(this.disablePreconnect)) * 31) + Boolean.hashCode(this.clearPool)) * 31) + Long.hashCode(this.strictGraceMs);
    }

    public String toString() {
        return "BackgroundNetworkModeConfig(mode=" + this.mode + ", disconnectFrontier=" + this.disconnectFrontier + ", disablePreconnect=" + this.disablePreconnect + ", clearPool=" + this.clearPool + ", strictGraceMs=" + this.strictGraceMs + ')';
    }
}
