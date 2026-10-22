package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.app.Application;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.component.widget.floatingpanel.impl.container.FloatingPanelTopPageViewContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements h {
    public final c a;

    @Override // yoc.h
    public final void G6() {
        c r0 = this.a;
        r0.getClass();
        Log.i("FloatingPanelPresenter", "collapseCardList");
        r0.c().c();
    }

    @Override // yoc.h
    public final int c8() {
        c r0 = this.a;
        r0.getClass();
        Log.i("FloatingPanelPresenter", "getCardCount");
        List r1 = CollectionsKt.toList(r0.f);
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L19;
        if (((FloatingCardItem) r2.next()).f != 2131389017) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L9;
        r3 = r3 + 1;
        if (r3 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r4 = false;
        goto L14
    L19:
        return r3;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return 0;
    }

    public a() {
        FloatingPanelTopPageViewContainer r0 = new FloatingPanelTopPageViewContainer(LarkContext.getApplication());
        Application r1 = LarkContext.getApplication();
        int r2 = com.larksuite.framework.utils.autoscale.a.a;
        this.a = new c(r1, r0, new e());
    }

    @Override // yoc.h
    public final void ra(yoc.c r7) {
        Intrinsics.checkNotNullParameter(r7, "card");
        final c r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "card");
        Log.i("FloatingPanelPresenter", "showCard, id: " + r7.getId());
        int r0 = FloatingCardItem.h;
        String r2 = FloatingCardItem.a.a(r7);
        Iterator r3 = ((ArrayList) r1.f).iterator();
        final int r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((FloatingCardItem) r3.next()).e, r2) == true) goto L10;
        r5 = r5 + 1;
    L10:
        if (r5 >= 0) goto L13;
        final FloatingCardItem<?> r6 = new FloatingCardItem(r7, r1.a);
        r1.d(r6);
        ListProtector.add(r1.f, 0, r6);
        r1.k(new FloatingPanelPresenter$showCardInner$2(r1, r6, r4));
    L13:
        Long r8 = FloatPanelHitPoint.a;
        FloatPanelHitPoint.b(1, ((ArrayList) r1.f).size());
        return;
    L9:
        r5 = -1;
        goto L10
    }

    @Override // yoc.h
    public final void y2(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        this.a.h(r2, r3);
    }
}
