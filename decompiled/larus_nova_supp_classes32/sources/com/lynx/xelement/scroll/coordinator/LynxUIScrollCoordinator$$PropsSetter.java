package com.lynx.xelement.scroll.coordinator;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIScrollCoordinator$$PropsSetter extends BaseScrollCoordinator$$PropsSetter {
    public LynxUIScrollCoordinator$$PropsSetter() {
    }

    @Override // com.lynx.xelement.scroll.coordinator.BaseScrollCoordinator$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        LynxUIScrollCoordinator r0 = (LynxUIScrollCoordinator) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -2081198901: goto L38;
            case -1056707280: goto L34;
            case -295277545: goto L30;
            case -183516802: goto L26;
            case 898500533: goto L22;
            case 1051176707: goto L18;
            case 1619605242: goto L14;
            case 1719615942: goto L10;
            case 2038700809: goto L6;
            default: goto L41;
        };
    L41:
        switch(r4) {
            case 0: goto L60;
            case 1: goto L58;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L46;
            case 8: goto L44;
            default: goto L42;
        };
    L42:
        super.setProperty(r6, r7, r8);
        return;
    L44:
        r0.setNestedScrollAsChild(r8.b(r7, false));
        return;
    L46:
        r0.setAndroidHeaderTapSlop(r8.f(r7, 0));
        return;
    L48:
        r0.setTabMovableEnable(r8.b(r7, true));
        return;
    L50:
        r0.setHeaderSlotOverflowHitTest(r8.b(r7, true));
        return;
    L52:
        r0.setAndroidHeaderOverSlot(r8.b(r7, false));
        return;
    L54:
        r0.setHeaderScrollViewEnable(r8.b(r7, false));
        return;
    L56:
        r0.setHeaderOverSlot(r8.b(r7, false));
        return;
    L58:
        r0.setToolbarInteractionEnable(r8.b(r7, true));
        return;
    L60:
        r0.setEnableTouchStopFling(r8.b(r7, true));
        return;
    L6:
        if (r7.equals("android-nested-scroll-as-child") == false) goto L41;
        r4 = 8;
        goto L41
    L10:
        if (r7.equals("android-header-tap-slop") == false) goto L41;
        r4 = 7;
        goto L41
    L14:
        if (r7.equals("tab-movable-enable") == false) goto L41;
        r4 = 6;
        goto L41
    L18:
        if (r7.equals("experimental-header-slot-overflow-hit-test") == false) goto L41;
        r4 = 5;
        goto L41
    L22:
        if (r7.equals("android-header-over-slot") == false) goto L41;
        r4 = 4;
        goto L41
    L26:
        if (r7.equals("header-scrollview-enable") == false) goto L41;
        r4 = 3;
        goto L41
    L30:
        if (r7.equals("header-over-slot") == false) goto L41;
        r4 = 2;
        goto L41
    L34:
        if (r7.equals("toolbar-interaction-enable") == false) goto L41;
        r4 = 1;
        goto L41
    L38:
        if (r7.equals("android-enable-touch-stop-fling") == false) goto L41;
        r4 = 0;
        goto L41
    }
}
