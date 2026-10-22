package com.larus.audioplayer.api.manager;

import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J#\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/larus/audioplayer/api/manager/AudioStopTimerManagerDelegate;", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerManager;", "<init>", "()V", "disablerStopTimer", "", "scene", "", "enableStopTimer", "", "duration", "", "timerCallback", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerCallback;", "getStopTime", "(Ljava/lang/String;)Ljava/lang/Long;", "getSupportedSceneList", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioStopTimerManagerDelegate implements IAudioStopTimerManager {
    public static final AudioStopTimerManagerDelegate b = null;
    public final /* synthetic */ IAudioStopTimerManager a;

    static {
        b = new AudioStopTimerManagerDelegate();
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final List<String> a() {
        return this.a.a();
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final Long b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return this.a.b(r2);
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return this.a.c(r2);
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final void d(String r2, long r3, SetAudioStopTimerMethod.a r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a.d(r2, r3, r5);
    }

    private AudioStopTimerManagerDelegate() {
        IAudioStopTimerManager r0 = (IAudioStopTimerManager) ServiceManager.get().getService(IAudioStopTimerManager.class);
        if (r0 != null) goto L5;
        r0 = NoopAudioStopTimerManager.a;
    L5:
        this.a = r0;
    }
}
