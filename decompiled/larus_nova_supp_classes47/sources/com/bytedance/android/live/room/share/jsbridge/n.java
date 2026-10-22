package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements fa1.a.b {
    public final /* synthetic */ q a;
    public final /* synthetic */ CallContext b;

    @Override // fa1.a.b
    public final void b() {
        q.j(this.a, this.b, true, "");
    }

    public n(q r1, CallContext r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // fa1.a.b
    public final void a(String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "channel");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "btnText");
        Intrinsics.checkNotNullParameter(r7, "packageName");
        q r0 = this.a;
        CallContext r1 = this.b;
        r0.getClass();
        if (StringUtils.isEmpty(r4) == false) goto L5;
    L16:
        q.j(this.a, this.b, false, r4);
        return;
    L5:
        if (StringUtils.isEmpty(r5) == true) goto L16;
        if (StringUtils.isEmpty(r6) == true) goto L16;
        if (StringUtils.isEmpty(r7) == true) goto L16;
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1.getContext());
        r2.setMessage(r5);
        r2.setPositiveButton(r6, new o(r1, r7));
        r2.setNegativeButton(2131915442, p.a);
        AlertDialog r8 = r2.create();
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r8);
        goto L16
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L15:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L16
    }
}
