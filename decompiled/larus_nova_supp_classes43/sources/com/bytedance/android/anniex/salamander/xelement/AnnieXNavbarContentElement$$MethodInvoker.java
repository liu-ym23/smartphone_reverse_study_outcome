package com.bytedance.android.anniex.salamander.xelement;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AnnieXNavbarContentElement$$MethodInvoker implements a<AnnieXNavbarContentElement> {
    public AnnieXNavbarContentElement$$MethodInvoker() {
    }

    public void invoke(AnnieXNavbarContentElement r10, String r11, ReadableMap r12, Callback r13) {
        r11.getClass();
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -527962973: goto L30;
            case -357431021: goto L26;
            case 194959693: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L33;
        };
    L33:
        switch(r14) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L34;
        };
    L34:
        r13.invoke(new Object[]{3});
        return;
    L35:
        r10.scrollIntoView(r12, r13);
        return;
    L36:
        r10.requestAccessibilityFocus(r12, r13);
        return;
    L37:
        r10.requestUIInfo(r12, r13);
        return;
    L38:
        r10.fetchAccessibilityTargets(r12, r13);
        return;
    L39:
        r10.takeScreenshot(r12, r13);
        return;
    L40:
        r10.boundingClientRect(r12, r13);
        return;
    L41:
        r10.innerText(r12, r13);
        return;
    L6:
        if (r11.equals("scrollIntoView") == false) goto L33;
        r14 = 6;
        goto L33
    L10:
        if (r11.equals("requestAccessibilityFocus") == false) goto L33;
        r14 = 5;
        goto L33
    L14:
        if (r11.equals("requestUIInfo") == false) goto L33;
        r14 = 4;
        goto L33
    L18:
        if (r11.equals("fetchAccessibilityTargets") == false) goto L33;
        r14 = 3;
        goto L33
    L22:
        if (r11.equals("takeScreenshot") == false) goto L33;
        r14 = 2;
        goto L33
    L26:
        if (r11.equals("boundingClientRect") == false) goto L33;
        r14 = 1;
        goto L33
    L30:
        if (r11.equals("innerText") == false) goto L33;
        r14 = 0;
        goto L33
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r10, ReadableMap r11, Callback r12) {
        invoke((AnnieXNavbarContentElement) r1, r10, r11, r12);
    }
}
