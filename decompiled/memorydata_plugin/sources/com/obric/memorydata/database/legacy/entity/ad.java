package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/UnionSemanticMemoryExtEntityOld;", "", OaidModel.KEY_ID, "", "memoryId", "", "useForKeyword", "", "personalDbSplitMigrated", "<init>", "(JLjava/lang/String;ZZ)V", "getId", "()J", "getMemoryId", "()Ljava/lang/String;", "getUseForKeyword", "()Z", "getPersonalDbSplitMigrated", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9485b;
    private final boolean c;
    private final boolean d;

    public ad(long r2, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "memoryId");
        this.f9484a = r2;
        this.f9485b = r4;
        this.c = r5;
        this.d = r6;
    }

    public final long a() {
        return this.f9484a;
    }

    public final String b() {
        return this.f9485b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ad.class) == true) goto L8;
        return false;
    L8:
        ad r10 = (ad) ZeusTransformUtils.preCheckCast(r9, ad.class, "com.obric.memorydata.plugin");
        if (this.f9484a == r10.f9484a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9485b, r10.f9485b) == true) goto L15;
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
        return (((((Long.hashCode(this.f9484a) * 31) + this.f9485b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "UnionSemanticMemoryExtEntityOld(id=" + this.f9484a + ", memoryId=" + this.f9485b + ", useForKeyword=" + this.c + ", personalDbSplitMigrated=" + this.d + ')';
    }
}
