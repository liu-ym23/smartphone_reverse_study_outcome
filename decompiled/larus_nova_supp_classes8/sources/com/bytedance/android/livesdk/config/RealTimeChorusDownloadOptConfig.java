package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JH\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR(\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/config/RealTimeChorusDownloadOptConfig;", "", "enableOptimize", "", "goodNetworkLevelList", "", "", "musicDuration", "useParallelStrategy", "dropNetworkCheck", "(Z[Ljava/lang/Integer;IZZ)V", "getDropNetworkCheck", "()Z", "setDropNetworkCheck", "(Z)V", "getEnableOptimize", "setEnableOptimize", "getGoodNetworkLevelList", "()[Ljava/lang/Integer;", "setGoodNetworkLevelList", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getMusicDuration", "()I", "setMusicDuration", "(I)V", "getUseParallelStrategy", "setUseParallelStrategy", "component1", "component2", "component3", "component4", "component5", "copy", "(Z[Ljava/lang/Integer;IZZ)Lcom/bytedance/android/livesdk/config/RealTimeChorusDownloadOptConfig;", "equals", "other", "hashCode", "toString", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusDownloadOptConfig {

    @SerializedName("drop_network_check")
    private boolean dropNetworkCheck;

    @SerializedName("enable_optimize")
    private boolean enableOptimize;

    @SerializedName("good_network_level_list")
    private Integer[] goodNetworkLevelList;

    @SerializedName("music_duration")
    private int musicDuration;

    @SerializedName("use_parallel_strategy")
    private boolean useParallelStrategy;

    public RealTimeChorusDownloadOptConfig() {
        this(false, null, 0, false, false, 31, null);
    }

    public static /* synthetic */ RealTimeChorusDownloadOptConfig copy$default(RealTimeChorusDownloadOptConfig r3, boolean r4, Integer[] r5, int r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableOptimize;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.goodNetworkLevelList;
    L8:
        Integer[] r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.musicDuration;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.useParallelStrategy;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.dropNetworkCheck;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.enableOptimize;
    }

    public final Integer[] component2() {
        return this.goodNetworkLevelList;
    }

    public final int component3() {
        return this.musicDuration;
    }

    public final boolean component4() {
        return this.useParallelStrategy;
    }

    public final boolean component5() {
        return this.dropNetworkCheck;
    }

    public final RealTimeChorusDownloadOptConfig copy(boolean r8, Integer[] r9, int r10, boolean r11, boolean r12) {
        return new RealTimeChorusDownloadOptConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RealTimeChorusDownloadOptConfig) == false) goto L16;
        RealTimeChorusDownloadOptConfig r4 = (RealTimeChorusDownloadOptConfig) r3;
        if (this.enableOptimize == r4.enableOptimize) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.goodNetworkLevelList, r4.goodNetworkLevelList) == true) goto L10;
        return false;
    L10:
        if (this.musicDuration == r4.musicDuration) goto L12;
        return false;
    L12:
        if (this.useParallelStrategy == r4.useParallelStrategy) goto L14;
        return false;
    L14:
        if (this.dropNetworkCheck == r4.dropNetworkCheck) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean r0 = this.enableOptimize;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        Integer[] r4 = this.goodNetworkLevelList;
        if (r4 == null) goto L8;
        int r5 = Arrays.hashCode(r4);
    L9:
        int r6 = (((r3 + r5) * 31) + this.musicDuration) * 31;
        boolean r7 = this.useParallelStrategy;
        ?? r8 = r7;
        if (r7 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.dropNetworkCheck;
        if (r10 == true) goto L17;
        r1 = r10;
    L17:
        return r9 + r1;
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "RealTimeChorusDownloadOptConfig(enableOptimize=" + this.enableOptimize + ", goodNetworkLevelList=" + Arrays.toString(this.goodNetworkLevelList) + ", musicDuration=" + this.musicDuration + ", useParallelStrategy=" + this.useParallelStrategy + ", dropNetworkCheck=" + this.dropNetworkCheck + ")";
    }

    public final boolean getDropNetworkCheck() {
        return this.dropNetworkCheck;
    }

    public final boolean getEnableOptimize() {
        return this.enableOptimize;
    }

    public final Integer[] getGoodNetworkLevelList() {
        return this.goodNetworkLevelList;
    }

    public final int getMusicDuration() {
        return this.musicDuration;
    }

    public final boolean getUseParallelStrategy() {
        return this.useParallelStrategy;
    }

    public final void setDropNetworkCheck(boolean r1) {
        this.dropNetworkCheck = r1;
    }

    public final void setEnableOptimize(boolean r1) {
        this.enableOptimize = r1;
    }

    public final void setGoodNetworkLevelList(Integer[] r1) {
        this.goodNetworkLevelList = r1;
    }

    public final void setMusicDuration(int r1) {
        this.musicDuration = r1;
    }

    public final void setUseParallelStrategy(boolean r1) {
        this.useParallelStrategy = r1;
    }

    public RealTimeChorusDownloadOptConfig(boolean r1, Integer[] r2, int r3, boolean r4, boolean r5) {
        this.enableOptimize = r1;
        this.goodNetworkLevelList = r2;
        this.musicDuration = r3;
        this.useParallelStrategy = r4;
        this.dropNetworkCheck = r5;
    }

    public /* synthetic */ RealTimeChorusDownloadOptConfig(boolean r5, Integer[] r6, int r7, boolean r8, boolean r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r6 = new Integer[]{0, 5, 6, 7, 8};
    L9:
        Integer[] r1 = r6;
        if ((r10 & 4) == 0) goto L12;
        int r2 = 350;
    L14:
        if ((r10 & 8) == 0) goto L16;
        boolean r3 = true;
    L18:
        if ((r10 & 16) == 0) goto L20;
        boolean r13 = true;
    L21:
        this(r12, r1, r2, r3, r13);
        return;
    L20:
        r13 = r9;
        goto L21
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L5:
        r12 = r5;
        goto L7
    }
}
