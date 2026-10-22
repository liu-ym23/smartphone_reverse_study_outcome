package com.bytedance.android.livesdk.interactivity.textmessage.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function0 c;

    public b(View r1, long r2, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = this.a.getTag(2131389787);     // Catch: Throwable -> L10
        if ((r0 instanceof f) == false) goto L13;
        T r1 = ((f) r0).b;     // Catch: Throwable -> L10
        if (r1 == 0) goto L17;
        long r2 = r1.getMessageId();     // Catch: Throwable -> L10
        if (this.b == r2) goto L18;
        this.c.invoke();     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
