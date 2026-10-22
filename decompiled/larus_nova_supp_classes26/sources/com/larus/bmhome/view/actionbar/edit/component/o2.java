package com.larus.bmhome.view.actionbar.edit.component;

import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o2 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ TabSelectorWidget a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public o2(TabSelectorWidget r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r5) {
        com.larus.bmhome.actionbar.model.i0 r0 = TabSelectorWidget.i6(this.a);
        if (r0 == null) goto L18;
        List r1 = r0.a;
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L7:
        Object r3 = null;
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        Long r6 = ((com.larus.bmhome.actionbar.model.w) r4).a;
        if (r5 == null) goto L13;
        r3 = r5.getTag();
    L13:
        if (Intrinsics.areEqual(r6, r3) == false) goto L7;
        r3 = r4;
    L15:
        com.larus.bmhome.actionbar.model.w r7 = (com.larus.bmhome.actionbar.model.w) r3;
        if (r7 == null) goto L18;
        r7.s = 1;
    L18:
        com.larus.bmhome.actionbar.model.i0 r8 = TabSelectorWidget.i6(this.a);
        if (r8 == null) goto L27;
        com.larus.bmhome.view.actionbar.edit.c r9 = this.a.getViewModel();
        if (r9 == null) goto L28;
        r9.onTabSelected(r8);
        return;
    L28:
        return;
    }

    public final void onTabUnselected(TabLayout.Tab r5) {
        com.larus.bmhome.actionbar.model.i0 r0 = TabSelectorWidget.i6(this.a);
        if (r0 == null) goto L22;
        List r1 = r0.a;
        if (r1 == null) goto L23;
        Iterator r2 = r1.iterator();
    L7:
        Object r3 = null;
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        Long r6 = ((com.larus.bmhome.actionbar.model.w) r4).a;
        if (r5 == null) goto L13;
        r3 = r5.getTag();
    L13:
        if (Intrinsics.areEqual(r6, r3) == false) goto L7;
        r3 = r4;
    L15:
        com.larus.bmhome.actionbar.model.w r7 = (com.larus.bmhome.actionbar.model.w) r3;
        if (r7 == null) goto L24;
        r7.s = 0;
        return;
    L24:
        return;
    L23:
        return;
    }
}
