package com.larus.dora.obric.device_management.setting.g;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGSettingsFragment a;

    public p(DoraObricGSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        u r3 = (u) r1;
        DoraObricGSettingsFragment r4 = this.a;
        int r5 = DoraObricGSettingsFragment.m;
        r4.ca0();
        return Unit.INSTANCE;
    }
}
