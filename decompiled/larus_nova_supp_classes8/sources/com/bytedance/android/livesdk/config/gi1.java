package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/gi1;", "", "", "messageType", "Ljava/lang/Number;", "b", "()Ljava/lang/Number;", "expire", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gi1 {

    @SerializedName("expire")
    private final Number expire;

    @SerializedName("message_type")
    private final Number messageType;

    public gi1() {
        Intrinsics.checkNotNullParameter(-1, "messageType");
        Intrinsics.checkNotNullParameter(-1, "expire");
        this.messageType = -1;
        this.expire = -1;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof gi1) == false) goto L10;
        gi1 r4 = (gi1) r3;
        if (Intrinsics.areEqual(this.messageType, r4.messageType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.expire, r4.expire) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Number r0 = this.messageType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Number r4 = this.expire;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ToolbarTipConfig(messageType=" + this.messageType + ", expire=" + this.expire + ")";
    }

    public final Number a() {
        return this.expire;
    }

    public final Number b() {
        return this.messageType;
    }
}
