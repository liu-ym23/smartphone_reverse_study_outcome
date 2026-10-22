package com.bytedance.android.live.ktv.common.ordersong.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Runnable {
    public final /* synthetic */ SongTextSwitcher a;

    public a(SongTextSwitcher r1) {
        this.a = r1;
    }

    public final void a() {
        SongTextSwitcher r0 = this.a;
        if (r0.g == true) goto L5;
        return;
    L5:
        if (r0.h == true) goto L17;
        c90.a r1 = r0.d;
        if (r1 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
    L9:
        c90.a r2 = this.a.d;
        if (r2 == null) goto L12;
        r2.g();
    L12:
        SongTextSwitcher r3 = this.a;
        r3.g = false;
        r3.h = false;
        Function1<Boolean, Unit> r4 = r3.getOnWindowStateListener();
        if (r4 == null) goto L18;
        Unit r5 = (Unit) r4.invoke(Boolean.TRUE);
        return;
    L18:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
