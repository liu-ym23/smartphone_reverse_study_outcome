package com.lynx.tasm.behavior.ui.list;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIList$$PropsSetter extends AbsLynxList$$PropsSetter {
    public UIList$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.list.AbsLynxList$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        UIList r5 = (UIList) r10;
        r11.getClass();
        switch(r11.hashCode()) {
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
        byte r13 = -1;
    L113:
        switch(r13) {
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
        super.a(r10, r11, r12);
        return;
    L116:
        r5.setVerticalOrientation(r12.e(r11, true));
        return;
    L118:
        r5.enableRtl(r12.e(r11, false));
        return;
    L120:
        r5.setItemHolderType(r12.f10815a.getDynamic(r11));
        return;
    L122:
        r5.setEnableFocusSearch(r12.e(r11, true));
        return;
    L124:
        r5.setAndroidIgnoreAttachForBinding(r12.e(r11, false));
        return;
    L126:
        r5.setAutoMeasure(r12.f10815a.getDynamic(r11));
        return;
    L128:
        r5.setTriggerStickyLayout(r12.e(r11, false));
        return;
    L130:
        r5.setDiffable(r12.f10815a.getDynamic(r11));
        return;
    L132:
        r5.setEnableDisappear(r12.e(r11, false));
        return;
    L134:
        r5.setUpperLowerSwitch(r12.e(r11, false));
        return;
    L136:
        r5.setEnableSizeCache(r12.e(r11, false));
        return;
    L138:
        r5.setEnableItemPrefetch(r12.e(r11, true));
        return;
    L140:
        r5.setEnableOverflow(r12.e(r11, false));
        return;
    L142:
        r5.setPreferenceConsumeGesture(r12.e(r11, false));
        return;
    L144:
        r5.updateListActionInfo(r12.f10815a.getMap(r11));
        return;
    L146:
        r5.setListPlatformInfo(r12.f10815a.getMap(r11));
        return;
    L148:
        r5.setPreloadBufferCount(r12.f10815a.getDynamic(r11));
        return;
    L150:
        r5.setNewAppear(r12.e(r11, false));
        return;
    L152:
        r5.setEnableAsyncList(r12.e(r11, false));
        return;
    L154:
        r5.setListOldStickySwitch(r12.e(r11, true));
        return;
    L156:
        r5.setEnableGapItemDecoration(r12.e(r11, false));
        return;
    L158:
        r5.enableNestedScroll(r12.e(r11, true));
        return;
    L160:
        r5.setEnableStrictScrollable(r12.e(r11, false));
        return;
    L162:
        r5.setMaxFlingVelocityPercent(r12.b(0.0f, r11));
        return;
    L164:
        r5.setListNewScrollTopSwitch(r12.e(r11, false));
        return;
    L166:
        r5.setStackFromEnd(r12.e(r11, false));
        return;
    L168:
        r5.setScrollIndex(r12.c(r11, -1));
        return;
    L6:
        if (r11.equals("vertical-orientation") == false) goto L170;
        r13 = 26;
        goto L113
    L170:
        r13 = -1;
        goto L113
    L10:
        if (r11.equals("enable-rtl") == false) goto L171;
        r13 = 25;
        goto L113
    L171:
        r13 = -1;
        goto L113
    L14:
        if (r11.equals("item-holder-type") == false) goto L172;
        r13 = 24;
        goto L113
    L172:
        r13 = -1;
        goto L113
    L18:
        if (r11.equals("android-enable-focus-search") == false) goto L173;
        r13 = 23;
        goto L113
    L173:
        r13 = -1;
        goto L113
    L22:
        if (r11.equals("android-ignore-attach-for-binding") == false) goto L174;
        r13 = 22;
        goto L113
    L174:
        r13 = -1;
        goto L113
    L26:
        if (r11.equals("auto-measure") == false) goto L175;
        r13 = 21;
        goto L113
    L175:
        r13 = -1;
        goto L113
    L30:
        if (r11.equals("android-trigger-sticky-layout") == false) goto L176;
        r13 = 20;
        goto L113
    L176:
        r13 = -1;
        goto L113
    L34:
        if (r11.equals("android-diffable") == false) goto L177;
        r13 = 19;
        goto L113
    L177:
        r13 = -1;
        goto L113
    L38:
        if (r11.equals("enable-disappear") == false) goto L178;
        r13 = 18;
        goto L113
    L178:
        r13 = -1;
        goto L113
    L42:
        if (r11.equals("scroll-upper-lower-switch") == false) goto L179;
        r13 = 17;
        goto L113
    L179:
        r13 = -1;
        goto L113
    L46:
        if (r11.equals("enable-size-cache") == false) goto L180;
        r13 = 16;
        goto L113
    L180:
        r13 = -1;
        goto L113
    L50:
        if (r11.equals("android-enable-item-prefetch") == false) goto L181;
        r13 = 15;
        goto L113
    L181:
        r13 = -1;
        goto L113
    L54:
        if (r11.equals("android-enable-overflow") == false) goto L182;
        r13 = 14;
        goto L113
    L182:
        r13 = -1;
        goto L113
    L58:
        if (r11.equals("android-preference-consume-gesture") == false) goto L183;
        r13 = 13;
        goto L113
    L183:
        r13 = -1;
        goto L113
    L62:
        if (r11.equals("update-list-info") == false) goto L184;
        r13 = 12;
        goto L113
    L184:
        r13 = -1;
        goto L113
    L66:
        if (r11.equals("list-platform-info") == false) goto L185;
        r13 = 11;
        goto L113
    L185:
        r13 = -1;
        goto L113
    L70:
        if (r11.equals("preload-buffer-count") == false) goto L186;
        r13 = 10;
        goto L113
    L186:
        r13 = -1;
        goto L113
    L74:
        if (r11.equals("enable-new-exposure-strategy") == false) goto L187;
        r13 = 9;
        goto L113
    L187:
        r13 = -1;
        goto L113
    L78:
        if (r11.equals("enable-async-list") == false) goto L188;
        r13 = 8;
        goto L113
    L188:
        r13 = -1;
        goto L113
    L82:
        if (r11.equals("use-old-sticky") == false) goto L189;
        r13 = 7;
        goto L113
    L189:
        r13 = -1;
        goto L113
    L86:
        if (r11.equals("android-enable-gap-item-decoration") == false) goto L190;
        r13 = 6;
        goto L113
    L190:
        r13 = -1;
        goto L113
    L90:
        if (r11.equals("enable-nested-scroll") == false) goto L191;
        r13 = 5;
        goto L113
    L191:
        r13 = -1;
        goto L113
    L94:
        if (r11.equals("android-enable-strict-scrollable") == false) goto L192;
        r13 = 4;
        goto L113
    L192:
        r13 = -1;
        goto L113
    L98:
        if (r11.equals("max-fling-velocity-percent") == false) goto L193;
        r13 = 3;
        goto L113
    L193:
        r13 = -1;
        goto L113
    L102:
        if (r11.equals("android-new-scroll-top") == false) goto L194;
        r13 = 2;
        goto L113
    L194:
        r13 = -1;
        goto L113
    L106:
        if (r11.equals("android-stack-from-end") == false) goto L195;
        r13 = 1;
        goto L113
    L195:
        r13 = -1;
        goto L113
    L110:
        if (r11.equals("scroll-index") == false) goto L196;
        r13 = 0;
        goto L113
    L196:
        r13 = -1;
        goto L113
    }
}
