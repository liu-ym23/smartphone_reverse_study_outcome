package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r6 implements ViewTreeObserver.OnDrawListener {
    public boolean a;
    public final /* synthetic */ q6 b;

    public static final class a implements Runnable {
        public final /* synthetic */ r6 a;

        public a(r6 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IInteractFeedView r0 = this.a.b.b;     // Catch: Throwable -> L11
            if ((r0 instanceof View) == true) goto L5;
            r0 = null;
        L5:
            View r1 = (View) r0;     // Catch: Throwable -> L11
            if (r1 == null) goto L14;
            ViewTreeObserver r2 = r1.getViewTreeObserver();     // Catch: Throwable -> L11
            if (r2 == null) goto L18;
            r2.removeOnDrawListener(this.a.b.h);     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        IInteractFeedView r0 = this.b.b;
        View r2 = null;
        if ((r0 instanceof View) == true) goto L5;
        r0 = null;
    L5:
        View r1 = (View) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getVisibility() != 0) goto L25;
        View r3 = this.b.b;
        if ((r3 instanceof View) == false) goto L13;
        r2 = r3;
    L13:
        View r4 = r2;
        if (r4 == null) goto L18;
        if (r4.getAlpha() != 0.0f) goto L18;
        return;
    L18:
        if (this.a == true) goto L27;
        this.a = true;
        ii1.a r5 = this.b.k;
        if (r5 == null) goto L22;
        r5.q();
    L22:
        com.bytedance.android.live.core.utils.i0.h(new a(this));
        return;
    L27:
        return;
    }

    public r6(q6 r1) {
        this.b = r1;
    }
}
