package com.larus.dora.dorag.res;

import com.byted.cast.common.sink.ClientInfo;
import com.byted.cast.common.sink.IServerListener;
import com.byted.cast.common.sink.ServerInfo;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements IServerListener {
    public final /* synthetic */ DoraByteCastManager a;

    public m(DoraByteCastManager r1) {
        this.a = r1;
    }

    public final void onStop(int r5) {
        FLogger.a.i(this.a.a, "server onStop. serviceId: " + r5 + ", currentRTCChannelConfigs: " + this.a.A);
        List<b49.c> r6 = this.a.A;
        if (r6 == null) goto L9;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        AbilityService r1 = r0.o0();
        if (r1 == null) goto L9;
        r1.u(r6);
    L9:
        this.a.A = null;
    }

    public final void onConnect(int r9, ClientInfo r10) {
        FLogger.a.i(this.a.a, "server onConnect. id: " + r9 + ", info: " + r10);
        String r1 = null;
        this.a.s = null;
        DoraByteCastManager r0 = this.a;
        r0.y(Boolean.FALSE);
        r0.u = false;
        if (r10 == null) goto L14;
        String r3 = r10.clientID;
        if (r3 == null) goto L14;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L14;
    L19:
        if (r10 == null) goto L21;
        r1 = r10.ip;
    L21:
        boolean r11 = !Intrinsics.areEqual(r1, "127.0.0.1");
        DoraByteCastManager r12 = this.a;
        Map<String, Boolean> r2 = r12.h;
        monitor-enter(r2);
        if (r11 == true) goto L36;
    L27:
        if (r11 == true) goto L29;
    L30:
        r12.h.put(r3, Boolean.valueOf(r11));     // Catch: Throwable -> L25
    L31:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r2);
        return;
    L25:
        th = move-exception;
        throw th;
    L29:
        if (r12.j == true) goto L31;
    L36:
        CollectionsKt.removeAll(((LinkedHashMap) r12.h).entrySet(), new l());     // Catch: Throwable -> L25
        r12.i++;     // Catch: Throwable -> L25
        r12.k.set(false);     // Catch: Throwable -> L25
        goto L27
    L9:
        r4 = false;
    L14:
        StringBuilder r5 = new StringBuilder();
        if (r10 == null) goto L17;
        String r6 = r10.ip;
    L18:
        r5.append(r6);
        r5.append(':');
        r5.append(r9);
        r3 = r5.toString();
        goto L19
    L17:
        r6 = null;
        goto L18
    }

    public final void onDisconnect(int r12, ClientInfo r13) {
        if (r13 == null) goto L14;
        String r3 = r13.clientID;
        if (r3 == null) goto L14;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L14;
    L19:
        DoraByteCastManager r5 = this.a;
        Map<String, Boolean> r6 = r5.h;
        monitor-enter(r6);
        boolean r7 = Intrinsics.areEqual(r5.h.remove(r3), Boolean.TRUE);     // Catch: Throwable -> L83
        if (r7 == false) goto L24;
        r5.i++;     // Catch: Throwable -> L83
    L24:
        boolean r8 = r5.h.isEmpty();     // Catch: Throwable -> L83
        if (r8 == false) goto L27;
        r5.s = null;     // Catch: Throwable -> L83
        r5.o();     // Catch: Throwable -> L83
    L27:
        Triple r0 = new Triple(Boolean.valueOf(r8), Boolean.valueOf(r7), Long.valueOf(r5.i));     // Catch: Throwable -> L83
        monitor-exit(r6);
        boolean r9 = ((Boolean) r0.component1()).booleanValue();
        boolean r10 = ((Boolean) r0.component2()).booleanValue();
        long r11 = ((Number) r0.component3()).longValue();
        boolean r1 = this.a.k.get();
        FLogger.a.i(this.a.a, "server onDisconnect. id: " + r12 + ", info: " + r13 + ", isLastClient: " + r9 + ", wasP2PClient=" + r10 + ", retainForCompanion=" + r1);
        DoraByteCastManager r14 = this.a;
        r14.y(Boolean.FALSE);
        r14.u = false;
        DoraByteCastManager r15 = this.a;
        Map<String, Boolean> r16 = r15.h;
        monitor-enter(r16);
        if (r10 == true) goto L92;
    L52:
        boolean r2 = false;
    L53:
        if (r2 == false) goto L58;
        r15.j = true;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    L58:
        monitor-exit(r16);
        if (r2 == true) goto L86;
        return;
    L86:
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L73
        if (r17 == null) goto L65;
        AbilityService r18 = r17.o0();     // Catch: Throwable -> L73
        if (r18 == null) goto L65;
        r18.a();     // Catch: Throwable -> L73
    L65:
        DoraByteCastManager r110 = this.a;
        Map<String, Boolean> r111 = r110.h;
        monitor-enter(r111);
        r110.j = false;     // Catch: Throwable -> L70
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L70
        monitor-exit(r111);
        return;
    L70:
        th = move-exception;
        throw th;
    L73:
        th = move-exception;
        DoraByteCastManager r113 = this.a;
        monitor-enter(r113.h);
        r113.j = false;     // Catch: Throwable -> L79
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L79
        throw th;
    L79:
        th = move-exception;
        throw th;
    L92:
        if (r11 != r15.i) goto L52;
        Collection r20 = ((LinkedHashMap) r15.h).values();     // Catch: Throwable -> L50
        if ((r20 instanceof Collection) == true) goto L37;
    L39:
        Iterator r21 = r20.iterator();     // Catch: Throwable -> L50
    L41:
        if (r21.hasNext() == false) goto L45;
        if (((Boolean) r21.next()).booleanValue() == false) goto L41;
        boolean r22 = false;
    L46:
        if (r22 == false) goto L52;
        if (r15.k.get() == true) goto L52;
        r2 = true;
    L45:
        r22 = true;
        goto L46
    L37:
        if (r20.isEmpty() == false) goto L39;
    L83:
        th = move-exception;
        throw th;
    L9:
        r4 = false;
    L14:
        StringBuilder r23 = new StringBuilder();
        if (r13 == null) goto L17;
        String r24 = r13.ip;
    L18:
        r23.append(r24);
        r23.append(':');
        r23.append(r12);
        r3 = r23.toString();
        goto L19
    L17:
        r24 = null;
        goto L18
    }

    public final void onStart(int r6, ServerInfo r7) {
        DoraByteCastManager r0 = this.a;
        Object r1 = r0.d;
        monitor-enter(r1);
        r0.c = true;     // Catch: Throwable -> L22
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L22
        r2.i(r0.a, "onSuccess: canSetByteCastRandomPortOption = true");     // Catch: Throwable -> L22
        r0.w("onStart");     // Catch: Throwable -> L22
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r1);
        String r4 = this.a.a;
        StringBuilder r5 = new StringBuilder("server onStart. serviceId: ");
        r5.append(r6);
        r5.append(", serverInfo: ");
        r5.append(r7);
        r5.append(", IDoraService:");
        r5.append(ServiceManager.get().getService(IDoraService.class));
        r5.append(", ability:");
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L10;
        AbilityService r9 = r8.o0();
    L11:
        r5.append(r9);
        r2.i(r4, r5.toString());
        if (r7 == null) goto L14;
        int r10 = r7.serverPort;
    L15:
        b49.c r11 = new b49.c(0, r10, InetAddress.getByName("localhost"));
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L20;
        AbilityService r13 = r12.o0();
        if (r13 == null) goto L20;
        r13.o(CollectionsKt.listOf(r11));
    L20:
        DoraByteCastManager r14 = this.a;
        r14.A = CollectionsKt.listOf(r11);
        return;
    L14:
        r10 = 0;
        goto L15
    L10:
        r9 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final void onError(int r5, int r6, String r7) {
        FLogger r0 = FLogger.a;
        r0.e(this.a.a, "server onError. serviceId: " + r5 + ", errCode: " + r6 + ", errMsg: " + r7);
        DoraByteCastManager r8 = this.a;
        Object r9 = r8.d;
        monitor-enter(r9);
        r8.c = true;     // Catch: Throwable -> L8
        r0.i(r8.a, "onError: canSetByteCastRandomPortOption = true");     // Catch: Throwable -> L8
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r9);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
