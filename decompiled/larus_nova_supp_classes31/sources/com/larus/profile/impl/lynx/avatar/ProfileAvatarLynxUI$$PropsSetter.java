package com.larus.profile.impl.lynx.avatar;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class ProfileAvatarLynxUI$$PropsSetter extends LynxUI$.PropsSetter {
    public ProfileAvatarLynxUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        ProfileAvatarLynxUI r0 = (ProfileAvatarLynxUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1666750992: goto L30;
            case -858429790: goto L26;
            case -737956838: goto L22;
            case -428646058: goto L18;
            case -403193606: goto L14;
            case 801287365: goto L10;
            case 1602416228: goto L6;
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
        r0.setEditableProp(r7.b(r6, false));
        return;
    L38:
        r0.setEnablePreviewProp(r7.b(r6, false));
        return;
    L40:
        r0.setAvatarSizeProp(r7.f(r6, 0));
        return;
    L42:
        r0.setAvatarUrlProp(r7.h(r6));
        return;
    L44:
        r0.setIconSizeProp(r7.f(r6, 0));
        return;
    L46:
        r0.setEnterFromProp(r7.h(r6));
        return;
    L48:
        r0.setIsDefaultAvatarProp(r7.b(r6, false));
        return;
    L6:
        if (r6.equals("editable") == false) goto L33;
        r3 = 6;
        goto L33
    L10:
        if (r6.equals("enablePreview") == false) goto L33;
        r3 = 5;
        goto L33
    L14:
        if (r6.equals("avatarSize") == false) goto L33;
        r3 = 4;
        goto L33
    L18:
        if (r6.equals("avatarUrl") == false) goto L33;
        r3 = 3;
        goto L33
    L22:
        if (r6.equals("iconSize") == false) goto L33;
        r3 = 2;
        goto L33
    L26:
        if (r6.equals("enterFrom") == false) goto L33;
        r3 = 1;
        goto L33
    L30:
        if (r6.equals("isDefaultAvatar") == false) goto L33;
        r3 = 0;
        goto L33
    }
}
