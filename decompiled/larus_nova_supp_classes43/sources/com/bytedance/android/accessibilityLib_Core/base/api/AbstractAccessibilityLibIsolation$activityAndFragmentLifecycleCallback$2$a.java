package com.bytedance.android.accessibilityLib_Core.base.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.bytedance.android.accessibilityLib_Core.helper.AbstractActivityLifecycleCallback;
import com.bytedance.android.accessibilityLib_Core.processor.TraverseFromType;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AbstractAccessibilityLibIsolation$activityAndFragmentLifecycleCallback$2$a extends AbstractActivityLifecycleCallback {
    public final /* synthetic */ AbstractAccessibilityLibIsolation.activityAndFragmentLifecycleCallback.2 c;

    public AbstractAccessibilityLibIsolation$activityAndFragmentLifecycleCallback$2$a(AbstractAccessibilityLibIsolation.activityAndFragmentLifecycleCallback.2 r1) {
        this.c = r1;
    }

    public static View d(Window r10) {
        View r11 = r10.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AbstractActivityLifecycleCallback
    public final void b(Fragment r10) {
    L14:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L18;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L18:
        Unit r12 = Unit.INSTANCE;
        return;
    L4:
        if (this.c.this$0.f() == true) goto L7;
        return;
    L7:
        if ("fragmentViewDestory ".concat(r10.getClass().getSimpleName()) == null) goto L9;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L14
    L9:
        View r13 = r10.getView();     // Catch: Exception -> L14
        if (r13 == null) goto L13;
        AbstractAccessibilityLibIsolation.e(this.c.this$0, r13);     // Catch: Exception -> L14
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L14
        return;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AbstractActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        super.onActivityDestroyed(r10);
    L15:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L19;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L19:
        Unit r12 = Unit.INSTANCE;
        return;
    L4:
        if (this.c.this$0.f() == true) goto L7;
        return;
    L7:
        if ("onActivityDestroyed ".concat(r10.getClass().getSimpleName()) == null) goto L9;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L15
    L9:
        Window r13 = r10.getWindow();     // Catch: Exception -> L15
        if (r13 == null) goto L23;
        View r14 = d(r13);     // Catch: Exception -> L15
        if (r14 == null) goto L24;
        AbstractAccessibilityLibIsolation.e(this.c.this$0, r14);     // Catch: Exception -> L15
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L15
        return;
    L24:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostResumed(Activity r10) {
        super.onActivityPostResumed(r10);
    L19:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L23;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L23:
        Unit r12 = Unit.INSTANCE;
        return;
    L4:
        if (this.c.this$0.f() == true) goto L6;
        return;
    L6:
        String r1 = r10.getClass().getSimpleName();     // Catch: Exception -> L19
        if ("onActivityPostResumed ".concat(r1) == null) goto L9;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L19
    L9:
        Window r14 = r10.getWindow();     // Catch: Exception -> L19
        if (r14 == null) goto L15;
        View r15 = d(r14);     // Catch: Exception -> L19
        if (r15 == null) goto L15;
        AbstractAccessibilityLibIsolation.d(this.c.this$0, r15, TraverseFromType.ActivityPostResumed);     // Catch: Exception -> L19
    L17:
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    L15:
        if (("onActivityPostResumed " + r1 + " window is null") == null) goto L17;
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L19
        goto L17
    }

    @Override // com.bytedance.android.accessibilityLib_Core.helper.AbstractActivityLifecycleCallback
    public final void a(Fragment r10, View r11) {
    L11:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L15;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L15:
        Unit r13 = Unit.INSTANCE;
        return;
    L4:
        if (this.c.this$0.f() == true) goto L7;
        return;
    L7:
        if ("onFragmentViewCreated ".concat(r10.getClass().getSimpleName()) == null) goto L9;
        Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L11
    L9:
        AbstractAccessibilityLibIsolation.d(this.c.this$0, r11, TraverseFromType.FragmentCreated);     // Catch: Exception -> L11
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L11
    }
}
