package com.obric.memorydata.database.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/entity/AbstractContentTime;", "", "startTimestamp", "", "endTimestamp", "startDateTimestamp", "endDateTimestamp", "deltaDay", "", "deltaMonth", "deltaYear", "<init>", "(JJJJLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStartTimestamp", "()J", "getEndTimestamp", "getStartDateTimestamp", "getEndDateTimestamp", "getDeltaDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeltaMonth", "getDeltaYear", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8861b;
    private final long c;
    private final long d;
    private final Integer e;
    private final Integer f;
    private final Integer g;

    public a(long r1, long r3, long r5, long r7, Integer r9, Integer r10, Integer r11) {
        this.f8860a = r1;
        this.f8861b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r11;
    }

    public long a() {
        return this.f8860a;
    }

    public long b() {
        return this.f8861b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public Integer e() {
        return this.e;
    }

    public Integer f() {
        return this.f;
    }

    public Integer g() {
        return this.g;
    }
}
