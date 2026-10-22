package com.larus.audioplayer.impl;

import c88.a;
import com.bytedance.applet.utils.b;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audioplayer.api.stream.IAudioSteamPlayerService;
import com.larus.audioplayer.impl.stream.AudioStreamPlayer;
import com.larus.doc.impl.DocFragment;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Jd\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016¨\u0006&"}, d2 = {"Lcom/larus/audioplayer/impl/AudioStreamPlayerServiceImpl;", "Lcom/larus/audioplayer/api/stream/IAudioSteamPlayerService;", "<init>", "()V", "addInterceptor", "", "interceptor", "Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor;", "removeInterceptor", "start", "appletId", "", "title", "artist", "coverUrl", "url", "uuid", "listener", "Lcom/larus/audioplayer/api/IOnStreamPlayerStatesChangeListener;", "inputTimeOff", "", "scene", "extra", "Lorg/json/JSONObject;", "reason", "pause", "resume", "stop", "getCurPlayingStatus", "getCurPlayTime", "", "changePlaySpeed", "newPlaySpeed", "", "getCurPlaying", "Lkotlin/Pair;", "getCurrentAudioSteamData", "Lcom/larus/audioplayer/api/stream/AudioSteamData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioStreamPlayerServiceImpl implements IAudioSteamPlayerService {
    public AudioStreamPlayerServiceImpl() {
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final a f() {
        AudioStreamPlayer r0 = AudioStreamPlayer.a;
        return AudioStreamPlayer.d;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final Pair<String, String> h() {
        AudioStreamPlayer r0 = AudioStreamPlayer.a;
        return AudioStreamPlayer.c;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final long b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        AudioStreamPlayer r0 = AudioStreamPlayer.a;
        return AudioStreamPlayer.i(r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final String d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        AudioStreamPlayer r1 = AudioStreamPlayer.a;
        Intrinsics.checkNotNullParameter(r3, "uuid");
        return AudioStreamPlayer.h.getValue();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void g(DocFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) AudioStreamPlayer.b).remove(r2);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void i(DocFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) AudioStreamPlayer.b).add(r2);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        AudioStreamPlayer.a.B(r2, r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "reason");
        AudioStreamPlayer.a.u(r2, r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "reason");
        AudioStreamPlayer.a.s(r2, r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void k(String r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        AudioStreamPlayer r1 = AudioStreamPlayer.a;
        Intrinsics.checkNotNullParameter(r3, "uuid");
        if (r4 <= 2.0f) goto L6;
        r4 = 2.0f;
    L8:
        AudioStreamPlayer.D = r4;
        AudioStreamPlayer.x();
        FLogger.a.i("AudioStreamPlayer", "changePlaySpeed call uuid=" + r3 + " and speed=" + AudioStreamPlayer.D);
        return;
    L6:
        if (r4 >= 0.5f) goto L8;
        r4 = 0.5f;
        goto L8
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void c(String r13, String r14, String r15, String r16, String r17, String r19, int r110, String r20, JSONObject r21) {
        y78.a r7 = b.a;
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "title");
        Intrinsics.checkNotNullParameter(r15, "artist");
        Intrinsics.checkNotNullParameter(r17, "url");
        Intrinsics.checkNotNullParameter(r19, "uuid");
        Intrinsics.checkNotNullParameter(r20, "scene");
        Intrinsics.checkNotNullParameter(r21, "extra");
        Intrinsics.checkNotNullParameter("bridge_call", "reason");
        AudioStreamPlayer.a.y(r13, r14, r15, r16, r17, r19, r7, r110, r20, r21, "bridge_call");
    }
}
