package dl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q {
    public static final String a(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r5) {
        StringBuilder r0 = new StringBuilder("ListUsers{size=");
        r0.append(r5.size());
        r0.append(",");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.link.model.bridge.k r2 = (com.bytedance.android.livesdk.link.model.bridge.k) r6.next();
        r0.append("[");
        if (r2.getUser() == null) goto L8;
        r0.append("id=");
        IBaseUser r3 = r2.getUser();
        Intrinsics.checkNotNull(r3);
        r0.append(r3.getIdString());
        r0.append(",");
    L8:
        r0.append("pos=");
        r0.append(r2.getUserPosition());
        r0.append(",silence=");
        r0.append(r2.getSilenceStatus());
        r0.append(",linkId=");
        r0.append(r2.getLinkMicIdStr());
        r0.append(",linkType=");
        r0.append(r2.getLinkType());
        r0.append(",isBg=");
        r0.append(r2.isBackground());
        r0.append(",mc=");
        r0.append(r2.getMcStatus());
        r0.append(",isCPos=");
        r0.append(CPositionModeUtil.isCPositionUser(r2));
        r0.append("]");
        goto L4
    L9:
        r0.append("}");
        return r0.toString();
    }
}
