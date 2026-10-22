package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements k {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k
    public final boolean a() {
        return fa2.b.a(this.a.O);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k
    public final boolean b() {
        return this.a.m();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k
    public final String c() {
        return this.a.l(true);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k
    public final WeakReference<DataCenter> getDataCenter() {
        return new WeakReference(this.a.M);
    }

    public c(AiAgentPSSelectedMsgView r1) {
        this.a = r1;
    }
}
