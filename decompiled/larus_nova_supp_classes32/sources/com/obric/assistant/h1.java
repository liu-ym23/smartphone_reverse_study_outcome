package com.obric.assistant;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r1, int r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        switch(r1.hashCode()) {
            case -2147383200: goto L45;
            case -2120344098: goto L41;
            case -1860705942: goto L38;
            case -1670871442: goto L34;
            case -263612710: goto L30;
            case -107566841: goto L27;
            case 609808309: goto L24;
            case 651570445: goto L20;
            case 953902067: goto L17;
            case 1003009595: goto L13;
            case 1306767466: goto L10;
            case 1996669219: goto L7;
            default: goto L55;
        };
    L55:
        return r2;
    L7:
        if (r1.equals("WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L56;
    L22:
        return 1;
    L56:
        return r2;
    L10:
        if (r1.equals("WAKEUP_SOURCE_BLUETOOTH") == true) goto L22;
        return r2;
    L13:
        if (r1.equals("WAKEUP_SOURCE_AUTO_MIC") == false) goto L58;
        return 2;
    L58:
        return r2;
    L17:
        if (r1.equals("WAKEUP_SOURCE_POWER_KEY_DOUBLE_PRESS") == false) goto L59;
    L43:
        return 7;
    L59:
        return r2;
    L20:
        if (r1.equals("WAKEUP_SOURCE_DORA_VOICE_WAKEUP") == true) goto L22;
        return r2;
    L24:
        if (r1.equals("WAKEUP_SOURCE_AI_KEY_DOWN") == false) goto L61;
    L36:
        return 5;
    L61:
        return r2;
    L27:
        if (r1.equals("WAKEUP_SOURCE_POWER_KEY_LONG_PRESS_SHUTDOWN_MENU") == true) goto L43;
        return r2;
    L30:
        if (r1.equals("WAKEUP_SOURCE_VOICE_ASSIST") == false) goto L63;
        return 0;
    L63:
        return r2;
    L34:
        if (r1.equals("WAKEUP_SOURCE_AI_KEY_UP") == true) goto L36;
        return r2;
    L38:
        if (r1.equals("WAKEUP_SOURCE_POWER_KEY_CLICK") == true) goto L43;
        return r2;
    L41:
        if (r1.equals("WAKEUP_SOURCE_POWER_KEY_LONG_PRESS") == true) goto L43;
        return r2;
    L45:
        if (r1.equals("WAKEUP_SOURCE_SPECIAL_INPUT") == false) goto L67;
        return 3;
    L67:
        return r2;
    }
}
