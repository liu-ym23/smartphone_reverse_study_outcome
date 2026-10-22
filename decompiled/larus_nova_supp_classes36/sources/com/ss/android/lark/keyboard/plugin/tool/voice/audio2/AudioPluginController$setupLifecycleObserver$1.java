package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, d2 = {"com/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController$setupLifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "resume", "", "pause", "destroy", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioPluginController$setupLifecycleObserver$1 implements LifecycleObserver {
    public AudioPluginController$setupLifecycleObserver$1() {
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        Log.i("AudioPluginController", "Lifecycle onDestroy");
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause() {
        Log.i("AudioPluginController", "Lifecycle onPause");
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        Log.i("AudioPluginController", "Lifecycle onResume");
        throw null;
    }
}
