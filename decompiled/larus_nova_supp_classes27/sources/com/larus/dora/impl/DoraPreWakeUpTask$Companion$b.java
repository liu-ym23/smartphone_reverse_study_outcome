package com.larus.dora.impl;

import android.os.Handler;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraPreWakeUpTask$Companion$b implements IEffectPlatformBaseListener<String[]> {
    public final /* synthetic */ String a;

    public DoraPreWakeUpTask$Companion$b(String r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r4) {
        final String[] r5 = (String[]) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        Handler r0 = DoraPreWakeUpTask.j;
        final String r1 = this.a;
        r0.post(new p(r5, r1));
    }

    public final void onFail(Object r2, final ExceptionResult r3) {
        String[] r4 = (String[]) r2;
        Intrinsics.checkNotNullParameter(r3, "exception");
        DoraPreWakeUpTask.j.post(new q(r3));
    }
}
