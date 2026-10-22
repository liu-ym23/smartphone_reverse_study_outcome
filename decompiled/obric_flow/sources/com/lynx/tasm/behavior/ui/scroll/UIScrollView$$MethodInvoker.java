package com.lynx.tasm.behavior.ui.scroll;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UIScrollView$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public UIScrollView$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((UIScrollView) r5, r10, r11, r12);
    }

    public void invoke(UIScrollView r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -527962973: goto L46;
            case -402165756: goto L42;
            case -402165208: goto L38;
            case -398364324: goto L34;
            case -357431021: goto L30;
            case -231782127: goto L26;
            case 194959693: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L49;
        };
    L49:
        switch(r13) {
            case 0: goto L72;
            case 1: goto L70;
            case 2: goto L68;
            case 3: goto L66;
            case 4: goto L64;
            case 5: goto L62;
            case 6: goto L60;
            case 7: goto L58;
            case 8: goto L56;
            case 9: goto L54;
            case 10: goto L52;
            default: goto L50;
        };
    L50:
        r12.invoke(new Object[]{3});
        return;
    L52:
        r5.scrollIntoView(r11, r12);
        return;
    L54:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L56:
        r5.requestUIInfo(r11, r12);
        return;
    L58:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L60:
        r5.takeScreenshot(r11, r12);
        return;
    L62:
        r5.getScrollInfo(r12);
        return;
    L64:
        r5.boundingClientRect(r11, r12);
        return;
    L66:
        r5.autoScroll(r11);
        return;
    L68:
        r5.scrollTo(r11, r12);
        return;
    L70:
        r5.scrollBy(r11, r12);
        return;
    L72:
        r5.innerText(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L49;
        r13 = 10;
        goto L49
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L49;
        r13 = 9;
        goto L49
    L14:
        if (r10.equals("requestUIInfo") == false) goto L49;
        r13 = 8;
        goto L49
    L18:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L49;
        r13 = 7;
        goto L49
    L22:
        if (r10.equals("takeScreenshot") == false) goto L49;
        r13 = 6;
        goto L49
    L26:
        if (r10.equals("getScrollInfo") == false) goto L49;
        r13 = 5;
        goto L49
    L30:
        if (r10.equals("boundingClientRect") == false) goto L49;
        r13 = 4;
        goto L49
    L34:
        if (r10.equals("autoScroll") == false) goto L49;
        r13 = 3;
        goto L49
    L38:
        if (r10.equals("scrollTo") == false) goto L49;
        r13 = 2;
        goto L49
    L42:
        if (r10.equals("scrollBy") == false) goto L49;
        r13 = 1;
        goto L49
    L46:
        if (r10.equals("innerText") == false) goto L49;
        r13 = 0;
        goto L49
    }
}
