package com.larus.dora.obric.device_management.setting.g.general;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.dora.impl.device.settings.unbind.DoraUnbindState;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGUnbindAndResetFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraUnbindState.values().length];
            r0[DoraUnbindState.SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DoraUnbindState.NO_DEVICE_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DoraUnbindState.SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DoraUnbindState.SPP_DISCONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DoraUnbindState.UNBIND_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public w(DoraObricGUnbindAndResetFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r4, Continuation r5) {
        Pair r6 = (Pair) r4;
        int r7 = a.a[((DoraUnbindState) r6.getFirst()).ordinal()];
        if (r7 != 1) goto L5;
        WeakReference<com.obric.oui.toast.f> r8 = DoraObricToastUtils.a;
        DoraObricToastUtils.b(this.a.requireContext(), this.a.getString(2131902938));
    L32:
        return Unit.INSTANCE;
    L5:
        if (r7 != 2) goto L7;
    L29:
        WeakReference<com.obric.oui.toast.f> r9 = DoraObricToastUtils.a;
        DoraObricToastUtils.b(this.a.requireContext(), this.a.getString(2131902949));
        goto L32
    L7:
        if (r7 == 3) goto L29;
        if (r7 == 4) goto L29;
        if (r7 != 5) goto L28;
        FragmentActivity r10 = this.a.getActivity();
        if (r10 == null) goto L32;
        Intent r0 = new Intent("action.DEVICE_UNBIND");
        r0.setPackage(r10.getPackageName());
        DoraDevice r1 = (DoraDevice) r6.getSecond();
        String r2 = null;
        if (r1 == null) goto L17;
        String r3 = r1.mac;
    L19:
        if (TextUtils.isEmpty(r3) == true) goto L26;
        DoraDevice r11 = (DoraDevice) r6.getSecond();
        if (r11 == null) goto L23;
        r2 = r11.mac;
    L23:
        if (r2 != null) goto L25;
        r2 = "";
    L25:
        r0.putExtra("mac", r2);
    L26:
        LocalBroadcastManager.getInstance(r10).sendBroadcast(r0);
        com.bytedance.router.i r12 = SmartRouter.buildRoute(r10, "//flow/dora/obric_device_home");
        r12.c.addFlags(335544320);
        r12.d();
        r10.finish();
        goto L32
    L17:
        r3 = null;
        goto L19
    L28:
        throw new NoWhenBranchMatchedException();
    }
}
