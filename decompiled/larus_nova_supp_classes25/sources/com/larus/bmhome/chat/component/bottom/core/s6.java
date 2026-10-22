package com.larus.bmhome.chat.component.bottom.core;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.h4;
import com.larus.bmhome.chat.i4;
import com.larus.im.bean.bot.BotModel;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s6 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ s6(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        CoreInputComponent r0 = this.a;
        nq9.b r5 = (nq9.b) r4;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter(r5, "it");
        BotModel r2 = r0.k4().q();
        if (r2 == null) goto L5;
        String r3 = r2.getBotId();
    L7:
        if (Intrinsics.areEqual(r3, r5.a) == false) goto L21;
        FLogger.a.d("CoreInputComponent", "receive BgUpdateFlow");
        Intrinsics.checkNotNullParameter(r0, "<this>");
        FragmentActivity r6 = a.b(r0, r0).getActivity();
        if ((r6 instanceof h4) == true) goto L20;
        if (r6 == null) goto L20;
        if ((r6 instanceof i4) == false) goto L17;
        r0.V6();
        goto L20
    L17:
        if (r0.f1().C() == false) goto L20;
        r0.V6();
    L20:
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L5:
        r3 = null;
        goto L7
    }
}
