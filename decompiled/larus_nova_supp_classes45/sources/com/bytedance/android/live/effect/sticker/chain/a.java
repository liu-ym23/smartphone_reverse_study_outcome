package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.presenter.s;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements m {
    public a() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r8) {
        Intrinsics.checkNotNullParameter(r8, "chain");
        List<String> r0 = LiveEffectContext.h;
        s r1 = LiveEffectContext.a.a(r8.getType()).b().i();
        boolean r2 = r8.g.isAigcSticker();
        boolean r3 = true;
        if ((!r1.i(r8.g.getId()).isEmpty()) == true) goto L5;
    L7:
        r3 = false;
    L9:
        if (r8.e != LiveEffectScene.Live) goto L13;
        if (r2 == false) goto L13;
        if (r3 == true) goto L13;
        f2.b(2131916328, 0);
        Intrinsics.checkNotNullParameter("aigc特效未在开播前生成背景", "reason");
        r8.b = false;
        return;
    L13:
        r8.a();
        return;
    L5:
        if (r1.g(r8.g.getId()) == false) goto L7;
        goto L7
    }
}
