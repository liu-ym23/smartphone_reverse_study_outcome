package org.apache.poi.hwpf.util;

import com.ttnet.org.chromium.net.NetError;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;

/* JADX INFO: loaded from: classes7.dex */
public class LittleEndianCP950Reader extends Reader {
    private static final c LOGGER = null;
    private final CharBuffer charBuffer;
    private final byte[] data;
    private final CharsetDecoder decoder;
    private final ByteBuffer doubleByteBuffer;
    private int leading;
    private final int length;
    private int offset;
    private final int startOffset;
    private int trailing;

    static {
        LOGGER = b.a(LittleEndianCP950Reader.class);
    }

    public LittleEndianCP950Reader(byte[] r3, int r4, int r5) {
        this.doubleByteBuffer = ByteBuffer.allocate(2);
        this.charBuffer = CharBuffer.allocate(2);
        this.decoder = DoubleByteUtil.BIG5.newDecoder();
        this.data = r3;
        this.startOffset = r4;
        this.offset = r4;
        this.length = r5;
    }

    private int handleF9(final int r2) {
        switch(r2) {
            case 64: goto L318;
            case 65: goto L316;
            case 66: goto L314;
            case 67: goto L312;
            case 68: goto L310;
            case 69: goto L308;
            case 70: goto L306;
            case 71: goto L304;
            case 72: goto L302;
            case 73: goto L300;
            case 74: goto L298;
            case 75: goto L296;
            case 76: goto L294;
            case 77: goto L292;
            case 78: goto L290;
            case 79: goto L288;
            case 80: goto L286;
            case 81: goto L284;
            case 82: goto L282;
            case 83: goto L280;
            case 84: goto L278;
            case 85: goto L276;
            case 86: goto L274;
            case 87: goto L272;
            case 88: goto L270;
            case 89: goto L268;
            case 90: goto L266;
            case 91: goto L264;
            case 92: goto L262;
            case 93: goto L260;
            case 94: goto L258;
            case 95: goto L256;
            case 96: goto L254;
            case 97: goto L252;
            case 98: goto L250;
            case 99: goto L248;
            case 100: goto L246;
            case 101: goto L244;
            case 102: goto L242;
            case 103: goto L240;
            case 104: goto L238;
            case 105: goto L236;
            case 106: goto L234;
            case 107: goto L232;
            case 108: goto L230;
            case 109: goto L228;
            case 110: goto L226;
            case 111: goto L224;
            case 112: goto L222;
            case 113: goto L220;
            case 114: goto L218;
            case 115: goto L216;
            case 116: goto L214;
            case 117: goto L212;
            case 118: goto L210;
            case 119: goto L208;
            case 120: goto L206;
            case 121: goto L204;
            case 122: goto L202;
            case 123: goto L200;
            case 124: goto L198;
            case 125: goto L196;
            case 126: goto L194;
            default: goto L3;
        };
    L3:
        switch(r2) {
            case 161: goto L192;
            case 162: goto L190;
            case 163: goto L188;
            case 164: goto L186;
            case 165: goto L184;
            case 166: goto L182;
            case 167: goto L180;
            case 168: goto L178;
            case 169: goto L176;
            case 170: goto L174;
            case 171: goto L172;
            case 172: goto L170;
            case 173: goto L168;
            case 174: goto L166;
            case 175: goto L164;
            case 176: goto L162;
            case 177: goto L160;
            case 178: goto L158;
            case 179: goto L156;
            case 180: goto L154;
            case 181: goto L152;
            case 182: goto L150;
            case 183: goto L148;
            case 184: goto L146;
            case 185: goto L144;
            case 186: goto L142;
            case 187: goto L140;
            case 188: goto L138;
            case 189: goto L136;
            case 190: goto L134;
            case 191: goto L132;
            case 192: goto L130;
            case 193: goto L128;
            case 194: goto L126;
            case 195: goto L124;
            case 196: goto L122;
            case 197: goto L120;
            case 198: goto L118;
            case 199: goto L116;
            case 200: goto L114;
            case 201: goto L112;
            case 202: goto L110;
            case 203: goto L108;
            case 204: goto L106;
            case 205: goto L104;
            case 206: goto L102;
            case 207: goto L100;
            case 208: goto L98;
            case 209: goto L96;
            case 210: goto L94;
            case 211: goto L92;
            case 212: goto L90;
            case 213: goto L88;
            case 214: goto L86;
            case 215: goto L84;
            case 216: goto L82;
            case 217: goto L80;
            case 218: goto L78;
            case 219: goto L76;
            case 220: goto L74;
            case 221: goto L72;
            case 222: goto L70;
            case 223: goto L68;
            case 224: goto L66;
            case 225: goto L64;
            case 226: goto L62;
            case 227: goto L60;
            case 228: goto L58;
            case 229: goto L56;
            case 230: goto L54;
            case 231: goto L52;
            case 232: goto L50;
            case 233: goto L48;
            case 234: goto L46;
            case 235: goto L44;
            case 236: goto L42;
            case 237: goto L40;
            case 238: goto L38;
            case 239: goto L36;
            case 240: goto L34;
            case 241: goto L32;
            case 242: goto L30;
            case 243: goto L28;
            case 244: goto L26;
            case 245: goto L24;
            case 246: goto L22;
            case 247: goto L20;
            case 248: goto L18;
            case 249: goto L16;
            case 250: goto L14;
            case 251: goto L12;
            case 252: goto L10;
            case 253: goto L8;
            case 254: goto L6;
            default: goto L4;
        };
    L4:
        LOGGER.atWarn().a(new $$Lambda$LittleEndianCP950Reader$WEUtqMUuY1ZArz7UMPjPcmLPbgQ(r2));
        return 63;
    L6:
        return 9619;
    L8:
        return 9583;
    L10:
        return 9584;
    L12:
        return 9582;
    L14:
        return 9581;
    L16:
        return 9552;
    L18:
        return 9553;
    L20:
        return 9564;
    L22:
        return 9576;
    L24:
        return 9561;
    L26:
        return 9570;
    L28:
        return 9579;
    L30:
        return 9567;
    L32:
        return 9558;
    L34:
        return 9573;
    L36:
        return 9555;
    L38:
        return 9563;
    L40:
        return 9575;
    L42:
        return 9560;
    L44:
        return 9569;
    L46:
        return 9578;
    L48:
        return 9566;
    L50:
        return 9557;
    L52:
        return 9572;
    L54:
        return 9554;
    L56:
        return 9565;
    L58:
        return 9577;
    L60:
        return 9562;
    L62:
        return 9571;
    L64:
        return 9580;
    L66:
        return 9568;
    L68:
        return 9559;
    L70:
        return 9574;
    L72:
        return 9556;
    L74:
        return 23290;
    L76:
        return 31911;
    L78:
        return 24658;
    L80:
        return 22715;
    L82:
        return 35023;
    L84:
        return 37561;
    L86:
        return 30849;
    L88:
        return 40856;
    L90:
        return 40777;
    L92:
        return 40830;
    L94:
        return 40612;
    L96:
        return 28778;
    L98:
        return 28777;
    L100:
        return 40477;
    L102:
        return 40058;
    L104:
        return 39531;
    L106:
        return 30325;
    L108:
        return 40631;
    L110:
        return 40057;
    L112:
        return 38019;
    L114:
        return 35743;
    L116:
        return 34379;
    L118:
        return 29225;
    L120:
        return 40473;
    L122:
        return 39726;
    L124:
        return 39528;
    L126:
        return 39529;
    L128:
        return 38017;
    L130:
        return 38016;
    L132:
        return 38018;
    L134:
        return 36520;
    L136:
        return 34380;
    L138:
        return 29223;
    L140:
        return 27422;
    L142:
        return 25095;
    L144:
        return 40776;
    L146:
        return 40471;
    L148:
        return 40469;
    L150:
        return 39716;
    L152:
        return 39527;
    L154:
        return 39526;
    L156:
        return 39524;
    L158:
        return 39339;
    L160:
        return 39265;
    L162:
        return 39116;
    L164:
        return 39028;
    L166:
        return 39027;
    L168:
        return 38731;
    L170:
        return 36553;
    L172:
        return 36521;
    L174:
        return 35996;
    L176:
        return 35742;
    L178:
        return 34879;
    L180:
        return 34877;
    L182:
        return 34878;
    L184:
        return 34410;
    L186:
        return 31991;
    L188:
        return 28773;
    L190:
        return 28776;
    L192:
        return 40868;
    L194:
        return 40714;
    L196:
        return 40694;
    L198:
        return 40467;
    L200:
        return 40468;
    L202:
        return 40053;
    L204:
        return 40049;
    L206:
        return 40051;
    L208:
        return 40052;
    L210:
        return 39520;
    L212:
        return 38005;
    L214:
        return 38006;
    L216:
        return 38008;
    L218:
        return 38004;
    L220:
        return 37315;
    L222:
        return 36518;
    L224:
        return 36274;
    L226:
        return 34876;
    L228:
        return 31855;
    L230:
        return 28774;
    L232:
        return 22302;
    L234:
        return 40825;
    L236:
        return 40826;
    L238:
        return 40827;
    L240:
        return 40824;
    L242:
        return 40775;
    L244:
        return 40713;
    L246:
        return 40693;
    L248:
        return 40609;
    L250:
        return 40465;
    L252:
        return 40466;
    L254:
        return 40463;
    L256:
        return 40464;
    L258:
        return 40461;
    L260:
        return 40459;
    L262:
        return 40045;
    L264:
        return 40046;
    L266:
        return 40040;
    L268:
        return 39263;
    L270:
        return 39026;
    L272:
        return 38729;
    L274:
        return 38003;
    L276:
        return 38001;
    L278:
        return 37999;
    L280:
        return 37997;
    L282:
        return 37998;
    L284:
        return 36515;
    L286:
        return 36516;
    L288:
        return 36517;
    L290:
        return 35737;
    L292:
        return 35736;
    L294:
        return 35327;
    L296:
        return 35195;
    L298:
        return 35196;
    L300:
        return 35194;
    L302:
        return 35193;
    L304:
        return 34376;
    L306:
        return 34375;
    L308:
        return 34374;
    L310:
        return 33249;
    L312:
        return 33248;
    L314:
        return 32409;
    L316:
        return 32411;
    L318:
        return 32408;
    }

    private int handleRange1(int r1, int r2) {
        int r3 = ((r1 - 129) * 157) + 61112;
        if (r2 >= 128) goto L5;
        int r4 = r2 - 64;
    L7:
        return r3 + r4;
    L5:
        r4 = r2 - 98;
        goto L7
    }

    private int handleRange2(int r1, int r2) {
        int r3 = ((r1 + NetError.ERR_MSG_TOO_BIG) * 157) + 58129;
        if (r2 >= 128) goto L5;
        int r4 = r2 - 64;
    L7:
        return r3 + r4;
    L5:
        r4 = r2 - 98;
        goto L7
    }

    private int handleRange3(int r1, int r2) {
        int r3 = ((r1 + NetError.ERR_TTNET_CONNECTION_TIMED_OUT) * 157) + 63090;
        if (r2 >= 128) goto L5;
        int r4 = r2 - 64;
    L7:
        return r3 + r4;
    L5:
        r4 = r2 - 98;
        goto L7
    }

    private int handleRange4(int r1, int r2) {
        int r3 = ((r1 - 250) * 157) + 57344;
        if (r2 >= 128) goto L5;
        int r4 = r2 - 64;
    L7:
        return r3 + r4;
    L5:
        r4 = r2 - 98;
        goto L7
    }

    static /* synthetic */ Message lambda$handleF9$1(int r3) {
        return new SimpleMessage("couldn't create char for: f9 " + Integer.toString(r3 & 255, 16));
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public /* synthetic */ Message lambda$read$0$LittleEndianCP950Reader() {
        return new SimpleMessage("couldn't create char for: " + Integer.toString(this.leading & 255, 16) + " " + Integer.toString(this.trailing & 255, 16));
    }

    @Override // java.io.Reader
    public int read() {
        int r0 = this.offset;
        int r1 = r0 + 1;
        byte[] r2 = this.data;
        if (r1 <= r2.length) goto L5;
        return -1;
    L5:
        if ((r0 - this.startOffset) > this.length) goto L47;
        int r3 = r0 + 1;
        this.offset = r3;
        this.trailing = r2[r0] & 255;
        this.offset = r3 + 1;
        this.leading = r2[r3] & 255;
        this.decoder.reset();
        int r4 = this.leading;
        if (r4 >= 129) goto L12;
        return this.trailing;
    L12:
        if (r4 == 249) goto L14;
        int r5 = this.trailing;
        int r6 = (r4 << 8) + r5;
        if (r6 < 33088) goto L22;
        if (r6 > 36350) goto L22;
        return handleRange1(r4, r5);
    L22:
        if (r6 < 36416) goto L28;
        if (r6 > 41214) goto L28;
        return handleRange2(r4, r5);
    L28:
        if (r6 < 50849) goto L34;
        if (r6 > 51454) goto L34;
        return handleRange3(r4, r5);
    L34:
        if (r6 >= 64064) goto L36;
    L39:
        this.charBuffer.clear();
        this.doubleByteBuffer.clear();
        this.doubleByteBuffer.put((byte) this.leading);
        this.doubleByteBuffer.put((byte) this.trailing);
        this.doubleByteBuffer.flip();
        this.decoder.decode(this.doubleByteBuffer, this.charBuffer, true);
        this.charBuffer.flip();
        if (this.charBuffer.length() != 0) goto L44;
        LOGGER.atWarn().a(new $$Lambda$LittleEndianCP950Reader$cP_xHi9TKdFK432B5A_oO86x1c(this));
        return 63;
    L44:
        return Character.codePointAt(this.charBuffer, 0);
    L36:
        if (r6 > 65278) goto L39;
        return handleRange4(r4, r5);
    L14:
        return handleF9(this.trailing);
    L47:
        return -1;
    }

    @Override // java.io.Reader
    public int read(char[] r4, int r5, int r6) {
        int r0 = r5;
    L4:
        if (r0 >= (r5 + r6)) goto L10;
        int r1 = read();
        if (r1 == (-1)) goto L8;
        r4[r0] = (char) r1;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 - r5;
    L10:
        return r6;
    }
}
