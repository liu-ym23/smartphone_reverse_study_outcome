package com.larus.bmhome.chat.helper;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements IIMCallback<wc9.e> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ kotlinx.coroutines.i<wc9.e> b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.b.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r5) {
        wc9.e r6 = (wc9.e) r5;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("createLocalSubCov: useTaskTitle=");
        r1.append(this.a);
        r1.append(", isLocal=");
        Boolean r2 = null;
        if (r6 == null) goto L5;
        Integer r3 = r6.f;
    L6:
        r1.append(r3);
        r1.append(", isDefaultName=");
        if (r6 == null) goto L9;
        r2 = Boolean.valueOf(r6.g());
    L9:
        r1.append(r2);
        r0.i("ChatRouterHelper", r1.toString());
        this.b.resumeWith(Result.constructor-impl(r6));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public a(boolean r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
