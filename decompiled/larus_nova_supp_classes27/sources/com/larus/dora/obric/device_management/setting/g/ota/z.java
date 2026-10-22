package com.larus.dora.obric.device_management.setting.g.ota;

import com.larus.dora.impl.ota.g.SilentOTASwitchState;
import com.obric.oui.oswitch.OSwitch;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGOTAFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SilentOTASwitchState.values().length];
            r0[SilentOTASwitchState.On.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SilentOTASwitchState.Off.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SilentOTASwitchState.Unsupported.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public z(DoraObricGOTAFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        int r6 = a.a[((SilentOTASwitchState) r4).ordinal()];
        if (r6 != 1) goto L5;
        DoraObricGOTAFragment.aa0(this.a, true);
        OSwitch r7 = this.a.q;
        if (r7 == null) goto L18;
        r7.setChecked(true);
    L18:
        g49.d.d("DoraObricGOTAFragment", "doraAutoOtaSwitch: true");
    L20:
        return Unit.INSTANCE;
    L5:
        if (r6 != 2) goto L7;
        DoraObricGOTAFragment.aa0(this.a, true);
        OSwitch r8 = this.a.q;
        if (r8 == null) goto L14;
        r8.setChecked(false);
    L14:
        g49.d.d("DoraObricGOTAFragment", "doraAutoOtaSwitch: false");
        goto L20
    L7:
        if (r6 != 3) goto L10;
        DoraObricGOTAFragment.aa0(this.a, false);
        goto L20
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
