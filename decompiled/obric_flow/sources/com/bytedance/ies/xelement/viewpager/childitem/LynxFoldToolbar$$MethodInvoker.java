package com.bytedance.ies.xelement.viewpager.childitem;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxFoldToolbar$$MethodInvoker implements a {
    public LynxFoldToolbar$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxFoldToolbar) r5, r10, r11, r12);
    }

    public void invoke(LynxFoldToolbar r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
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
        switch(r13) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        r12.invoke(new Object[]{3});
        return;
    L36:
        r5.scrollIntoView(r11, r12);
        return;
    L38:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L40:
        r5.requestUIInfo(r11, r12);
        return;
    L42:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L44:
        r5.takeScreenshot(r11, r12);
        return;
    L46:
        r5.boundingClientRect(r11, r12);
        return;
    L48:
        r5.innerText(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L33;
        r13 = 6;
        goto L33
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L33;
        r13 = 5;
        goto L33
    L14:
        if (r10.equals("requestUIInfo") == false) goto L33;
        r13 = 4;
        goto L33
    L18:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L33;
        r13 = 3;
        goto L33
    L22:
        if (r10.equals("takeScreenshot") == false) goto L33;
        r13 = 2;
        goto L33
    L26:
        if (r10.equals("boundingClientRect") == false) goto L33;
        r13 = 1;
        goto L33
    L30:
        if (r10.equals("innerText") == false) goto L33;
        r13 = 0;
        goto L33
    }
}
