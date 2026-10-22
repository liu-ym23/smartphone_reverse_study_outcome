package com.bytedance.ai.model;

import android.content.DialogInterface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2235b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f2234a = r10;
        this.f2235b = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r10) {
        Object r11 = this.f2235b;
        switch(this.f2234a) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        String r12 = (String) r11;
        String r13 = androidx.constraintlayout.motion.widget.a.q(r12, "$source", "PrivacyPolicyNetworkConfirm(result=cancel, source=", r12, ")");
        Intrinsics.checkNotNullParameter("PrivacyPolicyNavigator", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L9;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("PrivacyPolicyNavigator", r13);
        return;
    L9:
        throw new IllegalStateException("KoinApplication has not been started");
    L10:
        int r15 = AppletRuntime.f2196x;
        ((AppletRuntime) r11).p(null, null);
        r5.dismiss();
        return;
    L12:
        int r16 = AppletRuntime.f2196x;
        ((AppletRuntime) r11).p(null, null);
        r5.dismiss();
    }
}
