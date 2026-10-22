package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.AnAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class NormalComboEnterAnimHelper extends b {
    public static final float p = 0.0f;
    public final float l;
    public final float m;
    public final float n;
    public final boolean o;

    public static final class a {
    }

    static {
        p = s1.f(20.0f);
        s1.f(14.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> b() {
        return new NormalComboEnterAnimHelper$enterAnimDescription$1(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> c() {
        return new NormalComboEnterAnimHelper$exitAnimDescription$1(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> d() {
        return new NormalComboEnterAnimHelper$stayAnimDescription$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NormalComboEnterAnimHelper(BaseWindScreenAnimEnterTrayView r2, BaseWindScreenAnimEnterTrayView r3, z r4, float r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "animView");
        Intrinsics.checkNotNullParameter(r3, "comboView");
        Intrinsics.checkNotNullParameter(r4, "comboAnimBridge");
        super(r2, r3, r4);
        this.m = 40.0f;
        this.n = r5;
        this.o = r6;
        this.l = r2.getX();
    }
}
