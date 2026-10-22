package com.bytedance.android.live.effect.soundeffect;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ LiveSoundAdapter a;
    public final /* synthetic */ LiveSoundAdapter.ViewHolder b;

    public b(LiveSoundAdapter r1, LiveSoundAdapter.ViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        if (this.a.f == this.b.getAdapterPosition()) goto L5;
        return false;
    L5:
        StringBuilder r6 = new StringBuilder("sound viewHoler Longclick, index:");
        r6.append(this.a.f);
        r6.append(" stickerId:");
        Sticker r0 = this.a.z2();
        if (r0 == null) goto L8;
        Long r1 = Long.valueOf(r0.getId());
    L9:
        r6.append(r1);
        ALogger.d("ttlive_anchor_effect_LiveSoundAdapter", r6.toString());
        LiveSoundAdapter.ViewHolder r7 = this.b;
        r7.d.setVisibility(0);
        ViewParent r2 = r7.i.getParent();
        if (r2 == null) goto L12;
        r2.requestDisallowInterceptTouchEvent(true);
    L12:
        r7.j = true;
        if (this.a.b == null) goto L15;
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "enable PlayMode");
    L15:
        m90.b.z.e(this.a.h, Boolean.FALSE);
        Sticker r8 = this.a.z2();
        if (r8 == null) goto L18;
        LiveEffectContextFactoryDelegate$Type r3 = this.a.h;
        Map<String, Long> r4 = h.a;
        Intrinsics.checkNotNullParameter(r8, "sticker");
        Intrinsics.checkNotNullParameter(r3, "type");
        h.c(r8, "live_take_voice_try", r3);
    L18:
        return true;
    L8:
        r1 = null;
        goto L9
    }
}
