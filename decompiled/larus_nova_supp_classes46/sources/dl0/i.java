package dl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements a<c.AbstractC0198c, LinkPlayerInfo> {
    public static final c.AbstractC0198c.a a = null;
    public static WeakReference<LinkPlayerInfo> b;
    public static final i c = null;

    public i() {
    }

    static {
        c = new i();
        a = c.AbstractC0198c.a.a;
    }

    @Override // dl0.a
    public final c b() {
        return a;
    }

    @Override // dl0.a
    public final void c(View r13) {
        Intrinsics.checkNotNullParameter(r13, "view");
        WeakReference<LinkPlayerInfo> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        LinkPlayerInfo r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        MicPosTagInfo r2 = r1.micPosTagInfo;
        if (r2 != null) goto L11;
        return;
    L11:
        TextView r14 = (TextView) r13.findViewById(2131390752);
        if (r14 == null) goto L14;
        r14.setText(r2.getPositionTagName());
    L14:
        el0.j.a(r14);
        if (r14 == null) goto L17;
        Integer r3 = Integer.valueOf(r14.getVisibility());
    L19:
        if (r3.intValue() != 0) goto L21;
    L66:
        if (r14 == null) goto L69;
        r14.setOnClickListener(new h());
        return;
    L69:
        return;
    L21:
        if (r14 == null) goto L24;
        r14.setVisibility(0);
    L24:
        if (r1.mHasExposed == true) goto L66;
        Intrinsics.checkNotNullParameter("apply_list", "showPageName");
        Intrinsics.checkNotNullParameter(r2, "tagInfo");
        RoomContext.a r4 = RoomContext.Companion;
        RoomContext r8 = RoomContext.a.c(r4, null, 0, 3);
        if (r8 == null) goto L30;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L30;
        Room r10 = (Room) r9.getValue();
    L31:
        LinkedHashMap r11 = new LinkedHashMap();
        if (r10 == null) goto L34;
        Long r12 = Long.valueOf(r10.id);
    L35:
        r11.put("room_id", String.valueOf(r12));
        if (r10 == null) goto L38;
        String r15 = r10.getOwnerUserIdString();
    L39:
        r11.put("anchor_id", String.valueOf(r15));
        Integer r16 = Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene());
        LinkedHashMap r17 = new LinkedHashMap();
        el0.j.j(r17, r16);
        String r18 = (String) r17.get("function_type");
        if (r18 != null) goto L42;
        r18 = "live";
    L42:
        r11.put("function_type", r18);
        if (r10 != null) goto L45;
    L47:
        String r19 = "video_live";
    L48:
        r11.put("live_type", r19);
        RoomContext r5 = RoomContext.a.c(r4, null, 0, 3);
        if (r5 == null) goto L56;
        com.bytedance.live.datacontext.i r6 = r5.isAnchor();
        if (r6 == null) goto L56;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L56;
        String r7 = "anchor";
    L65:
        r11.put("user_type", r7);
        r11.put("play_mode", w.a());
        r11.put("show_page_name", "apply_list");
        r11.put("tag_type", String.valueOf(r2.getTagType()));
        r11.put("resource_name", String.valueOf(r2.getPositionTagName()));
        r11.put("resource_type", "ksong");
        el0.j.n(r11, Integer.valueOf(n.a()));
        u.l().sendLog("livesdk_connection_audience_tag_show", r11, new Object[]{Room.class});
    L56:
        if (jc1.k.n(IUserService.class).user().c() == false) goto L58;
        r7 = "admin";
        goto L65
    L58:
        Integer r20 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r20 != null) goto L62;
    L64:
        r7 = "audience";
        goto L65
    L62:
        if (r20.intValue() != 2) goto L64;
        r7 = "guest";
        goto L65
    L45:
        if (r10.isLiveTypeAudio() != true) goto L47;
        r19 = "voice_live";
        goto L48
    L38:
        r15 = null;
        goto L39
    L34:
        r12 = null;
    L30:
        r10 = null;
        goto L31
    L17:
        r3 = null;
        goto L19
    }

    @Override // dl0.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565212, r4, false);
    }
}
