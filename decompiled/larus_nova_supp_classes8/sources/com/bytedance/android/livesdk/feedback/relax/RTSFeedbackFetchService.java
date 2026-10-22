package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.salamander.anniex.a4;
import com.bytedance.salamander.anniex.b4;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RTSFeedbackFetchService {
    public static final /* synthetic */ int a = 0;

    public static final class Companion {
        public Companion() {
        }

        public static void b(RTSRelaxFeedbackLightData r10) {
            int r0 = RTSFeedbackFetchService.a;
            Intrinsics.checkNotNullParameter(r10, "relaxFeedbackLightData");
            Pair[] r1 = new Pair[3];
            int r2 = 0;
            r1[0] = TuplesKt.to("feedback_id", Long.valueOf(r10.g));
            r1[1] = TuplesKt.to("room_id", r10.d);
            if (StringsKt.indexOf$default(r10.i, "outflow", 0, false, 6, null) < 0) goto L5;
            r2 = 1;
        L5:
            r1[2] = TuplesKt.to("flow_type", Integer.valueOf(r2));
            Map r11 = MapsKt.mutableMapOf(r1);
            if (r11 == null) goto L10;
            Map r4 = TypeIntrinsics.asMutableMap(r11);
            a4 r12 = new a4("https://webcast.amemv.com/webcast/distribution/feedback_show/", "post", r4, r4, null, null, 8176);
            final Function1 r3 = null;
            Function1<b4, Unit> r5 = new RTSFeedbackFetchService$Companion$fetchFeedbackShow$1(r3);
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r5, "callback");
            com.bytedance.salamander.bridge.m.a(r12, r5);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.Json /* = kotlin.collections.MutableMap<kotlin.String, kotlin.Any> */");
        }

        public static void a(Map r9, final Function1 r10) {
            Intrinsics.checkNotNullParameter(r9, "feedback");
            a4 r0 = new a4("https://webcast.amemv.com/webcast/distribution/feedback/", "post", r9, r9, null, null, 8176);
            Function1<b4, Unit> r11 = new RTSFeedbackFetchService$Companion$fetchFeedbackDistribution$1(r10);
            Intrinsics.checkNotNullParameter(r0, "params");
            Intrinsics.checkNotNullParameter(r11, "callback");
            com.bytedance.salamander.bridge.m.a(r0, r11);
        }
    }

    static {
        new Companion();
    }
}
