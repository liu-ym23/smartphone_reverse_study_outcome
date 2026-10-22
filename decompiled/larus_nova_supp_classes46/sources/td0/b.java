package td0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.log.j0;
import hd0.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final Map<Integer, String> a = null;

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        a = r0;
        r0.put(1, "like");
        r0.put(2, "favorite");
        r0.put(3, "create");
        r0.put(4, "watched");
    }

    public static void b(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        r2.put("user_type", "anchor");
        return;
    L5:
        r2.put("user_type", "guest");
    }

    public static void c(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L6;
        r2.put("user_type", "anchor");
        return;
    L6:
        if (c.f().h() == false) goto L8;
        r2.put("user_type", "guest");
        return;
    L8:
        r2.put("user_type", "audience");
    }

    public static void a(String r2, long r3, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r0);
        r0.put("anchor_id", r2.toString());
        r0.put("room_id", String.valueOf(r3));
        b(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        LinkedHashMap r4 = (LinkedHashMap) a;
        String r7 = (String) r4.get(Integer.valueOf(r5));
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r0.put("tab_show", r7);
        r0.put("item_num", String.valueOf(r6));
        j0.l().sendLog("livesdk_video_comment_list_show", r0, new Object[0]);
        ALogger.i("LiveVideoCommentPlayLog", "livesdk_video_comment_list_show: tab_show =" + ((String) r4.get(Integer.valueOf(r5))) + ", itemNum=" + r6);
    }
}
