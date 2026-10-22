package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements com.bytedance.android.live.ui.a {
    public final /* synthetic */ c0 a;

    public a0(c0 r1) {
        this.a = r1;
    }

    public final void Ek(IVoiceLiveTheme r4) {
        Intrinsics.checkNotNullParameter(r4, "theme");
        ALogger.i(this.a.h, "onStart#theme:" + r4);
    }

    public final void W9(boolean r4, IVoiceLiveTheme r5) {
        Intrinsics.checkNotNullParameter(r5, "theme");
        ALogger.i(this.a.h, "onComplete#success:" + r4 + ",theme:" + r5);
        VideoThemeView r6 = this.a.m;
        if (r6 == null) goto L13;
        IAnimatedBgInfo r7 = r5.getAnimatedBgInfo();
        if (r7 == null) goto L7;
        py.k r8 = r7.getAnimatedBg();
    L8:
        if (r8 == null) goto L10;
        int r9 = 0;
    L11:
        r6.setVisibility(r9);
        return;
    L10:
        r9 = 8;
        goto L11
    L7:
        r8 = null;
        goto L8
    }
}
