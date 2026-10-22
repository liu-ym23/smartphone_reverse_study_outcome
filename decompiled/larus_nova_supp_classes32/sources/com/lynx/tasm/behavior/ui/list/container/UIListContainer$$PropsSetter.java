package com.lynx.tasm.behavior.ui.list.container;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIListContainer$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIListContainer$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        UIListContainer r0 = (UIListContainer) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -2062142952: goto L74;
            case -1741552957: goto L70;
            case -1512080424: goto L66;
            case -1305579111: goto L62;
            case -892259863: goto L58;
            case -858113201: goto L54;
            case -773140599: goto L50;
            case -711580976: goto L46;
            case -169901481: goto L42;
            case 518408055: goto L38;
            case 954804946: goto L34;
            case 1013897100: goto L30;
            case 1276968466: goto L26;
            case 1296520439: goto L22;
            case 1844261742: goto L18;
            case 2069690902: goto L14;
            case 2083253753: goto L10;
            case 2107607620: goto L6;
            default: goto L77;
        };
    L77:
        switch(r4) {
            case 0: goto L114;
            case 1: goto L112;
            case 2: goto L110;
            case 3: goto L108;
            case 4: goto L106;
            case 5: goto L104;
            case 6: goto L102;
            case 7: goto L100;
            case 8: goto L98;
            case 9: goto L96;
            case 10: goto L94;
            case 11: goto L92;
            case 12: goto L90;
            case 13: goto L88;
            case 14: goto L86;
            case 15: goto L84;
            case 16: goto L82;
            case 17: goto L80;
            default: goto L78;
        };
    L78:
        super.setProperty(r6, r7, r8);
        return;
    L80:
        r0.setPagingAlignment(r8.g(r7));
        return;
    L82:
        r0.setVerticalOrientation(r8.b(r7, false));
        return;
    L84:
        r0.setNeedVisibleItemInfo(r8.b(r7, false));
        return;
    L86:
        r0.setUpdateStickyForDiff(r8.b(r7, true));
        return;
    L88:
        r0.setStickyOffset(r8.e(r7, 0.0f));
        return;
    L90:
        r0.setBatchRenderStrategy(r8.f(r7, 0));
        return;
    L92:
        r0.setForceCanScroll(r8.b(r7, false));
        return;
    L94:
        r0.setMaxFlingDistanceRatio(r8.d(r7));
        return;
    L96:
        r0.setDeferChildMutationInDraw(r8.b(r7, false));
        return;
    L98:
        r0.setEnableScroll(r8.b(r7, true));
        return;
    L100:
        r0.setScrollOrientation(r8.h(r7));
        return;
    L102:
        r0.setDiffInfo(r8.g(r7));
        return;
    L104:
        r0.setEnableInsertPlatformViewOperation(r8.b(r7, false));
        return;
    L106:
        r0.setEnableListSticky(r8.b(r7, true));
        return;
    L108:
        r0.setEnableNestedScroll(r8.b(r7, false));
        return;
    L110:
        r0.setEnableRecycleStickyItem(r8.b(r7, true));
        return;
    L112:
        r0.setEnableFadeInAnimation(r8.b(r7, false));
        return;
    L114:
        r0.setUpdateAnimationFadeInDuration(r8.f(r7, 100));
        return;
    L6:
        if (r7.equals("item-snap") == false) goto L77;
        r4 = 17;
        goto L77
    L10:
        if (r7.equals("vertical-orientation") == false) goto L77;
        r4 = 16;
        goto L77
    L14:
        if (r7.equals("need-visible-item-info") == false) goto L77;
        r4 = 15;
        goto L77
    L18:
        if (r7.equals("experimental-update-sticky-for-diff") == false) goto L77;
        r4 = 14;
        goto L77
    L22:
        if (r7.equals("sticky-offset") == false) goto L77;
        r4 = 13;
        goto L77
    L26:
        if (r7.equals("experimental-batch-render-strategy") == false) goto L77;
        r4 = 12;
        goto L77
    L30:
        if (r7.equals("force-can-scroll") == false) goto L77;
        r4 = 11;
        goto L77
    L34:
        if (r7.equals("experimental-max-fling-distance-ratio") == false) goto L77;
        r4 = 10;
        goto L77
    L38:
        if (r7.equals("experimental-android-defer-child-mutation-in-draw") == false) goto L77;
        r4 = 9;
        goto L77
    L42:
        if (r7.equals("enable-scroll") == false) goto L77;
        r4 = 8;
        goto L77
    L46:
        if (r7.equals("scroll-orientation") == false) goto L77;
        r4 = 7;
        goto L77
    L50:
        if (r7.equals("list-container-info") == false) goto L77;
        r4 = 6;
        goto L77
    L54:
        if (r7.equals("enable-insert-platform-view-operation") == false) goto L77;
        r4 = 5;
        goto L77
    L58:
        if (r7.equals("sticky") == false) goto L77;
        r4 = 4;
        goto L77
    L62:
        if (r7.equals("enable-nested-scroll") == false) goto L77;
        r4 = 3;
        goto L77
    L66:
        if (r7.equals("experimental-recycle-sticky-item") == false) goto L77;
        r4 = 2;
        goto L77
    L70:
        if (r7.equals("enable-fade-in-animation") == false) goto L77;
        r4 = 1;
        goto L77
    L74:
        if (r7.equals("update-animation-fade-in-duration") == false) goto L77;
        r4 = 0;
        goto L77
    }
}
