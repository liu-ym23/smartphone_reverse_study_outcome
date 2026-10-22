package com.bytedance.android.live.liveinteract.widget.widget;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements a3.b {
    public final /* synthetic */ SelectPairRankAdapter.SelectPairRankItemViewHolder a;
    public final /* synthetic */ py.h b;

    public final void onFail() {
    }

    public final void a(NinePatchDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
        UIUtils.setText(this.a.f, this.b.getClubName());
    }

    public a0(SelectPairRankAdapter.SelectPairRankItemViewHolder r1, py.h r2) {
        this.a = r1;
        this.b = r2;
    }
}
