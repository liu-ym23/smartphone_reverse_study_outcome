package com.larus.audioplayer.api.news;

import b88.a;
import b88.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.platform.api.l0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J)\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J;\u0010\"\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016¨\u0006+"}, d2 = {"Lcom/larus/audioplayer/api/news/NoopNewsUrlAudioManager;", "Lcom/larus/audioplayer/api/news/INewsUrlAudioManager;", "<init>", "()V", "getCurrentUrlData", "Lcom/larus/audioplayer/api/news/NewsAudioData;", "getCurrentAudioStatus", "", "getAudioStatus", "Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "targetUrl", "", "sourceType", "videoModel", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "getAudioPausedReason", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "getCurrentScene", "playAudio", "", "urlData", "callback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "pauseAudio", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "stopAudio", "getAudioDuration", "setAudioPlaySpeed", "scene", "speed", "", "getAudioPlaySpeed", "getAudioCurrentPlaybackTime", "setAudioCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/platform/api/IFlowSeekCompletionListener;)Z", "getSystemVolume", "getSystemMaxVolume", "dismissPlayService", "isLoadStalled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class NoopNewsUrlAudioManager implements INewsUrlAudioManager {
    public static final NoopNewsUrlAudioManager a = null;

    static {
        a = new NoopNewsUrlAudioManager();
    }

    private NoopNewsUrlAudioManager() {
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final String a(String r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "targetUrl");
        return null;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean b(String r1, Integer r2, String r3, int r4, l0 r5) {
        Intrinsics.checkNotNullParameter(r1, "targetUrl");
        return false;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final d c() {
        return null;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean d(String r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "targetUrl");
        return false;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean e(String r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        return false;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final int f() {
        return 0;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean g(String r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "targetUrl");
        return false;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final int getAudioDuration() {
        return 0;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final void i(d r1, a r2) {
        Intrinsics.checkNotNullParameter(r1, "urlData");
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final float j(String r1) {
        return 1.0f;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final UrlAudioPlayStatus h(String r1, Integer r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "targetUrl");
        return UrlAudioPlayStatus.UNKNOWN;
    }
}
