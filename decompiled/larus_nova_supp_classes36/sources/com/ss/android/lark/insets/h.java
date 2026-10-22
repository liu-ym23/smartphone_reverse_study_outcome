package com.ss.android.lark.insets;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class h extends c {
    public static final /* synthetic */ int q = 0;
    public final View o;
    public final WindowInsetsControllerCompat p;

    public static final class a {
        public static h a(Window r5) {
            Intrinsics.checkNotNullParameter(r5, "window");
            int r1 = i.a;
            Intrinsics.checkNotNullParameter(r5, "window");
            View r2 = r5.findViewById(R.id.content);
            if (r2 != null) goto L10;
            View r3 = r5.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L9;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r4 = ThreadMethodProxy.currentThread();
            if (r4 == com.larus.home.impl.utils.c.a) goto L9;
            com.larus.home.impl.utils.c.a(r4, "getDecorView");
        L9:
            r2 = r3.findViewById(R.id.content);
        L10:
            Object r6 = r2.getTag(2131362173);
            if ((r6 instanceof h) == false) goto L13;
            h r7 = (h) r6;
        L14:
            if (r7 != null) goto L19;
            r7 = new h(r5, r2);
            if (Build.VERSION.SDK_INT >= 35) goto L18;
            WindowCompat.setDecorFitsSystemWindows(r5, false);
        L18:
            WindowInsetsUtils.h(r5, r7);
            r2.setTag(2131362173, r7);
        L19:
            return r7;
        L13:
            r7 = null;
            goto L14
        }
    }

    static {
    }

    @Override // com.ss.android.lark.insets.c
    public final WindowInsetsControllerCompat u() {
        return this.p;
    }

    public h(Window r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "window");
        Intrinsics.checkNotNullParameter(r4, "contentRootView");
        this.o = r4;
        Intrinsics.checkNotNullParameter(r4, "targetView");
        BaseWindowInsetsHandler$createCoordinator$coordinator$1 r0 = new BaseWindowInsetsHandler$createCoordinator$coordinator$1(r4, this);
        this.p = WindowCompat.getInsetsController(r3, r4);
        Iterator<k> r5 = l.a.iterator();
        OnApplyWindowInsetsListener r6 = r0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r6 = r5.next().intercept();
        goto L4
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this.o, r6);
        this.o.requestApplyInsets();
        this.a = r0;
        WindowInsetsControllerCompat r7 = this.p;
        boolean r8 = false;
        if (r7 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        p(r9);
        WindowInsetsControllerCompat r10 = this.p;
        if (r10 != null) goto L15;
    L17:
        v(r8);
        return;
    L15:
        if (r10.isAppearanceLightStatusBars() != true) goto L17;
        r8 = true;
        goto L17
    L9:
        if (r7.isAppearanceLightNavigationBars() != true) goto L11;
        r9 = true;
        goto L12
    }
}
