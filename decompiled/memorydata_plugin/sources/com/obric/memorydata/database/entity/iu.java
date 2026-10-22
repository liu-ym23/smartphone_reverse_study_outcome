package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "", OaidModel.KEY_ID, "", "unionSemanticMemoryId", "entityId", "", "version", "", "snapshotJson", "snapshotTime", "<init>", "(JJLjava/lang/String;ILjava/lang/String;J)V", "getId", "()J", "getUnionSemanticMemoryId", "getEntityId", "()Ljava/lang/String;", "getVersion", "()I", "getSnapshotJson", "getSnapshotTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class iu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9240b;
    private final String c;
    private final int d;
    private final String e;
    private final long f;

    public iu(long r2, long r4, String r6, int r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r6, "entityId");
        Intrinsics.checkNotNullParameter(r8, "snapshotJson");
        this.f9239a = r2;
        this.f9240b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }

    public /* synthetic */ iu(long r13, long r15, String r17, int r18, String r19, long r20, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r15, r17, r18, r19, r20);
        return;
    L5:
        r3 = r13;
        goto L6
    }

    public static /* synthetic */ iu a(iu r10, long r11, long r13, String r15, int r16, String r17, long r18, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = r10.f9239a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        long r3 = r10.f9240b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r5 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r6 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r8 = r10.f;
    L27:
        return r10.a(r1, r3, r5, r6, r7, r8);
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final long a() {
        return this.f9239a;
    }

    public final iu a(long r12, long r14, String r16, int r17, String r18, long r19) {
        Intrinsics.checkNotNullParameter(r16, "entityId");
        Intrinsics.checkNotNullParameter(r18, "snapshotJson");
        return new iu(r12, r14, r16, r17, r18, r19);
    }

    public final long b() {
        return this.f9240b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, iu.class) == true) goto L8;
        return false;
    L8:
        iu r10 = (iu) ZeusTransformUtils.preCheckCast(r9, iu.class, "com.obric.memorydata.plugin");
        if (this.f9239a == r10.f9239a) goto L12;
        return false;
    L12:
        if (this.f9240b == r10.f9240b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
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

    public final long f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f9239a) * 31) + Long.hashCode(this.f9240b)) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "UnionSemanticMemorySnapShotEntity(id=" + this.f9239a + ", unionSemanticMemoryId=" + this.f9240b + ", entityId=" + this.c + ", version=" + this.d + ", snapshotJson=" + this.e + ", snapshotTime=" + this.f + ')';
    }
}
