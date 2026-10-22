package zq0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentScene();
    L7:
        if (r1 != 8) goto L9;
    L10:
        return true;
    L9:
        if (r1 == 12) goto L10;
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    static {
    }
}
