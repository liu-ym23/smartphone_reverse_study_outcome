package com.bytedance.android.live.profit.format.voicechat.viewmodel;

import com.bytedance.android.live.profit.format.voicechat.model.CloseReason;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import kotlin.jvm.internal.Intrinsics;
import nu0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements hu0.a.InterfaceC0249a {
    public final /* synthetic */ VoiceChatViewModel.i a;

    public f(VoiceChatViewModel.i r1) {
        this.a = r1;
    }

    @Override // hu0.a.InterfaceC0249a
    public final void a(ju0.f r2) {
        Intrinsics.checkNotNullParameter(r2, "topicMessage");
        VoiceChatViewModel.access$get_topics$p(this.a.a).setValue(r2);
    }

    @Override // hu0.a.InterfaceC0249a
    public final void b(VoiceChatState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        j.a(this, "on talk state change: " + r3);
        VoiceChatViewModel.access$get_chatState$p(this.a.a).setValue(r3);
    }

    @Override // hu0.a.InterfaceC0249a
    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "detail");
        this.a.a.closeChat(false, CloseReason.OTHER, r4);
    }
}
