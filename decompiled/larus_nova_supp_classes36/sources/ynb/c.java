package ynb;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void a() {
        View r0 = this.a.d;
        View r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r0 = null;
    L6:
        if (r0.getVisibility() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        View r3 = this.a.d;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r3 = null;
    L14:
        int r4 = r3.getHeight();
        if (r4 > 0) goto L18;
        r4 = UIHelper.dp2px(24.0f);
    L18:
        float r5 = r4;
        View r6 = this.a.d;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r6 = null;
    L21:
        r6.setTranslationY(r5);
        View r7 = this.a.d;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L25:
        r1.animate().translationY(0.0f).alpha(1.0f).setDuration(220).setInterpolator(new DecelerateInterpolator()).start();
        return;
    L24:
        r1 = r7;
        goto L25
    L8:
        r2 = false;
        goto L9
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
