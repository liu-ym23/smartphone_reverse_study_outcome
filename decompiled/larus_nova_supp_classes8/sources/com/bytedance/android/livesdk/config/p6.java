package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/p6;", "", "", "enableRestart", "Z", "b", "()Z", "useLastFrame", "getUseLastFrame", "enableNormal", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p6 {

    @SerializedName("enable_normal")
    private final boolean enableNormal;

    @SerializedName("enable_restart")
    private final boolean enableRestart;

    @SerializedName("use_last_frame")
    private final boolean useLastFrame;

    public p6() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p6) == false) goto L12;
        p6 r4 = (p6) r3;
        if (this.enableRestart == r4.enableRestart) goto L8;
        return false;
    L8:
        if (this.useLastFrame == r4.useLastFrame) goto L10;
        return false;
    L10:
        if (this.enableNormal == r4.enableNormal) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r0 = this.enableRestart;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.useLastFrame;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.enableNormal;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public final String toString() {
        return "GameMultiProcessConfig(enableRestart=" + this.enableRestart + ", useLastFrame=" + this.useLastFrame + ", enableNormal=" + this.enableNormal + ")";
    }

    public final boolean a() {
        return this.enableNormal;
    }

    public final boolean b() {
        return this.enableRestart;
    }

    public p6(int r1) {
        this.enableRestart = false;
        this.useLastFrame = false;
        this.enableNormal = false;
    }
}
