package com.lynx.animax.ui;

import android.content.Context;
import android.content.res.Resources;
import com.lynx.animax.ability.BaseAbility;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXContext {
    public final BaseAbility a;
    public final Context b;
    public final boolean c;
    public float d;

    public static class a {
        public final BaseAbility a;
        public final Context b;
        public boolean c;

        public a(BaseAbility r2, Context r3) {
            this.c = false;
            this.a = r2;
            this.b = r3;
        }
    }

    public boolean disablePlaybackOnAssetLoadFailure() {
        return y4a.a.e(y4a.a.b("ANIMAX_DISABLE_PLAYBACK_ON_ASSET_LOAD_FAILURE", this.a));
    }

    public float getDeviceDensity() {
        if (this.d > 0.0f) goto L6;
        Resources r0 = this.b.getResources();
        this.d = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    L6:
        return this.d;
    }

    public BaseAbility getAbility() {
        return this.a;
    }

    public Context getContext() {
        return this.b;
    }

    public boolean multiThreadAccelerate() {
        return this.c;
    }

    public AnimaXContext(a r2) {
        this.d = 0.0f;
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
    }
}
