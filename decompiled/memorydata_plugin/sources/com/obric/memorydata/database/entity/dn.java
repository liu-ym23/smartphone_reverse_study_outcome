package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/entity/MiddleUserProfileEntity;", "", "timestamp", "", "uriKey", "", "uriValue", OaidModel.KEY_ID, "<init>", "(JLjava/lang/String;Ljava/lang/String;J)V", "getTimestamp", "()J", "getUriKey", "()Ljava/lang/String;", "getUriValue", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9035b;
    private final String c;
    private final long d;

    public dn(long r2, String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "uriKey");
        Intrinsics.checkNotNullParameter(r5, "uriValue");
        this.f9034a = r2;
        this.f9035b = r4;
        this.c = r5;
        this.d = r6;
    }

    public /* synthetic */ dn(long r8, String r10, String r11, long r12, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r12 = 0;
    L5:
        this(r8, r10, r11, r12);
    }

    public final long a() {
        return this.f9034a;
    }

    public final String b() {
        return this.f9035b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, dn.class) == true) goto L8;
        return false;
    L8:
        dn r10 = (dn) ZeusTransformUtils.preCheckCast(r9, dn.class, "com.obric.memorydata.plugin");
        if (this.f9034a == r10.f9034a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9035b, r10.f9035b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9034a) * 31) + this.f9035b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "MiddleUserProfileEntity(timestamp=" + this.f9034a + ", uriKey=" + this.f9035b + ", uriValue=" + this.c + ", id=" + this.d + ')';
    }
}
