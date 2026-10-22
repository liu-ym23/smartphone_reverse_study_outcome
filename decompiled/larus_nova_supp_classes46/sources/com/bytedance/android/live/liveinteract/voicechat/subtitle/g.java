package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public g(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Integer r7 = (Integer) r6;
        if (r7 != null) goto L6;
    L7:
        if (r7 != null) goto L10;
    L12:
        boolean r8 = li0.d.f(TeamFightContext.Companion.b());
        LinkmicSubtitleBusinessWidget r1 = this.a;
        r1.w = r8;
        if (r8 == false) goto L26;
        r1.h.put("stage_can_insert", Boolean.FALSE);
        return;
    L26:
        return;
    L10:
        if (r7.intValue() != 0) goto L12;
    L15:
        LinkmicSubtitleBusinessWidget r9 = this.a;
        boolean r2 = false;
        r9.w = false;
        Map<String, Boolean> r10 = r9.h;
        int r3 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == false) goto L24;
        Integer r4 = je0.d.h();
        LinkmicSubtitleBusinessWidget r5 = this.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.a(r4, r5.w, r5.Gq()) == false) goto L24;
        if (PadConfigUtils.c() == true) goto L24;
        if (FoldScreenUtils.f() == true) goto L24;
        r2 = true;
    L24:
        r10.put("stage_can_insert", Boolean.valueOf(r2));
        return;
    L6:
        if (r7.intValue() == 4) goto L15;
        goto L7
    }
}
