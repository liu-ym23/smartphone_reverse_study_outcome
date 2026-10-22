package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final Map<String, String> a;
    public final Map<String, String> b;
    public final List<String> c;
    public final int d;
    public final LiveEffectContextFactoryDelegate$Type e;

    public static final class a {
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.e;
    }

    public c(LiveEffectContextFactoryDelegate$Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.e = r3;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        this.c = new ArrayList();
        SettingKey<com.bytedance.android.live.effect.beauty.smallitem.a> r4 = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG;
        r4.getValue().getClass();
        this.d = r4.getValue().c();
        r4.getValue().getClass();
    }
}
