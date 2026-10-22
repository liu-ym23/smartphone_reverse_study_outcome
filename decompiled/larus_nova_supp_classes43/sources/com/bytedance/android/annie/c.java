package com.bytedance.android.annie;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.annie.container.dialog.AnnieDialog;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ com.bytedance.android.annie.param.a a;
    public final /* synthetic */ PopupHybridParamVoNew b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "savedInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (d.b == false) goto L32;
        c r0 = d.a;
        FragmentActivity r11 = d.a(r10, this.a);
        if (r11 == null) goto L27;
        FragmentManager r12 = r11.getSupportFragmentManager();
        if (r12 == null) goto L27;
        PopupHybridParamVoNew r1 = this.b;
        AnnieDialog r13 = d.c;
        if (r13 == null) goto L27;
        if (r1 == null) goto L14;
        boolean r14 = true;
        if (r1.O2() != true) goto L14;
    L16:
        if (r14 == false) goto L22;
        FragmentTransaction r15 = r12.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r15, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "Annie Dialog", 0) == true) goto L21;
        r15 = r15.add(r13, "Annie Dialog");
    L21:
        r15.commitAllowingStateLoss();
        goto L27
    L22:
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "Annie Dialog", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r13, r16) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L26:
        r13.show(r12, "Annie Dialog");
    L14:
        r14 = false;
    L27:
        c r17 = d.a;
        d.b = false;
        d.c = null;
        return;
    }

    public c(com.bytedance.android.annie.param.a r1, PopupHybridParamVoNew r10) {
        this.a = r1;
        this.b = r10;
    }
}
