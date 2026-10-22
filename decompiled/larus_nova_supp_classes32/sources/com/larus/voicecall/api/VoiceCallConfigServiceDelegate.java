package com.larus.voicecall.api;

import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import lq9.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0017\u001a\u00020\tH\u0096\u0001J\t\u0010\u0018\u001a\u00020\tH\u0096\u0001R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/voicecall/api/VoiceCallConfigServiceDelegate;", "Lcom/larus/voicecall/api/IVoiceCallConfigService;", "<init>", "()V", "buildConnectionConfig", "Lcom/larus/voicecall/api/bean/PreConnectConfig;", "callHelloTechType", NameKeys.UnloadStrategy_No_Strategy, "closeRealtimeDenoiseSwitch", NameKeys.UnloadStrategy_No_Strategy, "enableInitTaskVEPreload", NameKeys.UnloadStrategy_No_Strategy, "enableSubtitleAsrSeg", "getRealtimeCallPreloadConfig", "Lcom/larus/platform/model/audio/RealtimeCallPreloadConfig;", "isAutoInterrupt", "isCurSceneNull", "isDenoiseABEnable", "isDialogEntranceEnable", "isInCall", "isNewCallIconEnable", "isPlayingHello", "isVideoEnable", "preGetMmtAccess", "preloadMmtTransport", "curCallId", "getCurCallId", "()Ljava/lang/String;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallConfigServiceDelegate implements IVoiceCallConfigService {
    public static final VoiceCallConfigServiceDelegate b = null;
    public final /* synthetic */ IVoiceCallConfigService a;

    static {
        b = new VoiceCallConfigServiceDelegate();
    }

    public final String a() {
        return this.a.a();
    }

    public final boolean b() {
        return this.a.b();
    }

    public final boolean c() {
        return this.a.c();
    }

    public final void d() {
        this.a.d();
    }

    public final boolean e() {
        return this.a.e();
    }

    public final boolean f() {
        return this.a.f();
    }

    public final boolean g() {
        return this.a.g();
    }

    public final x getRealtimeCallPreloadConfig() {
        return this.a.getRealtimeCallPreloadConfig();
    }

    public final void h() {
        this.a.h();
    }

    public final boolean i() {
        return this.a.i();
    }

    public final String j() {
        return this.a.j();
    }

    public final boolean k() {
        return this.a.k();
    }

    public final boolean l() {
        return this.a.l();
    }

    public final void m() {
        this.a.m();
    }

    public final boolean n() {
        return this.a.n();
    }

    private VoiceCallConfigServiceDelegate() {
        IVoiceCallConfigService r0 = (IVoiceCallConfigService) ServiceManager.get().getService(IVoiceCallConfigService.class);
        if (r0 != null) goto L5;
        r0 = new VoiceCallConfigServiceNoop();
    L5:
        this.a = r0;
    }
}
