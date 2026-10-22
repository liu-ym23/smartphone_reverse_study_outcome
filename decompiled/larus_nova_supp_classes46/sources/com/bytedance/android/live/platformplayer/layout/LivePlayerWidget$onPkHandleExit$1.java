package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePlayerWidget$onPkHandleExit$1 extends MutablePropertyReference0Impl {
    public LivePlayerWidget$onPkHandleExit$1(LivePlayerWidget r7) {
        super(r7, LivePlayerWidget.class, "playerView", "getPlayerView()Lcom/bytedance/android/livesdkapi/roomplayer/AbsLivePlayerView;", 0);
    }

    public Object get() {
        return ((LivePlayerWidget) ((CallableReference) this).receiver).R8();
    }

    public void set(Object r2) {
        ((LivePlayerWidget) ((CallableReference) this).receiver).Mu((AbsLivePlayerView) r2);
    }
}
