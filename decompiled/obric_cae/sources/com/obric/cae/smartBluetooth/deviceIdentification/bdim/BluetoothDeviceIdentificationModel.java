package com.obric.cae.smartBluetooth.deviceIdentification.bdim;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.obric.cae.log.CaeLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tensorflow.lite.d;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothDeviceIdentificationModel {
    public static final String BDIM_TEST_MODE = "persist.bdim.testmode.enable";
    private static final float CONFIDENCE_THRESHOLD = 0.5f;
    private static final String TAG = "BluetoothDeviceIdentificationModel";
    private Context mContext;
    private d tflite;

    public BluetoothDeviceIdentificationModel() {
    }

    private String btPairCod(String r8) {
        if (r8 != null) goto L5;
    L12:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        if (r8.trim().isEmpty() == true) goto L12;
        if (r8.equals(BdimCategoryConstants.VALUE_NONE) == true) goto L12;
        int r10 = Integer.parseInt(r8.trim(), 16);     // Catch: NumberFormatException -> L11
        return ((r10 & 7936) >> 8) + "_" + ((r10 & 252) >> 2);
    L11:
        CaeLog.w(TAG, "Failed to parse CoD value: ".concat(r8));
        goto L12
    }

    private String btPairIo(String r8) {
        if (r8 != null) goto L5;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        String r10 = r8.toUpperCase();
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -1911550858: goto L37;
            case -1767952365: goto L33;
            case -426861746: goto L29;
            case -338838682: goto L25;
            case -333004503: goto L21;
            case -255278996: goto L17;
            case 1042859268: goto L13;
            case 1063497611: goto L9;
            default: goto L40;
        };
    L40:
        switch(r11) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L48;
            case 4: goto L44;
            case 5: goto L42;
            case 6: goto L46;
            case 7: goto L42;
            default: goto L41;
        };
    L41:
        return r8;
    L42:
        return BdimCategoryConstants.IO_NO_INPUT_NO_OUTPUT;
    L44:
        return BdimCategoryConstants.IO_DISPLAY_ONLY;
    L46:
        return BdimCategoryConstants.IO_KEYBOARD_ONLY;
    L48:
        return BdimCategoryConstants.IO_DISPLAY_YES_NO;
    L9:
        if (r10.equals("NOINPUTNOOUTPUT") == false) goto L40;
        r11 = 7;
        goto L40
    L13:
        if (r10.equals("KEYBOARD_ONLY") == false) goto L40;
        r11 = 6;
        goto L40
    L17:
        if (r10.equals("NO_INPUT_NO_OUTPUT") == false) goto L40;
        r11 = 5;
        goto L40
    L21:
        if (r10.equals("DISPLAY_ONLY") == false) goto L40;
        r11 = 4;
        goto L40
    L25:
        if (r10.equals("DISPLAYYESNO") == false) goto L40;
        r11 = 3;
        goto L40
    L29:
        if (r10.equals("DISPLAYONLY") == false) goto L40;
        r11 = 2;
        goto L40
    L33:
        if (r10.equals("KEYBOARDONLY") == false) goto L40;
        r11 = 1;
        goto L40
    L37:
        if (r10.equals("DISPLAY_YES_NO") == false) goto L40;
        r11 = 0;
        goto L40
    }

    private String btPairManuf(String r8) {
        if (r8 != null) goto L6;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L6:
        return r8;
    }

    private String btPairMethod(String r8) {
        if (r8 != null) goto L5;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        String r10 = r8.toUpperCase();
        r10.getClass();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -2004086193: goto L33;
            case -1981033472: goto L29;
            case -1283547796: goto L25;
            case -1281670963: goto L21;
            case -74055538: goto L17;
            case 78434: goto L13;
            case 703813117: goto L9;
            default: goto L36;
        };
    L36:
        switch(r11) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L42;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L44;
            default: goto L37;
        };
    L37:
        return r8;
    L38:
        return BdimCategoryConstants.METHOD_OOB;
    L40:
        return BdimCategoryConstants.METHOD_PASSKEY;
    L42:
        return BdimCategoryConstants.METHOD_NUM_CMP;
    L44:
        return BdimCategoryConstants.METHOD_JUSTWORK;
    L9:
        if (r10.equals("JUSTWORK") == false) goto L36;
        r11 = 6;
        goto L36
    L13:
        if (r10.equals("OOB") == false) goto L36;
        r11 = 5;
        goto L36
    L17:
        if (r10.equals("PASSKEY") == false) goto L36;
        r11 = 4;
        goto L36
    L21:
        if (r10.equals("NUM_CMP") == false) goto L36;
        r11 = 3;
        goto L36
    L25:
        if (r10.equals("NUM CMP") == false) goto L36;
        r11 = 2;
        goto L36
    L29:
        if (r10.equals("NUMCMP") == false) goto L36;
        r11 = 1;
        goto L36
    L33:
        if (r10.equals("JUST_WORKS") == false) goto L36;
        r11 = 0;
        goto L36
    }

    private String btPairServiceInfo(String r8) {
        if (r8 != null) goto L5;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        if (r8.trim().isEmpty() == true) goto L44;
        String r10 = r8.toUpperCase();
        StringBuilder r11 = new StringBuilder();
        String[] r12 = BdimCategoryConstants.CORE_SERVICES;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L35;
        String r15 = r12[r14];
        if (r10.contains(r15) == false) goto L33;
        if (r15.equals(BdimCategoryConstants.SERVICE_HANDFREE_HF) == false) goto L17;
        if (r10.contains(BdimCategoryConstants.SERVICE_HANDSFREE_HF) == true) goto L17;
        r15 = BdimCategoryConstants.SERVICE_HANDSFREE_HF;
    L28:
        if (r11.indexOf(r15) != (-1)) goto L33;
        if (r11.length() <= 0) goto L32;
        r11.append(",");
    L32:
        r11.append(r15);
    L17:
        if (r15.equals(BdimCategoryConstants.SERVICE_MAS) == false) goto L20;
        r15 = BdimCategoryConstants.SERVICE_MAP_MSE;
        goto L28
    L20:
        if (r15.equals(BdimCategoryConstants.SERVICE_MAP_MCE) == false) goto L23;
        r15 = BdimCategoryConstants.SERVICE_MAP_MCE_MNS;
        goto L28
    L23:
        if (r15.equals(BdimCategoryConstants.SERVICE_HEADSET_AUDIO_GATEWAY) == false) goto L25;
    L26:
        r15 = BdimCategoryConstants.SERVICE_HEADSET_AG_HF_AG;
        goto L28
    L25:
        if (r15.equals(BdimCategoryConstants.SERVICE_HANDFREE_AG) == false) goto L28;
    L33:
        r14 = r14 + 1;
        goto L8
    L35:
        if (r11.length() != 0) goto L38;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L38:
        return r11.toString();
    L44:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    }

    private float computeHashBin(String r8, int r10) {
        if (r8 != null) goto L4;
        return 0.0f;
    L4:
        if (BdimCategoryConstants.VALUE_UNKNOWN.equals(r8) == false) goto L6;
        return 0.0f;
    L6:
        if (BdimCategoryConstants.VALUE_NONE.equals(r8) == true) goto L22;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L10:
        if (r12 >= r8.length()) goto L13;
        r13 = (r13 * 31) + r8.charAt(r12);
        r12 = r12 + 1;
        goto L10
    L13:
        if (r13 == Integer.MIN_VALUE) goto L17;
        r11 = Math.abs(r13);
    L17:
        return (r11 % (r10 - 1)) + 1;
    L22:
        return 0.0f;
    }

    private String extractCategoryKeyword(String r8, String r10, String r11) {
        if (r8 != null) goto L5;
    L99:
        return BdimCategoryConstants.VALUE_NONE;
    L5:
        if (r8.trim().isEmpty() == true) goto L99;
        String r12 = r8.toLowerCase();
        int r13 = 0;
        if (BdimCategoryConstants.IO_NO_INPUT_NO_OUTPUT.equalsIgnoreCase(r10) == false) goto L10;
    L13:
        boolean r14 = true;
    L14:
        String[] r15 = BdimCategoryConstants.CAR_KEYWORDS;
        int r16 = r15.length;
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L21;
        if (r12.contains(r15[r17].toLowerCase()) == true) goto L18;
        r17 = r17 + 1;
        goto L15
    L18:
        return BdimCategoryConstants.CATEGORY_CAR;
    L21:
        String[] r18 = BdimCategoryConstants.SPEAKER_KEYWORDS;
        int r19 = r18.length;
        int r20 = 0;
    L22:
        if (r20 >= r19) goto L28;
        if (r12.contains(r18[r20].toLowerCase()) == true) goto L25;
        r20 = r20 + 1;
        goto L22
    L25:
        return BdimCategoryConstants.CATEGORY_SPEAKER;
    L28:
        String[] r21 = BdimCategoryConstants.EBIKE_KEYWORDS;
        int r22 = r21.length;
        int r23 = 0;
    L29:
        if (r23 >= r22) goto L35;
        if (r12.contains(r21[r23].toLowerCase()) == true) goto L32;
        r23 = r23 + 1;
        goto L29
    L32:
        return BdimCategoryConstants.CATEGORY_EBIKE;
    L35:
        String[] r24 = BdimCategoryConstants.HEADSET_KEYWORDS;
        int r25 = r24.length;
        int r26 = 0;
    L36:
        if (r26 >= r25) goto L42;
        if (r12.contains(r24[r26].toLowerCase()) == true) goto L39;
        r26 = r26 + 1;
        goto L36
    L39:
        return BdimCategoryConstants.CATEGORY_HEADSET;
    L42:
        String[] r27 = BdimCategoryConstants.BAND_KEYWORDS;
        int r28 = r27.length;
        int r29 = 0;
    L43:
        if (r29 >= r28) goto L49;
        if (r12.contains(r27[r29].toLowerCase()) == true) goto L46;
        r29 = r29 + 1;
        goto L43
    L46:
        return BdimCategoryConstants.CATEGORY_BAND;
    L49:
        String[] r30 = BdimCategoryConstants.GLASS_KEYWORDS;
        int r31 = r30.length;
        int r32 = 0;
    L50:
        if (r32 >= r31) goto L56;
        if (r12.contains(r30[r32].toLowerCase()) == true) goto L53;
        r32 = r32 + 1;
        goto L50
    L53:
        return BdimCategoryConstants.CATEGORY_GLASS;
    L56:
        String[] r33 = BdimCategoryConstants.WATCH_KEYWORDS;
        int r34 = r33.length;
        int r35 = 0;
    L57:
        if (r35 >= r34) goto L63;
        if (r12.contains(r33[r35].toLowerCase()) == true) goto L60;
        r35 = r35 + 1;
        goto L57
    L60:
        return BdimCategoryConstants.CATEGORY_WATCH;
    L63:
        String[] r36 = BdimCategoryConstants.TV_KEYWORDS;
        int r37 = r36.length;
        int r38 = 0;
    L64:
        if (r38 >= r37) goto L70;
        if (r12.contains(r36[r38].toLowerCase()) == true) goto L68;
        r38 = r38 + 1;
        goto L64
    L68:
        return BdimCategoryConstants.NAME_TV.toUpperCase();
    L70:
        String[] r39 = BdimCategoryConstants.MISC_KEYWORDS;
        int r40 = r39.length;
        int r41 = 0;
    L71:
        if (r41 >= r40) goto L77;
        String r42 = r39[r41];
        if (r12.contains(r42.toLowerCase()) == true) goto L75;
        r41 = r41 + 1;
        goto L71
    L75:
        return r42.toUpperCase();
    L77:
        if (r14 == true) goto L99;
        String[] r43 = BdimCategoryConstants.PAD_KEYWORDS;
        int r44 = r43.length;
        int r45 = 0;
    L79:
        if (r45 >= r44) goto L85;
        if (r12.contains(r43[r45].toLowerCase()) == true) goto L82;
        r45 = r45 + 1;
        goto L79
    L82:
        return BdimCategoryConstants.CATEGORY_PAD;
    L85:
        String[] r46 = BdimCategoryConstants.COMPUTER_KEYWORDS;
        int r47 = r46.length;
        int r48 = 0;
    L86:
        if (r48 >= r47) goto L92;
        if (r12.contains(r46[r48].toLowerCase()) == true) goto L89;
        r48 = r48 + 1;
        goto L86
    L89:
        return "COMPUTER";
    L92:
        String[] r49 = BdimCategoryConstants.SMARTPHONE_KEYWORDS;
        int r50 = r49.length;
    L93:
        if (r13 >= r50) goto L99;
        if (r12.contains(r49[r13].toLowerCase()) == true) goto L96;
        r13 = r13 + 1;
        goto L93
    L96:
        return BdimCategoryConstants.CATEGORY_SMART_PHONE;
    L10:
        if (BdimCategoryConstants.METHOD_JUSTWORK.equalsIgnoreCase(r11) == true) goto L13;
        r14 = false;
        goto L14
    }

    private String extractCodMajorClass(String r8) {
        if (r8 != null) goto L5;
    L33:
        return BdimCategoryConstants.COD_UNCATEGORIZED;
    L5:
        if (r8.trim().isEmpty() == true) goto L33;
        if (r8.toUpperCase().equals(BdimCategoryConstants.VALUE_NONE) == true) goto L33;
        if (r8.toUpperCase().equals(BdimCategoryConstants.VALUE_UNKNOWN) == true) goto L33;
    L32:
        CaeLog.w(TAG, "Failed to parse CoD value: ".concat(r8));
        goto L33
    L12:
        switch(((Integer.parseInt(r8.trim(), 16) >> 8) & 31)) {
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            default: goto L36;
        };     // Catch: NumberFormatException -> L32
    L14:
        return BdimCategoryConstants.COD_HEALTH;
    L16:
        return BdimCategoryConstants.COD_TOY;
    L18:
        return BdimCategoryConstants.COD_WEARABLE;
    L20:
        return BdimCategoryConstants.COD_IMAGING;
    L22:
        return BdimCategoryConstants.COD_PERIPHERAL;
    L24:
        return BdimCategoryConstants.COD_AUDIO_VIDEO;
    L26:
        return BdimCategoryConstants.COD_NETWORK;
    L28:
        return BdimCategoryConstants.COD_PHONE;
    L30:
        return "COMPUTER";
    L36:
        return BdimCategoryConstants.COD_UNCATEGORIZED;
    }

    private String extractCodMinorClass(String r8) {
        if (r8 != null) goto L5;
    L14:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        if (r8.trim().isEmpty() == true) goto L14;
        if (r8.toUpperCase().equals(BdimCategoryConstants.VALUE_NONE) == true) goto L14;
        if (r8.toUpperCase().equals(BdimCategoryConstants.VALUE_UNKNOWN) == true) goto L14;
        return String.valueOf((Integer.parseInt(r8.trim(), 16) >> 2) & 63);
    L13:
        CaeLog.w(TAG, "Failed to parse CoD value: ".concat(r8));
        goto L14
    }

    private String extractMacPrefix(String r8) {
        if (r8 != null) goto L4;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L4:
        if (r8.trim().isEmpty() == true) goto L14;
        String[] r10 = r8.split(BdimCategoryConstants.SEPARATOR_COLON);
        if (r10.length < 3) goto L11;
        return (r10[0] + BdimCategoryConstants.SEPARATOR_COLON + r10[1] + BdimCategoryConstants.SEPARATOR_COLON + r10[2]).toUpperCase();
    L11:
        return r8.toUpperCase();
    L14:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    }

    private String extractNameKeyword(String r8) {
        if (r8 != null) goto L5;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        if (r8.trim().isEmpty() == true) goto L13;
        String r10 = r8.trim().replaceAll(BdimCategoryConstants.REGEX_PREFIX_S, "").replaceAll(BdimCategoryConstants.REGEX_PREFIX_DE, "");
        Matcher r11 = Pattern.compile(BdimCategoryConstants.REGEX_NAME_KEYWORD).matcher(r10);
        if (r11.find() == true) goto L10;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L10:
        return r11.group().toUpperCase();
    L13:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    }

    public static String getDeviceTypeName(int r8) {
        switch(r8) {
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            case 5: goto L27;
            case 6: goto L25;
            case 7: goto L23;
            case 8: goto L21;
            case 9: goto L19;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L11;
            case 14: goto L9;
            case 15: goto L7;
            case 16: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return BdimCategoryConstants.NAME_TV;
    L7:
        return BdimCategoryConstants.NAME_MICROPHONE;
    L9:
        return BdimCategoryConstants.NAME_LAPTOP;
    L11:
        return BdimCategoryConstants.NAME_PAD;
    L13:
        return BdimCategoryConstants.NAME_GLASS;
    L15:
        return BdimCategoryConstants.NAME_EBIKE;
    L17:
        return BdimCategoryConstants.NAME_PERIPHERAL;
    L19:
        return BdimCategoryConstants.NAME_MOUSE;
    L21:
        return BdimCategoryConstants.NAME_KEYBOARD;
    L23:
        return BdimCategoryConstants.NAME_SMART_PHONE;
    L25:
        return BdimCategoryConstants.NAME_COMPUTER;
    L27:
        return BdimCategoryConstants.NAME_BAND;
    L29:
        return BdimCategoryConstants.NAME_WRIST_WATCH;
    L31:
        return BdimCategoryConstants.NAME_DISPLAY_LOUDSPEAKER;
    L33:
        return BdimCategoryConstants.NAME_CARKIT;
    L35:
        return BdimCategoryConstants.NAME_WEARABLE_HEADSET;
    }

    private String getDeviceTypeNameByOutputIndex(int r8) {
        if (r8 < 0) goto L7;
        String[] r10 = BdimCategoryConstants.CLASSES;
        if (r8 < r10.length) goto L6;
        return "unknown";
    L6:
        return r10[r8];
    L7:
        return "unknown";
    }

    private boolean hasAnyKnownService(String r8) {
        if (r8 != null) goto L5;
    L18:
        return false;
    L5:
        if (r8.trim().isEmpty() == true) goto L18;
        if (BdimCategoryConstants.VALUE_NONE.equalsIgnoreCase(r8) == true) goto L18;
        if (BdimCategoryConstants.VALUE_UNKNOWN.equalsIgnoreCase(r8) == true) goto L18;
        String[] r10 = BdimCategoryConstants.CORE_SERVICES;
        int r11 = r10.length;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L18;
        if (hasService(r8, new String[]{r10[r12]}) > 0.0f) goto L15;
        r12 = r12 + 1;
        goto L12
    L15:
        return true;
    }

    private float hasService(String r8, String... r10) {
        if (r8 != null) goto L5;
    L14:
        return 0.0f;
    L5:
        if (r8.trim().isEmpty() == true) goto L14;
        String r11 = r8.toUpperCase();
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L14;
        if (r11.contains(r10[r13].toUpperCase()) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return 1.0f;
    }

    private MappedByteBuffer loadModelFile(Context r8, String r10) {
        AssetFileDescriptor r11 = r8.getAssets().openFd(r10);     // Catch: IOException -> L21
        FileInputStream r12 = new FileInputStream(r11.getFileDescriptor());     // Catch: Throwable -> L14
        MappedByteBuffer r13 = r12.getChannel().map(FileChannel.MapMode.READ_ONLY, r11.getStartOffset(), r11.getDeclaredLength());     // Catch: Throwable -> L8
        r12.close();     // Catch: Throwable -> L14
        r11.close();     // Catch: IOException -> L21
        return r13;
    L8:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r11 != null) goto L27;
    L20:
        throw th;     // Catch: IOException -> L21
    L27:
        r11.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L21
    L21:
        e = move-exception;
        CaeLog.e(TAG, "loadModelFile: " + e);
        return null;
    }

    public static String mapIntTypeToString(int r8) {
        switch(r8) {
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            case 5: goto L27;
            case 6: goto L25;
            case 7: goto L23;
            case 8: goto L21;
            case 9: goto L19;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L11;
            case 14: goto L9;
            case 15: goto L7;
            case 16: goto L5;
            default: goto L3;
        };
    L3:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L5:
        return "TV";
    L7:
        return "MICROPHONE";
    L9:
        return "LAPTOP";
    L11:
        return BdimCategoryConstants.CATEGORY_PAD;
    L13:
        return BdimCategoryConstants.CATEGORY_GLASS;
    L15:
        return BdimCategoryConstants.CATEGORY_EBIKE;
    L17:
        return BdimCategoryConstants.COD_PERIPHERAL;
    L19:
        return "MOUSE";
    L21:
        return "KEYBOARD";
    L23:
        return BdimCategoryConstants.CATEGORY_SMART_PHONE;
    L25:
        return "COMPUTER";
    L27:
        return BdimCategoryConstants.CATEGORY_BAND;
    L29:
        return BdimCategoryConstants.CATEGORY_WATCH;
    L31:
        return "LOUDSPEAKER";
    L33:
        return "CARKIT";
    L35:
        return BdimCategoryConstants.CATEGORY_HEADSET;
    }

    public static int mapStringToIntType(String r19) {
        if (r19 != null) goto L5;
        return 0;
    L5:
        String r8 = r19.toLowerCase();
        r8.getClass();
        byte r18 = -1;
        switch(r8.hashCode()) {
            case -1877588922: goto L69;
            case -1367597438: goto L65;
            case -1360733890: goto L61;
            case -1121570117: goto L57;
            case -1109985830: goto L53;
            case -599163109: goto L49;
            case -150996104: goto L45;
            case 3714: goto L41;
            case 110739: goto L37;
            case 3016245: goto L33;
            case 96299462: goto L29;
            case 98436988: goto L25;
            case 104086693: goto L21;
            case 417170812: goto L17;
            case 503739367: goto L13;
            case 1370921258: goto L9;
            default: goto L72;
        };
    L72:
        switch(r18) {
            case 0: goto L90;
            case 1: goto L89;
            case 2: goto L88;
            case 3: goto L87;
            case 4: goto L86;
            case 5: goto L85;
            case 6: goto L84;
            case 7: goto L82;
            case 8: goto L81;
            case 9: goto L80;
            case 10: goto L79;
            case 11: goto L78;
            case 12: goto L77;
            case 13: goto L76;
            case 14: goto L75;
            case 15: goto L74;
            default: goto L73;
        };
    L73:
        return 0;
    L74:
        return 15;
    L75:
        return 8;
    L76:
        return 10;
    L77:
        return 9;
    L78:
        return 12;
    L79:
        return 11;
    L80:
        return 5;
    L81:
        return 13;
    L82:
        return 16;
    L84:
        return 7;
    L85:
        return 6;
    L86:
        return 14;
    L87:
        return 1;
    L88:
        return 4;
    L89:
        return 2;
    L90:
        return 3;
    L9:
        if (r8.equals(BdimCategoryConstants.NAME_MICROPHONE) == false) goto L72;
        r18 = 15;
        goto L72
    L13:
        if (r8.equals(BdimCategoryConstants.NAME_KEYBOARD) == false) goto L72;
        r18 = 14;
        goto L72
    L17:
        if (r8.equals(BdimCategoryConstants.NAME_PERIPHERAL) == false) goto L72;
        r18 = 13;
        goto L72
    L21:
        if (r8.equals(BdimCategoryConstants.NAME_MOUSE) == false) goto L72;
        r18 = 12;
        goto L72
    L25:
        if (r8.equals(BdimCategoryConstants.NAME_GLASS) == false) goto L72;
        r18 = 11;
        goto L72
    L29:
        if (r8.equals(BdimCategoryConstants.NAME_EBIKE) == false) goto L72;
        r18 = 10;
        goto L72
    L33:
        if (r8.equals(BdimCategoryConstants.NAME_BAND) == false) goto L72;
        r18 = 9;
        goto L72
    L37:
        if (r8.equals(BdimCategoryConstants.NAME_PAD) == false) goto L72;
        r18 = 8;
        goto L72
    L41:
        if (r8.equals(BdimCategoryConstants.NAME_TV) == false) goto L72;
        r18 = 7;
        goto L72
    L45:
        if (r8.equals(BdimCategoryConstants.NAME_SMART_PHONE) == false) goto L72;
        r18 = 6;
        goto L72
    L49:
        if (r8.equals(BdimCategoryConstants.NAME_COMPUTER) == false) goto L72;
        r18 = 5;
        goto L72
    L53:
        if (r8.equals(BdimCategoryConstants.NAME_LAPTOP) == false) goto L72;
        r18 = 4;
        goto L72
    L57:
        if (r8.equals(BdimCategoryConstants.NAME_WEARABLE_HEADSET) == false) goto L72;
        r18 = 3;
        goto L72
    L61:
        if (r8.equals(BdimCategoryConstants.NAME_WRIST_WATCH) == false) goto L72;
        r18 = 2;
        goto L72
    L65:
        if (r8.equals(BdimCategoryConstants.NAME_CARKIT) == false) goto L72;
        r18 = 1;
        goto L72
    L69:
        if (r8.equals(BdimCategoryConstants.NAME_DISPLAY_LOUDSPEAKER) == false) goto L72;
        r18 = 0;
        goto L72
    }

    private String safeString(String r8) {
        if (r8 != null) goto L6;
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L6:
        return r8;
    }

    private boolean shouldSuppressHeadsetPrediction(int r8, float r10, String r11, String r12, String r13, String r14) {
        if (r8 == 1) goto L6;
        return false;
    L6:
        if (BdimCategoryConstants.COD_UNCATEGORIZED.equals(r11) == true) goto L8;
    L10:
        boolean r15 = false;
    L11:
        boolean r16 = !hasAnyKnownService(r13);
        boolean r17 = !BdimCategoryConstants.CATEGORY_HEADSET.equals(r14);
        if (r15 == false) goto L19;
        if (r16 == false) goto L20;
        if (r17 == true) goto L16;
        return false;
    L16:
        if (r10 < 0.7f) goto L18;
        return false;
    L18:
        return true;
    L20:
        return false;
    L19:
        return false;
    L8:
        if ("0".equals(r12) == false) goto L10;
        r15 = true;
        goto L11
    }

    public void close() {
        d r8 = this.tflite;
        if (r8 == null) goto L6;
        r8.close();
        this.tflite = null;
        return;
    }

    public boolean initialize(Context r8, String r10) {
        this.mContext = r8;
        if (BdimFeatureController.getInstance(r8).isFeatureEnabled() == true) goto L17;
        CaeLog.i(TAG, "BDIM feature is disabled, skipping TFLite initialization.");
        return true;
    L17:
        d.a r11 = new d.a();     // Catch: Exception -> L12
        r11.f9836b = 4;     // Catch: Exception -> L12
        this.tflite = new d(loadModelFile(r8, r10), r11);     // Catch: Exception -> L12
        CaeLog.i(TAG, "DNN TFLite Model loaded successfully.");     // Catch: Exception -> L12
        int r12 = this.tflite.k();     // Catch: Exception -> L9
        int r13 = this.tflite.r();     // Catch: Exception -> L9
        CaeLog.d(TAG, "Total Input Tensors: " + r12);     // Catch: Exception -> L9
        CaeLog.d(TAG, "Total Output Tensors: " + r13);     // Catch: Exception -> L9
    L11:
        return true;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "Failed to read TFLite diagnostics", e);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        CaeLog.e(TAG, "Failed to load TFLite model", e);
        return false;
    }

    /* JADX WARN: Failed to calculate best type for var: r2v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v21 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @android.annotation.SuppressLint({"MissingPermission"})
    public int predict(com.obric.cae.libs.bluetooth.BdimPredictEvent r32) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0464: INVOKE (r2v21 ?? I:int) = 
              (wrap java.lang.String:SGET  A[WRAPPED] com.obric.cae.smartBluetooth.deviceIdentification.bdim.BluetoothDeviceIdentificationModel.BDIM_TEST_MODE java.lang.String)
              (0 int)
             STATIC call: android.os.SystemProperties.getInt(java.lang.String, int):int A[Catch: Exception -> 0x054e, DECLARE_VAR] in method: com.obric.cae.smartBluetooth.deviceIdentification.bdim.BluetoothDeviceIdentificationModel.predict(com.obric.cae.libs.bluetooth.BdimPredictEvent):int, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.smartBluetooth.deviceIdentification.bdim.BluetoothDeviceIdentificationModel.predict(com.obric.cae.libs.bluetooth.BdimPredictEvent):int");
    }
}
