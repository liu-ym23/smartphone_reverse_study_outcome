package com.bytedance.applog.priority;

import com.bytedance.applog.log.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e implements a {
    public final PriorityCallback a;

    public e(PriorityCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "priorityCallback");
        this.a = r2;
    }

    @Override // com.bytedance.applog.log.a
    public final void a(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a.printLog(2, "Priority-" + r3 + ": " + ((String) r4.invoke()));
    }

    @Override // com.bytedance.applog.log.a
    public final void b(String r3, Throwable r4, Function0<String> r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r5, "message");
        this.a.printLog(4, "Priority-" + r3 + ": " + ((String) r5.invoke()) + ", throwable: " + r4);
    }
}
