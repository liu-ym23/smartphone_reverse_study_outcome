package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static Disposable a;

    public static void b() {
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        Disposable r0 = a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isDisposed() == true) goto L12;
        r0.dispose();
        a = null;
        return;
    }

    static {
    }

    public static void a(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "eventPage");
        Intrinsics.checkNotNullParameter(r4, "modelName");
        Intrinsics.checkNotNullParameter(r5, "modelId");
        Intrinsics.checkNotNullParameter(r6, "actionType");
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        r0.put("model_name", r4);
        r0.put("model_id", r5);
        r0.put("action_type", r6);
        c.a("livesdk_beauty_model_popup_window_click", r0, r3);
    }
}
