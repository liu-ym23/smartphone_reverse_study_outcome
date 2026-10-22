package com.obric.miniapp.aibridge;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ i(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        f3.h r0 = this.a;
        JSONObject r5 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(AbsIntentCardOperationMethodIDL.b.class, "<this>");
        AbsIntentCardOperationMethodIDL.b r1 = k3.c.a(AbsIntentCardOperationMethodIDL.b.class);
        r1.setResult(r5.toString());
        f3.h.a.b(r0, r1);
        return Unit.INSTANCE;
    }
}
