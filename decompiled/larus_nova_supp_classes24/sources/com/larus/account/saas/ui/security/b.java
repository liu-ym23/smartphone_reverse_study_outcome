package com.larus.account.saas.ui.security;

import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.account.saas.ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {

    public static final class a implements h48.d {
        public a() {
        }

        @Override // h48.d
        public final void confirm() {
        }
    }

    /* JADX INFO: renamed from: com.larus.account.saas.ui.security.b$b, reason: collision with other inner class name */
    public static final class C0067b implements h48.a {
        public final /* synthetic */ Function1<e48.a, Unit> a;

        @Override // h48.a
        public final void cancel() {
            Function1<e48.a, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke(e48.a.C0104a.a);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0067b(Function1<? super e48.a, Unit> r1) {
            this.a = r1;
        }
    }

    public static final void a(FragmentActivity r6, e48.b r7, final Function1<? super e48.a, Unit> r8) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "riskInfo");
        String r0 = r7.a;
        String r9 = r7.b;
        DialogInterface.OnDismissListener r1 = new com.larus.account.saas.ui.security.a(r8);
        Intrinsics.checkNotNullParameter(r1, "listener");
        a r3 = new a();
        String r4 = r6.getString(2131899075);
        Intrinsics.checkNotNullParameter(r3, "listener");
        C0067b r5 = new C0067b(r8);
        String r10 = r6.getString(2131899074);
        Intrinsics.checkNotNullParameter(r5, "listener");
        CommonDialog r2 = new CommonDialog();
        r2.d = r0;
        r2.e = true;
        r2.f = r9;
        r2.g = null;
        r2.h = null;
        r2.i = r4;
        r2.j = 0;
        r2.k = false;
        r2.l = r3;
        r2.m = null;
        r2.n = true;
        r2.o = r10;
        r2.p = 0;
        r2.q = false;
        r2.r = true;
        r2.s = r5;
        r2.t = true;
        r2.u = r1;
        r2.v = true;
        r2.w = true;
        FragmentManager r11 = r6.getSupportFragmentManager();
        FragmentTransaction r12 = r11.beginTransaction();
        Fragment r13 = r11.findFragmentByTag("account_risk_dialog");
        if (r13 == null) goto L6;
        r12.remove(r13);
    L6:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "account_risk_dialog", 0) == true) goto L9;
        r12 = r12.add(r2, "account_risk_dialog");
    L9:
        r12.commitAllowingStateLoss();
        com.larus.account.saas.runtime.internal.delegate.a.a.d("DefaultAccountRiskUi", "onAccountAppealDialogShow");
    }
}
