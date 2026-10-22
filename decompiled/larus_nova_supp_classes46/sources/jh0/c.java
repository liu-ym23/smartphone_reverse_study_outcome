package jh0;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final Map<Integer, Long> a;
    public boolean b;
    public final b c;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Integer r7 = (Integer) r6;
            if (gh0.a.d() == true) goto L23;
            ALogger.i("DynamicBizLogHelper", "linkPlayerState onChanged: " + r7);
            if (this.a.b == true) goto L13;
            if (hd0.c.f().h() == false) goto L13;
            c r8 = this.a;
            r8.b = true;
            ALogger.i("DynamicBizLogHelper", "onStartMultiLink");
            if ((!r8.a.isEmpty()) == false) goto L13;
            r8.b(null);
        L13:
            if (this.a.b == true) goto L15;
            return;
        L15:
            if (hd0.c.f().h() == true) goto L21;
            c r9 = this.a;
            r9.b = false;
            ALogger.i("DynamicBizLogHelper", "onStartMultiLink");
            if ((!r9.a.isEmpty()) == false) goto L22;
            r9.c(null);
            return;
        L22:
            return;
        L21:
            return;
        }
    }

    static {
    }

    public c() {
        this.a = new LinkedHashMap();
        this.b = hd0.c.f().h();
        this.c = new b(this);
    }

    public final void a(Integer r13) {
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomWatchDuration, playModes: " + ((LinkedHashMap) this.a).keySet());
        HashMap r0 = new HashMap();
        zi0.d.b(r0, true);
        if (r13 == null) goto L7;
        Long r8 = (Long) ((LinkedHashMap) this.a).get(r13);
        if (r8 == null) goto L16;
        long r9 = r8.longValue();
        r0.put("play_mode", u0.k(r13.intValue()));
        r0.put("duration", String.valueOf((System.currentTimeMillis() - r9) / ((long) 1000)));
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r0, new Object[]{IRoom.class, x.class});
        return;
    L16:
        return;
    L7:
        Set r14 = ((LinkedHashMap) this.a).keySet();
        if (r14 != null) goto L10;
        return;
    L10:
        Iterator r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L23;
        int r10 = ((Number) r15.next()).intValue();
        r0.put("play_mode", u0.k(r10));
        Long r11 = (Long) ((LinkedHashMap) this.a).get(Integer.valueOf(r10));
        if (r11 == null) goto L12;
        r0.put("duration", String.valueOf((System.currentTimeMillis() - r11.longValue()) / ((long) 1000)));
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r0, new Object[]{IRoom.class, x.class});
        goto L12
    }

    public final void b(Integer r10) {
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomlink, playModes: " + ((LinkedHashMap) this.a).keySet());
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.V0(r0);
        if (o.c() != 16) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L18;
        j r2 = m.d().J();
        if (r2 == null) goto L17;
        LivePlayModeLogContext r3 = (LivePlayModeLogContext) r2.getValue();
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.m r4 = r3.getPlayModes();
        if (r4 == null) goto L17;
        Set r5 = (Set) r4.getValue();
        if (r5 == null) goto L17;
        if (r5.contains(16) == true) goto L18;
    L17:
        boolean r6 = true;
    L20:
        if (r10 == null) goto L25;
        if (r6 == false) goto L23;
        r0.put("play_mode", "link_room");
    L24:
        j0.l().sendLog("livesdk_audience_playmode_room_link", r0, new Object[]{IRoom.class, x.class});
        return;
    L23:
        r0.put("play_mode", u0.k(r10.intValue()));
        goto L24
    L25:
        if (r6 == false) goto L27;
        r0.put("play_mode", "link_room");
        j0.l().sendLog("livesdk_audience_playmode_room_link", r0, new Object[]{IRoom.class, x.class});
        return;
    L27:
        Set r11 = ((LinkedHashMap) this.a).keySet();
        if (r11 != null) goto L30;
        return;
    L30:
        Iterator r12 = r11.iterator();
    L32:
        if (r12.hasNext() == false) goto L37;
        r0.put("play_mode", u0.k(((Number) r12.next()).intValue()));
        j0.l().sendLog("livesdk_audience_playmode_room_link", r0, new Object[]{IRoom.class, x.class});
        goto L32
    L37:
        return;
    L18:
        r6 = false;
        goto L20
    L5:
        r1 = false;
        goto L6
    }

    public final void c(Integer r10) {
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomlinkDuration, playModes: " + ((LinkedHashMap) this.a).keySet());
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.V0(r0);
        if (o.c() != 16) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L18;
        j r2 = m.d().J();
        if (r2 == null) goto L17;
        LivePlayModeLogContext r3 = (LivePlayModeLogContext) r2.getValue();
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.m r4 = r3.getPlayModes();
        if (r4 == null) goto L17;
        Set r5 = (Set) r4.getValue();
        if (r5 == null) goto L17;
        if (r5.contains(16) == true) goto L18;
    L17:
        boolean r6 = true;
    L20:
        if (r10 == null) goto L25;
        if (r6 == false) goto L23;
        r0.put("play_mode", "link_room");
    L24:
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r0, new Object[]{IRoom.class, x.class});
        return;
    L23:
        r0.put("play_mode", u0.k(r10.intValue()));
        goto L24
    L25:
        if (r6 == false) goto L27;
        r0.put("play_mode", "link_room");
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r0, new Object[]{IRoom.class, x.class});
        return;
    L27:
        Set r11 = ((LinkedHashMap) this.a).keySet();
        if (r11 != null) goto L30;
        return;
    L30:
        Iterator r12 = r11.iterator();
    L32:
        if (r12.hasNext() == false) goto L37;
        r0.put("play_mode", u0.k(((Number) r12.next()).intValue()));
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r0, new Object[]{IRoom.class, x.class});
        goto L32
    L37:
        return;
    L18:
        r6 = false;
        goto L20
    L5:
        r1 = false;
        goto L6
    }
}
