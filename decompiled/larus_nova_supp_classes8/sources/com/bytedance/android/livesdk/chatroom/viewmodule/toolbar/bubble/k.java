package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface k {
    void cancelShowEffect();

    void checkClickEffectButton(lp1.a r1);

    BubbleEnv getBubbleEnv();

    Observable<g.b> getOnGuideButtonClick();

    Observable<g.b> getOnGuideEffectShow();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e getTheGuideButton();

    void notifyGuideEffectOnShow(g.b r1);

    void setBubbleEnv(BubbleEnv r1);

    void setTheGuideButton(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1);

    void showGuideEffect(long r1, Function1<? super k, Unit> r3);
}
