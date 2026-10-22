package com.lynx.tasm.behavior.ui.image;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlattenUIImage$$MethodInvoker implements a<FlattenUIImage> {
    public FlattenUIImage$$MethodInvoker() {
    }

    public void invoke(FlattenUIImage r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1296995794: goto L42;
            case -991382497: goto L38;
            case -893184606: goto L34;
            case -527962973: goto L30;
            case -357431021: goto L26;
            case 692239790: goto L22;
            case 1236882903: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L45;
        };
    L45:
        switch(r4) {
            case 0: goto L56;
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            default: goto L46;
        };
    L46:
        r9.invoke(new Object[]{3});
        return;
    L47:
        r6.scrollIntoView(r8, r9);
        return;
    L48:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L49:
        r6.requestUIInfo(r8, r9);
        return;
    L50:
        r6.resumeAnimation(r8, r9);
        return;
    L51:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L52:
        r6.boundingClientRect(r8, r9);
        return;
    L53:
        r6.innerText(r8, r9);
        return;
    L54:
        r6.stopAnimation(r8, r9);
        return;
    L55:
        r6.startAnimate(r8, r9);
        return;
    L56:
        r6.pauseAnimation(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L45;
        r4 = 9;
        goto L45
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L45;
        r4 = 8;
        goto L45
    L14:
        if (r7.equals("requestUIInfo") == false) goto L45;
        r4 = 7;
        goto L45
    L18:
        if (r7.equals("resumeAnimation") == false) goto L45;
        r4 = 6;
        goto L45
    L22:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L45;
        r4 = 5;
        goto L45
    L26:
        if (r7.equals("boundingClientRect") == false) goto L45;
        r4 = 4;
        goto L45
    L30:
        if (r7.equals("innerText") == false) goto L45;
        r4 = 3;
        goto L45
    L34:
        if (r7.equals("stopAnimation") == false) goto L45;
        r4 = 2;
        goto L45
    L38:
        if (r7.equals("startAnimate") == false) goto L45;
        r4 = 1;
        goto L45
    L42:
        if (r7.equals("pauseAnimation") == false) goto L45;
        r4 = 0;
        goto L45
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((FlattenUIImage) r1, r2, r3, r4);
    }
}
