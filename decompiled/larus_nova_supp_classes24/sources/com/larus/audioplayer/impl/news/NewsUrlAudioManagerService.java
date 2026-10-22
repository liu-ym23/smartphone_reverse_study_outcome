package com.larus.audioplayer.impl.news;

import b88.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audioplayer.api.news.INewsUrlAudioManager;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.platform.api.l0;
import com.larus.platform.api.n;
import f88.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J)\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J;\u0010\"\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016¨\u0006+"}, d2 = {"Lcom/larus/audioplayer/impl/news/NewsUrlAudioManagerService;", "Lcom/larus/audioplayer/api/news/INewsUrlAudioManager;", "<init>", "()V", "getCurrentUrlData", "Lcom/larus/audioplayer/api/news/NewsAudioData;", "getCurrentAudioStatus", "", "getAudioStatus", "Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "targetUrl", "", "sourceType", "videoModel", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "getAudioPausedReason", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "getCurrentScene", "playAudio", "", "urlData", "callback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "pauseAudio", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "stopAudio", "getAudioDuration", "setAudioPlaySpeed", "scene", "speed", "", "getAudioPlaySpeed", "getAudioCurrentPlaybackTime", "setAudioCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/platform/api/IFlowSeekCompletionListener;)Z", "getSystemVolume", "getSystemMaxVolume", "dismissPlayService", "isLoadStalled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class NewsUrlAudioManagerService implements INewsUrlAudioManager {
    public NewsUrlAudioManagerService() {
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final d c() {
        a r0 = a.a;
        return a.f;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final int f() {
        a r0 = a.a;
        b r1 = a.g;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.m.getCurrentPlaybackTime();
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final int getAudioDuration() {
        a r0 = a.a;
        b r1 = a.g;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.m.n();
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final float j(String r4) {
        a r0 = a.a;
        if (r4 != null) goto L9;
        b r5 = a.g;
        if (r5 == null) goto L11;
        n r6 = r5.m.a();
        if (r6 != null) goto L13;
        return 1.0f;
    L13:
        return r6.a;
    L11:
        return 1.0f;
    L9:
        int r1 = com.larus.audioplayer.impl.utils.b.a;
        Intrinsics.checkNotNullParameter(r4, "scene");
        return xg9.b.a().getFloat("play_audio_speed-".concat(r4), 1.0f);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean e(String r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        a r1 = a.a;
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r5 > 0.0f) goto L5;
        return false;
    L5:
        int r2 = com.larus.audioplayer.impl.utils.b.a;
        Intrinsics.checkNotNullParameter(r4, "scene");
        xg9.b.a().storeFloat("play_audio_speed-" + r4, r5);
        d r0 = a.f;
        if (r0 == null) goto L8;
        String r3 = r0.a;
    L10:
        if (Intrinsics.areEqual(r4, r3) == false) goto L15;
        n r6 = a.j;
        r6.a = r5;
        b r7 = a.g;
        if (r7 == null) goto L14;
        Intrinsics.checkNotNullParameter(r6, "params");
        r7.m.H(r6);
    L14:
        a.a(new g());
    L15:
        return true;
    L8:
        r3 = null;
        goto L10
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final void i(d r2, b88.a r3) {
        Intrinsics.checkNotNullParameter(r2, "urlData");
        a.a.e(r2, r3);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final String a(String r3, Integer r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "targetUrl");
        a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "targetUrl");
        if (a.c(r3, r4, r5) == false) goto L10;
        b r6 = a.g;
        if (r6 != null) goto L7;
        return null;
    L7:
        if (r6.n.a == UrlAudioPlayStatus.PAUSED) goto L9;
        return null;
    L9:
        return r6.p;
    L10:
        return null;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean d(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        return a.a.i(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean g(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        return a.a.d(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final UrlAudioPlayStatus h(String r3, Integer r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "targetUrl");
        a r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "targetUrl");
        if (a.c(r3, r4, r5) == false) goto L10;
        b r6 = a.g;
        if (r6 == null) goto L12;
        UrlAudioPlayStatus r7 = r6.n.a;
        if (r7 == null) goto L12;
        return r7;
    L12:
        return UrlAudioPlayStatus.UNKNOWN;
    L10:
        return UrlAudioPlayStatus.UNKNOWN;
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean b(String r2, Integer r3, String r4, int r5, l0 r6) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        a r0 = a.a;
        return a.g(r2, r3, r4, r5, r6);
    }
}
