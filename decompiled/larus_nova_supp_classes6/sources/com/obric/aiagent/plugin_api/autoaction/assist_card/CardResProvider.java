package com.obric.aiagent.plugin_api.autoaction.assist_card;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CardResProvider {
    public CardResProvider() {
    }

    public static int getLayoutRes() {
        return 2131558728;
    }

    public static int getIdRes(String r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -1116306093: goto L65;
            case 2521314: goto L61;
            case 63532782: goto L57;
            case 63532783: goto L53;
            case 63532784: goto L49;
            case 332973724: goto L45;
            case 1114219306: goto L41;
            case 1114549214: goto L37;
            case 1142848457: goto L33;
            case 1143178365: goto L29;
            case 1171477608: goto L25;
            case 1171807516: goto L21;
            case 1290981542: goto L17;
            case 1291311450: goto L13;
            case 1979680759: goto L9;
            default: goto L68;
        };
    L68:
        switch(r2) {
            case 0: goto L98;
            case 1: goto L96;
            case 2: goto L94;
            case 3: goto L92;
            case 4: goto L90;
            case 5: goto L88;
            case 6: goto L86;
            case 7: goto L84;
            case 8: goto L82;
            case 9: goto L80;
            case 10: goto L78;
            case 11: goto L76;
            case 12: goto L74;
            case 13: goto L72;
            case 14: goto L70;
            default: goto L69;
        };
    L69:
        return 0;
    L70:
        return 2131363269;
    L72:
        return 2131363283;
    L74:
        return 2131363282;
    L76:
        return 2131363278;
    L78:
        return 2131363277;
    L80:
        return 2131363275;
    L82:
        return 2131363274;
    L84:
        return 2131363272;
    L86:
        return 2131363271;
    L88:
        return 2131363279;
    L90:
        return 2131363276;
    L92:
        return 2131363273;
    L94:
        return 2131363270;
    L96:
        return 2131363281;
    L98:
        return 2131363280;
    L9:
        if (r3.equals("APP_ICON") == false) goto L68;
        r2 = 14;
        goto L68
    L13:
        if (r3.equals("STATUS_TEXT") == false) goto L68;
        r2 = 13;
        goto L68
    L17:
        if (r3.equals("STATUS_ICON") == false) goto L68;
        r2 = 12;
        goto L68
    L21:
        if (r3.equals("BTN_3_TEXT") == false) goto L68;
        r2 = 11;
        goto L68
    L25:
        if (r3.equals("BTN_3_ICON") == false) goto L68;
        r2 = 10;
        goto L68
    L29:
        if (r3.equals("BTN_2_TEXT") == false) goto L68;
        r2 = 9;
        goto L68
    L33:
        if (r3.equals("BTN_2_ICON") == false) goto L68;
        r2 = 8;
        goto L68
    L37:
        if (r3.equals("BTN_1_TEXT") == false) goto L68;
        r2 = 7;
        goto L68
    L41:
        if (r3.equals("BTN_1_ICON") == false) goto L68;
        r2 = 6;
        goto L68
    L45:
        if (r3.equals("BTN_GROUP") == false) goto L68;
        r2 = 5;
        goto L68
    L49:
        if (r3.equals("BTN_3") == false) goto L68;
        r2 = 4;
        goto L68
    L53:
        if (r3.equals("BTN_2") == false) goto L68;
        r2 = 3;
        goto L68
    L57:
        if (r3.equals("BTN_1") == false) goto L68;
        r2 = 2;
        goto L68
    L61:
        if (r3.equals("ROOT") == false) goto L68;
        r2 = 1;
        goto L68
    L65:
        if (r3.equals("CONTENT_TEXT") == false) goto L68;
        r2 = 0;
        goto L68
    }

    public static int getBackgroundRes(String r3, boolean r4) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -2032180703: goto L37;
            case -1149187101: goto L33;
            case -744169569: goto L29;
            case -368591510: goto L25;
            case 2196191: goto L21;
            case 75902422: goto L17;
            case 1571564098: goto L13;
            case 1980572282: goto L9;
            default: goto L40;
        };
    L40:
        switch(r2) {
            case 0: goto L68;
            case 1: goto L64;
            case 2: goto L62;
            case 3: goto L58;
            case 4: goto L54;
            case 5: goto L50;
            case 6: goto L46;
            case 7: goto L42;
            default: goto L41;
        };
    L41:
        return 0;
    L42:
        if (r4 == false) goto L44;
        return 2131231725;
    L44:
        return 2131231724;
    L46:
        if (r4 == false) goto L48;
        return 2131231727;
    L48:
        return 2131231726;
    L50:
        if (r4 == false) goto L52;
        return 2131231733;
    L52:
        return 2131231732;
    L54:
        if (r4 == false) goto L56;
        return 2131231723;
    L56:
        return 2131231722;
    L58:
        if (r4 == false) goto L60;
        return 2131231731;
    L60:
        return 2131231730;
    L62:
        return 2131231899;
    L64:
        if (r4 == false) goto L66;
        return 2131231735;
    L66:
        return 2131231734;
    L68:
        if (r4 == false) goto L70;
        return 2131231729;
    L70:
        return 2131231728;
    L9:
        if (r3.equals("CANCEL") == false) goto L40;
        r2 = 7;
        goto L40
    L13:
        if (r3.equals("CLARIFY") == false) goto L40;
        r2 = 6;
        goto L40
    L17:
        if (r3.equals("PAUSE") == false) goto L40;
        r2 = 5;
        goto L40
    L21:
        if (r3.equals("GREY") == false) goto L40;
        r2 = 4;
        goto L40
    L25:
        if (r3.equals("FAILURE") == false) goto L40;
        r2 = 3;
        goto L40
    L29:
        if (r3.equals("GRADIENT_ROUND") == false) goto L40;
        r2 = 2;
        goto L40
    L33:
        if (r3.equals("SUCCESS") == false) goto L40;
        r2 = 1;
        goto L40
    L37:
        if (r3.equals("DEFAULT") == false) goto L40;
        r2 = 0;
        goto L40
    }

    public static int getIconRes(String r3, boolean r4) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -2107065985: goto L33;
            case -1764795109: goto L29;
            case -1109051467: goto L25;
            case 2555906: goto L21;
            case 2571565: goto L17;
            case 900418722: goto L13;
            case 1803427515: goto L9;
            default: goto L36;
        };
    L36:
        switch(r2) {
            case 0: goto L62;
            case 1: goto L58;
            case 2: goto L54;
            case 3: goto L50;
            case 4: goto L46;
            case 5: goto L42;
            case 6: goto L38;
            default: goto L37;
        };
    L37:
        return 0;
    L38:
        if (r4 == false) goto L40;
        return 2131244882;
    L40:
        return 2131244880;
    L42:
        if (r4 == false) goto L44;
        return 2131245281;
    L44:
        return 2131245280;
    L46:
        if (r4 == false) goto L48;
        return 2131245778;
    L48:
        return 2131245768;
    L50:
        if (r4 == false) goto L52;
        return 2131245730;
    L52:
        return 2131245729;
    L54:
        if (r4 == false) goto L56;
        return 2131245060;
    L56:
        return 2131245059;
    L58:
        if (r4 == false) goto L60;
        return 2131245793;
    L60:
        return 2131245790;
    L62:
        if (r4 == false) goto L64;
        return 2131245188;
    L64:
        return 2131245187;
    L9:
        if (r3.equals("REFRESH") == false) goto L36;
        r2 = 6;
        goto L36
    L13:
        if (r3.equals("LEFT_HAND_AI_FILL") == false) goto L36;
        r2 = 5;
        goto L36
    L17:
        if (r3.equals("TEXT") == false) goto L36;
        r2 = 4;
        goto L36
    L21:
        if (r3.equals("STOP") == false) goto L36;
        r2 = 3;
        goto L36
    L25:
        if (r3.equals("CHECKMARK") == false) goto L36;
        r2 = 2;
        goto L36
    L29:
        if (r3.equals("TIME_LAPSE") == false) goto L36;
        r2 = 1;
        goto L36
    L33:
        if (r3.equals("EXCLAMATION_MARK") == false) goto L36;
        r2 = 0;
        goto L36
    }

    public static int getResId(Context r1, String r2, String r3) {
        return r1.getResources().getIdentifier(r2, r3, r1.getPackageName());
    }
}
