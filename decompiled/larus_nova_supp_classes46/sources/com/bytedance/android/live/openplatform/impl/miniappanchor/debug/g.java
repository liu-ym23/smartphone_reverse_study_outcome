package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ OpenPlatformDebugFloatBall a;

    public g(OpenPlatformDebugFloatBall r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.ImageView, com.bytedance.android.live.openplatform.impl.miniappanchor.debug.OpenPlatformDebugFloatBall, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ?? r4 = this.a;
        int r0 = OpenPlatformDebugFloatBall.b;
        r4.getClass();
        DebugMenuDialog r1 = new DebugMenuDialog(r4.getContext(), r4.a);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }
}
