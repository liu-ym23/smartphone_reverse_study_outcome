package com.bytedance.android.livesdk.interactivity.api.textaudio;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastStream;
import kotlin.Metadata;
import t52.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/textaudio/BaseTextAudioManager;", "Lt52/a;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTextAudioManager extends ViewModel implements a {
    @Override // t52.a
    public abstract /* synthetic */ a.C0282a getPlaying();

    @Override // t52.a
    public abstract /* synthetic */ boolean isPlaying();

    @Override // t52.a
    public abstract /* synthetic */ void playAudioByPath(Context r1, a.C0282a r2);

    @Override // t52.a
    public abstract /* synthetic */ void playAudioByUrl(Context r1, a.C0282a r2);

    @Override // t52.a
    public abstract /* synthetic */ void register(a.b r1);

    @Override // t52.a
    public abstract /* synthetic */ void setLiveStream(IBroadcastStream r1);

    @Override // t52.a
    public abstract /* synthetic */ void stopAudio();

    @Override // t52.a
    public abstract /* synthetic */ void unregister(a.b r1);

    public BaseTextAudioManager() {
    }
}
