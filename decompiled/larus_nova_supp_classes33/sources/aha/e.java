package aha;

import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final jha.g<d> a(String r2, String r3) {
        if (r2 != null) goto L4;
        r2 = "unknown_session";
    L4:
        if (r3 != null) goto L6;
        r3 = "unknown_task";
    L6:
        c r0 = c.a;
        int r1 = com.obric.assistant.state.multitask.ext.f.a;
        return TaskFlowDslKt.b(r0, r2 + '#' + r3);
    }
}
