package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget.c a;

    public m(LinkmicSubtitleBusinessWidget.c r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        UtilityKotlinExtentionsKt.s(0, false, false, new LinkmicSubtitleBusinessWidget$registerAudioChatStageObservable$1$1$1(this), 7);
    }
}
