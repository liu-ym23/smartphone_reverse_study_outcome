package com.bytedance.ai.debugscene;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.debugrouter.DebugRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class b1 implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ h1.c b;
    public final /* synthetic */ Function2 c;

    public /* synthetic */ b1(long r1, h1.c r10, Function2 r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final Object invoke(Object r10) {
        long r0 = this.a;
        h1.c r11 = this.b;
        Function2 r12 = this.c;
        Throwable r13 = (Throwable) r10;
        Intrinsics.checkNotNullParameter(r13, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        h1 r14 = h1.a;
        Long r1 = Long.valueOf(r0);
        r14.getClass();
        h1.l(r1);
        DebugRouter.getInstance().disableDebugChannel();
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "failed to open debug channel for " + r11.a + ": " + r13.getMessage());
        if (r12 == null) goto L9;
        Boolean r15 = Boolean.FALSE;
        String r16 = r13.getMessage();
        if (r16 != null) goto L7;
        r16 = "failed to open debug channel";
    L7:
        r12.invoke(r15, r16);
    L9:
        return Unit.INSTANCE;
    }
}
