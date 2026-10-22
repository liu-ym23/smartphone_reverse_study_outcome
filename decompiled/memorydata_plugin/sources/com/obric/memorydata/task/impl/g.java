package com.obric.memorydata.task.impl;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "", "long", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "<init>", "(JLjava/util/concurrent/TimeUnit;)V", "getLong", "()J", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "toMillis", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeUnit f12934b;

    public g(long r2, TimeUnit r4) {
        Intrinsics.checkNotNullParameter(r4, "timeUnit");
        this.f12933a = r2;
        this.f12934b = r4;
    }

    public long a() {
        return this.f12933a;
    }

    public TimeUnit b() {
        return this.f12934b;
    }

    public final long c() {
        return b().toMillis(a());
    }

    public String toString() {
        return "TaskTimeUnit(long=" + a() + ", timeUnit=" + b() + ')';
    }
}
