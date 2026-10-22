package com.larus.voice_setting;

import com.larus.platform.service.o;
import com.larus.voice_setting.voice.base.g1;
import com.larus.voice_setting.voice.utils.f;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ouc.d0;
import p2a.a;
import p2a.d;
import v2a.b;
import v2a.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u0010\u001a\u00020\u0011*\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/voice_setting/VoiceSettingServiceImpl;", "Lcom/larus/voice_setting/INativeVoiceSettingService;", "<init>", "()V", "getCreateUgcVoiceUtils", "Lcom/larus/voice_setting/ICreateUgcVoiceUtils;", "getTtsVoiceTracer", "Lcom/larus/voice_setting/voice/base/TtsVoiceTracer;", "getMixTracer", "Lcom/larus/voice_setting/voice/mix/MixTracer;", "mobVoiceSettingsSchemeJumpStart", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.PARAMS_KEY, "Lkotlinx/serialization/json/JsonObject;", "mobVoiceSettingsSchemeJumpEnd", "mobVoiceSettingsChangeEnd", "toJSONObject", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceSettingServiceImpl implements INativeVoiceSettingService {
    public VoiceSettingServiceImpl() {
    }

    public final d a3() {
        return g1.a;
    }

    public final b f7() {
        return g.a;
    }

    public final a l2() {
        return f.a;
    }

    public final void G(d0 r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        int r1 = y2a.a.a;
        JSONObject r2 = new JSONObject(r4.toString());
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        com.larus.platform.service.g.a.monitorEventForSlardar("voice_settings_scheme_jump_start", r2, null, null);
        o.a.reportEvent("voice_settings_scheme_jump_start", r2);
    }

    public final void T0(d0 r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        int r1 = y2a.a.a;
        JSONObject r2 = new JSONObject(r4.toString());
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        com.larus.platform.service.g.a.monitorEventForSlardar("voice_settings_change_end", r2, null, null);
        o.a.reportEvent("voice_settings_change_end", r2);
    }

    public final void X2(d0 r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        int r1 = y2a.a.a;
        JSONObject r2 = new JSONObject(r4.toString());
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        com.larus.platform.service.g.a.monitorEventForSlardar("voice_settings_scheme_jump_end", r2, null, null);
        o.a.reportEvent("voice_settings_scheme_jump_end", r2);
    }
}
