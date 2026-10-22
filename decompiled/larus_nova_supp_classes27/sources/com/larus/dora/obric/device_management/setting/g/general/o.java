package com.larus.dora.obric.device_management.setting.g.general;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.dora.impl.device.settings.general.IntentState;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGeneralSettingsFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IntentState.values().length];
            r0[IntentState.ACTION_SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[IntentState.ACTION_NO_DEVICE_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[IntentState.ACTION_SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[IntentState.ACTION_SPP_DISCONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[IntentState.ACTION_UNBIND_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public o(DoraObricGGeneralSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        IntentState r5 = (IntentState) ((Pair) r3).getFirst();
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        WeakReference<com.obric.oui.toast.f> r7 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131908080);
    L20:
        return Unit.INSTANCE;
    L5:
        if (r6 != 2) goto L7;
    L17:
        WeakReference<com.obric.oui.toast.f> r8 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), 2131904036);
        goto L20
    L7:
        if (r6 == 3) goto L17;
        if (r6 == 4) goto L17;
        if (r6 != 5) goto L16;
        DoraObricGGeneralSettingsFragment r9 = this.a;
        int r10 = DoraObricGGeneralSettingsFragment.x;
        FragmentActivity r11 = r9.getActivity();
        if (r11 == null) goto L20;
        com.bytedance.router.i r12 = SmartRouter.buildRoute(r11, "//flow/dora/obric_device_home");
        r12.c.addFlags(335544320);
        r12.d();
        r11.finish();
        goto L20
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
