package com.ss.android.lark.chameleon.api;

import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\b\u00101\u001a\u000202H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lcom/ss/android/lark/chameleon/api/OpenConfig;", "Ljava/io/Serializable;", "titlebarConfig", "Lcom/ss/android/lark/chameleon/api/TitlebarConfig;", "showLoading", BuildConfig.FLAVOR, "hideLoadingByJS", "statisticsByJS", "loadingTimeout", BuildConfig.FLAVOR, "isColdLaunch", "openTimestamp", "hitWebViewCache", "(Lcom/ss/android/lark/chameleon/api/TitlebarConfig;ZZZJZJZ)V", "getHideLoadingByJS", "()Z", "setHideLoadingByJS", "(Z)V", "getHitWebViewCache", "setHitWebViewCache", "setColdLaunch", "getLoadingTimeout", "()J", "setLoadingTimeout", "(J)V", "getOpenTimestamp", "setOpenTimestamp", "getShowLoading", "setShowLoading", "getStatisticsByJS", "setStatisticsByJS", "getTitlebarConfig", "()Lcom/ss/android/lark/chameleon/api/TitlebarConfig;", "setTitlebarConfig", "(Lcom/ss/android/lark/chameleon/api/TitlebarConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OpenConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_LOADING_TIMEOUT = 10000;
    private boolean hideLoadingByJS;
    private boolean hitWebViewCache;
    private boolean isColdLaunch;
    private long loadingTimeout;
    private long openTimestamp;
    private boolean showLoading;
    private boolean statisticsByJS;
    private TitlebarConfig titlebarConfig;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/OpenConfig$Companion;", BuildConfig.FLAVOR, "()V", "DEFAULT_LOADING_TIMEOUT", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OpenConfig() {
        this(null, false, false, false, 0, false, 0, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    public static /* synthetic */ OpenConfig copy$default(OpenConfig r11, TitlebarConfig r12, boolean r13, boolean r14, boolean r15, long r16, boolean r18, long r19, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        TitlebarConfig r2 = r11.titlebarConfig;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r3 = r11.showLoading;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = r11.hideLoadingByJS;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = r11.statisticsByJS;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r6 = r11.loadingTimeout;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r8 = r11.isColdLaunch;
    L27:
        if ((r22 & 64) == 0) goto L29;
        long r9 = r11.openTimestamp;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r1 = r11.hitWebViewCache;
    L35:
        return r11.copy(r2, r3, r4, r5, r6, r8, r9, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final TitlebarConfig component1() {
        return this.titlebarConfig;
    }

    public final boolean component2() {
        return this.showLoading;
    }

    public final boolean component3() {
        return this.hideLoadingByJS;
    }

    public final boolean component4() {
        return this.statisticsByJS;
    }

    public final long component5() {
        return this.loadingTimeout;
    }

    public final boolean component6() {
        return this.isColdLaunch;
    }

    public final long component7() {
        return this.openTimestamp;
    }

    public final boolean component8() {
        return this.hitWebViewCache;
    }

    public final OpenConfig copy(TitlebarConfig r13, boolean r14, boolean r15, boolean r16, long r17, boolean r19, long r20, boolean r22) {
        Intrinsics.checkNotNullParameter(r13, "titlebarConfig");
        return new OpenConfig(r13, r14, r15, r16, r17, r19, r20, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OpenConfig) == true) goto L8;
        return false;
    L8:
        OpenConfig r9 = (OpenConfig) r8;
        if (Intrinsics.areEqual(this.titlebarConfig, r9.titlebarConfig) == true) goto L12;
        return false;
    L12:
        if (this.showLoading == r9.showLoading) goto L15;
        return false;
    L15:
        if (this.hideLoadingByJS == r9.hideLoadingByJS) goto L18;
        return false;
    L18:
        if (this.statisticsByJS == r9.statisticsByJS) goto L21;
        return false;
    L21:
        if (this.loadingTimeout == r9.loadingTimeout) goto L24;
        return false;
    L24:
        if (this.isColdLaunch == r9.isColdLaunch) goto L27;
        return false;
    L27:
        if (this.openTimestamp == r9.openTimestamp) goto L30;
        return false;
    L30:
        if (this.hitWebViewCache == r9.hitWebViewCache) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public int hashCode() {
        int r0 = this.titlebarConfig.hashCode() * 31;
        boolean r1 = this.showLoading;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.hideLoadingByJS;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.statisticsByJS;
        ?? r9 = r8;
        if (r8 == false) goto L11;
        r9 = 1;
    L11:
        long r10 = this.loadingTimeout;
        int r11 = (((r7 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        boolean r12 = this.isColdLaunch;
        ?? r13 = r12;
        if (r12 == false) goto L14;
        r13 = 1;
    L14:
        int r14 = (r11 + r13) * 31;
        long r15 = this.openTimestamp;
        int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        boolean r17 = this.hitWebViewCache;
        if (r17 == true) goto L19;
        r2 = r17;
    L19:
        return r16 + r2;
    }

    public String toString() {
        return "OpenConfig(titlebarConfig=" + this.titlebarConfig + ", showLoading=" + this.showLoading + ", hideLoadingByJS=" + this.hideLoadingByJS + ", loadingTimeout=" + this.loadingTimeout + ')';
    }

    public final boolean getHideLoadingByJS() {
        return this.hideLoadingByJS;
    }

    public final boolean getHitWebViewCache() {
        return this.hitWebViewCache;
    }

    public final long getLoadingTimeout() {
        return this.loadingTimeout;
    }

    public final long getOpenTimestamp() {
        return this.openTimestamp;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final boolean getStatisticsByJS() {
        return this.statisticsByJS;
    }

    public final TitlebarConfig getTitlebarConfig() {
        return this.titlebarConfig;
    }

    public final boolean isColdLaunch() {
        return this.isColdLaunch;
    }

    public final void setColdLaunch(boolean r1) {
        this.isColdLaunch = r1;
    }

    public final void setHideLoadingByJS(boolean r1) {
        this.hideLoadingByJS = r1;
    }

    public final void setHitWebViewCache(boolean r1) {
        this.hitWebViewCache = r1;
    }

    public final void setLoadingTimeout(long r1) {
        this.loadingTimeout = r1;
    }

    public final void setOpenTimestamp(long r1) {
        this.openTimestamp = r1;
    }

    public final void setShowLoading(boolean r1) {
        this.showLoading = r1;
    }

    public final void setStatisticsByJS(boolean r1) {
        this.statisticsByJS = r1;
    }

    public final void setTitlebarConfig(TitlebarConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.titlebarConfig = r2;
    }

    public OpenConfig(TitlebarConfig r2, boolean r3, boolean r4, boolean r5, long r6, boolean r8, long r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "titlebarConfig");
        this.titlebarConfig = r2;
        this.showLoading = r3;
        this.hideLoadingByJS = r4;
        this.statisticsByJS = r5;
        this.loadingTimeout = r6;
        this.isColdLaunch = r8;
        this.openTimestamp = r9;
        this.hitWebViewCache = r11;
    }

    public /* synthetic */ OpenConfig(TitlebarConfig r12, boolean r13, boolean r14, boolean r15, long r16, boolean r18, long r19, boolean r21, int r22, DefaultConstructorMarker r23) {
        boolean r2 = true;
        if ((r22 & 1) == 0) goto L5;
        TitlebarConfig r1 = new TitlebarConfig(true, null, 2, null);
    L6:
        boolean r4 = false;
        if ((r22 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r22 & 8) != 0) goto L19;
        r4 = r15;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r6 = DEFAULT_LOADING_TIMEOUT;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r8 = true;
    L27:
        if ((r22 & 64) == 0) goto L29;
        long r9 = System.currentTimeMillis();
    L31:
        if ((r22 & 128) != 0) goto L34;
        r2 = r21;
    L34:
        this(r1, r3, r5, r4, r6, r8, r9, r2);
        return;
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L6
    }
}
