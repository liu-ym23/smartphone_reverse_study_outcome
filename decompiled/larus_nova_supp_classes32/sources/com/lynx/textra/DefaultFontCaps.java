package com.lynx.textra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class DefaultFontCaps implements PlatformFontCaps {
    public DefaultFontCaps() {
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r1) {
        return r1;
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r1) {
        return PlatformFontCaps.CC.$default$clamp(this, r1);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }
}
