package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIScrollView$$PropsSetter extends AbsLynxUIScroll$$PropsSetter {
    public UIScrollView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        UIScrollView r5 = (UIScrollView) r10;
        r11.getClass();
        Integer r13 = null;
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -1305579111: goto L38;
            case -746453530: goto L34;
            case -711580976: goto L30;
            case 293962082: goto L26;
            case 294508746: goto L22;
            case 616977828: goto L18;
            case 1013897100: goto L14;
            case 1730905463: goto L10;
            case 1868120577: goto L6;
            default: goto L41;
        };
    L41:
        switch(r14) {
            case 0: goto L68;
            case 1: goto L66;
            case 2: goto L64;
            case 3: goto L62;
            case 4: goto L57;
            case 5: goto L54;
            case 6: goto L52;
            case 7: goto L47;
            case 8: goto L44;
            default: goto L42;
        };
    L42:
        super.a(r10, r11, r12);
        return;
    L44:
        r5.setEnableNewBounce(r12.e(r11, false));
        return;
    L52:
        r5.setForceCanScroll(r12.e(r11, false));
        return;
    L54:
        r5.setPreferenceConsumeGesture(r12.e(r11, false));
        return;
    L62:
        r5.setFadingEdgeLength(r12.f10815a.getString(r11));
        return;
    L64:
        r5.setScrollOrientation(r12.f10815a.getString(r11));
        return;
    L66:
        r5.setTouchSlop(r12.f10815a.getString(r11));
        return;
    L68:
        r5.setEnableNestedScroll(r12.e(r11, false));
        return;
    L47:
        if (r12.f10815a.isNull(r11) == true) goto L50;
        r13 = Integer.valueOf(r12.c(r11, 0));
    L50:
        r5.setInitialScrollToIndex(r13);
        return;
    L57:
        if (r12.f10815a.isNull(r11) == true) goto L60;
        r13 = Integer.valueOf(r12.c(r11, 0));
    L60:
        r5.setInitialScrollOffset(r13);
        return;
    L6:
        if (r11.equals("android-enable-new-bounce") == false) goto L41;
        r14 = 8;
        goto L41
    L10:
        if (r11.equals("initial-scroll-to-index") == false) goto L41;
        r14 = 7;
        goto L41
    L14:
        if (r11.equals("force-can-scroll") == false) goto L41;
        r14 = 6;
        goto L41
    L18:
        if (r11.equals("android-preference-consume-gesture") == false) goto L41;
        r14 = 5;
        goto L41
    L22:
        if (r11.equals("initial-scroll-offset") == false) goto L41;
        r14 = 4;
        goto L41
    L26:
        if (r11.equals("fading-edge-length") == false) goto L41;
        r14 = 3;
        goto L41
    L30:
        if (r11.equals("scroll-orientation") == false) goto L41;
        r14 = 2;
        goto L41
    L34:
        if (r11.equals("android-touch-slop") == false) goto L41;
        r14 = 1;
        goto L41
    L38:
        if (r11.equals("enable-nested-scroll") == false) goto L41;
        r14 = 0;
        goto L41
    }
}
