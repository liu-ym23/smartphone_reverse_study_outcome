package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/entity/UnionSemanticMemoryExtEntity;", "", OaidModel.KEY_ID, "", "memoryId", "", "useForKeyword", "", "<init>", "(JLjava/lang/String;Z)V", "getId", "()J", "getMemoryId", "()Ljava/lang/String;", "getUseForKeyword", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ir {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9236b;
    private final boolean c;

    public ir(long r2, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "memoryId");
        this.f9235a = r2;
        this.f9236b = r4;
        this.c = r5;
    }

    public /* synthetic */ ir(long r1, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r1, r3, r4);
    }

    public final long a() {
        return this.f9235a;
    }

    public final String b() {
        return this.f9236b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ir.class) == true) goto L8;
        return false;
    L8:
        ir r10 = (ir) ZeusTransformUtils.preCheckCast(r9, ir.class, "com.obric.memorydata.plugin");
        if (this.f9235a == r10.f9235a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9236b, r10.f9236b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9235a) * 31) + this.f9236b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "UnionSemanticMemoryExtEntity(id=" + this.f9235a + ", memoryId=" + this.f9236b + ", useForKeyword=" + this.c + ')';
    }
}
