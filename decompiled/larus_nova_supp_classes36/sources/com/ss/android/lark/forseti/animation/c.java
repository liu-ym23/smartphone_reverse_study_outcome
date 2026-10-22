package com.ss.android.lark.forseti.animation;

import android.animation.Animator;
import android.view.View;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends com.ss.android.lark.forseti.animation.a {
    public static final /* synthetic */ int c = 0;

    public static final class a {
        public a() {
        }

        public static c a(View r7, float r8) {
            int r0 = c.c;
            Intrinsics.checkNotNullParameter(r7, "view");
            b r1 = com.ss.android.lark.forseti.animation.a.b;
            ForsetiAnimator$Companion$createAnimator$1 r2 = ForsetiAnimator$Companion$createAnimator$1.INSTANCE;
            Intrinsics.checkNotNullParameter(r7, "view");
            Intrinsics.checkNotNullParameter(r2, "factory");
            b r3 = com.ss.android.lark.forseti.animation.a.b;
            boolean r4 = false;
            Animator r5 = null;
            if (r3 != null) goto L17;
        L12:
            com.ss.android.lark.forseti.animation.a r9 = (com.ss.android.lark.forseti.animation.a) r2.invoke(r5, Boolean.valueOf(r4));
            new WeakReference(r7);
            r9.getClass();
            return (c) r9;
        L17:
            r5 = r3.a.newInstance(new Object[]{0, Float.valueOf(r8)});     // Catch: Throwable -> L14
        L7:
            b r10 = com.ss.android.lark.forseti.animation.a.b;
            r10.getClass();
            r10.b.invoke(r5, new Object[]{r7});     // Catch: Throwable -> L10
        L11:
            r4 = true;
        L10:
            Log.e("AsyncHandler", "assignTarget failed.");
            goto L11
        }
    }

    static {
        new a();
    }

    public c(Animator r1, boolean r2) {
        super(r1);
    }
}
