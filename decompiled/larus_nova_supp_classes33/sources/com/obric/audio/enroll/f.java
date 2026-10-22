package com.obric.audio.enroll;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.invoke();
            return true;
        }

        public a(View r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static void a(View r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "closure");
        if (r2.getViewTreeObserver().isAlive() == false) goto L6;
        r2.getViewTreeObserver().addOnPreDrawListener(new a(r2, r3));
        return;
    }
}
