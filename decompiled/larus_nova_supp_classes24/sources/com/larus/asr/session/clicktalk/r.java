package com.larus.asr.session.clicktalk;

import com.larus.asr.session.b2;
import com.larus.asr.session.c2;
import com.larus.asr.session.d2;
import com.larus.asr.session.f2;
import com.larus.audio.call.utils.AvBizType;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r {
    public final Function0<JSONObject> a;
    public final String b;
    public final Function0<String> c;
    public final Function0<String> d;
    public final Function0<CoroutineScope> e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ClickTalkAsrRoute.values().length];
            r0[ClickTalkAsrRoute.AUTO_STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ClickTalkAsrRoute.FLOW_ASR_TASK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ClickTalkAsrRoute.REALTIME_SERVICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final com.larus.audio.call.a a(final k r7) {
        ObricRealtimeCallServiceDelegate r0 = ObricRealtimeCallServiceDelegate.b;
        b78.h r1 = new b78.h(AvBizType.VOICE_CALL);
        int r2 = z2a.g.a;
        com.larus.audio.call.a r3 = r0.f(r1, z2a.g.e("continuous_talk", (JSONObject) this.a.invoke()), this.e, false, new n(this, r7));
        r3.f = new o(r7);
        r3.e = new p(r7);
        r3.b = new q(r7);
        return r3;
    }

    public r(b2 r2, String r3, c2 r4, d2 r5, f2 r6) {
        Intrinsics.checkNotNullParameter(r2, "spanCommonParamsProvider");
        Intrinsics.checkNotNullParameter(r3, "flowAsrTaskId");
        Intrinsics.checkNotNullParameter(r4, "flowAsrConversationIdProvider");
        Intrinsics.checkNotNullParameter(r5, "flowAsrBotIdProvider");
        Intrinsics.checkNotNullParameter(r6, "lifecycleScope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
