package com.bytedance.sdk.xbridge.cn.storage.utils;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0003\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\b\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/g;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "type", "b", "e", "value", "", "c", "Ljava/lang/Long;", "()Ljava/lang/Long;", "created_name", "getLastAccessTime", "lastAccessTime", "lastModifiedTime", "f", "expiredTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final String f7491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("value")
    private final String f7492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("created_time")
    private final Long f7493c;

    @SerializedName("last_access_time")
    private final Long d;

    @SerializedName("last_modified_time")
    private final Long e;

    @SerializedName("expired_time")
    private final Long f;

    public g() {
        this(null, null, null, null, null, null);
    }

    public final Long a() {
        return this.f7493c;
    }

    public final Long b() {
        return this.f;
    }

    public final Long c() {
        return this.e;
    }

    public final String d() {
        return this.f7491a;
    }

    public final String e() {
        return this.f7492b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        if (Intrinsics.areEqual(this.f7491a, r10.f7491a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7492b, r10.f7492b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f7493c, r10.f7493c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f7491a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f7492b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.f7493c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.e;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.f;
        if (r25 == null) goto L27;
        r10 = r25.hashCode();
    L27:
        return r24 + r10;
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserDomainStorageValue(type=" + this.f7491a + ", value=" + this.f7492b + ", created_name=" + this.f7493c + ", lastAccessTime=" + this.d + ", lastModifiedTime=" + this.e + ", expiredTime=" + this.f + ')';
    }

    public g(String r5, String r10, Long r11, Long r12, Long r13, Long r14) {
        this.f7491a = r5;
        this.f7492b = r10;
        this.f7493c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
