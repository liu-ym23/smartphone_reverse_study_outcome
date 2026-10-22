package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.r;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q implements Function0 {
    public final /* synthetic */ r a;

    public /* synthetic */ q(r r1) {
        this.a = r1;
    }

    public final Object invoke() {
        File r1 = new PolarisFileWrapper(this.a.a());
        if (r1.exists() == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        r.f(r1);
    L9:
        return Unit.INSTANCE;
    }
}
