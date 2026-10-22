package com.ss.android.lark.conditional.access.nopermission.ui;

import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements UDListDialogController.OnItemClickListener {
    public final /* synthetic */ NoPermissionActivity a;

    public static final class a implements k8b.e {
        public final /* synthetic */ NoPermissionActivity a;

        @Override // k8b.e
        public final void onError() {
            ScsLogger.d("SecurityPolicy_NoPermissionActivity", "logout error");
        }

        @Override // k8b.e
        public final void onSuccess() {
            ScsLogger.d("SecurityPolicy_NoPermissionActivity", "logout success");
            AppLifecycle.a.a.j(this.a.m);
            this.a.D1().j();
            this.a.finish();
        }

        public a(NoPermissionActivity r1) {
            this.a = r1;
        }
    }

    public u(NoPermissionActivity r1) {
        this.a = r1;
    }

    public final void onItemClick(int r4) {
        NoPermissionActivity r1 = this.a;
        a r0 = new a(r1);
        if (r4 != 0) goto L5;
        int r5 = p8b.a.a;
        p8b.a.b("switch_organization", r1.e);
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "switch user click");
        this.a.C1().getPassportDependency().e(this.a);
        return;
    L5:
        int r6 = p8b.a.a;
        p8b.a.b("log_out", r1.e);
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "logout click");
        this.a.C1().getPassportDependency().f(this.a, r0);
    }
}
