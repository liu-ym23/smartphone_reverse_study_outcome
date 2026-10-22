package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 {
    public final boolean a;

    public static final class a {
    }

    static {
    }

    public i0(boolean r1) {
        this.a = r1;
    }

    public final void a(JsonObject r3) {
        ALogger.i("RtcDynamicHandler", "handleCellularEnhancement: " + r3);
        if (r3 != null) goto L5;
        return;
    L5:
        JsonElement r0 = r3.get("enhance_signaling");
        if (r0 == null) goto L8;
        r0.getAsBoolean();
    L8:
        JsonElement r1 = r3.get("enhance_audio");
        if (r1 == null) goto L11;
        r1.getAsBoolean();
    L11:
        JsonElement r2 = r3.get("enhance_video");
        if (r2 == null) goto L14;
        r2.getAsBoolean();
    L14:
        JsonElement r4 = r3.get("enhance_screen_audio");
        if (r4 == null) goto L17;
        r4.getAsBoolean();
    L17:
        JsonElement r5 = r3.get("enhance_screen_video");
        if (r5 == null) goto L20;
        r5.getAsBoolean();
    L20:
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L23;
        ei6.a r7 = r6.getRtcClient(Boolean.valueOf(this.a));
    L24:
        if (r7 == null) goto L29;
        si6.b r8 = r7.b();
        if (r8 == null) goto L30;
        dg2.d r9 = new dg2.d();
        Unit r10 = Unit.INSTANCE;
        r8.l(r9);
        return;
    L30:
        return;
    L29:
        return;
    L23:
        r7 = null;
        goto L24
    }

    public final void b(JsonObject r4) {
        ALogger.i("RtcDynamicHandler", "handleRtcMethod: " + r4);
        if (r4 != null) goto L5;
        return;
    L5:
        JsonElement r0 = r4.get("method");
        String r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getAsString();
    L10:
        if (Intrinsics.areEqual(r2, "set_biz_extra_info") == false) goto L27;
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L14;
        ei6.a r5 = r3.getRtcClient(Boolean.valueOf(this.a));
    L15:
        JsonElement r6 = r4.get("params");
        if (r6 == null) goto L22;
        JsonObject r7 = r6.getAsJsonObject();
        if (r7 == null) goto L22;
        JsonElement r8 = r7.get("rtc_scene_tag");
        if (r8 == null) goto L22;
        r1 = r8.getAsString();
    L22:
        if (r5 == null) goto L28;
        si6.b r9 = r5.b();
        if (r9 == null) goto L29;
        r9.s(r1);
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r5 = null;
        goto L15
    L27:
        return;
    L8:
        r2 = null;
        goto L10
    }
}
