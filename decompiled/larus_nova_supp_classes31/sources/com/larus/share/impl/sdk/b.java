package com.larus.share.impl.sdk;

import android.content.Context;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ b(Context r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6) {
        Context r0 = this.a;
        Function1 r1 = this.b;
        int r7 = ((Integer) r6).intValue();
        Set r2 = SharePanelService.b;
        if (r7 != 2) goto L5;
        s.a.g(r0, 2131909350, false);
    L5:
        if (r1 == null) goto L8;
        r1.invoke(Integer.valueOf(r7));
    L8:
        return Unit.INSTANCE;
    }
}
