package com.obric.matrix.platform.sdk.ones.dataanalysis;

import gka.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ MatrixTeaManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;

    public /* synthetic */ c(MatrixTeaManager r1, String r2, JSONObject r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MatrixTeaManager r0 = this.a;
        String r1 = this.b;
        JSONObject r2 = this.c;
        JSONObject r3 = this.d;
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$eventName");
        Intrinsics.checkNotNullParameter(r2, "$copyJson");
        Intrinsics.checkNotNullParameter(r3, "$jsonObject");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        IDataService r5 = r0.c;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r5.onEvent(r1, r2.toString());     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r7) == null) goto L17;
        r0.h.add(new MatrixTeaManager.b(r1, r3));
        b.b("MatrixTeaManager", "onEvent error");
        return;
    L17:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
