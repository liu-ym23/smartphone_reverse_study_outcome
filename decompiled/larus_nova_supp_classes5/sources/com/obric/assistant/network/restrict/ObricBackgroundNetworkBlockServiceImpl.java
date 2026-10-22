package com.obric.assistant.network.restrict;

import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.larus.common.apphost.AppHost;
import com.larus.network.config.BackgroundControlConfig;
import com.larus.network.config.BackgroundNetworkModeConfig;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.assistant.audio.IObricAudioStatusMonitorService;
import com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService;
import com.obric.assistant.frontier.IObricFrontierStatusMonitorService;
import com.obric.assistant.network.api.INetworkInterceptorService;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.obric.assistant.state.ObricSharedStateDelegate;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hm9.b0;
import hm9.h;
import hm9.k;
import hm9.s;
import hm9.t;
import hm9.u;
import hm9.y;
import hm9.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import yea.b;
import yea.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u000f\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/network/restrict/ObricBackgroundNetworkBlockServiceImpl;", "Lcom/obric/assistant/common/spi/network/IObricBackgroundNetworkBlockService;", "<init>", "()V", "TAG", "", "shouldBlockNonDoraUserForObric", "", "()Ljava/lang/Boolean;", "triggerBackgroundNetworkRestrictIfNeeded", "", "initNetworkRestrict", "getAssistantState", "isMainProcessBackground", "registerMainProcessBackgroundListener", "listener", "Lcom/obric/assistant/common/spi/network/MainProcessBackgroundListener;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBackgroundNetworkBlockServiceImpl implements IObricBackgroundNetworkBlockService {
    public final String a;

    public final Boolean a() {
        return ObricSharedStateDelegate.c.e("flow_app_background");
    }

    public final void c() {
        e10 r0 = e10.a;
        BackgroundControlConfig r1 = e10.A();
        FLogger r2 = FLogger.a;
        r2.i(this.a, "runInternal: in " + q0.b(AppHost.a.getApplication()) + ", init network restrict " + r1);
        int r3 = h.a;
        Intrinsics.checkNotNullParameter(r1, "config");
        r2.i("ObricBackgroundNetworkRestrict", "init obric background network restrict: " + r1);
        if (Intrinsics.areEqual(r1.getEnable(), Boolean.FALSE) == false) goto L5;
        r2.i("ObricBackgroundNetworkRestrict", "obric background network restrict is disabled");
        return;
    L5:
        y r4 = new y(new hm9.a(new k(new j(new z(new b0())))));
        e r5 = new e();
        r5.a = r4;
        u r6 = new u(new t(r5));
        i r7 = new i(Intrinsics.areEqual(r1.getEnable(), Boolean.TRUE));
        r7.b = r6;
        hm9.j r8 = hm9.j.a;
        Intrinsics.checkNotNullParameter(r7, "handler");
        hm9.j.i = r7;
        NativeRequestInterceptor.a = new g();
        BackgroundNetworkModeConfig r9 = r1.getBackgroundNetworkModeConfig();
        boolean r10 = false;
        if (r9 == null) goto L8;
        boolean r11 = r9.getClearPool();
    L10:
        if (r11 == true) goto L54;
        r2.i("ObricBackgroundNetworkRestrict", "configureBgcpAllowlistIfNeeded skip, clearPool disabled");
    L17:
        if (c.a.compareAndSet(false, true) == false) goto L19;
        FLogger.a.i("ObricAIagentNetworkConfigManager", "init");
        ft9.k r12 = ft9.k.a;
        a r13 = c.c;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "listener");
        SettingsManager.registerListener(new ft9.j(r13), false);
        BuildersKt.launch$default(c.b, null, null, new ObricAIagentNetworkConfigManager$updateRules$1(null), 3, null);
    L19:
        boolean r14 = GlobalNetworkGate.a;
        if (Intrinsics.areEqual(r1.getEnable(), Boolean.TRUE) == false) goto L29;
        BackgroundNetworkModeConfig r15 = r1.getBackgroundNetworkModeConfig();
        if (r15 != null) goto L24;
    L26:
        boolean r16 = false;
    L27:
        if (r16 == false) goto L29;
        r10 = true;
        goto L29
    L24:
        if (r15.getMode() != 2) goto L26;
        r16 = true;
    L29:
        GlobalNetworkGate.b = r10;
        em9.a r17 = r1.getNetworkInterceptorConfig();
        if (r17 == null) goto L36;
        ArrayList r18 = r17.d();
        if (r18 == null) goto L36;
        List r19 = CollectionsKt.filterNotNull(r18);
        if (r19 == null) goto L36;
        List r20 = r19;
    L37:
        Intrinsics.checkNotNullParameter(r20, "hosts");
        Set r21 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r20), new c()), new yea.d()));
        if (r21.isEmpty() == true) goto L41;
        GlobalNetworkGate.c = SetsKt.plus(GlobalNetworkGate.c, r21);
    L41:
        em9.a r22 = r1.getNetworkInterceptorConfig();
        if (r22 == null) goto L48;
        ArrayList r23 = r22.e();
        if (r23 == null) goto L48;
        List r24 = CollectionsKt.filterNotNull(r23);
        if (r24 == null) goto L48;
        List r25 = r24;
    L49:
        Intrinsics.checkNotNullParameter(r25, "paths");
        Set r26 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r25), new yea.a()), new b()));
        if (r26.isEmpty() == true) goto L57;
        GlobalNetworkGate.d = SetsKt.plus(GlobalNetworkGate.d, r26);
        return;
    L57:
        return;
    L48:
        r25 = new ArrayList();
    L36:
        r20 = new ArrayList();
        goto L37
    L54:
        s r27 = hm9.j.h;     // Catch: Exception -> L14
        ArrayList r28 = r27.o;     // Catch: Exception -> L14
        ArrayList r29 = r27.p;     // Catch: Exception -> L14
        String r30 = new JSONArray(r28).toString();     // Catch: Exception -> L14
        String r31 = new JSONArray(r29).toString();     // Catch: Exception -> L14
        r2.i("ObricBackgroundNetworkRestrict", "configureBgcpAllowlist, ALLOW_HOST_LIST=" + r30 + ", ALLOW_PATH_LIST=" + r31);     // Catch: Exception -> L14
        HashMap r32 = new HashMap();     // Catch: Exception -> L14
        r32.put("x-ttnet-bgcp-hosts", r30);     // Catch: Exception -> L14
        r32.put("x-ttnet-bgcp-paths", r31);     // Catch: Exception -> L14
        TTNetProtocolUtil.sendTTNetProtocolRequest("background-clear-pool", "/set", null, r32);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e("ObricBackgroundNetworkRestrict", "configureBgcpAllowlistIfNeeded failed", e);
        goto L17
    L8:
        r11 = false;
        goto L10
    }

    public final boolean d() {
        IObricStateDispatcherService r0 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r0 == null) goto L7;
        ObricAssistantAliveLockState r1 = r0.a();
        if (r1 == null) goto L7;
        ObricAssistantAliveLockStateType r2 = r1.getCurrentState();
    L9:
        if (r2 != ObricAssistantAliveLockStateType.ACQUIRED) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public ObricBackgroundNetworkBlockServiceImpl() {
        this.a = "ObricBackgroundNetworkBlockService";
    }

    public final void f() {
        IObricStateDispatcherService r1 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);     // Catch: Throwable -> L26
        if (r1 == null) goto L8;
        ObricAssistantAliveLockState r2 = r1.a();     // Catch: Throwable -> L26
        if (r2 == null) goto L8;
        ObricAssistantAliveLockStateType r3 = r2.getCurrentState();     // Catch: Throwable -> L26
    L10:
        if (r3 != ObricAssistantAliveLockStateType.ACQUIRED) goto L12;
        boolean r4 = true;
    L13:
        FLogger.a.i(this.a, "triggerBackgroundNetworkRestrictIfNeeded, aliveState=" + r3 + ", isActive=" + r4);     // Catch: Throwable -> L26
        if (r4 == false) goto L16;
        return;
    L16:
        IObricFrontierStatusMonitorService r0 = (IObricFrontierStatusMonitorService) ServiceManager.get().getService(IObricFrontierStatusMonitorService.class);     // Catch: Throwable -> L26
        if (r0 == null) goto L19;
        r0.a(true);     // Catch: Throwable -> L26
    L19:
        IObricAudioStatusMonitorService r5 = (IObricAudioStatusMonitorService) ServiceManager.get().getService(IObricAudioStatusMonitorService.class);     // Catch: Throwable -> L26
        if (r5 == null) goto L22;
        r5.a(true);     // Catch: Throwable -> L26
    L22:
        INetworkInterceptorService r6 = (INetworkInterceptorService) ServiceManager.get().getService(INetworkInterceptorService.class);     // Catch: Throwable -> L26
        if (r6 == null) goto L31;
        r6.a(true);     // Catch: Throwable -> L26
        return;
    L31:
        return;
    L12:
        r4 = false;
    L8:
        r3 = null;
    L26:
        th = move-exception;
        FLogger.a.e(this.a, "triggerBackgroundNetworkRestrictIfNeeded error", th);
    }

    public final Boolean e() {
        return Boolean.TRUE;
    }

    public final void b(h r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        SharedState.INSTANCE.registerObserver(CollectionsKt.listOf("flow_app_background"), new f(this, r4));
    }
}
