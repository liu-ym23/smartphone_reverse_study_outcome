package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvFeedbackDialog;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements fd2.c {
    public final /* synthetic */ DataCenter a;

    public final void onCancelClick() {
    }

    public u(DataCenter r1) {
        this.a = r1;
    }

    public final void a(KtvFeedbackDialog r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        int r10 = y.a;
        DataCenter r11 = this.a;
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        if (com.bytedance.android.live.core.utils.a0.d(r11, false) == false) goto L7;
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 == null) goto L11;
        r12.finishAudioTalk();
        return;
    L11:
        return;
    L7:
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L13;
        IKtvService.b.a(r0, r9, false, !r8, false, 24);
        return;
    }
}
