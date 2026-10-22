package com.bytedance.android.livesdk.interactivity.comment.newinput;

import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements InputPanelSectionContainer.c {
    public final /* synthetic */ LiveLandscapeInputDialogV3 a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;

    public e(LiveLandscapeInputDialogV3 r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer.c
    public final void a(InputSectionType r4, InputSectionType r5) {
        Intrinsics.checkNotNullParameter(r4, "previousType");
        Intrinsics.checkNotNullParameter(r5, "currentSectionType");
        com.bytedance.android.live.profit.vip.e r6 = yt0.c.l();
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.m r7 = r6.isEmojiPanelShow();
        if (r7 == null) goto L12;
        if (r5 != InputSectionType.EMOJI) goto L9;
        boolean r2 = true;
    L10:
        r7.setValue(Boolean.valueOf(r2));
        goto L12
    L9:
        r2 = false;
    L12:
        if (r5 != InputSectionType.NONE) goto L17;
        LiveLandscapeInputDialogV3 r8 = this.a;
        int r3 = LiveLandscapeInputDialogV3.A;
        if (r8.k == true) goto L17;
        r8.dismissInputDialog();
    L17:
        if (r5 != InputSectionType.KEYBOARD) goto L20;
        this.b.r(true);
    L20:
        if (r5 == InputSectionType.DANMAKU) goto L26;
        c r9 = this.b.V();
        if (r9 == null) goto L26;
        a r10 = r9.g;
        if (r10 == null) goto L26;
        r10.c = false;
    L26:
        this.a.aa0();
    }
}
