package com.bytedance.android.ec.core.cps;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/cps/h;", "", "", "version", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "event", "b", "params", "d", "sysTime", "f", "hash", "c", "", "r", "I", "e", "()I", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("c")
    private final int c;

    @SerializedName("e")
    private final String event;

    @SerializedName("h")
    private final String hash;

    @SerializedName("d")
    private final String params;

    @SerializedName("r")
    private final int r;

    @SerializedName("t")
    private final String sysTime;

    @SerializedName("v")
    private final String version;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof h) == false) goto L20;
        h r11 = (h) r10;
        if (Intrinsics.areEqual(this.version, r11.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.event, r11.event) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r11.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sysTime, r11.sysTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hash, r11.hash) == true) goto L16;
        return false;
    L16:
        if (this.r == r11.r) goto L18;
        return false;
    L18:
        if (this.c == r11.c) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.version;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.event;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.params;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.sysTime;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.hash;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return ((((r20 + r1) * 31) + this.r) * 31) + this.c;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicEventStruct(version=" + this.version + ", event=" + this.event + ", params=" + this.params + ", sysTime=" + this.sysTime + ", hash=" + this.hash + ", r=" + this.r + ", c=" + this.c + ")";
    }

    public final int a() {
        return this.c;
    }

    public final String b() {
        return this.event;
    }

    public final String c() {
        return this.hash;
    }

    public final String d() {
        return this.params;
    }

    public final int e() {
        return this.r;
    }

    public final String f() {
        return this.sysTime;
    }

    public final String g() {
        return this.version;
    }

    public h(String r10, String r11, String r12, String r13, String r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r10, "version");
        Intrinsics.checkNotNullParameter(r11, "event");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "sysTime");
        Intrinsics.checkNotNullParameter(r14, "hash");
        this.version = r10;
        this.event = r11;
        this.params = r12;
        this.sysTime = r13;
        this.hash = r14;
        this.r = r15;
        this.c = r16;
    }
}
