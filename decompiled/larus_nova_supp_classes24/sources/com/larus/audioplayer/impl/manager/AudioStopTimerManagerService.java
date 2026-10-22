package com.larus.audioplayer.impl.manager;

import android.os.Handler;
import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audioplayer.api.manager.IAudioStopTimerManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/audioplayer/impl/manager/AudioStopTimerManagerService;", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerManager;", "<init>", "()V", "getSupportedSceneList", "", "", "getStopTime", "", "scene", "(Ljava/lang/String;)Ljava/lang/Long;", "enableStopTimer", "", "duration", "timerCallback", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerCallback;", "disablerStopTimer", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioStopTimerManagerService implements IAudioStopTimerManager {
    public AudioStopTimerManagerService() {
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final List<String> a() {
        Handler r0 = a.a;
        return CollectionsKt.listOf(new String[]{GlobalAudioSceneEnum.PLUGIN_MUSIC, GlobalAudioSceneEnum.PLUGIN_BACKGROUND_AUDIO, GlobalAudioSceneEnum.PODCAST, "news", GlobalAudioSceneEnum.QQ_MUSIC});
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final Long b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Handler r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "scene");
        a.RunnableC0087a r4 = a.b.get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.c;
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return a.a(r2);
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final void d(String r4, long r5, SetAudioStopTimerMethod.a r7) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Handler r1 = a.a;
        Intrinsics.checkNotNullParameter(r4, "scene");
        a.a(r4);
        a.RunnableC0087a r0 = new a.RunnableC0087a(r4, r7);
        a.b.put(r4, r0);
        r0.c = Long.valueOf(System.currentTimeMillis() + r5);
        a.a.postDelayed(r0, r5);
    }
}
