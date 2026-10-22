package com.obric.assistant.frontier;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.state.api.v2.core.ObricDeviceStateDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g2a.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/frontier/ObricFrontierStatusMonitorService;", "Lcom/obric/assistant/frontier/IObricFrontierStatusMonitorService;", "<init>", "()V", "init", "", "onObricStatusChanged", "isDeactive", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFrontierStatusMonitorService implements IObricFrontierStatusMonitorService {
    public ObricFrontierStatusMonitorService() {
    }

    public final void init() {
        Lazy r0 = d.a;
        com.larus.im.f r1 = d.c();
        if (r1 == null) goto L5;
        r1.k();
    L5:
        AccountService.a.E(d.h);
        ObricDeviceStateDelegate.b.b(new e());
        AppHost.a.a().j(new f());
        com.larus.im.f r2 = d.c();
        if (r2 == null) goto L8;
        r2.j(new g());
    L8:
        d.g = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricFrontierStatusMonitor$init$4(null), 3, null);
    }

    public final void a(boolean r10) {
        Lazy r0 = d.a;
        FLogger r1 = FLogger.a;
        r1.i("ObricFrontierStatusMonitor", "notifyObricStatusChanged, " + r10);
        if (AppHost.a.isTestChannel() == false) goto L5;
        r1.d("ObricFrontierStatusMonitor", "Test, notifyObricStatusChanged, x-tt-token: " + d.b(AccountService.a.getXTTToken()));
    L5:
        d.d = r10;
        if (r10 == false) goto L19;
        if (d.b() == false) goto L19;
        Job r11 = d.f;
        if (r11 == null) goto L12;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L12:
        com.larus.im.f r12 = d.c();
        if (r12 == null) goto L15;
        r12.h("obricAssistantDeactive", false);
    L15:
        IObricNetworkService r13 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r13 == null) goto L28;
        r13.f(true);
        return;
    L28:
        return;
    L19:
        if (d.d == true) goto L24;
        IObricNetworkService r14 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r14 == null) goto L23;
        r14.f(false);
    L23:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricFrontierStatusMonitor.notifyObricStatusChanged.1(null), 3, null);
        return;
    L24:
        Job r15 = d.f;
        if (r15 == null) goto L31;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
        return;
    }
}
