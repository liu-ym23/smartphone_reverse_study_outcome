package com.obric.assistant.state.multitask;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.multitask.core.TaskDispatchResult;
import jha.l;
import jha.o;
import jha.q;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TaskFlowManager$a<S extends o> {
    public final l<S> a;
    public final q<S> b;
    public final CompletableDeferred<TaskDispatchResult> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TaskFlowManager$a) == true) goto L8;
        return false;
    L8:
        TaskFlowManager$a r6 = (TaskFlowManager$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "TaskCommand(handle=" + this.a + ", event=" + this.b + ", result=" + this.c + ')';
    }

    public TaskFlowManager$a(l<S> r2, q<S> r3, CompletableDeferred<TaskDispatchResult> r4) {
        Intrinsics.checkNotNullParameter(r2, "handle");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.RESULT);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
