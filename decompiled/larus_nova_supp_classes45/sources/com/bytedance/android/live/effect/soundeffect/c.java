package com.bytedance.android.live.effect.soundeffect;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ LiveSoundAdapter a;
    public final /* synthetic */ LiveSoundAdapter.ViewHolder b;

    public c(LiveSoundAdapter r1, LiveSoundAdapter.ViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        if (r5.getAction() == 1) goto L6;
        return false;
    L6:
        if (this.b.j == true) goto L10;
        r4.performClick();
        return false;
    L10:
        if (this.a.b == null) goto L12;
        ALogger.d("ttlive_anchor_effect_LiveSoundEffectHelper", "disable PlayMode");
    L12:
        LiveSoundAdapter.ViewHolder r6 = this.b;
        r6.d.setVisibility(8);
        ViewParent r7 = r6.i.getParent();
        if (r7 == null) goto L15;
        r7.requestDisallowInterceptTouchEvent(false);
    L15:
        r6.j = false;
        return true;
    }
}
