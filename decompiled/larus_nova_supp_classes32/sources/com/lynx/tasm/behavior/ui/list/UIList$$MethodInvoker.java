package com.lynx.tasm.behavior.ui.list;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIList$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<UIList> {
    public UIList$$MethodInvoker() {
    }

    public void invoke(UIList r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -980170895: goto L58;
            case -527962973: goto L54;
            case -402165756: goto L50;
            case -398364324: goto L46;
            case -357431021: goto L42;
            case -284097454: goto L38;
            case -231782127: goto L34;
            case -142621742: goto L30;
            case 194959693: goto L26;
            case 692239790: goto L22;
            case 1363070069: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L61;
        };
    L61:
        switch(r4) {
            case 0: goto L76;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            case 6: goto L70;
            case 7: goto L69;
            case 8: goto L68;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L65;
            case 12: goto L64;
            case 13: goto L63;
            default: goto L62;
        };
    L62:
        r9.invoke(new Object[]{3});
        return;
    L63:
        r6.scrollIntoView(r8, r9);
        return;
    L64:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L65:
        r6.requestUIInfo(r8, r9);
        return;
    L66:
        r6.getVisibleCells(r9);
        return;
    L67:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L68:
        r6.takeScreenshot(r8, r9);
        return;
    L69:
        r6.removeStickyView();
        return;
    L70:
        r6.getScrollInfo(r9);
        return;
    L71:
        r6.initCache();
        return;
    L72:
        r6.boundingClientRect(r8, r9);
        return;
    L73:
        r6.autoScroll(r8, r9);
        return;
    L74:
        r6.scrollBy(r8, r9);
        return;
    L75:
        r6.innerText(r8, r9);
        return;
    L76:
        r6.scrollToPosition(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L61;
        r4 = 13;
        goto L61
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L61;
        r4 = 12;
        goto L61
    L14:
        if (r7.equals("requestUIInfo") == false) goto L61;
        r4 = 11;
        goto L61
    L18:
        if (r7.equals("getVisibleCells") == false) goto L61;
        r4 = 10;
        goto L61
    L22:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L61;
        r4 = 9;
        goto L61
    L26:
        if (r7.equals("takeScreenshot") == false) goto L61;
        r4 = 8;
        goto L61
    L30:
        if (r7.equals("removeStickyView") == false) goto L61;
        r4 = 7;
        goto L61
    L34:
        if (r7.equals("getScrollInfo") == false) goto L61;
        r4 = 6;
        goto L61
    L38:
        if (r7.equals("initCache") == false) goto L61;
        r4 = 5;
        goto L61
    L42:
        if (r7.equals("boundingClientRect") == false) goto L61;
        r4 = 4;
        goto L61
    L46:
        if (r7.equals("autoScroll") == false) goto L61;
        r4 = 3;
        goto L61
    L50:
        if (r7.equals("scrollBy") == false) goto L61;
        r4 = 2;
        goto L61
    L54:
        if (r7.equals("innerText") == false) goto L61;
        r4 = 1;
        goto L61
    L58:
        if (r7.equals("scrollToPosition") == false) goto L61;
        r4 = 0;
        goto L61
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((UIList) r1, r2, r3, r4);
    }
}
