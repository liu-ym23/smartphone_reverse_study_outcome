package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIScrollView$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LynxUIScrollView> {
    public LynxUIScrollView$$MethodInvoker() {
    }

    public void invoke(LynxUIScrollView r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -527962973: goto L50;
            case -402165756: goto L46;
            case -402165208: goto L42;
            case -398364324: goto L38;
            case -357431021: goto L34;
            case -231782127: goto L30;
            case 194959693: goto L26;
            case 445177080: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L53;
        };
    L53:
        switch(r4) {
            case 0: goto L66;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L56;
            case 11: goto L55;
            default: goto L54;
        };
    L54:
        r9.invoke(new Object[]{3});
        return;
    L55:
        r6.scrollIntoView(r8, r9);
        return;
    L56:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L57:
        r6.requestUIInfo(r8, r9);
        return;
    L58:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L59:
        r6.takeContentScreenshot(r8, r9);
        return;
    L60:
        r6.takeScreenshot(r8, r9);
        return;
    L61:
        r6.getScrollInfo(r8, r9);
        return;
    L62:
        r6.boundingClientRect(r8, r9);
        return;
    L63:
        r6.autoScroll(r8, r9);
        return;
    L64:
        r6.scrollTo(r8, r9);
        return;
    L65:
        r6.scrollBy(r8, r9);
        return;
    L66:
        r6.innerText(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L53;
        r4 = 11;
        goto L53
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L53;
        r4 = 10;
        goto L53
    L14:
        if (r7.equals("requestUIInfo") == false) goto L53;
        r4 = 9;
        goto L53
    L18:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L53;
        r4 = 8;
        goto L53
    L22:
        if (r7.equals("takeContentScreenshot") == false) goto L53;
        r4 = 7;
        goto L53
    L26:
        if (r7.equals("takeScreenshot") == false) goto L53;
        r4 = 6;
        goto L53
    L30:
        if (r7.equals("getScrollInfo") == false) goto L53;
        r4 = 5;
        goto L53
    L34:
        if (r7.equals("boundingClientRect") == false) goto L53;
        r4 = 4;
        goto L53
    L38:
        if (r7.equals("autoScroll") == false) goto L53;
        r4 = 3;
        goto L53
    L42:
        if (r7.equals("scrollTo") == false) goto L53;
        r4 = 2;
        goto L53
    L46:
        if (r7.equals("scrollBy") == false) goto L53;
        r4 = 1;
        goto L53
    L50:
        if (r7.equals("innerText") == false) goto L53;
        r4 = 0;
        goto L53
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((LynxUIScrollView) r1, r2, r3, r4);
    }
}
