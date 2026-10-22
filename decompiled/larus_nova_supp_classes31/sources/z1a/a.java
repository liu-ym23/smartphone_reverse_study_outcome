package z1a;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.xo;
import com.larus.update.IBitsUpdate;
import com.larus.update.IGpUpdate;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final a a = null;
    public static final String b = null;

    public a() {
    }

    static {
        a = new a();
        b = a.class.getSimpleName();
    }

    public static void a(boolean r2) {
        if (b(3) == false) goto L5;
        return;
    L5:
        e10 r0 = e10.a;
        int r1 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new xo())).booleanValue() == true) goto L10;
        FLogger.a.i(b, "checkUpdate, return by custom pre install");
        return;
    L10:
        if (AppHost.a.isOversea() == false) goto L15;
        IGpUpdate r3 = (IGpUpdate) ServiceManager.get().getService(IGpUpdate.class);
        if (r3 == null) goto L19;
        r3.a();
        return;
    L19:
        return;
    L15:
        IBitsUpdate r4 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r4 == null) goto L20;
        r4.checkUpdate(r2);
        return;
    }

    public static boolean b(int r4) {
        String r0 = AppHost.a.getApplication().getPackageName();
        if (Intrinsics.areEqual(r0, "com.larus.nova.dorag") == false) goto L9;
        IDoraAVLinkService r1 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r1 != null) goto L7;
    L10:
        return false;
    L7:
        if (r1.E1(r4) != true) goto L10;
        return true;
    L9:
        FLogger.a.i(b, "not g package, packageName is " + r0);
        goto L10
    }
}
