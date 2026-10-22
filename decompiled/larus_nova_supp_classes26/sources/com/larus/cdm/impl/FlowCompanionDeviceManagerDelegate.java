package com.larus.cdm.impl;

import android.os.Build;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import oy8.a;
import oy8.b;
import py8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002J\u0012\u0010#\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'H\u0016J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010+\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0015H\u0002J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u0004\u0018\u00010\u000fJ\u001d\u00102\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0015H\u0000¢\u0006\u0002\b4R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/cdm/impl/FlowCompanionDeviceManagerDelegate;", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/cdm/FlowCompanionDeviceAppearListener;", "observingRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "flowCdmCompat", "Lcom/larus/cdm/impl/FlowCDMCompat;", "KEY_BOUND_SNS", "", "deviceInfoProvider", "Lcom/larus/cdm/DeviceInfoProviderInterface;", "config", "", "provider", "Lcom/larus/cdm/FlowCompanionDeviceConfigProvider;", "companionDeviceSupport", "", "createAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "fragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/activity/ComponentActivity;", "hasAssociated", "macAddress", "isDeviceBound", "sn", "addBoundSn", "getBoundSns", "", "removeBoundSn", "removeAllBoundSn", "disassociate", "getAssociatedDevices", "", "hasObservedPresence", "startObservingPresence", "stopObservingPresence", "saveObservingState", "state", "addGlobalAppearListener", "listener", "removeGlobalAppearListener", "setDeviceInfoProvider", "getDeviceInfoProvider", "notifyDeviceStateChange", "isAppeared", "notifyDeviceStateChange$impl_release", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCompanionDeviceManagerDelegate implements IFlowCompanionDeviceManager {
    public static final FlowCompanionDeviceManagerDelegate a = null;
    public static final CopyOnWriteArrayList<b> b = null;
    public static final Keva c = null;
    public static final py8.b d = null;
    public static final String e = null;
    public static a f;

    private FlowCompanionDeviceManagerDelegate() {
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void h(DoraServiceImpl.h r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
    }

    static {
        a = new FlowCompanionDeviceManagerDelegate();
        b = new CopyOnWriteArrayList();
        c = Keva.getRepo("flow_cdm_manager_observing");
        d = h.a(AppHost.a.getApplication());
        e = "bound_device_sns";
    }

    public static Set p() {
        Set r0 = c.getStringSet(e, new LinkedHashSet());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new LinkedHashSet();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final List<String> l() {
        return d.e();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean n() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void f() {
        Set r0 = p();
        r0.clear();
        c.storeStringSet(e, r0);
        FLogger.a.i("flow_cdm", "SN Saved locally: set: " + r0 + ' ');
    }

    public static void o(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        Set r1 = p();
        r1.add(r3);
        c.storeStringSet(e, r1);
        FLogger.a.i("flow_cdm", "SN Saved locally: " + r3);
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "macAddress");
        d.a(r3);
        if (b(r3) == true) goto L6;
        c.storeBoolean(r3, false);
        return;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "macAddress");
        if (Build.VERSION.SDK_INT >= 31) goto L6;
        FLogger.a.i("flow_cdm", "[hasAssociated] api level not support");
        return false;
    L6:
        boolean r6 = d.b(r5);
        FLogger.a.d("flow_cdm", "[hasAssociated] " + r6 + ' ');
        return r6;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean c(String r5) {
        boolean r0 = CollectionsKt.contains(p(), r5);
        FLogger.a.d("flow_cdm", "[isDeviceBound] SN:" + r5 + " -> " + r0);
        return r0;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void d(String r7) {
        Intrinsics.checkNotNullParameter(r7, "macAddress");
        FLogger r0 = FLogger.a;
        r0.i("flow_cdm", "stopObservingPresence " + r7.substring(0, RangesKt.coerceAtMost(8, r7.length())));
        if (Build.VERSION.SDK_INT >= 31) goto L13;
        r0.i("flow_cdm", "[stopObservingPresence] no cdm");
        return;
    L13:
        d.d(r7);     // Catch: Throwable -> L8
        boolean r1 = true;
    L10:
        if (r1 == false) goto L15;
        c.storeBoolean(r7, false);
        return;
    L15:
        return;
    L8:
        th = move-exception;
        FLogger.a.i("flow_cdm", "stopObservingDevicePresence failed: " + th);
        r1 = false;
        goto L10
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void e(DoraServiceImpl.i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        b.add(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void g(String r8) {
        Intrinsics.checkNotNullParameter(r8, "macAddress");
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("startObservingPresence ");
        boolean r4 = false;
        r2.append(r8.substring(0, RangesKt.coerceAtMost(8, r8.length())));
        r1.i("flow_cdm", r2.toString());
        if (Build.VERSION.SDK_INT >= 31) goto L14;
        r1.i("flow_cdm", "[startObservingPresence] no cdm");
        return;
    L14:
        d.f(r8);     // Catch: Throwable -> L9
        r1.i("flow_cdm", "startObservingDevicePresence -> " + b(r8));     // Catch: Throwable -> L9
        r4 = true;
    L11:
        if (r4 == false) goto L16;
        c.storeBoolean(r8, true);
        return;
    L16:
        return;
    L9:
        th = move-exception;
        FLogger.a.i("flow_cdm", "startObservingDevicePresence failed: " + th);
        goto L11
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void i(DoraServiceImpl.f r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        f = r2;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final FlowCompanionDeviceAssociatorImpl j(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new FlowCompanionDeviceAssociatorImpl(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void k(String r4) {
        Set r0 = p();
        if (CollectionsKt.contains(r0, r4) == false) goto L6;
        TypeIntrinsics.asMutableCollection(r0).remove(r4);
        c.storeStringSet(e, r0);
        FLogger.a.i("flow_cdm", "SN Removed locally: " + r4);
        return;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean m(String r3) {
        Intrinsics.checkNotNullParameter(r3, "macAddress");
        return c.getBoolean(r3, false);
    }

    public static void q(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "macAddress");
        Iterator<b> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        b r1 = r0.next();
        if (r6 == false) goto L8;
        r1.a(r5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        FLogger.a.i("flow_cdm", "notifyDeviceStateChange failed: " + th);
        goto L4
    L8:
        r1.b(r5);     // Catch: Throwable -> L10
        goto L4
    }
}
