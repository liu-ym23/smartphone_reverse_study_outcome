package com.obric.memorydata.database.legacy.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JL\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/MemoryEntityCorrelationEntityOld;", "", "sourceEntityId", "", "targetEntityId", "targetMemoryType", "", "targetExpireTime", "", "score", "", "personalDbSplitMigrated", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;FZ)V", "getSourceEntityId", "()Ljava/lang/String;", "getTargetEntityId", "getTargetMemoryType", "()I", "getTargetExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getScore", "()F", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;FZ)Lcom/obric/memorydata/database/legacy/entity/MemoryEntityCorrelationEntityOld;", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9535b;
    private final int c;
    private final Long d;
    private final float e;
    private final boolean f;

    public p(String r2, String r3, int r4, Long r5, float r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r3, "targetEntityId");
        this.f9534a = r2;
        this.f9535b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final String a() {
        return this.f9534a;
    }

    public final String b() {
        return this.f9535b;
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
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9534a, r6.f9534a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9535b, r6.f9535b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        int r0 = ((((this.f9534a.hashCode() * 31) + this.f9535b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        Long r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Float.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MemoryEntityCorrelationEntityOld(sourceEntityId=" + this.f9534a + ", targetEntityId=" + this.f9535b + ", targetMemoryType=" + this.c + ", targetExpireTime=" + this.d + ", score=" + this.e + ", personalDbSplitMigrated=" + this.f + ')';
    }
}
