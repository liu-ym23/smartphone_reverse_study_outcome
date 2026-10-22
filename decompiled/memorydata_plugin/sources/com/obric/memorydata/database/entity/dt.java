package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJx\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\fHÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001b¨\u00061"}, d2 = {"Lcom/obric/memorydata/database/entity/NoteEntityContentTimeEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", "startTimestamp", "endTimestamp", "startDateTimestamp", "endDateTimestamp", "deltaDay", "", "deltaMonth", "deltaYear", "<init>", "(JJLjava/lang/String;JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getStartTimestamp", "getEndTimestamp", "getStartDateTimestamp", "getEndDateTimestamp", "getDeltaDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeltaMonth", "getDeltaYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JJLjava/lang/String;JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/memorydata/database/entity/NoteEntityContentTimeEntity;", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dt extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9045b;
    private final String c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final Integer h;
    private final Integer i;
    private final Integer j;

    public dt(long r5, long r7, String r9, long r10, long r12, long r14, long r16, Integer r18, Integer r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r9, "rawDbColumn");
        super(r5, r7, r9, r10, r12, r14, r16, r18, r19, r20);
        this.f9044a = r5;
        this.f9045b = r7;
        this.c = r9;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r18;
        this.i = r19;
        this.j = r20;
    }

    public /* synthetic */ dt(long r21, long r23, String r25, long r26, long r28, long r30, long r32, Integer r34, Integer r35, Integer r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r37 & 128) == 0) goto L9;
        Integer r17 = null;
    L11:
        if ((r37 & 256) == 0) goto L13;
        Integer r18 = null;
    L15:
        if ((r37 & 512) == 0) goto L17;
        Integer r19 = null;
    L18:
        this(r4, r23, r25, r26, r28, r30, r32, r17, r18, r19);
        return;
    L17:
        r19 = r36;
        goto L18
    L13:
        r18 = r35;
        goto L15
    L9:
        r17 = r34;
        goto L11
    L5:
        r4 = r21;
        goto L7
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
        if (ZeusTransformUtils.instanceOf(r9, dt.class) == true) goto L8;
        return false;
    L8:
        dt r10 = (dt) ZeusTransformUtils.preCheckCast(r9, dt.class, "com.obric.memorydata.plugin");
        if (this.f9044a == r10.f9044a) goto L12;
        return false;
    L12:
        if (this.f9045b == r10.f9045b) goto L15;
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
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L38;
        return false;
    L38:
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
        return this.f9044a;
    }

    public int hashCode() {
        int r0 = ((((((((((((Long.hashCode(this.f9044a) * 31) + Long.hashCode(this.f9045b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31;
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
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.b
    public long i() {
        return this.f9045b;
    }

    @Override // com.obric.memorydata.database.entity.b
    public String j() {
        return this.c;
    }

    public String toString() {
        return "NoteEntityContentTimeEntity(id=" + this.f9044a + ", rawDbId=" + this.f9045b + ", rawDbColumn=" + this.c + ", startTimestamp=" + this.d + ", endTimestamp=" + this.e + ", startDateTimestamp=" + this.f + ", endDateTimestamp=" + this.g + ", deltaDay=" + this.h + ", deltaMonth=" + this.i + ", deltaYear=" + this.j + ')';
    }
}
