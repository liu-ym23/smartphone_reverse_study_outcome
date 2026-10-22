package okio.internal;

import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.ByteString;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-ByteString")
@SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utf8.kt\nokio/Utf8\n*L\n1#1,363:1\n131#1,2:369\n133#1,9:372\n68#2:364\n74#2:365\n74#2:367\n74#2:368\n68#2:396\n74#2:408\n1#3:366\n1#3:371\n212#4,7:381\n122#4:388\n219#4,5:389\n122#4:394\n226#4:395\n228#4:397\n397#4,2:398\n122#4:400\n400#4,6:401\n127#4:407\n406#4:409\n122#4:410\n407#4,13:411\n122#4:424\n422#4:425\n122#4:426\n425#4:427\n230#4,3:428\n440#4,3:431\n122#4:434\n443#4:435\n127#4:436\n446#4,10:437\n127#4:447\n456#4:448\n122#4:449\n457#4,4:450\n127#4:454\n461#4:455\n122#4:456\n462#4,14:457\n122#4:471\n477#4,2:472\n122#4:474\n481#4:475\n122#4:476\n484#4:477\n234#4,3:478\n500#4,3:481\n122#4:484\n503#4:485\n127#4:486\n506#4,2:487\n127#4:489\n510#4,10:490\n127#4:500\n520#4:501\n122#4:502\n521#4,4:503\n127#4:507\n525#4:508\n122#4:509\n526#4,4:510\n127#4:514\n530#4:515\n122#4:516\n531#4,15:517\n122#4:532\n547#4,2:533\n122#4:535\n550#4,2:536\n122#4:538\n554#4:539\n122#4:540\n557#4:541\n241#4:542\n122#4:543\n242#4,5:544\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n*L\n329#1:369,2\n329#1:372,9\n67#1:364\n68#1:365\n258#1:367\n259#1:368\n348#1:396\n348#1:408\n329#1:371\n348#1:381,7\n353#1:388\n348#1:389,5\n353#1:394\n348#1:395\n348#1:397\n348#1:398,2\n353#1:400\n348#1:401,6\n348#1:407\n348#1:409\n353#1:410\n348#1:411,13\n353#1:424\n348#1:425\n353#1:426\n348#1:427\n348#1:428,3\n348#1:431,3\n353#1:434\n348#1:435\n348#1:436\n348#1:437,10\n348#1:447\n348#1:448\n353#1:449\n348#1:450,4\n348#1:454\n348#1:455\n353#1:456\n348#1:457,14\n353#1:471\n348#1:472,2\n353#1:474\n348#1:475\n353#1:476\n348#1:477\n348#1:478,3\n348#1:481,3\n353#1:484\n348#1:485\n348#1:486\n348#1:487,2\n348#1:489\n348#1:490,10\n348#1:500\n348#1:501\n353#1:502\n348#1:503,4\n348#1:507\n348#1:508\n353#1:509\n348#1:510,4\n348#1:514\n348#1:515\n353#1:516\n348#1:517,15\n353#1:532\n348#1:533,2\n353#1:535\n348#1:536,2\n353#1:538\n348#1:539\n353#1:540\n348#1:541\n348#1:542\n353#1:543\n348#1:544,5\n*E\n"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f12238a = null;

    static {
        f12238a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final /* synthetic */ int a(byte[] r10, int r11) {
        return c(r10, r11);
    }

    public static final /* synthetic */ int b(char r10) {
        return e(r10);
    }

    private static final int c(byte[] r19, int r20) {
        int r10 = r19.length;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r11 >= r10) goto L254;
        byte r14 = r19[r11];
        if (r14 >= 0) goto L6;
        if ((r14 >> 5) != (-2)) goto L108;
        int r15 = r11 + 1;
        if (r10 <= r15) goto L64;
        byte r16 = r19[r11];
        byte r17 = r19[r15];
        if ((r17 & MessagePack.Code.NIL) != 128) goto L70;
        boolean r18 = true;
    L71:
        if (r18 == false) goto L72;
        int r21 = (r17 ^ 3968) ^ (r16 << 6);
        if (r21 < 128) goto L77;
        int r22 = r13 + 1;
        if (r13 == r20) goto L82;
        if (r21 == 10) goto L99;
        if (r21 == 13) goto L99;
        if (r21 < 0) goto L88;
        if (r21 >= 32) goto L88;
        boolean r23 = true;
    L89:
        if (r23 == true) goto L97;
        if (127 > r21) goto L93;
        if (r21 >= 160) goto L93;
        boolean r24 = true;
    L94:
        if (r24 == true) goto L97;
        boolean r25 = false;
    L98:
        if (r25 == false) goto L99;
    L100:
        return -1;
    L93:
        r24 = false;
    L97:
        r25 = true;
    L88:
        r23 = false;
    L99:
        if (r21 == 65533) goto L100;
        if (r21 >= 65536) goto L104;
        int r110 = 1;
    L105:
        r12 = r12 + r110;
        Unit r26 = Unit.INSTANCE;
        r11 = r11 + 2;
    L106:
        r13 = r22;
        goto L3
    L104:
        r110 = 2;
        goto L105
    L82:
        return r12;
    L77:
        if (r13 != r20) goto L79;
        return r12;
    L79:
        return -1;
    L72:
        if (r13 != r20) goto L74;
        return r12;
    L74:
        return -1;
    L70:
        r18 = false;
        goto L71
    L64:
        if (r13 != r20) goto L66;
        return r12;
    L66:
        return -1;
    L108:
        if ((r14 >> 4) != (-2)) goto L173;
        int r27 = r11 + 2;
        if (r10 <= r27) goto L111;
        byte r28 = r19[r11];
        byte r111 = r19[r11 + 1];
        if ((r111 & MessagePack.Code.NIL) != 128) goto L117;
        boolean r29 = true;
    L118:
        if (r29 == false) goto L119;
        byte r30 = r19[r27];
        if ((r30 & MessagePack.Code.NIL) != 128) goto L125;
        boolean r31 = true;
    L126:
        if (r31 == false) goto L127;
        int r32 = ((r30 ^ (-123008)) ^ (r111 << 6)) ^ (r28 << 12);
        if (r32 < 2048) goto L132;
        if (55296 > r32) goto L138;
        if (r32 >= 57344) goto L138;
        boolean r33 = true;
    L139:
        if (r33 == true) goto L140;
        r22 = r13 + 1;
        if (r13 == r20) goto L145;
        if (r32 == 10) goto L165;
        if (r32 == 13) goto L165;
        if (r32 < 0) goto L151;
        if (r32 >= 32) goto L151;
        boolean r34 = true;
    L152:
        if (r34 == false) goto L154;
    L162:
        boolean r35 = true;
    L163:
        if (r35 == false) goto L165;
    L166:
        return -1;
    L154:
        if (127 <= r32) goto L156;
    L158:
        boolean r36 = false;
    L159:
        if (r36 == true) goto L162;
        r35 = false;
        goto L163
    L156:
        if (r32 >= 160) goto L158;
        r36 = true;
    L151:
        r34 = false;
    L165:
        if (r32 == 65533) goto L166;
        if (r32 >= 65536) goto L170;
        int r112 = 1;
    L171:
        r12 = r12 + r112;
        Unit r37 = Unit.INSTANCE;
        r11 = r11 + 3;
        goto L106
    L170:
        r112 = 2;
        goto L171
    L145:
        return r12;
    L140:
        if (r13 != r20) goto L142;
        return r12;
    L142:
        return -1;
    L138:
        r33 = false;
        goto L139
    L132:
        if (r13 != r20) goto L134;
        return r12;
    L134:
        return -1;
    L127:
        if (r13 != r20) goto L129;
        return r12;
    L129:
        return -1;
    L125:
        r31 = false;
        goto L126
    L119:
        if (r13 != r20) goto L121;
        return r12;
    L121:
        return -1;
    L117:
        r29 = false;
        goto L118
    L111:
        if (r13 != r20) goto L113;
        return r12;
    L113:
        return -1;
    L173:
        if ((r14 >> 3) != (-2)) goto L251;
        int r38 = r11 + 3;
        if (r10 <= r38) goto L176;
        byte r39 = r19[r11];
        byte r40 = r19[r11 + 1];
        if ((r40 & MessagePack.Code.NIL) != 128) goto L182;
        boolean r113 = true;
    L183:
        if (r113 == false) goto L184;
        byte r114 = r19[r11 + 2];
        if ((r114 & MessagePack.Code.NIL) != 128) goto L190;
        boolean r115 = true;
    L191:
        if (r115 == false) goto L192;
        byte r41 = r19[r38];
        if ((r41 & MessagePack.Code.NIL) != 128) goto L198;
        boolean r116 = true;
    L199:
        if (r116 == false) goto L200;
        int r42 = (((r41 ^ 3678080) ^ (r114 << 6)) ^ (r40 << 12)) ^ (r39 << 18);
        if (r42 > 1114111) goto L205;
        if (55296 > r42) goto L211;
        if (r42 >= 57344) goto L211;
        boolean r43 = true;
    L212:
        if (r43 == true) goto L213;
        if (r42 < 65536) goto L218;
        r22 = r13 + 1;
        if (r13 == r20) goto L223;
        if (r42 == 10) goto L244;
        if (r42 == 13) goto L244;
        if (r42 >= 0) goto L228;
    L230:
        boolean r44 = false;
    L231:
        if (r44 == false) goto L233;
    L241:
        boolean r45 = true;
    L242:
        if (r45 == false) goto L244;
    L245:
        return -1;
    L233:
        if (127 <= r42) goto L235;
    L237:
        boolean r46 = false;
    L238:
        if (r46 == true) goto L241;
        r45 = false;
        goto L242
    L235:
        if (r42 >= 160) goto L237;
        r46 = true;
        goto L238
    L228:
        if (r42 >= 32) goto L230;
        r44 = true;
    L244:
        if (r42 == 65533) goto L245;
        if (r42 >= 65536) goto L249;
        int r117 = 1;
    L250:
        r12 = r12 + r117;
        Unit r47 = Unit.INSTANCE;
        r11 = r11 + 4;
        goto L106
    L249:
        r117 = 2;
        goto L250
    L223:
        return r12;
    L218:
        if (r13 != r20) goto L220;
        return r12;
    L220:
        return -1;
    L213:
        if (r13 != r20) goto L215;
        return r12;
    L215:
        return -1;
    L211:
        r43 = false;
        goto L212
    L205:
        if (r13 != r20) goto L207;
        return r12;
    L207:
        return -1;
    L200:
        if (r13 != r20) goto L202;
        return r12;
    L202:
        return -1;
    L198:
        r116 = false;
        goto L199
    L192:
        if (r13 != r20) goto L194;
        return r12;
    L194:
        return -1;
    L190:
        r115 = false;
        goto L191
    L184:
        if (r13 != r20) goto L186;
        return r12;
    L186:
        return -1;
    L182:
        r113 = false;
        goto L183
    L176:
        if (r13 != r20) goto L178;
        return r12;
    L178:
        return -1;
    L251:
        if (r13 != r20) goto L253;
        return r12;
    L253:
        return -1;
    L6:
        int r118 = r13 + 1;
        if (r13 == r20) goto L8;
        if (r14 == 10) goto L25;
        if (r14 == 13) goto L25;
        if (r14 < 0) goto L14;
        if (r14 >= 32) goto L14;
        boolean r48 = true;
    L15:
        if (r48 == true) goto L23;
        if (127 > r14) goto L19;
        if (r14 >= 160) goto L19;
        boolean r49 = true;
    L20:
        if (r49 == true) goto L23;
        boolean r50 = false;
    L24:
        if (r50 == false) goto L25;
    L26:
        return -1;
    L19:
        r49 = false;
    L23:
        r50 = true;
    L14:
        r48 = false;
    L25:
        if (r14 == 65533) goto L26;
        if (r14 >= 65536) goto L29;
        int r51 = 1;
    L30:
        r12 = r12 + r51;
        r11 = r11 + 1;
    L31:
        r13 = r118;
        if (r11 >= r10) goto L3;
        if (r19[r11] < 0) goto L3;
        int r52 = r11 + 1;
        byte r53 = r19[r11];
        r118 = r13 + 1;
        if (r13 == r20) goto L37;
        if (r53 == 10) goto L54;
        if (r53 == 13) goto L54;
        if (r53 < 0) goto L43;
        if (r53 >= 32) goto L43;
        boolean r54 = true;
    L44:
        if (r54 == true) goto L52;
        if (127 > r53) goto L48;
        if (r53 >= 160) goto L48;
        boolean r55 = true;
    L49:
        if (r55 == true) goto L52;
        boolean r56 = false;
    L53:
        if (r56 == false) goto L54;
    L55:
        return -1;
    L48:
        r55 = false;
    L52:
        r56 = true;
    L43:
        r54 = false;
    L54:
        if (r53 == 65533) goto L55;
        if (r53 >= 65536) goto L58;
        int r57 = 1;
    L59:
        r12 = r12 + r57;
        r11 = r52;
        goto L31
    L58:
        r57 = 2;
        goto L59
    L37:
        return r12;
    L29:
        r51 = 2;
        goto L30
    L8:
        return r12;
    L254:
        return r12;
    }

    public static final void d(ByteString r10, okio.d r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "buffer");
        r11.a0(r10.getData$okio(), r12, r13);
    }

    private static final int e(char r10) {
        boolean r11 = true;
        if ('0' <= r10) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L26;
        char r13 = 'a';
        if ('a' <= r10) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == true) goto L29;
        r13 = 'A';
        if ('A' <= r10) goto L21;
    L23:
        r11 = false;
    L24:
        if (r11 == true) goto L29;
        throw new IllegalArgumentException("Unexpected hex digit: " + r10);
    L21:
        if (r10 >= 'G') goto L23;
    L29:
        return (r10 - r13) + 10;
    L13:
        if (r10 >= 'g') goto L15;
        r14 = true;
        goto L16
    L26:
        return r10 - '0';
    L5:
        if (r10 >= ':') goto L7;
        r12 = true;
        goto L8
    }

    public static final char[] f() {
        return f12238a;
    }
}
