package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements l {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ia2.e r0 = this.a.a.K;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b("onStateChange");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public f(AiAgentPSSelectedMsgView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.l
    public final void a(AiAgentViewState r4, AiAgentViewState r5, AiAgentViewChangeReason r6) {
        Intrinsics.checkNotNullParameter(r4, "oldState");
        Intrinsics.checkNotNullParameter(r5, "newState");
        Intrinsics.checkNotNullParameter(r6, "reason");
        int r0 = ga2.d.a;
        ga2.d.a("onStateChange, old state: " + r4.desc() + ", new state: " + r5.desc() + ", reason: " + r6.desc());
        AiAgentPSSelectedMsgView.h(this.a, r5);
        this.a.t();
        boolean r1 = true;
        if (r5 != AiAgentViewState.AI_AGENT_EMPTY) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r4 != AiAgentViewState.AI_AGENT_FOLD) goto L12;
        boolean r8 = true;
    L14:
        if (r6 != AiAgentViewChangeReason.ZOOM_IN) goto L16;
    L19:
        if (r8 == false) goto L24;
        if (r7 == false) goto L25;
        if (r1 == false) goto L26;
        this.a.post(new a(this));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L16:
        if (r6 == AiAgentViewChangeReason.MESSAGE_INSERT) goto L19;
        r1 = false;
        goto L19
    L12:
        r8 = false;
        goto L14
    L5:
        if (r5 == AiAgentViewState.AI_AGENT_MESSAGE) goto L8;
        r7 = false;
        goto L10
    }
}
