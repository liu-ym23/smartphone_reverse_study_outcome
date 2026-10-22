package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements w91.c.a {
    public final /* synthetic */ View a;
    public final /* synthetic */ w91.f b;
    public final /* synthetic */ BaseTabFlipper c;
    public final /* synthetic */ w91.f d;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ d b;

        public a(View r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            View r0 = this.a;
            WeakReference<View> r1 = this.b.c.getDisplayView();
            if (r1 == null) goto L5;
            View r2 = r1.get();
        L6:
            boolean r3 = !Intrinsics.areEqual(r0, r2);
            int r4 = BaseTabFlipper.l;
            ALogger.d("BaseTabFlipper", "remove view onExitEnd.the view index:" + this.b.c.indexOfChild(this.a) + "， should release:" + r3);
            if (r3 == false) goto L10;
            BaseTabFlipper r5 = this.b.c;
            View r6 = this.a;
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "view");
            r5.k(r6);
            r6.clearAnimation();
            r5.removeViewInLayout(r6);
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L6
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

    @Override // w91.c.a
    public final void b() {
    }

    @Override // w91.c.a
    public final void a() {
        this.c.e(this.b, this.a);
    }

    @Override // w91.c.a
    public final void c() {
        w91.f r0 = this.d;
        if (r0 == null) goto L8;
        View r1 = r0.a();
        if (r1 == null) goto L9;
        this.c.post(new a(r1, this));
        return;
    L9:
        return;
    }

    @Override // w91.c.a
    public final void d() {
        this.c.setDisplayView(new WeakReference(this.a));
    }

    public d(View r1, w91.f r2, BaseTabFlipper r3, w91.f r4, w91.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
