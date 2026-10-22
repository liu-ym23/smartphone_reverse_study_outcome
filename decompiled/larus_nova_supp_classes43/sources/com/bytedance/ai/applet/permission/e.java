package com.bytedance.ai.applet.permission;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements Function1<GrantingAction, Unit> {
    public final /* synthetic */ AppletAuthorizeHelper a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AppletPermissionDetail c;
    public final /* synthetic */ i<GrantingAction> d;

    public e(AppletAuthorizeHelper r1, String r10, AppletPermissionDetail r11, j r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final Object invoke(Object r10) {
        GrantingAction r11 = (GrantingAction) r10;
        Intrinsics.checkNotNullParameter(r11, "userAction");
        AppletAuthorizeHelper r0 = this.a;
        String r1 = this.b;
        AppletPermissionDetail r12 = this.c;
        String r13 = r0.a;
        String r14 = AppletAuthorizeHelper.i(r1);
        int r15 = AppletAuthorizeHelper.b.a[r11.ordinal()];
        if (r15 != 1) goto L5;
        String r16 = "agree";
    L13:
        com.bytedance.ai.monitor.b.b("doubao_apps_system_auth_popup_click", new b(r14, r16, r13, r12));
        if (this.d.isActive() == false) goto L17;
        this.d.resumeWith(Result.constructor-impl(r11));
    L17:
        return Unit.INSTANCE;
    L5:
        if (r15 != 2) goto L7;
    L11:
        r16 = "reject";
        goto L13
    L7:
        if (r15 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }
}
