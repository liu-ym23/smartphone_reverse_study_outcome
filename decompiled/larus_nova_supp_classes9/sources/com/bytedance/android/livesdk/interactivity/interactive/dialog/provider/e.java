package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnKeyListener {
    public final /* synthetic */ a.b a;

    public e(a.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r1, int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (66 == r2) goto L5;
        return false;
    L5:
        if (1 != r3.getAction()) goto L12;
        k82.a r4 = this.a.t.a;
        if (r4 == null) goto L9;
        r4.x();
    L9:
        return true;
    L12:
        return false;
    }
}
