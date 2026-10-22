package com.bytedance.android.live.recharge.nopassword;

import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final l a;

    public f(l r3) {
        Intrinsics.checkNotNullParameter(r3, "settingStrategy");
        this.a = r3;
        SetsKt.hashSetOf(new NoPasswordScene[]{NoPasswordScene.SCENE_PK, NoPasswordScene.SCENE_FANS_CLUB_JOIN, NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT});
    }
}
