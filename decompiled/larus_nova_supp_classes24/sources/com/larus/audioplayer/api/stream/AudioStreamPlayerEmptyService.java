package com.larus.audioplayer.api.stream;

import c88.a;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.doc.impl.DocFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Jd\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016¨\u0006&"}, d2 = {"Lcom/larus/audioplayer/api/stream/AudioStreamPlayerEmptyService;", "Lcom/larus/audioplayer/api/stream/IAudioSteamPlayerService;", "<init>", "()V", "addInterceptor", "", "interceptor", "Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor;", "removeInterceptor", "start", "appletId", "", "title", "artist", "coverUrl", "url", "uuid", "listener", "Lcom/larus/audioplayer/api/IOnStreamPlayerStatesChangeListener;", "inputTimeOff", "", "scene", "extra", "Lorg/json/JSONObject;", "reason", "pause", "resume", "stop", "getCurPlayingStatus", "getCurPlayTime", "", "changePlaySpeed", "newPlaySpeed", "", "getCurPlaying", "Lkotlin/Pair;", "getCurrentAudioSteamData", "Lcom/larus/audioplayer/api/stream/AudioSteamData;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioStreamPlayerEmptyService implements IAudioSteamPlayerService {
    public static final AudioStreamPlayerEmptyService a = null;

    static {
        a = new AudioStreamPlayerEmptyService();
    }

    private AudioStreamPlayerEmptyService() {
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final long b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        return 0;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void c(String r1, String r2, String r3, String r4, String r5, String r6, int r7, String r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r1, "appletId");
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "artist");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "uuid");
        Intrinsics.checkNotNullParameter(r8, "scene");
        Intrinsics.checkNotNullParameter(r9, "extra");
        Intrinsics.checkNotNullParameter("bridge_call", "reason");
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        return "";
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "reason");
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final a f() {
        return null;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void g(DocFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final Pair<String, String> h() {
        return null;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void i(DocFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "reason");
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void k(String r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "uuid");
    }
}
