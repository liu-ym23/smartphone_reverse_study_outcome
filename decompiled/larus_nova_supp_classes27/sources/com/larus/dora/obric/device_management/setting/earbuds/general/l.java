package com.larus.dora.obric.device_management.setting.earbuds.general;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.dora.impl.device.settings.general.IntentState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsGeneralSettingsFragment a;

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

    public l(DoraObricEarbudsGeneralSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        IntentState r5 = (IntentState) ((Pair) r3).getFirst();
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        FragmentActivity r7 = this.a.getActivity();
        if (r7 == null) goto L24;
        DoraObricEarbudsGeneralSettingsFragment r8 = this.a;
        Handler r0 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r7, r8.getString(2131908080));
    L24:
        return Unit.INSTANCE;
    L5:
        if (r6 != 2) goto L7;
    L17:
        FragmentActivity r9 = this.a.getActivity();
        if (r9 == null) goto L24;
        DoraObricEarbudsGeneralSettingsFragment r10 = this.a;
        Handler r1 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r9, r10.getString(2131904036));
        goto L24
    L7:
        if (r6 == 3) goto L17;
        if (r6 == 4) goto L17;
        if (r6 != 5) goto L16;
        FragmentActivity r11 = this.a.getActivity();
        if (r11 == null) goto L24;
        com.bytedance.router.i r12 = SmartRouter.buildRoute(r11, "//flow/dora/obric_device_home");
        r12.c.addFlags(335544320);
        r12.d();
        r11.finish();
        goto L24
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
