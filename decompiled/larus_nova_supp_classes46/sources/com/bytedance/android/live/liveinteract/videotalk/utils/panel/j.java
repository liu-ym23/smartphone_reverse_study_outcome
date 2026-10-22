package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements qh0.d<rh0.a> {
    public final /* synthetic */ VideoShowMode a;
    public final /* synthetic */ VideoShowMode b;

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
    }

    @Override // qh0.d
    public final void onResult(rh0.a r6) {
        if (hd0.c.f().h() == true) goto L8;
        rj0.l.n2.getClass();
        rj0.l r7 = rj0.l.a.a();
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.isEngineOn() == true) goto L8;
        return;
    L8:
        ILinkPlayerInfoBridge r8 = a.a;
        VideoShowMode r9 = this.b;
        VideoShowMode r0 = this.a;
        rj0.l.n2.getClass();
        rj0.l r1 = rj0.l.a.a();
        if (r1 == null) goto L11;
        m00.g r2 = r1.hh();
    L12:
        rj0.l r3 = rj0.l.a.a();
        if (r3 == null) goto L18;
        r3.So(r9.getType(), new d(r9, r0, r2), "link_interaction_panel_video", false);
        return;
    L18:
        return;
    L11:
        r2 = null;
        goto L12
    }

    public j(VideoShowMode r1, VideoShowMode r2) {
        this.a = r1;
        this.b = r2;
    }
}
