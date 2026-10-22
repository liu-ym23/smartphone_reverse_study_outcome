package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public b0(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        View r4 = this.a.getView();
        if (r4 == null) goto L7;
        ConstraintLayout r5 = r4.findViewById(2131371502);
        if (r5 == null) goto L7;
        r5.setVisibility(8);
    L7:
        List<String> r6 = com.bytedance.android.live.effect.utils.q.a;
        String r7 = this.a.q.getPage();
        Intrinsics.checkNotNullParameter(r7, "page");
        com.bytedance.android.live.effect.utils.q.e("livesdk_live_take_sticker_mock_guide", new HashMap(), r7);
    }
}
