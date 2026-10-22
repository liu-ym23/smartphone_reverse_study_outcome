package com.larus.voicecall.impl.component.bottom;

import android.view.View;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class w implements Function1 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ RealtimeBottomComponent b;

    public /* synthetic */ w(boolean r1, RealtimeBottomComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        boolean r0 = this.a;
        RealtimeBottomComponent r1 = this.b;
        View r5 = (RealtimeBottomMoreBtn) r4;
        int r2 = RealtimeBottomComponent.Q;
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r0 == false) goto L7;
        r1.getClass();
        com.larus.voicecall.impl.component.vlm.a r6 = (com.larus.voicecall.impl.component.vlm.a) s1a.d.a(r1).getAbility(com.larus.voicecall.impl.component.vlm.a.class);
        if (r6 == null) goto L11;
        r6.Yh(true, "click_share_screen");
    L11:
        return Unit.INSTANCE;
    L7:
        com.larus.voicecall.impl.component.window.b r3 = (com.larus.voicecall.impl.component.window.b) r1.z.getValue();
        if (r3 == null) goto L11;
        r3.oB(r5);
        goto L11
    }
}
