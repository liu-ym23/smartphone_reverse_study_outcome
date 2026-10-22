package com.larus.cdm;

import androidx.fragment.app.Fragment;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl;
import com.larus.dora.impl.DoraServiceImpl;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020!H&¨\u0006\""}, d2 = {"Lcom/larus/cdm/IFlowCompanionDeviceManager;", "", "config", "", "provider", "Lcom/larus/cdm/FlowCompanionDeviceConfigProvider;", "companionDeviceSupport", "", "createAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "fragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/activity/ComponentActivity;", "hasAssociated", "macAddress", "", "isDeviceBound", "sn", "removeBoundSn", "removeAllBoundSn", "addBoundSn", "disassociate", "getAssociatedDevices", "", "hasObservedPresence", "startObservingPresence", "stopObservingPresence", "addGlobalAppearListener", "listener", "Lcom/larus/cdm/FlowCompanionDeviceAppearListener;", "removeGlobalAppearListener", "setDeviceInfoProvider", "Lcom/larus/cdm/DeviceInfoProviderInterface;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowCompanionDeviceManager {
    void a(String r1);

    boolean b(String r1);

    boolean c(String r1);

    void d(String r1);

    void e(DoraServiceImpl.i r1);

    void f();

    void g(String r1);

    void h(DoraServiceImpl.h r1);

    void i(DoraServiceImpl.f r1);

    FlowCompanionDeviceAssociatorImpl j(Fragment r1);

    void k(String r1);

    List<String> l();

    boolean m(String r1);

    boolean n();
}
