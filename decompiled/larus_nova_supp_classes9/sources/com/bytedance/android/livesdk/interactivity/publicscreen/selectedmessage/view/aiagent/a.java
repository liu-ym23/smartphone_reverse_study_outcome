package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AiAgentPSSelectedMsgView a;
    public final /* synthetic */ Context b;

    public a(AiAgentPSSelectedMsgView r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.o(this.b);
    }
}
