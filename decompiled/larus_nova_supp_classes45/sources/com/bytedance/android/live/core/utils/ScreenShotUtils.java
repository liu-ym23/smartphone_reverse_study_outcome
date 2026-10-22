package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ScreenShotUtils {
    public static a a;

    public interface a {
        ILivePlayerClient currentClient();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ Function1 b;

        public b(Bitmap r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.invoke(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @JvmStatic
    public static final void b(Activity r7, final Function1<? super Bitmap, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (r7 == null) goto L13;
        final Window r2 = r7.getWindow();
        if (r2 == null) goto L13;
        final Bitmap r5 = Bitmap.createBitmap(a(r2).getWidth(), a(r2).getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas r4 = new Canvas(r5);
        a r9 = a;
        if (r9 == null) goto L9;
        ILivePlayerClient r11 = r9.currentClient();
    L10:
        if (r11 == null) goto L12;
        final ILivePlayerClient r3 = r11;
        r11.saveFrame(new ScreenShotUtils$shot$$inlined$run$lambda$1(r2, r3, r4, r5, r8));
        return;
    L12:
        a(r2).draw(r4);
        a(r2).post(new b(r5, r8));
        return;
    L9:
        r11 = null;
    L13:
        ALogger.w("ScreenShotUtils", "window为空，截屏失败");
    }
}
