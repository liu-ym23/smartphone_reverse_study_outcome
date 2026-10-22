package sr8;

import com.larus.bmhome.share.api.IConversationSharePanelService;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.platform.service.n0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ga9.e;
import java.util.concurrent.atomic.AtomicReference;
import wa9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        if (n0.a.b() == true) goto L5;
        return false;
    L5:
        int r0 = a.a;
        a r1 = new a(0);
        AtomicReference r2 = ga9.a.a;
        e.a.getClass();
        if (((a) e.a(ga9.a.c(ShareChannel.SHARE, e.c(r1)), a.class, r1)).a() == 1) goto L8;
        return false;
    L8:
        IConversationSharePanelService r3 = (IConversationSharePanelService) ServiceManager.get().getService(IConversationSharePanelService.class);
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.isAvailable() != true) goto L15;
        return true;
    L15:
        return false;
    }
}
