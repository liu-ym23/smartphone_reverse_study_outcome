package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w implements ne0.a {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

    public w(MultiLinkVideoTalkRoomGuestWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        MultiLinkVideoTalkRoomGuestWidget r4 = this.a;
        int r5 = MultiLinkVideoTalkRoomGuestWidget.i3;
        InteractBeautyPreviewDialog r6 = r4.w;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isShowing() == true) goto L14;
    L12:
        r4.w = null;
        return;
    L14:
        r6.dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L12;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }
}
