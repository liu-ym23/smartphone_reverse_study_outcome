package com.larus.dora.impl.guide;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.strategy.FeatureGuideServerStrategy;
import com.larus.dora.impl.settings.DoraSetting;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraDNULostUserGuide extends d {
    public DoraDevice h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.guide.d
    public final int A() {
        return 2131903154;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String j() {
        return "dora_dnu_lost_user_guide";
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void r(j59.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.larus.dora.impl.guide.d
    public final int z() {
        return 2131903153;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object v() {
        DoraDevice r0 = this.h;
        if (r0 != null) goto L6;
        r0 = DoraAdapterExtKt.h(kj4.a.g());
    L6:
        if (r0 != null) goto L9;
        g49.d.d(k(), "resolveDeviceParams() failed: currentDevice is null");
        return null;
    L9:
        String r2 = r0.getSerialNumber();
        if (r2 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L20;
        g49.d.d(k(), "resolveDeviceParams() failed: serialNumber is null");
        return null;
    L20:
        return new i59.a(r2, String.valueOf(n1.c(r0)));
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
        goto L16
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final DoraGuideMeta i() {
        return DoraGuideMeta.DoraDNULostUserGuide;
    }

    public DoraDNULostUserGuide(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        super(r2);
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object p(Continuation<? super Boolean> r11) {
        if ((r11 instanceof DoraDNULostUserGuide$localConditionCheck$1) == false) goto L7;
        DoraDNULostUserGuide$localConditionCheck$1 r0 = (DoraDNULostUserGuide$localConditionCheck$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraDNULostUserGuide$localConditionCheck$1 r8 = r0;
        Object r12 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        if (Intrinsics.areEqual((Boolean) r12, Boxing.boxBoolean(true)) == true) goto L21;
        g49.d.d(k(), "H device is not enabled for DNU guide");
        return Boxing.boxBoolean(false);
    L21:
        DoraDevice r13 = DoraAdapterExtKt.h(kj4.a.g());
        int r4 = kj4.a.g().getDoraLinkState(r13);
        if (r13 != null) goto L24;
    L32:
        g49.d.d(k(), "localConditionCheck: device not connected, device=" + r13 + ", linkState=" + r4);
        return Boxing.boxBoolean(false);
    L24:
        if (r4 != 2) goto L32;
        if (r13.vendorId == 4096) goto L30;
        g49.d.d(k(), "localConditionCheck: device vendorId is not H, vendorId=" + r13.vendorId);
        return Boxing.boxBoolean(false);
    L30:
        this.h = r13;
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        DoraSetting r5 = DoraSetting.a;
        String r6 = k().concat("-isHDeviceEnabled");
        Function0 r7 = new z();
        r8.label = 1;
        r12 = r5.b(5000, 100, r6, r7, r8);
        if (r12 != r2) goto L18;
        return r2;
    L7:
        r0 = new DoraDNULostUserGuide$localConditionCheck$1(this, r11);
        goto L8
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void u(j59.a r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        DoraBuryPointManager.a.L("dora_dnu_lost_user_balloon_show", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(r3.b))));
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void s(j59.a r9, Fragment r10) {
        Intrinsics.checkNotNullParameter(r9, "state");
        DoraBuryPointManager.a.L("dora_dnu_lost_user_balloon_clicked", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(this.e.b))));
        if (r10 == null) goto L8;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r10);
        if (r2 == null) goto L9;
        BuildersKt.launch$default(r2, null, null, new DoraDNULostUserGuide$onConfirmBtnClicked$1(null), 3, null);
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object w(i59.a r4, j59.a r5, Continuation<? super Boolean> r6) {
        return new FeatureGuideServerStrategy(new DoraDNULostUserGuide$serverConditionCheck$strategy$1(r4, r5, null), k(), true).a(r6);
    }
}
