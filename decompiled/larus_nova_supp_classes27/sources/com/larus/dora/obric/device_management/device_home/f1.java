package com.larus.dora.obric.device_management.device_home;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.ota.g2.G2OtaFacade;
import com.larus.dora.impl.ota.g2.k5;
import com.larus.dora.impl.ota.g2.s$e0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public f1(DoraObricDeviceHomeFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r14, Continuation r15) {
        Pair r16 = (Pair) r14;
        if (r16 == null) goto L45;
        DoraObricDeviceHomeFragment r17 = this.a;
        DoraDevice r0 = (DoraDevice) r16.component1();
        k5 r18 = (k5) r16.component2();
        int r1 = DoraObricDeviceHomeFragment.R;
        FragmentManager r110 = r17.getChildFragmentManager();
        String r2 = r0.sn;
        String r3 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        com.larus.dora.impl.ota.g2.e r4 = new com.larus.dora.impl.ota.g2.e(r2, r0.productId);
        if (r110.isStateSaved() == true) goto L45;
        DoraObricGOtaCompletionSheet r5 = r110.findFragmentByTag("DoraObricGOtaCompletionSheet");
        boolean r6 = true;
        if (r5 != null) goto L13;
        int r7 = DoraObricGOtaCompletionSheet.e;
        String r8 = r18.c();
        String r9 = r18.b();
        String r111 = r18.a();
        Intrinsics.checkNotNullParameter(r4, "deviceKey");
        Intrinsics.checkNotNullParameter(r8, "version");
        Intrinsics.checkNotNullParameter(r9, "descText");
        Intrinsics.checkNotNullParameter(r111, "descDetail");
        DoraObricGOtaCompletionSheet r10 = new DoraObricGOtaCompletionSheet();
        r10.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("arg_device_sn", r4.b()), TuplesKt.to("arg_device_product_id", Integer.valueOf(r4.a())), TuplesKt.to("arg_version", r8), TuplesKt.to("arg_desc_text", r9), TuplesKt.to("arg_desc_detail", r111)}));
        LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "DoraObricGOtaCompletionSheet", r112);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r10, r112) == false) goto L47;
    L40:
        G2OtaFacade.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(r0, "device");
        final com.larus.dora.impl.ota.g2.e r113 = G2OtaFacade.F(r0);
        if (r113 == null) goto L45;
        final long r11 = System.currentTimeMillis();
        G2OtaFacade.Y(new s$e0(r113, r11));
        goto L45
    L47:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L39:
        r10.show(r110, "DoraObricGOtaCompletionSheet");
        goto L40
    L13:
        if ((r5 instanceof DoraObricGOtaCompletionSheet) == false) goto L45;
        DoraObricGOtaCompletionSheet r12 = r5;
        Intrinsics.checkNotNullParameter(r4, "deviceKey");
        Bundle r114 = r12.getArguments();
        if (r114 == null) goto L17;
        String r115 = r114.getString("arg_device_sn");
    L18:
        if (r115 == null) goto L22;
        r3 = r115;
    L22:
        if (Intrinsics.areEqual(r3, r4.b()) == false) goto L29;
        Bundle r116 = r12.getArguments();
        int r117 = Integer.MIN_VALUE;
        if (r116 == null) goto L27;
        r117 = r116.getInt("arg_device_product_id", Integer.MIN_VALUE);
    L27:
        if (r117 != r4.a()) goto L29;
    L30:
        if (r6 == false) goto L45;
        G2OtaFacade.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(r0, "device");
        final com.larus.dora.impl.ota.g2.e r118 = G2OtaFacade.F(r0);
        if (r118 == null) goto L45;
        final long r13 = System.currentTimeMillis();
        G2OtaFacade.Y(new s$e0(r118, r13));
    L29:
        r6 = false;
        goto L30
    L17:
        r115 = null;
    L45:
        return Unit.INSTANCE;
    }
}
