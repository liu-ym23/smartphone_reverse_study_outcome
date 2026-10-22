package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.RomUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class OaidFactory {
    OaidFactory() {
    }

    static OaidApi createOaidImpl(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
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
        return new OaidVivoImpl(r3);
    L23:
        if (RomUtils.isHonorDevice() == false) goto L29;
        if (RomUtils.hasHWVersion() == false) goto L29;
        DrLog.d("honor# old honor oaid");
        return new HWOaidImpl();
    L29:
        if (RomUtils.isHonorDevice() == false) goto L35;
        if (RomUtils.hasHWVersion() == true) goto L35;
        DrLog.d("honor# new honor oaid");
        return new HonorOaidImpl();
    L35:
        if (RomUtils.isHuawei() == false) goto L39;
        return new HWOaidImpl();
    L39:
        if (RomUtils.isOnePlus() == false) goto L43;
        return new OnePlusOaidImpl();
    L43:
        if (RomUtils.isMeizu() == false) goto L47;
        return new MeizuOaidImpl();
    L47:
        if (Build.VERSION.SDK_INT <= 28) goto L70;
        if (RomUtils.isSamsung() == false) goto L53;
        return new SamsungOaidImpl();
    L53:
        if (RomUtils.isNubia() == false) goto L57;
        return new NubiaOaidImpl();
    L57:
        if (RomUtils.isLenovo() == false) goto L61;
        return new LenovoOaidImpl();
    L61:
        if (RomUtils.isASUS() == true) goto L63;
        CoolpadOaidImpl r0 = new CoolpadOaidImpl(r3);
        if (r0.support(r3) == false) goto L68;
        return r0;
    L68:
        return new CommonOaidImpl();
    L63:
        return new ASUSOaidImpl();
    L70:
        if (RomUtils.isMiui() == false) goto L72;
        return null;
    L72:
        if (HWOaidImpl.isSupport(r3) == true) goto L74;
        return null;
    L74:
        return new HWOaidImpl();
    }
}
