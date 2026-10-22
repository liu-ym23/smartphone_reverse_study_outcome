package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Runnable {
    public final /* synthetic */ View a;

    public a(View r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a;     // Catch: Throwable -> L14
        View r1 = r0.findViewById(R.id.statusBarBackground);     // Catch: Throwable -> L14
        if (r1 == null) goto L6;
        r1.setVisibility(8);     // Catch: Throwable -> L14
    L6:
        if ((r0 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r0;     // Catch: Throwable -> L14
    L9:
        if (r2 == null) goto L17;
        View r3 = r2.getChildAt(0);     // Catch: Throwable -> L14
        if (r3 == null) goto L21;
        r3.setPadding(0, 0, 0, 0);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L17:
        return;
    L8:
        r2 = null;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
