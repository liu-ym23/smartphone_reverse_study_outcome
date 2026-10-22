package com.obric.assistant.component;

import androidx.fragment.app.Fragment;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class l1 implements Function1 {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ l1(ObricIntercomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8) {
        ObricIntercomComponent r0 = this.a;
        boolean r9 = ((Boolean) r8).booleanValue();
        int r1 = ObricIntercomComponent.h1;
        r0.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(a.b(r0, r0));     // Catch: Throwable -> L5
    L7:
        ex8.a r4 = null;
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        Fragment r5 = (Fragment) r3;
        if (r5 != null) goto L13;
        FLogger.a.i("OrionIntercomComponent", "getSafeHostFragment null, from = suggestActionBarCallback");
    L13:
        FLogger.a.i("OrionIntercomComponent", "isNotMainBotPage " + r0.X + ' ' + r5);
        if (r5 != null) goto L17;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L29;
        if ((r5 instanceof ex8.a) == false) goto L26;
        r4 = (ex8.a) r5;
    L26:
        if (r4 == null) goto L29;
        r4.bS(r9);
    L29:
        return Unit.INSTANCE;
    L17:
        if (r0.X == false) goto L21;
        if ((r5 instanceof xe8.a) == true) goto L21;
        r6 = true;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
