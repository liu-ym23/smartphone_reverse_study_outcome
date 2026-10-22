package com.larus.dora.obric.device_management.setting.earbuds;

import android.text.TextUtils;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsDSLSettingsFragment a;

    public g(DoraObricEarbudsDSLSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        DoraDynamicViewModelV2.f r9 = (DoraDynamicViewModelV2.f) r7;
        if ((r9 instanceof DoraDynamicViewModelV2.f.a) == false) goto L13;
        DoraObricEarbudsDSLSettingsFragment r10 = this.a;
        int r0 = DoraObricEarbudsDSLSettingsFragment.l;
        String r11 = r10.X90().currentDeviceMac();
        DoraDynamicViewModelV2.f.a r12 = (DoraDynamicViewModelV2.f.a) r9;
        if (TextUtils.equals(r11, r12.b.mac) == false) goto L25;
        if (this.a.X90().hasLoadedPageInfo() == true) goto L9;
    L11:
        DoraObricEarbudsDSLSettingsViewModel r1 = this.a.X90();
        Integer r2 = Boxing.boxInt(r12.b.vendorId);
        int r13 = n1.a;
        Integer r3 = Boxing.boxInt(n1.c(r12.b));
        DoraDevice r14 = r12.b;
        r1.loadData(r2, r3, r14.model, this.a.j, r14.mac);
        goto L25
    L9:
        if (TextUtils.equals(r11, r12.b.mac) == false) goto L11;
        this.a.X90().updateConnectionState(new e59.b.a(r12.b.mac));
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L13:
        if ((r9 instanceof DoraDynamicViewModelV2.f.c) == false) goto L25;
        DoraDynamicViewModelV2.f.c r15 = (DoraDynamicViewModelV2.f.c) r9;
        z49.b r16 = r15.b;
        String r4 = null;
        if (r16 == null) goto L17;
        String r17 = r16.c();
    L18:
        DoraObricEarbudsDSLSettingsFragment r5 = this.a;
        int r6 = DoraObricEarbudsDSLSettingsFragment.l;
        if (TextUtils.equals(r17, r5.X90().currentDeviceMac()) == false) goto L25;
        DoraObricEarbudsDSLSettingsViewModel r18 = this.a.X90();
        z49.b r20 = r15.b;
        if (r20 == null) goto L23;
        r4 = r20.c();
    L23:
        r18.updateConnectionState(new e59.b.c(r4));
        goto L25
    L17:
        r17 = null;
        goto L18
    }
}
