package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/n4;", "", "", "enable", "Z", "a", "()Z", "", "enterMerge", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "enterType", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n4 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enter_merge")
    private final String enterMerge;

    @SerializedName("enter_type")
    private final String enterType;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n4) == false) goto L12;
        n4 r4 = (n4) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterMerge, r4.enterMerge) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterType, r4.enterType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.enterMerge;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.enterType;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "EnableEnterConfig(enable=" + this.enable + ", enterMerge=" + this.enterMerge + ", enterType=" + this.enterType + ")";
    }

    public n4() {
        Intrinsics.checkNotNullParameter("", "enterMerge");
        Intrinsics.checkNotNullParameter("", "enterType");
        this.enable = false;
        this.enterMerge = "";
        this.enterType = "";
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.enterMerge;
    }

    public final String c() {
        return this.enterType;
    }
}
