package com.bytedance.android.live.profit.player;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d extends dy0.d {
    Class<? extends Widget> Hm();

    s<o> K(String r1);

    uu0.b Me();

    void Nc(a r1);

    e Qh();

    p f1();

    uu0.a hd(Context r1);

    Disposable lh(long r1, n r3);

    void no(uu0.b r1);

    void w1(IAssetsManager r1, long r2, int r4, Function2 r5);

    PublishSubject x1();
}
