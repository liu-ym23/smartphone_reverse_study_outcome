package com.bytedance.sdk.xbridge.cn.storage.utils;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0003\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/e;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "type", "c", "value", "", "Ljava/lang/Long;", "()Ljava/lang/Long;", "expiredTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final String f7486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("value")
    private final String f7487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("expired_time")
    private final Long f7488c;

    public final Long a() {
        return this.f7488c;
    }

    public final String b() {
        return this.f7486a;
    }

    public final String c() {
        return this.f7487b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        if (Intrinsics.areEqual(this.f7486a, r10.f7486a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7487b, r10.f7487b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f7488c, r10.f7488c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f7486a.hashCode() * 31;
        int r10 = kk.a.b(this.f7487b, r5, 31);
        Long r11 = this.f7488c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final String toString() {
        return "StorageValue(type=" + this.f7486a + ", value=" + this.f7487b + ", expiredTime=" + this.f7488c + ')';
    }
}
