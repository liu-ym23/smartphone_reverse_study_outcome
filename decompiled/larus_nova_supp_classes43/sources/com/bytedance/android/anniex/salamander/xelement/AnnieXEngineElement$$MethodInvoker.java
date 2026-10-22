package com.bytedance.android.anniex.salamander.xelement;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AnnieXEngineElement$$MethodInvoker implements a<AnnieXEngineElement> {
    public AnnieXEngineElement$$MethodInvoker() {
    }

    public void invoke(AnnieXEngineElement r10, String r11, ReadableMap r12, Callback r13) {
        r11.getClass();
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -1615242480: goto L42;
            case -1614974401: goto L38;
            case -527962973: goto L34;
            case -357431021: goto L30;
            case 105857660: goto L26;
            case 194959693: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L45;
        };
    L45:
        switch(r14) {
            case 0: goto L56;
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            default: goto L46;
        };
    L46:
        r13.invoke(new Object[]{3});
        return;
    L47:
        r10.scrollIntoView(r12, r13);
        return;
    L48:
        r10.requestAccessibilityFocus(r12, r13);
        return;
    L49:
        r10.requestUIInfo(r12, r13);
        return;
    L50:
        r10.fetchAccessibilityTargets(r12, r13);
        return;
    L51:
        r10.takeScreenshot(r12, r13);
        return;
    L52:
        r10.onEnd(r12, r13);
        return;
    L53:
        r10.boundingClientRect(r12, r13);
        return;
    L54:
        r10.innerText(r12, r13);
        return;
    L55:
        r10.onTouchesMove(r12, r13);
        return;
    L56:
        r10.onTouchesDown(r12, r13);
        return;
    L6:
        if (r11.equals("scrollIntoView") == false) goto L45;
        r14 = 9;
        goto L45
    L10:
        if (r11.equals("requestAccessibilityFocus") == false) goto L45;
        r14 = 8;
        goto L45
    L14:
        if (r11.equals("requestUIInfo") == false) goto L45;
        r14 = 7;
        goto L45
    L18:
        if (r11.equals("fetchAccessibilityTargets") == false) goto L45;
        r14 = 6;
        goto L45
    L22:
        if (r11.equals("takeScreenshot") == false) goto L45;
        r14 = 5;
        goto L45
    L26:
        if (r11.equals("onEnd") == false) goto L45;
        r14 = 4;
        goto L45
    L30:
        if (r11.equals("boundingClientRect") == false) goto L45;
        r14 = 3;
        goto L45
    L34:
        if (r11.equals("innerText") == false) goto L45;
        r14 = 2;
        goto L45
    L38:
        if (r11.equals("onTouchesMove") == false) goto L45;
        r14 = 1;
        goto L45
    L42:
        if (r11.equals("onTouchesDown") == false) goto L45;
        r14 = 0;
        goto L45
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r10, ReadableMap r11, Callback r12) {
        invoke((AnnieXEngineElement) r1, r10, r11, r12);
    }
}
