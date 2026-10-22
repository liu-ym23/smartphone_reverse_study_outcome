package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0082\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\fHÖ\u0001J\t\u00104\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/ShortMemoryContentTimeEntityOld;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", "startTimestamp", "endTimestamp", "startDateTimestamp", "endDateTimestamp", "deltaDay", "", "deltaMonth", "deltaYear", "personalDbSplitMigrated", "", "<init>", "(JJLjava/lang/String;JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getStartTimestamp", "getEndTimestamp", "getStartDateTimestamp", "getEndDateTimestamp", "getDeltaDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeltaMonth", "getDeltaYear", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JJLjava/lang/String;JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/obric/memorydata/database/legacy/entity/ShortMemoryContentTimeEntityOld;", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ab extends com.obric.memorydata.database.entity.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9481b;
    private final String c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final boolean k;

    public ab(long r5, long r7, String r9, long r10, long r12, long r14, long r16, Integer r18, Integer r19, Integer r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r9, "rawDbColumn");
        super(r5, r7, r9, r10, r12, r14, r16, r18, r19, r20);
        this.f9480a = r5;
        this.f9481b = r7;
        this.c = r9;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public long a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public long b() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public long c() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public long d() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public Integer e() {
        return this.h;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == true) goto L8;
        return false;
    L8:
        ab r10 = (ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin");
        if (this.f9480a == r10.f9480a) goto L12;
        return false;
    L12:
        if (this.f9481b == r10.f9481b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L41;
        return false;
    L41:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public Integer f() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.b, com.obric.memorydata.database.entity.a
    public Integer g() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.b
    public long h() {
        return this.f9480a;
    }

    public int hashCode() {
        int r0 = ((((((((((((Long.hashCode(this.f9480a) * 31) + Long.hashCode(this.f9481b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31;
        Integer r1 = this.h;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.i;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.j;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + Boolean.hashCode(this.k);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.b
    public long i() {
        return this.f9481b;
    }

    @Override // com.obric.memorydata.database.entity.b
    public String j() {
        return this.c;
    }

    public final boolean k() {
        return this.k;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ShortMemoryContentTimeEntityOld(id=").append(this.f9480a).append(", rawDbId=").append(this.f9481b).append(", rawDbColumn=").append(this.c).append(", startTimestamp=").append(this.d).append(", endTimestamp=").append(this.e).append(", startDateTimestamp=").append(this.f).append(", endDateTimestamp=").append(this.g).append(", deltaDay=").append(this.h).append(", deltaMonth=").append(this.i).append(", deltaYear=").append(this.j).append(", personalDbSplitMigrated=").append(this.k).append(')');
        return r0.toString();
    }
}
