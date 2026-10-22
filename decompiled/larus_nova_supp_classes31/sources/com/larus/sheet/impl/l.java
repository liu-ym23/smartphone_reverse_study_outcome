package com.larus.sheet.impl;

import com.larus.common.apphost.AppHost;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements f09.a.b {
    public final /* synthetic */ SheetFragment a;

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
        AppHost.Companion r0 = AppHost.a;
        if ((!r0.a().g().isEmpty()) == true) goto L5;
        return;
    L5:
        if ((CollectionsKt.last(r0.a().g()) instanceof SheetActivity) == false) goto L9;
        int r1 = nw9.a.b;
        nw9.a.c("enter_background", Long.valueOf(System.currentTimeMillis() - nw9.a.a), this.a.t9());
        return;
    }

    public final void onAppForeground() {
        AppHost.Companion r0 = AppHost.a;
        if ((!r0.a().g().isEmpty()) == true) goto L5;
        return;
    L5:
        if ((CollectionsKt.last(r0.a().g()) instanceof SheetActivity) == false) goto L9;
        int r1 = nw9.a.b;
        nw9.a.a = System.currentTimeMillis();
        return;
    }

    public l(SheetFragment r1) {
        this.a = r1;
    }
}
