package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.os.Handler;
import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends d0 {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f.b c;
    public final /* synthetic */ String d;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void a() {
            l r0 = this.a;
            f.b(r0.a, r0.b, r0.c);
            int r1 = com.bytedance.android.livesdk.chatroom.utils.a.a;
            com.bytedance.android.livesdk.chatroom.utils.a.a(ActivityMonitor.ActivityStatusCode.SUCCESS.getCode(), Integer.valueOf(((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) this.a.a).d), String.valueOf(this.a.a.o), this.a.b);
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

    public final void a() {
        new Handler().post(new a(this));
        int r0 = com.bytedance.android.livesdk.chatroom.utils.a.a;
        int r1 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
        ActivityHybridMonitor.ContainerType r3 = ActivityHybridMonitor.ContainerType.LYNX;
        f r2 = this.a;
        com.bytedance.android.livesdk.chatroom.utils.a.c(r1, "onFallback", r3, ((com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a) r2).d, String.valueOf(r2.o), this.d);
    }

    public final void g(View r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        this.c.onLoadSuccess();
        this.a.l(true);
        com.bytedance.android.livesdk.chatroom.monitor.f r4 = this.a.k;
        if (r4 == null) goto L8;
        r4.d("ON_PAGE_FINISHED");
        if (r4.i != 2) goto L9;
        r4.g();
        return;
    L9:
        return;
    }

    public l(f r1, String r2, f.d r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
