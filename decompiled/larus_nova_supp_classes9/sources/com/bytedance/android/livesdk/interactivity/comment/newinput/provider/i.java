package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements View.OnKeyListener {
    public final /* synthetic */ e.c a;

    public i(e.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r2, int r3, KeyEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        boolean r0 = false;
        if (66 == r3) goto L5;
    L13:
        return false;
    L5:
        if (1 != r4.getAction()) goto L13;
        StringBuilder r5 = new StringBuilder("Keycode Enter receive, panelBridge empty?");
        if (this.a.s.a != null) goto L9;
        r0 = true;
    L9:
        r5.append(r0);
        i40.h.c(r5.toString(), true);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6 = this.a.s.a;
        if (r6 == null) goto L12;
        r6.p0();
    L12:
        return true;
    }
}
