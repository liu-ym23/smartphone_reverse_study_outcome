package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/v0;", "", "", "type", "I", "getType", "()I", "", "musicFeature", "Ljava/lang/String;", "getMusicFeature", "()Ljava/lang/String;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v0 {

    @SerializedName("music_feature")
    private final String musicFeature;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v0) == false) goto L10;
        v0 r4 = (v0) r3;
        if (this.type == r4.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.musicFeature, r4.musicFeature) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.musicFeature;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "SingingFingerprint(type=" + this.type + ", musicFeature=" + this.musicFeature + ")";
    }

    public v0() {
        this.type = 0;
        this.musicFeature = null;
    }

    public final int getType() {
        return this.type;
    }
}
