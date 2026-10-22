package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/k81;", "", "", "enableAll", "Z", "b", "()Z", "enableLoki", "c", "enablePlugin", "d", "enableSearch", "f", "accessibilityOpt", "a", "enableRecent", "e", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k81 {

    @SerializedName("accessibility_opt")
    private final boolean accessibilityOpt;

    @SerializedName("enable_all")
    private final boolean enableAll;

    @SerializedName("enable_loki")
    private final boolean enableLoki;

    @SerializedName("enable_plugin")
    private final boolean enablePlugin;

    @SerializedName("enable_recent")
    private final boolean enableRecent;

    @SerializedName("enable_search")
    private final boolean enableSearch;

    public k81() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k81) == false) goto L18;
        k81 r4 = (k81) r3;
        if (this.enableAll == r4.enableAll) goto L8;
        return false;
    L8:
        if (this.enableLoki == r4.enableLoki) goto L10;
        return false;
    L10:
        if (this.enablePlugin == r4.enablePlugin) goto L12;
        return false;
    L12:
        if (this.enableSearch == r4.enableSearch) goto L14;
        return false;
    L14:
        if (this.accessibilityOpt == r4.accessibilityOpt) goto L16;
        return false;
    L16:
        if (this.enableRecent == r4.enableRecent) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r0 = this.enableAll;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.enableLoki;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.enablePlugin;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.enableSearch;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.accessibilityOpt;
        ?? r14 = r13;
        if (r13 == false) goto L17;
        r14 = 1;
    L17:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.enableRecent;
        if (r16 == true) goto L22;
        r1 = r16;
    L22:
        return r15 + r1;
    }

    public final String toString() {
        return "LiveStartInteractiveToolsConfig(enableAll=" + this.enableAll + ", enableLoki=" + this.enableLoki + ", enablePlugin=" + this.enablePlugin + ", enableSearch=" + this.enableSearch + ", accessibilityOpt=" + this.accessibilityOpt + ", enableRecent=" + this.enableRecent + ")";
    }

    public final boolean a() {
        return this.accessibilityOpt;
    }

    public final boolean b() {
        return this.enableAll;
    }

    public final boolean c() {
        return this.enableLoki;
    }

    public final boolean d() {
        return this.enablePlugin;
    }

    public final boolean e() {
        return this.enableRecent;
    }

    public final boolean f() {
        return this.enableSearch;
    }

    public k81(int r2) {
        this.enableAll = false;
        this.enableLoki = false;
        this.enablePlugin = false;
        this.enableSearch = false;
        this.accessibilityOpt = true;
        this.enableRecent = false;
    }
}
