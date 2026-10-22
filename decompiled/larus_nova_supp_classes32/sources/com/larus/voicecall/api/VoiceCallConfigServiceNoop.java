package com.larus.voicecall.api;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import lq9.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/larus/voicecall/api/VoiceCallConfigServiceNoop;", "Lcom/larus/voicecall/api/IVoiceCallConfigService;", "<init>", "()V", "curCallId", NameKeys.UnloadStrategy_No_Strategy, "getCurCallId", "()Ljava/lang/String;", "isAutoInterrupt", NameKeys.UnloadStrategy_No_Strategy, "isVideoEnable", "enableInitTaskVEPreload", "preGetMmtAccess", NameKeys.UnloadStrategy_No_Strategy, "preloadMmtTransport", "isNewCallIconEnable", "isInCall", "isPlayingHello", "isCurSceneNull", "callHelloTechType", "isDialogEntranceEnable", "buildConnectionConfig", "Lcom/larus/voicecall/api/bean/PreConnectConfig;", "enableSubtitleAsrSeg", "closeRealtimeDenoiseSwitch", "isDenoiseABEnable", "getRealtimeCallPreloadConfig", "Lcom/larus/platform/model/audio/RealtimeCallPreloadConfig;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallConfigServiceNoop implements IVoiceCallConfigService {
    public VoiceCallConfigServiceNoop() {
    }

    public final String a() {
        return null;
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final void d() {
    }

    public final boolean e() {
        return false;
    }

    public final boolean f() {
        return false;
    }

    public final boolean g() {
        return true;
    }

    public final void h() {
    }

    public final boolean i() {
        return false;
    }

    public final String j() {
        return null;
    }

    public final boolean k() {
        return false;
    }

    public final boolean l() {
        return false;
    }

    public final void m() {
    }

    public final boolean n() {
        return false;
    }

    public final x getRealtimeCallPreloadConfig() {
        return new x(null);
    }
}
