package com.bytedance.android.live.effect.avadjust.lens;

import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements LiveLensAdapter.a {
    public final /* synthetic */ LiveLensFragment a;

    public b(LiveLensFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.avadjust.lens.LiveLensAdapter.a
    public final void a(k90.a r4) {
        Intrinsics.checkNotNullParameter(r4, "lensData");
        LiveLensFragment r0 = this.a;
        r4.getClass();
        r0.e = null;
        ((LinearLayout) r0.S90(2131388008)).removeAllViews();
        ((ArrayList) r0.h).clear();
        r4.getClass();
        Collection r2 = (Collection) null;
        ((LinearLayout) r0.S90(2131388008)).setVisibility(4);
        r4.getClass();
        LiveLensFragment r1 = this.a;
        r4.getClass();
        r1.T90("livesdk_sound_image_set_tab_color_detail_icon_click", "", new HashMap());
    }
}
