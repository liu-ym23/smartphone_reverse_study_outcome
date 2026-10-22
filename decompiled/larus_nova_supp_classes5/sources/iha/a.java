package iha;

import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.larus.voicecall.obric.IObricRealtimeCallService;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.impl.v2.ObricStateImpl;
import com.obric.assistant.state.impl.v2.core.g;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.utils.f;
import eha.b;
import eha.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public String a;
    public final C0018a b;

    /* JADX INFO: renamed from: iha.a$a, reason: collision with other inner class name */
    public static final class C0018a implements IObricRealtimeCallService.a {
        public final /* synthetic */ a a;

        public C0018a(a r1) {
            this.a = r1;
        }

        public final void onEnterRealtimeCall(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "botId");
            Intrinsics.checkNotNullParameter(r4, "conversationId");
            a r5 = this.a;
            r5.a = r4;
            FLogger.a.i("[RealtimeCallStateHandler]", "mobRealtimeCallStart, " + r5.a);
            List<bha.a> r6 = ObricStateImpl.a;
            y.c(new c());
            if (f.a == true) goto L6;
            CoroutineScope r7 = ObricPowerManager.a;
            ObricPowerManager.c(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
            return;
        }

        public final void onExitRealtimeCall(String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "botId");
            Intrinsics.checkNotNullParameter(r12, "conversationId");
            a r13 = this.a;
            r13.getClass();
            FLogger.a.i("[RealtimeCallStateHandler]", "mobRealtimeCallEnd, " + r12);
            r13.a = null;
            ObricLiveServiceDelegate r14 = ObricLiveServiceDelegate.b;
            ObricInteractionScene r3 = ObricInteractionScene.REALTIME_CALL_SCENE;
            r14.l(r3.ordinal(), false);
            if (r12 == null) goto L5;
            hha.a r15 = g.a;
            g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_END, r12, r3, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        L5:
            List<bha.a> r16 = ObricStateImpl.a;
            y.c(new b());
            if (f.a == true) goto L9;
            CoroutineScope r17 = ObricPowerManager.a;
            ObricPowerManager.f(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
            return;
        }
    }

    public a() {
        this.b = new C0018a(this);
    }
}
