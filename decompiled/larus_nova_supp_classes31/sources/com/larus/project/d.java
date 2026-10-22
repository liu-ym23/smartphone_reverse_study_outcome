package com.larus.project;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements IIMCallback<cd9.b> {
    public final /* synthetic */ kotlinx.coroutines.i<cd9.b> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public d(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ProjectListDataSource", "selectProjectList failed code=" + r4.getCode() + " msg=" + r4.getTips());
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<cd9.b> r5 = this.a;
        Result.Companion r0 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("select project list failed"))));
        return;
    }

    public final void onSuccess(Object r2) {
        cd9.b r3 = (cd9.b) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
