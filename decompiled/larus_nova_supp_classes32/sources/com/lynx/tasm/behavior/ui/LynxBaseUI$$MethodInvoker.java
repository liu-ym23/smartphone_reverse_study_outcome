package com.lynx.tasm.behavior.ui;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBaseUI$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LynxBaseUI> {
    public LynxBaseUI$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public void invoke(LynxBaseUI r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -527962973: goto L26;
            case -357431021: goto L22;
            case 692239790: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L29;
        };
    L29:
        switch(r4) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L31;
            default: goto L30;
        };
    L30:
        r9.invoke(new Object[]{3});
        return;
    L31:
        r6.scrollIntoView(r8, r9);
        return;
    L32:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L33:
        r6.requestUIInfo(r8, r9);
        return;
    L34:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L35:
        r6.boundingClientRect(r8, r9);
        return;
    L36:
        r6.innerText(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L29;
        r4 = 5;
        goto L29
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L29;
        r4 = 4;
        goto L29
    L14:
        if (r7.equals("requestUIInfo") == false) goto L29;
        r4 = 3;
        goto L29
    L18:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L29;
        r4 = 2;
        goto L29
    L22:
        if (r7.equals("boundingClientRect") == false) goto L29;
        r4 = 1;
        goto L29
    L26:
        if (r7.equals("innerText") == false) goto L29;
        r4 = 0;
        goto L29
    }
}
