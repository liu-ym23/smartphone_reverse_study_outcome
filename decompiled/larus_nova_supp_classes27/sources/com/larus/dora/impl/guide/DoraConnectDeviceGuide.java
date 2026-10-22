package com.larus.dora.impl.guide;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.strategy.FeatureGuideServerStrategy;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraConnectDeviceGuide extends d {
    public final Lazy h;
    public BluetoothDevice i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String j() {
        return "dora_connect_device_guide";
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void r(j59.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.larus.dora.impl.guide.d
    public final int A() {
        if (this.e.b > 1) goto L5;
        return 2131902386;
    L5:
        return 2131903152;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object v() {
        BluetoothDevice r0 = this.i;
        if (r0 != null) goto L6;
        g49.d.d(k(), "resolveDeviceParams() failed: connectDevice is null");
        return null;
    L6:
        DoraDevice r1 = DoraDevice.from(r0);
        r1.vendorId = 4096;
        String r2 = r1.getSerialNumber();
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L17;
        g49.d.d(k(), "resolveDeviceParams() failed: serialNumber is null");
        return null;
    L17:
        return new i59.a(r2, String.valueOf(n1.c(r1)));
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    @Override // com.larus.dora.impl.guide.d
    public final int z() {
        if (this.e.b > 1) goto L5;
        return 2131902385;
    L5:
        return 2131903151;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final DoraGuideMeta i() {
        return DoraGuideMeta.DoraConnectDeviceGuide;
    }

    public DoraConnectDeviceGuide(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        super(r2);
        this.h = LazyKt.lazy(new x());
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object p(Continuation<? super Boolean> r14) {
        if ((r14 instanceof DoraConnectDeviceGuide$localConditionCheck$1) == false) goto L7;
        DoraConnectDeviceGuide$localConditionCheck$1 r0 = (DoraConnectDeviceGuide$localConditionCheck$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L27:
        if (((Boolean) r15).booleanValue() == true) goto L113;
        g49.d.d(k(), "bluetooth permission not granted");
        return Boxing.boxBoolean(false);
    L113:
        Object r16 = AppHost.a.getApplication().getSystemService("bluetooth");     // Catch: Exception -> L110
        Object r3 = null;
        if ((r16 instanceof BluetoothManager) == false) goto L33;
        BluetoothManager r17 = (BluetoothManager) r16;     // Catch: Exception -> L110
    L34:
        if (r17 == null) goto L36;
        BluetoothAdapter r18 = r17.getAdapter();     // Catch: Exception -> L110
    L37:
        if (r18 != null) goto L39;
    L108:
        g49.d.e(k(), "bluetooth adapter is null or disabled");     // Catch: Exception -> L110
        return Boxing.boxBoolean(false);
    L39:
        if (r18.isEnabled() == false) goto L108;
        Set<BluetoothDevice> r110 = r18.getBondedDevices();     // Catch: Exception -> L110
        List r4 = DoraAdapterExtKt.k(kj4.a.g());     // Catch: Exception -> L110
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L110
        Iterator<T> r111 = r110.iterator();     // Catch: Exception -> L110
    L43:
        if (r111.hasNext() == false) goto L97;
        Object r5 = r111.next();     // Catch: Exception -> L110
        BluetoothDevice r6 = (BluetoothDevice) r5;     // Catch: Exception -> L110
        boolean r7 = pk4.a.f(r6);     // Catch: Exception -> L110
        if (r4 == null) goto L57;
        List r8 = r4;     // Catch: Exception -> L110
        if ((r8 instanceof Collection) == true) goto L49;
    L51:
        Iterator r10 = r8.iterator();     // Catch: Exception -> L110
    L53:
        if (r10.hasNext() == false) goto L57;
        if (Intrinsics.areEqual(((DoraDevice) r10.next()).mac, r6.getAddress()) == false) goto L53;
        boolean r11 = false;
    L58:
        String r12 = r6.getName();     // Catch: Exception -> L110
        if (r12 != null) goto L61;
    L63:
        boolean r13 = false;
    L64:
        if (r13 == false) goto L80;
        String r20 = r6.getName();     // Catch: Exception -> L110
        if (r20 != null) goto L68;
    L70:
        boolean r21 = false;
    L71:
        if (r21 == false) goto L80;
        String r22 = r6.getName();     // Catch: Exception -> L110
        if (r22 != null) goto L75;
    L77:
        boolean r23 = false;
    L78:
        if (r23 == false) goto L80;
        boolean r24 = true;
    L81:
        String r25 = k();     // Catch: Exception -> L110
        StringBuilder r26 = new StringBuilder();     // Catch: Exception -> L110
        r26.append("notBound=");     // Catch: Exception -> L110
        if (r11 == false) goto L84;
        boolean r27 = true;
    L85:
        r26.append(r27);     // Catch: Exception -> L110
        r26.append(", nameMatch=");     // Catch: Exception -> L110
        if (r24 == false) goto L88;
        boolean r28 = true;
    L89:
        r26.append(r28);     // Catch: Exception -> L110
        g49.d.a(r25, r26.toString());     // Catch: Exception -> L110
        if (r7 == false) goto L94;
        if (r11 == false) goto L94;
        if (r24 == false) goto L94;
        boolean r30 = true;
    L95:
        if (r30 == false) goto L43;
        r3 = r5;
    L94:
        r30 = false;
        goto L95
    L88:
        r28 = false;
        goto L89
    L84:
        r27 = false;
        goto L85
    L75:
        if (StringsKt.contains(r22, "2", true) != true) goto L77;
        r23 = true;
        goto L78
    L68:
        if (StringsKt.contains(r20, "huawei", true) != true) goto L70;
        r21 = true;
    L80:
        r24 = false;
        goto L81
    L61:
        if (StringsKt.contains(r12, "clip", true) != true) goto L63;
        r13 = true;
        goto L64
    L49:
        if (r8.isEmpty() == false) goto L51;
    L57:
        r11 = true;
    L97:
        BluetoothDevice r31 = (BluetoothDevice) r3;     // Catch: Exception -> L110
        if (r31 == null) goto L114;
        this.i = r31;     // Catch: Exception -> L110
        return Boxing.boxBoolean(true);
    L114:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L101
        g49.d.d(k(), "localConditionCheck: no eligible bonded device");     // Catch: Throwable -> L101
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L104:
        return Boxing.boxBoolean(false);
    L101:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Exception -> L110
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L110
        goto L104
    L36:
        r18 = null;
        goto L37
    L33:
        r17 = null;
    L110:
        e = move-exception;
        g49.d.c(k(), "localConditionCheck() exception: " + e.getMessage(), e);
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
    L20:
        if (Intrinsics.areEqual((Boolean) r15, Boxing.boxBoolean(true)) == true) goto L23;
        g49.d.d(k(), "H device is not enabled");
        return Boxing.boxBoolean(false);
    L23:
        com.larus.dora.impl.guide.strategy.a r113 = (com.larus.dora.impl.guide.strategy.a) this.h.getValue();
        r0.label = 2;
        r113.getClass();
        r15 = com.larus.dora.impl.guide.strategy.a.c();
        if (r15 != r9) goto L27;
        return r9;
    L16:
        ResultKt.throwOnFailure(r15);
        DoraSetting r33 = DoraSetting.a;
        String r34 = k().concat("-updateConnectDeviceShouldShowState-isHDeviceEnabled");
        Function0 r35 = new w();
        r0.label = 1;
        r15 = r33.b(5000, 100, r34, r35, r0);
        if (r15 != r9) goto L20;
        return r9;
    L7:
        r0 = new DoraConnectDeviceGuide$localConditionCheck$1(this, r14);
        goto L8
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void u(j59.a r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        DoraBuryPointManager.a.L("balloon_connect_device_show", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(r3.b))));
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void s(j59.a r9, Fragment r10) {
        Intrinsics.checkNotNullParameter(r9, "state");
        DoraBuryPointManager.a.L("balloon_connect_device_clicked", MapsKt.mapOf(TuplesKt.to("show_times", Integer.valueOf(r9.b))));
        if (r10 == null) goto L8;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r10);
        if (r2 == null) goto L9;
        BuildersKt.launch$default(r2, null, null, new DoraConnectDeviceGuide$onConfirmBtnClicked$1(this, r10, null), 3, null);
        return;
    L9:
        return;
    }

    public static final Object B(DoraConnectDeviceGuide r5, Fragment r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof DoraConnectDeviceGuide$onConnectDeviceClicked$1) == false) goto L7;
        DoraConnectDeviceGuide$onConnectDeviceClicked$1 r0 = (DoraConnectDeviceGuide$onConnectDeviceClicked$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r6 = (Fragment) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L29:
        if (((Boolean) r8).booleanValue() == true) goto L31;
        g49.d.e(r5.k(), "connect device does not support proprietary protocol");
        return Unit.INSTANCE;
    L31:
        if (r6 != null) goto L45;
    L34:
        Context r9 = AppHost.a.getApplication();     // Catch: Exception -> L41
    L35:
        y r10 = new y(r5);     // Catch: Exception -> L41
        com.bytedance.router.i r11 = SmartRouter.buildRoute(r9, "//flow/dora/bind_device");     // Catch: Exception -> L41
        r11.d = 2130772401;     // Catch: Exception -> L41
        r11.e = 2130772399;     // Catch: Exception -> L41
        Bundle r4 = com.larus.utils.f.c(new Pair[0]);     // Catch: Exception -> L41
        by7.h.k(r4, r10);     // Catch: Exception -> L41
        BluetoothDevice r12 = r5.i;     // Catch: Exception -> L41
        if (r12 == null) goto L38;
        String r13 = r12.getAddress();     // Catch: Exception -> L41
    L39:
        r4.putString("extra_mac", r13);     // Catch: Exception -> L41
        r4.putString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");     // Catch: Exception -> L41
        r4.putString("product_id", "-1");     // Catch: Exception -> L41
        r4.putString(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, "4096");     // Catch: Exception -> L41
        r11.c.putExtras(r4);     // Catch: Exception -> L41
        r11.d();     // Catch: Exception -> L41
    L44:
        return Unit.INSTANCE;
    L41:
        e = move-exception;
        g49.d.c(r5.k(), "onConnectDeviceClicked exception: " + e.getMessage(), e);
        goto L44
    L38:
        r13 = null;
        goto L39
    L45:
        r9 = r6.getContext();     // Catch: Exception -> L41
        if (r9 != null) goto L35;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (Fragment) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L20:
        if (((Boolean) r8).booleanValue() == true) goto L22;
        g49.d.b(r5.k(), "bluetooth permission not granted when connecting device");
        return Unit.INSTANCE;
    L22:
        BluetoothDevice r14 = r5.i;
        if (r14 == null) goto L48;
        FineDoraDeviceStrategy r15 = new FineDoraDeviceStrategy(r14, 4096);
        r0.L$0 = r6;
        r0.label = 2;
        r8 = r15.a(r0);
        if (r8 != r2) goto L29;
        return r2;
    L48:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r8);
        com.larus.dora.impl.guide.strategy.a r16 = (com.larus.dora.impl.guide.strategy.a) r5.h.getValue();
        r0.L$0 = r6;
        r0.label = 1;
        r16.getClass();
        r8 = com.larus.dora.impl.guide.strategy.a.c();
        if (r8 != r2) goto L20;
        return r2;
    L7:
        r0 = new DoraConnectDeviceGuide$onConnectDeviceClicked$1(r5, r7);
        goto L8
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final Object w(i59.a r4, j59.a r5, Continuation<? super Boolean> r6) {
        return new FeatureGuideServerStrategy(new DoraConnectDeviceGuide$serverConditionCheck$strategy$1(r4, r5, null), k(), true).a(r6);
    }
}
