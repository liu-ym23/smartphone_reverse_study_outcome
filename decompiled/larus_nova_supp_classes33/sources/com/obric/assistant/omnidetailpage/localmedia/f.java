package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements Function1<String, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<String> a;
    public final /* synthetic */ Context b;

    public f(kotlinx.coroutines.j r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        String r5 = (String) r4;
        if (this.a.isActive() == false) goto L10;
        kotlinx.coroutines.i<String> r0 = this.a;
        if (r5 == null) goto L7;
        Context r1 = this.b;
        LocalMediaShareHelper.a.getClass();
        String r6 = LocalMediaShareHelper.a(r1, r5, true);
    L8:
        r0.resumeWith(Result.constructor-impl(r6));
        goto L10
    L7:
        r6 = null;
    L10:
        return Unit.INSTANCE;
    }
}
