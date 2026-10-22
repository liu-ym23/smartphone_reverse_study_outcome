package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LongClickGiftPanelIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LongClickGiftPanelIconContinue;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnClickGiftPanelIconKeyUp;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnComboSingleClickStart;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnDialogFullyShowed;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftComboCountDownFinish;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(m.class, "LiveGiftPanelDiffOptimizeSwitch", "getLiveGiftPanelDiffOptimizeSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaMemoryLeakSwitch", "getLiveAnyaMemoryLeakSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaUseIoScheduler", "getLiveAnyaUseIoScheduler()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaViewModelMemoryLeakSwitch", "getLiveAnyaViewModelMemoryLeakSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaComputingLayoutCrashFix", "getLiveAnyaComputingLayoutCrashFix()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaFrequentALogOpt", "getLiveAnyaFrequentALogOpt()Z", 1)), Reflection.property0(new PropertyReference0Impl(m.class, "LiveAnyaMutateDeadLockAnrFix", "getLiveAnyaMutateDeadLockAnrFix()Z", 1))};
        a = r0;
        Boolean r9 = Boolean.FALSE;
        Class r10 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_diff_optimize_switch", r9, r10, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_memory_leak_switch", r9, r10, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_use_io_scheduler", r9, r10, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_view_model_memory_leak_switch", r9, r10, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_computing_layout_crash_fix", Boolean.TRUE, r10, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_frequent_alog_opt", r9, r10, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anya_mutate_dead_lock_anr_fix", r9, r10, false);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
    }

    public static final boolean c(GiftAction r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isGiftListStateMachineAction");
        if ((r1 instanceof ClickGiftPanelIcon) == false) goto L5;
    L18:
        return true;
    L5:
        if ((r1 instanceof LongClickGiftPanelIcon) == true) goto L18;
        if ((r1 instanceof OnDialogFullyShowed) == true) goto L18;
        if ((r1 instanceof LongClickGiftPanelIconContinue) == true) goto L18;
        if ((r1 instanceof OnClickGiftPanelIconKeyUp) == true) goto L18;
        if ((r1 instanceof OnComboSingleClickStart) == true) goto L18;
        if ((r1 instanceof OnGiftComboCountDownFinish) == true) goto L18;
        return false;
    }

    public static final Set<Integer> a(IntRange r5, IntRange r6) {
        Intrinsics.checkNotNullParameter(r5, "range");
        Intrinsics.checkNotNullParameter(r6, "rangeB");
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r6.getFirst();
        int r2 = r6.getLast();
        if (r1 <= r2) goto L5;
    L10:
        int r3 = r5.getFirst();
        int r7 = r5.getLast();
        if (r3 <= r7) goto L13;
    L18:
        return r0;
    L13:
        if (r6.contains(r3) == true) goto L16;
        if (r3 == (-1)) goto L16;
        r0.add(Integer.valueOf(r3));
    L16:
        if (r3 == r7) goto L18;
        r3 = r3 + 1;
    L5:
        if (r5.contains(r1) == true) goto L8;
        if (r1 == (-1)) goto L8;
        r0.add(Integer.valueOf(r1));
    L8:
        if (r1 == r2) goto L10;
        r1 = r1 + 1;
        goto L5
    }

    public static final Set<Integer> b(IntRange r3, IntRange r4) {
        Intrinsics.checkNotNullParameter(r3, "range");
        Intrinsics.checkNotNullParameter(r4, "rangeB");
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r4.getFirst();
        int r5 = r4.getLast();
        if (r1 <= r5) goto L5;
    L9:
        return r0;
    L5:
        if (r3.contains(r1) == true) goto L7;
        r0.add(Integer.valueOf(r1));
    L7:
        if (r1 == r5) goto L9;
        r1 = r1 + 1;
        goto L5
    }
}
