package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements q {
    public final /* synthetic */ q a;

    @Override // com.bytedance.android.live.effect.beauty.smallitem.q
    public final void onError() {
        q r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError();
        return;
    }

    public e(q r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.q
    public final void a(List<Sticker> r2, List<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "stickerList");
        ArrayList r4 = new ArrayList();
        r4.add(Integer.valueOf(r2.size()));
        q r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2, r4);
        return;
    }
}
