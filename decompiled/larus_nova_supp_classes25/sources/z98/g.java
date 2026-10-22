package z98;

import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.e.r;
import com.larus.avlink.plugins.c2;
import com.larus.avlink.plugins.k0;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final boolean a(com.larus.avlink.model.a r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
        return false;
    L5:
        com.larus.avlink.e.l r1 = com.larus.avlink.e.l.a;
        r r2 = com.larus.avlink.e.l.b;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L14;
    L15:
        DoraImageMode.a r4 = DoraImageMode.Companion;
        Integer r6 = Integer.valueOf(r5.m);
        r4.getClass();
        if (DoraImageMode.a.c(r6) == false) goto L20;
        if (r5.n == null) goto L20;
    L36:
        r0 = true;
    L37:
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("canUploadImageInfo: ");
        r8.append(r0);
        r8.append(". config: ");
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L42;
        VisionService r10 = r9.V();
        if (r10 == null) goto L42;
        Boolean r11 = Boolean.valueOf(r10.n());
    L43:
        r8.append(r11);
        r7.i("DoraVision", r8.toString());
        return r0;
    L42:
        r11 = null;
    L20:
        if (DoraImageMode.a.c(Integer.valueOf(r5.m)) == false) goto L36;
        if (c2.m == true) goto L36;
        if (k0.i == true) goto L36;
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L32;
        VisionService r13 = r12.V();
        if (r13 == null) goto L32;
        if (r13.n() != true) goto L32;
        boolean r14 = true;
    L33:
        if (r14 == false) goto L37;
        if (r5.m == 6) goto L37;
    L32:
        r14 = false;
        goto L33
    L14:
        if (r5.m == 6) goto L36;
    L8:
        if (r2.E() != true) goto L10;
        r3 = true;
        goto L12
    }
}
