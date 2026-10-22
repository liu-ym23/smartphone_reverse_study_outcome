package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.util.RomUtils;

/* JADX INFO: loaded from: classes.dex */
final class OaidFactory {
    OaidFactory() {
    }

    static OaidApi createOaidImpl(Context r10) {
        if (Build.BRAND.equals("Pico") == false) goto L7;
        return new PicoOaidImpl();
    L7:
        if (RomUtils.isColorOS() == false) goto L11;
        return new OnePlusOaidImpl(new XiaomiOppoImpl());
    L11:
        if (RomUtils.isXiaomi() == false) goto L15;
        if (XiaomiOppoImpl.isSupport() == false) goto L15;
    L17:
        return new XiaomiOppoImpl();
    L15:
        if (RomUtils.isBlackShark() == true) goto L17;
        if (OaidVivoImpl.isSupport() == false) goto L23;
        return new OaidVivoImpl(r10);
    L23:
        if (RomUtils.isHuawei() == true) goto L67;
        if (RomUtils.isHonorDevice() == true) goto L67;
        if (RomUtils.isOnePlus() == false) goto L32;
        return new OnePlusOaidImpl();
    L32:
        if (RomUtils.isMeizu() == false) goto L36;
        return new MeizuOaidImpl();
    L36:
        if (Build.VERSION.SDK_INT <= 28) goto L59;
        if (RomUtils.isSamsung() == false) goto L42;
        return new SamsungOaidImpl();
    L42:
        if (RomUtils.isNubia() == false) goto L46;
        return new NubiaOaidImpl();
    L46:
        if (RomUtils.isLenovo() == false) goto L50;
        return new LenovoOaidImpl();
    L50:
        if (RomUtils.isASUS() == true) goto L52;
        CoolpadOaidImpl r11 = new CoolpadOaidImpl(r10);
        if (r11.support(r10) == false) goto L57;
        return r11;
    L57:
        return new CommonOaidImpl();
    L52:
        return new ASUSOaidImpl();
    L59:
        if (RomUtils.isMiui() == false) goto L61;
        return null;
    L61:
        if (HWOaidImpl.isSupport(r10) == true) goto L63;
        return null;
    L63:
        return new HWOaidImpl();
    L67:
        return new HWOaidImpl();
    }
}
