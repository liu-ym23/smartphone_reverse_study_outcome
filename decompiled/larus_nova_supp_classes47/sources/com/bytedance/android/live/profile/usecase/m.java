package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements ut0.d {
    public boolean a;
    public final a b;

    @Override // ut0.d
    public final void a() {
        IBaseUser r0 = this.b.getRoomUser();
        DataCenter r1 = this.b.getRoomDataCenter();
        if (r1 == null) goto L8;
        IRoom r2 = a0.n(r1);
        if (r2 == null) goto L9;
        os0.b.c().getIInteractService().g(r2.getRoomId(), r0);
        return;
    L9:
        return;
    }

    @Override // ut0.d
    public final void b() {
        IBaseUser r0 = this.b.getRoomUser();
        DataCenter r1 = this.b.getRoomDataCenter();
        if (r1 == null) goto L24;
        Integer r2 = (Integer) r1.get("data_link_state", 0);
        if (v.a(r2.intValue(), 32) == false) goto L11;
        if (this.a == true) goto L9;
        f2.b(2131921725, 0);
        return;
    L9:
        r1.put("cmd_video_talk_invite", r0);
        return;
    L11:
        if (v.a(r2.intValue(), 8) == false) goto L17;
        if (this.a == true) goto L15;
        f2.b(2131921725, 0);
        return;
    L15:
        r1.put("cmd_audio_talk_invite", r0);
        return;
    L17:
        if (v.a(r2.intValue(), 2) == false) goto L20;
        r1.put("cmd_interact_audience_invite", r0);
        return;
    L20:
        if (v.a(r2.intValue(), 512) == false) goto L22;
        r1.put("cmd_new_video_link_invite", r0);
        return;
    L22:
        ALogger.i(NewProfileInfoViewModel.TAG, "invite-none");
        return;
    }

    @Override // ut0.d
    public final void c() {
        IBaseUser r0 = this.b.getRoomUser();
        DataCenter r1 = this.b.getRoomDataCenter();
        if (r1 == null) goto L24;
        Integer r2 = (Integer) r1.get("data_link_state", 0);
        if (r2 == null) goto L25;
        int r3 = r2.intValue();
        boolean r4 = this.b.getPageTypeUseCase().c;
        if (v.a(r3, 32) == false) goto L12;
        if (os0.b.c().getIInteractService().getVideoTalkService().l(r4, r0.getIdString()) == true) goto L26;
        this.a = true;
        return;
    L26:
        return;
    L12:
        if (v.a(r3, 8) == false) goto L17;
        if (os0.b.c().getIInteractService().getAudioTalkService().k(r4, r0.getIdString()) == true) goto L28;
        this.a = true;
        return;
    L28:
        return;
    L17:
        if (v.a(r3, 2) == true) goto L19;
        return;
    L19:
        if (v.a(r3, 64) == false) goto L21;
        return;
    L21:
        if (v.a(r3, 4) == true) goto L32;
        this.a = true;
        return;
    L32:
        return;
    L25:
        return;
    }

    public m(a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileViewModel");
        this.b = r2;
    }
}
