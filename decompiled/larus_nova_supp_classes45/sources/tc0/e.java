package tc0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map.Entry a(String r5, Map r6) {
        if (r6 == null) goto L23;
        Set r7 = r6.entrySet();
        if (r7 == null) goto L23;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r8.next();
        g2 r2 = (g2) r1.getValue();
        if (r2 == null) goto L8;
        List r3 = r2.getLinkedUsers();
        if (r3 == null) goto L8;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        Object r9 = r4.next();
        if (Intrinsics.areEqual(((k) r9).getInteractId(), r5) == false) goto L15;
    L21:
        if (((k) r9) == null) goto L8;
        return r1;
    L19:
        r9 = null;
    L23:
        return null;
    }

    public static void b(ILinkPlayerInfoBridge r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        Map.Entry r4 = a(r2.getInteractId(), r3);
        if (r4 == null) goto L6;
        r2.setLinkRoomUser(true);
        r2.setLinkRoomId(((Number) r4.getKey()).longValue());
        r2.setRoomLinkSilenceStatus(((g2) r4.getValue()).getRoomLinkSilenceStatus());
        return;
    }
}
