package com.obric.assistant.component;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class z6 implements Function1 {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ z6(FragmentActivity r1, u6 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        FragmentActivity r0 = this.a;
        final Function0 r1 = this.b;
        int r2 = OrionInstructionComponent.p1;
        if (Intrinsics.areEqual((Boolean) r5, Boolean.TRUE) == false) goto L11;
        com.obric.assistant.t1.a.setAutoImageUploadEnabled(true);
        View r6 = r0.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L9:
        r6.post(new a7(r1));
    L11:
        return Unit.INSTANCE;
    }
}
