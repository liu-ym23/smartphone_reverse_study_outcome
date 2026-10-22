package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JB\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryEntityCorrelationEntity;", "", "sourceEntityId", "", "targetEntityId", "targetMemoryType", "", "targetExpireTime", "", "score", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;F)V", "getSourceEntityId", "()Ljava/lang/String;", "getTargetEntityId", "getTargetMemoryType", "()I", "getTargetExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getScore", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;F)Lcom/obric/memorydata/database/entity/MemoryEntityCorrelationEntity;", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8987b;
    private final int c;
    private final Long d;
    private final float e;

    public cp(String r2, String r3, int r4, Long r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r3, "targetEntityId");
        this.f8986a = r2;
        this.f8987b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final String a() {
        return this.f8986a;
    }

    public final String b() {
        return this.f8987b;
    }

    public final int c() {
        return this.c;
    }

    public final Long d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cp.class) == true) goto L8;
        return false;
    L8:
        cp r6 = (cp) ZeusTransformUtils.preCheckCast(r5, cp.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8986a, r6.f8986a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8987b, r6.f8987b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f8986a.hashCode() * 31) + this.f8987b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        Long r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Float.hashCode(this.e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MemoryEntityCorrelationEntity(sourceEntityId=" + this.f8986a + ", targetEntityId=" + this.f8987b + ", targetMemoryType=" + this.c + ", targetExpireTime=" + this.d + ", score=" + this.e + ')';
    }
}
