package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.AnAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EmergeComboEnterAnimHelper extends b {
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> b() {
        return EmergeComboEnterAnimHelper$enterAnimDescription$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> c() {
        return EmergeComboEnterAnimHelper$exitAnimDescription$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.utils.b
    public final Function1<AnAnimator, Unit> d() {
        return EmergeComboEnterAnimHelper$stayAnimDescription$1.INSTANCE;
    }

    public EmergeComboEnterAnimHelper(BaseWindScreenAnimEnterTrayView r2, BaseWindScreenAnimEnterTrayView r3, z r4) {
        Intrinsics.checkNotNullParameter(r2, "animView");
        Intrinsics.checkNotNullParameter(r3, "comboView");
        Intrinsics.checkNotNullParameter(r4, "comboAnimBridge");
        super(r2, r3, r4);
    }
}
