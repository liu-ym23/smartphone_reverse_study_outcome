package com.lynx.tasm.behavior.ui.list;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIList$$PropsSetter extends AbsLynxList$$PropsSetter {
    public UIList$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        UIList r0 = (UIList) r6;
        r7.getClass();
        switch(r7.hashCode()) {
            case -1836837422: goto L110;
            case -1775291141: goto L106;
            case -1751296064: goto L102;
            case -1498894801: goto L98;
            case -1471202561: goto L94;
            case -1305579111: goto L90;
            case -1232185977: goto L86;
            case -1200045995: goto L82;
            case -1042889767: goto L78;
            case -1035189822: goto L74;
            case -942713210: goto L70;
            case -529325351: goto L66;
            case -505938823: goto L62;
            case 616977828: goto L58;
            case 626658734: goto L54;
            case 821895493: goto L50;
            case 1458283840: goto L46;
            case 1598314955: goto L42;
            case 1636003801: goto L38;
            case 1683042429: goto L34;
            case 1702184795: goto L30;
            case 1816872768: goto L26;
            case 1836550134: goto L22;
            case 1839496169: goto L18;
            case 1852315393: goto L14;
            case 1892080416: goto L10;
            case 2083253753: goto L6;
            default: goto L4;
        };
    L4:
        byte r1 = -1;
    L113:
        switch(r1) {
            case 0: goto L168;
            case 1: goto L166;
            case 2: goto L164;
            case 3: goto L162;
            case 4: goto L160;
            case 5: goto L158;
            case 6: goto L156;
            case 7: goto L154;
            case 8: goto L152;
            case 9: goto L150;
            case 10: goto L148;
            case 11: goto L146;
            case 12: goto L144;
            case 13: goto L142;
            case 14: goto L140;
            case 15: goto L138;
            case 16: goto L136;
            case 17: goto L134;
            case 18: goto L132;
            case 19: goto L130;
            case 20: goto L128;
            case 21: goto L126;
            case 22: goto L124;
            case 23: goto L122;
            case 24: goto L120;
            case 25: goto L118;
            case 26: goto L116;
            default: goto L114;
        };
    L114:
        super.setProperty(r6, r7, r8);
        return;
    L116:
        r0.setVerticalOrientation(r8.b(r7, true));
        return;
    L118:
        r0.enableRtl(r8.b(r7, false));
        return;
    L120:
        r0.setItemHolderType(r8.d(r7));
        return;
    L122:
        r0.setEnableFocusSearch(r8.b(r7, true));
        return;
    L124:
        r0.setAndroidIgnoreAttachForBinding(r8.b(r7, false));
        return;
    L126:
        r0.setAutoMeasure(r8.d(r7));
        return;
    L128:
        r0.setTriggerStickyLayout(r8.b(r7, false));
        return;
    L130:
        r0.setDiffable(r8.d(r7));
        return;
    L132:
        r0.setEnableDisappear(r8.b(r7, false));
        return;
    L134:
        r0.setUpperLowerSwitch(r8.b(r7, false));
        return;
    L136:
        r0.setEnableSizeCache(r8.b(r7, false));
        return;
    L138:
        r0.setEnableItemPrefetch(r8.b(r7, true));
        return;
    L140:
        r0.setEnableOverflow(r8.b(r7, false));
        return;
    L142:
        r0.setPreferenceConsumeGesture(r8.b(r7, false));
        return;
    L144:
        r0.updateListActionInfo(r8.g(r7));
        return;
    L146:
        r0.setListPlatformInfo(r8.g(r7));
        return;
    L148:
        r0.setPreloadBufferCount(r8.d(r7));
        return;
    L150:
        r0.setNewAppear(r8.b(r7, false));
        return;
    L152:
        r0.setEnableAsyncList(r8.b(r7, false));
        return;
    L154:
        r0.setListOldStickySwitch(r8.b(r7, true));
        return;
    L156:
        r0.setEnableGapItemDecoration(r8.b(r7, false));
        return;
    L158:
        r0.enableNestedScroll(r8.b(r7, true));
        return;
    L160:
        r0.setEnableStrictScrollable(r8.b(r7, false));
        return;
    L162:
        r0.setMaxFlingVelocityPercent(r8.e(r7, 0.0f));
        return;
    L164:
        r0.setListNewScrollTopSwitch(r8.b(r7, false));
        return;
    L166:
        r0.setStackFromEnd(r8.b(r7, false));
        return;
    L168:
        r0.setScrollIndex(r8.f(r7, -1));
        return;
    L6:
        if (r7.equals("vertical-orientation") == false) goto L4;
        r1 = 26;
        goto L113
    L10:
        if (r7.equals("enable-rtl") == false) goto L4;
        r1 = 25;
        goto L113
    L14:
        if (r7.equals("item-holder-type") == false) goto L4;
        r1 = 24;
        goto L113
    L18:
        if (r7.equals("android-enable-focus-search") == false) goto L4;
        r1 = 23;
        goto L113
    L22:
        if (r7.equals("android-ignore-attach-for-binding") == false) goto L4;
        r1 = 22;
        goto L113
    L26:
        if (r7.equals("auto-measure") == false) goto L4;
        r1 = 21;
        goto L113
    L30:
        if (r7.equals("android-trigger-sticky-layout") == false) goto L4;
        r1 = 20;
        goto L113
    L34:
        if (r7.equals("android-diffable") == false) goto L4;
        r1 = 19;
        goto L113
    L38:
        if (r7.equals("enable-disappear") == false) goto L4;
        r1 = 18;
        goto L113
    L42:
        if (r7.equals("scroll-upper-lower-switch") == false) goto L4;
        r1 = 17;
        goto L113
    L46:
        if (r7.equals("enable-size-cache") == false) goto L4;
        r1 = 16;
        goto L113
    L50:
        if (r7.equals("android-enable-item-prefetch") == false) goto L4;
        r1 = 15;
        goto L113
    L54:
        if (r7.equals("android-enable-overflow") == false) goto L4;
        r1 = 14;
        goto L113
    L58:
        if (r7.equals("android-preference-consume-gesture") == false) goto L4;
        r1 = 13;
        goto L113
    L62:
        if (r7.equals("update-list-info") == false) goto L4;
        r1 = 12;
        goto L113
    L66:
        if (r7.equals("list-platform-info") == false) goto L4;
        r1 = 11;
        goto L113
    L70:
        if (r7.equals("preload-buffer-count") == false) goto L4;
        r1 = 10;
        goto L113
    L74:
        if (r7.equals("enable-new-exposure-strategy") == false) goto L4;
        r1 = 9;
        goto L113
    L78:
        if (r7.equals("enable-async-list") == false) goto L4;
        r1 = 8;
        goto L113
    L82:
        if (r7.equals("use-old-sticky") == false) goto L4;
        r1 = 7;
        goto L113
    L86:
        if (r7.equals("android-enable-gap-item-decoration") == false) goto L4;
        r1 = 6;
        goto L113
    L90:
        if (r7.equals("enable-nested-scroll") == false) goto L4;
        r1 = 5;
        goto L113
    L94:
        if (r7.equals("android-enable-strict-scrollable") == false) goto L4;
        r1 = 4;
        goto L113
    L98:
        if (r7.equals("max-fling-velocity-percent") == false) goto L4;
        r1 = 3;
        goto L113
    L102:
        if (r7.equals("android-new-scroll-top") == false) goto L4;
        r1 = 2;
        goto L113
    L106:
        if (r7.equals("android-stack-from-end") == false) goto L4;
        r1 = 1;
        goto L113
    L110:
        if (r7.equals("scroll-index") == false) goto L4;
        r1 = 0;
        goto L113
    }
}
