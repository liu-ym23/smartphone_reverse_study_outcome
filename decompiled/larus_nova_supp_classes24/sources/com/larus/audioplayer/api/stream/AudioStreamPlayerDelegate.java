package com.larus.audioplayer.api.stream;

import c88.a;
import com.bytedance.applet.utils.b;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.doc.impl.DocFragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001Je\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001J\u001b\u0010%\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001¨\u0006&"}, d2 = {"Lcom/larus/audioplayer/api/stream/AudioStreamPlayerDelegate;", "Lcom/larus/audioplayer/api/stream/IAudioSteamPlayerService;", "<init>", "()V", "addInterceptor", "", "interceptor", "Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor;", "changePlaySpeed", "uuid", "", "newPlaySpeed", "", "getCurPlayTime", "", "getCurPlaying", "Lkotlin/Pair;", "getCurPlayingStatus", "getCurrentAudioSteamData", "Lcom/larus/audioplayer/api/stream/AudioSteamData;", "pause", "reason", "removeInterceptor", "resume", "start", "appletId", "title", "artist", "coverUrl", "url", "listener", "Lcom/larus/audioplayer/api/IOnStreamPlayerStatesChangeListener;", "inputTimeOff", "", "scene", "extra", "Lorg/json/JSONObject;", "stop", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioStreamPlayerDelegate implements IAudioSteamPlayerService {
    public static final AudioStreamPlayerDelegate b = null;
    public final /* synthetic */ IAudioSteamPlayerService a;

    static {
        b = new AudioStreamPlayerDelegate();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a.a(r2, r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final long b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uuid");
        return this.a.b(r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        return this.a.d(r2);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a.e(r2, r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final a f() {
        return this.a.f();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void g(DocFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.a.g(r2);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final Pair<String, String> h() {
        return this.a.h();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void i(DocFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.a.i(r2);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a.j(r2, r3);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void k(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        this.a.k(r2, r3);
    }

    private AudioStreamPlayerDelegate() {
        IAudioSteamPlayerService r0 = (IAudioSteamPlayerService) ServiceManager.get().getService(IAudioSteamPlayerService.class);
        if (r0 != null) goto L5;
        r0 = AudioStreamPlayerEmptyService.a;
    L5:
        this.a = r0;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void c(String r12, String r13, String r14, String r15, String r16, String r17, int r19, String r110, JSONObject r20) {
        b r0 = b.a;
        Intrinsics.checkNotNullParameter(r12, "appletId");
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r14, "artist");
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r17, "uuid");
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r20, "extra");
        Intrinsics.checkNotNullParameter("bridge_call", "reason");
        this.a.c(r12, r13, r14, r15, r16, r17, r19, r110, r20);
    }
}
