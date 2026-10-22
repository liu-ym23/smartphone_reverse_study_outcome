package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/hi1;", "", "", "module", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "enableTrace", "Z", "a", "()Z", "openSlardar", "d", "openTea", "e", "openLiveTrace", "c", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hi1 {

    @SerializedName("enable_trace")
    private final boolean enableTrace;

    @SerializedName("module")
    private final String module;

    @SerializedName("open_live_trace")
    private final boolean openLiveTrace;

    @SerializedName("open_slardar")
    private final boolean openSlardar;

    @SerializedName("open_tea")
    private final boolean openTea;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof hi1) == false) goto L16;
        hi1 r4 = (hi1) r3;
        if (Intrinsics.areEqual(this.module, r4.module) == true) goto L8;
        return false;
    L8:
        if (this.enableTrace == r4.enableTrace) goto L10;
        return false;
    L10:
        if (this.openSlardar == r4.openSlardar) goto L12;
        return false;
    L12:
        if (this.openTea == r4.openTea) goto L14;
        return false;
    L14:
        if (this.openLiveTrace == r4.openLiveTrace) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r0 = this.module;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.enableTrace;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r2 + r5) * 31;
        boolean r7 = this.openSlardar;
        ?? r8 = r7;
        if (r7 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.openTea;
        ?? r11 = r10;
        if (r10 == false) goto L15;
        r11 = 1;
    L15:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.openLiveTrace;
        if (r13 == true) goto L20;
        r4 = r13;
    L20:
        return r12 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "TraceModuleConfig(module=" + this.module + ", enableTrace=" + this.enableTrace + ", openSlardar=" + this.openSlardar + ", openTea=" + this.openTea + ", openLiveTrace=" + this.openLiveTrace + ")";
    }

    public final boolean a() {
        return this.enableTrace;
    }

    public final String b() {
        return this.module;
    }

    public final boolean c() {
        return this.openLiveTrace;
    }

    public final boolean d() {
        return this.openSlardar;
    }

    public final boolean e() {
        return this.openTea;
    }
}
