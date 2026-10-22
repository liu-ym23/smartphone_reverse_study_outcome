package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements ViewTreeObserver.OnDrawListener {
    public static final /* synthetic */ int e = 0;
    public final Handler a;
    public boolean b;
    public final View c;
    public final Function0<Unit> d;

    public static final class a {
        public static f a(View r1, Function0 r2) {
            Intrinsics.checkNotNullParameter(r1, "$this$onNextDraw");
            Intrinsics.checkNotNullParameter(r2, "onDrawCallback");
            f r0 = new f(r1, r2);
            r1.getViewTreeObserver().addOnDrawListener(r0);
            return r0;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.c.getViewTreeObserver().isAlive() == false) goto L9;
            this.a.c.getViewTreeObserver().removeOnDrawListener(this.a);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        this.d.invoke();
        this.a.post(new b(this));
    }

    public f(View r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "onDrawCallback");
        this.c = r2;
        this.d = r3;
        this.a = new Handler(Looper.getMainLooper());
    }
}
