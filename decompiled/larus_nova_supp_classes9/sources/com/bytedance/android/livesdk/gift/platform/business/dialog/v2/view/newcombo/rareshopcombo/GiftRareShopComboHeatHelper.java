package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftRareShopComboHeatHelper {
    public Animator a;
    public AnimatorSet b;
    public final NextLiveData<Boolean> c;
    public final NextLiveData<Boolean> d;
    public final long e;

    public static final class a {
    }

    static {
    }

    public GiftRareShopComboHeatHelper(long r7) {
        this.e = r7;
        this.c = new NextLiveData();
        final NextLiveData<Boolean> r8 = new NextLiveData();
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftRareShopComboHeatHelper$showCountDown$1$1(r8), 7);
        Unit r9 = Unit.INSTANCE;
        this.d = r8;
    }
}
