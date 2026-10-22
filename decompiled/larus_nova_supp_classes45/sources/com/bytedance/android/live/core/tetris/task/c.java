package com.bytedance.android.live.core.tetris.task;

import com.bytedance.android.live.core.utils.StateMachine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements y70.a {
    public final TaskState<c> a;
    public final HashMap<String, a> b;
    public final b c;
    public final String d;

    @Override // y70.a
    public final boolean isComplete() {
        return this.a.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<Map.Entry<String, a>> r0 = this.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, a> r1 = r0.next();
        r1.getValue().a(this.c);
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r2 = r1.getValue().a.d;
        TaskState.a.b r3 = TaskState.a.b.a;
        StateMachine.a r4 = StateMachine.c;
        r2.d(r3, null);
        goto L4
    }

    @Override // y70.a
    public final String getId() {
        return this.d;
    }

    public static final void a(c r2) {
        HashMap<String, a> r0 = r2.b;
        if (r0.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, a>> r1 = r0.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (r1.next().getValue().isComplete() == true) goto L7;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L18;
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r4 = r2.a.d;
        TaskState.a.c r5 = TaskState.a.c.a;
        StateMachine.a r6 = StateMachine.c;
        r4.d(r5, null);
        return;
    L18:
        return;
    L11:
        r3 = true;
        goto L12
    }

    public c(String r3, com.bytedance.android.livesdk.widget.schedule.a.b r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "taskStateListener");
        this.d = r3;
        TaskState<c> r5 = new TaskState();
        this.a = r5;
        Intrinsics.checkNotNullParameter(this, "task");
        Intrinsics.checkNotNullParameter(r4, "taskStateListener");
        r5.a = this;
        TaskState.b r0 = new TaskState.b(r4);
        r5.b = r0;
        r0.d(this);
        this.b = new HashMap();
        this.c = new b(this);
    }
}
