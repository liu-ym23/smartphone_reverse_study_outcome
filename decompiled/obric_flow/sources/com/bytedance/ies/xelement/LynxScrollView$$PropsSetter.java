package com.bytedance.ies.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxScrollView$$PropsSetter extends AbsLynxUIScroll$$PropsSetter {
    public LynxScrollView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxScrollView r5 = (LynxScrollView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1826701651: goto L34;
            case -1383205240: goto L30;
            case -1138034670: goto L26;
            case 363559068: goto L22;
            case 561570840: goto L18;
            case 1292219859: goto L14;
            case 1412362981: goto L10;
            case 1448017537: goto L6;
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
        r5.setPageEnable(r12.e(r11, false));
        return;
    L42:
        r5.setUnifiedNotifyItemChanged(r12.e(r11, false));
        return;
    L44:
        r5.setEnableCustomHittest(r12.e(r11, false));
        return;
    L46:
        r5.overflowText(r12.f10815a.getString(r11));
        return;
    L48:
        r5.setLayoutDirection(r12.f10815a.getString(r11));
        return;
    L50:
        r5.enableLoadMore(r12.e(r11, true));
        return;
    L52:
        r5.setBounces(r12.e(r11, false));
        return;
    L54:
        r5.scrollToId(r12.f10815a.getString(r11));
        return;
    L6:
        if (r11.equals("page-enable") == false) goto L37;
        r13 = 7;
        goto L37
    L10:
        if (r11.equals("android-unified-notify-item-changed") == false) goto L37;
        r13 = 6;
        goto L37
    L14:
        if (r11.equals("enable-custom-hittest") == false) goto L37;
        r13 = 5;
        goto L37
    L18:
        if (r11.equals("overflow-text") == false) goto L37;
        r13 = 4;
        goto L37
    L22:
        if (r11.equals("layout-direction") == false) goto L37;
        r13 = 3;
        goto L37
    L26:
        if (r11.equals("enable-load-more") == false) goto L37;
        r13 = 2;
        goto L37
    L30:
        if (r11.equals("bounce") == false) goto L37;
        r13 = 1;
        goto L37
    L34:
        if (r11.equals("scroll-to-id") == false) goto L37;
        r13 = 0;
        goto L37
    }
}
