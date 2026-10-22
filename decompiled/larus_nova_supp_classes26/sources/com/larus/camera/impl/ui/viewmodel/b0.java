package com.larus.camera.impl.ui.viewmodel;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatService;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b0 implements Function2 {
    public /* synthetic */ b0() {
    }

    public final Object invoke(Object r3, Object r4) {
        String r5 = (String) r4;
        if (((Boolean) r3).booleanValue() == false) goto L11;
        if (r5.length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L11;
        t19.s r7 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        r7.getClass();
        t19.s.o(r1, 2131908983, false);
        IAIChatService.a.n7(r5);
        goto L11
    L7:
        r6 = false;
    L11:
        return Unit.INSTANCE;
    }
}
