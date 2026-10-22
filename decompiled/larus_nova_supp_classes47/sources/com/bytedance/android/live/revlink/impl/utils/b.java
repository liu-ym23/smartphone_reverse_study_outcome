package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final ld.a a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final boolean a() {
        ld.a r0 = this.a;
        UILayout r1 = null;
        if (r0 == null) goto L7;
        NextLiveData r2 = r0.getCleanMode();
        if (r2 == null) goto L7;
        Integer r3 = (Integer) r2.getValue();
    L9:
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).b(vr2.a.class);
        Intrinsics.checkNotNull(r6);
        boolean r7 = ((com.bytedance.live.kmp.core.c) r6).zh();
        if (r4 == false) goto L28;
        if (r7 == false) goto L29;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r9 = r8.getMultiLinkUtil();
    L22:
        if (r9 == null) goto L25;
        r1 = r9.b();
    L25:
        if (r1 == UILayout.FULL) goto L30;
        return true;
    L30:
        return false;
    L21:
        r9 = null;
        goto L22
    L29:
        return false;
    L28:
        return false;
    L12:
        if (r3.intValue() != 13) goto L14;
        r4 = true;
    L7:
        r3 = null;
        goto L9
    }

    public final boolean b() {
        ld.a r0 = this.a;
        UILayout r1 = null;
        if (r0 == null) goto L7;
        NextLiveData r2 = r0.getCleanMode();
        if (r2 == null) goto L7;
        Integer r3 = (Integer) r2.getValue();
    L9:
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).b(vr2.a.class);
        Intrinsics.checkNotNull(r6);
        boolean r7 = ((com.bytedance.live.kmp.core.c) r6).zh();
        if (r4 == false) goto L28;
        if (r7 == false) goto L29;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r9 = r8.getMultiLinkUtil();
    L22:
        if (r9 == null) goto L25;
        r1 = r9.b();
    L25:
        if (r1 == UILayout.FULL) goto L30;
        return true;
    L30:
        return false;
    L21:
        r9 = null;
        goto L22
    L29:
        return false;
    L28:
        return false;
    L12:
        if (r3.intValue() != 2) goto L14;
        r4 = true;
    L7:
        r3 = null;
        goto L9
    }

    public b(ld.a r1, LinkFakeGlobalService r2) {
        this.a = r1;
        this.b = r2;
    }
}
