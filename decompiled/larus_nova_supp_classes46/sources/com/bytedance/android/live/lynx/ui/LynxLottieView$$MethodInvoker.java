package com.bytedance.android.live.lynx.ui;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LynxLottieView$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LynxLottieView> {
    public LynxLottieView$$MethodInvoker() {
    }

    public void invoke(LynxLottieView r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
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
        switch(r4) {
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
        r9.invoke(new Object[]{3});
        return;
    L35:
        r6.scrollIntoView(r8, r9);
        return;
    L36:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L37:
        r6.requestUIInfo(r8, r9);
        return;
    L38:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L39:
        r6.takeScreenshot(r8, r9);
        return;
    L40:
        r6.boundingClientRect(r8, r9);
        return;
    L41:
        r6.innerText(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L33;
        r4 = 6;
        goto L33
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L33;
        r4 = 5;
        goto L33
    L14:
        if (r7.equals("requestUIInfo") == false) goto L33;
        r4 = 4;
        goto L33
    L18:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L33;
        r4 = 3;
        goto L33
    L22:
        if (r7.equals("takeScreenshot") == false) goto L33;
        r4 = 2;
        goto L33
    L26:
        if (r7.equals("boundingClientRect") == false) goto L33;
        r4 = 1;
        goto L33
    L30:
        if (r7.equals("innerText") == false) goto L33;
        r4 = 0;
        goto L33
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((LynxLottieView) r1, r2, r3, r4);
    }
}
