package org.apache.xmlbeans.impl.common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.crash.constants.Constants;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.matrix.sdk.network.BuildConfig;
import com.ss.bduploader.BDVideoUploaderBase;
import okio.Utf8;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class XMLChar {
    private static final byte[] CHARS = null;

    static {
        CHARS = new byte[65536];
        int r0 = 8;
        int[] r1 = {9, 10, 13, 13, 32, 55295, 57344, Utf8.REPLACEMENT_CODE_POINT};
        int[] r3 = {32, 9, 13, 10};
        int[] r5 = {45, 46};
        int[] r6 = {58, 95};
        int[] r8 = {10, 13, 32, 33, 35, 36, 37, 61, 95};
        int[] r10 = {39, 59, 63, 90, 97, 122};
        int[] r12 = {65, 90, 97, 122, 192, Constants.UPLOAD_DISASTER_ESCAPE, 216, 246, 248, 305, 308, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 321, 328, 330, 382, 384, BDVideoUploaderBase.KeyIsTosEncStorageMode, 461, 496, 500, 501, TypedValues.PositionType.TYPE_PERCENT_X, 535, 592, 680, 699, TypedValues.TransitionType.TYPE_INTERPOLATOR, TypedValues.Custom.TYPE_BOOLEAN, TypedValues.Custom.TYPE_REFERENCE, 910, 929, 931, 974, 976, 982, 994, 1011, InputDeviceCompat.SOURCE_GAMEPAD, 1036, 1038, 1103, 1105, 1116, 1118, 1153, 1168, 1220, 1223, 1224, 1227, 1228, 1232, 1259, 1262, 1269, 1272, 1273, 1329, 1366, 1377, 1414, 1488, 1514, 1520, 1522, 1569, 1594, EntityType.EVENT_TASK, 1610, 1649, 1719, 1722, 1726, 1728, 1742, 1744, 1747, 1765, 1766, 2309, 2361, 2392, 2401, 2437, 2444, 2447, 2448, 2451, 2472, 2474, 2480, 2486, 2489, 2524, 2525, 2527, 2529, 2544, 2545, 2565, 2570, 2575, 2576, 2579, 2600, 2602, 2608, 2610, BuildConfig.SDK_VERSION_CODE, 2613, 2614, 2616, 2617, 2649, 2652, 2674, 2676, 2693, 2699, 2703, 2705, 2707, 2728, 2730, 2736, 2738, 2739, 2741, 2745, 2821, 2828, 2831, 2832, 2835, 2856, 2858, 2864, 2866, 2867, 2870, 2873, 2908, 2909, 2911, 2913, 2949, 2954, 2958, 2960, 2962, 2965, 2969, 2970, 2974, 2975, 2979, 2980, 2984, 2986, 2990, 2997, 2999, ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, 3077, 3084, 3086, 3088, 3090, 3112, 3114, 3123, 3125, 3129, 3168, 3169, 3205, 3212, 3214, 3216, 3218, 3240, 3242, 3251, 3253, 3257, 3296, 3297, 3333, 3340, 3342, 3344, 3346, 3368, 3370, 3385, 3424, 3425, 3585, 3630, 3634, 3635, 3648, 3653, 3713, 3714, 3719, 3720, 3732, 3735, 3737, 3743, 3745, 3747, 3754, 3755, 3757, 3758, 3762, 3763, 3776, 3780, 3904, 3911, 3913, 3945, 4256, 4293, 4304, 4342, 4354, 4355, 4357, 4359, 4363, 4364, 4366, 4370, 4436, 4437, 4447, 4449, 4461, 4462, 4466, 4467, 4526, 4527, 4535, 4536, 4540, 4546, 7680, 7835, 7840, 7929, 7936, 7957, 7960, 7965, 7968, ErrorCode.EventTask.CONDITION_EMPTY, ErrorCode.EventTask.LOCATION_NOT_PERMISSION, ErrorCode.EventTask.SMS_PARAMS_EMPTY, ErrorCode.EventTask.WIFI_SELECTED_NAME_EMPTY, ErrorCode.EventTask.LOCATION_SELECTED_ID_EMPTY, ErrorCode.EventTask.WIFI_SELECTED_ID_EMPTY, 8061, 8064, 8116, 8118, 8124, 8130, 8132, 8134, 8140, 8144, 8147, 8150, 8155, 8160, 8172, 8178, 8180, 8182, 8188, 8490, 8491, 8576, 8578, 12353, 12436, 12449, 12538, 12549, 12588, 44032, 55203, 12321, 12329, 19968, 40869};
        int[] r14 = {902, 908, 986, 988, 990, 992, 1369, 1749, 2365, 2482, 2654, 2701, 2749, 2784, 2877, 2972, 3294, 3632, 3716, 3722, 3725, 3749, 3751, 3760, 3773, 4352, 4361, 4412, 4414, 4416, 4428, 4430, 4432, 4441, 4451, 4453, 4455, 4457, 4469, 4510, 4520, 4523, 4538, 4587, 4592, 4601, ErrorCode.EventTask.DEVICE_CONDITION_TYPE_ERROR, ErrorCode.EventTask.BATTERY_DISCHARGED_TO_PARAMS_EMPTY, ErrorCode.EventTask.SMS_SELECTED_ID_EMPTY, 8126, 8486, 8494, 12295};
        int[] r7 = {768, 837, 864, 865, 1155, 1158, 1425, 1441, 1443, 1465, 1467, 1469, 1473, 1474, 1611, 1618, 1750, 1756, 1757, 1759, 1760, 1764, 1767, 1768, 1770, 1773, 2305, 2307, 2366, 2380, 2385, 2388, 2402, 2403, 2433, 2435, 2496, 2500, 2503, 2504, 2507, 2509, 2530, 2531, 2624, 2626, 2631, 2632, 2635, 2637, 2672, 2673, 2689, 2691, 2750, 2757, 2759, 2761, 2763, 2765, 2817, 2819, 2878, 2883, 2887, 2888, 2891, 2893, 2902, 2903, 2946, 2947, 3006, 3010, 3014, 3016, 3018, 3021, 3073, 3075, 3134, 3140, 3142, 3144, 3146, 3149, 3157, 3158, 3202, 3203, 3262, 3268, 3270, 3272, 3274, 3277, 3285, 3286, 3330, 3331, 3390, 3395, 3398, 3400, 3402, 3405, 3636, 3642, 3655, 3662, 3764, 3769, 3771, 3772, 3784, 3789, 3864, 3865, 3953, 3972, 3974, 3979, 3984, 3989, 3993, 4013, 4017, 4023, 8400, 8412, 12330, 12335};
        int[] r13 = {1471, 1476, 1648, 2364, 2381, 2492, 2494, 2495, 2519, 2562, 2620, 2622, 2623, 2748, 2876, 3031, 3415, 3633, 3761, 3893, 3895, 3897, 3902, 3903, 3991, 4025, 8417, 12441, 12442};
        int[] r11 = {48, 57, 1632, 1641, 1776, 1785, 2406, 2415, 2534, 2543, 2662, 2671, 2790, 2799, 2918, 2927, 3047, 3055, 3174, 3183, 3302, 3311, 3430, 3439, 3664, 3673, 3792, 3801, 3872, 3881};
        int[] r15 = {12337, 12341, 12445, 12446, 12540, 12542};
        int[] r9 = {183, 720, 721, TypedValues.Custom.TYPE_STRING, 1600, 3654, 3782, 12293};
        int[] r2 = {60, 38, 10, 13, 93};
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L9;
        int r16 = r1[r4];
    L5:
        int[] r19 = r10;
        if (r16 > r1[r4 + 1]) goto L8;
        byte[] r17 = CHARS;
        r17[r16] = (byte) (r17[r16] | 33);
        r16 = r16 + 1;
        r10 = r19;
        r1 = r1;
        goto L5
    L8:
        r4 = r4 + 2;
        r10 = r19;
        r0 = 8;
        goto L3
    L9:
        int[] r110 = r10;
        int r18 = 0;
    L11:
        if (r18 >= 5) goto L13;
        byte[] r20 = CHARS;
        r20[r2[r18]] = (byte) (r20[r2[r18]] & MessagePack.Code.MAP32);
        r18 = r18 + 1;
        goto L11
    L13:
        int r21 = 0;
    L15:
        if (r21 >= 4) goto L17;
        byte[] r22 = CHARS;
        int r23 = r3[r21];
        r22[r23] = (byte) (r22[r23] | 2);
        r21 = r21 + 1;
        goto L15
    L17:
        int r24 = 2;
        int r25 = 0;
    L18:
        if (r25 >= r24) goto L20;
        byte[] r26 = CHARS;
        int r27 = r6[r25];
        r26[r27] = (byte) (r26[r27] | MessagePack.Code.UINT8);
        r25 = r25 + 1;
        r24 = 2;
        goto L18
    L20:
        int r28 = 0;
    L21:
        if (r28 >= 302) goto L27;
        int r29 = r12[r28];
    L24:
        if (r29 > r12[r28 + 1]) goto L26;
        byte[] r30 = CHARS;
        r30[r29] = (byte) (r30[r29] | MessagePack.Code.UINT8);
        r29 = r29 + 1;
        goto L24
    L26:
        r28 = r28 + 2;
        goto L21
    L27:
        int r31 = 0;
    L28:
        if (r31 >= 53) goto L30;
        byte[] r32 = CHARS;
        int r33 = r14[r31];
        r32[r33] = (byte) (r32[r33] | MessagePack.Code.UINT8);
        r31 = r31 + 1;
        goto L28
    L30:
        int r34 = 0;
    L32:
        if (r34 >= 2) goto L34;
        byte[] r35 = CHARS;
        int r36 = r5[r34];
        r35[r36] = (byte) (r35[r36] | 136);
        r34 = r34 + 1;
        goto L32
    L34:
        int r37 = 0;
    L35:
        if (r37 >= 30) goto L41;
        int r38 = r11[r37];
    L38:
        if (r38 > r11[r37 + 1]) goto L40;
        byte[] r39 = CHARS;
        r39[r38] = (byte) (r39[r38] | 136);
        r38 = r38 + 1;
        goto L38
    L40:
        r37 = r37 + 2;
        goto L35
    L41:
        int r40 = 0;
    L42:
        if (r40 >= 132) goto L48;
        int r41 = r7[r40];
    L45:
        if (r41 > r7[r40 + 1]) goto L47;
        byte[] r42 = CHARS;
        r42[r41] = (byte) (r42[r41] | 136);
        r41 = r41 + 1;
        goto L45
    L47:
        r40 = r40 + 2;
        goto L42
    L48:
        int r43 = 0;
    L49:
        if (r43 >= 29) goto L51;
        byte[] r44 = CHARS;
        int r45 = r13[r43];
        r44[r45] = (byte) (r44[r45] | 136);
        r43 = r43 + 1;
        goto L49
    L51:
        int r46 = 0;
    L53:
        if (r46 >= 6) goto L59;
        int r47 = r15[r46];
    L56:
        if (r47 > r15[r46 + 1]) goto L58;
        byte[] r48 = CHARS;
        r48[r47] = (byte) (r48[r47] | 136);
        r47 = r47 + 1;
        goto L56
    L58:
        r46 = r46 + 2;
        goto L53
    L59:
        int r49 = 0;
    L60:
        if (r49 >= 8) goto L62;
        byte[] r50 = CHARS;
        int r51 = r9[r49];
        r50[r51] = (byte) (r50[r51] | 136);
        r49 = r49 + 1;
        goto L60
    L62:
        byte[] r52 = CHARS;
        r52[58] = (byte) (r52[58] & Utf8.REPLACEMENT_BYTE);
        int r53 = 0;
    L64:
        if (r53 >= 9) goto L66;
        byte[] r54 = CHARS;
        int r55 = r8[r53];
        r54[r55] = (byte) (r54[r55] | 16);
        r53 = r53 + 1;
        goto L64
    L66:
        int r56 = 0;
    L67:
        if (r56 >= 6) goto L73;
        int r57 = r110[r56];
    L70:
        if (r57 > r110[r56 + 1]) goto L72;
        byte[] r58 = CHARS;
        r58[r57] = (byte) (r58[r57] | 16);
        r57 = r57 + 1;
        goto L70
    L72:
        r56 = r56 + 2;
        goto L67
    }

    public static boolean isNCName(int r1) {
        if (r1 < 65536) goto L5;
    L7:
        return false;
    L5:
        if ((CHARS[r1] & 128) == 0) goto L7;
        return true;
    }

    public static boolean isNCNameStart(int r1) {
        if (r1 < 65536) goto L5;
    L7:
        return false;
    L5:
        if ((CHARS[r1] & 64) == 0) goto L7;
        return true;
    }

    public static boolean isName(int r1) {
        if (r1 < 65536) goto L5;
    L7:
        return false;
    L5:
        if ((CHARS[r1] & 8) == 0) goto L7;
        return true;
    }

    public static boolean isNameStart(int r1) {
        if (r1 < 65536) goto L5;
    L7:
        return false;
    L5:
        if ((CHARS[r1] & 4) == 0) goto L7;
        return true;
    }

    public static boolean isSpace(int r1) {
        if (r1 < 65536) goto L5;
    L7:
        return false;
    L5:
        if ((CHARS[r1] & 2) == 0) goto L7;
        return true;
    }

    public static boolean isValidNCName(String r4) {
        if (r4.length() != 0) goto L6;
        return false;
    L6:
        if (isNCNameStart(r4.charAt(0)) == true) goto L8;
        return false;
    L8:
        int r2 = 1;
    L10:
        if (r2 >= r4.length()) goto L15;
        if (isNCName(r4.charAt(r2)) == false) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static boolean isValidName(String r4) {
        if (r4.length() != 0) goto L6;
        return false;
    L6:
        if (isNameStart(r4.charAt(0)) == true) goto L8;
        return false;
    L8:
        int r2 = 1;
    L10:
        if (r2 >= r4.length()) goto L15;
        if (isName(r4.charAt(r2)) == false) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static boolean isValidNmtoken(String r3) {
        if (r3.length() != 0) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r3.length()) goto L12;
        if (isName(r3.charAt(r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }
}
