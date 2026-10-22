package l91;

import am2.x;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(IBaseUser r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        LinkedHashMap r0 = new LinkedHashMap();
        f r5 = r4.getBorder();
        if (r5 == null) goto L6;
        String r6 = r5.getDressId();
        if (r6 == null) goto L6;
    L7:
        r0.put("wear_id", r6);
        j0.l().sendLog("livesdk_user_icon_show", r0, new Object[]{x.class, IRoom.class});
        return;
    L6:
        r6 = "none";
        goto L7
    }
}
