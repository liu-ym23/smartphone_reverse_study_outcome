package w52;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void b(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "engineName");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        LiveMonitor.a r3 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineInit, r2, null);
        r3.l(0);
        r3.m("init engine success");
        r3.e("engine_name", r5);
        r3.h(r6);
        r3.a().report();
        return;
    L7:
        r2 = null;
        goto L8
    }

    @JvmStatic
    public static final void c(boolean r2, long r3) {
        LiveMonitor.a r0 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineInstallPlugin, null, null);
        if (r2 == false) goto L5;
        int r1 = 0;
    L6:
        r0.l(r1);
        if (r2 == false) goto L9;
        String r4 = "success";
    L10:
        r0.m(r4);
        r0.h(r3);
        r0.a().report();
        return;
    L9:
        r4 = "failed";
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    @JvmStatic
    public static final void a(String r5, int r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "engineName");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        LiveMonitor.a r3 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineInit, r2, null);
        r3.l(r6);
        r3.m("init engine failed");
        r3.e("engine_name", r5);
        r3.h(r7);
        r3.a().report();
        return;
    L7:
        r2 = null;
        goto L8
    }

    @JvmStatic
    public static final void d(int r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        LiveMonitor.a r0 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineLoadPlugin, null, null);
        r0.l(r2);
        r0.m(r3);
        r0.h(r4);
        r0.a().report();
    }

    public static void e(InteractivityMonitor.Event r7, Throwable r8, long r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r1 = "null";
        if ((r8 instanceof CustomApiServerException) == false) goto L13;
        CustomApiServerException r10 = (CustomApiServerException) r8;
        int r0 = r10.getErrorCode();
        String r2 = r10.getErrorMsg();
        if (r2 != null) goto L9;
        r2 = "known server error";
    L9:
        String r11 = r10.getXTtLogId();
        if (r11 == null) goto L17;
        r1 = r11;
    L17:
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r13 == null) goto L22;
        m r14 = r13.getRoom();
        if (r14 == null) goto L22;
        Room r15 = (Room) r14.getValue();
    L23:
        LiveMonitor.a r16 = InteractivityMonitor.a(r7, r15, null);
        r16.l(r0);
        r16.m(r2);
        r16.h(System.currentTimeMillis() - r9);
        r16.i("logId", r1);
        r16.a().report();
        return;
    L22:
        r15 = null;
        goto L23
    L13:
        String r17 = r8.getMessage();
        if (r17 != null) goto L16;
        r17 = "unknown local error";
    L16:
        r2 = r17;
        r0 = -10086;
        goto L17
    }

    public static void f(InteractivityMonitor.Event r5, String r6, long r7) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        LiveMonitor.a r8 = InteractivityMonitor.a(r5, r2, null);
        r8.l(0);
        r8.m("success");
        r8.h(System.currentTimeMillis() - r7);
        if (r6 != null) goto L11;
        r6 = "null";
    L11:
        r8.i("logId", r6);
        r8.a().report();
        return;
    L7:
        r2 = null;
        goto L8
    }
}
