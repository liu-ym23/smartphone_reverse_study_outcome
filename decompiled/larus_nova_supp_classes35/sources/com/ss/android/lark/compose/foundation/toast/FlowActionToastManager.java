package com.ss.android.lark.compose.foundation.toast;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowActionToastManager {
    public static Handler a;
    public static final LinkedList<a> b = null;
    public static final Lazy c = null;

    public static final class a {
        public final b a;
        public final int b;

        public final int hashCode() {
            return this.b;
        }

        public a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "toast");
            this.a = r2;
            this.b = r2.hashCode();
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 == null) goto L8;
            Class<?> r2 = r4.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.compose.foundation.toast.FlowActionToastManager.ToastInfo");
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r2 = null;
            goto L10
        }
    }

    public FlowActionToastManager() {
    }

    static {
        b = new LinkedList();
        c = LazyKt.lazy(FlowActionToastManager$activityLifecycleCallbacks$2.INSTANCE);
    }

    public static void b() {
        LinkedList<a> r0 = b;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        a r1 = r0.getFirst();
        b r2 = r1.a;
        if (r2.b != 2) goto L8;
        return;
    L8:
        Handler r4 = null;
        if (r2.a.isFinishing() == false) goto L11;
    L14:
        Handler r3 = a;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L18:
        r4.sendEmptyMessageDelayed(r1.b, r2.i);
        return;
    L17:
        r4 = r3;
        goto L18
    L11:
        if (r2.a.isDestroyed() == true) goto L14;
        r2.d.b();
        WindowManager.LayoutParams r5 = new WindowManager.LayoutParams();
        r5.width = -2;
        r5.height = -2;
        r5.type = 2;
        r5.format = 1;
        r5.flags = 8;
        r5.gravity = r2.f;
        r5.x = r2.g;
        r5.y = r2.h;
        WindowManager r6 = r2.c;
        UDShadowLayout r7 = r2.e;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r7, r5);
        r6.addView(r7, r5);
        r2.b = 2;
        i r8 = r2.d;
        r8.b.a.setAlpha(0.0f);
        ViewPropertyAnimator r9 = r8.b.a.animate().setDuration(200).alpha(1.0f).setListener(new j(null, r8, null));
        r9.start();
        r8.c = r9;
        goto L14
    }

    public static final void a(Activity r5) {
    L2:
        LinkedList<a> r0 = b;
        if ((!r0.isEmpty()) == false) goto L13;
        a r1 = r0.getFirst();
        b r2 = r1.a;
        if (Intrinsics.areEqual(r2.a, r5) == false) goto L18;
        if (r2.b != 2) goto L12;
        r2.b();
        Handler r3 = a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        r3 = null;
    L11:
        r3.removeMessages(r1.b);
    L12:
        r0.remove(r1);
        goto L2
    L18:
        return;
    }
}
