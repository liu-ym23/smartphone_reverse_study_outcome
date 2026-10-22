package com.lynx.xelement.markdown;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIMarkdown$$MethodInvoker implements a<LynxUIMarkdown> {
    public LynxUIMarkdown$$MethodInvoker() {
    }

    public void invoke(LynxUIMarkdown r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1585986401: goto L66;
            case -1360985222: goto L62;
            case -1296995794: goto L58;
            case -527962973: goto L54;
            case -357431021: goto L50;
            case -127960866: goto L46;
            case -95358563: goto L42;
            case 194959693: goto L38;
            case 510764398: goto L34;
            case 692239790: goto L30;
            case 850462443: goto L26;
            case 1236882903: goto L22;
            case 1419773105: goto L18;
            case 1848904985: goto L14;
            case 1908871954: goto L10;
            case 1988390979: goto L6;
            default: goto L69;
        };
    L69:
        switch(r4) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L77;
            case 10: goto L76;
            case 11: goto L75;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            default: goto L70;
        };
    L70:
        r9.invoke(new Object[]{3});
        return;
    L71:
        r6.getContent(r8, r9);
        return;
    L72:
        r6.scrollIntoView(r8, r9);
        return;
    L73:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L74:
        r6.requestUIInfo(r8, r9);
        return;
    L75:
        r6.resumeAnimation(r8, r9);
        return;
    L76:
        r6.getTextBoundingRect(r8, r9);
        return;
    L77:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L78:
        r6.getImages(r8, r9);
        return;
    L79:
        r6.takeScreenshot(r8, r9);
        return;
    L80:
        r6.setTextSelection(r8, r9);
        return;
    L81:
        r6.getSelectedText(r8, r9);
        return;
    L82:
        r6.boundingClientRect(r8, r9);
        return;
    L83:
        r6.innerText(r8, r9);
        return;
    L84:
        r6.pauseAnimation(r8, r9);
        return;
    L85:
        r6.getParseResult(r8, r9);
        return;
    L86:
        r6.clearStatus(r8, r9);
        return;
    L6:
        if (r7.equals("getContent") == false) goto L69;
        r4 = 15;
        goto L69
    L10:
        if (r7.equals("scrollIntoView") == false) goto L69;
        r4 = 14;
        goto L69
    L14:
        if (r7.equals("requestAccessibilityFocus") == false) goto L69;
        r4 = 13;
        goto L69
    L18:
        if (r7.equals("requestUIInfo") == false) goto L69;
        r4 = 12;
        goto L69
    L22:
        if (r7.equals("resumeAnimation") == false) goto L69;
        r4 = 11;
        goto L69
    L26:
        if (r7.equals("getTextBoundingRect") == false) goto L69;
        r4 = 10;
        goto L69
    L30:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L69;
        r4 = 9;
        goto L69
    L34:
        if (r7.equals("getImages") == false) goto L69;
        r4 = 8;
        goto L69
    L38:
        if (r7.equals("takeScreenshot") == false) goto L69;
        r4 = 7;
        goto L69
    L42:
        if (r7.equals("setTextSelection") == false) goto L69;
        r4 = 6;
        goto L69
    L46:
        if (r7.equals("getSelectedText") == false) goto L69;
        r4 = 5;
        goto L69
    L50:
        if (r7.equals("boundingClientRect") == false) goto L69;
        r4 = 4;
        goto L69
    L54:
        if (r7.equals("innerText") == false) goto L69;
        r4 = 3;
        goto L69
    L58:
        if (r7.equals("pauseAnimation") == false) goto L69;
        r4 = 2;
        goto L69
    L62:
        if (r7.equals("getParseResult") == false) goto L69;
        r4 = 1;
        goto L69
    L66:
        if (r7.equals("clearStatus") == false) goto L69;
        r4 = 0;
        goto L69
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((LynxUIMarkdown) r1, r2, r3, r4);
    }
}
