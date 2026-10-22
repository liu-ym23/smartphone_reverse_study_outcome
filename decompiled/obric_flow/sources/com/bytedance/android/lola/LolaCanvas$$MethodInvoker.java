package com.bytedance.android.lola;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LolaCanvas$$MethodInvoker implements a {
    public LolaCanvas$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LolaCanvas) r5, r10, r11, r12);
    }

    public void invoke(LolaCanvas r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1813545045: goto L42;
            case -1411068134: goto L38;
            case -527962973: goto L34;
            case -357431021: goto L30;
            case 97532676: goto L26;
            case 194959693: goto L22;
            case 692239790: goto L18;
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
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L56:
        r5.takeScreenshot(r11, r12);
        return;
    L58:
        r5.flush(r11);
        return;
    L60:
        r5.boundingClientRect(r11, r12);
        return;
    L62:
        r5.innerText(r11, r12);
        return;
    L64:
        r5.append(r11);
        return;
    L66:
        r5.measureText(r11, r12);
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
        if (r10.equals("fetchAccessibilityTargets") == false) goto L45;
        r13 = 6;
        goto L45
    L22:
        if (r10.equals("takeScreenshot") == false) goto L45;
        r13 = 5;
        goto L45
    L26:
        if (r10.equals("flush") == false) goto L45;
        r13 = 4;
        goto L45
    L30:
        if (r10.equals("boundingClientRect") == false) goto L45;
        r13 = 3;
        goto L45
    L34:
        if (r10.equals("innerText") == false) goto L45;
        r13 = 2;
        goto L45
    L38:
        if (r10.equals("append") == false) goto L45;
        r13 = 1;
        goto L45
    L42:
        if (r10.equals("measureText") == false) goto L45;
        r13 = 0;
        goto L45
    }
}
