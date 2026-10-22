package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.videotalk.emoji.t;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;

    public g(VoiceCommonMultiLinkWindowManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        zg1.g r4 = (zg1.g) r3;
        ALogger.i("VoiceCommonMultiLinkWindowManager", "received ApmOpenMulitLinkMicControlEvent");
        if (je0.d.r() == true) goto L5;
        return;
    L5:
        if (hd0.c.f().h() == true) goto L7;
        return;
    L7:
        if (((IInteractService) k.n(IInteractService.class)).isEnableTalkRoomEmoji() == false) goto L12;
        t r5 = new t();
        r5.e(this.a.getContext());
        r5.f(this.a.C);
        r5.g(true);
        Intrinsics.checkNotNullParameter("apm", "requestPage");
        r5.d = "apm";
        r5.c().a();
        return;
    }
}
