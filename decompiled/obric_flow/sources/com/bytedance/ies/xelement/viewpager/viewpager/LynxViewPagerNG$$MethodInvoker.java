package com.bytedance.ies.xelement.viewpager.viewpager;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxViewPagerNG$$MethodInvoker implements a {
    public LynxViewPagerNG$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxViewPagerNG) r5, r10, r11, r12);
    }

    public void invoke(LynxViewPagerNG r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
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
        switch(r13) {
            case 0: goto L60;
            case 1: goto L58;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L46;
            case 8: goto L44;
            default: goto L42;
        };
    L42:
        r12.invoke(new Object[]{3});
        return;
    L44:
        r5.scrollIntoView(r11, r12);
        return;
    L46:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L48:
        r5.requestUIInfo(r11, r12);
        return;
    L50:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L52:
        r5.takeScreenshot(r11, r12);
        return;
    L54:
        r5.boundingClientRect(r11, r12);
        return;
    L56:
        r5.innerText(r11, r12);
        return;
    L58:
        r5.setDragGesture(r11, r12);
        return;
    L60:
        r5.selectTab(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L41;
        r13 = 8;
        goto L41
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L41;
        r13 = 7;
        goto L41
    L14:
        if (r10.equals("requestUIInfo") == false) goto L41;
        r13 = 6;
        goto L41
    L18:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L41;
        r13 = 5;
        goto L41
    L22:
        if (r10.equals("takeScreenshot") == false) goto L41;
        r13 = 4;
        goto L41
    L26:
        if (r10.equals("boundingClientRect") == false) goto L41;
        r13 = 3;
        goto L41
    L30:
        if (r10.equals("innerText") == false) goto L41;
        r13 = 2;
        goto L41
    L34:
        if (r10.equals("setDragGesture") == false) goto L41;
        r13 = 1;
        goto L41
    L38:
        if (r10.equals("selectTab") == false) goto L41;
        r13 = 0;
        goto L41
    }
}
