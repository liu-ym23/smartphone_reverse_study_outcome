package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTime;", OaidModel.KEY_ID, "", "rawDbId", "rawDbColumn", "", "startTimestamp", "endTimestamp", "startDateTimestamp", "endDateTimestamp", "deltaDay", "", "deltaMonth", "deltaYear", "<init>", "(JJLjava/lang/String;JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()J", "getRawDbId", "getRawDbColumn", "()Ljava/lang/String;", "getStartTimestamp", "getEndTimestamp", "getStartDateTimestamp", "getEndDateTimestamp", "getDeltaDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeltaMonth", "getDeltaYear", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8914b;
    private final String c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final Integer h;
    private final Integer i;
    private final Integer j;

    public b(long r15, long r17, String r19, long r20, long r22, long r24, long r26, Integer r28, Integer r29, Integer r30) {
        Intrinsics.checkNotNullParameter(r19, "rawDbColumn");
        super(r20, r22, r24, r26, r28, r29, r30);
        this.f8913a = r15;
        this.f8914b = r17;
        this.c = r19;
        this.d = r20;
        this.e = r22;
        this.f = r24;
        this.g = r26;
        this.h = r28;
        this.i = r29;
        this.j = r30;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long b() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long c() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long d() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.a
    public Integer e() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.a
    public Integer f() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.a
    public Integer g() {
        return this.j;
    }

    public long h() {
        return this.f8913a;
    }

    public long i() {
        return this.f8914b;
    }

    public String j() {
        return this.c;
    }
}
