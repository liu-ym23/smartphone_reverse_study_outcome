package com.bytedance.ai.applet.render.core.camera;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class LynxCameraUI$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LynxCameraUI> {
    public LynxCameraUI$$MethodInvoker() {
    }

    public void invoke(LynxCameraUI r10, String r11, ReadableMap r12, Callback r13) {
        r11.getClass();
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -1909077165: goto L46;
            case -1391995149: goto L42;
            case -527962973: goto L38;
            case -357431021: goto L34;
            case 194959693: goto L30;
            case 692239790: goto L26;
            case 1280029577: goto L22;
            case 1419773105: goto L18;
            case 1484838379: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L49;
        };
    L49:
        switch(r14) {
            case 0: goto L61;
            case 1: goto L60;
            case 2: goto L59;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L56;
            case 6: goto L55;
            case 7: goto L54;
            case 8: goto L53;
            case 9: goto L52;
            case 10: goto L51;
            default: goto L50;
        };
    L50:
        r13.invoke(new Object[]{3});
        return;
    L51:
        r10.scrollIntoView(r12, r13);
        return;
    L52:
        r10.requestAccessibilityFocus(r12, r13);
        return;
    L53:
        r10.takePhoto(r12, r13);
        return;
    L54:
        r10.requestUIInfo(r12, r13);
        return;
    L55:
        r10.requestFocus(r12, r13);
        return;
    L56:
        r10.fetchAccessibilityTargets(r12, r13);
        return;
    L57:
        r10.takeScreenshot(r12, r13);
        return;
    L58:
        r10.boundingClientRect(r12, r13);
        return;
    L59:
        r10.innerText(r12, r13);
        return;
    L60:
        r10.stopRecord(r12, r13);
        return;
    L61:
        r10.startRecord(r12, r13);
        return;
    L6:
        if (r11.equals("scrollIntoView") == false) goto L49;
        r14 = 10;
        goto L49
    L10:
        if (r11.equals("requestAccessibilityFocus") == false) goto L49;
        r14 = 9;
        goto L49
    L14:
        if (r11.equals("takePhoto") == false) goto L49;
        r14 = 8;
        goto L49
    L18:
        if (r11.equals("requestUIInfo") == false) goto L49;
        r14 = 7;
        goto L49
    L22:
        if (r11.equals("requestFocus") == false) goto L49;
        r14 = 6;
        goto L49
    L26:
        if (r11.equals("fetchAccessibilityTargets") == false) goto L49;
        r14 = 5;
        goto L49
    L30:
        if (r11.equals("takeScreenshot") == false) goto L49;
        r14 = 4;
        goto L49
    L34:
        if (r11.equals("boundingClientRect") == false) goto L49;
        r14 = 3;
        goto L49
    L38:
        if (r11.equals("innerText") == false) goto L49;
        r14 = 2;
        goto L49
    L42:
        if (r11.equals("stopRecord") == false) goto L49;
        r14 = 1;
        goto L49
    L46:
        if (r11.equals("startRecord") == false) goto L49;
        r14 = 0;
        goto L49
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxCameraUI) r1, r10, r11, r12);
    }
}
