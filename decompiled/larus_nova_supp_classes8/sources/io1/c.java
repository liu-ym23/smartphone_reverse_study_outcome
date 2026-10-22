package io1;

import android.os.Build;
import android.view.SurfaceView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.BlackFrameDetectionUtil$blackFrameDetection$$inlined$let$lambda$1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import uf2.d0;
import zg1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ eo1.b a;

    public c(eo1.b r1) {
        this.a = r1;
    }

    public final void accept(Object r17) {
        Long r0 = (Long) r17;
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L8
        long r4 = r0.longValue();     // Catch: Exception -> L8
        int r1 = (int) r4;     // Catch: Exception -> L8
        if (r4 != r1) goto L7;
        int r2 = r1 + 1;     // Catch: Exception -> L8
    L10:
        HashMap<Long, ArrayList<HashMap<String, String>>> r5 = com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.b.a;
        DataCenter r6 = this.a.b();
        final Room r7 = this.a.c();
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "room");
        final IPushStreamService r11 = k.f(IPushStreamService.class);
        m r8 = (m) r6.get("data_broadcast_pause_state");
        if (r11 == null) goto L13;
        com.bytedance.android.live.pushstream.d r9 = r11.getPushLiveStream();
    L14:
        if (r9 == null) goto L110;
        if (r8 != null) goto L17;
    L18:
        final RoomContext r10 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r10 == null) goto L112;
        final HashMap r12 = new HashMap();
        final Ref.IntRef r13 = new Ref.IntRef();
        HashMap<Long, Integer> r14 = com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.b.b;
        Integer r15 = r14.get(Long.valueOf(r7.id));
        if (r15 != null) goto L23;
        r15 = 1;
    L23:
        r13.element = r15.intValue();
        r12.put("live_mode", String.valueOf(((LiveMode) r10.getLiveMode().getValue()).getSceneName()));
        r12.put("room_id", String.valueOf(r7.id));
        com.bytedance.android.live.pushstream.d r16 = r11.getPushLiveStream();
        if (r16 == null) goto L28;
        d0 r18 = r16.getLiveCore();
        if (r18 == null) goto L28;
        Boolean r19 = Boolean.valueOf(r18.Q());
    L29:
        r12.put("is_camera_running", String.valueOf(r19));
        com.bytedance.android.live.pushstream.d r110 = r11.getPushLiveStream();
        if (r110 == null) goto L38;
        com.bytedance.android.live.pushstream.b.b r111 = r110.getStatus();
        if (r111 == null) goto L38;
        if (r111.a == 0) goto L36;
        boolean r112 = true;
    L37:
        Boolean r113 = Boolean.valueOf(r112);
    L39:
        r12.put("local_status", String.valueOf(r113));
        r12.put("livecore_status", String.valueOf(r10.isPublishStarted()));
        com.bytedance.android.live.pushstream.d r114 = r11.getPushLiveStream();
        if (r114 == null) goto L48;
        com.bytedance.android.live.pushstream.b.a r115 = r114.s1();
        if (r115 == null) goto L48;
        if (r115.a != 1) goto L46;
        boolean r116 = true;
    L47:
        Boolean r117 = Boolean.valueOf(r116);
    L49:
        r12.put("local_capture_status", String.valueOf(r117));
        com.bytedance.android.live.pushstream.d r118 = r11.getPushLiveStream();
        if (r118 == null) goto L58;
        com.bytedance.android.live.pushstream.b.a r119 = r118.s1();
        if (r119 == null) goto L58;
        if (r119.b != 1) goto L56;
        boolean r120 = true;
    L57:
        Boolean r121 = Boolean.valueOf(r120);
    L59:
        r12.put("real_capture_status", String.valueOf(r121));
        r12.put("times", String.valueOf(r2));
        com.bytedance.android.live.pushstream.d r122 = r11.getPushLiveStream();
        if (r122 == null) goto L62;
        com.bytedance.android.live.pushstream.b.b r123 = r122.getStatus();
    L63:
        r12.put("local_status_value", String.valueOf(r123));
        r12.put("history_log", String.valueOf(com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.b.a.get(Long.valueOf(r7.id))));
    L79:
        e = move-exception;
        ALogger.e("BlackFrameDetectionUtil", "blackFrame Exception: " + e);
    L105:
        ALogger.e("BlackFrameDetectionUtil", "isBitmapMostlyBlack: " + r12);
        return;
    L65:
        if (r11.getPushLiveStream() == null) goto L88;
        com.bytedance.android.live.pushstream.d r20 = r11.getPushLiveStream();     // Catch: Exception -> L79
        if (r20 == null) goto L81;
        com.bytedance.android.live.pushstream.b.b r21 = r20.getStatus();     // Catch: Exception -> L79
        if (r21 == null) goto L81;
        int r22 = r21.a;     // Catch: Exception -> L79
        if (r22 == 2) goto L76;
        if (r22 == 1) goto L76;
        boolean r23 = false;
    L77:
        if (r23 == true) goto L81;
    L87:
        boolean r24 = true;
    L90:
        if (r24 == false) goto L94;
        int r25 = (r13.element << 1) | 0;     // Catch: Exception -> L79
        r14.put(Long.valueOf(r7.id), Integer.valueOf(r25));     // Catch: Exception -> L79
        r13.element = r25;     // Catch: Exception -> L79
        r12.put("black_frame_flag", String.valueOf(r25));     // Catch: Exception -> L79
        r12.put("is_black_frame", "skip");     // Catch: Exception -> L79
        u.l().sendLog("livesdk_live_broadcast_livecore_black_frame", r12, new Object[]{Room.class});     // Catch: Exception -> L79
    L102:
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.util.b.a(r7, r2, r12);     // Catch: Exception -> L79
        goto L105
    L94:
        if (Build.VERSION.SDK_INT < 24) goto L101;
        WeakReference r124 = (WeakReference) r10.getSurfaceView().getValue();     // Catch: Exception -> L79
        if (r124 == null) goto L98;
        SurfaceView r125 = (SurfaceView) r124.get();     // Catch: Exception -> L79
    L99:
        if (r125 == null) goto L101;
        TTExecutors.getNormalExecutor().submit(new BlackFrameDetectionUtil$blackFrameDetection$$inlined$let$lambda$1(r10, r13, r12, r7, r11));     // Catch: Exception -> L79
        goto L102
    L98:
        r125 = null;
    L101:
        ALogger.e("BlackFrameDetectionUtil", "livesdk_live_broadcast_livecore_black_frame: " + r12);     // Catch: Exception -> L79
        u.l().sendLog("livesdk_live_broadcast_livecore_black_frame", r12, new Object[]{Room.class});     // Catch: Exception -> L79
    L76:
        r23 = true;
    L81:
        com.bytedance.android.live.pushstream.d r26 = r11.getPushLiveStream();     // Catch: Exception -> L79
        if (r26 == null) goto L88;
        d0 r27 = r26.getLiveCore();     // Catch: Exception -> L79
        if (r27 == null) goto L88;
        if (r27.Q() == false) goto L87;
    L88:
        r24 = false;
        goto L90
    L62:
        r123 = null;
        goto L63
    L56:
        r120 = false;
    L58:
        r121 = null;
        goto L59
    L46:
        r116 = false;
    L48:
        r117 = null;
        goto L49
    L36:
        r112 = false;
    L38:
        r113 = null;
    L28:
        r19 = null;
        goto L29
    L112:
        return;
    L17:
        if (r8.a != 1) goto L18;
        return;
    L110:
        return;
    L13:
        r9 = null;
        goto L14
    L7:
        throw new ArithmeticException();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("AbsInteractionFragment", e);
        r2 = 0;
        goto L10
    }
}
