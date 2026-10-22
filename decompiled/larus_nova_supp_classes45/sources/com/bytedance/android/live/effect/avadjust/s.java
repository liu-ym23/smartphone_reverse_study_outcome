package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, int r4, Sticker r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "eventPage");
        Intrinsics.checkNotNullParameter(r6, "actionType");
        if (r5 == null) goto L32;
        HashMap r0 = new HashMap();
        r0.put("event_page", r3);
        r0.put("tab_name", "adjust");
        String r1 = r5.getName();
        if (r1 == null) goto L7;
        String r2 = (String) r0.put("effect_name", r1);
    L7:
        r0.put("live_type", "video_live");
        r0.put("effect_id", r5.getEffectId());
        r0.put("effect_order", String.valueOf(r4));
        r0.put("action_type", r6);
        Sticker.ComposerConfig r7 = r5.getSmallItemConfig();
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.getDefaultValue());
    L11:
        r0.put("default_value", String.valueOf(r8));
        List<String> r9 = LiveEffectContext.h;
        ILiveEffectComposerManager r11 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a();
        String r12 = r5.getEffectId();
        String r13 = "";
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        Sticker.ComposerConfig r14 = r5.getSmallItemConfig();
        if (r14 == null) goto L20;
        String r15 = r14.getTag();
        if (r15 == null) goto L20;
        r13 = r15;
    L20:
        Float r16 = r11.G(r12, r13);
        if (r16 == null) goto L23;
        float r17 = r16.floatValue();
    L24:
        int r18 = com.bytedance.android.live.effect.q.b(r5, r17);
        r0.put("effect_value", String.valueOf(r18));
        Sticker.ComposerConfig r19 = r5.getSmallItemConfig();
        if (r19 != null) goto L27;
    L29:
        String r21 = "0";
    L30:
        r0.put("is_default_value", r21);
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_panel_item_select", r0, r3);
        return;
    L27:
        if (r18 != r19.getDefaultValue()) goto L29;
        r21 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L30
    L23:
        r17 = 0.0f;
        goto L24
    L10:
        r8 = null;
        goto L11
    }
}
