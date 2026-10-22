package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/r41;", "", "", "enableMiniApp", "Z", "a", "()Z", "enableDevelopMiniApp", "getEnableDevelopMiniApp", "", "liveCoreOutFps", "I", "getLiveCoreOutFps", "()I", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r41 {

    @SerializedName("enable_develop_miniapp")
    private final boolean enableDevelopMiniApp;

    @SerializedName("enable_miniapp")
    private final boolean enableMiniApp;

    @SerializedName("livecore_outfps")
    private final int liveCoreOutFps;

    public r41() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r41) == false) goto L12;
        r41 r4 = (r41) r3;
        if (this.enableMiniApp == r4.enableMiniApp) goto L8;
        return false;
    L8:
        if (this.enableDevelopMiniApp == r4.enableDevelopMiniApp) goto L10;
        return false;
    L10:
        if (this.liveCoreOutFps == r4.liveCoreOutFps) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        boolean r0 = this.enableMiniApp;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.enableDevelopMiniApp;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return ((r3 + r1) * 31) + this.liveCoreOutFps;
    }

    public final String toString() {
        return "LiveInteractiveToolsMiniAppConfig(enableMiniApp=" + this.enableMiniApp + ", enableDevelopMiniApp=" + this.enableDevelopMiniApp + ", liveCoreOutFps=" + this.liveCoreOutFps + ")";
    }

    public final boolean a() {
        return this.enableMiniApp;
    }

    public r41(int r1) {
        this.enableMiniApp = false;
        this.enableDevelopMiniApp = false;
        this.liveCoreOutFps = 20;
    }
}
