package com.obric.cae.smartNfc;

import android.aimedia.a;
import android.nfc.NfcRoutingTableEntry;
import android.nfc.RoutingTableAidEntry;
import android.nfc.RoutingTableProtocolEntry;
import android.nfc.RoutingTableSystemCodeEntry;
import android.nfc.RoutingTableTechnologyEntry;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes2.dex */
final class NfcRoutingUtils {
    private NfcRoutingUtils() {
    }

    private static void appendField(StringBuilder r8, String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (r8.charAt(r8.length() - 1) == '{') goto L8;
        r8.append(", ");
    L8:
        r8.append(r10);
        r8.append("=");
        r8.append(r11);
    }

    private static String bytesToHex(byte[] r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.length == 0) goto L15;
        char[] r10 = "0123456789ABCDEF".toCharArray();
        char[] r11 = new char[r8.length * 2];
        int r12 = 0;
    L8:
        if (r12 >= r8.length) goto L11;
        int r13 = r8[r12] & 255;
        int r14 = r12 * 2;
        r11[r14] = r10[r13 >>> 4];
        r11[r14 + 1] = r10[r13 & 15];
        r12 = r12 + 1;
        goto L8
    L11:
        return new String(r11);
    L15:
        return "";
    }

    private static String formatByte(int r8) {
        return "0x" + Integer.toHexString(r8 & 255);
    }

    public static String formatEntry(int r8, NfcRoutingTableEntry r10) {
        if (r10 == null) goto L4;
        StringBuilder r11 = new StringBuilder();
        r11.append(r8);
        r11.append(": ");
        r11.append(r10.getClass().getSimpleName());
        r11.append(" {");
        appendField(r11, "type", formatHex(r10.getType()));
        if ((r10 instanceof RoutingTableAidEntry) == false) goto L10;
        String r12 = ((RoutingTableAidEntry) r10).getAid();
        String r13 = WsConstants.KEY_APP_ID;
    L8:
        appendField(r11, r13, r12);
    L18:
        appendField(r11, "routeType", formatHex(r10.getRouteType()));
        appendField(r11, "nfceeId", formatByte(r10.getNfceeId()));
        r11.append("}");
        return r11.toString();
    L10:
        if ((r10 instanceof RoutingTableSystemCodeEntry) == false) goto L13;
        r12 = bytesToHex(((RoutingTableSystemCodeEntry) r10).getSystemCode());
        r13 = "systemCode";
        goto L8
    L13:
        if ((r10 instanceof RoutingTableProtocolEntry) == false) goto L16;
        r12 = formatHex(((RoutingTableProtocolEntry) r10).getProtocol());
        r13 = "protocol";
        goto L8
    L16:
        if ((r10 instanceof RoutingTableTechnologyEntry) == false) goto L18;
        r12 = formatHex(((RoutingTableTechnologyEntry) r10).getTechnology());
        r13 = "technology";
        goto L8
    L4:
        return r8 + ": null";
    }

    private static String formatHex(int r8) {
        return "0x" + Integer.toHexString(r8);
    }

    public static String getLegend() {
        return "Legend: type{0=AID,1=PROTOCOL,2=TECHNOLOGY,3=SYSTEM_CODE} tech{0=A,1=B,2=F,3=V} protocol{0=UNDET,1=T1T,2=T2T,3=T3T,4=ISO_DEP,5=NFC_DEP,6=T5T,7=NDEF} routeType{0=DH,1=eSE,2=UICC,3=DEFAULT,4=NDEF_NFCEE,-1=UNSET}";
    }

    public static int routeNameToSeId(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return Integer.MIN_VALUE;
    L5:
        String r10 = r8.toLowerCase();
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case 100727: goto L37;
            case 103114: goto L33;
            case 113879: goto L29;
            case 3208616: goto L25;
            case 3376343: goto L21;
            case 3589620: goto L17;
            case 1155814165: goto L13;
            case 1544803905: goto L9;
            default: goto L40;
        };
    L40:
        switch(r11) {
            case 0: goto L46;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L42;
            default: goto L41;
        };
    L41:
        return Integer.MIN_VALUE;
    L42:
        return 0;
    L43:
        return 4;
    L44:
        return 2;
    L45:
        return 0;
    L46:
        return 1;
    L9:
        if (r10.equals("default") == false) goto L40;
        r11 = 7;
        goto L40
    L13:
        if (r10.equals("ndef-nfcee") == false) goto L40;
        r11 = 6;
        goto L40
    L17:
        if (r10.equals("uicc") == false) goto L40;
        r11 = 5;
        goto L40
    L21:
        if (r10.equals("ndef") == false) goto L40;
        r11 = 4;
        goto L40
    L25:
        if (r10.equals("host") == false) goto L40;
        r11 = 3;
        goto L40
    L29:
        if (r10.equals("sim") == false) goto L40;
        r11 = 2;
        goto L40
    L33:
        if (r10.equals("hce") == false) goto L40;
        r11 = 1;
        goto L40
    L37:
        if (r10.equals("ese") == false) goto L40;
        r11 = 0;
        goto L40
    }

    public static String routeToName(int r8) {
        if (r8 == (-1)) goto L25;
        if (r8 != 0) goto L6;
        return "DH";
    L6:
        if (r8 != 1) goto L8;
        return "ESE";
    L8:
        if (r8 != 2) goto L10;
        return "UICC";
    L10:
        if (r8 != 3) goto L12;
        return "DEFAULT";
    L12:
        if (r8 != 4) goto L14;
        return "NDEF";
    L14:
        return a.c("UNKNOWN(", r8, ")");
    L25:
        return "UNSET";
    }

    public static String seIdToName(int r8) {
        if (r8 != Integer.MIN_VALUE) goto L5;
        return "UNSET";
    L5:
        if (r8 == 4) goto L19;
        if (r8 != 0) goto L8;
        return "HCE";
    L8:
        if (r8 != 1) goto L10;
        return "ESE";
    L10:
        if (r8 != 2) goto L12;
        return "UICC";
    L12:
        return a.c("UNKNOWN(", r8, ")");
    L19:
        return "NDEF";
    }

    public static int seIdToRoute(int r8) {
        if (r8 == 0) goto L12;
        int r10 = 1;
        if (r8 == 1) goto L11;
        r10 = 2;
        if (r8 == 2) goto L11;
        r10 = 4;
        if (r8 == 4) goto L11;
        return -1;
    L11:
        return r10;
    L12:
        return 0;
    }
}
