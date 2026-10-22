package com.bytedance.android.monitorV2.settings;

import ai.j0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/g;", "", "Lcom/bytedance/android/monitorV2/settings/a;", "a", "Lcom/bytedance/android/monitorV2/settings/a;", "()Lcom/bytedance/android/monitorV2/settings/a;", "data", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("data")
    private final a f3729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("message")
    private final String f3730b;

    public g() {
        this.f3729a = null;
        this.f3730b = null;
    }

    public final a a() {
        return this.f3729a;
    }

    public final String b() {
        return this.f3730b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        if (Intrinsics.areEqual(this.f3729a, r10.f3729a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3730b, r10.f3730b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        a r5 = this.f3729a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f3730b;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("SettingsResponse(data=");
        r5.append(this.f3729a);
        r5.append(", message=");
        return j0.p(r5, this.f3730b, ')');
    }
}
