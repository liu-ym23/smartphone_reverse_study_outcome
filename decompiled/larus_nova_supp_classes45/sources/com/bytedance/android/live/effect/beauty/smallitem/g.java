package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements LiveSmallItemBeautyHelper.c {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ q d;

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
    public final void onError() {
        q r0 = this.d;
        if (r0 == null) goto L6;
        r0.onError();
        return;
    }

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.c
    public final void onSuccess(List<Sticker> r4) {
        Intrinsics.checkNotNullParameter(r4, "stickerList");
        Map<String, Map<String, List<Sticker>>> r0 = this.a.b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (r1.get(this.b) != null) goto L5;
        this.a.b.put(this.b, new LinkedHashMap());
    L5:
        Map<String, Map<String, List<Sticker>>> r2 = this.a.b;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        Map r5 = (Map) r3.get(this.b);
        if (r5 == null) goto L8;
        List r6 = (List) r5.put(this.c, r4);
    L8:
        q r7 = this.d;
        if (r7 == null) goto L12;
        r7.a(r4, null);
        return;
    }

    public g(d r1, String r2, String r3, q r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
