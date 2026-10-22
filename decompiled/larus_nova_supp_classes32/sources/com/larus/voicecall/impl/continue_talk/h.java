package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ry8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ h(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatContinuousTalkComponent r0 = this.a;
        int r1 = ChatContinuousTalkComponent.M;
        Intrinsics.checkNotNullParameter((View) r4, "it");
        b r5 = r0.Y2();
        if (r5 == null) goto L9;
        g0 r6 = r5.C5();
        if (r6 == null) goto L9;
        boolean r2 = true;
        if (r6.getTtsContinuousTalkEnabled() != true) goto L9;
    L10:
        if (r2 == true) goto L13;
        t19.s r7 = t19.s.a;
        Context r3 = r0.getContext();
        String r8 = AppHost.a.getApplication().getString(2131901019);
        r7.getClass();
        t19.s.t(r3, r8);
    L13:
        return Unit.INSTANCE;
    L9:
        r2 = false;
        goto L10
    }
}
