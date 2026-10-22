package com.bytedance.android.live.effect.cameramovement;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends com.bytedance.android.live.effect.common.a implements com.bytedance.android.live.effect.cameramovement.a {

    public static final class a {
    }

    static {
    }

    public c(LiveEffectContextFactoryDelegate$Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        super(r3);
    }
}
