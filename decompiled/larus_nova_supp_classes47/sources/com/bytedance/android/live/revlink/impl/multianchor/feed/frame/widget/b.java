package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget;

import android.view.View;
import android.widget.FrameLayout;
import b31.d;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.c;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.e;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final d a;
    public View b;
    public final FrameLayout c;

    public b(FrameLayout r1) {
        this.c = r1;
        this.a = new d();
    }

    public final void a(e r5) {
        Intrinsics.checkNotNullParameter(r5, "layoutState");
        Boolean r0 = r5.a;
        if (r0 == null) goto L22;
        r0.booleanValue();
        c r1 = r5.f;
        if (r1 == null) goto L23;
        s r2 = r1.b;
        if (r2 == null) goto L28;
        f r3 = r5.d;
        if (r3 == null) goto L24;
        Integer r4 = r3.b;
        if (r4 == null) goto L25;
        int r6 = r4.intValue();
        b31.e r7 = r5.b;
        if (r7 == null) goto L26;
        int r8 = r7.e;
        int r9 = r7.f;
        this.a.getClass();
        b31.a r10 = d.a(r2, r6, r8, r9);
        if (r10 == null) goto L27;
        View r12 = this.b;
        if (r12 != null) goto L20;
        return;
    L20:
        b31.c.b(r12, r10);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L28:
        return;
    L23:
        return;
    }
}
