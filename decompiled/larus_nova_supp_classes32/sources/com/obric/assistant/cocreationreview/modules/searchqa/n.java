package com.obric.assistant.cocreationreview.modules.searchqa;

import com.obric.assistant.cocreationreview.s3;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ q a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ n(q r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        q r0 = this.a;
        Function1 r1 = this.b;
        LinkedHashSet<Function1<List<c0>, Unit>> r2 = r0.c;
        monitor-enter(r2);
        r0.c.remove(r1);     // Catch: Throwable -> L11
        int r3 = r0.c.size();     // Catch: Throwable -> L11
        monitor-exit(r2);
        int r4 = s3.a;
        s3.b("search_qa.repository.observe", "remove listeners=" + r3);
        if (r3 != 0) goto L10;
        r0.d();
    L10:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        throw th;
    }
}
