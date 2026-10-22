package com.obric.memorydata.database.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/entity/ScheduleContentTime;", "Lcom/obric/memorydata/database/entity/AbstractContentTime;", "startTimestamp", "", "endTimestamp", "startDateTimestamp", "endDateTimestamp", "deltaDay", "", "deltaMonth", "deltaYear", "<init>", "(JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStartTimestamp", "()J", "getEndTimestamp", "getStartDateTimestamp", "getEndDateTimestamp", "getDeltaDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeltaMonth", "getDeltaYear", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hz extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9204b;
    private final long c;
    private final long d;
    private final Integer e;
    private final Integer f;
    private final Integer g;

    public hz() {
        this(0, 0, 0, 0, null, null, null, 127, null);
    }

    public hz(long r1, long r3, long r5, long r7, Integer r9, Integer r10, Integer r11) {
        super(r1, r3, r5, r7, r9, r10, r11);
        this.f9203a = r1;
        this.f9204b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r11;
    }

    public /* synthetic */ hz(long r3, long r5, long r7, long r9, Integer r11, Integer r12, Integer r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r7 = 0;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r9 = 0;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r11 = null;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r12 = null;
    L21:
        if ((r14 & 64) == 0) goto L23;
        r13 = null;
    L23:
        this(r3, r5, r7, r9, r11, r12, r13);
    }

    @Override // com.obric.memorydata.database.entity.a
    public long a() {
        return this.f9203a;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long b() {
        return this.f9204b;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long c() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.a
    public long d() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.a
    public Integer e() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.a
    public Integer f() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.a
    public Integer g() {
        return this.g;
    }
}
