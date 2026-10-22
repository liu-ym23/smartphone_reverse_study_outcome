package com.obric.memorydata.memory.tracker;

import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ah;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryCorrelationTracker;", "", "<init>", "()V", "memoryType", "", "strategy", "beginTs", "", "taskExecuteTs", "endTs", "startTrack", "", "startExecute", "endTrack", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10532b;
    private int c;
    private long d;
    private long e;
    private long f;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemoryCorrelationTracker$Companion;", "", "<init>", "()V", "TAG", "", "KEY_MEMORY_TYPE", "KEY_SCHEDULE_TIME", "KEY_EXECUTE_TIME", "KEY_TOTAL_TIME", "KEY_STRATEGY", "startTrack", "Lcom/obric/memorydata/memory/tracker/MemoryCorrelationTracker;", "memoryType", "", "strategy", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final b a(int r1, int r2) {
            b r0 = new b();
            r0.a(r1, r2);
            return r0;
        }
    }

    static {
        f10531a = new a(null);
    }

    public b() {
        this.f10532b = -1;
        this.c = -1;
    }

    public final void a() {
        this.e = System.currentTimeMillis();
    }

    public final void a(int r1, int r2) {
        this.c = r2;
        this.f10532b = r1;
        this.d = System.currentTimeMillis();
    }

    public final void b() {
        this.f = System.currentTimeMillis();
        JSONObject r0 = new JSONObject();
        r0.put("memoryType", this.f10532b);
        r0.put("strategy", this.c);
        r0.put("scheduleTime", this.e - this.d);
        r0.put("executeTime", this.f - this.e);
        r0.put("totalTime", this.f - this.d);
        RunLog.INSTANCE.debug("MemoryCorrelationTracker", "MemoryCorrelationTracker, params: " + r0);
        ah.a(DevTrackerEventId.MEMORY_CORRELATION_PERF_EVENT, r0);
    }
}
