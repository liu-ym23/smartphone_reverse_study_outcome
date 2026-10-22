package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ LiveStickerDialogV2 a;
    public final /* synthetic */ Sticker b;
    public final /* synthetic */ long c;

    public a0(LiveStickerDialogV2 r1, Sticker r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        LiveStickerDialogV2 r9 = this.a;
        Sticker r0 = this.b;
        long r1 = this.c;
        int r3 = LiveStickerDialogV2.y;
        View r4 = r9.getView();
        if (r4 == null) goto L7;
        View r5 = r4.findViewById(2131362447);
        if (r5 == null) goto L7;
        r5.setVisibility(4);
    L7:
        long r6 = System.currentTimeMillis() - r1;
        List<String> r2 = com.bytedance.android.live.effect.utils.q.a;
        String r11 = r9.q.getPage();
        Intrinsics.checkNotNullParameter(r0, "sticker");
        Intrinsics.checkNotNullParameter(r11, "eventPage");
        HashMap r7 = new HashMap();
        r7.put("sticker_id", String.valueOf(r0.getId()));
        r7.put("duration", String.valueOf(r6));
        com.bytedance.android.live.effect.utils.q.e("livesdk_live_aisticker_instruction_watch", r7, r11);
    }
}
