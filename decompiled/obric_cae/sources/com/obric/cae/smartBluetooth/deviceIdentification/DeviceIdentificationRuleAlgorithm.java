package com.obric.cae.smartBluetooth.deviceIdentification;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.btaware.SmartBluetoothEBikeAware;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BluetoothDeviceIdentificationModel;

/* JADX INFO: loaded from: classes.dex */
public class DeviceIdentificationRuleAlgorithm {
    private static final String TAG = "DeviceIdentificationRuleAlgorithm";

    public DeviceIdentificationRuleAlgorithm() {
    }

    public static int getDeviceTypeFromCod(Context r8, BluetoothDevice r10, String r11) {
        int r12 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        if (r11.trim().isEmpty() == false) goto L7;
        return 0;
    L7:
        if (BdimCategoryConstants.VALUE_UNKNOWN.equals(r11) == false) goto L9;
        return 0;
    L9:
        if (BdimCategoryConstants.VALUE_NONE.equals(r11) == true) goto L103;
        CaeLog.i(TAG, "getDeviceTypeFromCod: cod = ".concat(r11));
        int r13 = 16;
        int r14 = Integer.parseInt(r11.trim(), 16) & 8188;
        int r15 = r14 & 7936;
        if (r15 != 256) goto L16;
        r13 = 6;
        if (r14 != 260) goto L72;
    L84:
        r12 = r13;
        goto L85
    L72:
        if (r14 == 264) goto L84;
        if (r14 != 268) goto L76;
        int r16 = 14;
    L68:
        r12 = r16;
        goto L85
    L76:
        if (r14 != 272) goto L78;
    L82:
        r16 = 13;
        goto L68
    L78:
        if (r14 == 276) goto L82;
        if (r14 == 284) goto L82;
    L16:
        if (r15 != 512) goto L18;
        r16 = 7;
        goto L68
    L18:
        if (r15 != 1024) goto L20;
        r12 = 1;
        switch(r14) {
            case 1028: goto L85;
            case 1032: goto L85;
            case 1040: goto L66;
            case 1044: goto L65;
            case 1048: goto L64;
            case 1052: goto L65;
            case 1056: goto L63;
            case 1060: goto L84;
            case 1064: goto L65;
            case 1080: goto L84;
            case 1084: goto L84;
            default: goto L85;
        };
    L63:
        r16 = 2;
        goto L68
    L64:
        r16 = 17;
        goto L68
    L65:
        r16 = 3;
        goto L68
    L66:
        r16 = 15;
        goto L68
    L20:
        if (r15 != 1280) goto L22;
        r13 = 8;
        if (r14 == 1344) goto L84;
        if (r14 != 1408) goto L50;
        r13 = 9;
        goto L84
    L50:
        if (r14 == 1472) goto L84;
        int r17 = r14 & 60;
        if (r17 == 8) goto L58;
        if (r17 == 4) goto L58;
        if (r17 != 12) goto L57;
        r13 = 22;
        goto L84
    L57:
        r13 = 10;
    L58:
        r13 = 18;
        goto L84
    L22:
        if (r15 == 1536) goto L40;
        if (r15 == 1792) goto L33;
        if (r15 != 2048) goto L28;
    L31:
        r12 = 10;
        goto L85
    L28:
        if (r15 != 2304) goto L85;
        r16 = 5;
        goto L68
    L33:
        if (r14 != 1796) goto L35;
        r12 = 4;
        goto L85
    L35:
        if (r14 != 1812) goto L85;
        r12 = 12;
        goto L85
    L40:
        if ((r14 & 128) == 0) goto L43;
        r16 = 21;
        goto L68
    L43:
        if ((r14 & 32) == 0) goto L31;
        r16 = 20;
    L85:
        if (r12 == 0) goto L87;
        if (r12 == 10) goto L87;
        return r12;
    L87:
        if (r8 == null) goto L100;
        if (r10 != null) goto L90;
        return r12;
    L90:
        if (SmartBluetoothEBikeAware.getInstance(r8).isEBikeDevice(r10) == false) goto L102;
        CaeLog.d(TAG, "getDeviceTypeFromCod: matched as E-Bike by SmartBluetoothEBikeAware");
        return 11;
    L102:
        return r12;
    L100:
        return r12;
    L103:
        return 0;
    }

    public static int mapAlgorithmToDeviceType(String r15) {
        if (r15 != null) goto L5;
        return 0;
    L5:
        String r16 = r15.toUpperCase();
        r16.getClass();
        byte r14 = -1;
        switch(r16.hashCode()) {
            case -1724131831: goto L61;
            case -1290540065: goto L57;
            case 2547: goto L53;
            case 2690: goto L49;
            case 66484: goto L45;
            case 76327: goto L41;
            case 78963: goto L37;
            case 2031157: goto L33;
            case 73548933: goto L29;
            case 76105038: goto L25;
            case 82365615: goto L21;
            case 826650890: goto L17;
            case 1286366183: goto L13;
            case 1513303650: goto L9;
            default: goto L64;
        };
    L64:
        switch(r14) {
            case 0: goto L81;
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L77;
            case 4: goto L76;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L72;
            case 8: goto L71;
            case 9: goto L70;
            case 10: goto L69;
            case 11: goto L68;
            case 12: goto L67;
            case 13: goto L66;
            default: goto L65;
        };
    L65:
        return 0;
    L66:
        return 1;
    L67:
        return 8;
    L68:
        return 12;
    L69:
        return 4;
    L70:
        return 7;
    L71:
        return 9;
    L72:
        return 5;
    L73:
        return 13;
    L74:
        return 15;
    L76:
        return 2;
    L77:
        return 16;
    L79:
        return 6;
    L80:
        return 3;
    L81:
        return 10;
    L9:
        if (r16.equals(BdimCategoryConstants.CATEGORY_HEADSET) == false) goto L64;
        r14 = 13;
        goto L64
    L13:
        if (r16.equals("KEYBOARD") == false) goto L64;
        r14 = 12;
        goto L64
    L17:
        if (r16.equals("GLASSES") == false) goto L64;
        r14 = 11;
        goto L64
    L21:
        if (r16.equals(BdimCategoryConstants.CATEGORY_WATCH) == false) goto L64;
        r14 = 10;
        goto L64
    L25:
        if (r16.equals(BdimCategoryConstants.COD_PHONE) == false) goto L64;
        r14 = 9;
        goto L64
    L29:
        if (r16.equals("MOUSE") == false) goto L64;
        r14 = 8;
        goto L64
    L33:
        if (r16.equals(BdimCategoryConstants.CATEGORY_BAND) == false) goto L64;
        r14 = 7;
        goto L64
    L37:
        if (r16.equals(BdimCategoryConstants.CATEGORY_PAD) == false) goto L64;
        r14 = 6;
        goto L64
    L41:
        if (r16.equals("MIC") == false) goto L64;
        r14 = 5;
        goto L64
    L45:
        if (r16.equals(BdimCategoryConstants.CATEGORY_CAR) == false) goto L64;
        r14 = 4;
        goto L64
    L49:
        if (r16.equals("TV") == false) goto L64;
        r14 = 3;
        goto L64
    L53:
        if (r16.equals("PC") == false) goto L64;
        r14 = 2;
        goto L64
    L57:
        if (r16.equals(BdimCategoryConstants.CATEGORY_SPEAKER) == false) goto L64;
        r14 = 1;
        goto L64
    L61:
        if (r16.equals("GAME_CONTROLLER") == false) goto L64;
        r14 = 0;
        goto L64
    }

    public static int resolveFinalDeviceType(Context r8, BluetoothDevice r10, int r11, String r12, String r13) {
        String r14 = TAG;
        CaeLog.d(r14, "resolveFinalDeviceType: modelType = " + BluetoothDeviceIdentificationModel.mapIntTypeToString(r11) + ", algorithmType = " + r12);
        boolean r15 = true;
        if (r11 != 1) goto L5;
    L10:
        if (r15 == false) goto L12;
        return r11;
    L12:
        int r16 = getDeviceTypeFromCod(r8, r10, r13);
        CaeLog.i(r14, "finalType: " + BluetoothDeviceIdentificationModel.mapIntTypeToString(r16));
        return r16;
    L5:
        if (r11 == 4) goto L10;
        if (r11 == 2) goto L10;
        r15 = false;
        goto L10
    }
}
