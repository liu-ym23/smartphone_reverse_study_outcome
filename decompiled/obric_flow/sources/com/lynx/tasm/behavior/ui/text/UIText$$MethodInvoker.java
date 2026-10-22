package com.lynx.tasm.behavior.ui.text;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UIText$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public UIText$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((UIText) r5, r10, r11, r12);
    }

    public void invoke(UIText r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -527962973: goto L42;
            case -357431021: goto L38;
            case -127960866: goto L34;
            case -95358563: goto L30;
            case 194959693: goto L26;
            case 692239790: goto L22;
            case 850462443: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L45;
        };
    L45:
        switch(r13) {
            case 0: goto L66;
            case 1: goto L64;
            case 2: goto L62;
            case 3: goto L60;
            case 4: goto L58;
            case 5: goto L56;
            case 6: goto L54;
            case 7: goto L52;
            case 8: goto L50;
            case 9: goto L48;
            default: goto L46;
        };
    L46:
        r12.invoke(new Object[]{3});
        return;
    L48:
        r5.scrollIntoView(r11, r12);
        return;
    L50:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L52:
        r5.requestUIInfo(r11, r12);
        return;
    L54:
        r5.getTextBoundingRect(r11, r12);
        return;
    L56:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L58:
        r5.takeScreenshot(r11, r12);
        return;
    L60:
        r5.setTextSelection(r11, r12);
        return;
    L62:
        r5.getSelectedText(r11, r12);
        return;
    L64:
        r5.boundingClientRect(r11, r12);
        return;
    L66:
        r5.innerText(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L45;
        r13 = 9;
        goto L45
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L45;
        r13 = 8;
        goto L45
    L14:
        if (r10.equals("requestUIInfo") == false) goto L45;
        r13 = 7;
        goto L45
    L18:
        if (r10.equals("getTextBoundingRect") == false) goto L45;
        r13 = 6;
        goto L45
    L22:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L45;
        r13 = 5;
        goto L45
    L26:
        if (r10.equals("takeScreenshot") == false) goto L45;
        r13 = 4;
        goto L45
    L30:
        if (r10.equals("setTextSelection") == false) goto L45;
        r13 = 3;
        goto L45
    L34:
        if (r10.equals("getSelectedText") == false) goto L45;
        r13 = 2;
        goto L45
    L38:
        if (r10.equals("boundingClientRect") == false) goto L45;
        r13 = 1;
        goto L45
    L42:
        if (r10.equals("innerText") == false) goto L45;
        r13 = 0;
        goto L45
    }
}
