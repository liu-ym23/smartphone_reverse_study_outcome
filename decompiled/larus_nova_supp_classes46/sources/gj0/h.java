package gj0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public h() {
    }

    static {
    }

    public static void a(Context r7, Map r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r7, "context");
        Long r3 = null;
        u6 r0 = new u6((String) vm2.d.X3.getValue(null, vm2.d.a[255(0xff, float:3.57E-43)]));
        u6 r2 = r0.d("url");
        if (r8 == null) goto L8;
        Iterator r4 = r8.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Map.Entry r5 = (Map.Entry) r4.next();
        r2.b((String) r5.getKey(), (String) r5.getValue());
    L8:
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r0.a.put("url", r2);
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L11;
        IRoom r6 = (IRoom) r1.getValue();
    L12:
        LinkedHashMap r10 = new LinkedHashMap();
        if (r6 == null) goto L15;
        r3 = Long.valueOf(r6.getId());
    L15:
        r10.put("room_id", String.valueOf(r3));
        if (r6 == null) goto L19;
        String r11 = r6.getOwnerUserIdString();
        if (r11 == null) goto L19;
    L20:
        r10.put("anchor_id", r11);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r12 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r12 == null) goto L24;
        String r13 = String.valueOf(r12.b());
        if (r13 == null) goto L24;
    L25:
        r10.put("user_cnt", r13);
        r10.put("action_from", "start");
        r10.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r6 != null) goto L28;
    L30:
        String r14 = "video_live";
    L31:
        r10.put("live_type", r14);
        r10.put("business_type", "starWish");
        r10.put("user_id", k.n(IMiddlewareUserService.class).user().n().toString());
        if (r8 == null) goto L38;
        Iterator r15 = r8.entrySet().iterator();
    L35:
        if (r15.hasNext() == false) goto L38;
        Map.Entry r16 = (Map.Entry) r15.next();
        r10.put(r16.getKey(), r16.getValue());
    L38:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L40;
        String r17 = "anchor";
    L41:
        r10.put("user_type", r17);
        Iterator r18 = r10.entrySet().iterator();
    L43:
        if (r18.hasNext() == false) goto L45;
        Map.Entry r19 = (Map.Entry) r18.next();
        r2.b((String) r19.getKey(), (String) r19.getValue());
        goto L43
    L45:
        if (r9 == false) goto L47;
        j0.l().sendLog("livesdk_chatroom_game_starwish_icon_click", r10, new Object[]{IRoom.class});
    L47:
        k.n(IBaseLiveActionHandler.class).handle(r7, r0.c());
        return;
    L40:
        r17 = "admin";
        goto L41
    L28:
        if (r6.isLiveTypeAudio() != true) goto L30;
        r14 = "voice_live";
    L24:
        r13 = "0";
    L19:
        r11 = "";
        goto L20
    L11:
        r6 = null;
        goto L12
    }

    public static /* synthetic */ void b(Context r0, Map r1, int r2) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        a(r0, r1, false);
    }
}
