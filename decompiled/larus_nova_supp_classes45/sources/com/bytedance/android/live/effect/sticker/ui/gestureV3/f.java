package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements LiveGestureMagicPageAdapter.b {
    public final /* synthetic */ LiveGestureMagicPageAdapterVCD a;

    public f(LiveGestureMagicPageAdapterVCD r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter.b
    public final void a(Boolean r2, Sticker r3) {
        boolean r4 = r2.booleanValue();
        LiveGestureMagicPageAdapterVCD r0 = this.a;
        if (r3 != null) goto L5;
        r0.getClass();
        return;
    L5:
        LiveGestureMagicPageAdapter.b r1 = r0.a;
        if (r1 == null) goto L10;
        r1.a(Boolean.valueOf(r4), r3);
        return;
    }
}
