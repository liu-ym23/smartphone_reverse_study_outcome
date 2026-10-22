package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.profile.monitor.DataType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/n1;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "avatar", "getAvatar", "point", "getPoint", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n1 {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("name")
    private final String name;

    @SerializedName("points")
    private final String point;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n1) == false) goto L12;
        n1 r4 = (n1) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.point, r4.point) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.avatar;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.point;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "User(name=" + this.name + ", avatar=" + this.avatar + ", point=" + this.point + ")";
    }

    public n1() {
        this("", "", DataType.FALSE);
    }

    public n1(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "avatar");
        Intrinsics.checkNotNullParameter(r4, "point");
        this.name = r2;
        this.avatar = r3;
        this.point = r4;
    }
}
