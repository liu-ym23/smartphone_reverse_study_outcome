package zi0;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final MultiLinkEventModule a = null;
    public static final PublishSubject<Unit> b = null;
    public static final PublishSubject<Unit> c = null;
    public static final e d = null;
    public static long e;

    static {
        a = MultiLinkEventModule.ROOM_BATTLE;
        PublishSubject.create();
        b = PublishSubject.create();
        c = PublishSubject.create();
        PublishSubject.create();
        new CompositeDisposable();
        new CompositeDisposable();
        d = new e();
    }

    public static boolean b() {
        return ((Boolean) vm2.d.v4.getValue(null, vm2.d.a[279(0x117, float:3.91E-43)])).booleanValue();
    }

    public static void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        LinkRoomFightContext r0 = LinkRoomFightContext.Companion.getContext();
        if (r0 == null) goto L28;
        m<com.bytedance.android.live.liveinteract.multiscene.a> r1 = r0.getFightInfo();
        if (r1 == null) goto L28;
        com.bytedance.android.live.liveinteract.multiscene.a r2 = (com.bytedance.android.live.liveinteract.multiscene.a) r1.getValue();
        if (r2 == null) goto L28;
        c.a(r3, "battle_id", Long.valueOf(r2.getTeamFightId()));
        int r4 = r2.getFightStatus();
        if (r4 != 0) goto L11;
        String r5 = "none";
    L27:
        c.a(r3, "battle_status", r5);
        c.a(r3, "update_time", Long.valueOf(r2.getCurrentTime()));
        goto L28
    L11:
        if (r4 != 1) goto L13;
        r5 = "preparing";
        goto L27
    L13:
        if (r4 != 2) goto L15;
        r5 = "playing";
        goto L27
    L15:
        if (r4 != 3) goto L17;
        r5 = "punishing";
        goto L27
    L17:
        if (r4 != 4) goto L19;
        r5 = "finished";
        goto L27
    L19:
        if (r4 == 5) goto L21;
        r5 = "unknown(" + r2.getFightStatus() + ')';
        goto L27
    L21:
        r5 = "punish_showing";
    L28:
        e r6 = d;
        c.a(r3, "inviter_anchor_id", r6.a.getFirst());
        c.a(r3, "inviter_room_id", r6.a.getSecond());
        c.a(r3, "invitee_anchor_id", r6.b.getFirst());
        c.a(r3, "invitee_room_id", r6.b.getSecond());
    }

    public static void c(String r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "streamId");
        if (b() == true) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        c.a(r3, "stream_id", r10);
        c.a(r3, "use_canvas", Boolean.valueOf(r12));
        a(r3);
        nd0.c.p(nd0.c.a, LinkMonitorData.SetPublicStreamVideoCanvas, r3, a, r11, null, false, null, 112);
    }

    public static void d(boolean r9, Throwable r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "throwable");
        if (b() == true) goto L5;
        return;
    L5:
        JSONObject r7 = new JSONObject();
        c.a(r7, "silenceType", Integer.valueOf(r9 ? 1 : 0));
        a(r7);
        long r0 = 0;
        if (r11 <= 0) goto L8;
        r0 = System.currentTimeMillis() - r11;
    L8:
        nd0.c r1 = nd0.c.a;
        LinkMonitorData r2 = LinkMonitorData.SilenceOtherRoom;
        MultiLinkEventModule r3 = a;
        nd0.c.r(r1, r2, r3, r0, r10, r7, 32);
    }

    public static void e(boolean r9, String r10, long r11) {
        if (b() == true) goto L5;
        return;
    L5:
        JSONObject r7 = new JSONObject();
        c.a(r7, "silenceType", Integer.valueOf(r9 ? 1 : 0));
        a(r7);
        long r0 = 0;
        if (r11 <= 0) goto L8;
        r0 = System.currentTimeMillis() - r11;
    L8:
        long r4 = r0;
        nd0.c r1 = nd0.c.a;
        LinkMonitorData r2 = LinkMonitorData.SilenceOtherRoom;
        MultiLinkEventModule r3 = a;
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        nd0.c.s(r1, r2, r3, r4, r10, r7, 96);
    }

    public static void f(String r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "streamId");
        Intrinsics.checkNotNullParameter(r13, "source");
        if (b() == true) goto L5;
        return;
    L5:
        JSONObject r4 = new JSONObject();
        c.a(r4, "stream_id", r11);
        if (r12 == null) goto L8;
        int r14 = r12.intValue();
    L9:
        c.a(r4, "result", Integer.valueOf(r14));
        c.a(r4, "source", r13);
        a(r4);
        if (r12 != null) goto L13;
    L15:
        nd0.c.p(nd0.c.a, LinkMonitorData.StopPlayPublicStream, r4, a, 0, null, false, null, 120);
        return;
    L13:
        if (r12.intValue() != 0) goto L15;
        e = System.currentTimeMillis();
        goto L15
    L8:
        r14 = -1;
        goto L9
    }
}
