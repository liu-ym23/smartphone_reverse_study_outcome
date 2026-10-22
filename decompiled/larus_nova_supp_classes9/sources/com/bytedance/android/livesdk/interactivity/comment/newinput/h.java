package com.bytedance.android.livesdk.interactivity.comment.newinput;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements InputPanelSectionContainer.c {
    public final /* synthetic */ LivePortraitInputDialogV3 a;

    public h(LivePortraitInputDialogV3 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer.c
    public final void a(InputSectionType r5, InputSectionType r6) {
        Intrinsics.checkNotNullParameter(r5, "previousType");
        Intrinsics.checkNotNullParameter(r6, "currentSectionType");
        com.bytedance.android.live.profit.vip.e r0 = yt0.c.l();
        boolean r1 = false;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m r2 = r0.isEmojiPanelShow();
        if (r2 == null) goto L12;
        if (r6 != InputSectionType.EMOJI) goto L9;
        boolean r3 = true;
    L10:
        r2.setValue(Boolean.valueOf(r3));
        goto L12
    L9:
        r3 = false;
    L12:
        if (r6 != InputSectionType.NONE) goto L19;
        LivePortraitInputDialogV3 r4 = this.a;
        int r7 = LivePortraitInputDialogV3.L;
        if (r4.k == true) goto L19;
        if (r5 != InputSectionType.KEYBOARD) goto L18;
        r4.q = 3;
    L18:
        r4.dismissInputDialog();
    L19:
        LivePortraitInputDialogV3 r8 = this.a;
        if (r6 != InputSectionType.KEYBOARD) goto L22;
        r1 = true;
    L22:
        r8.l = r1;
        i0.c().post(new g(this));
    }
}
