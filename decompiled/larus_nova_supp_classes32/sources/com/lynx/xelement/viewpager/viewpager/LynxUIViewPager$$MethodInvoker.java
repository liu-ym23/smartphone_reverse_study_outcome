package com.lynx.xelement.viewpager.viewpager;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIViewPager$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LynxUIViewPager> {
    public LynxUIViewPager$$MethodInvoker() {
    }

    public void invoke(LynxUIViewPager r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1715986183: goto L38;
            case -1165230157: goto L34;
            case -527962973: goto L30;
            case -357431021: goto L26;
            case 194959693: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L41;
        };
    L41:
        switch(r4) {
            case 0: goto L51;
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L45;
            case 7: goto L44;
            case 8: goto L43;
            default: goto L42;
        };
    L42:
        r9.invoke(new Object[]{3});
        return;
    L43:
        r6.scrollIntoView(r8, r9);
        return;
    L44:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L45:
        r6.requestUIInfo(r8, r9);
        return;
    L46:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L47:
        r6.takeScreenshot(r8, r9);
        return;
    L48:
        r6.boundingClientRect(r8, r9);
        return;
    L49:
        r6.innerText(r8, r9);
        return;
    L50:
        r6.setDragGesture(r8, r9);
        return;
    L51:
        r6.selectTab(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L41;
        r4 = 8;
        goto L41
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L41;
        r4 = 7;
        goto L41
    L14:
        if (r7.equals("requestUIInfo") == false) goto L41;
        r4 = 6;
        goto L41
    L18:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L41;
        r4 = 5;
        goto L41
    L22:
        if (r7.equals("takeScreenshot") == false) goto L41;
        r4 = 4;
        goto L41
    L26:
        if (r7.equals("boundingClientRect") == false) goto L41;
        r4 = 3;
        goto L41
    L30:
        if (r7.equals("innerText") == false) goto L41;
        r4 = 2;
        goto L41
    L34:
        if (r7.equals("setDragGesture") == false) goto L41;
        r4 = 1;
        goto L41
    L38:
        if (r7.equals("selectTab") == false) goto L41;
        r4 = 0;
        goto L41
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((LynxUIViewPager) r1, r2, r3, r4);
    }
}
