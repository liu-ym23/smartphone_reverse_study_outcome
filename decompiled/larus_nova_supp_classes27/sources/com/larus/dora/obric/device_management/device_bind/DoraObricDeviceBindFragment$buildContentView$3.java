package com.larus.dora.obric.device_management.device_bind;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceBindFragment$buildContentView$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DoraObricDeviceBindFragment$buildContentView$3(Object r8) {
        super(1, r8, DoraObricDeviceBindFragment.class, "openBuyPage", "openBuyPage(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        DoraObricDeviceBindFragment r0 = (DoraObricDeviceBindFragment) ((CallableReference) this).receiver;
        int[] r1 = DoraObricDeviceBindFragment.o;
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L7;
        SmartRouter.buildRoute(r2, r3).d();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
