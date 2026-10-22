package com.bytedance.ai.applet.render.core.webview;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class EmbedWebView$$MethodInvoker implements a<EmbedWebView> {
    public EmbedWebView$$MethodInvoker() {
    }

    public void invoke(EmbedWebView r10, String r11, ReadableMap r12, Callback r13) {
        r11.getClass();
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -934641255: goto L46;
            case -527962973: goto L42;
            case -357431021: goto L38;
            case 3125404: goto L34;
            case 194959693: goto L30;
            case 692239790: goto L26;
            case 1156819118: goto L22;
            case 1419773105: goto L18;
            case 1490029383: goto L14;
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
        r10.postMessage(r12, r13);
        return;
    L54:
        r10.requestUIInfo(r12, r13);
        return;
    L55:
        r10.onGoBack(r12, r13);
        return;
    L56:
        r10.fetchAccessibilityTargets(r12, r13);
        return;
    L57:
        r10.takeScreenshot(r12, r13);
        return;
    L58:
        r10.eval(r12, r13);
        return;
    L59:
        r10.boundingClientRect(r12, r13);
        return;
    L60:
        r10.innerText(r12, r13);
        return;
    L61:
        r10.reload(r12, r13);
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
        if (r11.equals("postMessage") == false) goto L49;
        r14 = 8;
        goto L49
    L18:
        if (r11.equals("requestUIInfo") == false) goto L49;
        r14 = 7;
        goto L49
    L22:
        if (r11.equals("onGoBack") == false) goto L49;
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
        if (r11.equals("eval") == false) goto L49;
        r14 = 3;
        goto L49
    L38:
        if (r11.equals("boundingClientRect") == false) goto L49;
        r14 = 2;
        goto L49
    L42:
        if (r11.equals("innerText") == false) goto L49;
        r14 = 1;
        goto L49
    L46:
        if (r11.equals("reload") == false) goto L49;
        r14 = 0;
        goto L49
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r10, ReadableMap r11, Callback r12) {
        invoke((EmbedWebView) r1, r10, r11, r12);
    }
}
