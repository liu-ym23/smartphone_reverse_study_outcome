package com.bytedance.ies.xelement.viewpager.foldview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxFoldViewNG$$PropsSetter extends BaseLynxFoldView$$PropsSetter {
    public LynxFoldViewNG$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.viewpager.foldview.BaseLynxFoldView$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxFoldViewNG r5 = (LynxFoldViewNG) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -2081198901: goto L34;
            case -1056707280: goto L30;
            case -295277545: goto L26;
            case -183516802: goto L22;
            case 898500533: goto L18;
            case 1619605242: goto L14;
            case 1719615942: goto L10;
            case 2038700809: goto L6;
            default: goto L37;
        };
    L37:
        switch(r13) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            default: goto L38;
        };
    L38:
        super.a(r10, r11, r12);
        return;
    L40:
        r5.setNestedScrollAsChild(r12.e(r11, false));
        return;
    L42:
        r5.setAndroidHeaderTapSlop(r12.c(r11, 0));
        return;
    L44:
        r5.setTabMovableEnable(r12.e(r11, true));
        return;
    L46:
        r5.setAndroidHeaderOverSlot(r12.e(r11, false));
        return;
    L48:
        r5.setHeaderScrollViewEnable(r12.e(r11, false));
        return;
    L50:
        r5.setUnifiedHeaderOverSlot(r12.e(r11, false));
        return;
    L52:
        r5.setToolbarInteractionEnable(r12.e(r11, true));
        return;
    L54:
        r5.setEnableTouchStopFling(r12.e(r11, true));
        return;
    L6:
        if (r11.equals("android-nested-scroll-as-child") == false) goto L37;
        r13 = 7;
        goto L37
    L10:
        if (r11.equals("android-header-tap-slop") == false) goto L37;
        r13 = 6;
        goto L37
    L14:
        if (r11.equals("tab-movable-enable") == false) goto L37;
        r13 = 5;
        goto L37
    L18:
        if (r11.equals("android-header-over-slot") == false) goto L37;
        r13 = 4;
        goto L37
    L22:
        if (r11.equals("header-scrollview-enable") == false) goto L37;
        r13 = 3;
        goto L37
    L26:
        if (r11.equals("header-over-slot") == false) goto L37;
        r13 = 2;
        goto L37
    L30:
        if (r11.equals("toolbar-interaction-enable") == false) goto L37;
        r13 = 1;
        goto L37
    L34:
        if (r11.equals("android-enable-touch-stop-fling") == false) goto L37;
        r13 = 0;
        goto L37
    }
}
