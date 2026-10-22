package com.larus.cdm.impl;

import androidx.fragment.app.Fragment;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.dora.impl.DoraServiceImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oy8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020%H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/cdm/impl/FlowCompanionDeviceManagerImpl;", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "<init>", "()V", "configProvider", "Lcom/larus/cdm/FlowCompanionDeviceConfigProvider;", "config", "", "provider", "companionDeviceConfigDisable", "", "companionDeviceSupport", "createAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "fragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/activity/ComponentActivity;", "hasAssociated", "macAddress", "", "isDeviceBound", "sn", "removeBoundSn", "removeAllBoundSn", "addBoundSn", "disassociate", "getAssociatedDevices", "", "hasObservedPresence", "startObservingPresence", "stopObservingPresence", "addGlobalAppearListener", "listener", "Lcom/larus/cdm/FlowCompanionDeviceAppearListener;", "removeGlobalAppearListener", "setDeviceInfoProvider", "Lcom/larus/cdm/DeviceInfoProviderInterface;", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCompanionDeviceManagerImpl implements IFlowCompanionDeviceManager {
    public volatile d a;

    public FlowCompanionDeviceManagerImpl() {
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void f() {
        FlowCompanionDeviceManagerDelegate.a.f();
    }

    public final boolean o() {
        d r0 = this.a;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final List<String> l() {
        if (o() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return FlowCompanionDeviceManagerDelegate.a.l();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean n() {
        if (o() == false) goto L7;
        return false;
    L7:
        return FlowCompanionDeviceManagerDelegate.a.n();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        if (o() == false) goto L5;
        return;
    L5:
        FlowCompanionDeviceManagerDelegate.a.a(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        if (o() == false) goto L7;
        return false;
    L7:
        return FlowCompanionDeviceManagerDelegate.a.b(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean c(String r2) {
        return FlowCompanionDeviceManagerDelegate.a.c(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        if (o() == false) goto L5;
        return;
    L5:
        FlowCompanionDeviceManagerDelegate.a.d(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void e(DoraServiceImpl.i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (o() == false) goto L5;
        return;
    L5:
        FlowCompanionDeviceManagerDelegate.a.e(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        if (o() == false) goto L5;
        return;
    L5:
        FlowCompanionDeviceManagerDelegate.a.g(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void h(DoraServiceImpl.h r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void i(DoraServiceImpl.f r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        FlowCompanionDeviceManagerDelegate.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "provider");
        FlowCompanionDeviceManagerDelegate.f = r3;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final FlowCompanionDeviceAssociatorImpl j(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if (o() == false) goto L7;
        return null;
    L7:
        return FlowCompanionDeviceManagerDelegate.a.j(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void k(String r2) {
        FlowCompanionDeviceManagerDelegate.a.k(r2);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macAddress");
        if (o() == false) goto L7;
        return false;
    L7:
        return FlowCompanionDeviceManagerDelegate.a.m(r2);
    }
}
