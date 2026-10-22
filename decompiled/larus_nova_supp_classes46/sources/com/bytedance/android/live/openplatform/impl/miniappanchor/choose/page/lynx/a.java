package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.lynx;

import android.view.View;
import com.bytedance.android.annie.lynx.f;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;
import lp0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends f {
    public final /* synthetic */ MiniAppChooseLynxFragment b;

    public a(MiniAppChooseLynxFragment r1) {
        this.b = r1;
        super(null);
    }

    public final void e(LynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        if (b.d(this.b.f) == false) goto L5;
        int r6 = 2;
    L6:
        no0.a.d(1, r6, 2, "0", "load success");
        mp0.a r7 = b.a(this.b.f);
        if (r7 == null) goto L10;
        mp0.a.c(r7, "success", null, "task", 6);
        return;
    L10:
        return;
    L5:
        r6 = 1;
        goto L6
    }

    public final void n(LynxView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.n(r2);
        mp0.a r3 = b.a(this.b.f);
        if (r3 == null) goto L6;
        r3.f(false);
        return;
    }

    public final void j(View r4, String r5, String r6) {
        super.j(r4, r5, r6);
        String r7 = "failed:" + r6;
        if (b.d(this.b.f) == false) goto L5;
        int r8 = 2;
    L6:
        no0.a.d(1, r8, 2, "-1", r7);
        mp0.a r9 = b.a(this.b.f);
        if (r9 == null) goto L9;
        r9.c = false;
    L9:
        mp0.a r10 = b.a(this.b.f);
        if (r10 == null) goto L15;
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        mp0.a.c(r10, "fail", r6, "task", 4);
        return;
    L15:
        return;
    L5:
        r8 = 1;
        goto L6
    }
}
