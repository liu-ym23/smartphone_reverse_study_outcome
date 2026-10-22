package com.larus.profile.impl.relaxedit.input;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class LynxUIInputLit$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxUIInputLit$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        LynxUIInputLit r0 = (LynxUIInputLit) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -866730430: goto L50;
            case -669817125: goto L46;
            case -112785691: goto L42;
            case 3575610: goto L38;
            case 94842723: goto L34;
            case 124732746: goto L30;
            case 270940796: goto L26;
            case 598246771: goto L22;
            case 746232421: goto L18;
            case 1736600384: goto L14;
            case 2018420361: goto L10;
            case 2051146279: goto L6;
            default: goto L53;
        };
    L53:
        switch(r4) {
            case 0: goto L78;
            case 1: goto L76;
            case 2: goto L74;
            case 3: goto L72;
            case 4: goto L70;
            case 5: goto L68;
            case 6: goto L66;
            case 7: goto L64;
            case 8: goto L62;
            case 9: goto L60;
            case 10: goto L58;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        super.setProperty(r6, r7, r8);
        return;
    L56:
        r0.setConfirmType(r8.h(r7));
        return;
    L58:
        r0.setPlaceholderColor(r8.d(r7));
        return;
    L60:
        r0.setShowSoftInputOnFocus(r8.b(r7, true));
        return;
    L62:
        r0.setTextAlign(r8.f(r7, 0));
        return;
    L64:
        r0.setPlaceholder(r8.h(r7));
        return;
    L66:
        r0.setDisabled(r8.b(r7, false));
        return;
    L68:
        r0.setMaxLength(r8.d(r7));
        return;
    L70:
        r0.setTextColor(r8.d(r7));
        return;
    L72:
        r0.setInputType(r8.h(r7));
        return;
    L74:
        r0.setDefaultValue(r8.h(r7));
        return;
    L76:
        r0.setInputFilter(r8.h(r7));
        return;
    L78:
        r0.setReadOnly(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("confirm-type") == false) goto L53;
        r4 = 11;
        goto L53
    L10:
        if (r7.equals("placeholder-color") == false) goto L53;
        r4 = 10;
        goto L53
    L14:
        if (r7.equals("show-soft-input-on-focus") == false) goto L53;
        r4 = 9;
        goto L53
    L18:
        if (r7.equals("text-align") == false) goto L53;
        r4 = 8;
        goto L53
    L22:
        if (r7.equals("placeholder") == false) goto L53;
        r4 = 7;
        goto L53
    L26:
        if (r7.equals("disabled") == false) goto L53;
        r4 = 6;
        goto L53
    L30:
        if (r7.equals("maxlength") == false) goto L53;
        r4 = 5;
        goto L53
    L34:
        if (r7.equals("color") == false) goto L53;
        r4 = 4;
        goto L53
    L38:
        if (r7.equals("type") == false) goto L53;
        r4 = 3;
        goto L53
    L42:
        if (r7.equals("default-value") == false) goto L53;
        r4 = 2;
        goto L53
    L46:
        if (r7.equals("input-filter") == false) goto L53;
        r4 = 1;
        goto L53
    L50:
        if (r7.equals("readonly") == false) goto L53;
        r4 = 0;
        goto L53
    }
}
