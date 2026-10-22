package mi8;

import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static IMoaGrantingAppletService a() {
        return (IMoaGrantingAppletService) ServiceManager.get().getService(IMoaGrantingAppletService.class);
    }
}
