package com.larus.dora.impl.dynamic;

import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r0<T> implements FlowCollector {

    public /* synthetic */ class a {
        public static final /* synthetic */ int a = 0;

        static {
            int[] r0 = new int[BindAndConnectResult.values().length];
            r0[BindAndConnectResult.SERVER_BIND_NEED_UNBIND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public r0(DoraDynamicFragment r1) {
    }

    public final Object emit(Object r1, Continuation r2) {
        DoraDynamicViewModelV2.e r3 = (DoraDynamicViewModelV2.e) r1;
        if ((r3 instanceof DoraDynamicViewModelV2.e.a) == false) goto L7;
        ((DoraDynamicViewModelV2.e.a) r3).getClass();
        int r4 = a.a;
        throw null;
    L7:
        throw new NoWhenBranchMatchedException();
    }
}
