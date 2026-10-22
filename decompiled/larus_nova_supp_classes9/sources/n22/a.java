package n22;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.k6;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import jc1.k;
import r52.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static boolean d;

    static {
        c = true;
    }

    public static boolean b() {
        Integer r0 = (Integer) k6.a.getValue();
        Boolean r1 = (Boolean) r52.d.a.getValue();
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 == null) goto L12;
        o r3 = IRoomContextService.a.a(r2, null, 0, 3);
        if (r3 == null) goto L12;
        m r4 = r3.getRoom();
        if (r4 == null) goto L12;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L12;
        LiveMode r6 = r5.getStreamType();
        if (r6 == null) goto L12;
    L13:
        String r7 = "open contour: contourEnable:" + r1 + ",anchorPhoneType:" + r0 + ",livemode:" + r6 + ",scene:" + c + ",hasDownloadModel:" + d + ",sceneSupport:" + c;
        if (a == false) goto L17;
        DanmakuMonitor.b("judge", r7);
    L17:
        if (a == true) goto L19;
    L35:
        return false;
    L19:
        if (r1.booleanValue() == false) goto L35;
        if ((!PadConfigUtils.c()) == false) goto L35;
        if (r0.intValue() > 2) goto L35;
        if (r6 == LiveMode.VIDEO) goto L29;
        if (r6 != LiveMode.MEDIA) goto L35;
    L29:
        if (c == false) goto L35;
        if (b == true) goto L35;
        if (d == false) goto L35;
        return true;
    L12:
        r6 = LiveMode.VIDEO;
        goto L13
    }

    public static boolean a() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r0 = q.b();
        if (r0 == null) goto L10;
        n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r1 = r0.getChatCarnivalMessage();
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r2 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r1.getValue();
        if (r2 == null) goto L10;
        if (r2.p() != 1) goto L10;
    L24:
        boolean r3 = true;
    L26:
        if (r3 == true) goto L28;
        return false;
    L28:
        if (((Boolean) p.a.getValue()).booleanValue() == true) goto L30;
        return false;
    L30:
        if ((!PadConfigUtils.c()) == false) goto L35;
        return true;
    L35:
        return false;
    L10:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r4 = q.b();
        if (r4 == null) goto L25;
        j<GeneralCarnivalDataSyncModel> r5 = r4.getGeneralCarnivalSyncModel();
        if (r5 == null) goto L25;
        GeneralCarnivalDataSyncModel r6 = (GeneralCarnivalDataSyncModel) r5.getValue();
        if (r6 == null) goto L25;
        dc2.c<com.bytedance.android.livesdk.interactivity.api.barrage.data.k> r7 = r6.getCarnivalMessage();
        if (r7 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.k r8 = r7.c();
        if (r8 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.j r9 = r8.a();
        if (r9 == null) goto L25;
        if (r9.q() == 1) goto L24;
    L25:
        r3 = false;
        goto L26
    }
}
