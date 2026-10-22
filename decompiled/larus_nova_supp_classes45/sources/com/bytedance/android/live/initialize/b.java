package com.bytedance.android.live.initialize;

import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.android.live.initialize.scheduler.WTOSchedulerNotify;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskListener;
import com.bytedance.android.livesdkapi.init.LiveInitCostInfo;
import com.bytedance.android.livesdkapi.init.LiveInitTaskInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wa0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final C0204b a;
    public final a b;
    public final WTOSchedulerNotify c;
    public ILiveInitTaskListener d;

    public static final class a implements wa0.b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // wa0.b
        public final void a(com.bytedance.android.live.initialize.a r5) {
            if (r5 == null) goto L7;
            ILiveInitTaskListener r0 = this.a.d;
            if (r0 == null) goto L7;
            LiveInitCostInfo r1 = new LiveInitCostInfo(r5.b);
            r1.setDuration(r5.a);
            Unit r2 = Unit.INSTANCE;
            r0.onTaskScheduleEnd(r1);
        L7:
            if (Intrinsics.areEqual(r5, com.bytedance.android.live.initialize.a.i.c) == false) goto L12;
            ILiveInitTaskListener r6 = this.a.d;
            if (r6 == null) goto L13;
            r6.onAllTaskExecuteFinish();
            return;
        L13:
            return;
        }

        @Override // wa0.b
        public final void b(com.bytedance.android.live.initialize.a r3) {
            if (r3 == null) goto L9;
            String r4 = r3.b;
            if (r4 == null) goto L10;
            ILiveInitTaskListener r0 = this.a.d;
            if (r0 == null) goto L11;
            r0.onTaskScheduleStart(new LiveInitCostInfo(r4));
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.initialize.b$b, reason: collision with other inner class name */
    public static final class C0204b implements c {
        public final /* synthetic */ b a;

        public C0204b(b r1) {
            this.a = r1;
        }

        @Override // wa0.c
        public final void a(WTOTaskProxy r2) {
            Intrinsics.checkNotNullParameter(r2, "taskProxy");
            Intrinsics.checkNotNullParameter(r2, "taskProxy");
        }

        @Override // wa0.c
        public final void b(WTOTaskProxy r4) {
            Intrinsics.checkNotNullParameter(r4, "taskProxy");
            LiveInitTaskInfo r0 = new LiveInitTaskInfo();
            r0.setPeriodName(r4.k.taskExecutePeriod().b);
            r0.setName(r4.k.taskBusinessInfo());
            r0.setThreadId(r4.h);
            ILiveInitTaskListener r5 = this.a.d;
            if (r5 == null) goto L6;
            r5.onTaskStart(r0);
            return;
        }

        @Override // wa0.c
        public final void c(WTOTaskProxy r4) {
            Intrinsics.checkNotNullParameter(r4, "taskProxy");
            LiveInitTaskInfo r0 = new LiveInitTaskInfo();
            r0.setPeriodName(r4.k.taskExecutePeriod().b);
            r0.setName(r4.k.taskBusinessInfo());
            r0.setDuration(r4.j);
            ILiveInitTaskListener r5 = this.a.d;
            if (r5 == null) goto L6;
            r5.onTaskEnd(r0);
            return;
        }
    }

    public b(WTOSchedulerNotify r2, ILiveInitTaskListener r3) {
        Intrinsics.checkNotNullParameter(r2, "notify");
        this.c = r2;
        this.d = r3;
        C0204b r4 = new C0204b(this);
        this.a = r4;
        a r0 = new a(this);
        this.b = r0;
        r2.c(r4);
        r2.b(r0);
    }
}
