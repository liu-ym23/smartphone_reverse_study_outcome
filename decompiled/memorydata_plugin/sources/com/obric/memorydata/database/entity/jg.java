package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/entity/UserProfileMemoryEntity;", "", "profileKey", "", "profileValue", "timestamp", "", OaidModel.KEY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getProfileKey", "()Ljava/lang/String;", "getProfileValue", "getTimestamp", "()J", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9266b;
    private final long c;
    private final long d;

    public jg(String r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "profileKey");
        Intrinsics.checkNotNullParameter(r3, "profileValue");
        this.f9265a = r2;
        this.f9266b = r3;
        this.c = r4;
        this.d = r6;
    }

    public final String a() {
        return this.f9265a;
    }

    public final String b() {
        return this.f9266b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, jg.class) == true) goto L8;
        return false;
    L8:
        jg r10 = (jg) ZeusTransformUtils.preCheckCast(r9, jg.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9265a, r10.f9265a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9266b, r10.f9266b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f9265a.hashCode() * 31) + this.f9266b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "UserProfileMemoryEntity(profileKey=" + this.f9265a + ", profileValue=" + this.f9266b + ", timestamp=" + this.c + ", id=" + this.d + ')';
    }
}
