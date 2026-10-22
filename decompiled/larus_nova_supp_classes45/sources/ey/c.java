package ey;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final String b() {
        return jc1.k.n(IMiddlewareUserService.class).user().n();
    }

    public static final boolean a(if r3) {
        if (r3 == null) goto L4;
        LinkerInviteContent r0 = r3.mInvite;
    L6:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r3.mInvite.getInviteSource() != 2) goto L20;
        List r4 = r3.mInvite.getInviterUsers();
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r4.isEmpty() == true) goto L16;
        r5 = false;
        goto L17
    L20:
        return false;
    L4:
        r0 = null;
        goto L6
    }
}
