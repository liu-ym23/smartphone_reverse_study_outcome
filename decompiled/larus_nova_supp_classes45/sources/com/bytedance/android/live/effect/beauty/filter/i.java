package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements k.f {
    public final /* synthetic */ LiveComposerFilterHelper a;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r1, Sticker r2) {
    }

    public i(LiveComposerFilterHelper r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r2, Sticker r3) {
        if (StringUtils.equal(d0.a, r2) == false) goto L13;
        if (r3 != null) goto L9;
        Iterator<T> r4 = this.a.c.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r4.next()).onError();
        goto L7
    L16:
        return;
    L9:
        Iterator<T> r5 = this.a.c.iterator();
    L11:
        if (r5.hasNext() == false) goto L17;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r5.next()).a(r3);
        goto L11
    L17:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r1, Sticker r2, ExceptionResult r3) {
        if (StringUtils.equal(d0.a, r1) == false) goto L8;
        Iterator<T> r4 = this.a.c.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r4.next()).onError();
        goto L6
    L10:
        return;
    }
}
