package com.larus.voicecall.impl;

import com.bytedance.keva.Keva;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006\u001d"}, d2 = {"Lcom/larus/voicecall/impl/RealtimeCallConfigProvider;", "Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "<init>", "()V", "isMainBotType", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "isRtcEnable", "isRtcNewConnEnable", "isSupportScene", "subtitleUseCC", "enableAudioBgSimpleColor", "enableRealtimeCallTakePhoto", "isMainBot", "isVideoEnable", "isScreenShareEnable", "enableRecord", "isAutoInterrupt", "useNewTitleBarUI", "useDoubleLineCallUI", "showThinkingStatus", "audioAnimRenderFps", "isTakePhotoEnable", "isRealtimeDowngradeEnable", "useSpringSceneIcon", "isInScene", "trafficDegradationCallDisableCn", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallConfigProvider implements IRealtimeCallConfigDependency {
    public RealtimeCallConfigProvider() {
    }

    public final int d() {
        RealtimeCallUtil.a.getClass();
        return ((Number) RealtimeCallUtil.h0.getValue()).intValue();
    }

    public final boolean e() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.E();
    }

    public final boolean enableAudioBgSimpleColor() {
        return z2.a.enableAudioBgSimpleColor();
    }

    public final boolean enableRecord() {
        return z2.a.M3().getEnableRecord();
    }

    public final boolean f() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.v;
    }

    public final boolean g() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.B();
    }

    public final boolean h() {
        Keva r0 = RealtimeCallDegradeManager.a;
        return !RealtimeCallDegradeManager.j("image_query", "shot_button", true);
    }

    public final boolean i() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.A();
    }

    public final boolean j() {
        return z2.a.getRealtimeCallNewStyleConfig().d();
    }

    public final String k() {
        FlowDowngradeToastConfig r0 = z2.a.getFlowDowngradeToastConfig();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTrafficDegradationCallDisableCn();
    }

    public final boolean m() {
        return z2.a.getRealtimeCallNewStyleConfig().b();
    }

    public final boolean n() {
        RealtimeCallUtil.a.getClass();
        return ((Boolean) RealtimeCallUtil.U.getValue()).booleanValue();
    }

    public final boolean o() {
        return Intrinsics.areEqual(z2.a.realtimeCallSceneConfig().getUseSpringSceneIcon(), Boolean.TRUE);
    }

    public final boolean p() {
        return z2.a.realtimeCallUseTwoLineStyle();
    }

    public final boolean q() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.D();
    }

    public final boolean r() {
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean s() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.M();
    }

    public final boolean l(boolean r2) {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.e(r2);
    }
}
