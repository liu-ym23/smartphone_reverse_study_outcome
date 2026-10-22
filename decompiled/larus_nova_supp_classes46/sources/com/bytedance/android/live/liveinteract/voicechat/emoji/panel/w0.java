package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w0 extends g {
    public final int f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (this.f != ThemedCompetitionRole.PERFORMER.getValue()) goto L6;
        return s1.B(2131919403);
    L6:
        return s1.B(2131919407);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r4) {
        Intrinsics.checkNotNullParameter(r4, "icon");
        int r0 = qy.a.a;
        ImageUtil.loadRoundImage(r4, qy.a.b("", CollectionsKt.arrayListOf(new String[]{LiveCommonConstants.assembleTosObjectUrl(com.bytedance.android.live.liveinteract.videotalk.themecompetition.d.a)})));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (this.f != ThemedCompetitionRole.CONTESTANT.getValue()) goto L5;
        boolean r3 = true;
    L6:
        this.e.l(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public w0(q0 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
        this.f = r3;
    }
}
