package t69;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.i;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import vk4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q implements h {
    public /* synthetic */ q() {
    }

    public final void a(int r11, int r12, String r13) {
        w88.t r1 = null;
        if (Intrinsics.areEqual(r13, FlowDoraConnectReason.P2P_CHECK_WIFI_NOT_OPEN) == false) goto L5;
        FLogger.a.i("FlowDoraWifiStateManager", "ignore P2P_CHECK_WIFI_NOT_OPEN in obric mode");
        String r0 = null;
    L6:
        FLogger r3 = FLogger.a;
        r3.i("FlowDoraWifiStateManager", "onStateChanged: oldState=" + r11 + ", newState=" + r12 + ", reason=" + r13 + ", flowReason=" + r0);
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L9;
        AbilityService r5 = r4.o0();
    L10:
        IDoraAVLinkService r6 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r6 == null) goto L13;
        r1 = r6.A();
    L13:
        int r7 = t.a;
        boolean r8 = false;
        if (r5 != null) goto L16;
    L18:
        boolean r9 = false;
    L19:
        if (r1 == null) goto L21;
        boolean r2 = true;
    L23:
        if (r11 != 2) goto L28;
        if (r12 != 0) goto L28;
        if (r9 == false) goto L28;
        if (r2 == false) goto L28;
        r8 = true;
    L28:
        if (r8 == false) goto L33;
        r3.e("FlowDoraWifiStateManager", "P2P RTC runtime disconnected, release P2P and keep current RTC video call: state=" + r11 + "->" + r12 + ", reason=" + r13);
        if (r5 == null) goto L33;
        r5.a();
    L33:
        Iterator<i> r14 = s.a.iterator();
    L35:
        if (r14.hasNext() == false) goto L37;
        r14.next().f(r11, r12, r0);
        goto L35
    L37:
        return;
    L21:
        r2 = false;
        goto L23
    L16:
        if (r5.j() != true) goto L18;
        r9 = true;
        goto L19
    L9:
        r5 = null;
        goto L10
    L5:
        r0 = r13;
        goto L6
    }
}
