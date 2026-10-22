package com.bytedance.android.live.room.navi.userinfo_p.element;

import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements Runnable {
    public final /* synthetic */ UserInfoFlipTabElement a;

    public g(UserInfoFlipTabElement r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UserInfoFlipTabElement r0 = this.a;     // Catch: Throwable -> L8
        int r1 = UserInfoFlipTabElement.o;     // Catch: Throwable -> L8
        if (r0.c.a() == false) goto L11;
        LivePopupWindow r2 = this.a.k;     // Catch: Throwable -> L8
        if (r2 == null) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);     // Catch: Throwable -> L8
        r2.dismiss();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
