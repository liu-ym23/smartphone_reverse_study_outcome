package com.ss.android.lark.framework.assembly.logger;

import android.content.Context;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.f;
import com.ss.android.lark.utils.o0;
import se6.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements f.c {
    public final /* synthetic */ InitLogTask a;
    public final /* synthetic */ Context b;

    public c(InitLogTask r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.log.f.c
    public final boolean isEnable() {
        InitLogTask r0 = this.a;
        Context r1 = this.b;
        boolean r3 = true;
        if (r0.c == false) goto L6;
    L12:
        return r3;
    L6:
        if (o0.c(r1) == false) goto L9;
        r3 = false;
    L11:
        r0.c = r3;
        goto L12
    L9:
        if (z.e(r1) == false) goto L11;
        r3 = q.b;
        goto L11
    }
}
