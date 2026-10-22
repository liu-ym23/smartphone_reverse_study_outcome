package com.lynx.textra;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class HuaweiFontCaps implements PlatformFontCaps {
    private final Context mContext;

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r1) {
        return PlatformFontCaps.CC.$default$clamp(this, r1);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    public HuaweiFontCaps(Context r1) {
        this.mContext = r1;
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r4) {
        return clamp((int) (Settings.System.getFloat(this.mContext.getContentResolver(), "font_weight_scale", 1.0f) * r4));
    }
}
