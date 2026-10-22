package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final C0018a a = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.api.utils.a$a, reason: collision with other inner class name */
    public static final class C0018a {
        public C0018a() {
        }

        @JvmStatic
        public static String a(int r3) {
            if (r3 != 4) goto L5;
            return "audience";
        L5:
            if (r3 != 5) goto L7;
            com.bytedance.live.datacontext.m r4 = m.i().getRoom();
            if (r4 == null) goto L24;
            IRoom r5 = (IRoom) r4.getValue();
            if (r5 == null) goto L24;
            if (d0.h(r5) == false) goto L24;
            return "party";
        L24:
            return "radio";
        L7:
            if (r3 == 12) goto L16;
            switch(r3) {
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L11;
                default: goto L9;
            };
        L9:
            return "";
        L11:
            return "watch";
        L13:
            return "ktv";
        L15:
            return "radio";
        L16:
            return "party";
        }

        @JvmStatic
        public static void c(RoomDecoration r4) {
            Intrinsics.checkNotNullParameter(r4, "roomDecoration");
            LinkedHashMap r0 = new LinkedHashMap();
            b(r0, ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene());
            r0.put("prop_id", String.valueOf(r4.getId()));
            j0.l().sendLog("livesdk_live_prop_select", r0, new Object[]{IRoom.class});
        }

        @JvmStatic
        public static void b(Map r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "logMap");
            r1.put("function_type", a(r2));
        }
    }

    static {
        a = new C0018a();
    }
}
