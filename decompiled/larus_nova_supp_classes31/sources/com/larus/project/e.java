package com.larus.project;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e implements IIMCallback<List<? extends OmniProject>> {
    public final /* synthetic */ kotlinx.coroutines.i<List<OmniProject>> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public e(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ProjectListDataSource", "getProject failed code=" + r4.getCode() + " msg=" + r4.getTips());
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<List<OmniProject>> r5 = this.a;
        Result.Companion r0 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("get project failed"))));
        return;
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
