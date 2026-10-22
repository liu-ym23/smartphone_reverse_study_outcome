package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        qo0.a.c("LiveMgFloatDialog", "onBackCast");
        ((LiveMgMountContextService) this.a.d.getService(LiveMgMountContextService.class)).l();
        TextView r3 = this.a.c;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("castTipsTV");
    L5:
        r3.setText("返回游戏");
    }
}
