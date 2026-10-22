package com.obric.assistant.activity_stack;

import android.app.Activity;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricActivityStackServiceImpl$c<T> implements Comparator {
    public final /* synthetic */ Map a;

    public ObricActivityStackServiceImpl$c(Map r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r5, T r6) {
        Long r7 = (Long) this.a.get((Activity) r5);
        long r0 = 0;
        if (r7 == null) goto L5;
        long r2 = r7.longValue();
    L6:
        Long r8 = Long.valueOf(r2);
        Long r9 = (Long) this.a.get((Activity) r6);
        if (r9 == null) goto L10;
        r0 = r9.longValue();
    L10:
        return ComparisonsKt.compareValues(r8, Long.valueOf(r0));
    L5:
        r2 = 0;
        goto L6
    }
}
