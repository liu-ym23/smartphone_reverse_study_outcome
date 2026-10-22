package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h1 {
    public static final String a = null;
    public static final a b = null;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            RoomContext.a r0 = RoomContext.Companion;
            RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
            if (r5 == null) goto L8;
            com.bytedance.live.datacontext.m r6 = r5.getCleanMode();
            if (r6 == null) goto L8;
            if (((Number) r6.getValue()).intValue() != ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L8;
            return true;
        L8:
            RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
            if (r1 == null) goto L15;
            com.bytedance.live.datacontext.m r2 = r1.isCleanMode();
            if (r2 == null) goto L15;
            if (((Boolean) r2.getValue()).booleanValue() != true) goto L15;
            return true;
        L15:
            return false;
        }

        public static boolean c() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L11;
            com.bytedance.live.datacontext.n r1 = r0.isStreamHorizontal();
            if (r1 == null) goto L11;
            Function0 r2 = (Function0) r1.getValue();
            if (r2 == null) goto L11;
            if (((Boolean) r2.invoke()).booleanValue() != true) goto L11;
            return true;
        L11:
            return false;
        }

        public static LiveVisibilityControlContext f(DataCenter r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IVisibilityControlBrickService r1 = jc1.k.f(IVisibilityControlBrickService.class);
            if (r1 == null) goto L11;
            IVisibilityControlService r3 = r1.provideVisibilityControlService(r2);
            if (r3 != null) goto L10;
            return null;
        L10:
            return r3.provideContext();
        L11:
            return null;
        }

        public static IVisibilityControlService g(DataCenter r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IVisibilityControlBrickService r1 = jc1.k.f(IVisibilityControlBrickService.class);
            if (r1 != null) goto L8;
            return null;
        L8:
            return r1.provideVisibilityControlService(r2);
        }

        public static boolean b(DataCenter r4, RoomContext r5) {
            Intrinsics.checkNotNullParameter(r4, "dataCenter");
            boolean r0 = c();
            if (com.bytedance.android.live.core.utils.z.m(r4, true) == false) goto L13;
            if (r0 == true) goto L13;
            if (r5 == null) goto L11;
            com.bytedance.live.datacontext.m r6 = r5.isCleanMode();
            if (r6 == null) goto L11;
            if (((Boolean) r6.getValue()).booleanValue() != true) goto L11;
            return true;
        L11:
            return false;
        L13:
            if (com.bytedance.android.live.core.utils.z.m(r4, true) == true) goto L15;
        L25:
            return true;
        L15:
            if (PadConfigUtils.a() == false) goto L17;
        L18:
            if (r5 == null) goto L24;
            com.bytedance.live.datacontext.m r7 = r5.isCleanMode();
            if (r7 == null) goto L24;
            if (((Boolean) r7.getValue()).booleanValue() != true) goto L24;
            return true;
        L24:
            return false;
        L17:
            if (FoldScreenUtils.e() == false) goto L25;
            goto L18
        }

        public static boolean d(RoomContext r2, DataCenter r3) {
            if (r2 != null) goto L5;
            return false;
        L5:
            if (r3 != null) goto L8;
            return false;
        L8:
            if (r2.getVsRoom().isMergeVSRoom() == true) goto L17;
            VSDataContext r4 = VSDataContext.a.c(VSDataContext.Companion, r3);
            if (r4 == null) goto L16;
            com.bytedance.live.datacontext.m r5 = r4.isVSVideo();
            if (r5 == null) goto L16;
            if (((Boolean) r5.getValue()).booleanValue() == true) goto L17;
        L16:
            if (pm1.f.d(r3) != null) goto L17;
            return false;
        L17:
            return true;
        }

        public static void e(IRoom r9, DataCenter r10, RoomContext r11) {
            Intrinsics.checkNotNullParameter(r10, "dataCenter");
            Intrinsics.checkNotNullParameter(r11, "context");
            if (r10 == null) goto L27;
            if (r9 == null) goto L27;
            String r2 = h1.a;
            StringBuilder r3 = new StringBuilder("room.getExtra() realTimeReplayEnable is ");
            RoomExtra r4 = r9.getExtra();
            Boolean r5 = null;
            if (r4 == null) goto L10;
            Boolean r6 = Boolean.valueOf(r4.getRealTimeReplayEnable());
        L11:
            r3.append(r6);
            r3.append(", realTimePlaybackQualities.isEmpty() ");
            RoomExtra r7 = r9.getExtra();
            if (r7 == null) goto L16;
            List r8 = r7.getRealTimePlaybackQualities();
            if (r8 == null) goto L16;
            r5 = Boolean.valueOf(r8.isEmpty());
        L16:
            r3.append(r5);
            ALogger.d(r2, r3.toString());
            RoomExtra r12 = r9.getExtra();
            if (r12 != null) goto L19;
        L24:
            ALogger.d(r2, "supportPlayBack() == false");
            LiveVisibilityControlContext r13 = f(r10);
            if (r13 == null) goto L27;
            r13.setPlayBackAbilityInRoom(false);
            goto L27
        L19:
            if (r12.supportPlayBack() != true) goto L24;
            ALogger.d(r2, "supportPlayBack() == true");
            LiveVisibilityControlContext r14 = f(r10);
            if (r14 == null) goto L23;
            r14.setPlayBackAbilityInRoom(true);
        L23:
            boolean r15 = true;
        L28:
            if (r15 == false) goto L55;
            if (r9 == null) goto L48;
            long r16 = System.currentTimeMillis() / ((long) BubbleId.PadCast);
            long r17 = 0;
            if (r9.getStartTimeFlex() == 0) goto L48;
            long r18 = r16 - r9.getStartTimeFlex();
            RoomExtra r19 = r9.getExtra();
            if (r19 == null) goto L37;
            r17 = r19.getRealTimePlaybackShift();
        L37:
            if (r18 < r17) goto L42;
            ALogger.d(h1.a, "shift 满足要求");
            LiveVisibilityControlContext r20 = f(r10);
            if (r20 == null) goto L41;
            r20.setPlayBackAbilityInShift(true);
        L41:
            boolean r21 = true;
        L49:
            if (r21 == false) goto L55;
            if (b(r10, r11) == false) goto L55;
            LiveVisibilityControlContext r22 = f(r10);
            if (r22 == null) goto L59;
            r22.setPlaybackVisibleValue(true);
            return;
        L59:
            return;
        L42:
            ALogger.d(h1.a, "shift 不满足要求");
            LiveVisibilityControlContext r23 = f(r10);
            if (r23 == null) goto L45;
            r23.setPlayBackAbilityInShift(false);
        L45:
            long r24 = r17 - r18;
            IVisibilityControlService r25 = g(r10);
            if (r25 == null) goto L48;
            r25.countDownShift(r24);
        L48:
            r21 = false;
        L55:
            LiveVisibilityControlContext r26 = f(r10);
            if (r26 == null) goto L61;
            r26.setPlaybackVisibleValue(false);
            return;
        L61:
            return;
        L10:
            r6 = null;
        L27:
            r15 = false;
            goto L28
        }
    }

    static {
        b = new a();
        a = "enterRoomInPlayback";
    }
}
