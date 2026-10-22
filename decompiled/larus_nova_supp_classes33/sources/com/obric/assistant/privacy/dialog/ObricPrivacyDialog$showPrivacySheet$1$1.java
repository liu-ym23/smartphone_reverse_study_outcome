package com.obric.assistant.privacy.dialog;

import android.app.Activity;
import android.content.Context;
import com.larus.home.api.main.HomeService;
import com.larus.network.HttpConst;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricPrivacyDialog$showPrivacySheet$1$1 implements com.obric.oui.privacy.i {
    public final /* synthetic */ ObricPrivacyDialog a;

    public final void a() {
        ObricPrivacyDialog r0 = this.a;
        r0.h = false;
        Context r1 = r0.f;
        if (r1 == null) goto L5;
        String r2 = r1.getClass().getName();
    L7:
        if (Intrinsics.areEqual(r2, "com.larus.home.impl.MainActivity") == false) goto L15;
        Context r3 = this.a.f;
        if ((r3 instanceof Activity) == false) goto L11;
        Activity r4 = (Activity) r3;
    L12:
        if (r4 == null) goto L14;
        r4.finish();
    L14:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricPrivacyDialog$showPrivacySheet$1$1$onExitClicked$1(this, null), 3, null);
        return;
    L11:
        r4 = null;
        goto L12
    L15:
        com.obric.oui.privacy.c r5 = this.a.g;
        if (r5 == null) goto L20;
        r5.b();
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void b() {
        ObricPrivacyDialog r0 = this.a;
        r0.h = true;
        com.obric.oui.privacy.c r1 = r0.g;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    public final void onDismiss() {
        ObricPrivacyDialog r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        if (r0.h == false) goto L6;
        ObricPrivacyDialog.T90(r0);     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L6:
        FLogger.a.i("ObricPrivacyDialog", "click disagree");     // Catch: Throwable -> L20
        Context r2 = r0.f;     // Catch: Throwable -> L20
        if (r2 == null) goto L9;
        HomeService.a.Y(r2, false);     // Catch: Throwable -> L20
    L9:
        com.larus.common_ui.dialog.u r3 = r0.e;     // Catch: Throwable -> L20
        if (r3 == null) goto L23;
        r3.cancel();     // Catch: Throwable -> L20
    L23:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L14 Throwable -> L20
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L20
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L20
        if (r4 == null) goto L18;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onBackPressed() {
        a();
    }

    public ObricPrivacyDialog$showPrivacySheet$1$1(ObricPrivacyDialog r1) {
        this.a = r1;
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "linkText");
        ObricPrivacyDialog r0 = this.a;
        int r1 = ObricPrivacyDialog.k;
        if (Intrinsics.areEqual(r3, r0.U90(2131912376)) == false) goto L6;
        ObricPrivacyDialog r4 = this.a;
        HttpConst.a.getClass();
        ObricPrivacyDialog.S90(r4, HttpConst.M);
        return;
    L6:
        if (Intrinsics.areEqual(r3, this.a.U90(2131912345)) == false) goto L9;
        ObricPrivacyDialog.S90(this.a, "https://www.doubao.com/ocean_legal/terms");
        return;
    L9:
        if (Intrinsics.areEqual(r3, this.a.U90(2131912346)) == false) goto L14;
        ObricPrivacyDialog r5 = this.a;
        HttpConst.a.getClass();
        ObricPrivacyDialog.S90(r5, HttpConst.L);
        return;
    }
}
