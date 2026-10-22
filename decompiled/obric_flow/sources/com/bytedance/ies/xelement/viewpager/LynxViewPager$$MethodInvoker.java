package com.bytedance.ies.xelement.viewpager;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxViewPager$$MethodInvoker implements a {
    public LynxViewPager$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxViewPager) r5, r10, r11, r12);
    }

    public void invoke(LynxViewPager r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1715986183: goto L34;
            case -527962973: goto L30;
            case -357431021: goto L26;
            case 194959693: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L37;
        };
    L37:
        switch(r13) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            default: goto L38;
        };
    L38:
        r12.invoke(new Object[]{3});
        return;
    L40:
        r5.scrollIntoView(r11, r12);
        return;
    L42:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L44:
        r5.requestUIInfo(r11, r12);
        return;
    L46:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L48:
        r5.takeScreenshot(r11, r12);
        return;
    L50:
        r5.boundingClientRect(r11, r12);
        return;
    L52:
        r5.innerText(r11, r12);
        return;
    L54:
        r5.selectTab(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L37;
        r13 = 7;
        goto L37
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L37;
        r13 = 6;
        goto L37
    L14:
        if (r10.equals("requestUIInfo") == false) goto L37;
        r13 = 5;
        goto L37
    L18:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L37;
        r13 = 4;
        goto L37
    L22:
        if (r10.equals("takeScreenshot") == false) goto L37;
        r13 = 3;
        goto L37
    L26:
        if (r10.equals("boundingClientRect") == false) goto L37;
        r13 = 2;
        goto L37
    L30:
        if (r10.equals("innerText") == false) goto L37;
        r13 = 1;
        goto L37
    L34:
        if (r10.equals("selectTab") == false) goto L37;
        r13 = 0;
        goto L37
    }
}
