package com.larus.dora.impl.device.manage.settings;

import com.larus.dora.impl.core.BindAndConnectResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w<T> implements FlowCollector {

    public /* synthetic */ class a {
        public static final /* synthetic */ int a = 0;

        static {
            int[] r0 = new int[BindAndConnectResult.values().length];
            r0[BindAndConnectResult.SERVER_BIND_NEED_UNBIND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public w(DoraDeviceSettingsFragment r1) {
    }

    public final Object emit(Object r1, Continuation r2) {
        DoraDeviceSettingsViewModel.d r3 = (DoraDeviceSettingsViewModel.d) r1;
        if ((r3 instanceof DoraDeviceSettingsViewModel.d.a) == false) goto L7;
        ((DoraDeviceSettingsViewModel.d.a) r3).getClass();
        int r4 = a.a;
        throw null;
    L7:
        throw new NoWhenBranchMatchedException();
    }
}
