package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements View.OnLayoutChangeListener {
    public final /* synthetic */ DoubaoForwardFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ DoubaoForwardFragment a;
        public final /* synthetic */ View b;

        public a(DoubaoForwardFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DoubaoForwardFragment r0 = this.a;     // Catch: Throwable -> L4
            View r1 = this.b;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
            DoubaoForwardFragment.S90(r0, r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public q(DoubaoForwardFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r1.getVisibility() != 0) goto L6;
        r1.post(new a(this.a, r1));
        return;
    }
}
