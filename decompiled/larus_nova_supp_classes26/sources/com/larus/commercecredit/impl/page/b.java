package com.larus.commercecredit.impl.page;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ BaseCommerceCreditFragment a;

    public /* synthetic */ b(BaseCommerceCreditFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final BaseCommerceCreditFragment r0 = this.a;
        int r1 = BaseCommerceCreditFragment.e;
        Dialog r2 = r0.getDialog();     // Catch: Throwable -> L18 Exception -> L20
        if (r2 == null) goto L25;
        View r3 = r2.findViewById(2131368870);     // Catch: Throwable -> L18 Exception -> L20
        if (r3 == null) goto L25;
        T r4 = r0.d;     // Catch: Throwable -> L18 Exception -> L20
        if (r4 == 0) goto L25;
        View r5 = r4.getRoot();     // Catch: Throwable -> L18 Exception -> L20
        if (r5 == null) goto L25;
        int r6 = r0.U90();     // Catch: Throwable -> L18 Exception -> L20
        if (r6 <= 0) goto L25;
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();     // Catch: Throwable -> L18 Exception -> L20
        r7.height = r6;     // Catch: Throwable -> L18 Exception -> L20
        r3.setLayoutParams(r7);     // Catch: Throwable -> L18 Exception -> L20
        final BottomSheetBehavior r8 = BottomSheetBehavior.from(r3);     // Catch: Throwable -> L18 Exception -> L20
        r8.setPeekHeight(r6);     // Catch: Throwable -> L18 Exception -> L20
        r3.requestLayout();     // Catch: Throwable -> L18 Exception -> L20
        r5.requestLayout();     // Catch: Throwable -> L18 Exception -> L20
        new Handler(Looper.getMainLooper()).post(new d(r8, r0));     // Catch: Throwable -> L18 Exception -> L20
    L25:
        r0.W90();
        return;
    L20:
        T r9 = r0.d;     // Catch: Throwable -> L18
        if (r9 == 0) goto L25;
        View r10 = r9.getRoot();     // Catch: Throwable -> L18
        if (r10 == null) goto L25;
        r10.requestLayout();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r0.W90();
        throw th;
    }
}
