package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends com.bytedance.android.live.livepkaudience.base.x {
    public final /* synthetic */ PkAudienceListInviteDialogFragment a;
    public final /* synthetic */ LinkPlayerInfo b;

    public m(PkAudienceListInviteDialogFragment r1, LinkPlayerInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
    public final void V6(String r2, LinkInviteResult r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "result");
        this.b.isHasInvited = true;
        MultiTypeAdapter r4 = this.a.h;
        if (r4 == null) goto L6;
        r4.notifyDataSetChanged();
        return;
    }
}
