package com.obric.miniapp.lynx;

import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u1 implements OBottomNavActionBar.c {
    public final /* synthetic */ LynxOUIBottomNavigationBarUI a;
    public final /* synthetic */ OBottomNavActionBar b;

    public final void a(int r1) {
    }

    public final void onSelect(int r6) {
        LynxOUIBottomNavigationBarUI r0 = this.a;
        OBottomNavActionBar r1 = this.b;
        int r2 = LynxOUIBottomNavigationBarUI.f;
        r0.N(r1);
        LynxOUIBottomNavigationBarUI r3 = this.a;
        if (r3.e == false) goto L5;
        return;
    L5:
        String r4 = (String) CollectionsKt.getOrNull(r3.c, r6);
        LynxContext r5 = r3.getLynxContext();
        if (r5 == null) goto L15;
        EventEmitter r7 = r5.getEventEmitter();
        if (r7 == null) goto L16;
        m7a.a r8 = new m7a.a(r3.getSign(), "change");
        r8.a("index", Integer.valueOf(r6));
        r8.a("value", Integer.valueOf(r6));
        if (r4 == null) goto L13;
        r8.a("title", r4);
    L13:
        r7.sendCustomEvent(r8);
        return;
    L16:
        return;
    }

    public u1(LynxOUIBottomNavigationBarUI r1, OBottomNavActionBar r2) {
        this.a = r1;
        this.b = r2;
    }
}
