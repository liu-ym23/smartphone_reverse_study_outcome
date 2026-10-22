package com.larus.voicecall.impl.scene;

import com.larus.im.bean.bot.SceneModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o {
    public final SceneModel a;
    public final l b;
    public final n c;
    public boolean d;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.voicecall.impl.scene.n] */
    public o(SceneModel r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "impl");
        this.a = r2;
        this.b = r3;
        this.c = new n(this);
    }
}
