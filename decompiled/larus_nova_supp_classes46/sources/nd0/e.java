package nd0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.user.IMiddlewareUserService;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final String a() {
        return k.n(IMiddlewareUserService.class).user().n();
    }

    public static final boolean c() {
        return ((IInteractService) k.n(IInteractService.class)).isAudienceLinkEngineOn();
    }

    public static final boolean b() {
        Boolean r0 = m.i().isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }
}
