package com.larus.audioplayer.api.manager;

import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/audioplayer/api/manager/NoopAudioStopTimerManager;", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerManager;", "<init>", "()V", "getSupportedSceneList", "", "", "getStopTime", "", "scene", "(Ljava/lang/String;)Ljava/lang/Long;", "enableStopTimer", "", "duration", "timerCallback", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerCallback;", "disablerStopTimer", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class NoopAudioStopTimerManager implements IAudioStopTimerManager {
    public static final NoopAudioStopTimerManager a = null;

    static {
        a = new NoopAudioStopTimerManager();
    }

    private NoopAudioStopTimerManager() {
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final Long b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return null;
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return false;
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final void d(String r1, long r2, SetAudioStopTimerMethod.a r4) {
        Intrinsics.checkNotNullParameter(r1, "scene");
    }

    @Override // com.larus.audioplayer.api.manager.IAudioStopTimerManager
    public final List<String> a() {
        return CollectionsKt.emptyList();
    }
}
