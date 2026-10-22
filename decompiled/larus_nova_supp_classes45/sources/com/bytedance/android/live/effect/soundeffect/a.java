package com.bytedance.android.live.effect.soundeffect;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LiveSoundAdapter a;
    public final /* synthetic */ LiveSoundAdapter.ViewHolder b;

    public a(LiveSoundAdapter r1, LiveSoundAdapter.ViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
    L31:
        th = move-exception;
        ALogger.e("ttlive_anchor_effect_LiveSoundAdapter", "viewHolder onClick:", th);
        return;
    L4:
        if (this.a.f != this.b.getAdapterPosition()) goto L6;
        return;
    L6:
        Sticker r1 = this.a.z2();     // Catch: Throwable -> L31
        if (r1 == null) goto L11;
        LiveSoundEffectHelper r3 = this.a.b;     // Catch: Throwable -> L31
        if (r3 == null) goto L11;
        int r4 = LiveSoundEffectHelper.h;     // Catch: Throwable -> L31
        r3.b(r1, false, true);     // Catch: Throwable -> L31
    L11:
        this.a.f = this.b.getAdapterPosition();     // Catch: Throwable -> L31
        Sticker r2 = this.a.z2();     // Catch: Throwable -> L31
        if (r2 != null) goto L14;
        return;
    L14:
        if (m90.b.z.c(this.a.h).booleanValue() == true) goto L16;
    L20:
        LiveEffectContextFactoryDelegate$Type r5 = this.a.h;     // Catch: Throwable -> L31
        Map<String, Long> r6 = h.a;     // Catch: Throwable -> L31
        Intrinsics.checkNotNullParameter(r2, "sticker");     // Catch: Throwable -> L31
        Intrinsics.checkNotNullParameter(r5, "type");     // Catch: Throwable -> L31
        h.c(r2, "live_take_voice_select", r5);     // Catch: Throwable -> L31
        StringBuilder r7 = new StringBuilder("sound viewHoler onclick, index:");     // Catch: Throwable -> L31
        r7.append(this.a.f);     // Catch: Throwable -> L31
        r7.append(" stickerId:");     // Catch: Throwable -> L31
        Sticker r0 = this.a.z2();     // Catch: Throwable -> L31
        if (r0 == null) goto L23;
        Long r9 = Long.valueOf(r0.getId());     // Catch: Throwable -> L31
    L24:
        r7.append(r9);     // Catch: Throwable -> L31
        ALogger.d("ttlive_anchor_effect_LiveSoundAdapter", r7.toString());     // Catch: Throwable -> L31
        LiveSoundEffectHelper r11 = this.a.b;     // Catch: Throwable -> L31
        if (r11 == null) goto L28;
        LiveSoundEffectHelper.c(r11, r2, null, this.b, 2);     // Catch: Throwable -> L31
    L28:
        if (r2.isDownloaded() == true) goto L37;
        this.b.e.setVisibility(8);     // Catch: Throwable -> L31
        this.b.f.setVisibility(0);     // Catch: Throwable -> L31
        return;
    L37:
        return;
    L23:
        r9 = null;
        goto L24
    L16:
        if (this.a.b == null) goto L20;
        if (LiveSoundEffectHelper.a(r2) == true) goto L20;
        LiveSoundAdapter.y2(this.a, this.b);     // Catch: Throwable -> L31
        goto L20
    }
}
