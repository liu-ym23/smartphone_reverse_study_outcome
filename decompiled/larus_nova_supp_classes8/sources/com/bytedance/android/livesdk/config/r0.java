package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/r0;", "", "", "", "blackList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "multiList", "b", "setMultiList", "singleList", "c", "setSingleList", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("black_list")
    private List<String> blackList;

    @SerializedName("multi_list")
    private List<String> multiList;

    @SerializedName("single_list")
    private List<String> singleList;

    public r0() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r0) == false) goto L12;
        r0 r4 = (r0) r3;
        if (Intrinsics.areEqual(this.blackList, r4.blackList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.multiList, r4.multiList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.singleList, r4.singleList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.blackList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.multiList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.singleList;
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
        return "BackRoomListSettingConfig(blackList=" + this.blackList + ", multiList=" + this.multiList + ", singleList=" + this.singleList + ")";
    }

    public final List<String> a() {
        return this.blackList;
    }

    public final List<String> b() {
        return this.multiList;
    }

    public final List<String> c() {
        return this.singleList;
    }

    public r0(Object r1) {
        this.blackList = null;
        this.multiList = null;
        this.singleList = null;
    }
}
