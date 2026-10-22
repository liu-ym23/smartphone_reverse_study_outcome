package com.ss.android.lark.keyboard.biz.voice.inject;

import android.content.Context;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Context b;

    public b(a r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L4
        Context r1 = this.b;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        FlowToast.a r2 = new FlowToast.a(r1);     // Catch: Throwable -> L4
        r2.e(2131892124);     // Catch: Throwable -> L4
        r2.c = UDIconUtils.getIconDrawable(r2.a, 2131235476);     // Catch: Throwable -> L4
        r2.c(49, 0, UIHelper.dp2px(44.0f));     // Catch: Throwable -> L4
        r2.a().show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
