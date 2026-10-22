package com.bytedance.android.live.effect.view;

import android.os.Message;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.common.utility.collection.WeakHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/view/EffectLiveBroadcastActivityProxy;", "Lcom/bytedance/android/live/effect/view/LiveEffectActivityProxy;", "", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectLiveBroadcastActivityProxy extends LiveEffectActivityProxy implements WeakHandler.IHandler {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onCreate() {
        super.onCreate();
        throw null;
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onDestroy() {
        super.onDestroy();
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L6;
        r0.getMessageCenter();
    L6:
        throw null;
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onPause() {
        throw null;
    }
}
