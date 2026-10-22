package com.ss.android.lark.passport.flow.core.network.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@CodeHandlerAnno(code = 4402)
public final class AlertCodeHandler implements e {
    public AlertCodeHandler() {
    }

    @Override // com.ss.android.lark.passport.flow.core.network.handler.e
    public final boolean a(final Context r3, NetworkErrorResult r4) {
        if (r3 != null) goto L5;
    L19:
        return false;
    L5:
        if ((r3 instanceof Activity) == false) goto L19;
        if (r4 == null) goto L10;
        final String r5 = r4.getErrorMessage();
        if (r5 == null) goto L10;
    L12:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        Handler r0 = uyb.a.a;
        Function0<Unit> r1 = new AlertCodeHandler$handlerErrorWithContext$1(r3, r5);
        Intrinsics.checkNotNullParameter(r1, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L16;
        r1.invoke();
        return true;
    L16:
        uyb.a.a.post(new uyb.a.RunnableC0198a(r1));
        return true;
    L10:
        r5 = "";
        goto L12
    }
}
