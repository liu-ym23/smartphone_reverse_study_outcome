package com.larus.urlplayer;

import android.app.Application;
import c2a.a;
import c2a.b;
import c2a.e;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaResourceManager;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngine;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/urlplayer/AudioUrlPlayImpl;", "Lcom/larus/urlplayer/IAudioUrlPlayService;", "<init>", "()V", "TAG", "", "playAudioByUrl", "", "url", "message", "Lcom/larus/im/bean/message/Message;", "startMethod", "stopAudioPlay", "endMethod", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AudioUrlPlayImpl implements IAudioUrlPlayService {
    public final String a;

    public AudioUrlPlayImpl() {
        this.a = "AudioUrlPlayImpl";
    }

    @Override // com.larus.urlplayer.IAudioUrlPlayService
    public final void C(String r5) {
        Intrinsics.checkNotNullParameter(r5, "endMethod");
        FLogger r1 = FLogger.a;
        r1.i(this.a, "stopAudioPlay, stopAudioPlay ".concat(r5));
        TTVideoEngine r2 = e.a;
        Intrinsics.checkNotNullParameter(r5, "endMethod");
        if (e.d == null) goto L11;
        r1.i("AudioUrlPlayer", "stopAudioPlay, is playing ,current url = " + e.c);
        TTVideoEngine r0 = e.a;
        if (r0 == null) goto L7;
        r0.pause();
    L7:
        TTVideoEngine r3 = e.a;
        if (r3 == null) goto L10;
        r3.release();
    L10:
        e.a = null;
        e.b(r5);
        e.a();
        return;
    L11:
        r1.i("AudioUrlPlayer", "stopAudioPlay, is not playing !");
    }

    @Override // com.larus.urlplayer.IAudioUrlPlayService
    public final void D(String r6, final Message r7) {
        Intrinsics.checkNotNullParameter(r6, "url");
        FLogger r1 = FLogger.a;
        r1.i(this.a, "playAudioByUrl " + r6 + ", startMethod click_play");
        TTVideoEngine r2 = e.a;
        Intrinsics.checkNotNullParameter(r6, "url");
        AppHost.Companion r0 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r0.getApplication()) == true) goto L5;
        s r8 = s.a;
        Application r9 = r0.getApplication();
        r8.getClass();
        s.s(r9, 2131907052);
        return;
    L5:
        Lazy r3 = q3.a;
        z3 r4 = q3.a();
        if (r4 == null) goto L8;
        r4.j();
    L8:
        e.a = new TTVideoEngine(r0.getApplication().getApplicationContext(), 0);
        e.e = "click_play";
        r1.i("AudioUrlPlayer", "playAudioByTTVideoEngine url ".concat(r6));
        TTVideoEngine r5 = e.a;
        if (r5 == null) goto L11;
        r5.setVideoEngineCallback(e.b);
    L11:
        TTVideoEngine r10 = e.a;
        if (r10 == null) goto L14;
        r10.setIntOption(160, 1);
    L14:
        String r11 = "md5_".concat(r6);
        TTVideoEngine r12 = e.a;
        if (r12 == null) goto L25;
        r12.setDirectUrlUseDataLoader(r6, r11);
    L25:
        e.c = r6;     // Catch: Exception -> L19
        e.d = r7;     // Catch: Exception -> L19
        Lazy r13 = MediaResourceManager.a;     // Catch: Exception -> L19
        MediaResourceManager.m(e.f, new a(r7), new b(), 0, 8);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        FLogger.a.e("AudioUrlPlayer", "playAudioByTTVideoEngine error " + e);
        TTVideoEngine r14 = e.a;
        if (r14 == null) goto L23;
        r14.release();
    L23:
        e.a = null;
        e.a();
    }
}
