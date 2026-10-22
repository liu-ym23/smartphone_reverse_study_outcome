package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements com.bytedance.android.live.effect.api.k.f {
    public final /* synthetic */ l a;
    public final /* synthetic */ LiveColorAdjustHelper$tryDownloadSticker$1 b;
    public final /* synthetic */ l.b c;
    public final /* synthetic */ boolean d;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r1, Sticker r2) {
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r3, Sticker r4) {
        if (Intrinsics.areEqual("live_adjustment", r3) == false) goto L12;
        if (r4 != null) goto L6;
    L8:
        this.b.invoke(this.c, r4);
        Iterator<T> r5 = this.a.c.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        l.b r0 = (l.b) r5.next();
        this.b.invoke(r0, r4);
        goto L10
    L14:
        return;
    L6:
        if (this.d == false) goto L8;
        this.a.d(r4);
        goto L8
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r2, Sticker r3, ExceptionResult r4) {
        if (Intrinsics.areEqual("live_adjustment", r2) == false) goto L8;
        this.b.invoke(this.c, null);
        Iterator<T> r5 = this.a.c.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        l.b r6 = (l.b) r5.next();
        this.b.invoke(r6, null);
        goto L6
    L10:
        return;
    }

    public r(l r1, LiveColorAdjustHelper$tryDownloadSticker$1 r2, l.b r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
