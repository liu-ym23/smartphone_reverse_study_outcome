package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements com.bytedance.android.live.ui.a {
    public final /* synthetic */ CommonMultiLinkFeedView a;

    public h(CommonMultiLinkFeedView r1) {
        this.a = r1;
    }

    public final void Ek(IVoiceLiveTheme r2) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        Intrinsics.checkNotNullParameter(r2, "theme");
    }

    public final void W9(boolean r7, IVoiceLiveTheme r8) {
        Intrinsics.checkNotNullParameter(r8, "theme");
        CommonMultiLinkFeedView r9 = this.a;
        r9.Q = true;
        if (r9.getVisibility() != 0) goto L8;
        IMultiScenePreviewStatistics r0 = this.a.P;
        if (r0 == null) goto L9;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r0, "background_Load", 0, 2, null);
        return;
    L9:
        return;
    }
}
