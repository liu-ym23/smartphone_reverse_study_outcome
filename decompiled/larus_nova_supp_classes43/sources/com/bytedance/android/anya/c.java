package com.bytedance.android.anya;

import android.view.View;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c<STATE extends MVIState<?>, ACTION extends p> extends BaseMVIView<STATE, ACTION> {
    public STATE h;
    public int i;
    public boolean j;
    public final View k;

    public boolean r() {
        return false;
    }

    public final void p() {
        if (this.i != 0) goto L5;
        return;
    L5:
        if (this.j == true) goto L16;
        mb.c r0 = mb.a.a;
        String r1 = "ensureContentLoaded pos=" + this.i;
        mb.c r10 = mb.a.a;
        if (r10 == null) goto L10;
        r10.logD("ttlive_anya_vp", r1);
    L10:
        this.j = true;
        STATE r11 = this.h;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stateInstance");
    L13:
        c(new k(r11, m().f(), true));
        return;
    }

    public c(View r1) {
        this.k = r1;
        this.i = -1;
    }

    public final void q(boolean r10) {
        if (r() == true) goto L5;
    L10:
        STATE r1 = this.h;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stateInstance");
    L13:
        c(new k(r1, m().f(), r10));
        return;
    L5:
        if (this.i == 0) goto L10;
        if (this.j == true) goto L10;
    }
}
