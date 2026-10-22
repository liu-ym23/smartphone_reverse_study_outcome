package com.bytedance.ai.applet.render.core.webview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class EmbedWebView$$PropsSetter extends UISimpleView$.PropsSetter {
    public EmbedWebView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r10, String r11, x0 r12) {
        EmbedWebView r0 = (EmbedWebView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case 114148: goto L14;
            case 3213227: goto L10;
            case 1504731529: goto L6;
            default: goto L17;
        };
    L17:
        switch(r13) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r10, r11, r12);
        return;
    L20:
        r0.setDebug(r12.b(r11, false));
        return;
    L22:
        r0.setHtmlString(r12.h(r11));
        return;
    L24:
        r0.setSrc(r12.h(r11));
        return;
    L6:
        if (r11.equals("enable-debug") == false) goto L17;
        r13 = 2;
        goto L17
    L10:
        if (r11.equals("html") == false) goto L17;
        r13 = 1;
        goto L17
    L14:
        if (r11.equals("src") == false) goto L17;
        r13 = 0;
        goto L17
    }
}
