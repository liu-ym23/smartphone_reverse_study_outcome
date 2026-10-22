package com.bytedance.ies.xelement.overlay;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxOverlayView$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxOverlayView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxOverlayView r12 = (LynxOverlayView) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1987814405: goto L50;
            case -1952821320: goto L46;
            case -1389050563: goto L42;
            case -939362323: goto L38;
            case -865043584: goto L34;
            case -243354428: goto L30;
            case 272778088: goto L26;
            case 466743410: goto L22;
            case 1011660130: goto L18;
            case 1330942754: goto L14;
            case 1860950378: goto L10;
            case 2013950716: goto L6;
            default: goto L53;
        };
    L53:
        switch(r13) {
            case 0: goto L82;
            case 1: goto L80;
            case 2: goto L78;
            case 3: goto L76;
            case 4: goto L74;
            case 5: goto L72;
            case 6: goto L70;
            case 7: goto L68;
            case 8: goto L63;
            case 9: goto L60;
            case 10: goto L58;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        super.a(r5, r10, r11);
        return;
    L56:
        r12.setNativeEventPass(r11.e(r10, false));
        return;
    L58:
        r12.setFullScreen(r11.e(r10, false));
        return;
    L60:
        r12.setEnableAccessibility(r11.e(r10, false));
        return;
    L68:
        r12.setVisible(r11.f10815a.getDynamic(r10));
        return;
    L70:
        r12.setStatusBarTranslucentStyle(r11.f10815a.getString(r10));
        return;
    L72:
        r12.setStatusBarTranslucent(r11.f10815a.getDynamic(r10));
        return;
    L74:
        r12.setAndroidSetSoftInputMode(r11.f10815a.getString(r10));
        return;
    L76:
        r12.setCutOutMode(r11.e(r10, false));
        return;
    L78:
        r12.setEventsPassThrough(r11.f10815a.getDynamic(r10));
        return;
    L80:
        r12.setOverlayId(r11.f10815a.getString(r10));
        return;
    L82:
        r12.setAlwaysShow(r11.e(r10, false));
        return;
    L63:
        if (r11.f10815a.isNull(r10) == false) goto L65;
        Boolean r14 = null;
    L66:
        r12.setShouldOffsetBoundingRect(r14);
        return;
    L65:
        r14 = Boolean.valueOf(r11.e(r10, false));
        goto L66
    L6:
        if (r10.equals("android-native-event-pass") == false) goto L53;
        r13 = 11;
        goto L53
    L10:
        if (r10.equals("full-screen") == false) goto L53;
        r13 = 10;
        goto L53
    L14:
        if (r10.equals("android-enable-accessibility") == false) goto L53;
        r13 = 9;
        goto L53
    L18:
        if (r10.equals("compat-bounding-rect") == false) goto L53;
        r13 = 8;
        goto L53
    L22:
        if (r10.equals("visible") == false) goto L53;
        r13 = 7;
        goto L53
    L26:
        if (r10.equals("status-bar-translucent-style") == false) goto L53;
        r13 = 6;
        goto L53
    L30:
        if (r10.equals("status-bar-translucent") == false) goto L53;
        r13 = 5;
        goto L53
    L34:
        if (r10.equals("android-set-soft-input-mode") == false) goto L53;
        r13 = 4;
        goto L53
    L38:
        if (r10.equals("cut-out-mode") == false) goto L53;
        r13 = 3;
        goto L53
    L42:
        if (r10.equals("events-pass-through") == false) goto L53;
        r13 = 2;
        goto L53
    L46:
        if (r10.equals("overlay-id") == false) goto L53;
        r13 = 1;
        goto L53
    L50:
        if (r10.equals("always-show") == false) goto L53;
        r13 = 0;
        goto L53
    }
}
