package com.lynx.tasm.behavior.ui.text;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIText$$PropsSetter extends UIGroup$$PropsSetter {
    public UIText$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        UIText r0 = (UIText) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1157887457: goto L30;
            case -1145258555: goto L26;
            case 263767276: goto L22;
            case 298809032: goto L18;
            case 315007413: goto L14;
            case 543207321: goto L10;
            case 1137695781: goto L6;
            default: goto L33;
        };
    L33:
        switch(r3) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        super.setProperty(r5, r6, r7);
        return;
    L36:
        r0.setSelectionBackgroundColor(r7.f(r6, 0));
        return;
    L38:
        r0.setCustomContextMenu(r7.b(r6, false));
        return;
    L40:
        r0.setAccessibilityLabel(r7.d(r6));
        return;
    L42:
        r0.setCustomTextSelection(r7.b(r6, false));
        return;
    L44:
        r0.setEnableTextSelection(r7.b(r6, false));
        return;
    L46:
        r0.setSelectionHandleSize(r7.f(r6, 0));
        return;
    L48:
        r0.setSelectionHandleColor(r7.f(r6, 0));
        return;
    L6:
        if (r6.equals("selection-background-color") == false) goto L33;
        r3 = 6;
        goto L33
    L10:
        if (r6.equals("custom-context-menu") == false) goto L33;
        r3 = 5;
        goto L33
    L14:
        if (r6.equals("accessibility-label") == false) goto L33;
        r3 = 4;
        goto L33
    L18:
        if (r6.equals("custom-text-selection") == false) goto L33;
        r3 = 3;
        goto L33
    L22:
        if (r6.equals("text-selection") == false) goto L33;
        r3 = 2;
        goto L33
    L26:
        if (r6.equals("selection-handle-size") == false) goto L33;
        r3 = 1;
        goto L33
    L30:
        if (r6.equals("selection-handle-color") == false) goto L33;
        r3 = 0;
        goto L33
    }
}
