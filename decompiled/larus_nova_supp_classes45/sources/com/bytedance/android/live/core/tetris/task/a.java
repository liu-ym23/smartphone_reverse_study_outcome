package com.bytedance.android.live.core.tetris.task;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a implements y70.a {
    public final TaskState<a> a;
    public final String b;

    @Override // y70.a
    public final boolean isComplete() {
        return this.a.b();
    }

    @Override // y70.a
    public final String getId() {
        return this.b;
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.b = r2;
        this.a = new TaskState();
    }

    public final void a(y70.b<a> r4) {
        Intrinsics.checkNotNullParameter(r4, "taskStateListener");
        TaskState<a> r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "task");
        Intrinsics.checkNotNullParameter(r4, "taskStateListener");
        r1.a = this;
        TaskState.b r0 = new TaskState.b(r4);
        r1.b = r0;
        r0.d(this);
    }

    public final void b(boolean r4) {
        TaskState<a> r0 = this.a;
        if (r4 == false) goto L5;
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r5 = r0.d;
        TaskState.a.c r1 = TaskState.a.c.a;
        StateMachine.a r2 = StateMachine.c;
        r5.d(r1, null);
        return;
    L5:
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r6 = r0.d;
        TaskState.a.C0162a r3 = TaskState.a.C0162a.a;
        StateMachine.a r7 = StateMachine.c;
        r6.d(r3, null);
    }
}
