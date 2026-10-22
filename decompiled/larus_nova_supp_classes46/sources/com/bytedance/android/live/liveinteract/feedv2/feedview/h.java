package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements com.bytedance.android.live.ui.a {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

    public h(MultiLinkCommonVideoFeedPreview r1) {
        this.a = r1;
    }

    public final void Ek(IVoiceLiveTheme r2) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        Intrinsics.checkNotNullParameter(r2, "theme");
    }

    public final void W9(boolean r7, IVoiceLiveTheme r8) {
        Intrinsics.checkNotNullParameter(r8, "theme");
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(this.a.getConfigInnerProvider().g(), "background_Load", 0, 2, null);
    }
}
