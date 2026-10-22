package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import tf0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements q {
    public final /* synthetic */ ToolbarAudioInteractBehavior a;
    public final /* synthetic */ int b;

    @Override // tf0.q
    public final void a() {
    }

    @Override // tf0.q
    public final void b() {
        StringBuilder r0 = new StringBuilder("showFollowGuideDialog onFollowSuccess, internalService is null: ");
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        ALogger.d("ToolbarAudioInteractBehavior", r0.toString());
        if (this.a.p == null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.base.g r2 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r2 == null) goto L13;
        r2.Zl(this.b);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public b(ToolbarAudioInteractBehavior r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
