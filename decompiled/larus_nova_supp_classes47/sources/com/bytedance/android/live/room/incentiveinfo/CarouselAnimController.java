package com.bytedance.android.live.room.incentiveinfo;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CarouselAnimController {
    public final Lazy a;

    public static final class a {
    }

    public static final class b implements u81.a {
        public static final b a = null;

        public b() {
        }

        static {
            a = new b();
        }

        @Override // u81.a
        public final boolean a(u81.b r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (r2.c == null) goto L5;
        L7:
            return false;
        L5:
            if (r2.b != 0) goto L7;
            return true;
        }
    }

    public static final class c implements u81.a {
        public static final c a = null;

        public c() {
        }

        static {
            a = new c();
        }

        @Override // u81.a
        public final boolean a(u81.b r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (r2.c == null) goto L5;
        L7:
            return false;
        L5:
            if (r2.a != 1) goto L7;
            return true;
        }
    }

    static {
    }

    public CarouselAnimController() {
        this.a = LazyKt.lazy(CarouselAnimController$interceptors$2.INSTANCE);
    }

    public static void a(boolean r3, View r4, u81.e r5, com.bytedance.android.live.room.incentiveinfo.b r6) {
        if (r4 == null) goto L29;
        if (r5 != null) goto L27;
        return;
    L27:
        if (r3 == false) goto L10;
        Animation r2 = r5.d();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        if (r2 != null) goto L14;
        Context r7 = r4.getContext();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        r5.a();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        Animation r8 = AnimationUtils.loadAnimation(r7, -1);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L26:
    L19:
        if (r8 == null) goto L21;
        r8.setAnimationListener(new com.bytedance.android.live.room.incentiveinfo.a(r3, r6, r4));
        r4.startAnimation(r8);
        return;
    L21:
        if (r3 == false) goto L23;
        r6.d();
        r6.a();
    L24:
        Unit r9 = Unit.INSTANCE;
        return;
    L23:
        r6.b();
        r6.c();
        goto L24
    L14:
        r8 = r2;
        goto L26
    L10:
        r2 = r5.c();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        if (r2 != null) goto L14;
        Context r10 = r4.getContext();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        r5.b();     // Catch: Exception -> L15 Resources.NotFoundException -> L17
        r8 = AnimationUtils.loadAnimation(r10, -1);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L17:
        ALogger.e("CarouselAnimController", "解析动画文件出错");
    L18:
        r8 = null;
    L15:
        e = move-exception;
        ALogger.e("CarouselAnimController", e);
        goto L18
    }
}
