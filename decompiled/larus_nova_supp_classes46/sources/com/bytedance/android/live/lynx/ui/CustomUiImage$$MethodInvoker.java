package com.bytedance.android.live.lynx.ui;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class CustomUiImage$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<CustomUiImage> {
    public CustomUiImage$$MethodInvoker() {
    }

    public void invoke(CustomUiImage r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1296995794: goto L46;
            case -991382497: goto L42;
            case -893184606: goto L38;
            case -527962973: goto L34;
            case -357431021: goto L30;
            case 194959693: goto L26;
            case 692239790: goto L22;
            case 1236882903: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L49;
        };
    L49:
        switch(r4) {
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
        r9.invoke(new Object[]{3});
        return;
    L51:
        r6.scrollIntoView(r8, r9);
        return;
    L52:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L53:
        r6.requestUIInfo(r8, r9);
        return;
    L54:
        r6.resumeAnimation(r8, r9);
        return;
    L55:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L56:
        r6.takeScreenshot(r8, r9);
        return;
    L57:
        r6.boundingClientRect(r8, r9);
        return;
    L58:
        r6.innerText(r8, r9);
        return;
    L59:
        r6.stopAnimation(r8, r9);
        return;
    L60:
        r6.startAnimate();
        return;
    L61:
        r6.pauseAnimation(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L49;
        r4 = 10;
        goto L49
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L49;
        r4 = 9;
        goto L49
    L14:
        if (r7.equals("requestUIInfo") == false) goto L49;
        r4 = 8;
        goto L49
    L18:
        if (r7.equals("resumeAnimation") == false) goto L49;
        r4 = 7;
        goto L49
    L22:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L49;
        r4 = 6;
        goto L49
    L26:
        if (r7.equals("takeScreenshot") == false) goto L49;
        r4 = 5;
        goto L49
    L30:
        if (r7.equals("boundingClientRect") == false) goto L49;
        r4 = 4;
        goto L49
    L34:
        if (r7.equals("innerText") == false) goto L49;
        r4 = 3;
        goto L49
    L38:
        if (r7.equals("stopAnimation") == false) goto L49;
        r4 = 2;
        goto L49
    L42:
        if (r7.equals("startAnimate") == false) goto L49;
        r4 = 1;
        goto L49
    L46:
        if (r7.equals("pauseAnimation") == false) goto L49;
        r4 = 0;
        goto L49
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((CustomUiImage) r1, r2, r3, r4);
    }
}
