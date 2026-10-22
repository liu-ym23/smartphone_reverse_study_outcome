package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$1(Object r8) {
        super(1, r8, DoraObricDeviceHomeFragment.class, "onDeviceCardClicked", "onDeviceCardClicked(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        DoraObricDeviceHomeFragment r0 = (DoraObricDeviceHomeFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricDeviceHomeFragment.R;
        if (((DoraObricDeviceHomeViewModel.c) r0.ia0().getUiState().getValue()).b == null) goto L11;
        y69.a.c("device_card");
        if (Intrinsics.areEqual(r3, ((DoraObricDeviceHomeViewModel.c) r0.ia0().getUiState().getValue()).c) == true) goto L8;
        r0.ta0(r3);
        return;
    L8:
        r0.ia0().onDeviceCardClicked();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
