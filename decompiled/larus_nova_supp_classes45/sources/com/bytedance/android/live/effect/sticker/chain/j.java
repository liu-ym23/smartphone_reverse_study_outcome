package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements m {
    public j() {
    }

    public static String b(String r1) {
        if (Intrinsics.areEqual(r1, d0.c) == false) goto L6;
    L20:
        return "特效";
    L6:
        if (Intrinsics.areEqual(r1, d0.a) == false) goto L9;
        return "滤镜";
    L9:
        if (Intrinsics.areEqual(r1, d0.k) == false) goto L12;
        return "风格妆";
    L12:
        if (Intrinsics.areEqual(r1, d0.b) == false) goto L15;
        return "手势魔法";
    L15:
        if (Intrinsics.areEqual(r1, d0.h) == false) goto L18;
        return "互动特效";
    L18:
        if (Intrinsics.areEqual(r1, "live_camera_move") == false) goto L20;
        return "运镜";
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r4) {
        Intrinsics.checkNotNullParameter(r4, "chain");
        List<String> r0 = LiveEffectContext.h;
        ILiveEffectComposerManager r1 = LiveEffectContext.a.a(r4.getType()).a();
        if (r1.U(r4.f) <= 0) goto L10;
        Map<Long, String> r2 = r1.N(r4.f);
        StringBuilder r3 = new StringBuilder("当前");
        Map.Entry r5 = (Map.Entry) CollectionsKt.firstOrNull(r2.entrySet());
        if (r5 == null) goto L8;
        String r6 = (String) r5.getValue();
        if (r6 == null) goto L8;
    L9:
        r3.append(b(r6));
        r3.append("不支持更换");
        r3.append(b(r4.f));
        f2.c(r3.toString(), 0);
        Intrinsics.checkNotNullParameter("repel", "reason");
        r4.b = false;
        return;
    L8:
        r6 = "";
        goto L9
    L10:
        r4.a();
    }
}
