package com.larus.dora.impl.device.manage;

import android.view.View;
import com.larus.dora.impl.device.manage.holder.DeviceUIComponent;
import com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k0 implements a1 {
    public final /* synthetic */ DoraGDeviceManagementFragment a;

    public k0(DoraGDeviceManagementFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.device.manage.a1
    public final void a(a r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        g49.d.d("DoraGDeviceManagementFragment", "onDeviceSwitch event=" + r8);
        DoraGDeviceManagementAdapter r1 = this.a.j;
        boolean r2 = true;
        if (r1 == null) goto L24;
        Intrinsics.checkNotNullParameter(r8, "event");
        g49.d.d("DoraGDeviceManagementAdapter", "dispatchDeviceSwitchEvent event=" + r8);
        Iterator<T> r3 = r1.m.iterator();
        boolean r4 = false;
    L6:
        if (r3.hasNext() == false) goto L24;
        LifecycleUIComponent r5 = (LifecycleUIComponent) r3.next();
        View r6 = r5.b;
        if (r6 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L6;
        if ((r5 instanceof DeviceUIComponent) == true) goto L16;
        Intrinsics.checkNotNullParameter(r8, "event");
        if (r5.a() == false) goto L6;
        r5.e(r8);
        goto L6
    L16:
        if (r4 == true) goto L6;
        Intrinsics.checkNotNullParameter(r8, "event");
        if (r5.a() == false) goto L20;
        r5.e(r8);
    L20:
        r4 = true;
        goto L6
    L10:
        if (r6.isAttachedToWindow() != true) goto L12;
        r7 = true;
    L24:
        c r9 = r8.a;
        if (r9 != null) goto L27;
    L29:
        r2 = false;
    L30:
        if (r2 == false) goto L45;
        DoraGDeviceManagementFragment r10 = this.a;
        r10.l = false;
        DoraGDeviceManagementViewModel.refreshLatestCardContent$default(r10.Y90(), false, false, 3, null);
        return;
    L45:
        return;
    L27:
        if (r9.f != true) goto L29;
        goto L29
    }
}
