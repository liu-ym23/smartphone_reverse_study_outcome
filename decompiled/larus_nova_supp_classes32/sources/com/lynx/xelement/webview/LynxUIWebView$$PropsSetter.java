package com.lynx.xelement.webview;

import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIWebView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxUIWebView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        LynxUIWebView r0 = (LynxUIWebView) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -995427962: goto L22;
            case 114148: goto L18;
            case 3213227: goto L14;
            case 1504731529: goto L10;
            case 1969817742: goto L6;
            default: goto L25;
        };
    L25:
        switch(r3) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        super.setProperty(r5, r6, r7);
        return;
    L28:
        r0.setWebViewType(r7.h(r6));
        return;
    L30:
        r0.setDebug(r7.b(r6, false));
        return;
    L32:
        r0.setHtmlString(r7.h(r6));
        return;
    L34:
        r0.setSrc(r7.h(r6));
        return;
    L36:
        r0.setParams(r7.g(r6));
        return;
    L6:
        if (r6.equals("webview-type") == false) goto L25;
        r3 = 4;
        goto L25
    L10:
        if (r6.equals("enable-debug") == false) goto L25;
        r3 = 3;
        goto L25
    L14:
        if (r6.equals("html") == false) goto L25;
        r3 = 2;
        goto L25
    L18:
        if (r6.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L25;
        r3 = 1;
        goto L25
    L22:
        if (r6.equals(LynxResourceModule.PARAMS_KEY) == false) goto L25;
        r3 = 0;
        goto L25
    }
}
