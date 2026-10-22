package com.larus.audioplayer.api.manager;

import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006\u0010"}, d2 = {"Lcom/larus/audioplayer/api/manager/IAudioStopTimerManager;", "", "getSupportedSceneList", "", "", "getStopTime", "", "scene", "(Ljava/lang/String;)Ljava/lang/Long;", "enableStopTimer", "", "duration", "timerCallback", "Lcom/larus/audioplayer/api/manager/IAudioStopTimerCallback;", "disablerStopTimer", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IAudioStopTimerManager {
    List<String> a();

    Long b(String r1);

    boolean c(String r1);

    void d(String r1, long r2, SetAudioStopTimerMethod.a r4);
}
