package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.rts.foundation.v;
import com.bytedance.salamander.anniex.y3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RTSFeedbackUtils {
    public static final Map<String, String> a = null;
    public static final Companion b = null;

    public static final class Companion {
        public Companion() {
        }

        public static void d(final Map r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            RTSFeedbackUtils.b.getClass();
            com.bytedance.rts.foundation.m.d(RTSFeedbackUtils.a, new RTSFeedbackUtils$Companion$liveFeedbackCardClick$1(r3));
            y3 r1 = new y3("livesdk_live_feedback_card_click", r3);
            RTSFeedbackUtils$Companion$liveFeedbackCardClick$2 r4 = RTSFeedbackUtils$Companion$liveFeedbackCardClick$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r4, "callback");
            com.bytedance.salamander.bridge.k.a(r1, r4);
        }

        public static void e(final Map r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            RTSFeedbackUtils.b.getClass();
            com.bytedance.rts.foundation.m.d(RTSFeedbackUtils.a, new RTSFeedbackUtils$Companion$liveFeedbackCardShow$1(r3));
            y3 r1 = new y3("livesdk_live_feedback_card_show", r3);
            RTSFeedbackUtils$Companion$liveFeedbackCardShow$2 r4 = RTSFeedbackUtils$Companion$liveFeedbackCardShow$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r4, "callback");
            com.bytedance.salamander.bridge.k.a(r1, r4);
        }

        public static void f(RTSRelaxFeedbackLightData r3) {
            Intrinsics.checkNotNullParameter(r3, "lightData");
            RTSFeedbackUtils.b.getClass();
            Map<String, String> r0 = RTSFeedbackUtils.a;
            com.bytedance.rts.foundation.m.e(r0, "enter_from_merge", r3.a);
            com.bytedance.rts.foundation.m.e(r0, "enter_method", r3.b);
            com.bytedance.rts.foundation.m.e(r0, "room_id", r3.d);
            com.bytedance.rts.foundation.m.e(r0, "anchor_id", r3.e);
            com.bytedance.rts.foundation.m.e(r0, "request_id", r3.f);
            com.bytedance.rts.foundation.m.e(r0, "draw_order", r3.h);
            Long r1 = Long.valueOf(r3.g);
            Intrinsics.checkNotNullParameter(r1, "x");
            com.bytedance.rts.foundation.m.e(r0, "feedback_id", r1.toString());
            com.bytedance.rts.foundation.m.e(r0, "flow_type", r3.i);
            com.bytedance.rts.foundation.m.e(r0, "card_type", r3.j);
            com.bytedance.rts.foundation.m.e(r0, "pk_id", r3.l);
            com.bytedance.rts.foundation.m.e(r0, "question_type", r3.k);
            com.bytedance.rts.foundation.m.e(r0, "action_type", r3.c);
        }

        public static int a(Object r1, int r2) {
            int r0 = v.a;
            if ((r1 instanceof Long) == false) goto L11;
            int r3 = com.bytedance.rts.foundation.e.a;
            if (r1 == null) goto L9;
            return (int) ((Long) r1).longValue();
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        L11:
            if ((r1 instanceof Integer) == false) goto L18;
            int r4 = com.bytedance.rts.foundation.d.a;
            if (r1 == null) goto L17;
            return ((Integer) r1).intValue();
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L18:
            return r2;
        }

        public static Map b(Map r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Object r0 = null;
            if (r2 == null) goto L15;
            Object r4 = r2.get("data");
            if (TypeIntrinsics.isMutableMap(r4) == true) goto L7;
            r4 = null;
        L7:
            Map r5 = (Map) r4;
            if (r5 == null) goto L16;
            Object r6 = r5.get(r3);
            if (TypeIntrinsics.isMutableMap(r6) == false) goto L14;
            r0 = r6;
        L14:
            return (Map) r0;
        L16:
            return null;
        L15:
            return null;
        }

        public static int c(String r2, Map r3) {
            Intrinsics.checkNotNullParameter(r2, "position");
            if (r3 != null) goto L6;
            return 30;
        L6:
            switch(r2.hashCode()) {
                case -1730219439: goto L21;
                case -207318108: goto L17;
                case 1198803481: goto L13;
                case 1804255104: goto L9;
                default: goto L24;
            };
        L24:
            return 30;
        L9:
            if (r2.equals("preview_bottom_component") == false) goto L24;
            Companion r4 = RTSFeedbackUtils.b;
            Object r5 = r3.get("preview_bottom_component_show_duration");
            r4.getClass();
            return a(r5, 30);
        L13:
            if (r2.equals("public_screen_show_duration") == false) goto L24;
            Companion r6 = RTSFeedbackUtils.b;
            Object r7 = r3.get("public_screen_show_duration");
            r6.getClass();
            return a(r7, 30);
        L17:
            if (r2.equals("room_bottombar") == false) goto L24;
            Companion r8 = RTSFeedbackUtils.b;
            Object r9 = r3.get("room_bottom_show_duration");
            r8.getClass();
            return a(r9, 30);
        L21:
            if (r2.equals("preview_bottombar") == false) goto L24;
            Companion r10 = RTSFeedbackUtils.b;
            Object r11 = r3.get("preview_bottom_bar_show_duration");
            r10.getClass();
            return a(r11, 30);
        }
    }

    static {
        b = new Companion();
        a = new LinkedHashMap();
    }
}
