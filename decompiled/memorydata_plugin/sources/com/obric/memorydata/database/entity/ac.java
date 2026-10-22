package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/entity/AwarenessInfoEntity;", "", "timestamp", "", "key", "", EventBody.KEY_VALUE, OaidModel.KEY_ID, "<init>", "(JLjava/lang/String;Ljava/lang/String;J)V", "getTimestamp", "()J", "getKey", "()Ljava/lang/String;", "getValue", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8868b;
    private final String c;
    private final long d;

    public ac(long r2, String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        this.f8867a = r2;
        this.f8868b = r4;
        this.c = r5;
        this.d = r6;
    }

    public final long a() {
        return this.f8867a;
    }

    public final String b() {
        return this.f8868b;
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
        if (ZeusTransformUtils.instanceOf(r9, ac.class) == true) goto L8;
        return false;
    L8:
        ac r10 = (ac) ZeusTransformUtils.preCheckCast(r9, ac.class, "com.obric.memorydata.plugin");
        if (this.f8867a == r10.f8867a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8868b, r10.f8868b) == true) goto L15;
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
        return (((((Long.hashCode(this.f8867a) * 31) + this.f8868b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "AwarenessInfoEntity(timestamp=" + this.f8867a + ", key=" + this.f8868b + ", value=" + this.c + ", id=" + this.d + ')';
    }
}
