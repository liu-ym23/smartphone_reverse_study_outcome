package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxOUIBasicButtonFloatingUI$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxOUIBasicButtonFloatingUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r5, String r6, com.lynx.tasm.behavior.x0 r7) {
        LynxOUIBasicButtonFloatingUI r0 = (LynxOUIBasicButtonFloatingUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1402875678: goto L58;
            case -1398151987: goto L54;
            case -1249474914: goto L50;
            case -980098337: goto L46;
            case -826033408: goto L42;
            case -738113884: goto L38;
            case -737956838: goto L34;
            case -409059990: goto L30;
            case -102886596: goto L26;
            case 3226745: goto L22;
            case 236785797: goto L18;
            case 270940796: goto L14;
            case 456353938: goto L10;
            case 861554865: goto L6;
            default: goto L61;
        };
    L61:
        switch(r3) {
            case 0: goto L90;
            case 1: goto L88;
            case 2: goto L86;
            case 3: goto L84;
            case 4: goto L82;
            case 5: goto L80;
            case 6: goto L78;
            case 7: goto L76;
            case 8: goto L74;
            case 9: goto L72;
            case 10: goto L70;
            case 11: goto L68;
            case 12: goto L66;
            case 13: goto L64;
            default: goto L62;
        };
    L62:
        super.setProperty(r5, r6, r7);
        return;
    L64:
        r0.setButtonPreset(r7.h(r6));
        return;
    L66:
        r0.setIconResName(r7.h(r6));
        return;
    L68:
        r0.setDisabled(r7.b(r6, false));
        return;
    L70:
        r0.setVariant(r7.h(r6));
        return;
    L72:
        r0.setIcon(r7.h(r6));
        return;
    L74:
        r0.setBuiltinIcon(r7.h(r6));
        return;
    L76:
        r0.setIconBuiltin(r7.h(r6));
        return;
    L78:
        r0.setIconSize(r7.h(r6));
        return;
    L80:
        r0.setIconName(r7.h(r6));
        return;
    L82:
        r0.setIconHeight(r7.h(r6));
        return;
    L84:
        r0.setPreset(r7.h(r6));
        return;
    L86:
        r0.setOptions(r7.h(r6));
        return;
    L88:
        r0.setIconWidth(r7.h(r6));
        return;
    L90:
        r0.setIconResId(r7.f(r6, 0));
        return;
    L6:
        if (r6.equals("buttonPreset") == false) goto L61;
        r3 = 13;
        goto L61
    L10:
        if (r6.equals("iconResName") == false) goto L61;
        r3 = 12;
        goto L61
    L14:
        if (r6.equals("disabled") == false) goto L61;
        r3 = 11;
        goto L61
    L18:
        if (r6.equals("variant") == false) goto L61;
        r3 = 10;
        goto L61
    L22:
        if (r6.equals("icon") == false) goto L61;
        r3 = 9;
        goto L61
    L26:
        if (r6.equals("builtinIcon") == false) goto L61;
        r3 = 8;
        goto L61
    L30:
        if (r6.equals("iconBuiltin") == false) goto L61;
        r3 = 7;
        goto L61
    L34:
        if (r6.equals("iconSize") == false) goto L61;
        r3 = 6;
        goto L61
    L38:
        if (r6.equals("iconName") == false) goto L61;
        r3 = 5;
        goto L61
    L42:
        if (r6.equals("iconHeight") == false) goto L61;
        r3 = 4;
        goto L61
    L46:
        if (r6.equals("preset") == false) goto L61;
        r3 = 3;
        goto L61
    L50:
        if (r6.equals("options") == false) goto L61;
        r3 = 2;
        goto L61
    L54:
        if (r6.equals("iconWidth") == false) goto L61;
        r3 = 1;
        goto L61
    L58:
        if (r6.equals("iconResId") == false) goto L61;
        r3 = 0;
        goto L61
    }
}
