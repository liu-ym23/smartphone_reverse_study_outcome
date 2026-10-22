package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/AutoMemorySemanticRelevantDataOld;", "", OaidModel.KEY_ID, "", "memoryId", "ruleId", "createTime", "sourceType", "", "personalDbSplitMigrated", "", "<init>", "(JJJJLjava/lang/String;Z)V", "getId", "()J", "getMemoryId", "getRuleId", "getCreateTime", "getSourceType", "()Ljava/lang/String;", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9517b;
    private final long c;
    private final long d;
    private final String e;
    private final boolean f;

    public g(long r2, long r4, long r6, long r8, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sourceType");
        this.f9516a = r2;
        this.f9517b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r10;
        this.f = r11;
    }

    public final long a() {
        return this.f9516a;
    }

    public final long b() {
        return this.f9517b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (this.f9516a == r10.f9516a) goto L12;
        return false;
    L12:
        if (this.f9517b == r10.f9517b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f9516a) * 31) + Long.hashCode(this.f9517b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "AutoMemorySemanticRelevantDataOld(id=" + this.f9516a + ", memoryId=" + this.f9517b + ", ruleId=" + this.c + ", createTime=" + this.d + ", sourceType=" + this.e + ", personalDbSplitMigrated=" + this.f + ')';
    }
}
