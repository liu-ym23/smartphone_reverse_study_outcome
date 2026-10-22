package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DoraObricDeviceHomeFragment$setupDeviceCardCarousel$adapter$3(Object r8) {
        super(1, r8, DoraObricDeviceHomeFragment.class, "openGlassesModeSheet", "openGlassesModeSheet(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        DoraObricDeviceHomeFragment r0 = (DoraObricDeviceHomeFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricDeviceHomeFragment.R;
        r0.ja0(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
