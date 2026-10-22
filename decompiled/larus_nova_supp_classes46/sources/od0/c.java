package od0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    static {
    }

    public static void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Boolean r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.getValue();
    L7:
        if (RoomKt.isValid(r2) == false) goto L9;
        IRoom r3 = r2;
    L10:
        if (r3 == null) goto L26;
        BaseMonitor.add(r5, "room_id", r3.getIdStr());
        if (RoomKt.isValid(r2) == false) goto L14;
        String r4 = r3.getOwnerUserIdString();
    L15:
        BaseMonitor.add(r5, "anchor_id", r4);
        switch(b.a[LiveMode.Companion.valueOf((int) r3.getLiveRoomMode()).ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            default: goto L17;
        };
    L17:
        String r6 = "unknown:" + r3.getLiveRoomMode();
    L25:
        BaseMonitor.add(r5, "room_type", r6);
        BaseMonitor.add(r5, "room_visibility_range", r3.getVisibilityRange());
        goto L26
    L18:
        r6 = "acquaintance";
        goto L25
    L19:
        r6 = "vs_live";
        goto L25
    L20:
        r6 = "media";
        goto L25
    L21:
        r6 = "screen_record";
        goto L25
    L22:
        r6 = "obs";
        goto L25
    L23:
        r6 = "audio";
        goto L25
    L24:
        r6 = "video";
        goto L25
    L14:
        r4 = "0";
    L26:
        IMiddlewareUserService r7 = k.f(IMiddlewareUserService.class);
        if (r7 == null) goto L29;
        e r8 = r7.user();
    L30:
        if (r8 == null) goto L32;
        IBaseUser r9 = r8.b();
    L33:
        if (r9 == null) goto L35;
        String r10 = r9.getIdString();
    L36:
        BaseMonitor.add(r5, "current_user_id", r10);
        m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L42;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L42;
        Object r13 = r12.getOwnerUserIdString();
        if (r13 == null) goto L42;
    L43:
        IMiddlewareUserService r14 = k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L46;
        e r15 = r14.user();
    L47:
        if (r15 == null) goto L49;
        IBaseUser r16 = r15.b();
    L50:
        if (r16 == null) goto L52;
        String r17 = r16.getIdString();
    L53:
        IInteractService r18 = (IInteractService) k.f(IInteractService.class);
        if (r18 == null) goto L56;
        Boolean r19 = Boolean.valueOf(r18.isAudienceLinkEngineOn());
    L58:
        if (Intrinsics.areEqual(r13.toString(), r17) == false) goto L61;
        String r20 = "anchor";
    L64:
        BaseMonitor.add(r5, "current_user_role", r20);
        IMiddlewareUserService r21 = k.f(IMiddlewareUserService.class);
        if (r21 == null) goto L67;
        e r22 = r21.user();
    L68:
        if (r22 == null) goto L70;
        Boolean r23 = Boolean.valueOf(r22.isAdmin());
    L71:
        if (r22 == null) goto L73;
        r1 = Boolean.valueOf(r22.c());
    L73:
        Boolean r24 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r24) == false) goto L77;
        String r25 = "link_admin";
    L80:
        BaseMonitor.add(r5, "admin_type", r25);
        return;
    L77:
        if (Intrinsics.areEqual(r23, r24) == false) goto L79;
        r25 = "admin";
        goto L80
    L79:
        r25 = "normal";
        goto L80
    L70:
        r23 = null;
        goto L71
    L67:
        r22 = null;
        goto L68
    L61:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == false) goto L63;
        r20 = "audience";
        goto L64
    L63:
        r20 = "guest";
        goto L64
    L56:
        r19 = null;
        goto L58
    L52:
        r17 = null;
        goto L53
    L49:
        r16 = null;
        goto L50
    L46:
        r15 = null;
    L42:
        r13 = 0L;
        goto L43
    L35:
        r10 = null;
        goto L36
    L32:
        r9 = null;
        goto L33
    L29:
        r8 = null;
        goto L30
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }
}
