package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvFeedbackDialog;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements fd2.c {
    public final /* synthetic */ DataCenter a;

    public final void onCancelClick() {
    }

    public x(DataCenter r1) {
        this.a = r1;
    }

    public final void a(KtvFeedbackDialog r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        int r10 = y.a;
        if (com.bytedance.android.live.core.utils.a0.d(this.a, false) == false) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r11 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r11 == null) goto L11;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r11);
        return;
    L11:
        return;
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L13;
        IVoiceChatGuestService.b.b(r0, r9, false, !r8, false, 24);
        return;
    }
}
