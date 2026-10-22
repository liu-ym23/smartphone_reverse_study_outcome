package com.larus.dora.impl.device.manage.settings;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.general.IntentState;
import com.larus.dora.impl.dynamic.n1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v<T> implements FlowCollector {
    public final /* synthetic */ DoraDeviceSettingsFragment a;

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

    public v(DoraDeviceSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r9, Continuation r10) {
        Pair r11 = (Pair) r9;
        int r12 = a.a[((IntentState) r11.getFirst()).ordinal()];
        boolean r0 = false;
        if (r12 != 1) goto L5;
        t19.s r13 = t19.s.a;
        Application r14 = AppHost.a.getApplication();
        r13.getClass();
        t19.s.b(r14, 2131908080, false);
    L72:
        return Unit.INSTANCE;
    L5:
        if (r12 != 2) goto L7;
    L69:
        t19.s r15 = t19.s.a;
        Application r16 = AppHost.a.getApplication();
        r15.getClass();
        t19.s.b(r16, 2131904036, false);
        goto L72
    L7:
        if (r12 == 3) goto L69;
        if (r12 == 4) goto L69;
        if (r12 != 5) goto L68;
        FragmentActivity r17 = this.a.getActivity();
        if (r17 == null) goto L72;
        DoraDevice r2 = (DoraDevice) r11.getSecond();
        List r3 = DoraAdapterExtKt.k(kj4.a.g());
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L15:
        String r6 = null;
        if (r5.hasNext() == false) goto L23;
        T r7 = r5.next();
        String r8 = ((DoraDevice) r7).mac;
        if (r2 == null) goto L21;
        r6 = r2.mac;
    L21:
        if ((!Intrinsics.areEqual(r8, r6)) == false) goto L15;
        r4.add(r7);
        goto L15
    L23:
        g49.d.d("DoraDeviceSettingsFragment", "unbindStateFlow: unbindDevice=" + r2 + ", remaining=" + r4.size());
        if (r4.isEmpty() == true) goto L36;
        Iterator r18 = r4.iterator();
    L28:
        if (r18.hasNext() == false) goto L36;
        if (n1.c((DoraDevice) r18.next()) != ProductNameType.DORA_G.id) goto L32;
        boolean r20 = true;
    L33:
        if (r20 == false) goto L28;
        r0 = true;
        goto L36
    L32:
        r20 = false;
    L36:
        if (com.larus.dora.impl.util.s.a() == false) goto L40;
        if (r0 == false) goto L40;
        g49.d.d("DoraDeviceSettingsFragment", "unbindStateFlow: jumping to DoraGDeviceManagement");
        SmartRouter.buildRoute(r17, "//dora_g_device_management").d();
    L55:
        Intent r1 = new Intent("action.DEVICE_UNBIND");
        r1.setPackage(r17.getPackageName());
        DoraDevice r21 = (DoraDevice) r11.getSecond();
        if (r21 == null) goto L59;
        r6 = r21.mac;
    L59:
        if (TextUtils.isEmpty(r6) == true) goto L66;
        DoraDevice r22 = (DoraDevice) r11.getSecond();
        if (r22 == null) goto L64;
        String r23 = r22.mac;
        if (r23 == null) goto L64;
    L65:
        r1.putExtra("mac", r23);
    L64:
        r23 = "";
    L66:
        LocalBroadcastManager.getInstance(r17).sendBroadcast(r1);
        r17.finish();
    L40:
        if ((!r4.isEmpty()) == false) goto L48;
        IFlowSdkDepend r24 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r24 == null) goto L44;
        com.larus.home.impl.sdk.s r25 = r24.s0();
    L45:
        if (r25 == null) goto L47;
        r25.M(r17, null);
        goto L55
    L47:
        n1.i();
        goto L55
    L44:
        r25 = null;
        goto L45
    L48:
        g49.d.d("DoraDeviceSettingsFragment", "unbindStateFlow: jumping to Device Discovery");
        IFlowSdkDepend r26 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r26 == null) goto L51;
        com.larus.home.impl.sdk.s r27 = r26.s0();
    L52:
        if (r27 == null) goto L54;
        r27.N(null);
        goto L55
    L54:
        SmartRouter.buildRoute(r17, "//flow/dora/device_list").d();
        goto L55
    L51:
        r27 = null;
        goto L52
    L68:
        throw new NoWhenBranchMatchedException();
    }
}
