package com.lynx.textra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class VivoFontCaps implements PlatformFontCaps {
    public VivoFontCaps() {
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r1) {
        return PlatformFontCaps.CC.$default$clamp(this, r1);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r3) {
        int r0 = TTTextUtils.nativeGetSystemPropInt("persist.system.vivo.fontsize");
        if (r0 > 0) goto L6;
        r0 = 550;
    L6:
        return clamp((int) ((r0 / 550.0f) * r3));
    }
}
