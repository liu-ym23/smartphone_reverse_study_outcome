package com.larus.setting.impl;

import android.view.View;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class PrivacyPermissionFragment$onCreateView$1$1 extends FunctionReferenceImpl implements Function5<View, String, String, String, String, Unit> {
    public PrivacyPermissionFragment$onCreateView$1$1(Object r8) {
        super(5, r8, PrivacyPermissionFragment.class, "showGoSettingsDialogWithDefaultCancel", "showGoSettingsDialogWithDefaultCancel(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public final void invoke(View r9, String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        Intrinsics.checkNotNullParameter(r11, "p2");
        Intrinsics.checkNotNullParameter(r12, "p3");
        Intrinsics.checkNotNullParameter(r13, "p4");
        PrivacyPermissionFragment r1 = (PrivacyPermissionFragment) ((CallableReference) this).receiver;
        int r0 = PrivacyPermissionFragment.k;
        r1.getClass();
        tx9.c0.E(r10);
        r1.ba0(r9, r10, r11, r12, r1.getString(2131908448), r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        invoke((View) r7, (String) r8, (String) r9, (String) r10, (String) r11);
        return Unit.INSTANCE;
    }
}
