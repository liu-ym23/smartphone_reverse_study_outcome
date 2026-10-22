package com.lynx.tasm.behavior.ui.list.container;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIListContainer$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIListContainer$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        UIListContainer r5 = (UIListContainer) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -2062142952: goto L70;
            case -1741552957: goto L66;
            case -1512080424: goto L62;
            case -1305579111: goto L58;
            case -892259863: goto L54;
            case -858113201: goto L50;
            case -773140599: goto L46;
            case -711580976: goto L42;
            case -169901481: goto L38;
            case 954804946: goto L34;
            case 1013897100: goto L30;
            case 1276968466: goto L26;
            case 1296520439: goto L22;
            case 1844261742: goto L18;
            case 2069690902: goto L14;
            case 2083253753: goto L10;
            case 2107607620: goto L6;
            default: goto L73;
        };
    L73:
        switch(r13) {
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
        super.a(r10, r11, r12);
        return;
    L76:
        r5.setPagingAlignment(r12.f10815a.getMap(r11));
        return;
    L78:
        r5.setVerticalOrientation(r12.e(r11, false));
        return;
    L80:
        r5.setNeedVisibleItemInfo(r12.e(r11, false));
        return;
    L82:
        r5.setUpdateStickyForDiff(r12.e(r11, true));
        return;
    L84:
        r5.setStickyOffset(r12.f10815a.getDynamic(r11));
        return;
    L86:
        r5.setBatchRenderStrategy(r12.c(r11, 0));
        return;
    L88:
        r5.setForceCanScroll(r12.e(r11, false));
        return;
    L90:
        r5.setMaxFlingDistanceRatio(r12.f10815a.getDynamic(r11));
        return;
    L92:
        r5.setEnableScroll(r12.e(r11, true));
        return;
    L94:
        r5.setScrollOrientation(r12.f10815a.getString(r11));
        return;
    L96:
        r5.setDiffInfo(r12.f10815a.getMap(r11));
        return;
    L98:
        r5.setEnableInsertPlatformViewOperation(r12.e(r11, false));
        return;
    L100:
        r5.setEnableListSticky(r12.e(r11, true));
        return;
    L102:
        r5.setEnableNestedScroll(r12.e(r11, false));
        return;
    L104:
        r5.setEnableRecycleStickyItem(r12.e(r11, true));
        return;
    L106:
        r5.setEnableFadeInAnimation(r12.e(r11, false));
        return;
    L108:
        r5.setUpdateAnimationFadeInDuration(r12.c(r11, 100));
        return;
    L6:
        if (r11.equals("item-snap") == false) goto L73;
        r13 = 16;
        goto L73
    L10:
        if (r11.equals("vertical-orientation") == false) goto L73;
        r13 = 15;
        goto L73
    L14:
        if (r11.equals("need-visible-item-info") == false) goto L73;
        r13 = 14;
        goto L73
    L18:
        if (r11.equals("experimental-update-sticky-for-diff") == false) goto L73;
        r13 = 13;
        goto L73
    L22:
        if (r11.equals("sticky-offset") == false) goto L73;
        r13 = 12;
        goto L73
    L26:
        if (r11.equals("experimental-batch-render-strategy") == false) goto L73;
        r13 = 11;
        goto L73
    L30:
        if (r11.equals("force-can-scroll") == false) goto L73;
        r13 = 10;
        goto L73
    L34:
        if (r11.equals("experimental-max-fling-distance-ratio") == false) goto L73;
        r13 = 9;
        goto L73
    L38:
        if (r11.equals("enable-scroll") == false) goto L73;
        r13 = 8;
        goto L73
    L42:
        if (r11.equals("scroll-orientation") == false) goto L73;
        r13 = 7;
        goto L73
    L46:
        if (r11.equals("list-container-info") == false) goto L73;
        r13 = 6;
        goto L73
    L50:
        if (r11.equals("enable-insert-platform-view-operation") == false) goto L73;
        r13 = 5;
        goto L73
    L54:
        if (r11.equals("sticky") == false) goto L73;
        r13 = 4;
        goto L73
    L58:
        if (r11.equals("enable-nested-scroll") == false) goto L73;
        r13 = 3;
        goto L73
    L62:
        if (r11.equals("experimental-recycle-sticky-item") == false) goto L73;
        r13 = 2;
        goto L73
    L66:
        if (r11.equals("enable-fade-in-animation") == false) goto L73;
        r13 = 1;
        goto L73
    L70:
        if (r11.equals("update-animation-fade-in-duration") == false) goto L73;
        r13 = 0;
        goto L73
    }
}
