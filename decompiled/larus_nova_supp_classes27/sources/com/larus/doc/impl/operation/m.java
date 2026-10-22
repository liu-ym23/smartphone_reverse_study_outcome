package com.larus.doc.impl.operation;

import com.larus.utils.logger.FLogger;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements n39.e {
    public final /* synthetic */ kotlinx.coroutines.i<Integer> a;

    @Override // n39.e
    public final void a() {
        FLogger.a.i("DocOpManager", "delete success v2: " + System.currentTimeMillis());
        kotlinx.coroutines.i<Integer> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(3));
    }

    @Override // n39.e
    public final void b() {
        kotlinx.coroutines.i<Integer> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(1));
    }

    public m(kotlinx.coroutines.j r1) {
        this.a = r1;
    }
}
