package com.bytedance.android.live.effect.beauty.body;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements com.bytedance.android.live.effect.api.k.f {
    public final /* synthetic */ g a;
    public final /* synthetic */ LiveBodyBeautyHelper$tryDownloadSticker$1 b;
    public final /* synthetic */ LiveSmallItemBeautyHelper.b c;
    public final /* synthetic */ boolean d;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r1, Sticker r2) {
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r3, Sticker r4) {
        if (Intrinsics.areEqual("livebody", r3) == false) goto L12;
        if (r4 != null) goto L6;
    L8:
        this.b.invoke(this.c, r4);
        Iterator<T> r5 = this.a.b.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        LiveSmallItemBeautyHelper.b r0 = (LiveSmallItemBeautyHelper.b) r5.next();
        this.b.invoke(r0, r4);
        goto L10
    L14:
        return;
    L6:
        if (this.d == false) goto L8;
        this.a.a(r4);
        goto L8
    }

    public j(g r1, LiveBodyBeautyHelper$tryDownloadSticker$1 r2, LiveSmallItemBeautyHelper.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = true;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r2, Sticker r3, ExceptionResult r4) {
        if (Intrinsics.areEqual("livebody", r2) == false) goto L8;
        this.b.invoke(this.c, null);
        Iterator<T> r5 = this.a.b.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        LiveSmallItemBeautyHelper.b r6 = (LiveSmallItemBeautyHelper.b) r5.next();
        this.b.invoke(r6, null);
        goto L6
    L10:
        return;
    }
}
