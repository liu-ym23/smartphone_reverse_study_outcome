package com.bytedance.ai.debugscene;

import com.bytedance.ai.model.objects.Applet;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w implements Function0<Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<Applet> a;
    public final /* synthetic */ String b;

    public w(kotlinx.coroutines.j r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object invoke() {
        if (this.a.isActive() == false) goto L10;
        kotlinx.coroutines.i<Applet> r0 = this.a;
        com.bytedance.ai.resource.d0 r1 = AIDebugManager.d.get(this.b);
        if (r1 == null) goto L7;
        Applet r10 = r1.g(this.b);
    L8:
        r0.resumeWith(Result.constructor-impl(r10));
        goto L10
    L7:
        r10 = null;
    L10:
        return Unit.INSTANCE;
    }
}
