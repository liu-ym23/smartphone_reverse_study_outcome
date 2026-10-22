package com.obric.miniapp.lynx;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LynxOUIDatePickerViewUI$$PropsSetter extends LynxUI$.PropsSetter {
    public LynxOUIDatePickerViewUI$$PropsSetter() {
    }

    public void setProperty(LynxBaseUI r5, String r6, com.lynx.tasm.behavior.x0 r7) {
        LynxOUIDatePickerViewUI r0 = (LynxOUIDatePickerViewUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1693353237: goto L70;
            case -1278569099: goto L66;
            case -1249474914: goto L62;
            case -1221029593: goto L58;
            case -948681800: goto L54;
            case -858560584: goto L50;
            case -655379712: goto L46;
            case -315206725: goto L42;
            case -133587431: goto L38;
            case -90854392: goto L34;
            case 3076014: goto L30;
            case 3357091: goto L26;
            case 696975130: goto L22;
            case 843626290: goto L18;
            case 1055252361: goto L14;
            case 1063424288: goto L10;
            case 1458020480: goto L6;
            default: goto L73;
        };
    L73:
        Integer r1 = null;
        Boolean r2 = null;
        Integer r4 = null;
        Integer r8 = null;
        Integer r9 = null;
        Integer r10 = null;
        Integer r11 = null;
        Integer r12 = null;
        Integer r13 = null;
        Integer r14 = null;
        Integer r15 = null;
        switch(r3) {
            case 0: goto L150;
            case 1: goto L144;
            case 2: goto L141;
            case 3: goto L136;
            case 4: goto L130;
            case 5: goto L124;
            case 6: goto L118;
            case 7: goto L112;
            case 8: goto L106;
            case 9: goto L100;
            case 10: goto L97;
            case 11: goto L95;
            case 12: goto L93;
            case 13: goto L91;
            case 14: goto L86;
            case 15: goto L83;
            case 16: goto L78;
            default: goto L75;
        };
    L75:
        super.setProperty(r5, r6, r7);
        return;
    L83:
        r0.setMinDate(r7.h(r6));
        return;
    L91:
        r0.setMaxDate(r7.h(r6));
        return;
    L93:
        r0.setPresentation(r7.h(r6));
        return;
    L95:
        r0.setMode(r7.h(r6));
        return;
    L97:
        r0.setDate(r7.h(r6));
        return;
    L141:
        r0.setOptions(r7.h(r6));
        return;
    L78:
        if (r7.k(r6) == true) goto L81;
        r2 = Boolean.valueOf(r7.b(r6, false));
    L81:
        r0.setClipToBounds(r2);
        return;
    L86:
        if (r7.k(r6) == true) goto L89;
        r4 = Integer.valueOf(r7.f(r6, 0));
    L89:
        r0.setTileHSpacing(r4);
        return;
    L100:
        if (r7.k(r6) == true) goto L103;
        r8 = Integer.valueOf(r7.f(r6, 0));
    L103:
        r0.setHeaderPaddingHorizontal(r8);
        return;
    L106:
        if (r7.k(r6) == true) goto L109;
        r9 = Integer.valueOf(r7.f(r6, 0));
    L109:
        r0.setMinHeight(r9);
        return;
    L112:
        if (r7.k(r6) == true) goto L115;
        r10 = Integer.valueOf(r7.f(r6, 0));
    L115:
        r0.setTileVSpacing(r10);
        return;
    L118:
        if (r7.k(r6) == true) goto L121;
        r11 = Integer.valueOf(r7.f(r6, 0));
    L121:
        r0.setContentHeight(r11);
        return;
    L124:
        if (r7.k(r6) == true) goto L127;
        r12 = Integer.valueOf(r7.f(r6, 0));
    L127:
        r0.setTileWidth(r12);
        return;
    L130:
        if (r7.k(r6) == true) goto L133;
        r13 = Integer.valueOf(r7.f(r6, 0));
    L133:
        r0.setHeaderPaddingRight(r13);
        return;
    L136:
        if (r7.k(r6) == true) goto L139;
        r14 = Integer.valueOf(r7.f(r6, 0));
    L139:
        r0.setHeight(r14);
        return;
    L144:
        if (r7.k(r6) == true) goto L147;
        r15 = Integer.valueOf(r7.f(r6, 0));
    L147:
        r0.setTileHeight(r15);
        return;
    L150:
        if (r7.k(r6) == true) goto L153;
        r1 = Integer.valueOf(r7.f(r6, 0));
    L153:
        r0.setHeaderPaddingLeft(r1);
        return;
    L6:
        if (r6.equals("clipToBounds") == false) goto L73;
        r3 = 16;
        goto L73
    L10:
        if (r6.equals("minDate") == false) goto L73;
        r3 = 15;
        goto L73
    L14:
        if (r6.equals("tileHSpacing") == false) goto L73;
        r3 = 14;
        goto L73
    L18:
        if (r6.equals("maxDate") == false) goto L73;
        r3 = 13;
        goto L73
    L22:
        if (r6.equals("presentation") == false) goto L73;
        r3 = 12;
        goto L73
    L26:
        if (r6.equals("mode") == false) goto L73;
        r3 = 11;
        goto L73
    L30:
        if (r6.equals("date") == false) goto L73;
        r3 = 10;
        goto L73
    L34:
        if (r6.equals("headerPaddingHorizontal") == false) goto L73;
        r3 = 9;
        goto L73
    L38:
        if (r6.equals("minHeight") == false) goto L73;
        r3 = 8;
        goto L73
    L42:
        if (r6.equals("tileVSpacing") == false) goto L73;
        r3 = 7;
        goto L73
    L46:
        if (r6.equals("contentHeight") == false) goto L73;
        r3 = 6;
        goto L73
    L50:
        if (r6.equals("tileWidth") == false) goto L73;
        r3 = 5;
        goto L73
    L54:
        if (r6.equals("headerPaddingRight") == false) goto L73;
        r3 = 4;
        goto L73
    L58:
        if (r6.equals("height") == false) goto L73;
        r3 = 3;
        goto L73
    L62:
        if (r6.equals("options") == false) goto L73;
        r3 = 2;
        goto L73
    L66:
        if (r6.equals("tileHeight") == false) goto L73;
        r3 = 1;
        goto L73
    L70:
        if (r6.equals("headerPaddingLeft") == false) goto L73;
        r3 = 0;
        goto L73
    }
}
