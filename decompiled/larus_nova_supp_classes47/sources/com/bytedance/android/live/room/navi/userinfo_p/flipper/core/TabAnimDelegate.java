package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class TabAnimDelegate implements w91.d {
    public final String a;
    public final Lazy b;

    public static final class a implements w91.d.a {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @Override // w91.d.a
        public final boolean a(w91.d.b r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (r2.c == null) goto L5;
        L7:
            return false;
        L5:
            if (r2.b != 0) goto L7;
            return true;
        }
    }

    public static final class b implements w91.d.a {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }

        @Override // w91.d.a
        public final boolean a(w91.d.b r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (r2.c == null) goto L5;
        L7:
            return false;
        L5:
            if (r2.a != 1) goto L7;
            return true;
        }
    }

    public TabAnimDelegate() {
        this.a = "TabAnimDelegate";
        this.b = LazyKt.lazy(TabAnimDelegate$interceptors$2.INSTANCE);
    }

    @Override // w91.d
    public final boolean a(w91.d.b r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        List r0 = (List) this.b.getValue();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((w91.d.a) r1.next()).a(r4) == false) goto L9;
        boolean r5 = true;
    L15:
        return !r5;
    L13:
        r5 = false;
        goto L15
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // w91.d
    public final void b(w91.f r4, w91.f r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "enterHolder");
        Intrinsics.checkNotNullParameter(r6, "listener");
        f r0 = new f(this, r4, r6, r5);
        View r7 = null;
        if (r4 == null) goto L5;
        q91.a r1 = r4.c();
    L6:
        if (r4 == null) goto L8;
        r7 = r4.a();
    L8:
        q91.a r8 = r5.c();
        View r9 = r5.a();
        if (r7 == null) goto L11;
        r7.clearAnimation();
    L11:
        r9.clearAnimation();
        r8.e(r9, r0);
        c(false, r1, r7, r0);
        c(true, r8, r9, r0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void c(boolean r3, w91.c r4, View r5, f r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 != null) goto L28;
        return;
    L28:
        if (r3 == false) goto L11;
        Animation r1 = r4.d();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        if (r1 != null) goto L15;
        Context r2 = r5.getContext();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        r4.a();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        Animation r7 = AnimationUtils.loadAnimation(r2, -1);     // Catch: Exception -> L16 Resources.NotFoundException -> L18
    L27:
    L20:
        if (r7 == null) goto L22;
        r7.setAnimationListener(new g(r3, r6, r5));
        r5.startAnimation(r7);
        return;
    L22:
        if (r3 == false) goto L24;
        r6.d();
        r6.a();
    L25:
        Unit r8 = Unit.INSTANCE;
        return;
    L24:
        r6.b();
        r6.c();
        goto L25
    L15:
        r7 = r1;
        goto L27
    L11:
        r1 = r4.c();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        if (r1 != null) goto L15;
        Context r9 = r5.getContext();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        r4.b();     // Catch: Exception -> L16 Resources.NotFoundException -> L18
        r7 = AnimationUtils.loadAnimation(r9, -1);     // Catch: Exception -> L16 Resources.NotFoundException -> L18
    L18:
        ALogger.e(this.a, "解析动画文件出错");
    L19:
        r7 = null;
    L16:
        e = move-exception;
        ALogger.e(this.a, e);
        goto L19
    }
}
