package com.ss.android.lark.passportc.internal;

import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements Action {
    public final /* synthetic */ Function1<List<h>, Unit> a;
    public final /* synthetic */ List<h> b;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Function1<? super List<h>, Unit> r1, List<h> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        Function1<List<h>, Unit> r0 = this.a;
        List<h> r1 = this.b;
        Intrinsics.checkNotNull(r1);
        r0.invoke(r1);
    }
}
