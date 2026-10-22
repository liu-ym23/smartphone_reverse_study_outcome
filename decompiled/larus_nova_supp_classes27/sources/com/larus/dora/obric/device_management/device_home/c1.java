package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.os.Bundle;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c1<T> implements FlowCollector {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricEnvironmentMemoryUiMessage.values().length];
            r0[DoraObricEnvironmentMemoryUiMessage.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DoraObricEnvironmentMemoryUiMessage.TEMPORARY_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DoraObricEnvironmentMemoryUiMessage.UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DoraObricEnvironmentMemoryUiMessage.NETWORK_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public c1(DoraObricDeviceHomeFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.dora.obric.device_management.device_home.z0] */
    public final Object emit(Object r7, Continuation r8) {
        i r9 = (i) r7;
        if ((r9 instanceof i.a) == false) goto L6;
        DoraObricDeviceHomeFragment r10 = this.a;
        i.a r11 = (i.a) r9;
        String r0 = r11.a;
        Bundle r12 = r11.b;
        int r1 = DoraObricDeviceHomeFragment.R;
        r10.ka0(r0, r12);
    L41:
        return Unit.INSTANCE;
    L6:
        if ((r9 instanceof i.b) == false) goto L12;
        final DoraObricDeviceHomeFragment r13 = this.a;
        i.b r14 = (i.b) r9;
        final String r2 = r14.a;
        final long r3 = r14.b;
        int r15 = DoraObricDeviceHomeFragment.R;
        r13.getClass();
        r13.k = TuplesKt.to(r2, Long.valueOf(r3));
        if (com.larus.dora.obric.onboarding.m.a.a(com.larus.dora.obric.onboarding.m.j, r13.requireContext(), r2, new z0(r13, r2, r3), 4) == true) goto L41;
        Bundle r16 = new Bundle();
        r16.putString("mac", r2);
        Unit r4 = Unit.INSTANCE;
        r13.ka0("//flow/dora/obric_g_env_observe", r16);
        goto L41
    L12:
        if ((r9 instanceof i.c) == false) goto L43;
        int r17 = l2.a;
        DoraObricEnvironmentMemoryToastType r18 = ((i.c) r9).getType();
        Intrinsics.checkNotNullParameter(r18, "toastType");
        int r20 = l2.a.a[r18.ordinal()];
        if (r20 == 1) goto L26;
        if (r20 == 2) goto L25;
        if (r20 == 3) goto L24;
        if (r20 != 4) goto L19;
        DoraObricEnvironmentMemoryUiMessage r21 = DoraObricEnvironmentMemoryUiMessage.NETWORK_ERROR;
    L27:
        if (r21 == null) goto L41;
        DoraObricDeviceHomeFragment r5 = this.a;
        WeakReference<com.obric.oui.toast.f> r6 = DoraObricToastUtils.a;
        Context r22 = r5.requireContext();
        int r23 = a.a[r21.ordinal()];
        if (r23 == 1) goto L38;
        if (r23 == 2) goto L37;
        if (r23 == 3) goto L36;
        if (r23 != 4) goto L35;
        int r24 = 2131903501;
    L39:
        Intrinsics.checkNotNullParameter(r22, "context");
        DoraObricToastUtils.c(r22, r22.getString(r24), null);
        goto L41
    L35:
        throw new NoWhenBranchMatchedException();
    L36:
        r24 = 2131903503;
        goto L39
    L37:
        r24 = 2131903502;
        goto L39
    L38:
        r24 = 2131903499;
        goto L39
    L19:
        if (r20 != 5) goto L22;
        r21 = null;
        goto L27
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        r21 = DoraObricEnvironmentMemoryUiMessage.UNAVAILABLE;
        goto L27
    L25:
        r21 = DoraObricEnvironmentMemoryUiMessage.TEMPORARY_OVERRIDE;
        goto L27
    L26:
        r21 = DoraObricEnvironmentMemoryUiMessage.ENABLED;
        goto L27
    L43:
        throw new NoWhenBranchMatchedException();
    }
}
