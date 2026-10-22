package com.larus.audioplayer.api.news;

import b88.a;
import b88.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.platform.api.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J,\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0096\u0001J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J*\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0001J<\u0010#\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0001¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0010H\u0096\u0001J*\u0010*\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010\u001e¨\u0006+"}, d2 = {"Lcom/larus/audioplayer/api/news/NewsUrlAudioManagerDelegate;", "Lcom/larus/audioplayer/api/news/INewsUrlAudioManager;", "<init>", "()V", "dismissPlayService", "", "getAudioCurrentPlaybackTime", "", "getAudioDuration", "getAudioPausedReason", "", "targetUrl", "sourceType", "videoModel", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "getAudioPlaySpeed", "", "scene", "getAudioStatus", "Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "getCurrentAudioStatus", "getCurrentScene", "getCurrentUrlData", "Lcom/larus/audioplayer/api/news/NewsAudioData;", "getSystemMaxVolume", "getSystemVolume", "isLoadStalled", "", "pauseAudio", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "playAudio", "urlData", "callback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "setAudioCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/platform/api/IFlowSeekCompletionListener;)Z", "setAudioPlaySpeed", "speed", "stopAudio", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class NewsUrlAudioManagerDelegate implements INewsUrlAudioManager {
    public static final NewsUrlAudioManagerDelegate b = null;
    public final /* synthetic */ INewsUrlAudioManager a;

    static {
        b = new NewsUrlAudioManagerDelegate();
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final String a(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        return this.a.a(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean b(String r8, Integer r9, String r10, int r11, l0 r12) {
        Intrinsics.checkNotNullParameter(r8, "targetUrl");
        return this.a.b(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final d c() {
        return this.a.c();
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean d(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        return this.a.d(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean e(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return this.a.e(r2, r3);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final int f() {
        return this.a.f();
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final boolean g(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        return this.a.g(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final int getAudioDuration() {
        return this.a.getAudioDuration();
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final UrlAudioPlayStatus h(String r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUrl");
        return this.a.h(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final void i(d r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "urlData");
        this.a.i(r2, r3);
    }

    @Override // com.larus.audioplayer.api.news.INewsUrlAudioManager
    public final float j(String r2) {
        return this.a.j(r2);
    }

    private NewsUrlAudioManagerDelegate() {
        INewsUrlAudioManager r0 = (INewsUrlAudioManager) ServiceManager.get().getService(INewsUrlAudioManager.class);
        if (r0 != null) goto L5;
        r0 = NoopNewsUrlAudioManager.a;
    L5:
        this.a = r0;
    }
}
