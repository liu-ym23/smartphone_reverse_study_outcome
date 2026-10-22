package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/e6;", "", "", "enableActivateGecko", "Z", "b", "()Z", "", "", "activatePaths", "Ljava/util/List;", "a", "()Ljava/util/List;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e6 {

    @SerializedName("activate_paths")
    private final List<String> activatePaths;

    @SerializedName("enable_activate_gecko")
    private final boolean enableActivateGecko;

    public e6() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e6) == false) goto L10;
        e6 r4 = (e6) r3;
        if (this.enableActivateGecko == r4.enableActivateGecko) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.activatePaths, r4.activatePaths) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.enableActivateGecko;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.activatePaths;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "GameGeckoActivateConfig(enableActivateGecko=" + this.enableActivateGecko + ", activatePaths=" + this.activatePaths + ")";
    }

    public final List<String> a() {
        return this.activatePaths;
    }

    public final boolean b() {
        return this.enableActivateGecko;
    }

    public /* synthetic */ e6(int r2) {
        this(false, null);
    }

    public e6(boolean r1, List<String> r2) {
        this.enableActivateGecko = r1;
        this.activatePaths = r2;
    }
}
