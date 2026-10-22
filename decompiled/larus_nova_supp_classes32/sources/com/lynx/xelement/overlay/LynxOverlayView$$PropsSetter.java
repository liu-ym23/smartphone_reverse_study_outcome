package com.lynx.xelement.overlay;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxOverlayView$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxOverlayView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        LynxOverlayView r0 = (LynxOverlayView) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1987814405: goto L70;
            case -1648946227: goto L66;
            case -1389050563: goto L62;
            case -992853731: goto L58;
            case -939362323: goto L54;
            case -865043584: goto L50;
            case -572683161: goto L46;
            case -402853108: goto L42;
            case -243354428: goto L38;
            case 102865796: goto L34;
            case 272778088: goto L30;
            case 466743410: goto L26;
            case 487537320: goto L22;
            case 509801442: goto L18;
            case 1290012751: goto L14;
            case 1312625564: goto L10;
            case 2013950716: goto L6;
            default: goto L73;
        };
    L73:
        switch(r4) {
            case 0: goto L108;
            case 1: goto L106;
            case 2: goto L104;
            case 3: goto L102;
            case 4: goto L100;
            case 5: goto L98;
            case 6: goto L96;
            case 7: goto L94;
            case 8: goto L92;
            case 9: goto L90;
            case 10: goto L88;
            case 11: goto L86;
            case 12: goto L84;
            case 13: goto L82;
            case 14: goto L80;
            case 15: goto L78;
            case 16: goto L76;
            default: goto L74;
        };
    L74:
        super.setProperty(r6, r7, r8);
        return;
    L76:
        r0.setNativeEventPass(r8.b(r7, false));
        return;
    L78:
        r0.setAndroidNavigationBarStyle(r8.h(r7));
        return;
    L80:
        r0.setContainerPopupTag(r8.h(r7));
        return;
    L82:
        r0.setNestScroll(r8.h(r7));
        return;
    L84:
        r0.setAdaptEdgeToEdge(r8.b(r7, false));
        return;
    L86:
        r0.setVisible(r8.d(r7));
        return;
    L88:
        r0.setStatusBarTranslucentStyle(r8.h(r7));
        return;
    L90:
        r0.setLevel(r8.f(r7, 1));
        return;
    L92:
        r0.setStatusBarTranslucent(r8.d(r7));
        return;
    L94:
        r0.setFullScreen(r8.b(r7, false));
        return;
    L96:
        r0.hideNavBar(r8.b(r7, false));
        return;
    L98:
        r0.setAndroidSetSoftInputMode(r8.h(r7));
        return;
    L100:
        r0.setCutOutMode(r8.b(r7, false));
        return;
    L102:
        r0.setIgnoreFocus(r8.d(r7));
        return;
    L104:
        r0.setEventsPassThrough(r8.d(r7));
        return;
    L106:
        r0.setLazyInitContext(r8.b(r7, false));
        return;
    L108:
        r0.setAlwaysShow(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("android-native-event-pass") == false) goto L73;
        r4 = 16;
        goto L73
    L10:
        if (r7.equals(LynxUIOverlay.PROP_ANDROID_NAVIGATION_BAR_STYLE) == false) goto L73;
        r4 = 15;
        goto L73
    L14:
        if (r7.equals(LynxUIOverlay.PROP_CONTAINER_POPUP_TAG) == false) goto L73;
        r4 = 14;
        goto L73
    L18:
        if (r7.equals(LynxUIOverlay.PROP_NEST_SCROLL) == false) goto L73;
        r4 = 13;
        goto L73
    L22:
        if (r7.equals(LynxUIOverlay.PROP_ADAPT_EDGE_TO_EDGE) == false) goto L73;
        r4 = 12;
        goto L73
    L26:
        if (r7.equals(LynxUIOverlay.PROP_VISIBLE) == false) goto L73;
        r4 = 11;
        goto L73
    L30:
        if (r7.equals(LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE) == false) goto L73;
        r4 = 10;
        goto L73
    L34:
        if (r7.equals(LynxUIOverlay.PROP_LEVEL) == false) goto L73;
        r4 = 9;
        goto L73
    L38:
        if (r7.equals(LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT) == false) goto L73;
        r4 = 8;
        goto L73
    L42:
        if (r7.equals(LynxUIOverlay.PROP_FULL_SCREEN) == false) goto L73;
        r4 = 7;
        goto L73
    L46:
        if (r7.equals(LynxUIOverlay.PROP_ANDROID_HIDE_NAVIGATION_BAR) == false) goto L73;
        r4 = 6;
        goto L73
    L50:
        if (r7.equals("android-set-soft-input-mode") == false) goto L73;
        r4 = 5;
        goto L73
    L54:
        if (r7.equals(LynxUIOverlay.CUT_OUT_MODE) == false) goto L73;
        r4 = 4;
        goto L73
    L58:
        if (r7.equals("ignore-focus") == false) goto L73;
        r4 = 3;
        goto L73
    L62:
        if (r7.equals(LynxUIOverlay.PROP_EVENTS_PASS_THROUGH) == false) goto L73;
        r4 = 2;
        goto L73
    L66:
        if (r7.equals(LynxUIOverlay.PROP_ANDROID_LAZY_INIT_CONTEXT) == false) goto L73;
        r4 = 1;
        goto L73
    L70:
        if (r7.equals(LynxUIOverlay.PROP_ALWAYS_SHOW) == false) goto L73;
        r4 = 0;
        goto L73
    }
}
