package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements a3.b {
    public final /* synthetic */ InteractAudienceViewHolder a;
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b b;

    public final void onFail() {
    }

    public final void a(NinePatchDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
        this.a.j.setText(this.b.a);
    }

    public m(InteractAudienceViewHolder r1, com.bytedance.android.live.profit.fansclub.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
