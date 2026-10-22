package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Application;
import android.content.DialogInterface;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 implements DialogInterface.OnClickListener {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.b();
        Application r4 = LarkContext.getApplication();
        int r5 = g8b.b.a;
        k8b.c r6 = g8b.b.a.a().getDependency();
        Intrinsics.checkNotNull(r4);
        r6.k(r4, PassportcConvention.a(r4));
        ScsLogger.d("SecurityPolicyDialogFragment", "DeviceDeclarePageHintDialog re declare button click.");
    }
}
