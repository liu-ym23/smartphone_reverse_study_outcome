package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 implements com.bytedance.android.live.ui.a {
    public final /* synthetic */ MultiLinkRadioFeedView a;

    public l0(MultiLinkRadioFeedView r1) {
        this.a = r1;
    }

    public final void Ek(IVoiceLiveTheme r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        ALogger.i("MultiLinkRadioFeedView", "onStart#theme:" + r3);
    }

    public final void W9(boolean r3, IVoiceLiveTheme r4) {
        Intrinsics.checkNotNullParameter(r4, "theme");
        VideoThemeView r0 = this.a.h;
        if (r0 == null) goto L12;
        IAnimatedBgInfo r1 = r4.getAnimatedBgInfo();
        if (r1 == null) goto L7;
        py.k r2 = r1.getAnimatedBg();
    L8:
        if (r2 == null) goto L10;
        int r5 = 0;
    L11:
        r0.setVisibility(r5);
        goto L12
    L10:
        r5 = 8;
        goto L11
    L7:
        r2 = null;
    L12:
        ALogger.i("MultiLinkRadioFeedView", "onComplete#success:" + r3 + ",theme:" + r4);
    }
}
