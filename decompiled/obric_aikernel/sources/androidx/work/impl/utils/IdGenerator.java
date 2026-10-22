package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public IdGenerator(WorkDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "workDatabase");
        this.workDatabase = r10;
    }

    public static /* synthetic */ Integer a(IdGenerator r10, int r11, int r12) {
        return nextJobSchedulerIdWithRange$lambda$0(r10, r11, r12);
    }

    public static /* synthetic */ Integer b(IdGenerator r10) {
        return nextAlarmManagerId$lambda$1(r10);
    }

    private static final Integer nextAlarmManagerId$lambda$1(IdGenerator r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        return Integer.valueOf(IdGeneratorKt.access$nextId(r10.workDatabase, IdGeneratorKt.NEXT_ALARM_MANAGER_ID_KEY));
    }

    private static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        int r13 = IdGeneratorKt.access$nextId(r10.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY);
        boolean r14 = false;
        if (r11 > r13) goto L6;
        if (r13 > r12) goto L6;
        r14 = true;
    L6:
        if (r14 == true) goto L8;
        IdGeneratorKt.access$updatePreference(r10.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY, r11 + 1);
    L10:
        return Integer.valueOf(r11);
    L8:
        r11 = r13;
        goto L10
    }

    public final int nextAlarmManagerId() {
        Object r10 = this.workDatabase.runInTransaction(new a(this));
        Intrinsics.checkNotNullExpressionValue(r10, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) r10).intValue();
    }

    public final int nextJobSchedulerIdWithRange(final int r10, final int r11) {
        Object r12 = this.workDatabase.runInTransaction(new b(this, r10, r11));
        Intrinsics.checkNotNullExpressionValue(r12, "workDatabase.runInTransa…            id\n        })");
        return ((Number) r12).intValue();
    }
}
