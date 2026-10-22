package com.ss.android.lark.flow.chat;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.foundation.toast.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;

    public a(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;     // Catch: Throwable -> L4
        int r1 = FlowToast.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L4
        f r2 = new f(r0);     // Catch: Throwable -> L4
        r2.setText(2131889967);     // Catch: Throwable -> L4
        r2.setIcon(2131235476);     // Catch: Throwable -> L4
        r2.show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
