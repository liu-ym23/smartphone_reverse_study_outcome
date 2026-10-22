package com.ss.android.lark.conditional.access.nopermission.manager;

import android.content.Context;
import android.os.Handler;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.OfficeSDKExternalDeviceFactorHelper;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.p0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DialogButtonTypeFunction implements com.ss.android.lark.conditional.access.nopermission.ui.custom.a {
    public static final DialogButtonTypeFunction a = null;

    public static final class a implements k8b.d {
        public a() {
        }

        @Override // k8b.d
        public final void a(k8b.b r5) {
            Intrinsics.checkNotNullParameter(r5, ChameleonOpenTracker.ParamKey.RESULT);
            DialogButtonTypeFunction.a.getClass();
            if (Intrinsics.areEqual(r5, k8b.b.d.a) == false) goto L6;
            ScsLogger.d("SecurityPolicy_CustomDisplayModel", "device token claims challenge authorization success");
            ((Handler) SecurityDialogUtil.d.getValue()).post(b.a);
            return;
        L6:
            if ((r5 instanceof k8b.b.c) == false) goto L9;
            int r0 = ScsLogger.a;
            StringBuilder r1 = new StringBuilder("device token claims challenge authorization failed, code: ");
            k8b.b.c r6 = (k8b.b.c) r5;
            r1.append(r6.a);
            ScsLogger.c("SecurityPolicy_CustomDisplayModel", r1.toString());
            FileAuthMonitor.UpdateTrigger[] r2 = FileAuthMonitor.a;
            FileAuthMonitor.j("dialog", r6.a, r6.b);
            return;
        L9:
            if (Intrinsics.areEqual(r5, k8b.b.C0247b.a) == false) goto L12;
            ScsLogger.d("SecurityPolicy_CustomDisplayModel", "device token claims challenge authorization cancelled");
            FileAuthMonitor.UpdateTrigger[] r7 = FileAuthMonitor.a;
            FileAuthMonitor.j("dialog", "cancelled", null);
            return;
        L12:
            if (Intrinsics.areEqual(r5, k8b.b.a.a) == false) goto L15;
            ScsLogger.c("SecurityPolicy_CustomDisplayModel", "device token claims challenge authorization failed, app not installed");
            FileAuthMonitor.UpdateTrigger[] r8 = FileAuthMonitor.a;
            FileAuthMonitor.j("dialog", "app_not_installed", null);
            return;
        L15:
            if (Intrinsics.areEqual(r5, k8b.b.e.a) == false) goto L19;
            ScsLogger.c("SecurityPolicy_CustomDisplayModel", "device token claims challenge is unsupported by passport dependency");
            FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
            FileAuthMonitor.j("dialog", "unsupported", null);
            return;
        L19:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        a = new DialogButtonTypeFunction();
    }

    public DialogButtonTypeFunction() {
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.e
    public final void nb(CustomDisplayHandler r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r4 = (String) r2.link.get("mobile");
        if (r4 != null) goto L8;
        r4 = (String) r2.link.get("general");
        if (r4 != null) goto L8;
        r4 = BuildConfig.FLAVOR;
    L8:
        if (r4.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L14;
        int r6 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModel", "click: " + p0.d(r4));
        int r7 = com.ss.android.lark.conditional.access.utils.g.a;
        com.ss.android.lark.conditional.access.utils.g.a(LarkContext.getApplication(), r4);
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
        return;
    L14:
        return;
    L10:
        r5 = false;
        goto L11
    }

    public static boolean a(Context r2, String r3, InternalSecurityAction r4) {
        List<String> r0 = OfficeSDKExternalDeviceFactorHelper.a;
        return OfficeSDKExternalDeviceFactorHelper.c(r2, r3, r4, "dialog", new DialogButtonTypeFunction$openOfficeSDKExternalDeviceFactorIfNeeded$1(SecurityPolicyDialogActionManager.a));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.f0
    public final void Dx(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a(r4, "DeviceCertAuth", r3) == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        SecurityPolicyDialogActionManager r5 = SecurityPolicyDialogActionManager.a;
        r5.getClass();
        SecurityPolicyDialogActionManager.b();
        r5.f(25, r3);
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.d0
    public final void Fw(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a(r4, "DeviceApply", r3) == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.c(r3);
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.b
    public final void KT(CustomDisplayHandler r1, InternalSecurityAction r2, Context r3) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        Intrinsics.checkNotNullParameter(r3, "context");
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b.clear();
        SecurityPolicyDialogActionManager.b();
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.i0
    public final void QY(CustomDisplayHandler r3, InternalSecurityAction r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r5, "context");
        ScsLogger.e("SecurityPolicy_CustomDisplayModel", "onGeoAuthButtonClick: not supported in dialog scene, fallback to cancel");
        KT(r3, r4, r5);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.j0
    public final void To(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        KT(r2, r3, r4);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.k0
    public final void VB(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        KT(r2, r3, r4);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.e0
    public final void Vy(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a(r4, "DeviceAuth", r3) == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        SecurityPolicyDialogActionManager r5 = SecurityPolicyDialogActionManager.a;
        r5.getClass();
        SecurityPolicyDialogActionManager.b();
        r5.f(21, r3);
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.a
    public final boolean dL(CustomDisplayHandler r1, InternalSecurityAction r2, Context r3) {
        return com.ss.android.lark.conditional.access.nopermission.ui.custom.a.C0157a.a(this, r1, r2, r3);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.c
    public final void eG(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r5 = (String) r2.link.get("mobile");
        if (r5 != null) goto L7;
        r5 = (String) r2.link.get("general");
        if (r5 != null) goto L7;
        r5 = BuildConfig.FLAVOR;
    L7:
        String r6 = "lark://applink".concat(r5);
        if (ova.f.m().i(LarkContext.getApplication(), r6, 14) == false) goto L11;
        ova.f.m().y(LarkContext.getApplication(), r6, 14);
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.l0
    public final void qF(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        ScsLogger.e("SecurityPolicy_ButtonTypeFunction", "onSkipVerifyButtonClick: not supported in this scene, ignored");
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.g0
    public final void sI(CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        Intrinsics.checkNotNullParameter(r6, "context");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L9
        String r8 = DisplayUtilsKt.a(r5).get("tokenChallengeCode");     // Catch: Throwable -> L9
        if (r8 == null) goto L6;
        String r9 = StringsKt.trim(r8).toString();     // Catch: Throwable -> L9
    L7:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L9
    L11:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L15;
        int r1 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomDisplayModel", "parse device token claims challenge code failed: " + r11.getMessage());
    L15:
        if (Result.isFailure-impl(r10) == false) goto L17;
        r10 = null;
    L17:
        String r12 = (String) r10;
        if (r12 != null) goto L20;
    L23:
        boolean r13 = true;
    L24:
        if (r13 == false) goto L27;
        ScsLogger.c("SecurityPolicy_CustomDisplayModel", "device token claims challenge code is missing");
        FileAuthMonitor.UpdateTrigger[] r14 = FileAuthMonitor.a;
        FileAuthMonitor.j("dialog", "missing_challenge_code", null);
        return;
    L27:
        int r15 = g8b.b.a;
        g8b.b.a.a().getDependency().getPassportDependency().a(r12, new a());
        return;
    L20:
        if (StringsKt.isBlank(r12) == true) goto L23;
        r13 = false;
        goto L24
    L6:
        r9 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.m0
    public final void uR(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        KT(r2, r3, r4);
    }
}
