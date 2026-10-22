package com.ctc.wstx.shaded.msv.a;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(char r3) {
        if (e(r3) == false) goto L6;
        return true;
    L6:
        if (r3 != '>') goto L9;
        return false;
    L9:
        if (r3 != '.') goto L11;
    L20:
        return true;
    L11:
        if (r3 == '-') goto L20;
        if (r3 == '_') goto L20;
        if (r3 == ':') goto L20;
        if (f(r3) == true) goto L20;
        return false;
    }

    public static boolean b(char r1) {
        if (r1 != ':') goto L5;
    L7:
        return false;
    L5:
        if (a(r1) == false) goto L7;
        return true;
    }

    public static boolean c(char r4) {
        if (r4 < 'a') goto L8;
        if (r4 > 'z') goto L8;
        return true;
    L8:
        if (r4 != '/') goto L11;
        return false;
    L11:
        if (r4 >= 'A') goto L13;
    L15:
        int r1 = Character.getType(r4);
        if (r1 == 1) goto L39;
        if (r1 == 2) goto L39;
        if (r1 == 3) goto L39;
        if (r1 == 5) goto L39;
        if (r1 == 10) goto L39;
        if (r4 < 699) goto L30;
        if (r4 > 705) goto L30;
        return true;
    L30:
        if (r4 != 1369) goto L32;
        return true;
    L32:
        if (r4 != 1765) goto L34;
        return true;
    L34:
        if (r4 != 1766) goto L37;
        return true;
    L37:
        return false;
    L39:
        if (d(r4) == true) goto L46;
        if (r4 >= 8413) goto L43;
        return true;
    L43:
        if (r4 <= 8416) goto L46;
        return true;
    L46:
        return false;
    L13:
        if (r4 > 'Z') goto L15;
        return true;
    }

    private static boolean d(char r4) {
        int r0 = (r4 >> '\b') & 255;
        if (r0 == 0) goto L211;
        if (r0 == 1) goto L189;
        if (r0 == 2) goto L179;
        if (r0 == 3) goto L175;
        if (r0 == 5) goto L171;
        if (r0 == 14) goto L165;
        if (r0 == 17) goto L75;
        if (r0 == 32) goto L71;
        if (r0 == 33) goto L39;
        if (r0 == 48) goto L33;
        if (r0 == 49) goto L27;
        switch(r0) {
            case 249: goto L25;
            case 250: goto L25;
            case 251: goto L25;
            case 252: goto L25;
            case 253: goto L25;
            case 254: goto L25;
            case 255: goto L25;
            default: goto L24;
        };
    L24:
        return false;
    L25:
        return true;
    L27:
        if (r4 >= 12593) goto L29;
        return false;
    L29:
        if (r4 <= 12686) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r4 >= 12443) goto L35;
        return false;
    L35:
        if (r4 <= 12444) goto L37;
        return false;
    L37:
        return true;
    L39:
        if (r4 == 8450) goto L69;
        if (r4 == 8455) goto L69;
        if (r4 < 8458) goto L47;
        if (r4 <= 8467) goto L69;
    L47:
        if (r4 == 8469) goto L69;
        if (r4 < 8472) goto L53;
        if (r4 <= 8477) goto L69;
    L53:
        if (r4 == 8484) goto L69;
        if (r4 == 8488) goto L69;
        if (r4 < 8492) goto L61;
        if (r4 <= 8493) goto L69;
    L61:
        if (r4 < 8495) goto L65;
        if (r4 <= 8504) goto L69;
    L65:
        if (r4 >= 8544) goto L67;
        return false;
    L67:
        if (r4 <= 8575) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (r4 == 8319) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (r4 == 4353) goto L163;
        if (r4 == 4356) goto L163;
        if (r4 == 4360) goto L163;
        if (r4 == 4362) goto L163;
        if (r4 == 4365) goto L163;
        if (r4 < 4371) goto L89;
        if (r4 <= 4411) goto L163;
    L89:
        if (r4 == 4413) goto L163;
        if (r4 == 4415) goto L163;
        if (r4 < 4417) goto L97;
        if (r4 <= 4427) goto L163;
    L97:
        if (r4 == 4429) goto L163;
        if (r4 == 4431) goto L163;
        if (r4 < 4433) goto L105;
        if (r4 <= 4435) goto L163;
    L105:
        if (r4 < 4438) goto L109;
        if (r4 <= 4440) goto L163;
    L109:
        if (r4 == 4450) goto L163;
        if (r4 == 4452) goto L163;
        if (r4 == 4454) goto L163;
        if (r4 == 4456) goto L163;
        if (r4 < 4458) goto L121;
        if (r4 <= 4460) goto L163;
    L121:
        if (r4 < 4463) goto L125;
        if (r4 <= 4465) goto L163;
    L125:
        if (r4 == 4468) goto L163;
        if (r4 < 4470) goto L131;
        if (r4 <= 4509) goto L163;
    L131:
        if (r4 < 4511) goto L135;
        if (r4 <= 4514) goto L163;
    L135:
        if (r4 < 4521) goto L139;
        if (r4 <= 4522) goto L163;
    L139:
        if (r4 < 4524) goto L143;
        if (r4 <= 4525) goto L163;
    L143:
        if (r4 < 4528) goto L147;
        if (r4 <= 4534) goto L163;
    L147:
        if (r4 == 4537) goto L163;
        if (r4 == 4539) goto L163;
        if (r4 < 4547) goto L155;
        if (r4 <= 4586) goto L163;
    L155:
        if (r4 < 4588) goto L159;
        if (r4 <= 4591) goto L163;
    L159:
        if (r4 >= 4593) goto L161;
        return false;
    L161:
        if (r4 <= 4600) goto L163;
        return false;
    L163:
        return true;
    L165:
        if (r4 >= 3804) goto L167;
        return false;
    L167:
        if (r4 <= 3805) goto L169;
        return false;
    L169:
        return true;
    L171:
        if (r4 == 1415) goto L173;
        return false;
    L173:
        return true;
    L175:
        if (r4 == 890) goto L177;
        return false;
    L177:
        return true;
    L179:
        if (r4 < 688) goto L183;
        if (r4 > 696) goto L183;
    L187:
        return true;
    L183:
        if (r4 >= 736) goto L185;
        return false;
    L185:
        if (r4 <= 740) goto L187;
        return false;
    L189:
        if (r4 < 306) goto L193;
        if (r4 > 307) goto L193;
    L209:
        return true;
    L193:
        if (r4 < 319) goto L197;
        if (r4 <= 320) goto L209;
    L197:
        if (r4 == 329) goto L209;
        if (r4 == 383) goto L209;
        if (r4 < 452) goto L205;
        if (r4 <= 460) goto L209;
    L205:
        if (r4 >= 497) goto L207;
        return false;
    L207:
        if (r4 <= 499) goto L209;
        return false;
    L211:
        if (r4 == 170) goto L217;
        if (r4 == 181) goto L217;
        if (r4 == 186) goto L217;
        return false;
    L217:
        return true;
    }

    private static boolean e(char r4) {
        if (r4 < 'a') goto L8;
        if (r4 > 'z') goto L8;
        return true;
    L8:
        if (r4 != '>') goto L11;
        return false;
    L11:
        if (r4 >= 'A') goto L13;
    L15:
        int r1 = Character.getType(r4);
        if (r1 == 16) goto L35;
        switch(r1) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L26;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L26;
            case 8: goto L26;
            case 9: goto L26;
            case 10: goto L26;
            default: goto L19;
        };
    L19:
        if (r4 != 903) goto L21;
        return true;
    L21:
        if (r4 != 8494) goto L24;
        return true;
    L24:
        return false;
    L26:
        if (d(r4) == true) goto L33;
        if (r4 >= 8413) goto L30;
        return true;
    L30:
        if (r4 <= 8416) goto L33;
        return true;
    L33:
        return false;
    L35:
        if (r4 != 1757) goto L38;
        return true;
    L38:
        return false;
    L13:
        if (r4 > 'Z') goto L15;
        return true;
    }

    private static boolean f(char r1) {
        if (r1 != 183) goto L5;
    L32:
        return true;
    L5:
        if (r1 == 720) goto L32;
        if (r1 == 721) goto L32;
        if (r1 == 903) goto L32;
        if (r1 == 1600) goto L32;
        if (r1 == 3654) goto L32;
        if (r1 == 3782) goto L32;
        if (r1 == 12293) goto L32;
        if (r1 < 12337) goto L23;
        if (r1 <= 12341) goto L32;
    L23:
        if (r1 < 12445) goto L27;
        if (r1 <= 12446) goto L32;
    L27:
        if (r1 >= 12540) goto L29;
    L31:
        return false;
    L29:
        if (r1 > 12542) goto L31;
        goto L31
    }
}
