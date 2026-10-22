package org.bouncycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DefaultMultiBlockCipher;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class AESEngine extends DefaultMultiBlockCipher {
    private static final byte[] S = null;
    private static final byte[] Si = null;
    private static final int[] T0 = null;
    private static final int[] Tinv0 = null;
    private static final int[] rcon = null;
    private int ROUNDS;
    private int[][] WorkingKey;
    private boolean forEncryption;
    private byte[] s;

    static {
        S = new byte[]{99, 124, 119, 123, -14, 107, 111, MessagePack.Code.BIN16, 48, 1, 103, 43, -2, MessagePack.Code.FIXEXT8, -85, 118, MessagePack.Code.FLOAT32, -126, MessagePack.Code.EXT32, 125, -6, 89, 71, -16, -83, MessagePack.Code.FIXEXT1, -94, -81, -100, -92, 114, MessagePack.Code.NIL, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, MessagePack.Code.UINT8, 52, -91, -27, -15, 113, MessagePack.Code.FIXEXT16, 49, 21, 4, MessagePack.Code.EXT8, 35, MessagePack.Code.TRUE, 24, -106, 5, -102, 7, 18, -128, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, MessagePack.Code.FIXSTR_PREFIX, 82, 59, MessagePack.Code.FIXEXT4, -77, 41, -29, 47, -124, 83, MessagePack.Code.INT16, 0, -19, 32, -4, -79, 91, 106, MessagePack.Code.FLOAT64, -66, 57, 74, 76, 88, MessagePack.Code.UINT64, MessagePack.Code.INT8, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, MessagePack.Code.STR16, 33, 16, -1, -13, MessagePack.Code.INT32, MessagePack.Code.UINT16, 12, 19, -20, 95, -105, 68, 23, MessagePack.Code.BIN8, -89, 126, Base64.padSymbol, 100, 93, 25, 115, 96, -127, 79, MessagePack.Code.ARRAY16, 34, 42, MessagePack.Code.FIXARRAY_PREFIX, -120, 70, -18, -72, 20, MessagePack.Code.MAP16, 94, 11, MessagePack.Code.STR32, MessagePack.Code.NEGFIXINT_PREFIX, 50, 58, 10, 73, 6, 36, 92, MessagePack.Code.FALSE, MessagePack.Code.INT64, -84, 98, -111, -107, -28, 121, -25, MessagePack.Code.EXT16, 55, 109, -115, MessagePack.Code.FIXEXT2, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, MessagePack.Code.BIN32, -24, MessagePack.Code.ARRAY32, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, MessagePack.Code.NEVER_USED, 29, -98, -31, -8, -104, 17, 105, MessagePack.Code.STR8, -114, -108, -101, 30, -121, -23, MessagePack.Code.UINT32, 85, 40, MessagePack.Code.MAP32, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
        Si = new byte[]{82, 9, 106, MessagePack.Code.FIXEXT2, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, MessagePack.Code.FIXEXT8, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, MessagePack.Code.BIN8, MessagePack.Code.MAP16, -23, MessagePack.Code.FLOAT64, 84, 123, -108, 50, -90, MessagePack.Code.FALSE, 35, Base64.padSymbol, -18, 76, -107, 11, 66, -6, MessagePack.Code.TRUE, 78, 8, 46, -95, 102, 40, MessagePack.Code.STR8, 36, -78, 118, 91, -94, 73, 109, -117, MessagePack.Code.INT16, 37, 114, -8, -10, 100, -122, 104, -104, 22, MessagePack.Code.FIXEXT1, -92, 92, MessagePack.Code.UINT8, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, MessagePack.Code.STR16, 94, 21, 70, 87, -89, -115, -99, -124, MessagePack.Code.FIXARRAY_PREFIX, MessagePack.Code.FIXEXT16, -85, 0, -116, -68, MessagePack.Code.INT64, 10, -9, -28, 88, 5, -72, -77, 69, 6, MessagePack.Code.INT8, 44, 30, -113, MessagePack.Code.FLOAT32, Utf8.REPLACEMENT_BYTE, 15, 2, MessagePack.Code.NEVER_USED, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, MessagePack.Code.ARRAY16, -22, -105, -14, MessagePack.Code.UINT64, MessagePack.Code.UINT32, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, MessagePack.Code.MAP32, 110, 71, -15, 26, 113, 29, 41, MessagePack.Code.BIN16, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, MessagePack.Code.BIN32, MessagePack.Code.INT32, 121, 32, -102, MessagePack.Code.STR32, MessagePack.Code.NIL, -2, 120, MessagePack.Code.UINT16, 90, -12, 31, MessagePack.Code.ARRAY32, -88, 51, -120, 7, MessagePack.Code.EXT8, 49, -79, 18, 16, 89, 39, -128, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, MessagePack.Code.EXT32, -100, -17, MessagePack.Code.FIXSTR_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, 59, 77, -82, 42, -11, -80, MessagePack.Code.EXT16, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, MessagePack.Code.FIXEXT4, 38, -31, 105, 20, 99, 85, 33, 12, 125};
        rcon = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, 197, 145};
        T0 = new int[]{-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
        Tinv0 = new int[]{1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};
    }

    public AESEngine() {
        this.WorkingKey = (int[][]) ZeusTransformUtils.preCheckCast(null, int[][].class, "com.obric.memorydata.plugin");
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 256));
    }

    private static int FFmulX(int r2) {
        int r0 = (2139062143 & r2) << 1;
        return (((r2 & (-2139062144)) >>> 7) * 27) ^ r0;
    }

    private static int FFmulX2(int r2) {
        int r0 = (1061109567 & r2) << 2;
        int r3 = r2 & (-1061109568);
        int r4 = r3 ^ (r3 >>> 1);
        int r1 = r0 ^ (r4 >>> 2);
        return (r4 >>> 5) ^ r1;
    }

    private int bitsOfSecurity() {
        int[][] r0 = this.WorkingKey;
        if (r0 != null) goto L7;
        return 256;
    L7:
        return (r0.length - 7) << 5;
    }

    private void decryptBlock(byte[] r17, int r18, byte[] r19, int r20, int[][] r21) {
        int r3 = Pack.littleEndianToInt(r17, r18 + 0);
        int r4 = Pack.littleEndianToInt(r17, r18 + 4);
        int r5 = Pack.littleEndianToInt(r17, r18 + 8);
        int r1 = Pack.littleEndianToInt(r17, r18 + 12);
        int r6 = this.ROUNDS;
        char r8 = 0;
        int r7 = r3 ^ r21[r6][0];
        int r9 = 1;
        int r10 = r4 ^ r21[r6][1];
        int r11 = r5 ^ r21[r6][2];
        int r12 = r6 - 1;
        int r2 = r1 ^ r21[r6][3];
    L4:
        if (r12 <= r9) goto L6;
        int[] r14 = Tinv0;
        int r13 = (((shift(r14[(r2 >> 8) & 255], 24) ^ r14[r7 & 255]) ^ shift(r14[(r11 >> 16) & 255], 16)) ^ shift(r14[(r10 >> 24) & 255], 8)) ^ r21[r12][r8];
        int r15 = (((shift(r14[(r7 >> 8) & 255], 24) ^ r14[r10 & 255]) ^ shift(r14[(r2 >> 16) & 255], 16)) ^ shift(r14[(r11 >> 24) & 255], 8)) ^ r21[r12][r9];
        int r16 = (((shift(r14[(r10 >> 8) & 255], 24) ^ r14[r11 & 255]) ^ shift(r14[(r7 >> 16) & 255], 16)) ^ shift(r14[(r2 >> 24) & 255], 8)) ^ r21[r12][2];
        int r22 = ((r14[r2 & 255] ^ shift(r14[(r11 >> 8) & 255], 24)) ^ shift(r14[(r10 >> 16) & 255], 16)) ^ shift(r14[(r7 >> 24) & 255], 8);
        int r23 = r12 - 1;
        int r24 = r22 ^ r21[r12][3];
        int r25 = (((r14[r13 & 255] ^ shift(r14[(r24 >> 8) & 255], 24)) ^ shift(r14[(r16 >> 16) & 255], 16)) ^ shift(r14[(r15 >> 24) & 255], 8)) ^ r21[r23][0];
        int r26 = (((r14[r15 & 255] ^ shift(r14[(r13 >> 8) & 255], 24)) ^ shift(r14[(r24 >> 16) & 255], 16)) ^ shift(r14[(r16 >> 24) & 255], 8)) ^ r21[r23][1];
        int r27 = (((r14[r16 & 255] ^ shift(r14[(r15 >> 8) & 255], 24)) ^ shift(r14[(r13 >> 16) & 255], 16)) ^ shift(r14[(r24 >> 24) & 255], 8)) ^ r21[r23][2];
        int r28 = r23 - 1;
        r2 = (((r14[r24 & 255] ^ shift(r14[(r16 >> 8) & 255], 24)) ^ shift(r14[(r15 >> 16) & 255], 16)) ^ shift(r14[(r13 >> 24) & 255], 8)) ^ r21[r23][3];
        r7 = r25;
        r10 = r26;
        r11 = r27;
        r8 = 0;
        r9 = 1;
        r12 = r28;
        goto L4
    L6:
        int[] r29 = Tinv0;
        int r30 = (((r29[r7 & 255] ^ shift(r29[(r2 >> 8) & 255], 24)) ^ shift(r29[(r11 >> 16) & 255], 16)) ^ shift(r29[(r10 >> 24) & 255], 8)) ^ r21[r12][0];
        int r110 = (((r29[r10 & 255] ^ shift(r29[(r7 >> 8) & 255], 24)) ^ shift(r29[(r2 >> 16) & 255], 16)) ^ shift(r29[(r11 >> 24) & 255], 8)) ^ r21[r12][1];
        int r111 = (((r29[r11 & 255] ^ shift(r29[(r10 >> 8) & 255], 24)) ^ shift(r29[(r7 >> 16) & 255], 16)) ^ shift(r29[(r2 >> 24) & 255], 8)) ^ r21[r12][2];
        int r31 = (((r29[r2 & 255] ^ shift(r29[(r11 >> 8) & 255], 24)) ^ shift(r29[(r10 >> 16) & 255], 16)) ^ shift(r29[(r7 >> 24) & 255], 8)) ^ r21[r12][3];
        byte[] r32 = Si;
        int r33 = r32[r30 & 255] & 255;
        byte[] r0 = this.s;
        int r34 = (((r33 ^ ((r0[(r31 >> 8) & 255] & 255) << 8)) ^ ((r0[(r111 >> 16) & 255] & 255) << 16)) ^ (r32[(r110 >> 24) & 255] << 24)) ^ r21[0][0];
        int r35 = ((((r0[r110 & 255] & 255) ^ ((r0[(r30 >> 8) & 255] & 255) << 8)) ^ ((r32[(r31 >> 16) & 255] & 255) << 16)) ^ (r0[(r111 >> 24) & 255] << 24)) ^ r21[0][1];
        int r36 = ((((r0[r111 & 255] & 255) ^ ((r32[(r110 >> 8) & 255] & 255) << 8)) ^ ((r32[(r30 >> 16) & 255] & 255) << 16)) ^ (r0[(r31 >> 24) & 255] << 24)) ^ r21[0][2];
        int r37 = ((r0[(r30 >> 24) & 255] << 24) ^ (((r32[r31 & 255] & 255) ^ ((r0[(r111 >> 8) & 255] & 255) << 8)) ^ ((r0[(r110 >> 16) & 255] & 255) << 16))) ^ r21[0][3];
        Pack.intToLittleEndian(r34, r19, r20 + 0);
        Pack.intToLittleEndian(r35, r19, r20 + 4);
        Pack.intToLittleEndian(r36, r19, r20 + 8);
        Pack.intToLittleEndian(r37, r19, r20 + 12);
    }

    private void encryptBlock(byte[] r17, int r18, byte[] r19, int r20, int[][] r21) {
        int r3 = Pack.littleEndianToInt(r17, r18 + 0);
        int r4 = Pack.littleEndianToInt(r17, r18 + 4);
        int r5 = Pack.littleEndianToInt(r17, r18 + 8);
        int r1 = Pack.littleEndianToInt(r17, r18 + 12);
        char r6 = 0;
        int r7 = r3 ^ r21[0][0];
        int r8 = 1;
        int r9 = r4 ^ r21[0][1];
        int r10 = r5 ^ r21[0][2];
        int r2 = r1 ^ r21[0][3];
        int r11 = 1;
    L4:
        if (r11 >= (this.ROUNDS - r8)) goto L6;
        int[] r12 = T0;
        int r13 = (((shift(r12[(r9 >> 8) & 255], 24) ^ r12[r7 & 255]) ^ shift(r12[(r10 >> 16) & 255], 16)) ^ shift(r12[(r2 >> 24) & 255], 8)) ^ r21[r11][r6];
        int r14 = (((shift(r12[(r10 >> 8) & 255], 24) ^ r12[r9 & 255]) ^ shift(r12[(r2 >> 16) & 255], 16)) ^ shift(r12[(r7 >> 24) & 255], 8)) ^ r21[r11][r8];
        int r15 = (((shift(r12[(r2 >> 8) & 255], 24) ^ r12[r10 & 255]) ^ shift(r12[(r7 >> 16) & 255], 16)) ^ shift(r12[(r9 >> 24) & 255], 8)) ^ r21[r11][2];
        int r16 = ((r12[r2 & 255] ^ shift(r12[(r7 >> 8) & 255], 24)) ^ shift(r12[(r9 >> 16) & 255], 16)) ^ shift(r12[(r10 >> 24) & 255], 8);
        int r22 = r11 + 1;
        int r23 = r16 ^ r21[r11][3];
        int r24 = (((r12[r13 & 255] ^ shift(r12[(r14 >> 8) & 255], 24)) ^ shift(r12[(r15 >> 16) & 255], 16)) ^ shift(r12[(r23 >> 24) & 255], 8)) ^ r21[r22][0];
        int r25 = (((r12[r14 & 255] ^ shift(r12[(r15 >> 8) & 255], 24)) ^ shift(r12[(r23 >> 16) & 255], 16)) ^ shift(r12[(r13 >> 24) & 255], 8)) ^ r21[r22][1];
        int r26 = (((r12[r15 & 255] ^ shift(r12[(r23 >> 8) & 255], 24)) ^ shift(r12[(r13 >> 16) & 255], 16)) ^ shift(r12[(r14 >> 24) & 255], 8)) ^ r21[r22][2];
        int r27 = ((r12[r23 & 255] ^ shift(r12[(r13 >> 8) & 255], 24)) ^ shift(r12[(r14 >> 16) & 255], 16)) ^ shift(r12[(r15 >> 24) & 255], 8);
        int r28 = r22 + 1;
        r2 = r27 ^ r21[r22][3];
        r7 = r24;
        r9 = r25;
        r10 = r26;
        r8 = 1;
        r11 = r28;
        r6 = 0;
        goto L4
    L6:
        int[] r29 = T0;
        int r30 = (((r29[r7 & 255] ^ shift(r29[(r9 >> 8) & 255], 24)) ^ shift(r29[(r10 >> 16) & 255], 16)) ^ shift(r29[(r2 >> 24) & 255], 8)) ^ r21[r11][0];
        int r110 = (((r29[r9 & 255] ^ shift(r29[(r10 >> 8) & 255], 24)) ^ shift(r29[(r2 >> 16) & 255], 16)) ^ shift(r29[(r7 >> 24) & 255], 8)) ^ r21[r11][1];
        int r111 = (((r29[r10 & 255] ^ shift(r29[(r2 >> 8) & 255], 24)) ^ shift(r29[(r7 >> 16) & 255], 16)) ^ shift(r29[(r9 >> 24) & 255], 8)) ^ r21[r11][2];
        int r31 = ((r29[r2 & 255] ^ shift(r29[(r7 >> 8) & 255], 24)) ^ shift(r29[(r9 >> 16) & 255], 16)) ^ shift(r29[(r10 >> 24) & 255], 8);
        int r32 = r11 + 1;
        int r33 = r31 ^ r21[r11][3];
        byte[] r34 = S;
        int r35 = (r34[r30 & 255] & 255) ^ ((r34[(r110 >> 8) & 255] & 255) << 8);
        byte[] r0 = this.s;
        int r36 = ((r35 ^ ((r0[(r111 >> 16) & 255] & 255) << 16)) ^ (r0[(r33 >> 24) & 255] << 24)) ^ r21[r32][0];
        int r37 = ((((r0[r110 & 255] & 255) ^ ((r34[(r111 >> 8) & 255] & 255) << 8)) ^ ((r34[(r33 >> 16) & 255] & 255) << 16)) ^ (r0[(r30 >> 24) & 255] << 24)) ^ r21[r32][1];
        int r38 = ((((r0[r111 & 255] & 255) ^ ((r34[(r33 >> 8) & 255] & 255) << 8)) ^ ((r34[(r30 >> 16) & 255] & 255) << 16)) ^ (r34[(r110 >> 24) & 255] << 24)) ^ r21[r32][2];
        int r39 = ((((r0[(r110 >> 16) & 255] & 255) << 16) ^ ((r0[r33 & 255] & 255) ^ ((r0[(r30 >> 8) & 255] & 255) << 8))) ^ (r34[(r111 >> 24) & 255] << 24)) ^ r21[r32][3];
        Pack.intToLittleEndian(r36, r19, r20 + 0);
        Pack.intToLittleEndian(r37, r19, r20 + 4);
        Pack.intToLittleEndian(r38, r19, r20 + 8);
        Pack.intToLittleEndian(r39, r19, r20 + 12);
    }

    private int[][] generateWorkingKey(byte[] r20, boolean r21) {
        int r2 = r20.length;
        if (r2 < 16) goto L38;
        if (r2 > 32) goto L38;
        if ((r2 & 7) != 0) goto L38;
        int r3 = r2 >>> 2;
        int r5 = r3 + 6;
        this.ROUNDS = r5;
        int r6 = 1;
        int[][] r7 = (int[][]) Array.newInstance(int.class, new int[]{r5 + 1, 4});
        int r10 = 8;
        char r11 = 3;
        if (r3 != 4) goto L11;
        int r4 = Pack.littleEndianToInt(r20, 0);
        r7[0][0] = r4;
        int r8 = Pack.littleEndianToInt(r20, 4);
        r7[0][1] = r8;
        int r12 = Pack.littleEndianToInt(r20, 8);
        r7[0][2] = r12;
        int r1 = Pack.littleEndianToInt(r20, 12);
        r7[0][3] = r1;
        int r9 = 1;
    L27:
        if (r9 > 10) goto L29;
        r4 = r4 ^ (subWord(shift(r1, 8)) ^ rcon[r9 - 1]);
        r7[r9][0] = r4;
        r8 = r8 ^ r4;
        r7[r9][1] = r8;
        r12 = r12 ^ r8;
        r7[r9][2] = r12;
        r1 = r1 ^ r12;
        r7[r9][3] = r1;
        r9 = r9 + 1;
    L29:
        if (r21 == false) goto L31;
    L36:
        return r7;
    L31:
        if (r6 >= this.ROUNDS) goto L36;
        int r13 = 0;
    L33:
        if (r13 >= 4) goto L35;
        r7[r6][r13] = inv_mcol(r7[r6][r13]);
        r13 = r13 + 1;
        goto L33
    L35:
        r6 = r6 + 1;
        goto L31
    L11:
        if (r3 == 6) goto L20;
        if (r3 != 8) goto L19;
        int r14 = Pack.littleEndianToInt(r20, 0);
        r7[0][0] = r14;
        int r15 = Pack.littleEndianToInt(r20, 4);
        r7[0][1] = r15;
        int r16 = Pack.littleEndianToInt(r20, 8);
        r7[0][2] = r16;
        int r17 = Pack.littleEndianToInt(r20, 12);
        r7[0][3] = r17;
        int r18 = Pack.littleEndianToInt(r20, 16);
        r7[1][0] = r18;
        int r19 = Pack.littleEndianToInt(r20, 20);
        r7[1][1] = r19;
        int r110 = Pack.littleEndianToInt(r20, 24);
        r7[1][2] = r110;
        int r22 = Pack.littleEndianToInt(r20, 28);
        r7[1][3] = r22;
        int r111 = 2;
        int r23 = 1;
    L14:
        int r112 = subWord(shift(r22, r10)) ^ r23;
        r23 = r23 << 1;
        r14 = r14 ^ r112;
        r7[r111][0] = r14;
        r15 = r15 ^ r14;
        r7[r111][1] = r15;
        r16 = r16 ^ r15;
        r7[r111][2] = r16;
        r17 = r17 ^ r16;
        r7[r111][r11] = r17;
        int r113 = r111 + 1;
        if (r113 >= 15) goto L29;
        r18 = r18 ^ subWord(r17);
        r7[r113][0] = r18;
        r19 = r19 ^ r18;
        r7[r113][1] = r19;
        r110 = r110 ^ r19;
        r7[r113][2] = r110;
        r22 = r22 ^ r110;
        r7[r113][3] = r22;
        r111 = r113 + 1;
        r10 = 8;
        r11 = 3;
        goto L14
    L19:
        throw new IllegalStateException("Should never get here");
    L20:
        int r24 = Pack.littleEndianToInt(r20, 0);
        r7[0][0] = r24;
        int r114 = Pack.littleEndianToInt(r20, 4);
        r7[0][1] = r114;
        int r115 = Pack.littleEndianToInt(r20, 8);
        r7[0][2] = r115;
        int r25 = Pack.littleEndianToInt(r20, 12);
        r7[0][3] = r25;
        int r26 = Pack.littleEndianToInt(r20, 16);
        int r27 = Pack.littleEndianToInt(r20, 20);
        int r28 = 1;
        int r116 = 1;
    L21:
        r7[r28][0] = r26;
        r7[r28][1] = r27;
        int r117 = subWord(shift(r27, 8)) ^ r116;
        int r118 = r116 << 1;
        int r29 = r24 ^ r117;
        r7[r28][2] = r29;
        int r119 = r114 ^ r29;
        r7[r28][3] = r119;
        int r120 = r115 ^ r119;
        int r121 = r28 + 1;
        r7[r121][0] = r120;
        int r30 = r25 ^ r120;
        r7[r121][1] = r30;
        int r31 = r26 ^ r30;
        r7[r121][2] = r31;
        int r32 = r27 ^ r31;
        r7[r121][3] = r32;
        int r122 = subWord(shift(r32, 8)) ^ r118;
        r116 = r118 << 1;
        r24 = r29 ^ r122;
        int r123 = r28 + 2;
        r7[r123][0] = r24;
        r114 = r119 ^ r24;
        r7[r123][1] = r114;
        r115 = r120 ^ r114;
        r7[r123][2] = r115;
        r25 = r30 ^ r115;
        r7[r123][3] = r25;
        r28 = r28 + 3;
        if (r28 >= 13) goto L29;
        r26 = r31 ^ r25;
        r27 = r32 ^ r26;
    L38:
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    private static int inv_mcol(int r2) {
        int r0 = shift(r2, 8) ^ r2;
        int r3 = r2 ^ FFmulX(r0);
        int r1 = r0 ^ FFmulX2(r3);
        return r3 ^ (r1 ^ shift(r1, 16));
    }

    private static int shift(int r1, int r2) {
        int r0 = r1 >>> r2;
        return (r1 << (-r2)) | r0;
    }

    private static int subWord(int r3) {
        byte[] r0 = S;
        int r1 = ((r0[r3 & 255] & 255) | ((r0[(r3 >> 8) & 255] & 255) << 8)) | ((r0[(r3 >> 16) & 255] & 255) << 16);
        return (r0[(r3 >> 24) & 255] << 24) | r1;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return CryptoConst.ALGORITHM_AES;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r3, CipherParameters r4) {
        CipherParameters r5 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r4, CipherParameters.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, KeyParameter.class) == false) goto L11;
        this.WorkingKey = generateWorkingKey(((KeyParameter) ZeusTransformUtils.preCheckCast(r5, KeyParameter.class, "com.obric.memorydata.plugin")).getKey(), r3);
        this.forEncryption = r3;
        if (r3 == false) goto L7;
        this.s = Arrays.clone(S);
    L8:
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bitsOfSecurity(), r5, Utils.getPurpose(r3)));
        return;
    L7:
        this.s = Arrays.clone(Si);
        goto L8
    L11:
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + r5.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r8, int r9, byte[] r10, int r11) {
        int[][] r5 = this.WorkingKey;
        if (r5 == null) goto L18;
        if (r9 > (r8.length - 16)) goto L16;
        if (r11 > (r10.length - 16)) goto L14;
        if (this.forEncryption == false) goto L11;
        encryptBlock(r8, r9, r10, r11, r5);
    L12:
        return 16;
    L11:
        decryptBlock(r8, r9, r10, r11, r5);
        goto L12
    L14:
        throw new OutputLengthException("output buffer too short");
    L16:
        throw new DataLengthException("input buffer too short");
    L18:
        throw new IllegalStateException("AES engine not initialised");
    }
}
