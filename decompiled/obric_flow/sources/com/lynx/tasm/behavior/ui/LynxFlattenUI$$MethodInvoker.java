package com.lynx.tasm.behavior.ui;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxFlattenUI$$MethodInvoker implements com.lynx.tasm.behavior.utils.a {
    public LynxFlattenUI$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxFlattenUI) r5, r10, r11, r12);
    }

    public void invoke(LynxFlattenUI r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -527962973: goto L26;
            case -357431021: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L29;
        };
    L29:
        switch(r13) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        r12.invoke(new Object[]{3});
        return;
    L32:
        r5.scrollIntoView(r11, r12);
        return;
    L34:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L36:
        r5.requestUIInfo(r11, r12);
        return;
    L38:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L40:
        r5.boundingClientRect(r11, r12);
        return;
    L42:
        r5.innerText(r11, r12);
        return;
    L6:
        if (r10.equals("scrollIntoView") == false) goto L29;
        r13 = 5;
        goto L29
    L10:
        if (r10.equals("requestAccessibilityFocus") == false) goto L29;
        r13 = 4;
        goto L29
    L14:
        if (r10.equals("requestUIInfo") == false) goto L29;
        r13 = 3;
        goto L29
    L18:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L29;
        r13 = 2;
        goto L29
    L22:
        if (r10.equals("boundingClientRect") == false) goto L29;
        r13 = 1;
        goto L29
    L26:
        if (r10.equals("innerText") == false) goto L29;
        r13 = 0;
        goto L29
    }
}
