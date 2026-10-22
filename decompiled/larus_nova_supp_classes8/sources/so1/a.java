package so1;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(b1 r15, int r16, String r17) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r15 == null) goto L5;
        Long r2 = Long.valueOf(r15.getId());
    L6:
        r0.put("banner_id", String.valueOf(r2));
        r0.put("request_page", "top");
        o r3 = j0.l().c(x.class);
        String r5 = "";
        if (r3.getMap().containsKey("event_page") == false) goto L10;
        String r4 = (String) r3.getMap().get("event_page");
        if (r4 == null) goto L10;
    L11:
        r0.put("event_page", r4);
        com.bytedance.android.livesdk.chatroom.o r6 = z51.a.h(null, 3);
        if (r6 == null) goto L28;
        m r7 = r6.getRoom();
        if (r7 == null) goto L28;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L28;
        String r9 = r8.getAnchorId();
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r0.put("anchor_id", r9);
        IMiddlewareUserService r10 = k.f(IMiddlewareUserService.class);
        if (r10 == null) goto L26;
        e r11 = r10.user();
        if (r11 == null) goto L26;
        String r12 = r11.n();
        if (r12 == null) goto L26;
    L27:
        r0.put("user_id", r12);
        r0.put("room_id", r8.getIdStr());
        r0.put("room_type", h1.b(r8));
        r0.put("log_pb", r8.getLog_pb());
    L26:
        r12 = "";
    L28:
        r0.put("banner_action", "auto");
        r0.put("index", String.valueOf(r16));
        com.bytedance.android.livesdk.chatroom.o r1 = z51.a.h(null, 3);
        if (r1 == null) goto L33;
        Boolean r13 = r1.isAnchor();
        if (r13 == null) goto L33;
        boolean r14 = r13.booleanValue();
    L34:
        r0.put("is_anchor", String.valueOf(r14));
        r0.put("log_id", String.valueOf(r17));
        if (r15 == null) goto L42;
        List r18 = r15.getTrackingTypes();
        if (r18 == null) goto L42;
        String r19 = CollectionsKt.joinToString$default(r18, ",", null, null, 0, null, null, 62, null);
        if (r19 == null) goto L42;
        r5 = r19;
    L42:
        r0.put("tracking_type", r5);
        j0.l().sendLog("livesdk_live_banner_show", r0, new Object[0]);
        if (v.a() == false) goto L46;
        ALogger.i("BannerTeaLog", "livesdk_live_banner_show: " + r0);
        return;
    L46:
        return;
    L33:
        r14 = false;
    L10:
        r4 = "";
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
