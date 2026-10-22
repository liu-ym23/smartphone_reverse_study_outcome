package k0c;

import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passportc.task.TaskType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final TaskType a;
    public final l0c.c b;
    public long c;
    public long d;
    public final ConcurrentHashMap<String, C0158b> e;

    public static final class a {
        public final d a;
        public StepTrace b;
        public long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public a(d r2) {
            Intrinsics.checkNotNullParameter(r2, "task");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: k0c.b$b, reason: collision with other inner class name */
    public static final class C0158b {
        public final long a;
        public final long b;
        public final long c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0158b) == true) goto L8;
            return false;
        L8:
            C0158b r9 = (C0158b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.c;
            return r2 + ((int) (r4 ^ (r4 >>> 32)));
        }

        public final String toString() {
            return "TaskCostPayload(executeCost=" + this.a + ", runCost=" + this.b + ", waitTime=" + this.c + ')';
        }

        public C0158b(long r1, long r3, long r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r1 + r3;
        }
    }

    public final void a(a r10) {
        Intrinsics.checkNotNullParameter(r10, "singleTaskTracker");
        d r0 = r10.a;
        C0158b r8 = new C0158b(r10.f, r10.h, r10.d);
        this.d += r8.d;
        this.e.put(r0.getTask().F().a, r8);
        if (this.a != TaskType.OFFLINE) goto L5;
        String r11 = "rust_infra_offline_task";
    L6:
        l0c.c r1 = this.b;
        if (r1 == null) goto L10;
        r1.c(r11 + '_' + r0.getTask().F(), r8.d);
        return;
    L10:
        return;
    L5:
        r11 = "rust_infra_online_task";
        goto L6
    }

    public b(TaskType r2, l0c.c r3) {
        Intrinsics.checkNotNullParameter(r2, "taskType");
        this.a = r2;
        this.b = r3;
        this.e = new ConcurrentHashMap();
    }
}
