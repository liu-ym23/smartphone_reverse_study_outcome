package vi0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jc1.k;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final boolean a(DataCenter r4) {
        boolean r0 = k.n(IMiddlewareUserService.class).user().isAdmin();
        IBaseUser r1 = null;
        if (r4 == null) goto L6;
        r1 = (IBaseUser) r4.get("data_user_in_room", null);
    L6:
        if (r1 == null) goto L14;
        t r2 = r1.getUserAttr();
        if (r2 == null) goto L14;
        List r3 = r2.getAdminPrivileges();
        if (r3 == null) goto L14;
        LiveRoomPermission.D.getClass();
        if (r3.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L14;
        boolean r5 = true;
    L15:
        if (r0 == false) goto L19;
        if (r5 == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L14:
        r5 = false;
        goto L15
    }
}
