package com.larus.bmhome.chat.manager;

import com.larus.bmhome.view.screenmenu.ScreenMenuLayout;
import com.larus.bmhome.view.screenmenu.x0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z implements Function0<Unit> {
    public final /* synthetic */ x0 a;

    public z(x0 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ScreenMenuLayout r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.setMenuMask(false);
    L6:
        return Unit.INSTANCE;
    }
}
