package com.larus.dora.obric.device_management.setting.earbuds;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.dora.impl.device.settings.general.IntentState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsDSLSettingsFragment a;

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

    public h(DoraObricEarbudsDSLSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        Pair r6 = (Pair) r4;
        IntentState r7 = (IntentState) r6.component1();
        DoraDevice r8 = (DoraDevice) r6.component2();
        int r9 = a.a[r7.ordinal()];
        if (r9 != 1) goto L5;
        FragmentActivity r10 = this.a.getActivity();
        if (r10 == null) goto L35;
        DoraObricEarbudsDSLSettingsFragment r11 = this.a;
        Handler r0 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r10, r11.getString(2131908080));
    L35:
        return Unit.INSTANCE;
    L5:
        if (r9 != 2) goto L7;
    L28:
        FragmentActivity r12 = this.a.getActivity();
        if (r12 == null) goto L35;
        DoraObricEarbudsDSLSettingsFragment r13 = this.a;
        Handler r1 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r12, r13.getString(2131904036));
        goto L35
    L7:
        if (r9 == 3) goto L28;
        if (r9 == 4) goto L28;
        if (r9 != 5) goto L27;
        FragmentActivity r14 = this.a.getActivity();
        if (r14 == null) goto L35;
        Intent r2 = new Intent("action.DEVICE_UNBIND");
        r2.setPackage(r14.getPackageName());
        String r3 = null;
        if (r8 == null) goto L17;
        String r15 = r8.mac;
    L19:
        if (TextUtils.isEmpty(r15) == true) goto L25;
        if (r8 == null) goto L22;
        r3 = r8.mac;
    L22:
        if (r3 != null) goto L24;
        r3 = "";
    L24:
        r2.putExtra("mac", r3);
    L25:
        LocalBroadcastManager.getInstance(r14).sendBroadcast(r2);
        com.bytedance.router.i r16 = SmartRouter.buildRoute(r14, "//flow/dora/obric_device_home");
        r16.c.addFlags(335544320);
        r16.d();
        r14.finish();
        goto L35
    L17:
        r15 = null;
        goto L19
    L27:
        throw new NoWhenBranchMatchedException();
    }
}
