package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements Runnable {
    public final /* synthetic */ i.c a;

    public k(i.c r1) {
        this.a = r1;
    }

    public final void a() {
        WelfareAnchorServiceWidget r0 = this.a.a.a;
        Context r1 = ((Widget) r0).context;
        if (r1 == null) goto L7;
        lm3.d.a r2 = new lm3.d.a(r1);
        r2.b = r1.getString(2131922064);
        lm3.c r4 = new lm3.c();
        r4.b = r1.getString(2131915442);
        r4.c = lm3.c.a.a;
        Unit r5 = Unit.INSTANCE;
        lm3.c r6 = new lm3.c();
        r6.b = r1.getString(2131922063);
        r6.c = new q(r0);
        r2.e = CollectionsKt.listOf(new lm3.c[]{r4, r6});
        r2.a();
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
