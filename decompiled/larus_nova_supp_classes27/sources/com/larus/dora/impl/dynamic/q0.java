package com.larus.dora.impl.dynamic;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.settings.general.IntentState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q0<T> implements FlowCollector {
    public final /* synthetic */ DoraDynamicFragment a;

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

    public q0(DoraDynamicFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        Pair r5 = (Pair) r3;
        IntentState r6 = (IntentState) r5.getFirst();
        int r7 = a.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        t19.s r8 = t19.s.a;
        Application r9 = AppHost.a.getApplication();
        r8.getClass();
        t19.s.b(r9, 2131908080, false);
    L32:
        return Unit.INSTANCE;
    L5:
        if (r7 != 2) goto L7;
    L29:
        t19.s r10 = t19.s.a;
        Application r11 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.b(r11, 2131904036, false);
        goto L32
    L7:
        if (r7 == 3) goto L29;
        if (r7 == 4) goto L29;
        if (r7 != 5) goto L28;
        FragmentActivity r12 = this.a.getActivity();
        if (r12 == null) goto L32;
        Intent r0 = new Intent("action.DEVICE_UNBIND");
        r0.setPackage(r12.getPackageName());
        DoraDevice r1 = (DoraDevice) r5.getSecond();
        if (r1 == null) goto L17;
        String r2 = r1.mac;
    L19:
        if (TextUtils.isEmpty(r2) == true) goto L26;
        DoraDevice r13 = (DoraDevice) r5.getSecond();
        if (r13 == null) goto L24;
        String r14 = r13.mac;
        if (r14 == null) goto L24;
    L25:
        r0.putExtra("mac", r14);
    L24:
        r14 = "";
    L26:
        LocalBroadcastManager.getInstance(r12).sendBroadcast(r0);
        goto L32
    L17:
        r2 = null;
        goto L19
    L28:
        throw new NoWhenBranchMatchedException();
    }
}
