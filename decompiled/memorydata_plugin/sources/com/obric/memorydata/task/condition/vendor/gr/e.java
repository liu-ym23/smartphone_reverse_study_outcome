package com.obric.memorydata.task.condition.vendor.gr;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nj\u0004\u0018\u0001`\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/VirtualTaskSplitter;", "", "<init>", "()V", "currentTaskStartTime", "", "currentTaskEndTime", "tryAddTask", "", "getTaskInfo", "Lkotlin/Pair;", "Lcom/obric/memorydata/task/condition/vendor/gr/VirtualTaskInfo;", "getCurrentTime", "toString", "", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f12911b;
    private volatile long c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/VirtualTaskSplitter$Companion;", "", "<init>", "()V", "BATCH_TASK_THROTTLE", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12910a = new a(null);
    }

    public e() {
    }

    private final long c() {
        return System.currentTimeMillis();
    }

    public final boolean a() {
        long r0 = c();
        if ((c() - this.c) <= 60000) goto L6;
        this.f12911b = r0;
        this.c = r0;
        return true;
    L6:
        this.c = r0;
        return false;
    }

    public final Pair<Long, Long> b() {
        if ((c() - this.c) <= 60000) goto L7;
        return null;
    L7:
        return TuplesKt.to(Long.valueOf(this.f12911b), Long.valueOf(this.c));
    }

    public String toString() {
        return "Task [" + this.f12911b + ", " + this.c + "], info = " + b();
    }
}
