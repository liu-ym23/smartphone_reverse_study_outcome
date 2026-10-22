package com.larus.call_plugins_doubao_common.manager;

import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.v0;
import com.larus.platform.service.v1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    static {
    }

    public static void a(String r3, Function0 r4, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r4, "onIdle");
        Intrinsics.checkNotNullParameter(r5, "onAllEnd");
        Intrinsics.checkNotNullParameter(r6, "onOccupied");
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.K0();
        Boolean r1 = Boolean.valueOf(com.larus.music.i.a.h());
    L6:
        boolean r2 = false;
        if (com.larus.media.o.a() == false) goto L14;
        v0 r7 = (v0) v1.a.getValue();
        if (r7 == null) goto L14;
        if (r7.a(r3) == true) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
    L20:
        v0 r9 = (v0) v1.a.getValue();
        if (r9 == null) goto L23;
        r2 = r9.b(r3);
    L23:
        if (r2 == true) goto L25;
    L27:
        r6.invoke();
        return;
    L25:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L27;
        r5.invoke();
        return;
    L17:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L20;
        r4.invoke();
        return;
    L14:
        r8 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }
}
